package JavaClass.GameManager;

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
    public void GameLoop(){
        KeyFrame kf = new KeyFrame(Duration.seconds(0.017),
                actionEvent -> {
            // Handle GamePlay Here !
            System.out.println("loop");
        });
        gameLoop.setCycleCount(Animation.INDEFINITE);
        gameLoop.getKeyFrames().add(kf);
        gameLoop.play();
    }
    public void Init() throws FileNotFoundException {
        sceneManager =new SceneManager();
        sceneManager.Init();
    }
    public void doSomething(){

    }
}