package sample;

import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;

public class Model {

    Fruit objectData1;
    ObjectData objectData2;
    Game gameCreation;
    Game game;
    int index;
    int i;
    Player player;
    SaveToFile save;
    CareTaker careTaker;
    ArrayList<Memento> arrayList;
    private ArrayList<Fruit> generatedFruits = new ArrayList<>();
    private ArrayList<Bomb> generatedBombs = new ArrayList<>();

    public ArrayList<Fruit> getGeneratedFruits() {
        return generatedFruits;
    }

    public void setGeneratedFruits(ArrayList<Fruit> generatedFruits) {
        this.generatedFruits = generatedFruits;
    }

    public ArrayList<Bomb> getGeneratedBombs() {
        return generatedBombs;
    }

    public void setGeneratedBombs(ArrayList<Bomb> generatedBombs) {
        this.generatedBombs = generatedBombs;
    }

    public Model() throws IOException, ParserConfigurationException, org.xml.sax.SAXException {

        gameCreation = Game.getInstance();
        gameCreation.intialize();
        objectData1 = new Fruit();
        objectData2 = new Bomb();
        save = new SaveToFile();
        careTaker = new CareTaker();
        player = new Player();
        arrayList = save.loadGame();


//        if (!(arrayList.isEmpty()))
//            player.Load(arrayList.get(arrayList.size() - 1));




        generatedFruits.add( getFruit(0));
        generatedFruits.add( getFruit(1));
        generatedFruits.add( getFruit(2));
        generatedFruits.add( getFruit(3));
        generatedFruits.add( getFruit(4));
        generatedFruits.add( getFruit(5));
        generatedFruits.add( getFruit(6));
        generatedFruits.add( getFruit(7));
        generatedFruits.add( getFruit(8));
        generatedFruits.add( getFruit(0));
        generatedBombs.add(getBomb(0));
        generatedBombs.add(getBomb(1));
        generatedBombs.add(getBomb(2));
        generatedBombs.add(getBomb(3));
        generatedBombs.add(getBomb(4));
        generatedBombs.add(getBomb(5));

    }
    public void setBest ( int BestScore)
    {
        gameCreation.setBestScore(BestScore);
    }
    public int getBest ()
    {
        return gameCreation.getBestScore();
    }

    public void save() throws ParserConfigurationException, TransformerException, IOException, org.xml.sax.SAXException {
        save.saveGame(careTaker.getArrayList());
        careTaker.getArrayList().clear();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Fruit getFruit(int index) {

        return Game.getInstance().getFruits().get(index);

    }

    public Bomb getBomb(int index) {

        return Game.getInstance().getBombs().get(index);

    }
    public void setPlayer(){
         if(arrayList.get(arrayList.size() - 1).getNoOfLives()>0)
            player.Load(arrayList.get(arrayList.size() - 1));
        else {
             player = new Player();
             player.setLevel(arrayList.get(arrayList.size() - 1).getLevel());
         }


    }
    public void delete(){
        save.delete();
    }
    public void load() throws ParserConfigurationException, SAXException, IOException {arrayList.clear(); arrayList = save.loadGame(); for(int i=0;i<arrayList.size();i++){
        if(arrayList.get(i).getScore()>gameCreation.getBestScore())
            gameCreation.setBestScore(arrayList.get(i).getScore());
    }}
}