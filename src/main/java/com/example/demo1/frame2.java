package com.example.demo1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.Vector;

public class frame2 extends Application implements do_it {

    private int cherries_collected;

    private int score;

    private HelloApplication obj;

    private User user;

    public void set_user(User user) {
        this.user=user;
    }

    public User get_user() {
        return this.user;
    }

    public int getCherries_collected() {
        return cherries_collected;
    }

    public void setCherries_collected(int cherries_collected) {
        this.cherries_collected = cherries_collected;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public HelloApplication getObj() {
        return obj;
    }

    public void setObj(HelloApplication obj) {
        this.obj = obj;
    }

    @Override
    public void start(Stage stage) {
        Pane pane=new Pane();
        Image image=new Image(Objects.requireNonNull(getClass().getResourceAsStream("Frame 1.png")));
        BackgroundImage bb = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(200, 200, true, true, true, true));
        Background bg = new Background(bb);

        Text text=new Text(Integer.toString(score));
        text.setFont(new Font("Arial",35));
        text.setX(240);
        text.setY(370);

        Text text1=new Text(Integer.toString(user.getHighest_score()));
        text1.setFont(new Font("Arial",35));
        text1.setX(240);
        text1.setY(470);


        ImageView game_over=new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("GAME OVER!.png"))));
        game_over.setY(150);
        game_over.setX(100);
        game_over.setFitWidth(300);
        game_over.setFitHeight(70);

        ImageView score_card=new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("Group 18.png"))));
        score_card.setY(280);
        score_card.setX(100);
        score_card.setFitWidth(300);
        score_card.setFitHeight(200);

        ImageView home=new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("Group 13.png"))));
        home.setY(520);
        home.setX(160);
        home.setFitHeight(50);
        home.setFitWidth(50);

        Button btn5=new Button("",home);
        btn5.setLayoutY(520);
        btn5.setLayoutX(160);
        btn5.prefHeight(50);
        btn5.prefWidth(50);

        btn5.setOnAction(ege-> {
            stage.close();
            frame1 obj=new frame1();
            frame1.setUser(user);
            obj.start(stage);
        });



        ImageView Leader_board=new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("Group 17.png"))));
        Leader_board.setY(520);
        Leader_board.setX(230);
        Leader_board.setFitHeight(50);
        Leader_board.setFitWidth(50);

        Button btn1=new Button(" ",Leader_board);
        btn1.setLayoutY(520);
        btn1.setLayoutX(220);
        btn1.prefHeight(40);
        btn1.prefWidth(40);

        ImageView image2=new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("p1.png"))));
        image2.setY(0);
        image2.setX(0);
        image2.setFitHeight(700);
        image2.setFitWidth(500);
        image2.setVisible(false);

        Button btn3=new Button("Back");
        btn3.setLayoutX(430);
        btn3.setLayoutY(50);
        btn3.prefWidth(40);
        btn3.prefHeight(40);
        btn3.setVisible(false);

        Vector<User> u=LoadGame.get_rating();
        Text text11=new Text();
        Text text12=new Text();
        Text text22=new Text();
        text11.setText("-                              -");
        text12.setText("-                              -");
        text22.setText("-                              -");
        text11.setFont(new Font("Arial",40));
        text12.setFont(new Font("Arial",40));
        text22.setFont(new Font("Arial",40));

        if (u!=null) {
            if (u.get(0)!=null) {
                text11.setText(u.get(0).get_name()+"               "+u.get(0).getHighest_score());
            }
            if (u.get(1)!=null) {
                text12.setText(u.get(1).get_name()+"                "+u.get(1).getHighest_score());
            }
            if (u.get(2)!=null) {
                text22.setText(u.get(2).get_name()+"                "+u.get(2).getHighest_score());
            }
        }




        text11.setVisible(false);
        text12.setVisible(false);
        text22.setVisible(false);

        text11.setX(170);
        text12.setX(170);
        text22.setX(170);

        text11.setY(520);
        text12.setY(600);
        text22.setY(680);

        btn1.setOnAction(event-> {
            image2.setVisible(true);
            text11.setVisible(true);
            text12.setVisible(true);
            text22.setVisible(true);
            btn3.setVisible(true);
            btn3.setOnAction(e-> {
                image2.setVisible(false);
                btn3.setVisible(false);
                text11.setVisible(false);
                text12.setVisible(false);
                text22.setVisible(false);
            });

        });

        ImageView restart=new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("Group 15.png"))));
        restart.setY(520);
        restart.setX(300);
        restart.setFitHeight(50);
        restart.setFitWidth(50);

        Button btn6=new Button("",restart);
        btn6.setLayoutX(300);
        btn6.setLayoutY(520);
        btn6.prefWidth(50);
        btn6.prefHeight(50);

        btn6.setOnAction(ee-> {
            stage.close();
            //HelloApplication ss=new HelloApplication();
            obj=new HelloApplication();
            obj.set_user(user);
            obj.set_obje(obj);
            obj.start(stage);

        });


        pane.setBackground(bg);
        pane.getChildren().addAll(game_over);

        pane.getChildren().add(score_card);
        pane.getChildren().add(text);
        pane.getChildren().add(text1);
        pane.getChildren().add(btn5);
        pane.getChildren().add(btn6);
        pane.getChildren().add(home);
        pane.getChildren().add(Leader_board);
        pane.getChildren().add(restart);
        pane.getChildren().add(btn1);
        pane.getChildren().add(image2);
        pane.getChildren().add(btn3);
        pane.getChildren().add(text11);
        pane.getChildren().add(text12);
        pane.getChildren().add(text22);



        Scene scene=new Scene(pane,500,700);
        stage.setScene(scene);
        stage.show();


    }

    public static void begin() {
        launch();
    }
}
