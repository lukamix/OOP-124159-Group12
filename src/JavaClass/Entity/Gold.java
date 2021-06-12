package JavaClass.Entity;

import JavaClass.Animation.Animation;
import Utils.Vector2;
import javafx.scene.canvas.GraphicsContext;
import JavaClass.Sprites.Assets;

public class Gold extends Entity {
    public Gold() {
        Init();
    }

    private void Init() {
        InitProperties();
        InitAnimation();
    }

    private void InitProperties() {
        localPosition = new Vector2(450, 490);
        globalPosition = new Vector2(450, 490);
        Dimension = new Vector2(142, 112);
    }

    private void InitAnimation() {
        animation = new Animation();
        animation.setDuration(1f);
        animation.setFrames(Assets.Instance.goldImage);
        AnimationSprites.add(Assets.Instance.goldImage);
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
