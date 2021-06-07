package JavaClass.Entity;

import Constant.SystemConstant;
import JavaClass.Animation.Animation;
import Utils.Vector2;
import javafx.scene.canvas.GraphicsContext;
import JavaClass.Sprites.Assets;

public class Woodpecker extends Monster {
    private boolean isTop, isBottom;
    public Woodpecker(Player p,Bullet b) {
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
        isTop = true;
        isBottom = false;
        localPosition = new Vector2(5265, 530);
        globalPosition = new Vector2(5265, 530);
        nextPosition = new Vector2();
        updatedPosition = new Vector2();
        velocity = new Vector2();
        Dimension = new Vector2(50, 60);
        CollideBox = new Vector2(40, 50);
    }

    private void InitAnimation() {
        animation = new Animation();
        animation.setDuration(.05f);
        animation.setFrames(Assets.Instance.woodpeckerImage[0]);
        for (int i = 0; i < 2; i++) {
            AnimationSprites.add(Assets.Instance.woodpeckerImage[i]);
        }
    }

    private void InitMovement() {
        velocity.x = 0f;
        velocity.y = 1.0f;
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
        updatedPosition.x = localPosition.x+dx;
        updatedPosition.y = localPosition.y+dy;
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
        UpdateTopBottomBoolean();
        UpdateDy();
    }
    private void UpdateTopBottomBoolean(){
        if(isDead){
            isTop = false;
            isBottom = false;
        }
        if(updatedPosition.y>540&&isTop){
            isBottom = true;
            isTop = false;
        }
        if(updatedPosition.y<470&&isBottom){
            isTop = true;
            isBottom = false;
        }
    }
    private void UpdateDy(){
        if(isTop){
            dy+=velocity.y;
            if(dy>maxVec)dy=maxVec;
        } else if(isBottom){
            dy-=maxVec;
            if(dy<-maxVec) dy=-maxVec;
        } else dy=0;
    }
    private void UpdateAnimation() {
        if(!isDead){
            animation.setDuration(0.05f);
            animation.setFrames(Assets.Instance.woodpeckerImage[0]);
        } else {
            animation.setDuration(0.05f);
            animation.setFrames(Assets.Instance.woodpeckerImage[1]);
        }
    }
}
