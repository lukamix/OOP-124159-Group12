package JavaClass.SceneManager;

import JavaClass.Entity.Player;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyHandler {
    public static void AddKeyListener(Scene scene, Player player){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.RIGHT || keyEvent.getCode() == KeyCode.D){
                    player.setRightButtonPressed(true);
                }
                else if (keyEvent.getCode() == KeyCode.LEFT || keyEvent.getCode() == KeyCode.A) {
                    player.setLeftButtonPressed(true);
                }
                else if (keyEvent.getCode() == KeyCode.SPACE){
                    player.setSpaceButtonPressed(true);
                }
                else if (keyEvent.getCode() == KeyCode.ENTER){
                    player.setEnterButtonPressed(true);
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.RIGHT || keyEvent.getCode() == KeyCode.D){
                    player.setRightButtonPressed(false);
                }
                else if (keyEvent.getCode() == KeyCode.LEFT || keyEvent.getCode() == KeyCode.A) {
                    player.setLeftButtonPressed(false);
                }
                else if (keyEvent.getCode() == KeyCode.SPACE){
                    player.setSpaceButtonPressed(false);
                }
                else if (keyEvent.getCode() == KeyCode.ENTER){
                    player.setEnterButtonPressed(false);
                }
            }
        });
    }
}
