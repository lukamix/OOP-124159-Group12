package JavaClass.UI.PreRunScene;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PlayerDecorator extends AnimDecorator{
    public PlayerDecorator() throws FileNotFoundException {
        super();
        width = 332;
        height = 298;
        url = "src/Resources/UI/MainMenu/mainmenu_bg_1.png";
        Image image = new Image(new FileInputStream(url),width,height,false,true);
        Init(image);
        SetAnimation();
    }
}
