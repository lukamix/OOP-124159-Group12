package Scene.Zone1;

import Constant.SystemConstant;
import JavaClass.Entity.Player;
import JavaClass.TileMap.TileMap;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;

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
    public MapWithTile(Parent root, double width, double height) {
        super(root, width, height);
    }
    public void Update(Player player, GraphicsContext g){
        tileMap.setPosition(1200,1200);
        tileMap.drawMap(g);
        tileMap.drawLayer2(g);
        tileMap.drawLayer3(g);
    }
}
