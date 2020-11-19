package sample;

import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;

public  class Fruit  implements ObjectData {
    private int xLocation;
    private int yLoaction;
    private BackgroundImage image;
    private BackgroundImage slicedImage;
    private boolean isSliced;
    private int maxHeight;

    public BackgroundImage getImage() {
        return image;
    }

    public BackgroundImage getSlicedImage() {
        return slicedImage;
    }

    public void setSlicedImage(BackgroundImage slicedImage) {
        this.slicedImage = slicedImage;
    }

    public void setImage(BackgroundImage image) {
        this.image = image;
    }

    public Fruit() {
        this.xLocation = 0;
        this.yLoaction = 0;
        this.isSliced = false;
    }


    public int getXlocation() {
        return xLocation;
    }

    public void setXLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    public int getYlocation() {
        return yLoaction;
    }

    public void setYLoaction(int yLoaction) {
        this.yLoaction = yLoaction;
    }


    @Override
    public int getMaxHeight() {
        return maxHeight;
    }

    public boolean isSliced() {
        return isSliced;
    }

    public void setSliced(boolean sliced) {
        isSliced = sliced;
    }




}
