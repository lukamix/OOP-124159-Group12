package JavaClass.SceneManager;

import Constant.SystemConstant;
import Scene.*;
import Scene.Zone1.Map1_1;
import Scene.Zone1.Map1_2;
import javafx.scene.Scene;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class SceneManager {
    public PreRunScene preRunScene;
    public LoadingScene loadingScene;
    public SelectMapScene selectMapScene;
    public Map1_1 map11;
    public Map1_2 map12;
    public AnchorPane[] anchorPane = new AnchorPane[SystemConstant.NUMBER_SCENE];
    public Stage mainStage;
    public void SwitchScene(Scene scene){
        mainStage.setScene(scene);
    }
    public void Init() throws FileNotFoundException {
        for(int i=0;i<SystemConstant.NUMBER_SCENE;i++){
            anchorPane[i] = new AnchorPane();
        }
        preRunScene = new PreRunScene(anchorPane[0],
                SystemConstant.SCREEN_WIDTH,SystemConstant.SCREEN_HEIGHT);
        loadingScene = new LoadingScene(anchorPane[1],
                SystemConstant.SCREEN_WIDTH,SystemConstant.SCREEN_HEIGHT);
        selectMapScene = new SelectMapScene(anchorPane[2],
                SystemConstant.SCREEN_WIDTH,SystemConstant.SCREEN_HEIGHT,1);
        map11 = new Map1_1(anchorPane[3],SystemConstant.SCREEN_WIDTH,SystemConstant.SCREEN_HEIGHT);
        map12 = new Map1_2(anchorPane[4],SystemConstant.SCREEN_WIDTH,SystemConstant.SCREEN_HEIGHT);
        mainStage = new Stage();
    }
}
