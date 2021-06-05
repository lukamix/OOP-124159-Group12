package JavaClass.Entity;

import JavaClass.Animation.Animation;
import Utils.Vector2;
import javafx.scene.canvas.GraphicsContext;
import JavaClass.Sprites.Assets;

public class BeeHive extends Monster {
    public BeeHive(Player p) {
        player = p;
        Init();
    }

    private void Init() {
        InitProperties();
        InitAnimation();
    }

    private void InitProperties() {
        localPosition = new Vector2(5300, 478);
        globalPosition = new Vector2(5300, 478);
        nextPosition = new Vector2();
        updatedPosition = new Vector2();
        velocity = new Vector2();
        Dimension = new Vector2(40, 60);
        CollideBox = new Vector2(40, 60);
    }

    private void InitAnimation() {
        animation = new Animation();
        animation.setDuration(.05f);
        animation.setFrames(Assets.Instance.beeHiveImage);
        AnimationSprites.add(Assets.Instance.beeHiveImage);
    }

    @Override
    public void Update(GraphicsContext gc) {
        super.Update(gc);
        UpdateCollision();
    }

    @Override
    public void Draw(GraphicsContext gc) {
        super.Draw(gc);
    }
    private void UpdateCollision(){
        if(!player.isDead)
            checkPlayerCollision();
        if(collideBottomEnemy||collideLeftEnemy||collideTopEnemy||collideRightEnemy){
            player.setCollideBeeHive(true);
            if(player.isDead){
                player.isDead = false;
            }
        }
    }
}