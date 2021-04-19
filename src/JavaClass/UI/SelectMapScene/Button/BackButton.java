package JavaClass.UI.SelectMapScene.Button;

import JavaClass.GameManager.GameManager;
import JavaClass.UI.Decorator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BackButton extends Button {
    private Image backGround;
    private Decorator backGroundView;
    public BackButton(AnchorPane anchorPane,double x,double y) throws FileNotFoundException{
        Init(anchorPane,x,y);
    }
    private void Init(AnchorPane anchorPane, double x, double y) throws FileNotFoundException {
        backGround = new Image(new FileInputStream("src/Resources/UI/SelectMapScene/Button/button_back.png"),84,77,false,true);
        backGroundView = new Decorator(backGround,84,77);
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
    }
    public void SetPosition(AnchorPane anchorPane,double x,double y){
        anchorPane.getChildren().add(this);
        AnchorPane.setLeftAnchor(this,x);
        AnchorPane.setTopAnchor(this,y);
    }
    private void SetButtonOnClickEvent(){
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                OnButtonClick();
            }
        });
    }
    private void OnButtonClick(){
        GameManager.Instance.sceneManager.SwitchScene(GameManager.Instance.sceneManager.preRunScene);
    }
}
