package com.example.demo1;//package com.example.demo1;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.animation.RotateTransition;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.*;
//import java.time.Duration;
import javafx.util.Duration;

import javafx.scene.shape.Circle;
import javafx.scene.Group;



public class HelloApplication extends Application {
    private int length;

    private static HelloApplication obje;


    private Stage stage;

    boolean flag1=false;
    private long start_time;
    private long end_time;
    private int breadth;

    private  int count_cherries=0;

    private Rectangle rectangle;

    private Timeline timeline;

    private int current_cherry=0;

    private int collected_cherries=0;

    private Text text;

    private Text text1;

    private Text Score_name;
    private boolean flag=true;

    private boolean che=false;

    private Rotate rotate;

    private Timeline t1;

    private Pane pane;

    private boolean blocked_flag=false;
    private boolean blocked_flag1=false;

    private ImageView image;

    private boolean fall=false;

    private double height;

    private int lower_bound=0;

    private Rectangle r;

    private Timeline t23;

    private boolean revert_flag=true;

    private Pane pane1;

    private int score=0;

    private Button btn;
    private Scene scene;

    private Scene scene1;

    private Stage stage1;

    private boolean removal=false;



    private boolean collected=false;

    private Background bg;
    private double image_x_coordinate;

    private double distance=70;
    private Thread thread1;
    private Thread thread2;

    private User user;


    private Vector<ImageView> cherries;


    private Vector<Rectangle> arr;
    private int count=0;
    int flagu=0;

    public void set_user(User user) {
        this.user=user;
    }

    public User get_user() {
        return this.user;
    }

    public void set_cc(int count) {
        this.count_cherries+=count;
    }

    public int get_cc() {
        return this.count_cherries;
    }

    public  void set_fall(boolean f) {
        fall=f;
    }







    @Override
    public void start(Stage primaryStage) {
        stage=primaryStage;
        Image image1=new Image(Objects.requireNonNull(getClass().getResourceAsStream("2_game2_4x.jpg")));
        BackgroundImage bb=new BackgroundImage(image1, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,new BackgroundSize(200,200,true,true,true,true));
        this.bg=new Background(bb);
        // Creating the ball
        this.arr=new Vector<>();
        this.cherries=new Vector<>();
//        for (int i=0;i<200;i++) {
//            ImageView i1=new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("cherry_icon-removebg-preview.png"))));
//            //this.pane.getChildren().add(i1);
//            this.cherries.add(i1);
//        }


        ImageView ii=new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("cherry_icon-removebg-preview.png"))));
        ii.setX(450);
        ii.setY(50);
        ii.setFitWidth(40);
        ii.setFitHeight(40);


        //rectangel_maker();
        Rectangle r1=new Rectangle(10,315,60,385);
        //r1.setOpacity(0.75);
        //image.setX(50-image.getFitWidth());
        //image_x_coordinate=image.getX();
        arr.add(r1);
        make_rectangles gd=new make_rectangles(distance,arr,cherries,count_cherries,obje);
        Thread t1=new Thread(gd);
        t1.start();
        try{
            t1.join();
        } catch(Exception e) {
            System.out.println("exception hai");
        }
        Circle ball = new Circle(20,20,20, Color.BLUE);

        this.stage1=primaryStage;
        this.image=new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("hero.png"))));
        this.image.setFitWidth(30);
        this.image.setFitHeight(30);
        this.image.setX(40);
        this.image.setY(285);
        //this.image_x_coordinate=50;
        this.image_x_coordinate=70;

        ImageView pause=new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("Black-Pause-Button-Png (1).jpg"))));
        pause.setX(20);
        pause.setY(60);
        pause.setFitHeight(30);
        pause.setFitWidth(30);


        this.text=new Text(Integer.toString(this.score));
        this.Score_name=new Text("Score: ");
        this.Score_name.setX(230);
        this.Score_name.setY(100);
        this.Score_name.setFont(new Font("Arial",18));
        this.Score_name.setFill(Color.WHITE);

        this.text1=new Text();
        this.text1.setFont(new Font("Arial",20));
        this.text1.setX(465);
        this.text1.setFill(Color.BLACK);
        this.text1.setY(120);
        this.text1.setText(Integer.toString(collected_cherries));

        text.setX(235);
        text.setY(100);
        text.setFont(new Font("Arial",18));
        text.setFill(Color.WHITE);

        r=new Rectangle(220,70,40,40);
        r.setFill(Color.BLUEVIOLET);
        r.setOpacity(0.45);





        //image.relocate(100,100);




        //pane.getChildren().addAll(ball);
        //Pane pane=new Pane(ball1);


        // Add the scene to the stage
