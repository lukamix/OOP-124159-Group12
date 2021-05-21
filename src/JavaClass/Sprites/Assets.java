package JavaClass.Sprites;

import javafx.scene.image.Image;
import javafx.scene.text.Text;

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
    public Image[][] playerImage = new Image[7][20];
    public Image[][] mushroomImage = new Image[3][15];
    public Image[] zone1 = new Image[100];
    public Assets() throws FileNotFoundException {
        Init();
    }
    public void Init() throws FileNotFoundException {
        InitZone1Image();
        InitPlayerImage();
        InitMushroomImage();
    }
    public void InitZone1Image() throws FileNotFoundException {
        for(int i=1;i<=98;i++){
            zone1[i] = new Image (new FileInputStream("src/Resources/Textures/Textures/Tiles/Zone1/item"+Integer.toString(i)+".png"));
        }
    }
    public void InitPlayerImage() throws FileNotFoundException {
        for(int i=0;i<13;i++){
            playerImage[0][i] = new Image( new FileInputStream(
                    "src/Resources/Textures/Character Player/Orc/idle/main_character_idle"+Integer.toString(i)+".png"));
        }
        for(int i=0;i<14;i++){
            playerImage[1][i] = new Image( new FileInputStream(
                    "src/Resources/Textures/Character Player/Orc/move/main_character_move"+Integer.toString(i)+".png"));
        }
        playerImage[2][0] = new Image(new FileInputStream("src/Resources/Textures/Character Player/Orc/jump/main_character_jump.png"));
        for(int i=0;i<9;i++){
            playerImage[3][i] = new Image( new FileInputStream(
                    "src/Resources/Textures/Character Player/Orc/attack/main_character_attack"+Integer.toString(i)+".png"));
        }
    }
    public void InitMushroomImage() throws FileNotFoundException{
        for(int i=0;i<14;i++){
            mushroomImage[0][i] = new Image( new FileInputStream(
                    "src/Resources/Textures/Monster Enemy/Monsters/Mushroom1/move/monster2_move"+Integer.toString(i)+".png"));
        }
            mushroomImage[1][0] = new Image(new FileInputStream(
             "src/Resources/Textures/Monster Enemy/Monsters/Mushroom1/damage/monster2_dame"+".png"
            ));
            mushroomImage[2][0] = new Image(new FileInputStream(
                    "src/Resources/Textures/Monster Enemy/Monsters/Mushroom1/die/monster2_die"+".png"
            ));
    }
}
