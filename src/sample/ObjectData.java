package sample;

import javafx.scene.layout.BackgroundImage;

public interface ObjectData {
        //public abstract ObjectData getObjectType();

        public int getXlocation();

        public int getYlocation();

        public int getMaxHeight();

        public boolean isSliced();

        public BackgroundImage getImage();

}
