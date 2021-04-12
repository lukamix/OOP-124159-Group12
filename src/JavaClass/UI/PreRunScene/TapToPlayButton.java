package JavaClass.UI.PreRunScene;

import JavaClass.GameManager.GameManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;
import javafx.animation.ScaleTransition;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TapToPlayButton extends Button {
    private final String FONT_LOCATION="src/Fonts/UVNNguyenDu.TTF";
    private int width =340;
    private int height =74;
    private float ScaleSize = 0.2f;
    public TapToPlayButton(){
        Init();
    }
    private void Init(){
        SetUserView();
        SetButtonSize();
        SetTapToPlayButtonOnClickEvent();
        SetAnimation();
    }
    private void SetUserView(){
        try{
            setFont(Font.loadFont(new FileInputStream(FONT_LOCATION),19));
            Image image=new Image(new FileInputStream("src/Resources/UI/MainMenu/mainmenu_text.png"),width,height,false,true);
            setPadding(Insets.EMPTY);
            BackgroundImage backgroundImage=new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);
            setBackground(new Background(backgroundImage));
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    private void SetButtonSize(){
        setPrefWidth(width);
        setPrefHeight(height);
    }
    private void SetAnimation(){
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.millis(1000));
        scaleTransition.setNode(this);
        scaleTransition.setByY(ScaleSize);
        scaleTransition.setByX(ScaleSize);
        scaleTransition.setCycleCount(20);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();
    }
    private void SetTapToPlayButtonOnClickEvent(){
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                OnTapToPlay();
            }
        });
    }
    private void OnTapToPlay(){
        GameManager.Instance.sceneManager.SwitchScene(GameManager.Instance.sceneManager.selectMapScene);
    }
}
