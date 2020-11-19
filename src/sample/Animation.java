package sample;

import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Shape;
import javafx.scene.shape.VLineTo;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public  class Animation {
    IStrategy iStrategy;
    Label fruitNinja=new Label("Fruit Ninja");
    javafx.scene.control.Label label=new javafx.scene.control.Label();
    javafx.scene.control.Label labelLives=new javafx.scene.control.Label();
    javafx.scene.control.Label labelGameOver=new javafx.scene.control.Label();
    javafx.scene.control.Label labelBestScore=new javafx.scene.control.Label();
    int flag=0;
    Game game;
    int t=0;
    javafx.scene.control.Label label1=new Label();
    Player player;
    Label label3=new Label();
    int seconds;
    QuadCurve quadCurve;
    QuadCurve quadCurve2;
    QuadCurve quadCurve3;
    QuadCurve quadCurve4;
    QuadCurve quadCurve1B;
    QuadCurve quadCurve2B;
    QuadCurve quadCurve7;
    QuadCurve quadCurve8;
    QuadCurve quadCurve9;
    QuadCurve quadCurve10;
    QuadCurve quadCurve11;
    QuadCurve quadCurve12;

    ArrayList<QuadCurve> quadcurves;
    ArrayList<PathTransition> pathTransitions;
    ArrayList<Button> btns;
    ArrayList<QuadCurve> quadcurvesB;
    ArrayList<PathTransition> pathTransitionsB;
    ArrayList<Button> btnsB;
    ParallelTransition parallelTransition;
    ArrayList<Fruit> f;
    ArrayList<Bomb> b;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn10;
    Button btn1B;
    Button btn2B;
    Group animation;
    Scene scene;
   Random ok;
   Random h;
   Random w;
    ArrayList<Integer> indcies;
    Scene scene1;
    Scene scene2;
    Button button3;
    Button button2;
    Button button1;
    Button button4;
    Button button5;
    public void setPlayer(Player player) {
        this.player = player;
    }

    public Animation(){
         ok = new Random();
         h=new Random();
         w=new Random();
        animation = new Group();

        Group group=new Group();
        scene=new Scene(animation,500,500);
        scene.getStylesheets().add(getClass().getResource("game.css").toString());
        scene.getCursor();
        javafx.scene.image.Image image = new Image("/sample/HiNinja3.png");
        scene.setCursor(new ImageCursor(image));
        scene1=new Scene(group,500,500);
        javafx.scene.image.Image wallPaper1 = new javafx.scene.image.Image("/sample/scene1.jpg");
        scene1.getStylesheets().add(getClass().getResource("game.css").toString());
        ImageView iv1 = new ImageView();
        iv1.setImage( wallPaper1 );
        group.getChildren().add(iv1);
        button1=new Button("level 1");
        button2=new Button("level 2");
        button3=new Button("level 3");
        button1.setLayoutX(200);
        button2.setLayoutX(200);
        button3.setLayoutX(200);
        button1.setLayoutY(100);
        button2.setLayoutY(200);
        button3.setLayoutY(300);
        group.getChildren().addAll(button1,button2,button3);

       javafx.scene.image.Image wallPaper = new javafx.scene.image.Image("/sample/wallpaper.jpg");
       ImageView iv = new ImageView();
       iv.setImage( wallPaper );
       animation.getChildren().add(iv);

       animation.getChildren().add(label3);
       label3.setLayoutX(50);
       label3.setLayoutY(50);
        fruitNinja.setLayoutX(175);
        fruitNinja.setLayoutY(50);

       animation.getChildren().add(label);
       label.setLayoutX(30);
       label.setLayoutY(50);
       animation.getChildren().add(label1);
       label1.setLayoutX(140);
       label1.setLayoutY(50);
       label1.setFont(Font.font(20));
        animation.getChildren().add(labelLives);
        labelLives.setLayoutX(250);
        labelLives.setLayoutY(50);
        labelLives.setFont(Font.font(20));
        labelLives.setText("LIVES: 3");
        animation.getChildren().add(labelGameOver);
        labelGameOver.setLayoutX(100);
        labelGameOver.setLayoutY(200);
        labelGameOver.setFont(Font.font(60));
        animation.getChildren().add(labelBestScore);
        labelBestScore.setLayoutX(350);
        labelBestScore.setLayoutY(50);
        labelBestScore.setFont(Font.font(20));
       quadCurve = new QuadCurve(0, 400, 200, 50, 1000, 1000);
       quadCurve2 = new QuadCurve(3, 400, 200, -125, 1000, 1000);
       quadCurve3 = new QuadCurve(5, 400, 200, -50, 1000, 1000);
       quadCurve4 = new QuadCurve(7, 400, 200, 100, 1000, 1000);
       quadCurve1B = new QuadCurve(3, 400, 200, -150, 2000, 1000);
       quadCurve2B = new QuadCurve(5, 400, 200, -250, 3000, 1000);

      /* quadCurve7 = new QuadCurve(0, 400, 200, 200, 4000, 1000);
       quadCurve8 = new QuadCurve(3, 400, 200, 155, 5000, 1000);
       quadCurve9 = new QuadCurve(5, 400, 200, 200, 6000, 1000);
       quadCurve10 = new QuadCurve(5, 400, 200, 300, 7000, 1000);
       quadCurve11 = new QuadCurve(4, 400, 200, -300, 7000, 1000);
       quadCurve12 = new QuadCurve(3, 400, 200, 300, 7000, 1000);*/
        btn1 = new javafx.scene.control.Button();
        btn2 = new javafx.scene.control.Button();
        btn3 = new javafx.scene.control.Button();
        btn4 = new javafx.scene.control.Button();
       /* btn5 = new javafx.scene.control.Button();
        btn6 = new javafx.scene.control.Button();
        btn7 = new javafx.scene.control.Button();
        btn8 = new javafx.scene.control.Button();
        btn9 = new javafx.scene.control.Button();
        btn10 = new javafx.scene.control.Button();*/
        btn1B = new javafx.scene.control.Button();
        btn2B = new javafx.scene.control.Button();

       btn1.setLayoutX(-100);
       btn2.setLayoutX(-100);
       btn3.setLayoutX(-100);
       btn4.setLayoutX(-100);
       /*btn5.setLayoutX(-100);
       btn6.setLayoutX(-100);
       btn7.setLayoutX(-100);
       btn8.setLayoutX(-100);
       btn9.setLayoutX(-100);
       btn10.setLayoutX(-100);*/
       btn1B.setLayoutX(-100);
       btn2B.setLayoutX(-100);



       indcies= new ArrayList<>();
       btns = new ArrayList<>();
        btnsB = new ArrayList<>();
       quadcurves = new ArrayList<>();
        quadcurvesB = new ArrayList<>();
       pathTransitions = new ArrayList<>();
        pathTransitionsB = new ArrayList<>();

       quadcurves.add(quadCurve);
       quadcurves.add(quadCurve2);
       quadcurves.add(quadCurve3);
       quadcurves.add(quadCurve4);
       quadcurvesB.add(quadCurve1B);
       quadcurvesB.add(quadCurve2B);
      /* quadcurves.add(quadCurve7);
       quadcurves.add(quadCurve8);
       quadcurves.add(quadCurve9);
       quadcurves.add(quadCurve10);
       quadcurves.add(quadCurve11);
       quadcurves.add(quadCurve12);*/





       // btn11=new Button();
       // btn12=new Button();



       parallelTransition = new ParallelTransition();
       btn1.setMinSize(200, 200);
       btn2.setMinSize(200, 200);
       btn3.setMinSize(200, 200);
       btn4.setMinSize(200, 200);
      /* btn5.setMinSize(200, 200);
       btn6.setMinSize(200, 200);
       btn7.setMinSize(200, 200);
       btn8.setMinSize(200, 200);
       btn9.setMinSize(200, 200);
       btn10.setMinSize(200, 200);*/
       btn1B.setMinSize(200, 200);
       btn2B.setMinSize(200, 200);



       btns.add(btn1);
       btns.add(btn2);
       btns.add(btn3);
       btns.add(btn4);
      /* btns.add(btn5);
       btns.add(btn6);
       btns.add(btn7);
       btns.add(btn8);
       btns.add(btn9);
       btns.add(btn10);*/
       btnsB.add(btn1B);
       btnsB.add(btn2B);


       animation.getChildren().add(btn1);
       animation.getChildren().add(btn2);
       animation.getChildren().add(btn3);
       animation.getChildren().add(btn4);
      /* animation.getChildren().add(btn5);
       animation.getChildren().add(btn6);
       animation.getChildren().add(btn7);
       animation.getChildren().add(btn8);
       animation.getChildren().add(btn9);
       animation.getChildren().add(btn10);*/
       animation.getChildren().add(btn1B);
       animation.getChildren().add(btn2B);

       for(t=0;t<btns.size();t++)
       {
           pathTransitions.add(new PathTransition());

       }
        for(t=0;t<btnsB.size();t++)
        {
            pathTransitionsB.add(new PathTransition());

        }

       for(t=0;t<pathTransitions.size();t++)
       {
           pathTransitions.get(t).setPath(quadcurves.get(t));
       }
        for(t=0;t<pathTransitionsB.size();t++)
        {
            pathTransitionsB.get(t).setPath(quadcurvesB.get(t));
        }

       for(t=0;t<pathTransitions.size();t++)
       {
           pathTransitions.get(t).setNode(btns.get(t));
       }
        for(t=0;t<pathTransitionsB.size();t++)
        {
            pathTransitionsB.get(t).setNode(btnsB.get(t));
        }

//       for(t=0;t<pathTransitions.size();t++)
//       {
//           pathTransitions.get(t).setDuration(Duration.seconds(4));
//           pathTransitions.get(t).setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
//       }
//        for(t=0;t<pathTransitionsB.size();t++)
//        {
//            pathTransitionsB.get(t).setDuration(Duration.seconds(4));
//            pathTransitionsB.get(t).setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
//        }
   }

    public void updateObjectStatus(){
        flag=0;
        if(player.getNoOfLives() >0) {
            int i = 0;

            int types = ok.nextInt(4) + 1;
            int ty = h.nextInt(3);

            for (i = 0; i < indcies.size(); i++) {
                QuadCurve shape = (QuadCurve) pathTransitions.get(indcies.get(i)).getPath();
                if (shape.getEndX() - 100 > pathTransitions.get(indcies.get(i)).getNode().getTranslateX()) {
                    if (scene.getHeight() < pathTransitions.get(indcies.get(i)).getNode().getTranslateY() && f.get(indcies.get(i)).isSliced()) {
                        btns.get(indcies.get(i)).setBackground(new Background(f.get(indcies.get(i)).getImage()));
                        f.get(indcies.get(i)).setSliced(false);

                    } else if (scene.getWidth() < pathTransitions.get(indcies.get(i)).getNode().getTranslateX() &&
                            !f.get(indcies.get(i)).isSliced()) {
                        if(player.getNoOfLives()!=0)
                        player.setNoOfLives(player.getNoOfLives() - 1);
                        pathTransitions.get(indcies.get(i)).getNode().setLayoutX(-100);
                        pathTransitions.get(indcies.get(i)).getNode().setLayoutY(0);
                        labelLives.setText("LIVES:" + Integer.toString(player.getNoOfLives()));
                    }


                }

            }
            for (i = 0; i < pathTransitionsB.size(); i++) {
                if (scene.getHeight() < pathTransitionsB.get(i).getNode().getTranslateY() && b.get(i).isSliced()) {

                    btnsB.get(i).setBackground(new Background(b.get(i).getImage()));
                    b.get(i).setSliced(false);

                }


            }
            indcies.clear();
            for (i = 0; i < types; i++) {
                int y = w.nextInt(4);
                for (int k = 0; k < pathTransitions.size(); k++) {
                    if (parallelTransition.getChildren().contains(pathTransitions.get(y))) ;
                    {
                        parallelTransition.getChildren().remove(pathTransitions.get(y));
                        indcies.remove((Object) y);
                        break;
                    }
                }
                parallelTransition.getChildren().add(pathTransitions.get(y));
                indcies.add(y);
            }

            for (i = 0; i < ty; i++) {
                parallelTransition.getChildren().add(pathTransitionsB.get(i));

            }

            parallelTransition.setCycleCount(1);
            parallelTransition.play();

        }else flag = 1;
    }
    public void updateBackground(){
        for(t=0;t<4;t++) {
            btns.get(t).setBackground(new Background(f.get(t).getImage()));
        }
        for(t=0;t<2;t++) {
            btnsB.get(t).setBackground(new Background(b.get(t).getImage()));
        }


    }
    public void removeTransitions(){
        parallelTransition.getChildren().removeAll(parallelTransition.getChildren());
    }

    public void setF(ArrayList<Fruit> f) {
        this.f = f;
    }
    public void setB(ArrayList<Bomb> b) {
        this.b = b;
    }

    public void sliceObjects(Button o) {
        int i;

        for(i=0;i<4;i++) {
            if (player.getNoOfLives() != 0) {
                if (o.equals(btns.get(i)) && !f.get(i).isSliced()) {
                    o.setBackground(new Background(f.get(i).getSlicedImage()));
                    f.get(i).setSliced(true);
                    player.setScore(player.getScore() + 1);
                    label1.setText("SCORE:" + player.getScore());
                    Path path = new Path();
                    path.getElements().add(new MoveTo(o.getTranslateX(), o.getTranslateY() + 150));
                    path.getElements().add(new VLineTo(+700));
                    PathTransition transition = new PathTransition();
                    transition.setNode(btns.get(i));
                    transition.setDuration(Duration.seconds(1.55));
                    transition.setPath(path);
                    transition.setCycleCount(1);
                    parallelTransition.getChildren().remove(pathTransitions.get(i));
                    transition.play();

                }
            }
            else break;
        }
        for(i=0;i<2;i++) {
            if (player.getNoOfLives() != 0) {
                if (o.equals(btnsB.get(i)) && !b.get(i).isSliced()) {
                    o.setBackground(new Background(b.get(i).getSlicedImage()));
                    b.get(i).setSliced(true);
                    if (i % 2 == 0) {
                        player.setNoOfLives(0);
                        flag = 1;
                        labelLives.setText("LIVES:" + Integer.toString(player.getNoOfLives()));

                    } else {

                        player.setNoOfLives(player.getNoOfLives() - 1);
                        if (player.getNoOfLives() == 0) flag = 1;
                        labelLives.setText("LIVES:" + Integer.toString(player.getNoOfLives()));


                    }
                    Path path = new Path();
                    path.getElements().add(new MoveTo(o.getTranslateX(), o.getTranslateY() + 250));
                    path.getElements().add(new VLineTo(+700));
                    PathTransition transition = new PathTransition();
                    transition.setNode(btnsB.get(i));
                    transition.setDuration(Duration.seconds(2));
                    transition.setPath(path);
                    transition.setCycleCount(1);
                    parallelTransition.getChildren().remove(pathTransitionsB.get(i));
                    transition.play();

                }
            }
            else break;
        }



    }
    public ArrayList<Fruit> getGeneratedFruits(ArrayList<Fruit> fruits){
       return fruits;
    }
    public ArrayList<Bomb> getGeneratedBombs(ArrayList<Bomb> bombs){
        return bombs;
    }



    //public Boolean hasMovedOffScreen(){};
    // public void slice(){};
    //public void move(double time){};
    //public BufferedImage[] getBufferedImages(){};
 public void button(){

     iStrategy=new Level1();
     player.setLevel(1);
     iStrategy.time(pathTransitions);
     iStrategy.time(pathTransitionsB);

 }
    public void button2() {
            iStrategy = new Level2();
            player.setLevel(2);
            iStrategy.time(pathTransitions);
            iStrategy.time(pathTransitionsB);


    }
    public void button3(){


        iStrategy=new Level3();
        player.setLevel(3);
        iStrategy.time(pathTransitions);
        iStrategy.time(pathTransitionsB);

    }
    public Scene choose(){
         button5=new Button("continue");
         button4=new Button("New game");
        Group op=new Group();
        javafx.scene.image.Image wallPaper2 = new javafx.scene.image.Image("/sample/scene.jpg");
        ImageView iv2 = new ImageView();
        iv2.setImage( wallPaper2 );
        op.getChildren().add(iv2);
        op.getChildren().addAll(button5,button4,fruitNinja);
        button4.setLayoutX(200);
        button4.setLayoutY(150);
        button5.setLayoutX(200);
        button5.setLayoutY(250);
        scene2=new Scene(op,500,500);
        scene2.getCursor();
        javafx.scene.image.Image image = new Image("/sample/HiNinja3.png");
        scene2.setCursor(new ImageCursor(image));
        scene2.getStylesheets().add(getClass().getResource("game2.css").toString());
        return  scene2;
    }

}