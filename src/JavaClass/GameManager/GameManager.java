package JavaClass.GameManager;

import Constant.SystemConstant;
import JavaClass.Entity.BatPig;
import JavaClass.Entity.Chicken;
import JavaClass.Entity.MushRoom;
import JavaClass.Entity.Player;
import JavaClass.SceneManager.KeyHandler;
import JavaClass.SceneManager.SceneManager;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.io.FileNotFoundException;

public class GameManager {
    public static GameManager Instance = new GameManager();
    public SceneManager sceneManager;
    private Timeline gameLoop = new Timeline();
    private Player player = new Player();
    private MushRoom mr = new MushRoom(player);
    private Chicken ck = new Chicken(player);
    private BatPig pb = new BatPig(player);

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
    }
    public void StopGameLoop(){
        gameLoop.stop();
    }
    public void Init() throws FileNotFoundException {
        sceneManager = new SceneManager();
        sceneManager.Init();
    }
}

