package Scene;

import JavaClass.UI.SelectMapScene.Button.BackButton;
import JavaClass.UI.SelectMapScene.MapBackGround;
import Scene.Zone1.MapWithTile;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SelectMapScene extends MapWithTile {
    public SelectMapScene(AnchorPane anchorPane, double width, double height,int map) throws FileNotFoundException {
        super(anchorPane, width, height);
        Init(anchorPane,map);
    }
    private void Init(AnchorPane anchorPane,int map) throws FileNotFoundException {
        AddBackGround(anchorPane);
        AddMapBackGround(anchorPane,map);
        AddBackButton(anchorPane);
    }
    private void AddBackGround(AnchorPane anchorPane)  throws FileNotFoundException {
        Image background=new Image(new FileInputStream("src/Resources/UI/SelectMapScene/progressmap_bg 1.png"),1200,675,false,true);
        BackgroundImage backgroundImage=new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);
        anchorPane.setBackground(new Background(backgroundImage));
    }
    private void AddMapBackGround(AnchorPane anchorPane,int map) throws FileNotFoundException {
        MapBackGround mapBackGround = new MapBackGround(anchorPane,"src/Resources/UI/SelectMapScene/progressmap_bg_"+String.valueOf(map)+".png");
        anchorPane.getChildren().add(mapBackGround);
        AnchorPane.setTopAnchor(mapBackGround,20.0);
        AnchorPane.setLeftAnchor(mapBackGround,20.0);
    }
    private void AddBackButton(AnchorPane anchorPane) throws FileNotFoundException {
        BackButton backButton =new BackButton(anchorPane,60,620);
    }
}
