package sample;

import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class FatalBomb extends Bomb{
    public FatalBomb() {
        this.setImage(new BackgroundImage( new Image( getClass().getResource("/sample/boom.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));
        this.setSlicedImage(new BackgroundImage( new Image( getClass().getResource("/sample/Explosion1.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));

    }
}
