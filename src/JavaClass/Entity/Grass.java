package JavaClass.Entity;

import JavaClass.Animation.Animation;
import Utils.Vector2;
import javafx.scene.canvas.GraphicsContext;
import JavaClass.Sprites.Assets;

public class Grass extends Entity {
    public Grass() {
        Init();
    }

    private void Init() {
        InitProperties();
        InitAnimation();
    }

    private void InitProperties() {
        localPosition = new Vector2(6450, 560);
        globalPosition = new Vector2(6450, 560);
        Dimension = new Vector2(150, 150);
    }

    private void InitAnimation() {
        animation = new Animation();
        animation.setDuration(1f);
        animation.setFrames(Assets.Instance.grassImage);
        AnimationSprites.add(Assets.Instance.grassImage);
    }

    @Override
    public void Update(GraphicsContext gc) {
        super.Update(gc);
    }

    @Override
    public void Draw(GraphicsContext gc) {
        super.Draw(gc);
    }
    public void setDimension(Vector2 v){
        Dimension = v;
    }
    public Animation getAnimation(){
        return animation;
    }
}
