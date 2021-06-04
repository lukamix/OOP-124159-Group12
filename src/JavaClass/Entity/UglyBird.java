package JavaClass.Entity;

import JavaClass.Animation.Animation;
import Utils.Vector2;
import javafx.scene.canvas.GraphicsContext;
import JavaClass.Sprites.Assets;

public class UglyBird extends Monster {
    public UglyBird(Player p) {
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
        localPosition = new Vector2(8100, 460);
        globalPosition = new Vector2(8100, 460);
        nextPosition = new Vector2();
        updatedPosition = new Vector2();
        velocity = new Vector2();
        Dimension = new Vector2(50, 60);
        CollideBox = new Vector2(40, 50);
    }

    private void InitAnimation() {
        animation = new Animation();
        animation.setDuration(.05f);
        animation.setFrames(Assets.Instance.uglyBirdImage);
        AnimationSprites.add(Assets.Instance.uglyBirdImage);
    }

    private void InitMovement() {
        velocity.x = 0f;
        velocity.y = 0f;
        maxVec = 1000f;
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
        if(!player.isDead) {
            checkAttack();
            checkPlayerCollision();
            if(isDead){
                isDead = false;
                player.isDead = true;
            }
        }
        if(isAttack){
            velocity.x = 1;
        }
        dx-=velocity.x;
        if(dx<-maxVec){
            dx = 0;
            velocity.x = 0;
            isAttack = false;
        }
        setPosition(updatedPosition);
        if (isRight) {
            faceRight = false;
        }
        if (isLeft) {
            faceRight = true;
        }
    }

    private void UpdateAnimation() {
        animation.setDuration(0.05f);
        animation.setFrames(Assets.Instance.uglyBirdImage);
    }

    private void checkAttack(){
        if(player.nextPosition.x>localPosition.x-1000&&
                Math.abs(player.nextPosition.y-localPosition.y)<CollideBox.y/2){
            isAttack = true;
        }
    }
}
