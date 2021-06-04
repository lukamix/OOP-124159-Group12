package JavaClass.Entity;

import JavaClass.Animation.Animation;
import Utils.Vector2;
import javafx.scene.canvas.GraphicsContext;
import JavaClass.Sprites.Assets;

public class Tree extends Entity {
    public Tree() {
        Init();
    }

    private void Init() {
        InitProperties();
        InitAnimation();
    }

    private void InitProperties() {
        localPosition = new Vector2(140, 400);
        globalPosition = new Vector2(140, 400);
        Dimension = new Vector2(250, 400);
    }

    private void InitAnimation() {
        animation = new Animation();
        animation.setDuration(1f);
        animation.setFrames(Assets.Instance.treeImage[0]);
        for(int i =0;i<3;i++){
            AnimationSprites.add(Assets.Instance.treeImage[i]);
        }
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