package sample;

import javafx.animation.PathTransition;

import java.util.ArrayList;

public interface IStrategy {
    void time(ArrayList<PathTransition> pathTransition);
}
