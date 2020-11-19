package sample;

import javafx.application.Platform;
import javafx.scene.text.Font;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class Timers {
Timer timer;
TimerState timerState;
int seconds;
Controller controller;
public Timers(Controller controller){
    this.controller=controller;
    timer=new Timer();
    timerState=new StartState();

}
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            if (seconds == 0 && controller.model.player.getTime() != 0) {
                seconds += controller.model.player.getTime();
            }
            seconds++;

            Platform.runLater(() -> controller.animation.label3.setText("TIME:"+String.valueOf(seconds)));
            controller.animation.label3.setFont(Font.font(20));
            controller.model.player.setTime(seconds);
            if (seconds % 10 == 0) {
                controller.model.careTaker.addMemento(controller.model.player.save());
            }
            if (seconds % 30 == 0) {
                try {
                    controller.model.save();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (TransformerException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    };
public void setTimerState(TimerState timerState){
    this.timerState=timerState;
}
public void Change(){timerState.change(this);}
public void stop(){
    timer.cancel();
}
public void start(){
    timer.scheduleAtFixedRate(timerTask, 1000, 1000);
}

}
