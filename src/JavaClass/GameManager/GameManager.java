package JavaClass.GameManager;

import Constant.SystemConstant;
import JavaClass.Entity.*;
import JavaClass.SceneManager.KeyHandler;
import JavaClass.SceneManager.SceneManager;
import Utils.Vector2;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameManager {
    public static GameManager Instance = new GameManager();
    public SceneManager sceneManager;
    private Timeline gameLoop = new Timeline();
    private Bullet bl = new Bullet();
    private Player player = new Player(bl);
    private MushRoom mr = new MushRoom(player,bl);
    private Chicken ck = new Chicken(player,bl);
    private BatPig pb = new BatPig(player,bl);
    private MushRoom2 mr2 = new MushRoom2(player,bl);
    private Coin[] c = {new Coin(player),new Coin(player),new Coin(player),new Coin(player)};

    public void GameLoop() {
        InitGameLoop();
        KeyFrame kf = new KeyFrame(Duration.seconds(SystemConstant.FPS),
            actionEvent -> {
                sceneManager.currentCanvas.getGraphicsContext2D().clearRect(0, 0, SystemConstant.SCREEN_WIDTH, SystemConstant.SCREEN_HEIGHT);
                sceneManager.currentScene.Update(player,sceneManager.currentCanvas.getGraphicsContext2D());
                player.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                mr.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                ck.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                pb.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                mr2.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                if(player.getAttack()) {
                    bl.Update(sceneManager.currentCanvas.getGraphicsContext2D());
                }
                for(int i = 0;i<4;i++){
                    if(!c[i].getCoin()) {
                        c[i].setPosition(new Vector2(520 + i * 50, 550));
                        c[i].Update(sceneManager.currentCanvas.getGraphicsContext2D());
                    }
                }
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
            });
        gameLoop.setCycleCount(Animation.INDEFINITE);
        gameLoop.getKeyFrames().add(kf);
        gameLoop.play();
    }
    public void InitGameLoop(){
        KeyHandler.AddKeyListener(sceneManager.currentScene,player);
        player.tileMap = sceneManager.currentScene.tileMap ;
        mr.tileMap = sceneManager.currentScene.tileMap ;
        ck.tileMap = sceneManager.currentScene.tileMap ;
        pb.tileMap = sceneManager.currentScene.tileMap;
        mr2.tileMap = sceneManager.currentScene.tileMap;
        bl.tileMap = sceneManager.currentScene.tileMap;
        for(int i=0;i<4;i++)
        c[i].tileMap = sceneManager.currentScene.tileMap;
    }
    public void StopGameLoop(){
        gameLoop.stop();
    }
    public void Init() throws FileNotFoundException {
        sceneManager = new SceneManager();
        sceneManager.Init();
    }
}

