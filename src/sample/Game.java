package sample;

import java.util.ArrayList;

public class Game   implements GameCreation{
    private static Game obj;
    private FruitFactory fruitFactory=new FruitFactory();
    private BombsFactory bombFactory=new BombsFactory();
    private int bestScore;



    private ArrayList<Fruit> fruits=new ArrayList();
    private ArrayList<Bomb> bombs=new ArrayList();
    private Game(){}
    public static Game getInstance(){
        if(obj==null)
            obj=new Game();
        return obj;
    }
    public void intialize(){
        fruits.add(fruitFactory.getFruit("mango"));
        fruits.add(fruitFactory.getFruit("watermelon"));
        fruits.add(fruitFactory.getFruit("banana"));
        fruits.add(fruitFactory.getFruit("mango"));
        fruits.add(fruitFactory.getFruit("watermelon"));
        fruits.add(fruitFactory.getFruit("banana"));
        fruits.add(fruitFactory.getFruit("mango"));
        fruits.add(fruitFactory.getFruit("watermelon"));
        fruits.add(fruitFactory.getFruit("banana"));
        bombs.add(bombFactory.create("fatalbomb"));
        bombs.add(bombFactory.create("dangerousbomb"));
        bombs.add(bombFactory.create("fatalbomb"));
        bombs.add(bombFactory.create("dangerousbomb"));
        bombs.add(bombFactory.create("fatalbomb"));
        bombs.add(bombFactory.create("dangerousbomb"));
        bestScore=0;
    }


    @Override
    public Game createGameObject() {
        return  getInstance();
    }

    @Override
    public void ResetGame() {
        obj=null;

    }
    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }
    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
    }

    public ArrayList<Bomb> getBombs() {
        return bombs;
    }

    public void setBombs(ArrayList<Bomb> bombs) {
        this.bombs = bombs;
    }


}
