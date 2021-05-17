package JavaClass.UI.PreRunScene;

import JavaClass.UI.Decorator;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class AnimDecorator extends Decorator {
    protected void SetAnimation(){
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.millis(1000));
        translateTransition.setNode(this);
        translateTransition.setByY(30);
        translateTransition.setCycleCount(20);
        translateTransition.setAutoReverse(true);
        translateTransition.play();
    }
}
