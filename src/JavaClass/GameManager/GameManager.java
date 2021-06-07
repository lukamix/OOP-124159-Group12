package JavaClass.GameManager;

import Constant.SystemConstant;
import JavaClass.Entity.*;
import JavaClass.SceneManager.KeyHandler;
import JavaClass.SceneManager.SceneManager;
import JavaClass.Sprites.Assets;
import Utils.Vector2;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameManager {
    String s;
    public static GameManager Instance = new GameManager();
    public SceneManager sceneManager;
    private Timeline gameLoop = new Timeline();
    private Bullet bullet = new Bullet();
    public Player player = new Player(bullet);

    private MushRoom[] mushroom = {
            new MushRoom(player,bullet,new Vector2(380,575),new Vector2(380,575),480,280),
            new MushRoom(player,bullet,new Vector2(1455,190),new Vector2(1455,190),1630,1455),
            new MushRoom(player,bullet,new Vector2(480,610),new Vector2(300,610),480,300),
            new MushRoom(player,bullet,new Vector2(1560,340),new Vector2(1560,340),1560,1220),
            new MushRoom(player,bullet,new Vector2(2060,670),new Vector2(2060,670),2060,1780),//4
            new MushRoom(player,bullet,new Vector2(10500,220),new Vector2(10500,220),10500,9870),
            new MushRoom(player,bullet,new Vector2(8280,570),new Vector2(8200,570),8280,7900),
            new MushRoom(player,bullet,new Vector2(9190,580),new Vector2(9190,580),9190,8740),
            new MushRoom(player,bullet,new Vector2(4950,400),new Vector2(4950,400),4950,4350),//8
            new MushRoom(player,bullet,new Vector2(1400,310),new Vector2(1400,310),1400,1295),
            new MushRoom(player,bullet,new Vector2(2130,550),new Vector2(2130,550),2130,2000),
            new MushRoom(player,bullet,new Vector2(4850,400),new Vector2(4850,400),5260,4850),//11
                                        };

    private Egg egg = new Egg();
    private MushRoom2[] mushroom2 = {
            new MushRoom2(player,bullet,new Vector2(630,580),new Vector2(630,580),630,300),
            new MushRoom2(player,bullet,new Vector2(930,520),new Vector2(930,520),930,780),
            new MushRoom2(player,bullet,new Vector2(810,550),new Vector2(810,550),810,660),//2
            new MushRoom2(player,bullet,new Vector2(10260,585),new Vector2(10260,585),10260,9860),
            new MushRoom2(player,bullet,new Vector2(5070,640),new Vector2(5070,640),5070,4880),
            new MushRoom2(player,bullet,new Vector2(7300,520),new Vector2(7300,520),7300,6960),
            new MushRoom2(player,bullet,new Vector2(9060,460),new Vector2(9060,460),9060,8890),//6
            new MushRoom2(player,bullet,new Vector2(3300,550),new Vector2(3300,550),3300,3145),//7
            new MushRoom2(player,bullet,new Vector2(1630,190),new Vector2(1630,190),1630,1455),
            new MushRoom2(player,bullet,new Vector2(3850,220),new Vector2(3850,220),3850,3730),
            new MushRoom2(player,bullet,new Vector2(5550,610),new Vector2(5550,610),5550,5200),//10
    };

    private Chicken[] chicken = {new Chicken(player,bullet,egg,new Vector2(7500,500),new Vector2(7500,500),7500,7300)};

    private BatPig[] batpig = {new BatPig(player,bullet,new Vector2(1250,300),new Vector2(1250,300),1250,1000),
                                new BatPig(player,bullet,new Vector2(3250,300),new Vector2(3250,300),3250,3000),
                                 new BatPig(player,bullet,new Vector2(1330,350),new Vector2(1330,350),1330,1130)};

    private Frog[] frog ={ new Frog(player,bullet,new Vector2(4850,400),new Vector2(4850,400),4950,4750)};

    private BulletMonster bulletMonster = new BulletMonster();

    private Aborigine[] aborigine = {new Aborigine(player,bullet,bulletMonster,new Vector2(8150,550),new Vector2(8150,550),8150,7950),
                                     new Aborigine(player,bullet,bulletMonster,new Vector2(10350,555),new Vector2(10350,555),10350,10150)};

    private Woodpecker woodpecker = new Woodpecker(player,bullet);
    private BeeHive beehive = new BeeHive(player);
    private Bee bee = new Bee(player,bullet);
    private UglyBird uglyBird = new UglyBird(player);
    private SpeedLine speedLine = new SpeedLine();
    private Flag flag = new Flag();
    private CheckPoint[] checkPoint = {new CheckPoint(),new CheckPoint(),new CheckPoint()};
    private Gold gold = new Gold();
    private Vulture[] vulture = {new Vulture(player,bullet,new Vector2(2900,370),new Vector2(2900,370),2900,2700),
                                 new Vulture(player,bullet,new Vector2(4300,390),new Vector2(4800,390),4800,4600),
                                 new Vulture(player,bullet,new Vector2(4500,370),new Vector2(4500,370),4500,4300),
                                 new Vulture(player,bullet,new Vector2(5600,375),new Vector2(5600,375),5600,5400),
                                 new Vulture(player,bullet,new Vector2(6300,350),new Vector2(6300,350),6300,6100)};
    public Coin[] coin = {new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player)
            ,new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player)
            ,new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player)
            ,new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player)
            ,new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player)
            ,new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player)
            ,new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player)};
    private Star[] star = {new Star(player),new Star(player),new Star(player)};
    private Tree[] tree = {new Tree(),new Tree(),new Tree(),new Tree(),new Tree(),new Tree()};
    private Grass grass = new Grass();

    public void GameLoop() {
        InitGameLoop();
        KeyFrame kf = new KeyFrame(Duration.seconds(SystemConstant.FPS),
                actionEvent -> {
                    sceneManager.currentCanvas.getGraphicsContext2D().clearRect(0, 0, SystemConstant.SCREEN_WIDTH, SystemConstant.SCREEN_HEIGHT);
                    sceneManager.currentScene.Update(player,sceneManager.currentCanvas.getGraphicsContext2D());
                    player.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    PostRender.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    if(uglyBird.getAttack()){
                        speedLine.setPosition(new Vector2(uglyBird.getLocalPosition().x+2*uglyBird.getCollideBox().x,
                                uglyBird.getLocalPosition().y));
                        speedLine.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    }
                    uglyBird.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    if(player.getAttack()) {
                        bullet.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    }

                    //handle map1

                     if (sceneManager.currentScene == sceneManager.map1[0]){
                         //handle monster
                         mushroom[0].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         mushroom[1].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         mushroom[9].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         mushroom[10].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         mushroom[11].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         mushroom2[1].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         mushroom2[9].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         mushroom2[10].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         batpig[0].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         batpig[1].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         frog[0].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         beehive.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         if(player.getCollideBeeHive()){
                             bee.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         }
                         tree[0].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         tree[1].setPosition(new Vector2(2275,343));
                         tree[1].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         for(int i=2;i<5;i++){
                             tree[i].setDimension(new Vector2(150,300));
                         }
                         tree[2].setPosition(new Vector2(5000,274));
                         tree[2].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         //handle coin
                         for(int i = 0;i<4;i++){
                             if(!coin[i].getCoin()) {
                                 coin[i].setPosition(new Vector2(520 + i * 50, 570));
                                 coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                             }
                         }
                         for(int i = 4;i<8;i++){
                             if(!coin[i].getCoin()) {
                                 coin[i].setPosition(new Vector2(1030 + i * 50, 300));
                                 coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                             }
                         }
                         for(int i = 8;i<12;i++){
                             if(!coin[i].getCoin()) {
                                 coin[i].setPosition(new Vector2(1060 + i * 50, 180));
                                 coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                             }
                         }
                         for(int i = 12;i<17;i++){
                             if(!coin[i].getCoin()) {
                                 coin[i].setPosition(new Vector2(1140 + i * 50, 550));
                                 coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                             }
                         }
                         for(int i = 17;i<21;i++){
                             if(!coin[i].getCoin()) {
                                 coin[i].setPosition(new Vector2(2489 + i * 50, 275));
                                 coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                             }
                         }
                         for(int i = 21;i<25;i++){
                             if(!coin[i].getCoin()) {
                                 coin[i].setPosition(new Vector2(2650 + i * 50, 218));
                                 coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                             }
                         }
                         for(int i = 25;i<29;i++){
                             if(!coin[i].getCoin()) {
                                 coin[i].setPosition(new Vector2(2809 + i * 50, 285));
                                 coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                             }
                         }
                         for(int i = 29;i<33;i++){
                             if(!coin[i].getCoin()) {
                                 coin[i].setPosition(new Vector2(3740 + i * 50, 600));
                                 coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                             }
                         }

                         //handle star
                         try{
                             if(!star[0].getStar()){
                                 star[0].setPosition(new Vector2(1535,500));
                                 star[0].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                             }else{
                                 sceneManager.currentCanvas.getGraphicsContext2D().drawImage(
                                         new Image(new FileInputStream(
                                                 "src/Resources/Textures/Assets/Star/star2.png"
                                         )),1000,5);
                             }
                             if(!star[1].getStar()){
                                 star[1].setPosition(new Vector2(2800,220));
                                 star[1].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                             }else{
                                 sceneManager.currentCanvas.getGraphicsContext2D().drawImage(
                                         new Image(new FileInputStream(
                                                 "src/Resources/Textures/Assets/Star/star.png"
                                         )),1060,0);
                             }
                             if(!star[2].getStar()){
                                 star[2].setPosition(new Vector2(5500,580));
                                 star[2].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                             }
                             else{
                                 sceneManager.currentCanvas.getGraphicsContext2D().drawImage(
                                         new Image(new FileInputStream(
                                                 "src/Resources/Textures/Assets/Star/star1.png")),1120,5);
                             }
                         }catch(FileNotFoundException e) {
                             e.printStackTrace();
                         }
                         checkPoint[0].setPosition(new Vector2(5665,470));
                         checkPoint[0].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         if(player.getLocalPosition().x>5665){
                             flag.setPosition(new Vector2(5655,470));
                             flag.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         }

                     }
                    //handle map 2

                    if (sceneManager.currentScene == sceneManager.map1[1]){
                        //handle monster

                        mushroom[2].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom[3].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom[4].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom[5].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom[6].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom[7].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom2[2].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom2[3].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom2[4].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom2[5].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom2[6].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom2[7].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        vulture[0].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        vulture[1].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        vulture[2].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        vulture[3].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        vulture[4].Update(sceneManager.currentCanvas.getGraphicsContext2D());



                        chicken[0].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        if(chicken[0].getAttack()){
                            egg.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        }
                        batpig[2].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        aborigine[0].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        if(aborigine[0].getAttack()){
                            bulletMonster.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        }
                        aborigine[1].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        if(aborigine[1].getAttack()){
                            bulletMonster.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        }
                        woodpecker.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        grass.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        tree[0].setPosition(new Vector2(150,437));
                        tree[0].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        tree[1].setPosition(new Vector2(7850,406));
                        tree[1].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        //handle coin map3
                        for(int i = 0;i<4;i++){
                            if(!coin[i].getCoin()) {
                                coin[i].setPosition(new Vector2(640 + i * 50, 540));
                                coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                            }
                        }
                        for(int i = 4;i<10;i++){
                            if(!coin[i].getCoin()) {
                                    coin[i].setPosition(new Vector2(1068 + i * 50, 340));
                                    coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                            }
                        }
                        for(int i = 10;i<14;i++){
                            if(!coin[i].getCoin()) {
                                        coin[i].setPosition(new Vector2(1319 + i * 50, 670));
                                        coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                            }
                        }
                        for(int i = 14;i< 18;i++){
                            if(!coin[i].getCoin()) {
                                coin[i].setPosition(new Vector2(1800 + i * 50, 488));
                                coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                            }
                        }
                        for(int i = 18;i<22;i++){
                            if(!coin[i].getCoin()) {
                                coin[i].setPosition(new Vector2(2252 + i * 50, 540));
                                coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                            }
                        }
                        for(int i = 22;i< 26;i++){
                            if(!coin[i].getCoin()) {
                                coin[i].setPosition(new Vector2(3130 + i * 50, 375));
                                coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                            }
                        }
                        for(int i = 26;i<32;i++){
                            if(!coin[i].getCoin()) {
                                coin[i].setPosition(new Vector2(5700 + i * 50, 516));
                                coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                            }
                        }
                        for(int i = 32;i<36;i++){
                            if(!coin[i].getCoin()) {
                                coin[i].setPosition(new Vector2(7295 + i * 50, 450));
                                coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                            }
                        }for(int i = 36;i<42;i++){
                            if(!coin[i].getCoin()) {
                                coin[i].setPosition(new Vector2(8400 + i * 50, 570));
                                coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                            }
                        }
                        //handle star map 3
                        try{
                            if(!star[0].getStar()){
                                star[0].setPosition(new Vector2(1400,300));
                                star[0].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                            }else{
                                sceneManager.currentCanvas.getGraphicsContext2D().drawImage(
                                        new Image(new FileInputStream(
                                                "src/Resources/Textures/Assets/Star/star2.png"
                                        )),1000,5);
                            }
                            if(!star[1].getStar()){
                                star[1].setPosition(new Vector2(2400,670));
                                star[1].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                            }else{
                                sceneManager.currentCanvas.getGraphicsContext2D().drawImage(
                                        new Image(new FileInputStream(
                                                "src/Resources/Textures/Assets/Star/star.png"
                                        )),1060,0);
                            }
                            if(!star[2].getStar()){
                                star[2].setPosition(new Vector2(10450,540));
                                star[2].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                            }
                            else{
                                sceneManager.currentCanvas.getGraphicsContext2D().drawImage(
                                        new Image(new FileInputStream(
                                                "src/Resources/Textures/Assets/Star/star1.png")),1120,5);
                            }
                        }catch(FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        checkPoint[1].setPosition(new Vector2(10500,180));
                        checkPoint[1].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        if(player.getLocalPosition().x>10500){
                            flag.setPosition(new Vector2(10490,180));
                            flag.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        }

                    }
                    //handle map3_boss
                    if (sceneManager.currentScene == sceneManager.map1[2]){
                        gold.setPosition(new Vector2(3080,365));
                        gold.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        if(player.getLocalPosition().x>3080){
                            PostRender2.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        }

                    }
                    //handle destiny
                    try{
                        if(player.getDestiny()>0){
                            sceneManager.currentCanvas.getGraphicsContext2D().drawImage(new Image(
                                    new FileInputStream("src/Resources/Textures/Textures/Assets/item_heart.png")),0,15);
                        }
                        if(player.getDestiny()>1){
                            sceneManager.currentCanvas.getGraphicsContext2D().drawImage(new Image(
                                    new FileInputStream("src/Resources/Textures/Textures/Assets/item_heart.png")),45,15);
                        }
                        if(player.getDestiny()>2){
                            sceneManager.currentCanvas.getGraphicsContext2D().drawImage(new Image(
                                    new FileInputStream("src/Resources/Textures/Textures/Assets/item_heart.png")),90,15);
                        }
                    }catch(FileNotFoundException e){
                        e.printStackTrace();
                    }
                    try{
                        s = Integer.toString(Coin.point);
                        sceneManager.currentCanvas.getGraphicsContext2D().setFont((Font.loadFont(new FileInputStream("src/Fonts/OpenSans/OpenSansRegular.ttf"),35)));
                        sceneManager.currentCanvas.getGraphicsContext2D().fillText(s,278,53);
                        s = Integer.toString(Player.countBullet);
                        sceneManager.currentCanvas.getGraphicsContext2D().fillText(s,528,53);
                    }catch(FileNotFoundException e){
                        e.printStackTrace();
                    }
                    try {
                        sceneManager.currentCanvas.getGraphicsContext2D().drawImage(new Image(
                                new FileInputStream("src/Resources/Textures/bullet.png")),420,15);
                    }catch (FileNotFoundException e){
                        e.printStackTrace();
                    }
                });
        gameLoop.setCycleCount(Animation.INDEFINITE);
        gameLoop.getKeyFrames().add(kf);
        gameLoop.play();
    }
    public void InitGameLoop() {
        KeyHandler.AddKeyListener(sceneManager.currentScene, player);
        player.tileMap = sceneManager.currentScene.tileMap;
        bullet.tileMap = sceneManager.currentScene.tileMap;
        egg.tileMap = sceneManager.currentScene.tileMap;
        flag.tileMap = sceneManager.currentScene.tileMap;
        bulletMonster.tileMap = sceneManager.currentScene.tileMap;
        beehive.tileMap = sceneManager.currentScene.tileMap;
        bee.tileMap = sceneManager.currentScene.tileMap;
        uglyBird.tileMap = sceneManager.currentScene.tileMap;
        speedLine.tileMap = sceneManager.currentScene.tileMap;
        for (int i = 0; i < 42; i++)
            coin[i].tileMap = sceneManager.currentScene.tileMap;
        for (int i = 0; i < 3; i++)
            star[i].tileMap = sceneManager.currentScene.tileMap;
        for (int i = 0; i < 12; i++)
            mushroom[i].tileMap = sceneManager.currentScene.tileMap;
        for (int i = 0; i < 11; i++)
            mushroom2[i].tileMap = sceneManager.currentScene.tileMap;
        for (int i = 0; i < 3; i++)
            batpig[i].tileMap = sceneManager.currentScene.tileMap;
        for (int i = 0; i < 3; i++)
            checkPoint[i].tileMap = sceneManager.currentScene.tileMap;
        for (int i = 0; i < 1; i++)
            frog[i].tileMap = sceneManager.currentScene.tileMap;
        for (int i = 0; i < 1; i++)
            chicken[i].tileMap = sceneManager.currentScene.tileMap;
        for (int i = 0; i < 2; i++)
            aborigine[i].tileMap = sceneManager.currentScene.tileMap;
        for (int i = 0; i < 5; i++)
            vulture[i].tileMap = sceneManager.currentScene.tileMap;
        for (int i = 0; i < 6; i++)
            tree[i].tileMap = sceneManager.currentScene.tileMap;
        woodpecker.tileMap = sceneManager.currentScene.tileMap;
        grass.tileMap = sceneManager.currentScene.tileMap;
        gold.tileMap = sceneManager.currentScene.tileMap;


    }
    public void StopGameLoop(){
        gameLoop.stop();
    }
    public void Init() throws FileNotFoundException {
        sceneManager = new SceneManager();
        sceneManager.Init();
    }
}
