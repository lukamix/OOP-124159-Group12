package JavaClass.Entity;

import Constant.SystemConstant;
import JavaClass.Animation.Animation;
import Utils.Vector2;
import javafx.scene.canvas.GraphicsContext;
import JavaClass.Sprites.Assets;

public class Bee extends Entity {
    public Bee(Player p,Bullet b) {
        bullet = b;
        player = p;
        Init();
    }

    private void Init() {
        InitProperties();
        InitAnimation();
        InitMovement();
    }

    private void InitProperties() {
        isLeft = true;
        isRight = false;
        localPosition = new Vector2(6280, 495);
        globalPosition = new Vector2(6280, 495);
        nextPosition = new Vector2();
        updatedPosition = new Vector2();
        velocity = new Vector2();
        Dimension = new Vector2(40, 30);
        CollideBox = new Vector2(40, 30);
    }

    private void InitAnimation() {
        animation = new Animation();
        animation.setDuration(.05f);
        animation.setFrames(Assets.Instance.beeImage);
        AnimationSprites.add(Assets.Instance.beeImage);
    }

    private void InitMovement() {
        velocity.x = 1f;
        velocity.y = 0f;
        maxVec = 2.0f;
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

    private void UpdatePosition() {
        checkTileMapCollision();
        if(collideBottom||collideLeft||collideRight||collideTop||topLeft||topRight||bottomLeft||bottomRight){
            player.setCollideBeeHive(false);
        }
        if(!isDead&&!player.isDead) {
            checkPlayerCollision();
        }
        if(!isDead){
            if(player.getAttack()&&Math.abs(bullet.nextPosition.y- localPosition.y)<CollideBox.y/2&&
                    Math.abs(bullet.nextPosition.x- localPosition.x)< CollideBox.x/2){
                isDead = true;
            }
        }
        UpdateXY();
        setPosition(updatedPosition);
        if (isRight) {
            faceRight = true;
        }
        if (isLeft) {
            faceRight = false;
        }
    }

    private void UpdateXY() {
        UpdateDx();
        UpdateDy();
    }

    private void UpdateDx() {
        if(!isDead){
            dx+=velocity.x;
            if(dx>20){
                dx=0;
                velocity.x = 0;
                player.setCollideBeeHive(false);
            }
        }
    }
    private void UpdateDy(){
        if(isDead){
            if(!isGrounded){
                velocity.y += SystemConstant.GRAVITY * SystemConstant.FPS ;
                dy = velocity.y * SystemConstant.FPS;
            }
            if((bottomLeft||bottomRight||collideBottom) && !isGrounded){
                if(!jumping){
                    isGrounded = true;
                    dy=0;
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
    }
    private void UpdateAnimation() {
        isCheckJumpAnimation = false;
        isCheckMoveAnimation = false;
        animation.setDuration(0.05f);
        animation.setFrames(Assets.Instance.beeImage);
    }
}
