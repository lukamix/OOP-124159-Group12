package JavaClass.Entity;

import JavaClass.Sprites.Assets;
import javafx.scene.canvas.GraphicsContext;

public class PostRender {
    public static void Update(GraphicsContext gc){
        gc.drawImage(Assets.Instance.zone1[53],50,50,231,66);

    }
}