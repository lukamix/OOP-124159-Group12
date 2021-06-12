package JavaClass.Entity;

import JavaClass.Animation.Animation;
import Utils.Vector2;
import javafx.scene.canvas.GraphicsContext;
import JavaClass.Sprites.Assets;

public class Heart extends Entity {
    public Heart() {
        Init();
    }

    private void Init() {
        InitProperties();
        InitAnimation();
    }

    private void InitProperties() {
        localPosition = new Vector2(140, 400);
        globalPosition = new Vector2(140, 400);
        Dimension = new Vector2(20, 20);
    }

    private void InitAnimation() {
        animation = new Animation();
        animation.setDuration(1f);
        animation.setFrames(Assets.Instance.heartImage);
        AnimationSprites.add(Assets.Instance.heartImage);
    }

    @Override
    public void Update(GraphicsContext gc) {
        super.Update(gc);
    }

    @Override
    public void Draw(GraphicsContext gc) {
        super.Draw(gc);
    }
}

