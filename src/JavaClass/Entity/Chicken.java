package JavaClass.Entity;

import JavaClass.Animation.Animation;
import Utils.Vector2;
import javafx.scene.canvas.GraphicsContext;
import JavaClass.Sprites.Assets;

public class Chicken extends Entity {
    public Chicken(Player player,Bullet b) {
        bullet = b;
        this.player = player;
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
        localPosition = new Vector2(1380, 630);
        globalPosition = new Vector2(1380, 630);
        nextPosition = new Vector2();
        updatedPosition = new Vector2();
        velocity = new Vector2();
        Dimension = new Vector2(95, 90);
        CollideBox = new Vector2(50, 60);
    }

    private void InitAnimation() {
        animation = new Animation();
        animation.setDuration(.05f);
        animation.setFrames(Assets.Instance.chickenImage[0]);
        for (int i = 0; i < 4; i++) {
            AnimationSprites.add(Assets.Instance.chickenImage[i]);
        }
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
        if(!isDead&&!player.isDead) {
            checkPlayerCollision(player);
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
    }

    private void UpdateLeftRightBoolean() {
        if(isDead){
            isLeft = false;
            isRight = false;
        }
        if (updatedPosition.x > 1430 && isRight) {
            isLeft = true;
            isRight = false;
        } else if (updatedPosition.x < 1230 && isLeft) {
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
    private void UpdateAnimation() {
        if (isGrounded) {
            if (isCheckJumpAnimation) isCheckMoveAnimation = false;
        }
        if(!isDead){
            if (isLeft || isRight) {
                if (!isCheckMoveAnimation) {
                    isCheckMoveAnimation = true;
                    animation.setDuration(.05f);
                    animation.setFrames(Assets.Instance.chickenImage[0]);
                }
            } else {
                isCheckMoveAnimation = false;
                animation.setDuration(.05f);
                animation.setFrames(Assets.Instance.chickenImage[2]);
            }
        }
        else {
            isCheckJumpAnimation = false;
            isCheckMoveAnimation = false;
            animation.setDuration(0.05f);
            animation.setFrames(Assets.Instance.chickenImage[3]);
        }
    }
}
