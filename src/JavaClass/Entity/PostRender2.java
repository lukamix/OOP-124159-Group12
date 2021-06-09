package JavaClass.Entity;

import JavaClass.Sprites.Assets;
import javafx.scene.canvas.GraphicsContext;

public class PostRender2 {
    public static void Update(GraphicsContext gc){
        gc.drawImage(Assets.Instance.winImage[0],380,180,459,386);

    }
}

