package Utils;

public class Vector2 {
    public double x;
    public double y;

    public Vector2(){
        this.x=0f;
        this.y=0f;
    }
    public Vector2(double x, double y){
        this.x=x;
        this.y=y;
    }
    public void Translate(Vector2 destiny){
        x=destiny.x;
        y=destiny.y;
    }
    public void Move(){

    }
}
