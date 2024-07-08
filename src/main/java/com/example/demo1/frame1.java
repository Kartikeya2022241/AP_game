package com.example.demo1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.nio.file.Paths;
import java.util.Objects;
import java.util.Vector;


public class frame1 extends Application implements do_it {

    private static User user;

    private static HelloApplication obj;


    private boolean showings_flag=false;

    public boolean isShowings_flag() {
        return showings_flag;
    }

    public void setShowings_flag(boolean showings_flag) {
        this.showings_flag = showings_flag;
    }

    public static HelloApplication getObj() {
        return obj;
    }

    public static void setObj(HelloApplication obj) {
        frame1.obj = obj;
    }

    @Override
    public void start(Stage stage) {

        //String video_path= Paths.get("https://videorecorder.page.link/Best").toUri().toString();


        Pane pane = new Pane();

        Image image1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Frame 11.png")));
        BackgroundImage bb = new BackgroundImage(image1, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(200, 200, true, true, true, true));
        Background bg = new Background(bb);
        Rectangle r = new Rectangle(140, 230, 120, 170);
        r.setFill(Color.BLACK);

        ImageView play = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("Group 3.png"))));
        play.setFitHeight(80);
        play.setFitWidth(80);
        play.setX(160);
        play.setY(130);

        Button btn=new Button(" ",play);
        btn.setLayoutX(150);
        btn.setLayoutY(130);
        btn.prefWidth(80);
        btn.prefHeight(80);
        btn.setOnAction(event->{
            stage.close();
            obj=new HelloApplication();
            obj.set_user(user);
            obj.set_obje(obj);
            obj.start(stage);
            System.out.println("came here");
            //System.exit(0);
        });



        ImageView name = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("Group 9.png"))));
        name.setFitWidth(100);
        name.setFitHeight(50);
        name.setX(150);
        name.setY(60);

        ImageView Leaderboard = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("leader_board.png"))));
        Leaderboard.setFitHeight(40);
        Leaderboard.setFitWidth(40);
        Leaderboard.setX(310);
        Leaderboard.setY(320);

        Button btn1=new Button(" ",Leaderboard);
        btn1.setLayoutY(320);
        btn1.setLayoutX(310);
        btn1.prefHeight(40);
        btn1.prefWidth(40);

        ImageView image2=new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("p1.png"))));
        image2.setY(0);
        image2.setX(0);
        image2.setFitHeight(400);
        image2.setFitWidth(400);
        image2.setVisible(false);

        Button btn3=new Button("Back");
        btn3.setLayoutX(330);
        btn3.setLayoutY(50);
        btn3.prefWidth(40);
        btn3.prefHeight(40);
        btn3.setVisible(false);

        Vector<User> u=LoadGame.get_rating();
        Text text=new Text();
        Text text1=new Text();
        Text text2=new Text();
        text.setText("-                        -");
        text1.setText("-                        -");
        text2.setText("-                        -");
        text.setFont(new Font("Arial",20));
        text1.setFont(new Font("Arial",20));
        text2.setFont(new Font("Arial",20));

        if (u!=null) {
            if (u.get(0)!=null) {
                text.setText(u.get(0).get_name()+"           "+u.get(0).getHighest_score());
            }
            if (u.get(1)!=null) {
                text1.setText(u.get(1).get_name()+"           "+u.get(1).getHighest_score());
            }
            if (u.get(2)!=null) {
                text2.setText(u.get(2).get_name()+"            "+u.get(2).getHighest_score());
            }
        }




        text.setVisible(false);
        text1.setVisible(false);
        text2.setVisible(false);

        text.setX(170);
        text1.setX(170);
        text2.setX(170);

        text.setY(290);
        text1.setY(340);
        text2.setY(390);

        btn1.setOnAction(event-> {
            image2.setVisible(true);
            text.setVisible(true);
            text1.setVisible(true);
            text2.setVisible(true);
            btn3.setVisible(true);
            btn3.setOnAction(e-> {
                image2.setVisible(false);
                btn3.setVisible(false);
                text.setVisible(false);
                text1.setVisible(false);
                text2.setVisible(false);
            });

        });

        ImageView about = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("Group 1.png"))));
        about.setFitHeight(40);
        about.setFitWidth(40);
        about.setX(40);
        about.setY(250);


        ImageView sound = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("p4.png"))));
        sound.setFitHeight(40);
        sound.setFitWidth(40);
        sound.setX(40);
        sound.setY(330);

        Button btn7=new Button("",sound);
        btn7.setLayoutY(330);
        btn7.setLayoutX(40);
        btn7.prefWidth(40);
        btn7.prefHeight(40);

        btn7.setOnAction(eeee->{
            stage.close();
            obj=new HelloApplication();
            obj.set_score(user.getState().getScore());
            showings_flag=false;
            obj.setCollected_cherries(user.getState().getCherries());
            obj.set_user(user);
            obj.set_obje(obj);
            obj.start(stage);
        });


        ImageView cherry = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("cherry_icon-removebg-preview.png"))));
        cherry.setFitHeight(40);
        cherry.setFitWidth(40);
        cherry.setX(310);
        cherry.setY(250);

        Button btn4=new Button("",cherry);
        btn4.setLayoutX(310);
        btn4.setLayoutY(250);
        btn4.prefHeight(40);
        btn.prefWidth(40);

        ImageView cc=new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("p2.png"))));
        cc.setX(0);
        cc.setY(0);
        cc.setFitHeight(400);
        cc.setFitWidth(400);
        cc.setVisible(false);

        Text t=new Text();
        t.setFont(new Font("Arial",30));
        t.setX(300);
        t.setY(110);
        t.setText(Integer.toString(user.getHighes_number_of_cherries()));
        t.setVisible(false);


        btn4.setOnAction(ev->{
            cc.setVisible(true);
            t.setVisible(true);
            btn3.setVisible(true);
            btn3.setOnAction(e-> {
                cc.setVisible(false);
                t.setVisible(false);
                btn3.setVisible(false);
            });
        });


        ImageView iiii=new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("p4.png"))));
        pane.setBackground(bg);

        pane.getChildren().add(r);
        //pane.getChildren().add(play);
        pane.getChildren().add(name);
        pane.getChildren().add(Leaderboard);
        pane.getChildren().add(about);
        if (showings_flag) {
            pane.getChildren().add(btn7);
        }
        pane.getChildren().add(cherry);
        pane.getChildren().add(btn4);
        pane.getChildren().add(btn);
        pane.getChildren().add(btn1);
        pane.getChildren().add(image2);
        pane.getChildren().add(cc);
        pane.getChildren().add(t);
        pane.getChildren().add(btn3);
        pane.getChildren().add(text);
        pane.getChildren().add(text1);
        pane.getChildren().add(text2);


        Scene scene = new Scene(pane, 400, 400);
        scene.setFill(Color.TRANSPARENT);

        //stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();



    }

    public  User getUser() {
        return user;
    }

    public  static void setUser(User user) {
        frame1.user = user;
    }

    public static void l() {
        launch();
    }




}
