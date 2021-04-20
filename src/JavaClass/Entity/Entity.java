package JavaClass.Entity;

import JavaClass.Animation.Animation;
import Utils.Vector2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public abstract class Entity {
    //region Entity Properties
    protected Vector2 localPosition;
    protected Vector2 globalPosition;
    protected Vector2 Dimension;
    protected Vector2 CollideBox;
    protected Animation animation;
    public boolean faceRight;
    //endregion
    //region Movement attribute
    protected Vector2 veclocity;
    protected double maxVec;
    protected Vector2 nextPosition;
    protected Vector2 updatedPosition;
    protected double dx;
    protected double dy;
    protected boolean isRight;
    protected boolean isLeft;
    protected boolean isJump;
    protected boolean canJump;
    protected boolean isCheckAnimation;
    protected boolean isGrounded;
    //endregion

    protected ArrayList<Image[]> AnimationSprites=new ArrayList<>();

    public void Update(GraphicsContext gc){
        Draw(gc);
        animation.updateFrame();
    }

    public void Draw(GraphicsContext gc)
    {
        if(!faceRight) {
            gc.drawImage(animation.getImage(),localPosition.x - globalPosition.x + Dimension.x/2,
                    localPosition.y- globalPosition.y - Dimension.y/2,-Dimension.x, Dimension.y);
        }
        else
        {
            gc.drawImage(animation.getImage(), localPosition.x -globalPosition.x - Dimension.x/2,
                    localPosition.y - globalPosition.y - Dimension.y/2, Dimension.x, Dimension.y);
        }
    }
    public void setPosition(Vector2 position)
    {
        localPosition = position;
    }
    protected void checkTileMapCollision(){
        nextPosition.x = localPosition.x+dx;
        nextPosition.y = localPosition.y+dy;
    }

    public Vector2 getNextPosition() {
        return nextPosition;
    }

    public Vector2 getUpdatedPosition() {
        return updatedPosition;
    }
}
