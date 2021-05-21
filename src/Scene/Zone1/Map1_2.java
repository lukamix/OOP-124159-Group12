package Scene.Zone1;

import Constant.SystemConstant;
import JavaClass.Entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;

public class Map1_2 extends MapWithTile {
    public Map1_2(AnchorPane anchorPane, double width, double height) throws FileNotFoundException {
        super(anchorPane, width, height);
        tileMap.loadTile("src/Resources/SpriteSheet/spritesheet1.png");
        tileMap.loadMap("src/Resources/SpriteSheet/Map1.1.tmx");
        tileMap.setPosition(0.0, 0.0);
    }
    @Override
    public void Update(Player player, GraphicsContext g) {
        super.Update(player, g);
        tileMap.setPosition(player.getNextPosition().x - SystemConstant.SCREEN_WIDTH / 2, player.getNextPosition().y - SystemConstant.SCREEN_HEIGHT/ 2);
        tileMap.drawMap(g);
        tileMap.drawLayer2(g);
        tileMap.drawLayer3(g);
    }
}
