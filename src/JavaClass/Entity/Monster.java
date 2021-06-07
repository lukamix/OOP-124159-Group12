package JavaClass.Entity;

public class Monster extends Entity{
    protected Bullet bullet;
    protected Player player;

    protected boolean collideTopEnemy;
    protected boolean collideBottomEnemy;
    protected boolean collideRightEnemy;
    protected boolean collideLeftEnemy;

    protected  double x_max;
    protected  double x_min;

    protected void checkPlayerCollision() {
        if(Math.abs(player.nextPosition.x-localPosition.x)< CollideBox.x/2+player.CollideBox.x/2
                &&Math.abs(player.nextPosition.y- localPosition.y)< CollideBox.y/2+player.CollideBox.y/2)
            calculateCornerEnemy();
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
    protected void calculateCornerEnemy() {
        int left = (int)(localPosition.x-CollideBox.x/2+0.001)/30;
        int right = (int)(localPosition.x+ CollideBox.x/2-0.001)/30;
        int top = (int)(localPosition.y-CollideBox.y/2+0.001)/30;
        int bottom = (int)(localPosition.y+ CollideBox.y/2-0.001)/30;

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