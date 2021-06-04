package JavaClass.Entity;

import JavaClass.Animation.Animation;
import Utils.Vector2;
import javafx.scene.canvas.GraphicsContext;
import JavaClass.Sprites.Assets;

public class Flag extends Entity {
    public Flag() {
        Init();
    }

    private void Init() {
        InitProperties();
        InitAnimation();
    }

    private void InitProperties() {
        isLeft = true;
        isRight = false;
        localPosition = new Vector2(8435, 490);
        globalPosition = new Vector2(8435, 490);
        nextPosition = new Vector2();
        updatedPosition = new Vector2();
        velocity = new Vector2();
        Dimension = new Vector2(50, 70);
        CollideBox = new Vector2(50, 70);
    }

    private void InitAnimation() {
        animation = new Animation();
        animation.setDuration(.02f);
        animation.setFrames(Assets.Instance.flagImage);
        AnimationSprites.add(Assets.Instance.flagImage);
    }

    @Override
    public void Update(GraphicsContext gc) {
        super.Update(gc);
        if(isLeft){
            faceRight = true;
        }
        if(isRight){
            faceRight = false;
        }
    }

    @Override
    public void Draw(GraphicsContext gc) {
        super.Draw(gc);
    }

}
