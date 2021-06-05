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


           // new MushRoom(player,bullet,new Vector2())
    };

    private Egg egg = new Egg();
    private Chicken chicken = new Chicken(player,bullet,egg);
    private BatPig batpig = new BatPig(player,bullet);
    private MushRoom2[] mushroom2 = {
            new MushRoom2(player,bullet,new Vector2(630,580),new Vector2(630,580),630,300),
            new MushRoom2(player,bullet,new Vector2(930,520),new Vector2(930,520),930,780),
            new MushRoom2(player,bullet,new Vector2(810,550),new Vector2(810,550),810,660),//2
            new MushRoom2(player,bullet,new Vector2(10260,585),new Vector2(10260,585),10260,9860),
            new MushRoom2(player,bullet,new Vector2(5070,640),new Vector2(5070,640),5070,4880),
            new MushRoom2(player,bullet,new Vector2(7300,520),new Vector2(7300,520),7300,6960),
            new MushRoom2(player,bullet,new Vector2(9060,465),new Vector2(9060,465),9060,8890),//6
            new MushRoom2(player,bullet,new Vector2(3300,550),new Vector2(3300,550),3300,3145),//7
            new MushRoom2(player,bullet,new Vector2(1630,190),new Vector2(1630,190),1630,1455),
            new MushRoom2(player,bullet,new Vector2(3850,220),new Vector2(3850,220),3850,3730),
            new MushRoom2(player,bullet,new Vector2(5550,610),new Vector2(5550,610),5550,5200),//10

    };
    private Frog frog = new Frog(player,bullet);
    private BulletMonster bulletMonster = new BulletMonster();
    private Aborigine aborigine = new Aborigine(player,bullet,bulletMonster);
    private Woodpecker woodpecker = new Woodpecker(player,bullet);
    private BeeHive beehive = new BeeHive(player);
    private Bee bee = new Bee(player,bullet);
    private UglyBird uglyBird = new UglyBird(player);
    private SpeedLine speedLine = new SpeedLine();
    private Flag flag = new Flag();
    private CheckPoint checkPoint = new CheckPoint();
    private Vulture vulture = new Vulture(player,bullet);
    public Coin[] coin = {new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player)
            ,new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player)
            ,new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player)
            ,new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player)
            ,new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player)
            ,new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player)
            ,new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player)};
    private Star[] star = {new Star(player),new Star(player),new Star(player)};
    private Grass grass = new Grass();
    public void GameLoop() {
        InitGameLoop();
        KeyFrame kf = new KeyFrame(Duration.seconds(SystemConstant.FPS),
                actionEvent -> {
                    sceneManager.currentCanvas.getGraphicsContext2D().clearRect(0, 0, SystemConstant.SCREEN_WIDTH, SystemConstant.SCREEN_HEIGHT);
                    sceneManager.currentScene.Update(player,sceneManager.currentCanvas.getGraphicsContext2D());
                    player.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    chicken.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    batpig.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    frog.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    aborigine.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    vulture.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    PostRender.Update(sceneManager.currentCanvas.getGraphicsContext2D());

                    if(uglyBird.getAttack()){
                        speedLine.setPosition(new Vector2(uglyBird.getLocalPosition().x+2*uglyBird.getCollideBox().x,
                                uglyBird.getLocalPosition().y));
                        speedLine.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    }
                    uglyBird.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    if(aborigine.getAttack()){
                        bulletMonster.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    }
                    if(chicken.getAttack()){
                        egg.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    }
                    woodpecker.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    beehive.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    if(player.getCollideBeeHive()){
                        bee.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    }
                    if(player.getAttack()) {
                        bullet.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    }
                    grass.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    //handle map1
                     if (sceneManager.currentScene == sceneManager.map1[0]){
                         //handle monster
                         mushroom[0].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         mushroom[1].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         mushroom[9].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         mushroom[10].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         mushroom[11].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         mushroom2[0].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         mushroom2[1].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         mushroom2[8].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         mushroom2[9].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                         mushroom2[10].Update(sceneManager.currentCanvas.getGraphicsContext2D());
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
                                 coin[i].setPosition(new Vector2(3600 + i * 50, 600));
                                 coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                             }
                         }

                         try{
                             sceneManager.currentCanvas.getGraphicsContext2D().drawImage(
                                     new Image(new FileInputStream(
                                             "src/Resources/Textures/Assets/Coin/item_coin4.png")),200,0);
                         }
                             catch(FileNotFoundException e){
                             e.printStackTrace();
                         }

                         //handle star
                         try{
                             if(!star[0].getStar()){
                                 star[0].setPosition(new Vector2(1555,570));
                                 star[0].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                             }else{
                                 sceneManager.currentCanvas.getGraphicsContext2D().drawImage(
                                         new Image(new FileInputStream(
                                                 "src/Resources/Textures/Assets/Star/star2.png"
                                         )),1000,5);
                             }
                             if(!star[1].getStar()){
                                 star[1].setPosition(new Vector2(2500,320));
                                 star[1].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                             }else{
                                 sceneManager.currentCanvas.getGraphicsContext2D().drawImage(
                                         new Image(new FileInputStream(
                                                 "src/Resources/Textures/Assets/Star/star.png"
                                         )),1060,0);
                             }
                             if(!star[2].getStar()){
                                 star[2].setPosition(new Vector2(3600,580));
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

                     }
                    //handle map3
                    if (sceneManager.currentScene == sceneManager.map1[2]) {
                    //handle monster
                        mushroom[2].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom[3].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom[4].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom[5].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom[6].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom[7].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom[8].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom2[2].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom2[3].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom2[4].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom2[5].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom2[6].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        mushroom2[7].Update(sceneManager.currentCanvas.getGraphicsContext2D());
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
                    }catch(FileNotFoundException e){
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
        chicken.tileMap = sceneManager.currentScene.tileMap;
        batpig.tileMap = sceneManager.currentScene.tileMap;
        frog.tileMap = sceneManager.currentScene.tileMap;
        aborigine.tileMap = sceneManager.currentScene.tileMap;
        woodpecker.tileMap = sceneManager.currentScene.tileMap;
        bullet.tileMap = sceneManager.currentScene.tileMap;
        egg.tileMap = sceneManager.currentScene.tileMap;
        flag.tileMap = sceneManager.currentScene.tileMap;
        bulletMonster.tileMap = sceneManager.currentScene.tileMap;
        beehive.tileMap = sceneManager.currentScene.tileMap;
        bee.tileMap = sceneManager.currentScene.tileMap;
        grass.tileMap = sceneManager.currentScene.tileMap;
        uglyBird.tileMap = sceneManager.currentScene.tileMap;
        speedLine.tileMap = sceneManager.currentScene.tileMap;
        vulture.tileMap = sceneManager.currentScene.tileMap;
        checkPoint.tileMap = sceneManager.currentScene.tileMap;
        for (int i = 0; i < 42; i++)
            coin[i].tileMap = sceneManager.currentScene.tileMap;
        for (int i = 0; i < 3; i++)
            star[i].tileMap = sceneManager.currentScene.tileMap;
        for (int i = 0; i < 12; i++)
            mushroom[i].tileMap = sceneManager.currentScene.tileMap;
        for (int i = 0; i < 11; i++)
            mushroom2[i].tileMap = sceneManager.currentScene.tileMap;


    }
    public void StopGameLoop(){
        gameLoop.stop();
    }
    public void Init() throws FileNotFoundException {
        sceneManager = new SceneManager();
        sceneManager.Init();
    }
}
