package JavaClass.UI.PreRunScene;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EnemyDecorator extends AnimDecorator{
    public EnemyDecorator() throws FileNotFoundException {
        super();
        width = 201;
        height = 202;
        url = "src/Resources/UI/MainMenu/mainmenu_bg_2.png";
        Image image = new Image(new FileInputStream(url),width,height,false,true);
        Init(image);
        SetAnimation();
    }
}
