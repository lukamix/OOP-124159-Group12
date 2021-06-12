package JavaClass.Entity;

import Constant.SystemConstant;
import JavaClass.Animation.Animation;
import Utils.Vector2;
import JavaClass.Sprites.Assets;
import javafx.scene.canvas.GraphicsContext;

public class Boss3 extends Monster {
    private int destiny = 5;
    int f=2;

    public Boss3(Player p, Bullet b) {
        player = p;
        bullet = b;
        Init();
    }

    //region Init
    private void Init() {
        InitProperties();
        InitAnimation();
        InitMovement();
    }

    private void InitProperties() {
        isLeft = true;
        isRight = false;
        localPosition = new Vector2(1800, 530);
        globalPosition = new Vector2(1800, 530);
        nextPosition = new Vector2();
        updatedPosition = new Vector2();
        velocity = new Vector2();
        Dimension = new Vector2(95, 90);
        CollideBox = new Vector2(50, 60);
    }

    private void InitAnimation() {
        animation = new Animation();
        animation.setDuration(.05f);
        animation.setFrames(Assets.Instance.boss3Image[0]);
        for (int i = 0; i < 5; i++) {
            AnimationSprites.add(Assets.Instance.boss3Image[i]);
        }
    }

    private void InitMovement() {
        velocity.x = 0.5f;
        velocity.y = 1.0f;
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

    private void UpdatePosition() {
        checkTileMapCollision();
        if (!isDead && !player.isDead) {
            checkAttack();
            collideTopEnemy = false;
            collideRightEnemy = false;
            collideBottomEnemy = false;
            collideLeftEnemy = false;
            checkPlayerCollision();
            if (isDead) {
                player.isDead = true;
                isDead = false;
            }
            if (player.isDead) {
                player.setDestiny(player.getDestiny() - 1);
            }
        }
        if (player.isDead) {
            if (Math.abs(player.currentCol - currentCol) > 4 && Math.abs(player.currentCol - currentCol) < 6) {
                if (player.getDestiny()!=0) player.isDead = false;
            }
        }
        if (!isDead) {
            if (player.getAttack() && Math.abs(bullet.nextPosition.y - localPosition.y) < CollideBox.y / 2 &&
                    Math.abs(bullet.nextPosition.x - localPosition.x) < CollideBox.x / 2&&bullet.velocity.x!=0) {
                isDead = true;
                destiny--;
                if(isLeft){
                    isLeft = false;
                    isRight = true;
                }else {
                    if (isRight) {
                        isRight = false;
                        isLeft = true;
                    }
                }
            }
        }
        if(destiny!=0&&!player.getAttack()){
            isDead = false;
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
        if(isAttack){
            velocity.y=1.0f;
            UpdateDy();
        }
        else{
            localPosition.y=530;
            dy=0;
            velocity.y=0f;
        }
    }

    private void UpdateLeftRightBoolean() {
        if (destiny==0) {
            isLeft = false;
            isRight = false;
        }
        if(!player.isDead&&localPosition.x>=1400&&localPosition.x<=2300){
            if(player.currentCol<currentCol&&player.currentCol>currentCol-5&&isRight){
                isRight = false;
                isLeft = true;
            }
            if(player.currentCol>currentCol&&player.currentCol<currentCol+5&&isLeft){
                isLeft = false;
                isRight = true;
            }
        }
        if (updatedPosition.x > 2300 && isRight) {
            isLeft = true;
            isRight = false;
        } else if (updatedPosition.x < 1400 && isLeft) {
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

    private void UpdateDy() {
        if (destiny==0) {
            if (!isGrounded) {
                velocity.y += SystemConstant.GRAVITY * SystemConstant.FPS;
                dy = velocity.y * SystemConstant.FPS;
            }
            if ((bottomLeft || bottomRight || collideBottom) && !isGrounded) {
                if (!jumping) {
                    isGrounded = true;
                    dy = 0;
                }
            } else if (isGrounded && !collideBottom && !bottomLeft && !bottomRight) {
                velocity.y = 0;
                isGrounded = false;
            }
            if (velocity.y > 0) {
                jumping = false;
            }
        }
        if(localPosition.y<360){
            dy=0;
            f=1;
        }
        if(localPosition.y>500){
            dy=0;
            f=2;
        }
        if(f==1)dy+=velocity.y;
        if(f==2)dy-=velocity.y;
    }

    private void UpdateAnimation() {
        if (isGrounded) {
            if (isCheckJumpAnimation) isCheckMoveAnimation = false;
        }
        if (destiny!=0) {
            if(!isDead){
                if(!isAttack){
                    if (isLeft || isRight) {
                        if (!isCheckMoveAnimation) {
                            isCheckMoveAnimation = true;
                            animation.setDuration(.05f);
                            animation.setFrames(Assets.Instance.boss3Image[1]);
                        }
                    } else {
                        isCheckMoveAnimation = false;
                        animation.setDuration(.05f);
                        animation.setFrames(Assets.Instance.boss3Image[0]);
                    }
                }else{
                    isCheckMoveAnimation = false;
                    animation.setDuration(0.05f);
                    animation.setFrames(Assets.Instance.boss3Image[4]);
                }
            }else{
                isCheckMoveAnimation = false;
                animation.setDuration(.05f);
                animation.setFrames(Assets.Instance.boss3Image[2]);
            }
        } else {
            isCheckJumpAnimation = false;
            isCheckMoveAnimation = false;
            animation.setDuration(0.05f);
            animation.setFrames(Assets.Instance.boss3Image[3]);
        }
    }
    private void checkAttack(){
        if((player.currentCol<currentCol&&player.currentCol>currentCol-10)
                ||(player.currentCol>currentCol&&player.currentCol<currentCol+10)){
            isAttack = true;
        }else{
            isAttack = false;
        }
    }
    public int getDestiny(){
        return destiny;
    }
}