//        ImageView rr=new ImageView(new Image("C:\\Users\\leech\\OneDrive\\Desktop\\Group 6.png"));
//        //ImageView i1=cherries.get((i-1)/2);
//        rr.setFitWidth(20);
//        rr.setFitHeight(10);
//        rr.setX(80);
//        rr.setY(204);
        //this.pane.getChildren().add(rr);

        // Set up animation to make the ball roll forward
        //        TranslateTransition t=new TranslateTransition(Duration.millis(1000),ball);
        //        t.setToX(360);
        this.btn=new Button("move forward");
        this.btn.setLayoutX(20);
        this.btn.setLayoutY(10);


        this.pane=new Pane();
        Button btn1=new Button("",pause);
        btn1.setLayoutY(60);
        btn1.setLayoutX(20);
        btn1.prefWidth(30);
        btn1.prefHeight(30);

        ImageView iei=new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("p3.png"))));
        iei.setX(0);
        iei.setY(0);
        iei.setFitWidth(500);
        iei.setFitHeight(500);
        iei.setVisible(false);


        Button btn3=new Button("Back");
        btn3.setLayoutX(330);
        btn3.setLayoutY(50);
        btn3.prefWidth(40);
        btn3.prefHeight(40);
        btn3.setVisible(false);

        Button btn4=new Button("Save game state");
        btn4.setLayoutX(210);
        btn4.setLayoutY(450);
        btn4.prefHeight(40);
        btn4.prefWidth(40);
        btn4.setVisible(false);

        btn1.setOnAction(e-> {
            iei.setVisible(true);
            btn3.setVisible(true);
            btn4.setVisible(true);
            btn3.setOnAction(ev-> {
                iei.setVisible(false);
                btn3.setVisible(false);
                btn4.setVisible(false);
            });


            btn4.setOnAction(eee-> {
                game_state g=new game_state(score,collected_cherries);
                user.setState(g);
                //thread1=null;
                stage.close();
                frame1 ob=new frame1();
                frame1.setUser(user);
                ob.setShowings_flag(true);
                ob.start(stage);
            });

        });
        pane.getChildren().add(btn1);
        //this.pane.getChildren().add(btn);

        //this.pane.getChildren().add(rr);
//            pane.getChildren().add(image);
//            pane.getChildren().add(btn);
        this.pane.setBackground(bg);
        this.pane.getChildren().add(text);
        this.pane.getChildren().add(r);
        this.pane.getChildren().add(text1);
        this.pane.getChildren().add(ii);

//            pane.getChildren().add(r1);
        //this.pane.getChildren().add(arr);
        System.out.println("arr siz3e "+arr.size());
        for (int i=0;i<arr.size();i++) {
            this.pane.getChildren().add(arr.get(i));
        }

        System.out.println("ch count "+count_cherries);
        System.out.println("size "+cherries.size());
        for (int i=0;i<count_cherries;i++) {
            this.pane.getChildren().add(cherries.get(i));
        }

        this.pane.getChildren().add(image);
        this.pane.getChildren().add(iei);
        this.pane.getChildren().add(btn3);
        this.pane.getChildren().add(btn4);




