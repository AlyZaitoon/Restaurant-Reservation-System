package sample;

import java.util.Timer;

public class StopState implements TimerState {
    @Override
    public void change(Timers timer) {
        timer.stop();
    }
}
