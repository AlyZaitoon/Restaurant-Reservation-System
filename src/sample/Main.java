package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main extends Application {
Timeline timeline;
Timers timer;
int flag=0;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller controller = new Controller();

        controller.generateFruits();
        controller.generatedBombs();
        primaryStage.setScene(controller.animation.choose());
        primaryStage.setResizable(false);
        controller.updateBackgrounds();
        controller.animation.labelBestScore.setText("BEST SCORE:"+ Integer.toString(controller.model.getBest()));

        EventHandler event=new EventHandler() {
            @Override
            public void handle(Event event) {
                controller.animation.removeTransitions();
                controller.updateLocations();
                if(controller.model.getBest()<controller.model.player.getScore())
                {
                    controller.model.setBest(controller.model.player.getScore());
                    controller.animation.labelBestScore.setText( "Best Score:"+Integer.toString(controller.model.player.getScore()));
                    flag=1;
                }
                if(controller.animation.flag==1){
                    try {
                        controller.model.careTaker.addMemento(controller.model.player.save());
                        controller.model.save();
                    } catch (ParserConfigurationException e) {
                        e.printStackTrace();
                    } catch (TransformerException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (SAXException e) {
                        e.printStackTrace();
                    }
                    timer.setTimerState(new StopState());
                    timer.Change();
                    if(flag==0)
                        JOptionPane.showMessageDialog(null, "Game over");
                    else
                        JOptionPane.showMessageDialog(null, "YOU WON !!");
                    timeline.stop();
                    try {
                        controller.model.load();
                    } catch (ParserConfigurationException e) {
                        e.printStackTrace();
                    } catch (SAXException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    primaryStage.setScene(controller.animation.scene2);
                }





                EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        Button o=(Button)e.getSource();
                        controller.animation.sliceObjects(o);
           }
                };

                for (int i = 0; i <4; i++) {
                    controller.animation.btns.get(i).addEventFilter(MouseEvent.MOUSE_EXITED_TARGET, eventHandler);
                }
                for (int i = 0; i <2; i++) {
                    controller.animation.btnsB.get(i).addEventFilter(MouseEvent.MOUSE_EXITED_TARGET, eventHandler);
                }
            }

        };
        controller.animation.button4.setOnAction(e->{
            controller.model.player=new Player();
            controller.animation.player= controller.model.player;
            controller.model.delete();
            controller.animation.labelLives.setText("Lives: "+controller.animation.player.getNoOfLives());
            controller.animation.label1.setText("SCORE:"+controller.model.player.getScore());

            controller.model.gameCreation.setBestScore(0);
            controller.animation.labelBestScore.setText( "Best Score:"+Integer.toString(controller.model.player.getScore()));
            primaryStage.setScene(controller.animation.scene1);


        });
        controller.animation.button5.setOnAction(e->{
            try{
                flag=0;
                controller.model.load();
            controller.model.setPlayer();
                controller.play();
                controller.animation.labelLives.setText("Lives: "+controller.animation.player.getNoOfLives());
                controller.animation.label1.setText("SCORE:"+controller.model.player.getScore());
                controller.animation.labelBestScore.setText("Best Score:"+Integer.toString(controller.model.gameCreation.getBestScore()));
                timer=new Timers(controller);
                timer.Change();
                if(controller.model.player.getLevel()==1){
                    controller.animation.button();
                    primaryStage.setScene(controller.animation.scene);
                    KeyFrame f=new KeyFrame(Duration.seconds(6),event);
                    timeline=new Timeline();
                    timeline.getKeyFrames().add(f);
                    timeline.setCycleCount(Timeline.INDEFINITE);
                    timeline.play();
                }
                else if(controller.model.player.getLevel()==2){
                    controller.animation.button2();
                    primaryStage.setScene(controller.animation.scene);
                    KeyFrame f=new KeyFrame(Duration.seconds(4),event);
                    timeline=new Timeline();
                    timeline.getKeyFrames().add(f);
                    timeline.setCycleCount(Timeline.INDEFINITE);
                    timeline.play();}
                else{ controller.animation.button3();
                    primaryStage.setScene(controller.animation.scene);
                    KeyFrame f=new KeyFrame(Duration.seconds(2),event);
                    timeline=new Timeline();
                    timeline.getKeyFrames().add(f);
                    timeline.setCycleCount(Timeline.INDEFINITE);
                    timeline.play();
                }
            }
            catch (Exception q){
                JOptionPane.showMessageDialog(null, "No data to load");
            }

        });
        controller.animation.button1.setOnAction(e->{
            controller.animation.button();
                    primaryStage.setScene(controller.animation.scene);
            timer=new Timers(controller);
            timer.Change();
            KeyFrame f=new KeyFrame(Duration.seconds(6),event);
            timeline=new Timeline();
            timeline.getKeyFrames().add(f);
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();

                }
        );
        controller.animation.button2.setOnAction(e->{
            controller.animation.button2();
                    primaryStage.setScene(controller.animation.scene);
            timer=new Timers(controller);
            timer.Change();
            KeyFrame f=new KeyFrame(Duration.seconds(4),event);
            timeline=new Timeline();
            timeline.getKeyFrames().add(f);
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
                }
        );
        controller.animation.button3.setOnAction(e->{
            controller.animation.button3();
                    primaryStage.setScene(controller.animation.scene);
            timer=new Timers(controller);
            timer.Change();
            KeyFrame f=new KeyFrame(Duration.seconds(2),event);
            timeline=new Timeline();
            timeline.getKeyFrames().add(f);
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
                }
        );
        primaryStage.setOnCloseRequest(windowEvent->{
            try {
                controller.model.careTaker.addMemento(controller.model.player.save());
                controller.model.save();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (TransformerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
                }
        );
          primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}