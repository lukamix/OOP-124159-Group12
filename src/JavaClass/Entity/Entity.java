package JavaClass.Entity;

import JavaClass.Animation.Animation;
import JavaClass.TileMap.Tile;
import JavaClass.TileMap.TileMap;
import Utils.Vector2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class Entity {
    //region Entity Properties
    protected Vector2 localPosition;
    protected Vector2 Dimension;
    protected Vector2 CollideBox;
    protected Animation animation;
    public boolean faceRight;
    //endregion
    //region Movement Attributes
    protected Vector2 velocity;
    protected double maxVec;
    protected Vector2 nextPosition;
    protected Vector2 updatedPosition;
    //region Collide Atrribute
    protected int currentRow;
    protected int currentCol;
    protected boolean topLeft;
    protected boolean topRight;
    protected boolean bottomLeft;
    protected boolean bottomRight;
    protected boolean collideTop;
    protected boolean collideBottom;
    protected boolean collideLeft;
    protected boolean collideRight;

    private boolean collideTopEnemy;
    private boolean collideBottomEnemy;
    private boolean collideRightEnemy;
    private boolean collideLeftEnemy;
    //endregions
    protected double dx;
    protected double dy;
    protected boolean isRight;
    protected boolean isLeft;
    protected boolean isJump;
    protected boolean jumping;
    protected boolean canJump;
    protected boolean isCheckMoveAnimation;
    protected boolean isCheckJumpAnimation;
    protected boolean isGrounded;
    protected boolean isDead;
    //endregion
    //region Map Properties
    public TileMap tileMap;
    protected Vector2 globalPosition;
    //endregion
    protected ArrayList<Image[]> AnimationSprites=new ArrayList<>();
    public void Update(GraphicsContext gc){
        setGlobalPosition();
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
        currentCol = (int)localPosition.x/30;
        currentRow = (int)localPosition.y/30;
        nextPosition.x = localPosition.x+dx;
        nextPosition.y = localPosition.y+dy;
        updatedPosition.x = localPosition.x;
        updatedPosition.y = localPosition.y;
        if(nextPosition.x>0 + CollideBox.x/2  &&  nextPosition.x< 30* tileMap.numCols- CollideBox.x/2) {
            calculateCorner(nextPosition.x, localPosition.y);
            if(dx>0){
                if(collideRight){
                    dx = 0;
                    updatedPosition.x = localPosition.x;
                } else {
                    updatedPosition.x += dx;
                }
            }
            if(dx<0){
                if(collideLeft){
                    dx = 0;
                    updatedPosition.x = localPosition.x;
                } else {
                    updatedPosition.x+=dx;
                }
            }
        }
        if(nextPosition.y>0+ CollideBox.y/2 && nextPosition.y < 30 * tileMap.numRows - CollideBox.y/2) {
            calculateCorner(localPosition.x, nextPosition.y);
            if(velocity.y<0){
                if(collideTop){
                    dy=0;
                    updatedPosition.y = localPosition.y;
                } else{
                    updatedPosition.y+=dy;
                }
            }
            if(velocity.y>0){
                if(collideBottom){
                    dy=0;
                    updatedPosition.y = localPosition.y;
                } else{
                    updatedPosition.y+=dy;
                }
            }
        }
    }
    public void calculateCorner(double x,double y)
    {
        //region Get Corner Index
        int leftTileCorner=(int)(x- CollideBox.x/2+0.0001)/30;
        int rightTileCorner=(int)(x + CollideBox.x/2-0.0001)/30;
        int topTile=(int)((y - CollideBox.y/2+0.0001)/30);
        int bottomTile=(int)(y + CollideBox.y/2-0.0001)/30;
        //endregion
        //region CheckCorner
        int typeTopLeft=tileMap.getType(topTile,leftTileCorner);
        int typeTopRight=tileMap.getType(topTile,rightTileCorner);
        int typeBottomLeft=tileMap.getType(bottomTile,leftTileCorner);
        int typeBottomRight=tileMap.getType(bottomTile,rightTileCorner);

        this.topLeft = ( typeTopLeft == Tile.BLOCKED);
        this.topRight = ( typeTopRight == Tile.BLOCKED);
        this.bottomLeft = ( typeBottomLeft == Tile.BLOCKED);
        this.bottomRight = ( typeBottomRight == Tile.BLOCKED);
        //endregion
        //region Check 4 Sign
        int typeTop = tileMap.getType(topTile,currentCol);
        int typeBottom = tileMap.getType(bottomTile,currentCol);
        int typeLeft = tileMap.getType(currentRow,leftTileCorner);
        int typeRight = tileMap.getType(currentRow,rightTileCorner);

        collideTop = (typeTop == Tile.BLOCKED);
        collideBottom = (typeBottom == Tile.BLOCKED);
        collideLeft = (typeLeft == Tile.BLOCKED);
        collideRight = (typeRight == Tile.BLOCKED);
        //endregion
    }
    public void setGlobalPosition()
    {
        globalPosition.x=tileMap.getX();
        globalPosition.y=tileMap.getY();
    }
    public Vector2 getNextPosition() {
        return nextPosition;
    }
    protected void checkPlayerCollision(Player player) {
        if(Math.abs(player.nextPosition.x-updatedPosition.x)< CollideBox.x/2+player.CollideBox.x/2
                &&Math.abs(player.nextPosition.y- updatedPosition.y)< CollideBox.y/2+player.CollideBox.y/2)
            calculateCornerEnemy(player);
        if(collideRightEnemy||collideLeftEnemy){
            updatedPosition.x = localPosition.x;
            player.updatedPosition.x = player.localPosition.x;
        }
        if(collideBottomEnemy||collideTopEnemy){
            updatedPosition.y = localPosition.y;
            player.updatedPosition.y = player.localPosition.y;
        }
        if(collideTopEnemy||collideRightEnemy||collideLeftEnemy){
            player.isDead = true;
        }
        if(collideBottomEnemy){
            isDead = true;
        }
    }
    public void calculateCornerEnemy(Player player) {
        int left = (int)(nextPosition.x-CollideBox.x/2+0.001)/30;
        int right = (int)(nextPosition.x+ CollideBox.x/2-0.001)/30;
        int top = (int)(nextPosition.y-CollideBox.y/2+0.001)/30;
        int bottom = (int)(nextPosition.y+ CollideBox.y/2-0.001)/30;

        int leftEnemy = (int)(player.nextPosition.x-player.CollideBox.x/2+0.001)/30;
        int rightEnemy = (int)(player.nextPosition.x+ player.CollideBox.x/2-0.001)/30;
        int topEnemy = (int)(player.nextPosition.y-player.CollideBox.y/2+0.001)/30;
        int bottomEnemy = (int)(player.nextPosition.y+ player.CollideBox.y/2-0.001)/30;

        collideTopEnemy = (topEnemy == bottom);
        collideBottomEnemy = (bottomEnemy == top);
        collideLeftEnemy = (leftEnemy == right);
        collideRightEnemy = (rightEnemy == left);

        if(collideTopEnemy&&collideLeftEnemy||collideTopEnemy&&collideRightEnemy){
            collideTopEnemy = false;
        }
        if(collideBottomEnemy&&collideRightEnemy||collideBottomEnemy&&collideLeftEnemy){
            collideBottomEnemy = false;
        }
    }
}
