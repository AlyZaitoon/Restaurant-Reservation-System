package sample;

import javafx.animation.PathTransition;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

public class Level2 implements IStrategy {


    @Override
    public void time(ArrayList<PathTransition> pathTransition) {
        for(int i=0;i<pathTransition.size();i++){
            pathTransition.get(i).setDuration(Duration.seconds(4));
            pathTransition.get(i).setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        }
    }
}
