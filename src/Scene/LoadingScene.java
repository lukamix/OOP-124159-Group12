package Scene;

import Scene.Zone1.MapWithTile;
import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;

public class LoadingScene extends MapWithTile {
    public LoadingScene(AnchorPane anchorPane, double width, double height) throws FileNotFoundException {
        super(anchorPane, width, height);
    }
}
