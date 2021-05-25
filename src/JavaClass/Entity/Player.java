package JavaClass.Entity;

import Constant.SystemConstant;
import JavaClass.Animation.Animation;
import Utils.Vector2;
import JavaClass.Sprites.Assets;
import javafx.scene.canvas.GraphicsContext;

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
        localPosition = new Vector2(600,400);
        globalPosition = new Vector2(0,0);
        localPosition = new Vector2(300,400);
        globalPosition = new Vector2(300,400);
        nextPosition = new Vector2();
        updatedPosition = new Vector2();
        velocity = new Vector2();
        Dimension = new Vector2(95,90);
        CollideBox = new Vector2(60,80);
        CollideBox = new Vector2(50,60);
    }
    private void InitAnimation(){
        animation=new Animation();
        animation.setDuration(.05f);
        animation.setFrames(Assets.Instance.playerImage[0]);
        for(int i=0;i<5;i++){
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
        if(isDead){
            leftButtonPressed = false;
            bothRightLeftPressed = false;
            rightButtonPressed = false;
            isRight = false;
            isLeft = false;
        }
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
        if(isDead){
            spaceButtonPressed = false;
            canJump = false;
        }
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
        } else {
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
        if(!isDead){
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
            } else{
                isCheckMoveAnimation = false;
                animation.setDuration(0.05f);
                animation.setFrames(Assets.Instance.playerImage[0]);
            }
        }
        else {
            isCheckJumpAnimation = false;
            isCheckMoveAnimation = false;
            animation.setDuration(.05f);
            animation.setFrames(Assets.Instance.playerImage[4]);
        }
    }
    //region Getter && Setter Key Pressed
    public void setLeftButtonPressed(boolean leftButtonPressed) {
        this.leftButtonPressed = leftButtonPressed;
    }
    public void setRightButtonPressed(boolean rightButtonPressed) {
        this.rightButtonPressed = rightButtonPressed;
    }
    public void setSpaceButtonPressed(boolean spaceButtonPressed) {
        this.spaceButtonPressed = spaceButtonPressed;
    }
    public void setEnterButtonPressed(boolean enterButtonPressed) {
        this.enterButtonPressed = enterButtonPressed;
    }
    //endregion
}
