package JavaClass.UI.SelectMapScene.Button;

import JavaClass.GameManager.GameManager;
import JavaClass.UI.Decorator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Set;

public class LevelButton extends Button {
    private Text levelText;
    private Image backGround;
    private Decorator backGroundView;
    private StarDisplay starDisplay;
    public double x = 0; //x =vertical
    public double y = 0; //y = horizontal
    int buttonname;
    public LevelButton(AnchorPane anchorPane,double x,double y,int buttonname) throws FileNotFoundException {
        Init(anchorPane,x,y,buttonname);
    }
    private void Init(AnchorPane anchorPane,double x,double y,int buttonname) throws FileNotFoundException {
        backGround = new Image(new FileInputStream("src/Resources/UI/SelectMapScene/Button/GUI_MAP_level.png"),62,50,false,true);
        backGroundView = new Decorator(backGround,62,50);
        this.buttonname = buttonname;
        setGraphic(backGroundView);
        setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 3px; " +
                        "-fx-min-height: 3px; " +
                        "-fx-max-width: 3px; " +
                        "-fx-max-height: 3px;"
        );
        SetPosition(anchorPane,x,y);
        SetButtonOnClickEvent();
        SetStarDisplay(anchorPane);
    }
    public void SetPosition(AnchorPane anchorPane,double x,double y){
        anchorPane.getChildren().add(this);
        AnchorPane.setLeftAnchor(this,x);
        AnchorPane.setTopAnchor(this,y);
        this.x =x;
        this.y =y;
    }
    public void SetTextButton(AnchorPane anchorPane,int level) throws FileNotFoundException {
        levelText = new Text(Integer.toString(level));

        AnchorPane.setTopAnchor(levelText,y-70);
        if(level<=9)
            AnchorPane.setLeftAnchor(levelText,x-15);
        else
            AnchorPane.setLeftAnchor(levelText,x-30);
        Font font = Font.loadFont(new FileInputStream("src/Fonts/UVNNguyenDu.TTF"), 50);
        levelText.setFont(font);
        levelText.setFill(Color.WHITE);
        anchorPane.getChildren().add(levelText);
        levelText.setViewOrder(1);
    }
    public void SetStarDisplay(AnchorPane anchorPane) throws FileNotFoundException {
        starDisplay = new StarDisplay();
        AnchorPane.setLeftAnchor(starDisplay,x-55);
        AnchorPane.setTopAnchor(starDisplay,y+25);
        anchorPane.getChildren().add(starDisplay);
        starDisplay.setViewOrder(2);
    }
    private void SetButtonOnClickEvent(){
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("hi");
                OnButtonClick();
            }
        });
    }
    private void OnButtonClick(){
        int offSetScene = 3;
        switch (buttonname){
            case 0:{
                GameManager.Instance.sceneManager.SwitchScene(GameManager.Instance.sceneManager.map11);
                GameManager.Instance.sceneManager.setCurrentScene(GameManager.Instance.sceneManager.map11);
                break;
            }
            case 1:{
                GameManager.Instance.sceneManager.SwitchScene(GameManager.Instance.sceneManager.map12);
                GameManager.Instance.sceneManager.setCurrentScene(GameManager.Instance.sceneManager.map12);
                break;
            }
            default:{
                break;
            }
        }
        GameManager.Instance.sceneManager.setCurrentCanvas(buttonname+offSetScene);
        GameManager.Instance.GameLoop();
    }
}
