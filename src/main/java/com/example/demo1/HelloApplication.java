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
    import javafx.scene.transform.Rotate;
    import javafx.animation.RotateTransition;
    import javafx.stage.Stage;
    import java.io.IOException;
    import java.util.*;
    //import java.time.Duration;
    import javafx.util.Duration;

    import javafx.scene.shape.Circle;
    import javafx.scene.Group;



    public class HelloApplication extends Application {
        private int length;

        boolean flag1=false;
        private long start_time;
        private long end_time;
        private int breadth;

        private Rectangle rectangle;

        private Timeline timeline;
        private boolean flag=true;

        private Rotate rotate;

        private Timeline t1;

        private Pane pane;

        private ImageView image;

        private double height;

        private Timeline t23;

        private Pane pane1;

        private Button btn;
        private Scene scene;

        private Scene scene1;

        private Stage stage1;

        private Background bg;
        private double image_x_coordinate;
        private Thread thread1;
        private Thread thread2;



        private Vector<Rectangle> arr;
        private int count=0;

        @Override
        public void start(Stage primaryStage) {
            // Creating the ball
            arr=new Vector<>();
            rectangel_maker();
            Circle ball = new Circle(20,20,20, Color.BLUE);

            stage1=primaryStage;
            image=new ImageView(new Image("C:\\Users\\leech\\OneDrive\\Desktop\\hero.png"));
            image.setFitWidth(30);
            image.setFitHeight(30);
            image.setX(20);
            image.setY(170);
            image_x_coordinate=50;



            //image.relocate(100,100);
            Image image1=new Image("C:\\Users\\leech\\OneDrive\\Desktop\\3826392.jpg");
            BackgroundImage bb=new BackgroundImage(image1, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,new BackgroundSize(200,200,true,true,true,true));
            bg=new Background(bb);



            //pane.getChildren().addAll(ball);
            //Pane pane=new Pane(ball1);


            // Add the scene to the stage


            // Set up animation to make the ball roll forward
    //        TranslateTransition t=new TranslateTransition(Duration.millis(1000),ball);
    //        t.setToX(360);
            btn=new Button("move forward");
            btn.setLayoutX(20);
            btn.setLayoutY(10);

            Button btn1=new Button("Stop");
            btn1.setLayoutX(20);
            btn1.setLayoutY(300);


            Button btn2=new Button("increase length");
            btn2.setLayoutX(20);
            btn2.setLayoutY(150);


            pane=new Pane();
            pane.getChildren().addAll(image,btn);
//            pane.getChildren().add(image);
//            pane.getChildren().add(btn);
            pane.setBackground(bg);
//            pane.getChildren().add(r1);
            for (int i=0;i<21;i++) {
                pane.getChildren().add(arr.get(i));
            }

//




            scene = new Scene(pane, 400, 400);
            scene.setFill(Color.TRANSPARENT);








            timeline=new Timeline(
                    new KeyFrame(Duration.millis(50),event->{
                        if (flag) {

                            //System.out.println(image.getX());
                            System.out.println("count "+count);
                            //System.out.println(image.getX()+image.getFitWidth());
                            rectangle=new Rectangle(10+arr.get(count).getWidth(),image.getY()+image.getFitHeight(),3,1);
                            //System.out.println(image.getX());
                            //System.out.println(image.getFitWidth());
                            rectangle.setFill(Color.BLUE);
                            this.breadth=1;
                            pane.getChildren().add(rectangle);

                            flag=false;
                        }

                        //length-=10;
                        //rectangle.setY(length);
                        rectangle.setY(rectangle.getY() - 20);
                        this.breadth+=20;
                        rectangle.setHeight(breadth);

                    })
            );
            timeline.setCycleCount(Timeline.INDEFINITE);


            btn.setOnMousePressed(event->{
                timeline.play();
            });



            btn.setOnMouseReleased(event->{
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

                start_rotation(rectangle);
                move_the_character(rectangle.getHeight(),count);
                count++;
                //move_the_frame();
                //this.t23.stop();
                //flag1=true;
                //pane.getChildren().remove(rectangle);
            });

            scene.setOnKeyPressed(event134->{
                if (event134.getCode() == KeyCode.W) {
                    image.setScaleY(-1);
                }
            });


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
            // Creating the ball

        }

        public static void main(String[] args) {
            //arr=new Vector<>();
            launch(args);
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
            rotate = new Rotate(0, rectangle.getX() + rectangle.getWidth() / 2, rectangle.getY() +rectangle.getHeight());
            rectangle.getTransforms().add(rotate);
            Timeline te=new Timeline(
                    new KeyFrame(Duration.millis(1000),event->{
                        rotate.setAngle(90);
                    })
            );
            te.play();
             this.height=rectangle.getHeight();

        }

        public void moving_the_image(TranslateTransition imageTransition) {

        }

        public void move_the_character(double height,int count) {
            double store=0;
            scene.setOnKeyPressed(event134->{
                if (event134.getCode() == KeyCode.W) {
                    image.setScaleY(-1);
                }
            });
            TranslateTransition imageTransition = new TranslateTransition(Duration.millis(500), image);
            Timeline t2=new Timeline(
                    new KeyFrame(Duration.millis(1100),event->{
                        try{
                            if (height<arr.get(count+1).getX()-arr.get(count).getX()-arr.get(count).getWidth() || (height>arr.get(count+1).getX()+arr.get(count+1).getWidth()-arr.get(count).getX()-arr.get(count).getWidth())) {
                                pane.getChildren().remove(image);
                            } else {
//                                double minus=arr.get(count+1).getX()-arr.get(count).getX()-arr.get(count).getWidth();
//                                image.setX(arr.get(count+1).getX()+arr.get(count+1).getWidth()-image.getFitWidth()-minus);
//                                //image.setX(image.getX()-minus);
//
//
//                                //int count=50
//                                //TranslateTransition []arrr=new TranslateTransition[11];
//                                for (int i=0;i<21;i++) {
////                                    TranslateTransition translate1=new TranslateTransition(Duration.millis(300),arr.get(i));
////                                    translate1.setToX(arr.get(i).getX()-minus);
////                                    arrr[i]=translate1;
//                                    //translate1.play();
//                                    arr.get(i).setX(arr.get(i).getX()-minus);
//                                }
//                                for (int i=0;i<11;i++) {
//                                    arrr[i].play();
//                                }
//                            }

                                //image.setX(height+image.getX());
                                //image.setX(height+image.getX()+image.getFitWidth());
                                double minus=(arr.get(count+1).getX()-arr.get(count).getX());
                                // Create TranslateTransition for the character image
                                //TranslateTransition imageTransition = new TranslateTransition(Duration.millis(500), image);
                                //imageTransition.setToX(arr.get(count+1).getX()+arr.get(count+1).getWidth()-image.getFitWidth()-minus);
                                imageTransition.setByX(arr.get(count+1).getX()+arr.get(count+1).getWidth()-arr.get(count).getX()-arr.get(count).getWidth());
                                //image_x_coordinate=image.getTranslateX();
                                //System.out.println("coordinate hai "+image.getTranslateX());
                                //image_x_coordinate=arr.get(count+1).getX()+arr.get(count+1).getWidth()-image.getFitWidth();
                                imageTransition.play();

                                //image.setY(image.getY()+image.getFitHeight());







                                //image.setLayoutX(arr.get(count+1).getX()+arr.get(count+1).getWidth()-image.getFitWidth()-23);

                                //List<TranslateTransition> transitions = new ArrayList<>();
//                                for (int i = 0; i < 21; i++) {
//                                    TranslateTransition rectangleTransition = new TranslateTransition(Duration.millis(500), arr.get(i));
//                                    rectangleTransition.setByX((-1)*minus);
//                                    transitions.add(rectangleTransition);
//                                }
//                                //image.setX(image.getX()-minus);
//
//                                // Play transitions for rectangles
//                                int count1=0;
//                                for (TranslateTransition transition : transitions) {
//                                    transition.play();
//                                    //arr.get(count1).setX(arr.get(count1).getX()-minus);
//                                    count1++;
//                                }
                                //image.setX(arr.get(count+1).getX()+arr.get(count+1).getWidth()-image.getFitWidth()-minus);

                                // Create TranslateTransitions for rectangles

                            }

//
                        }catch (NullPointerException e) {
                            System.out.println("exception hai");
                        }finally{
                            //double minus = arr.get(count + 1).getWidth() + (arr.get(count + 1).getX() - arr.get(count).getX());

                            try{
                                Thread.sleep(100);
                            } catch (Exception e) {
                                System.out.println("error in sleep");
                            }
                            pane.getChildren().remove(rectangle);

//                            image.setX(height+2*image.getFitWidth());
//                            image.setY(image.getY());
                        }

                    })
            );
            t2.play();
            //System.out.println("coordinate image "+image.getX());
            Timeline ttt=new Timeline(
                    new KeyFrame(Duration.millis(1750),eventt->{
                        double minus=(arr.get(count+1).getX()-arr.get(count).getX());
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
                        for (int i = 0; i < 21; i++) {
                            TranslateTransition rectangleTransition = new TranslateTransition(Duration.millis(500), arr.get(i));
                            rectangleTransition.setByX((-1)*minus);
                            transitions.add(rectangleTransition);
                        }
                        //image.setX(image.getX()-minus);
                        // Play transitions for rectangles
                        int count1=0;
                        for (TranslateTransition transition : transitions) {
                            transition.play();
                            //arr.get(count1).setX(arr.get(count1).getX()-minus);
                            count1++;
                        }

                    })
            );
            ttt.play();

        }
        public void move_the_frame() {
            t23=new Timeline(
                    new KeyFrame(Duration.millis(5000),e->{
                        pane.setTranslateX(pane.getTranslateX()-20);
                        btn.setTranslateX((-1)*pane.getTranslateX());

                    })
            );
            //t23.setCycleCount(Timeline.INDEFINITE);
            t23.play();
        }

        public void rectangel_maker() {
            Random random=new Random();
            Rectangle r1=new Rectangle(10,200,40,200);
            //image.setX(50-image.getFitWidth());
            //image_x_coordinate=image.getX();
            arr.add(r1);
            int distance_between_poles=random.nextInt(100);
            int width_of_the_pole=random.nextInt(70);
            if (width_of_the_pole<35) {
                width_of_the_pole=35;
            }
            if (distance_between_poles<20) {
                distance_between_poles=20;
            }
            //int width_of_the_pole=40;
            int distance=50;
            for (int i=0;i<20;i++) {
                Rectangle r=new Rectangle(distance+width_of_the_pole,200,width_of_the_pole,200);
                distance=distance+width_of_the_pole+distance_between_poles;
                distance_between_poles= random.nextInt(100);
                width_of_the_pole= random.nextInt(70);
                if (width_of_the_pole<35) {
                    width_of_the_pole=35;
                }
                if (distance_between_poles<30) {
                    distance_between_poles=30;
                }
//                arr.add(r);
                //width_of_the_pole=40;
                arr.add(r);
            }
        }
    }




