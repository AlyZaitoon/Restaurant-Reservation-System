package sample;

import java.util.PrimitiveIterator;

public class Memento {
    private  int time;
    private int score;
    private  int noOfLives;
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Memento(int time, int score, int noOfLives,int level) {
        this.time = time;
        this.score = score;
        this.noOfLives = noOfLives;
        this.level=level;
    }
    public Memento(){}
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNoOfLives() {
        return noOfLives;
    }

    public void setNoOfLives(int noOfLives) {
        this.noOfLives = noOfLives;
    }




}
