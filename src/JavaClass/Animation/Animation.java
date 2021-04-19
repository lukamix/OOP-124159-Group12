package JavaClass.Animation;

import javafx.scene.image.Image;

public class Animation {
    private Image[] frames;
    private double duration;
    private boolean played;
    private int currFrame;
    private double startTimeInSecond;
    public Animation()
    {
        played=false;
    }
    public void setFrames(Image[] images)
    {
        this.frames=images;//import frames
        currFrame=0;
        startTimeInSecond=System.currentTimeMillis()/1000;
        played=false;
    }

    public void setDuration(double d )
    {
        this.duration=d;
    }
    public void updateFrame()
    {
        double elapsed=(System.currentTimeMillis()/1000.0-startTimeInSecond);//second
        if(elapsed>duration)
        {
            currFrame++;
            startTimeInSecond=System.currentTimeMillis()/1000.0;//reset
        }
        if(currFrame==frames.length)
        {
            currFrame=0;
            played=true;
        }
    }
    public Image getImage() {
        return frames[currFrame];
    }
}
