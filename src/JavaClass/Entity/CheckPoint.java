package JavaClass.Entity;

import JavaClass.Animation.Animation;
import Utils.Vector2;
import javafx.scene.canvas.GraphicsContext;
import JavaClass.Sprites.Assets;

public class CheckPoint extends Entity {
    public CheckPoint() {
        Init();
    }

    private void Init() {
        InitProperties();
        InitAnimation();
    }

    private void InitProperties() {
        localPosition = new Vector2(450, 490);
        globalPosition = new Vector2(450, 490);
        Dimension = new Vector2(50, 140);
    }

    private void InitAnimation() {
        animation = new Animation();
        animation.setDuration(1f);
        animation.setFrames(Assets.Instance.checkPointImage);
        AnimationSprites.add(Assets.Instance.checkPointImage);
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
