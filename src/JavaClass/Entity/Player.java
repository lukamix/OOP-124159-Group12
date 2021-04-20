package JavaClass.Entity;

import Constant.SystemConstant;
import JavaClass.Animation.Animation;
import JavaClass.Sprites.Assets;
import Utils.Vector2;
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
        localPosition = new Vector2(1000,1000);
        globalPosition = new Vector2(500,500);
        nextPosition = new Vector2();
        updatedPosition = new Vector2();
        veclocity = new Vector2();
        Dimension = new Vector2(95,90);
        CollideBox = new Vector2(95,90);
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
        veclocity.x = .8f;
        veclocity.y = 0f;
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
        UpdateXY();
        checkTileMapCollision();
        setPosition(nextPosition);
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
            dx -= veclocity.x;
            if (dx < -maxVec) {
                dx = -maxVec;
            }
        } else if (isRight) {
            dx += veclocity.x;
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
            dy = 0;
            veclocity.y = -400;
            spaceButtonPressed = false;
        }
        if(!isGrounded){
            veclocity.y += SystemConstant.GRAVITY * SystemConstant.FPS ;
            dy = veclocity.y * SystemConstant.FPS;
        }
        if(isGrounded){
            isJump = false;
            canJump = true;
        }
    }
    private void UpdateAnimation(){
        if(isJump){
            if(!isCheckAnimation){
                isCheckAnimation =true;
                animation.setDuration(.05f);
                animation.setFrames(Assets.Instance.playerImage[2]);
            }
        }
        else if(isLeft || isRight){
            if(!isCheckAnimation){
                isCheckAnimation =true;
                animation.setDuration(.05f);
                animation.setFrames(Assets.Instance.playerImage[1]);
            }
        }
        else{
            isCheckAnimation = false;
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
}
