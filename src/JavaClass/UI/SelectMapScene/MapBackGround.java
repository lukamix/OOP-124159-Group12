package JavaClass.UI.SelectMapScene;

import Constant.SystemConstant;
import JavaClass.UI.Decorator;
import JavaClass.UI.SelectMapScene.Button.LevelButton;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MapBackGround extends Decorator {
    LevelButton[] levelButton;
    public MapBackGround(AnchorPane anchorPane,String url) throws FileNotFoundException {
        super();
        this.setViewOrder(3);
        width = 1160;
        height = 640;
        Image image = new Image(new FileInputStream(url),width,height,false,true);
        Init(image);
        InitLevelButton(anchorPane);
    }
    void InitLevelButton(AnchorPane anchorPane) throws FileNotFoundException {
        levelButton = new LevelButton[SystemConstant.NUMBER_LEVEL_EACH_ZONE];
        for(int i=0;i<levelButton.length;i++){
            levelButton[i] = new LevelButton(
                    anchorPane,SystemConstant.ZONE1BUTTONPOSITION[i][0],SystemConstant.ZONE1BUTTONPOSITION[i][1],i);
            levelButton[i].setViewOrder(2);
            levelButton[i].SetTextButton(anchorPane,i+1);
        }
    }
}
