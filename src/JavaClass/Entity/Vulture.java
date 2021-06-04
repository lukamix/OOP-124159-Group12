package JavaClass.Entity;

import Constant.SystemConstant;
import JavaClass.Animation.Animation;
import Utils.Vector2;
import javafx.scene.canvas.GraphicsContext;
import JavaClass.Sprites.Assets;

public class Vulture extends Monster {
    public Vulture(Player p,Bullet b) {
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
        localPosition = new Vector2(3150, 200);
        globalPosition = new Vector2(3150, 200);
        nextPosition = new Vector2();
        updatedPosition = new Vector2();
        velocity = new Vector2();
        Dimension = new Vector2(100, 120);
        CollideBox = new Vector2(80, 90);
    }

    private void InitAnimation() {
        animation = new Animation();
        animation.setDuration(.05f);
        animation.setFrames(Assets.Instance.vultureImage[0]);
        for (int i = 0; i < 2; i++) {
            AnimationSprites.add(Assets.Instance.vultureImage[i]);
        }
    }

    private void InitMovement() {
        velocity.x = 1f;
        velocity.y = 0.1f;
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
            faceRight = false;
        }
        if (isLeft) {
            faceRight = true;
        }
    }

    private void UpdateXY() {
        UpdateLeftRightBoolean();
        UpdateDx();
        UpdateDy();
    }

    private void UpdateLeftRightBoolean() {
        if(isDead){
            isLeft = false;
            isRight = false;
        }
        if (updatedPosition.x > 3250 && isRight) {
            isLeft = true;
            isRight = false;
        } else if (updatedPosition.x < 3050 && isLeft) {
            isRight = true;
            isLeft = false;
        }
    }

    private void UpdateDx() {
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
        if (isLeft) {
            dy -= velocity.y;
            if (dy < -maxVec) {
                dy = -maxVec;
            }
        } else if (isRight) {
            dy += velocity.y;
            if (dy > maxVec) {
                dy = maxVec;
            }
        }
    }
    private void UpdateAnimation() {
        if (isGrounded) {
            if (isCheckJumpAnimation) isCheckMoveAnimation = false;
        }
        if(!isDead){
            if (isLeft || isRight) {
                if (!isCheckMoveAnimation) {
                    isCheckMoveAnimation = true;
                    animation.setDuration(.05f);
                    animation.setFrames(Assets.Instance.vultureImage[0]);
                }
            } else {
                isCheckMoveAnimation = false;
                animation.setDuration(.05f);
                animation.setFrames(Assets.Instance.vultureImage[0]);
            }
        }
        else {
            isCheckJumpAnimation = false;
            isCheckMoveAnimation = false;
            animation.setDuration(0.05f);
            animation.setFrames(Assets.Instance.vultureImage[1]);
        }
    }
}