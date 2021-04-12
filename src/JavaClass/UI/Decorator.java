package JavaClass.UI;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;

public class Decorator extends ImageView {
    protected int width ;
    protected int height ;
    protected String url;
    public Decorator() {

    }
    public Decorator(Image image,int width,int height) throws FileNotFoundException {
        Init(image);
        this.width = width;
        this.height = height;
    }
    public void Init(Image image) throws FileNotFoundException {
        setFitHeight(height);
        setFitWidth(width);
        setPreserveRatio(true);
        setImage(image);
    }
}
