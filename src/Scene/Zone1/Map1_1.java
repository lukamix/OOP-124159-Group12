package Scene.Zone1;

import javafx.scene.Parent;

public class Map1_1 extends MapWithTile {
    public Map1_1(Parent root, double width, double height)
    {
        super(root, width, height);
        tileMap.loadTile("src/Resources/SpriteSheet/spritesheet.png");
        tileMap.setPosition(0.0,0.0);
        tileMap.loadMap("src/Resources/SpriteSheet/map1.tmx");
    }
}
