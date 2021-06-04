package JavaClass.Entity;

import JavaClass.Animation.Animation;
import Utils.Vector2;
import javafx.scene.canvas.GraphicsContext;
import JavaClass.Sprites.Assets;

public class SpeedLine extends Entity {
    public SpeedLine() {
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
        Dimension = new Vector2(150, 35);
        CollideBox = new Vector2(150, 35);
    }

    private void InitAnimation() {
        animation = new Animation();
        animation.setDuration(1f);
        animation.setFrames(Assets.Instance.speedLineImage);
        AnimationSprites.add(Assets.Instance.speedLineImage);
    }

    private void InitMovement() {
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
        if (isRight) {
            faceRight = true;
        }
        if (isLeft) {
            faceRight = false;
        }
    }

    private void UpdateAnimation() {
        animation.setDuration(1f);
        animation.setFrames(Assets.Instance.speedLineImage);
    }
}
