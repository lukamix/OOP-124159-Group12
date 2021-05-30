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
    public Image[][] playerImage = new Image[7][20];
    public Image[][] mushroomImage = new Image[3][15];
    public Image[][] chickenImage = new Image[4][20];
    public Image[][] batPigImage = new Image[2][15];
    public Image[][] mushroom2Image = new Image[3][15];
    public Image[] bulletImage = new Image[2];
    public Image[] coinImage = new Image[5];
    public Image[] zone1 = new Image[100];
    public Assets() throws FileNotFoundException {
        Init();
    }
    public void Init() throws FileNotFoundException {
        InitZone1Image();
        InitPlayerImage();
        InitMushroomImage();
        InitChickenImage();
        InitBatPigImage();
        InitMushroom2Image();
        InitBulletImage();
        InitCoinImage();
    }
    public void InitZone1Image() throws FileNotFoundException {
        for(int i=1;i<=98;i++){
            zone1[i] = new Image (new FileInputStream("src/Resources/Textures/Textures/Tiles/Zone1/item"+i+".png"));
        }
    }
    public void InitPlayerImage() throws FileNotFoundException {
        for(int i=0;i<13;i++){
            playerImage[0][i] = new Image( new FileInputStream(
                    "src/Resources/Textures/Character Player/Orc/idle/main_character_idle"+i+".png"));
        }
        for(int i=0;i<14;i++){
            playerImage[1][i] = new Image( new FileInputStream(
                    "src/Resources/Textures/Character Player/Orc/move/main_character_move"+i+".png"));
        }
        playerImage[2][0] = new Image(new FileInputStream("src/Resources/Textures/Character Player/Orc/jump/main_character_jump.png"));
        for(int i=0;i<9;i++){
            playerImage[3][i] = new Image( new FileInputStream(
                    "src/Resources/Textures/Character Player/Orc/attack/main_character_attack"+i+".png"));
        }
        for(int i =0;i<12;i++){
            playerImage[4][i] = new Image( new FileInputStream(
                    "src/Resources/Textures/Character Player/Orc/die/main_character_die"+i+".png"));
        }
        playerImage[5][0] = new Image(new FileInputStream("src/Resources/Textures/Character Player/Orc/dame/main_character_dame.png"));
    }
    public void InitMushroomImage() throws FileNotFoundException{
        for(int i=0;i<14;i++){
            mushroomImage[0][i] = new Image( new FileInputStream(
                    "src/Resources/Textures/Monster Enemy/Monsters/Mushroom1/move/monster2_move"+i+".png"));
        }
        mushroomImage[1][0] = new Image(new FileInputStream(
                "src/Resources/Textures/Monster Enemy/Monsters/Mushroom1/damage/monster2_dame"+".png"
        ));
        mushroomImage[2][0] = new Image(new FileInputStream(
                "src/Resources/Textures/Monster Enemy/Monsters/Mushroom1/die/monster2_die"+".png"
        ));
    }
    public void InitChickenImage() throws FileNotFoundException{
        for(int i=0;i<15;i++){
            chickenImage[0][i] = new Image( new FileInputStream(
                    "src/Resources/Textures/Monster Enemy/Monsters/Chicken/move/monster6_move"+i+".png"));
        }
        for(int i=0;i<14;i++){
            chickenImage[1][i] = new Image( new FileInputStream(
                    "src/Resources/Textures/Monster Enemy/Monsters/Chicken/attack/monster6_attack"+i+".png"));
        }
        for(int i=0;i<13;i++){
            chickenImage[2][i] = new Image( new FileInputStream(
                    "src/Resources/Textures/Monster Enemy/Monsters/Chicken/idle/monster6_idle"+i+".png"));
        }
        chickenImage[3][0] = new Image( new FileInputStream(
                "src/Resources/Textures/Monster Enemy/Monsters/Chicken/dame/monster6_dame"+".png"));
    }
    public void InitBatPigImage() throws FileNotFoundException{
        for(int i=0;i<12;i++){
            batPigImage[0][i] = new Image( new FileInputStream(
                    "src/Resources/Textures/Monster Enemy/Monsters/BatPig/monster4_fly"+i+".png"));
        }
        batPigImage[1][0] = new Image(new FileInputStream(
                "src/Resources/Textures/Monster Enemy/Monsters/BatPig/monster4_die"+".png"
        ));
    }
    public void InitMushroom2Image() throws FileNotFoundException{
        for(int i=0;i<14;i++){
            mushroom2Image[0][i] = new Image( new FileInputStream(
                    "src/Resources/Textures/Monster Enemy/Monsters/Mushroom2/monster3_move"+i+".png"));
        }
        mushroom2Image[1][0] = new Image(new FileInputStream(
                "src/Resources/Textures/Monster Enemy/Monsters/Mushroom2/monster3_dame"+".png"
        ));
        mushroom2Image[2][0] = new Image(new FileInputStream(
                "src/Resources/Textures/Monster Enemy/Monsters/Mushroom2/monster3_die"+".png"
        ));
    }
    public void InitBulletImage() throws FileNotFoundException{
        bulletImage[0] = new Image(new FileInputStream(
                "src/Resources/Textures/bullet"+".png"
        ));
    }
    public void InitCoinImage() throws FileNotFoundException{
        coinImage[0] = new Image(new FileInputStream(
                "src/Resources/Textures/Assets/Coin/item_coin0.png"
        ));
        coinImage[1] = new Image(new FileInputStream(
                "src/Resources/Textures/Assets/Coin/item_coin1.png"));
        coinImage[2] = new Image(new FileInputStream(
                "src/Resources/Textures/Assets/Coin/item_coin2.png"));
        coinImage[3] = new Image(new FileInputStream(
                "src/Resources/Textures/Assets/Coin/item_coin3.png"));
    }
}
