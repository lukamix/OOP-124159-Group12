package JavaClass.UI.SelectMapScene.Button;

import JavaClass.UI.Decorator;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StarDisplay extends Decorator {
    private Decorator[] Star;
    public StarDisplay() throws FileNotFoundException {
        super();
        this.setViewOrder(1);
        width = 110;
        height = 40;
        url = "src/Resources/UI/SelectMapScene/Button/star4.png";
        Image image = new Image(new FileInputStream(url),width,height,false,true);
        Init(image);
    }
    @Override
    public void Init(Image image) throws FileNotFoundException {
        super.Init(image);
        Star = new Decorator[3];
        for(int i=0;i<3;i++){
            Star[i] = new Decorator();
            InitStar(Star[i],"src/Resources/UI/SelectMapScene/Button/star"+Integer.toString(i)+".png");
        }
    }
    private void InitStar(Decorator Star,String url) throws FileNotFoundException {
        int width = 107;
        int height =114;
        Image image = new Image(new FileInputStream(url),width,height,false,true);
        Star.Init(image);
    }
}
