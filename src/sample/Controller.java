package sample;

import org.xml.sax.SAXException;
import javafx.scene.control.Button;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;



public class Controller {

  Animation animation;
  Model model;


    public Controller() throws ParserConfigurationException, SAXException, IOException {
        this.animation = new Animation();
        this.model = new Model();
    }
    public void generateFruits(){
        animation.setF(model.getGeneratedFruits());
    }
    public void generatedBombs(){animation.setB(model.getGeneratedBombs());}
    public void play(){
        animation.setPlayer(model.player);
    }
    public void slice(Button o){
        animation.sliceObjects(o);
    }
    public void updateLocations(){
        animation.updateObjectStatus();
    }
    public void updateBackgrounds(){
        animation.updateBackground();
    }
    
}


