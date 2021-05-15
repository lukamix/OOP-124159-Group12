package JavaClass.Entity;

import Constant.SystemConstant;
import JavaClass.Animation.Animation;
import JavaClass.Sprites.Assets;
import Utils.Vector2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Player extends Entity{

    //region Key Pressed
    private boolean leftButtonPressed;
    private boolean rightButtonPressed;
    private boolean enterButtonPressed;
    private boolean spaceButtonPressed;
    private boolean bothRightLeftPressed=false;
    //endregion

    public Player(){
        Init();
    }
    //region Init
    private void Init(){
        InitProperties();
        InitAnimation();
        InitMovement();
    }
    private void InitProperties(){
        localPosition = new Vector2(600,500);
        globalPosition = new Vector2(2400,400);
        nextPosition = new Vector2();
        updatedPosition = new Vector2();
        velocity = new Vector2();
        Dimension = new Vector2(95,90);
        CollideBox = new Vector2(60,80);
        debugRec = new Rectangle(CollideBox.x,CollideBox.y);
    }
    private void InitAnimation(){
        animation=new Animation();
        animation.setDuration(.05f);
        animation.setFrames(Assets.Instance.playerImage[0]);
        for(int i=0;i<4;i++){
            AnimationSprites.add(Assets.Instance.playerImage[i]);
        }
    }
    private void InitMovement(){
        velocity.x = 1.2f;
        velocity.y = 0f;
        maxVec = 3.0f;
    }
    //endregion
    @Override
    public void Update(GraphicsContext gc) {
        super.Update(gc);
        UpdatePosition();
        UpdateAnimation();
    }
    @Override
    public void Draw(GraphicsContext gc) {
        super.Draw(gc);
    }
    private void UpdatePosition(){
        checkTileMapCollision();
        UpdateXY();
        setPosition(updatedPosition);
        if(isRight) faceRight=true;
        if(isLeft) faceRight=false;
    }
    private void UpdateXY() {
        UpdateLeftRightBoolean();
        UpdateDx();
        UpdateJumpBoolean();
        UpdateDy();
    }
    private void UpdateLeftRightBoolean(){
        if (leftButtonPressed && rightButtonPressed)
        {
            if (bothRightLeftPressed == false) {
                bothRightLeftPressed = true;
                if (isRight) {
                    isRight = false;
                    isLeft = true;
                } else {
                    isRight = true;
                    isLeft = false;
                }
            }
        } else if (leftButtonPressed) {
            bothRightLeftPressed = false;
            isLeft = true;
            isRight = false;
        } else if (rightButtonPressed) {
            bothRightLeftPressed = false;
            isRight = true;
            isLeft = false;
        } else {
            bothRightLeftPressed = false;
            isLeft = false;
            isRight = false;
        }
    }
    private void UpdateJumpBoolean(){
        if(spaceButtonPressed){
            isJump =true;
        }
    }
    private void UpdateDx(){
        if (isLeft) {
            dx -= velocity.x;
            if (dx < -maxVec) {
                dx = -maxVec;
            }
        } else if (isRight) {
            dx += velocity.x;
            if (dx > maxVec) {
                dx = maxVec;
            }
        } else if (!isLeft && !isRight) {
            dx = 0;
        }
    }
    private void UpdateDy(){
        if(isJump && canJump) {
            canJump = false;
            jumping =true;
            dy = 0;
            velocity.y = -400;
            spaceButtonPressed = false;
            isGrounded =false;
        }
        if(!isGrounded){
            velocity.y += SystemConstant.GRAVITY * SystemConstant.FPS ;
            dy = velocity.y * SystemConstant.FPS;
        }
        if((bottomLeft||bottomRight||collideBottom) && !isGrounded){
            if(!jumping){
                isGrounded = true;
                dy=0;
                isJump = false;
                canJump = true;
            }
        }
        else if(isGrounded && !collideBottom && !bottomLeft && !bottomRight){
            velocity.y = 0;
            isGrounded = false;
        }
        if(velocity.y>0){
            jumping =false;
        }
    }
    private void UpdateAnimation(){
        if(isGrounded){
            if(isCheckJumpAnimation) isCheckMoveAnimation = false;
            isCheckJumpAnimation = false;
        }
        if(isJump){
            if(!isCheckJumpAnimation){
                isCheckJumpAnimation =true;
                animation.setDuration(.05f);
                animation.setFrames(Assets.Instance.playerImage[2]);
            }
        }
        else if(isLeft || isRight){
            if(!isCheckMoveAnimation){
                isCheckMoveAnimation =true;
                animation.setDuration(.05f);
                animation.setFrames(Assets.Instance.playerImage[1]);
            }
        }
        else{
            isCheckJumpAnimation = false;
            isCheckMoveAnimation = false;
            animation.setDuration(.05f);
            animation.setFrames(Assets.Instance.playerImage[0]);
        }
    }
    //region Getter && Setter Key Pressed
    public boolean isLeftButtonPressed() {
        return leftButtonPressed;
    }
    public boolean isRightButtonPressed() {
        return rightButtonPressed;
    }
    public boolean isEnterButtonPressed() {
        return enterButtonPressed;
    }
    public boolean isSpaceButtonPressed() {
        return spaceButtonPressed;
    }
    public boolean isBothRightLeftPressed() {
        return bothRightLeftPressed;
    }
    public void setLeftButtonPressed(boolean leftButtonPressed) {
        this.leftButtonPressed = leftButtonPressed;
    }
    public void setRightButtonPressed(boolean rightButtonPressed) {
        this.rightButtonPressed = rightButtonPressed;
    }
    public void setEnterButtonPressed(boolean enterButtonPressed) {
        this.enterButtonPressed = enterButtonPressed;
    }
    public void setSpaceButtonPressed(boolean spaceButtonPressed) {
        this.spaceButtonPressed = spaceButtonPressed;
    }
    //endregion
    public void CheckPlayerJumpEnemyHead(Entity enemy){

    }
}
