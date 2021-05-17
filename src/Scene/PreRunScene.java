package Scene;

import JavaClass.UI.PreRunScene.EnemyDecorator;
import JavaClass.UI.PreRunScene.PlayerDecorator;
import JavaClass.UI.PreRunScene.ShadowDecorator;
import JavaClass.UI.PreRunScene.TapToPlayButton;
import Scene.Zone1.MapWithTile;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PreRunScene extends MapWithTile {

    public PreRunScene(AnchorPane anchorPane, double width, double height) throws FileNotFoundException {
        super(anchorPane, width, height);
        Init(anchorPane);
    }

    private void Init(AnchorPane anchorPane) throws FileNotFoundException {
        AddBackGround(anchorPane);
        AddButtonTapToPlay(anchorPane);
        AddPlayerDecorator(anchorPane);
        AddEnemyDecorator(anchorPane);
        AddShadowDecorator(anchorPane,120,690);
        AddShadowDecorator(anchorPane,220,240);
    }
    private void AddBackGround(AnchorPane anchorPane)  throws FileNotFoundException {
        Image background=new Image(new FileInputStream("src/Resources/UI/MainMenu/mainmenu_bg.png"),1200,675,false,true);
        BackgroundImage backgroundImage=new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);
        anchorPane.setBackground(new Background(backgroundImage));
    }
    private void AddButtonTapToPlay(AnchorPane anchorPane){
        TapToPlayButton button = new TapToPlayButton();
        anchorPane.getChildren().add(button);
        AnchorPane.setBottomAnchor(button,50.0);
        AnchorPane.setLeftAnchor(button,480.0);
    }
    private void AddPlayerDecorator(AnchorPane anchorPane) throws FileNotFoundException {
        PlayerDecorator playerDecorator = new PlayerDecorator();
        anchorPane.getChildren().add(playerDecorator);
        AnchorPane.setBottomAnchor(playerDecorator,180.0);
        AnchorPane.setLeftAnchor(playerDecorator,240.0);
    }
    private void AddEnemyDecorator(AnchorPane anchorPane) throws FileNotFoundException{
        EnemyDecorator enemyDecorator = new EnemyDecorator();
        anchorPane.getChildren().add(enemyDecorator);
        AnchorPane.setBottomAnchor(enemyDecorator,300.0);
        AnchorPane.setRightAnchor(enemyDecorator,240.0);
    }
    private void AddShadowDecorator(AnchorPane anchorPane,double bottomanchor,double rightanchor) throws FileNotFoundException{
        ShadowDecorator shadowDecorator = new ShadowDecorator();
        anchorPane.getChildren().add(shadowDecorator);
        AnchorPane.setBottomAnchor(shadowDecorator,bottomanchor);
        AnchorPane.setRightAnchor(shadowDecorator,rightanchor);
    }
}
