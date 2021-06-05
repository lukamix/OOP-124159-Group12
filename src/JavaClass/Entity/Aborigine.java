package JavaClass.Entity;

import JavaClass.Animation.Animation;
import Utils.Vector2;
import javafx.scene.canvas.GraphicsContext;
import JavaClass.Sprites.Assets;

public class Aborigine extends Monster {
    private BulletMonster bulletMonster;
    private boolean canAttack;
    public Aborigine(Player p,Bullet b,BulletMonster bm,Vector2 localPosition,Vector2 globalPosition,double x_max,double x_min) {
        bulletMonster = bm;
        bullet = b;
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
        Dimension = new Vector2(100, 120);
        CollideBox = new Vector2(60, 80);
    }

    private void InitAnimation() {
        animation = new Animation();
        animation.setDuration(.05f);
        animation.setFrames(Assets.Instance.aborigineImage[0]);
        for (int i = 0; i < 3; i++) {
            AnimationSprites.add(Assets.Instance.aborigineImage[i]);
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
            checkPlayerCollision();
            checkAttack();
        }
        if(player.isAttack&&Math.abs(bullet.nextPosition.y- localPosition.y)<CollideBox.y/2&&
                Math.abs(bullet.nextPosition.x- localPosition.x)< CollideBox.x/2) {
            isDead = true;
        }
        if(bulletMonster.velocity.x==0)isAttack = false;
        if(canAttack){
            {
                isAttack = true;
                bulletMonster.velocity.x = 0.5f;
                if (isLeft) {
                    bulletMonster.isLeft = true;
                    bulletMonster.isRight = false;
                    bulletMonster.localPosition = new Vector2(localPosition.x - CollideBox.x / 2, localPosition.y);
                }
                if (isRight) {
                    bulletMonster.isLeft = false;
                    bulletMonster.isRight = true;
                    bulletMonster.localPosition = new Vector2(localPosition.x + CollideBox.x / 2, localPosition.y);
                }
            }
        }
        if(isAttack){
            if(Math.abs(player.nextPosition.x-bulletMonster.localPosition.x)< CollideBox.x/2&&
                    Math.abs(player.nextPosition.y-bulletMonster.localPosition.y)< CollideBox.y/2){
                player.isDead = true;
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
            if(!isAttack){
                if (isLeft || isRight) {
                    if (!isCheckMoveAnimation) {
                        isCheckMoveAnimation = true;
                        animation.setDuration(.05f);
                        animation.setFrames(Assets.Instance.aborigineImage[0]);
                    }
                } else {
                    isCheckMoveAnimation = false;
                    animation.setDuration(.05f);
                    animation.setFrames(Assets.Instance.aborigineImage[0]);
                }
            } else{
                isCheckMoveAnimation = false;
                animation.setDuration(.05f);
                animation.setFrames(Assets.Instance.aborigineImage[1]);
            }
        }
        else {
            isCheckJumpAnimation = false;
            isCheckMoveAnimation = false;
            animation.setDuration(0.05f);
            animation.setFrames(Assets.Instance.aborigineImage[2]);
        }
    }
    private void checkAttack(){
        int nextColEnemy = (int)(player.nextPosition.x)/30;
        int nextRowEnemy = (int)(player.nextPosition.y)/30;
        if(((nextColEnemy<currentCol&&nextColEnemy>currentCol-8&&isLeft)
                ||(nextColEnemy>currentCol&&nextColEnemy<currentCol+8&&isRight))&&Math.abs(nextRowEnemy-currentRow)<=3){
            canAttack = true;
        }else{
            canAttack = false;
        }
    }
}
