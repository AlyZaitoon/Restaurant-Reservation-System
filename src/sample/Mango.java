package sample;

import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class Mango extends Fruit {


    public Mango() {
        this.setImage(new BackgroundImage( new Image( getClass().getResource("/sample/new_mango.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));
        this.setSlicedImage(new BackgroundImage( new Image( getClass().getResource("/sample/slicedmango2.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));

    }


}
