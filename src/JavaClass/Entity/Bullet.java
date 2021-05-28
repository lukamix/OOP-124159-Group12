package JavaClass.Entity;

import JavaClass.Animation.Animation;
import Utils.Vector2;
import javafx.scene.canvas.GraphicsContext;
import JavaClass.Sprites.Assets;

public class Bullet extends Entity {
    public Bullet() {
        Init();
    }

    private void Init() {
        InitProperties();
        InitAnimation();
        InitMovement();
    }

    private void InitProperties() {
        isLeft = false;
        isRight = true;
        localPosition = new Vector2(500, 640);
        globalPosition = new Vector2(500, 640);
        nextPosition = new Vector2();
        updatedPosition = new Vector2();
        velocity = new Vector2();
        Dimension = new Vector2(20, 30);
        CollideBox = new Vector2(20, 30);
    }

    private void InitAnimation() {
        animation = new Animation();
        animation.setDuration(1f);
        animation.setFrames(Assets.Instance.bulletImage);
        AnimationSprites.add(Assets.Instance.bulletImage);
    }

    private void InitMovement() {
        velocity.x = 0.5f;
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
        dx+=velocity.x;
        if(dx>20){
            dx=0;
            velocity.x = 0;
        }
        setPosition(updatedPosition);
        if (isRight) {
            faceRight = true;
        }
        if (isLeft) {
            faceRight = false;
        }
    }
    private void UpdateAnimation() {
        isCheckJumpAnimation = false;
        isCheckMoveAnimation = false;
        animation.setDuration(1f);
        animation.setFrames(Assets.Instance.bulletImage);
    }
}
