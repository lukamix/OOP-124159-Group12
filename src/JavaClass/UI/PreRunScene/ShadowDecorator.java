package JavaClass.UI.PreRunScene;

import JavaClass.UI.Decorator;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ShadowDecorator extends Decorator {
    public ShadowDecorator() throws FileNotFoundException{
        super();
        width = 144;
        height = 39;
        url = "src/Resources/UI/MainMenu/shadow.png";
        Image image = new Image(new FileInputStream(url),width,height,false,true);
        Init(image);
    }
}
