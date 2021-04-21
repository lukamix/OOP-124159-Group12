package JavaClass.SceneManager;

import Constant.SystemConstant;
import Scene.*;
import Scene.Zone1.Map1_3;
import Scene.Zone1.MapWithTile;
import Scene.Zone1.Map1_1;
import Scene.Zone1.Map1_2;
import javafx.scene.Scene;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class SceneManager {
    public PreRunScene preRunScene;
    public LoadingScene loadingScene;
    public SelectMapScene selectMapScene;
    public MapWithTile[] map1 = new MapWithTile[15];
    private AnchorPane[] anchorPane = new AnchorPane[SystemConstant.NUMBER_SCENE];
    public Canvas[] canvas = new Canvas[SystemConstant.NUMBER_SCENE];
    public Canvas currentCanvas;
    public MapWithTile currentScene;
    public Stage mainStage;
    public void SwitchScene(Scene scene){
        mainStage.setScene(scene);
    }
    public void Init() throws FileNotFoundException {
        for(int i=0;i<SystemConstant.NUMBER_SCENE;i++){
            anchorPane[i] = new AnchorPane();
            if(i>2){
                canvas[i] = new Canvas(SystemConstant.SCREEN_WIDTH,SystemConstant.SCREEN_WIDTH);
                anchorPane[i].getChildren().add(canvas[i]);
            }
        }
        preRunScene = new PreRunScene(anchorPane[0],
                SystemConstant.SCREEN_WIDTH,SystemConstant.SCREEN_HEIGHT);
        loadingScene = new LoadingScene(anchorPane[1],
                SystemConstant.SCREEN_WIDTH,SystemConstant.SCREEN_HEIGHT);
        selectMapScene = new SelectMapScene(anchorPane[2],
                SystemConstant.SCREEN_WIDTH,SystemConstant.SCREEN_HEIGHT,1);
        map1[0] = new Map1_1(anchorPane[3],SystemConstant.SCREEN_WIDTH,SystemConstant.SCREEN_HEIGHT);
        map1[1] = new Map1_2(anchorPane[4],SystemConstant.SCREEN_WIDTH,SystemConstant.SCREEN_HEIGHT);
        map1[2] = new Map1_3(anchorPane[5],SystemConstant.SCREEN_WIDTH,SystemConstant.SCREEN_HEIGHT);
        //map1[...] = new Map1_...(anchorPane[3+...],SystemConstant.SCREEN_WIDTH,SystemConstant.SCREEN_HEIGHT)
        mainStage = new Stage();
    }
    public void setCurrentCanvas(int index){
        currentCanvas = canvas[index];
    }
    public void setCurrentScene(MapWithTile scene){
        currentScene = scene;
    }
}
