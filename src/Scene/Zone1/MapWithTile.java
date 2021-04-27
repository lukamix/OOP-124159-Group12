package Scene.Zone1;

import Constant.SystemConstant;
import JavaClass.Entity.Player;
import JavaClass.TileMap.TileMap;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MapWithTile extends Scene {

    public TileMap tileMap;
    {
        try {
            tileMap = new TileMap();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public MapWithTile(AnchorPane anchorPane, double width, double height) throws FileNotFoundException {
        super(anchorPane, width, height);
        AddBackGround(anchorPane);
    }
    public void Update(Player player, GraphicsContext g){

    }
    private void AddBackGround(AnchorPane anchorPane)  throws FileNotFoundException {
        Image background=new Image(new FileInputStream("src/Resources/Textures/Textures/Backgrounds/bg.png"),1200,675,false,true);
        BackgroundImage backgroundImage=new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);
        anchorPane.setBackground(new Background(backgroundImage));
    }
}
