package sample;

public class BombsFactory {
    public Bomb create(String bombName) {
        Bomb bomb = null;
        if ("fatalbomb".equalsIgnoreCase(bombName)) {
            bomb = new FatalBomb();
        } else if ("dangerousbomb".equalsIgnoreCase(bombName)) {
            bomb = new DangerousBomb();
        }

        return bomb;

    }
}