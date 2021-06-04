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
    private Player player = new Player(bullet);
    private MushRoom mushroom = new MushRoom(player,bullet);
    private Egg egg = new Egg();
    private Chicken chicken = new Chicken(player,bullet,egg);
    private BatPig batpig = new BatPig(player,bullet);
    private MushRoom2 mushroom2 = new MushRoom2(player,bullet);
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
    private Coin[] coin = {new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player)
            ,new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player)
            ,new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player)
            ,new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player)
            ,new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player),new Coin(player)};
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
                    mushroom.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    chicken.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    batpig.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    mushroom2.Update(sceneManager.currentCanvas.getGraphicsContext2D());
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

                    //handle coin
                    for(int i = 0;i<4;i++){
                        if(!coin[i].getCoin()) {
                            coin[i].setPosition(new Vector2(520+i*50,550));
                            coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        }
                    }
                    for(int i = 4;i<8;i++){
                        if(!coin[i].getCoin()) {
                            coin[i].setPosition(new Vector2(1265+i*50,150));
                            coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        }
                    }
                    for(int i = 8;i<12;i++){
                        if(!coin[i].getCoin()) {
                            coin[i].setPosition(new Vector2(3300+i*50,180));
                            coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        }
                    }
                    for(int i = 12;i<16;i++){
                        if(!coin[i].getCoin()) {
                            coin[i].setPosition(new Vector2(3830+i*50,250));
                            coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        }
                    }
                    for(int i = 16;i<20;i++){
                        if(!coin[i].getCoin()) {
                            coin[i].setPosition(new Vector2(4450+i*50,250));
                            coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        }
                    }
                    for(int i = 20;i<24;i++){
                        if(!coin[i].getCoin()) {
                            coin[i].setPosition(new Vector2(4905+i*50,250));
                            coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        }
                    }
                    for(int i = 24;i<28;i++){
                        if(!coin[i].getCoin()) {
                            coin[i].setPosition(new Vector2(6070+i*40,480));
                            coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        }
                    }
                    for(int i = 28;i<32;i++){
                        if(!coin[i].getCoin()) {
                            coin[i].setPosition(new Vector2(6570+i*40,480));
                            coin[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        }
                    }
                    try{
                        sceneManager.currentCanvas.getGraphicsContext2D().drawImage(
                                new Image(new FileInputStream(
                                        "src/Resources/Textures/Assets/Coin/item_coin4.png"
                                )),200,0);
                    }catch(FileNotFoundException e){
                        e.printStackTrace();
                    }

                    //handle star
                    try{
                        if(!star[0].getStar()){
                            star[0].setPosition(new Vector2(1555,350));
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
                            star[2].setPosition(new Vector2(6200,580));
                            star[2].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                        }
                        else{
                            sceneManager.currentCanvas.getGraphicsContext2D().drawImage(
                                    new Image(new FileInputStream(
                                            "src/Resources/Textures/Assets/Star/star1.png"
                                    )),1120,5);
                        }
                    }catch(FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    //handle destiny
                    try{
                        if(player.getDestiny()>0){
                            sceneManager.currentCanvas.getGraphicsContext2D().drawImage(new Image(
                                    new FileInputStream("src/Resources/Textures/Textures/Assets/item_heart.png")),0,0);
                        }
                        if(player.getDestiny()>1){
                            sceneManager.currentCanvas.getGraphicsContext2D().drawImage(new Image(
                                    new FileInputStream("src/Resources/Textures/Textures/Assets/item_heart.png")),45,0);
                        }
                        if(player.getDestiny()>2){
                            sceneManager.currentCanvas.getGraphicsContext2D().drawImage(new Image(
                                    new FileInputStream("src/Resources/Textures/Textures/Assets/item_heart.png")),90,0);
                        }
                    }catch(FileNotFoundException e){
                        e.printStackTrace();
                    }
                    tree[0].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    tree[1].setPosition(new Vector2(2150,380));
                    tree[1].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    for(int i=2;i<5;i++){
                        tree[i].setDimension(new Vector2(150,300));
                    }
                    tree[2].setPosition(new Vector2(5000,280));
                    tree[2].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    tree[3].getAnimation().setFrames(Assets.Instance.treeImage[1]);
                    tree[3].setPosition(new Vector2(5630,330));
                    tree[3].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    tree[4].getAnimation().setFrames(Assets.Instance.treeImage[2]);
                    tree[4].setPosition(new Vector2(6200,280));
                    tree[4].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    tree[5].getAnimation().setFrames(Assets.Instance.treeImage[2]);
                    tree[5].setPosition(new Vector2(8200,350));
                    tree[5].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    checkPoint.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    if(player.getLocalPosition().x>8390){
                        flag.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    }
                    try{
                        s = Integer.toString(Coin.point);
                        sceneManager.currentCanvas.getGraphicsContext2D().setFont((Font.loadFont(new FileInputStream("src/Fonts/OpenSans/OpenSansRegular.ttf"),25)));
                        sceneManager.currentCanvas.getGraphicsContext2D().fillText(s,275,25);
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
        mushroom.tileMap = sceneManager.currentScene.tileMap;
        chicken.tileMap = sceneManager.currentScene.tileMap;
        batpig.tileMap = sceneManager.currentScene.tileMap;
        mushroom2.tileMap = sceneManager.currentScene.tileMap;
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
        for (int i = 0; i < 32; i++)
            coin[i].tileMap = sceneManager.currentScene.tileMap;
        for (int i = 0; i < 3; i++)
            star[i].tileMap = sceneManager.currentScene.tileMap;
        for (int i = 0; i < 6; i++)
            tree[i].tileMap = sceneManager.currentScene.tileMap;
    }
    public void StopGameLoop(){
        gameLoop.stop();
    }
    public void Init() throws FileNotFoundException {
        sceneManager = new SceneManager();
        sceneManager.Init();
    }
}

