package JavaClass.Entity;

import JavaClass.Animation.Animation;
import Utils.Vector2;
import javafx.scene.canvas.GraphicsContext;
import JavaClass.Sprites.Assets;

public class Coin extends Monster {
    private boolean getCoin;
    private boolean beforeState;
    public static int beforePoint;
    public static boolean raiseCoin;
    public static int point;

    public Coin(Player p) {
        player = p;
        Init();
    }

    private void Init() {
        InitProperties();
        InitAnimation();
    }

    private void InitProperties() {
        point = 0;
        beforePoint = point;
        localPosition = new Vector2(500, 550);
        globalPosition = new Vector2(500, 550);
        velocity = new Vector2();
        Dimension = new Vector2(20, 30);
        CollideBox = new Vector2(20, 30);
    }

    private void InitAnimation() {
        animation = new Animation();
        animation.setDuration(0.2f);
        animation.setFrames(Assets.Instance.coinImage);
        AnimationSprites.add(Assets.Instance.coinImage);
    }

    @Override
    public void Update(GraphicsContext gc) {
        super.Update(gc);
        checkCollisionPlayer();
    }

    @Override
    public void Draw(GraphicsContext gc) {
        super.Draw(gc);
    }

    private void checkCollisionPlayer() {
        if (Math.abs(player.nextPosition.x - localPosition.x) < CollideBox.x / 2 + player.CollideBox.x / 2
                && Math.abs(player.nextPosition.y - localPosition.y) < CollideBox.y / 2 + player.CollideBox.y / 2)
            calculateCornerEnemy();
        if (collideBottomEnemy || collideLeftEnemy || collideRightEnemy || collideTopEnemy) {
            getCoin = true;
        }
        if (!beforeState && getCoin) {
            point++;
            beforeState = true;
        }
        if (beforePoint != point) {
            raiseCoin = true;
        } else {
            raiseCoin = false;
        }
        beforePoint = point;
    }

    public boolean getCoin() {
        return getCoin;
    }
}
