package JavaClass.Sprites;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Assets {
    public static Assets Instance;

    static {
        try {
            Instance = new Assets();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Image[] zone1 = new Image[100];
    public Assets() throws FileNotFoundException {
        Init();
    }
    public void Init() throws FileNotFoundException {
        InitZone1Image();
    }
    public void InitZone1Image() throws FileNotFoundException {
        for(int i=1;i<=98;i++){
            zone1[i] = new Image (new FileInputStream("src/Resources/Textures/Tiles/Zone1/item"+Integer.toString(i)));
        }
    }
    public void foo(){
        
    }
}
