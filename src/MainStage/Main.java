package MainStage;

import JavaClass.GameManager.GameManager;
import JavaClass.SceneManager.SceneManager;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        InitGameManager();
        SettingStage(primaryStage);
    }
    public void InitGameManager() throws FileNotFoundException {
        GameManager.Instance.Init();
    }
    public void SettingStage(Stage primaryStage) throws FileNotFoundException {
        primaryStage = GameManager.Instance.sceneManager.mainStage;
        primaryStage.setScene(GameManager.Instance.sceneManager.preRunScene);
        primaryStage.setTitle("Mario");
        primaryStage.getIcons().add(new Image(new FileInputStream("src/Resources/UI/Icon/logo.png")));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
