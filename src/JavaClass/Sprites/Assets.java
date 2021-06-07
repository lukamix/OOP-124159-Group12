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
    public Image[][] vultureImage = new Image[2][15];
    public Image[][] mushroom2Image = new Image[3][15];
    public Image[][] frogImage = new Image[2][15];
    public Image[][] aborigineImage = new Image[3][20];
    public Image[][] woodpeckerImage = new Image[2][14];
    public Image[] starImage = new Image[10];
    public Image[] beeHiveImage = new Image[11];
    public Image[] beeImage = new Image[15];
    public Image[] uglyBirdImage = new Image[11];
    public Image[] bulletMonsterImage = new Image[2];
    public Image[] eggImage = new Image[2];
    public Image[] bulletImage = new Image[2];
    public Image[] flagImage = new Image[10];
    public Image[] speedLineImage = new Image[2];
    public Image[] coinImage = new Image[5];
    public Image[] zone1 = new Image[100];
    public Image[][] treeImage = new Image[3][2];
    public Image[] grassImage = new Image[2];
    public Image[] checkPointImage = new Image[2];
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
        InitFrogImage();
        InitAborigineImage();
        InitWoodPeckerImage();
        InitStarImage();
        InitTreeImage();
        InitBeeHiveImage();
        InitBeeImage();
        InitBulletMonsterImage();
        InitGrassImage();
        InitEggImage();
        InitUglyBirdImage();
        InitSpeedLineImage();
        InitFlagImage();
        InitVultureImage();
        InitCheckPointImage();
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
        for(int i=0;i<13;i++){
            playerImage[2][i] = new Image(new FileInputStream("src/Resources/Textures/Character Player/Orc/jump/main_character_jump_up"+i+".png"));
        }
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
        for(int i=0;i<4;i++) {
            coinImage[i] = new Image(new FileInputStream(
                    "src/Resources/Textures/Assets/Coin/item_coin" + i + ".png"));
        }
        /*
        coinImage[0] = new Image(new FileInputStream(
                "src/Resources/Textures/Assets/Coin/item_coin0.png"));
        coinImage[1] = new Image(new FileInputStream(
                "src/Resources/Textures/Assets/Coin/item_coin1.png"));
        coinImage[2] = new Image(new FileInputStream(
                "src/Resources/Textures/Assets/Coin/item_coin2.png"));
        coinImage[3] = new Image(new FileInputStream(
                "src/Resources/Textures/Assets/Coin/item_coin3.png"));

         */
    }
    public void InitStarImage() throws FileNotFoundException {
        starImage[0] = new Image(new FileInputStream(
                "src/Resources/Textures/Assets/Star/star2.png"
        ));
        starImage[1] = new Image(new FileInputStream(
                "src/Resources/Textures/Assets/Star/star.png"
        ));
        starImage[2] = new Image(new FileInputStream(
                "src/Resources/Textures/Assets/Star/star1.png"
        ));
        starImage[3] = new Image(new FileInputStream(
                "src/Resources/Textures/Assets/Star/star.png"
        ));
    }
    public void InitTreeImage() throws FileNotFoundException{
        treeImage[0][0] = new Image(new FileInputStream(
                "src/Resources/Textures/Textures/Tiles/Deco/deco1.png"
        ));
        treeImage[1][0] = new Image(new FileInputStream(
                "src/Resources/Textures/Textures/Tiles/Deco/deco2.png"
        ));
        treeImage[2][0] = new Image(new FileInputStream(
                "src/Resources/Textures/Textures/Tiles/Deco/deco3.png"
        ));
    }
    public void InitFrogImage() throws FileNotFoundException{
        for(int i=0;i<14;i++){
            frogImage[0][i] = new Image( new FileInputStream(
                    "src/Resources/Textures/Monster Enemy/Monsters/Frog/monster7_move"+i+".png"));
        }
        frogImage[1][0] = new Image(new FileInputStream(
                "src/Resources/Textures/Monster Enemy/Monsters/Frog/monster7_die"+".png"
        ));
    }
    public void InitAborigineImage() throws FileNotFoundException{
        for(int i=0;i<9;i++){
            aborigineImage[0][i] = new Image( new FileInputStream(
                    "src/Resources/Textures/Monster Enemy/Monsters/Aborigine/move/aborigine_move"+i+".png"));
        }
        for(int i=0;i<20;i++){
            aborigineImage[1][i] = new Image( new FileInputStream(
                    "src/Resources/Textures/Monster Enemy/Monsters/Aborigine/attack/aborigine_attack"+i+".png"));
        }
        aborigineImage[2][0] = new Image( new FileInputStream(
                "src/Resources/Textures/Monster Enemy/Monsters/Aborigine/Die/aborigine_die"+".png"));
    }
    public void InitWoodPeckerImage() throws FileNotFoundException{
        for(int i=0;i<14;i++){
            woodpeckerImage[0][i] = new Image( new FileInputStream(
                    "src/Resources/Textures/Monster Enemy/Monsters/Woodpecker/monster5_idle"+i+".png"));
        }
        woodpeckerImage[1][0] = new Image(new FileInputStream(
                "src/Resources/Textures/Monster Enemy/Monsters/Woodpecker/monster5_die"+".png"
        ));
    }
    public void InitBeeHiveImage() throws FileNotFoundException{
        for(int i=0;i<10;i++){
            beeHiveImage[i] = new Image( new FileInputStream(
                    "src/Resources/Textures/Monster Enemy/Monsters/Bee/BeeHive/monster12_"+(i+1)+".png"));
        }
    }
    public void InitBeeImage() throws FileNotFoundException{
        for(int i=0;i<12;i++){
            beeImage[i] = new Image( new FileInputStream(
                    "src/Resources/Textures/Monster Enemy/Monsters/Bee/monster12_bullet/monster12_bullet"+i+".png"));
        }
    }
    public void InitBulletMonsterImage() throws FileNotFoundException{
        bulletMonsterImage[0] = new Image(new FileInputStream(
                "src/Resources/Textures/Monster Enemy/Monsters/Aborigine/axe.png"
        ));
    }
    public void InitGrassImage() throws FileNotFoundException{
        grassImage[0] = new Image(new FileInputStream(
                "src/Resources/Textures/Textures/Tiles/Deco/deco8.png"
        ));
    }
    public void InitEggImage() throws FileNotFoundException{
        eggImage[0] = new Image(new FileInputStream(
                "src/Resources/Textures/Monster Enemy/Monsters/Chicken/egg.png"
        ));
    }
    public void InitUglyBirdImage() throws FileNotFoundException{
        for(int i = 0;i<10;i++){
            uglyBirdImage[i] = new Image(new FileInputStream(
                    "src/Resources/Textures/Monster Enemy/Monsters/UglyBird/monster9_fly"+ i+".png"
            ));
        }
    }
    public void InitSpeedLineImage() throws FileNotFoundException{
        speedLineImage[0] = new Image(new FileInputStream(
                "src/Resources/Textures/Monster Enemy/Monsters/UglyBird/speedline.png"
        ));
    }
    public void InitFlagImage() throws FileNotFoundException{
        for(int i = 0;i<9;i++){
            flagImage[i] = new Image(new FileInputStream(
                    "src/Resources/Textures/Textures/Assets/Flag/flag"+ (i+1)+".png"
            ));
        }
    }
    public void InitVultureImage() throws FileNotFoundException{
        for(int i=0;i<10;i++){
            vultureImage[0][i] = new Image( new FileInputStream(
                    "src/Resources/Textures/Monster Enemy/Monsters/Vulture/Fly/vulture_fly"+i+".png"));
        }
        vultureImage[1][0] = new Image(new FileInputStream(
                "src/Resources/Textures/Monster Enemy/Monsters/Vulture/Die/vulture_die"+".png"
        ));
    }
    public void InitCheckPointImage() throws FileNotFoundException{
        checkPointImage[0] = new Image(new FileInputStream(
                "src/Resources/Textures/Textures/Character/checkpoint2.png"
        ));
    }
}
