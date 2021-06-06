package JavaClass.Entity;

import JavaClass.Animation.Animation;
import Utils.Vector2;
import javafx.scene.canvas.GraphicsContext;
import JavaClass.Sprites.Assets;

public class MushRoom2 extends Monster {
    private boolean attacked;
    public MushRoom2(Player p,Bullet b,Vector2 localPosition,Vector2 globalPosition,double x_max,double x_min) {
        bullet =b;
        player = p;
        this.localPosition = localPosition;
        this.globalPosition = globalPosition;
        this.x_max = x_max;
        this.x_min = x_min;
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
        nextPosition = new Vector2();
        updatedPosition = new Vector2();
        velocity = new Vector2();
        Dimension = new Vector2(50, 60);
        CollideBox = new Vector2(40, 50);
    }

    private void InitAnimation() {
        animation = new Animation();
        animation.setDuration(.05f);
        animation.setFrames(Assets.Instance.mushroom2Image[0]);
        for (int i = 0; i < 3; i++) {
            AnimationSprites.add(Assets.Instance.mushroom2Image[i]);
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
            collideTopEnemy= false;
            collideRightEnemy=false;
            collideBottomEnemy=false;
            collideLeftEnemy=false;
            checkPlayerCollision();
            if (player.isDead){
                player.setDestiny(player.getDestiny()-1);
            }
        }
        if(player.isDead){
            if (Math.abs(player.currentCol- currentCol)>4&&Math.abs(player.currentCol-currentCol)<6) {
                player.isDead=false;
            }
        }
        if(isDead&&!attacked)isDead = false;
        if(player.getAttack()&&Math.abs(bullet.nextPosition.y- localPosition.y)<CollideBox.y/2&&
                Math.abs(bullet.nextPosition.x- localPosition.x)< CollideBox.x/2){
            attacked = true;
            isDead = true;
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
        if (updatedPosition.x > x_max && isRight) {
            isLeft = true;
            isRight = false;
        } else if (updatedPosition.x < x_min && isLeft) {
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
                    animation.setFrames(Assets.Instance.mushroom2Image[0]);
                }
            } else {
                isCheckMoveAnimation = false;
                animation.setDuration(.05f);
                animation.setFrames(Assets.Instance.mushroom2Image[0]);
            }
        }
        else {
            isCheckJumpAnimation = false;
            isCheckMoveAnimation = false;
            animation.setDuration(0.05f);
            animation.setFrames(Assets.Instance.mushroom2Image[2]);
        }
    }

}