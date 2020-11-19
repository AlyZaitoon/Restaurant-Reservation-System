package sample;

public class Player {
    private int noOfLives=3;
    private int score=0;
    private int time;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private int level;
    public void setNoOfLives(int noOfLives) {
        this.noOfLives = noOfLives;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    public Player() {
        this.noOfLives = 3;
        this.score = 0;
        this.time=0;
    }
    public int getScore() {
        return score;
    }


    public int getNoOfLives() {        return noOfLives;
    }
    public Memento save(){
        return new Memento(time,score,noOfLives,level);
    }
    public void Load(Memento memento){
        score=memento.getScore();
        time=memento.getTime();
        noOfLives=memento.getNoOfLives();
        level=memento.getLevel();
    }
}
