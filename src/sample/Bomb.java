package sample;

import javafx.scene.layout.BackgroundImage;

public  class Bomb implements ObjectData {
    private int xLocation;
    private int yLoaction;
    private String type;
    private int lifeDimishing;
    private BackgroundImage Image;
    private BackgroundImage slicedImage;
    private boolean isSliced;
    private int maxHeight;


    public int getXlocation() {
        return xLocation;
    }

    public void setxLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    public int getYlocation() {
        return yLoaction;
    }

    @Override
    public int getMaxHeight() {
        return maxHeight;
    }

    @Override
    public boolean isSliced() {
        return isSliced;
    }

    public void setSliced(boolean sliced) {
        isSliced = sliced;
    }

    public void setyLoaction(int yLoaction) {
        this.yLoaction = yLoaction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLifeDimishing() {
        return lifeDimishing;
    }

    public void setLifeDimishing(int lifeDimishing) {
        this.lifeDimishing = lifeDimishing;
    }

    public BackgroundImage getImage() {
        return Image;
    }

    public void setImage(BackgroundImage image) {
        Image = image;
    }
    public BackgroundImage getSlicedImage() {
        return slicedImage;
    }

    public void setSlicedImage(BackgroundImage slicedImage) {
        this.slicedImage = slicedImage;
    }

}
