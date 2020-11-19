package sample;

import java.util.Timer;

public class StartState implements TimerState {

    @Override
    public void change(Timers timers) {
        timers.start();
    }
}