//




        this.scene = new Scene(this.pane, 500, 500);
        this.scene.setFill(Color.TRANSPARENT);








        timeline=new Timeline(
                new KeyFrame(Duration.millis(50),event->{
                    if (this.flag) {

                        //System.out.println(image.getX());
                        //System.out.println("count "+count);
                        //System.out.println(image.getX()+image.getFitWidth());
                        this.rectangle=new Rectangle(10+arr.get(count).getWidth(),image.getY()+image.getFitHeight(),3,1);
                        //System.out.println(image.getX());
                        //System.out.println(image.getFitWidth());
                        rectangle.setFill(Color.BLACK);
                        this.breadth=1;
                        pane.getChildren().add(rectangle);

                        this.flag=false;
                    }

                    //length-=10;
                    //rectangle.setY(length);
                    rectangle.setY(rectangle.getY() - 20);
                    this.breadth+=20;
                    rectangle.setHeight(breadth);

                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        scene.setOnMousePressed(event->{
            if (!this.blocked_flag) {
                timeline.play();
                this.blocked_flag=true;
            }

        });



        scene.setOnMouseReleased(event->{
            if (!blocked_flag1) {
                flag=true;


//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }


//
                //pane.getChildren().remove(rectangle);
                timeline.stop();
//                try{
//                    Thread.sleep(800);
//                } catch (Exception e) {
//                    System.out.println("Error in sleep");
//
//                }
                //Thread t1=new Thread(obje);
//                thread1=new Thread(obje);
//                thread1.start();
//                try {
//                    thread1.join();
//                } catch (Exception e) {
//                    System.out.println("error in joining");
//                }

                start_rotation(rectangle);
                move_the_character(rectangle.getHeight(),count);


                count++;
                this.blocked_flag1=true;
                //move_the_frame();
                //this.t23.stop();
                //flag1=true;
                //pane.getChildren().remove(rectangle);
            }

        });

//        Timeline tt=new Timeline(
//                new KeyFrame(Duration.millis(10),event-> collecting())
//        );
//        tt.setCycleCount(Animation.INDEFINITE);
//        tt.play();

//


//            TranslateTransition t=new TranslateTransition(Duration.millis(400),ball);
//            t.setByX(20);
//            t.setByY(20);
//
//
//            TranslateTransition t1=new TranslateTransition(Duration.millis(300),image);
//            t1.setByX(60);


//            btn.setOnAction(event->{
//                length-=10;
//                //rectangle.setY(length);
//                rectangle.setY(rectangle.getY() - 20);
//                this.breadth+=20;
//                rectangle.setHeight(breadth);
//                t.play();
//                t1.play();
//            });

        //scene.setFill(Color.RED);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rolling Ball Forward Animation");


        primaryStage.show();
        pane.requestFocus();
//        scene.setOnKeyPressed(event -> pane.requestFocus());
        // Creating the ball
        scene.setOnMouseClicked(event-> pane.requestFocus());
    }

    public static void begin() {
        //arr=new Vector<>();
        launch();
    }

    public void start_rotation(Rectangle rectangle) {

//            Rotate rr= new Rotate(0, rectangle.getX() + rectangle.getWidth() / 2, rectangle.getY() +rectangle.getHeight());
//            rectangle.getTransforms().add(rotate);
//            double x_coordinate=rectangle.getX();
//            double y_coordinate=rectangle.getY();
//            Point3D p=new Point3D(rectangle.getX(),rectangle.getY()+rectangle.getHeight(),0);
//            RotateTransition r=new RotateTransition(Duration.millis(1000),rectangle);
//            rectangle.setRotationAxis(p);
//            //r.setAxisY(rectangle.getY() + rectangle.getHeight());
//            r.setByAngle(-90);
//            r.play();
        //rectangle.setX(arr.get(count).getX()+arr.get(count).getWidth());


//           // r.setByAngle(90);
//            r.play();
          Rotate_rod r=new Rotate_rod(rectangle,rotate);
          r.rotate_rod();
//        rotate = new Rotate(0, rectangle.getX() + rectangle.getWidth() / 2, rectangle.getY() +rectangle.getHeight());
//        rectangle.getTransforms().add(rotate);
//        Timeline te=new Timeline(
//                new KeyFrame(Duration.millis(10),event->{
//                    rotate.setAngle(rotate.getAngle()+1);
//                })
//        );
//        te.setCycleCount(90);
//        //te.setRate(1.5);
//        te.play();
        //Animation
        this.height=rectangle.getHeight();

    }

//    public void switch_scene() {
//        stage.close();
//        frame2 obj=new frame2();
//        obj.start(stage);
//    }

    public void move_the_character(double height,int count) {
        scene.setOnKeyPressed(event-> {
            if (event.getCode()==KeyCode.SPACE) {
                if (revert_flag) {
                    image.setScaleY(-1);
                    image.setY(image.getY()+image.getFitWidth());
                    //che=true;
                    revert_flag=false;
                } else {
                    image.setScaleY(1);
                    image.setY(image.getY()-image.getFitWidth());
                    revert_flag=true;
                }
            }
        });
        double store=arr.get(count+1).getX()+arr.get(count+1).getWidth()-arr.get(count).getX()-arr.get(count).getWidth();
        double minus=(arr.get(count+1).getX()-arr.get(count).getX());
//        scene.setOnKeyPressed(event134->{
//            if (event134.getCode() == KeyCode.W) {
//
//            }
//        });
        TranslateTransition imageTransition = new TranslateTransition(Duration.millis(1000), image);
        Timeline t2=new Timeline(
                new KeyFrame(Duration.millis(900),event->{
                    move_the_character dd=new move_the_character(height,count,scene,revert_flag,image,arr,cherries,current_cherry,collected,pane,fall,collected_cherries,text1,obje);
                    dd.do_work();
//
                })
        );

        t2.play();
//
        Timeline ttt=new Timeline(
                new KeyFrame(Duration.millis(1950),eventt->{
                    if (fall) {
                        TranslateTransition falling_down=new TranslateTransition(Duration.millis(500),image);
                        falling_down.setByY(600);
                        falling_down.play();
                        falling_down.setOnFinished(event->{
                            stage.close();
                            frame2 obj=new frame2();
                            obj.set_user(user);
                            obj.setScore(this.score);
                            obj.setCherries_collected(collected_cherries);
                            user.add_cherries(this.collected_cherries);
                            user.add_score(this.score);
                            if (score>user.getHighest_score()) {
                                user.setHighest_score(score);
                            }
                            if (collected_cherries>user.getHighes_number_of_cherries()) {
                                user.setHighes_number_of_cherries(collected_cherries);
                            }
                            LoadGame.delete_file_content();
                            Vector<User> r=LoadGame.get_rating();
                            int ct=0;
                            boolean ft=false;
                            if (r!=null) {
                                for (User u: r) {
                                    if (u==null) {
                                        int index=ct;

                                        r.add(index,user);
                                        ft=true;
                                        break;
                                    }else if (user.getHighest_score()>u.getHighest_score()) {
                                        int index=ct;

                                        r.add(index,user);
                                        ft=true;
                                        break;
                                    }
                                    ct++;
                                }
                            }

                            if (ft) {
                                r.remove(3);
                            }
                            Vector<User> u=LoadGame.get_users();
                            File f=LoadGame.getFile2();
                            for(User use: u) {
                                if (!use.equals(user)) {
                                    LoadGame.serialize(use,f);
                                } else {
                                    LoadGame.serialize(user,f);
                                }
                            }
                            obj.setObj(obje);
                            obj.start(stage);
                        });
                        return;
                        ///System.exit(0);
                        //pane.getChildren().remove(image);
                    }
                    pane.getChildren().remove(rectangle);
                    //double minus=(arr.get(count+1).getX()-arr.get(count).getX());
                    //TranslateTransition imageTransition = new TranslateTransition(Duration.millis(500), image);
                    //imageTransition.setToX(arr.get(count+1).getX()+arr.get(count+1).getWidth()-image.getFitWidth()-minus);
                    imageTransition.setByX((-1)*minus);
//                        image.translateXProperty().addListener((observable,oldvalue,newValue)->{
//                            image_x_coordinate=newValue.doubleValue();
//                        });
//                        System.out.println("coordinate hai "+image_x_coordinate);
                    //image_x_coordinate-=minus;
                    //image_x_coordinate=arr.get(count+1).getX()+arr.get(count+1).getWidth()-image.getFitWidth();

                    imageTransition.play();

                    List<TranslateTransition> transitions = new ArrayList<>();
                    List<TranslateTransition> tansitions1 = new ArrayList<>();
                    for (int i=this.lower_bound;i<10;i++) {
                        TranslateTransition cherryTransition=new TranslateTransition(Duration.millis(1000),cherries.get(i));
                        cherryTransition.setByX((-1)*minus);
                        tansitions1.add(cherryTransition);
                    }
                    for (int i = 0; i < 21; i++) {

                        TranslateTransition rectangleTransition = new TranslateTransition(Duration.millis(1000), arr.get(i));

                        rectangleTransition.setByX((-1)*minus);
                        transitions.add(rectangleTransition);

                    }
                    TranslateTransition for_r=new TranslateTransition(Duration.millis(1000),r);
                    for_r.setByX((-1)*minus);

                    TranslateTransition for_text=new TranslateTransition(Duration.millis(1000),text);
                    for_text.setByX((-1)*minus);
                    //image.setX(image.getX()-minus);
                    // Play transitions for rectangles
                    int count1=0;
                    for (TranslateTransition transition : transitions) {
                        transition.play();
                        //arr.get(count1).setX(arr.get(count1).getX()-minus);
                        count1++;
                    }
                    for (TranslateTransition transition: tansitions1) {
                        transition.play();
                    }

                })
        );
        ttt.play();

        ttt.setOnFinished(event->{
            if (!fall) {
                this.score++;
                this.text.setText(Integer.toString(this.score));
            }
            if (removal) {
                pane.getChildren().remove(cherries.get(current_cherry-1));
            }
            this.blocked_flag1=false;
            this.blocked_flag=false;
        });

    }

    //    public void collecting() {
//        if (cherries.get(current_cherry).getX()<arr.get(count+1).getX() && cherries.get(current_cherry).getX()>arr.get(count).getX()+arr.get(count).getWidth()) {
//            if (image.getBoundsInParent().intersects(cherries.get(current_cherry).getBoundsInParent())) {
//                collected_cherries++;
//                System.out.println(collected_cherries);
//                pane.getChildren().remove(cherries.get(current_cherry));
//                lower_bound=current_cherry+1;
//            }
//
//            current_cherry++;
//            //lower_bound=current_cherry;
//        }
//        //System.out.println(image.getBoundsInParent().getMaxX());
//    }


    public void rectangel_maker() {
        Random random=new Random();

        //Random random=new Random();
//        int distance_between_poles=random.nextInt(270);
//        int width_of_the_pole=random.nextInt(130);
//        if (width_of_the_pole<20) {
//            width_of_the_pole=20;
//        }
//        if (distance_between_poles<20) {
//            distance_between_poles=20;
//        }
////        Thread t1=new Thread(obje);
////        Thread t2=new Thread(obje);
////        Thread t3=new Thread(obje);
////        Thread t4=new Thread(obje);
////        Thread t5=new Thread(obje);
////
////        t1.start();
//////        t2.start();
//////        t3.start();
//////        t4.start();
//////        t5.start();
////        try {
////            t1.join();
//////            t2.join();
//////            t3.join();
//////            t4.join();
//////            t5.join();
////        } catch (Exception e) {
////            System.out.println("exception in thread join");
////        }
//        for (int i=0;i<20;i++) {
//            Rectangle r=new Rectangle(distance+distance_between_poles,315,width_of_the_pole,385);
//            //r.setOpacity(0.75);
//            if (true) {
//                if (distance_between_poles>=50) {
//                    ImageView i1=cherries.get(count_cherries);
//                    count_cherries++;
//                    i1.setFitWidth(20);
//                    i1.setFitHeight(20);
//                    i1.setX(distance+random.nextInt(distance_between_poles)-20);
//                    if (i1.getX()<=r.getWidth()+r.getX()) {
//                        i1.setX(i1.getX()+20);
//                    }
//                    i1.setY(319);
//                }
//
//            }
//            distance=distance+width_of_the_pole+distance_between_poles;
//            distance_between_poles= random.nextInt(270);
//            width_of_the_pole= random.nextInt(130);
//
//            if (width_of_the_pole<20) {
//                width_of_the_pole=20;
//            }
//            if (distance_between_poles<20) {
//                distance_between_poles=20;
//            }
//    //                arr.add(r);
//            //width_of_the_pole=40;
//            this.arr.add(r);
//        }


    }

    public void set_obje(HelloApplication obj) {
        obje=obj;
    }

    public void set_score(int score) {
        this.score=score;
    }

    public void setCollected_cherries(int c) {
        this.collected_cherries=c;
    }

    public void set_collected(boolean collected) {
        this.collected=collected;
    }

    public void set_current_cherry(int c) {
        this.current_cherry=c;
    }


    public static void l() {
        launch();
    }

    public void make_cherries() {

    }


}




