package JavaClass.Entity;

import Constant.SystemConstant;
import JavaClass.Animation.Animation;
import JavaClass.Sprites.Assets;
import Utils.Vector2;
import javafx.scene.canvas.GraphicsContext;

public class MushRoom extends Entity{
    public MushRoom(){
        Init();
    }
    private void Init(){
        InitProperties();
        InitAnimation();
        InitMovement();
    }
    private void InitProperties(){
        isLeft =true;
        isRight=false;
        localPosition = new Vector2(650,400);
        globalPosition = new Vector2(650,400);
        nextPosition = new Vector2();
        updatedPosition = new Vector2();
        velocity = new Vector2();
        Dimension = new Vector2(95,90);
        CollideBox = new Vector2(60,80);
    }
    private void InitAnimation(){
        animation=new Animation();
        animation.setDuration(.05f);
        animation.setFrames(Assets.Instance.mushroomImage[0]);
        for(int i=0;i<3;i++){
            AnimationSprites.add(Assets.Instance.mushroomImage[i]);
        }
    }
    private void InitMovement(){
        velocity.x = 1.2f;
        velocity.y = 0f;
        maxVec = 3.0f;
    }
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
        if(isRight) {
            faceRight = false;
        }
        if(isLeft) {
            faceRight = true;
        }
    }
    private void UpdateXY() {
        UpdateLeftRightBoolean();
        UpdateDx();
        UpdateDy();
    }
    private void UpdateLeftRightBoolean(){
        if (updatedPosition.x>700 && isRight) {
            isLeft = true;
            isRight = false;
        } else if (updatedPosition.x<500&&isLeft) {
            isRight = true;
            isLeft = false;
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
        if(!isGrounded){
            velocity.y += SystemConstant.GRAVITY * SystemConstant.FPS ;
            dy = velocity.y * SystemConstant.FPS;
        }
        if((bottomLeft||bottomRight||collideBottom) && !isGrounded){
            isGrounded = true;
            dy=0;
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
        }
        if(isLeft || isRight){
            if(!isCheckMoveAnimation){
                isCheckMoveAnimation =true;
                animation.setDuration(.05f);
                animation.setFrames(Assets.Instance.mushroomImage[0]);
            }
        }
        else{
            isCheckMoveAnimation = false;
            animation.setDuration(.05f);
            animation.setFrames(Assets.Instance.mushroomImage[1]);
        }
    }
}
