package com.example.demo1;

import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Vector;

public class move_the_character extends something{
    private double height;
    private int count;

    private Scene scene;

    private boolean revert_flag;

    private ImageView image;

    private Vector<Rectangle> arr;

    private Vector<ImageView> cherries;

    private int current_cherry;

    private int collected_cherries;

    private boolean collected;

    private Pane pane;

    private boolean fall;

    private Text text1;

    private HelloApplication obj;

    public move_the_character(double height, int count, Scene scene, boolean revert_flag, ImageView image, Vector<Rectangle> arr, Vector<ImageView> cherries, int current_cherry, boolean collected, Pane pane, boolean fall, int collected_cherries, Text text1,HelloApplication obj) {
        this.height = height;
        this.count = count;
        this.scene = scene;
        this.revert_flag = revert_flag;
        this.image = image;
        this.arr = arr;
        this.cherries = cherries;
        this.current_cherry = current_cherry;
        this.collected = collected;
        this.pane = pane;
        this.fall=fall;
        this.collected_cherries=collected_cherries;
        this.text1=text1;
        this.obj=obj;

    }

    public void do_work() {
        TranslateTransition imageTransition = new TranslateTransition(Duration.millis(1000), image);
        try{
            if (height<arr.get(count+1).getX()-arr.get(count).getX()-arr.get(count).getWidth() || (height>arr.get(count+1).getX()+arr.get(count+1).getWidth()-arr.get(count).getX()-arr.get(count).getWidth())) {

                TranslateTransition t=new TranslateTransition(Duration.millis(1000),image);
                t.setByX(height+10);
                t.play();
                 obj.set_fall(true);
                fall=true;
                //falling_down.play();
                //pane.getChildren().remove(image);
            } else {
//
                imageTransition.setByX(arr.get(count+1).getX()+arr.get(count+1).getWidth()-arr.get(count).getX()-arr.get(count).getWidth());
//
                image.boundsInParentProperty().addListener((obs,old_bound,new_bound)-> {
                    // System.out.println("came here to check");
                    if (new_bound.intersects(cherries.get(current_cherry).getBoundsInParent()) && !collected) {
                        collected_cherries++;
                        obj.setCollected_cherries(collected_cherries);
                        this.text1.setText(Integer.toString(collected_cherries));
                        System.out.println(collected_cherries);
                        pane.getChildren().remove(cherries.get(current_cherry));
                        collected=true;
//                                    if (cherries.get(current_cherry).getX()<arr.get(count+1).getX() && cherries.get(current_cherry).getX()>arr.get(count).getX()+arr.get(count).getWidth()) {
//                                        current_cherry++;
//                                    }
                        //current_cherry++;
                    }

                });



//                            if (cherries.get(current_cherry).getX()<arr.get(count+1).getX() && cherries.get(current_cherry).getX()>arr.get(count).getX()+arr.get(count).getWidth()) {
//                                if (!revert_flag) {
////                                    if (image.getX()+image.getFitWidth()>=cherries.get(current_cherry).getX()) {
////
////                                    }
//                                    collected_cherries++;
//                                    System.out.println(collected_cherries);
//                                    pane.getChildren().remove(cherries.get(current_cherry));
//                                    //che=false;
//                                }
//                                this.current_cherry++;
//                                //this.revert_flag=false;
//                            }

//                            if (image.getBoundsInParent().intersects(cherries.get(current_cherry).getBoundsInParent())) {
//                                System.out.println("collected cherries");
//                            }
                imageTransition.play();
                imageTransition.setOnFinished(even-> {
                    if (cherries.get(current_cherry).getX()<arr.get(count+1).getX() && cherries.get(current_cherry).getX()>arr.get(count).getX()+arr.get(count).getWidth()) {
                        current_cherry++;
                        obj.set_current_cherry(current_cherry);
                    }
                    collected=false;
                    obj.set_collected(collected);
                    System.out.println("current_cherry "+current_cherry);
                });



            }

//
        }catch (NullPointerException e) {
            System.out.println("exception hai");
        } finally {

        }
    }
}
