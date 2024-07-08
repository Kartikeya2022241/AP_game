package com.example.demo1;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.Objects;
import java.util.Random;
import java.util.Vector;

public class make_rectangles extends something implements Runnable{
    private double distance;
    private Vector<Rectangle> arr;

    private HelloApplication obje;
    int count_cherries;

    private Vector<ImageView> cherries;

    public double getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Vector<Rectangle> getArr() {
        return arr;
    }

    public void setArr(Vector<Rectangle> arr) {
        this.arr = arr;
    }

    public Vector<ImageView> getArr1() {
        return cherries;
    }

    public void setArr1(Vector<ImageView> arr1) {
        this.cherries = arr1;
    }

    public make_rectangles(double distance, Vector<Rectangle> arr, Vector<ImageView> arr1,int count,HelloApplication obj) {
        this.distance = distance;
        this.arr = arr;
        this.cherries = arr1;
        this.count_cherries=count;
        this.obje=obj;
    }

    public void do_work() {
        Random random=new Random();
//        Rectangle r1=new Rectangle(10,315,60,385);
//        //r1.setOpacity(0.75);
//        //image.setX(50-image.getFitWidth());
//        //image_x_coordinate=image.getX();
//        arr.add(r1);
        //Random random=new Random();
        int distance_between_poles=random.nextInt(270);
        int width_of_the_pole=random.nextInt(130);
        if (width_of_the_pole<20) {
            width_of_the_pole=20;
        }
        if (distance_between_poles<20) {
            distance_between_poles=20;
        }
//        Thread t1=new Thread(obje);
//        Thread t2=new Thread(obje);
//        Thread t3=new Thread(obje);
//        Thread t4=new Thread(obje);
//        Thread t5=new Thread(obje);
//
//        t1.start();
////        t2.start();
////        t3.start();
////        t4.start();
////        t5.start();
//        try {
//            t1.join();
////            t2.join();
////            t3.join();
////            t4.join();
////            t5.join();
//        } catch (Exception e) {
//            System.out.println("exception in thread join");
//        }
        for (int i=0;i<20;i++) {
            Rectangle r=new Rectangle(distance+distance_between_poles,315,width_of_the_pole,385);
            //r.setOpacity(0.75);
            if (true) {
                if (distance_between_poles>=50) {
                    ImageView i1=new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("cherry_icon-removebg-preview.png"))));
                    //ImageView i1=cherries.get(count_cherries);
                    count_cherries++;
                    i1.setFitWidth(20);
                    i1.setFitHeight(20);
                    i1.setX(distance+random.nextInt(distance_between_poles)-20);
                    if (i1.getX()<=r.getWidth()+r.getX()) {
                        i1.setX(i1.getX()+20);
                    }
                    i1.setY(319);
                    cherries.add(i1);
                }

            }
            distance=distance+width_of_the_pole+distance_between_poles;
            distance_between_poles= random.nextInt(270);
            width_of_the_pole= random.nextInt(130);

            if (width_of_the_pole<20) {
                width_of_the_pole=20;
            }
            if (distance_between_poles<20) {
                distance_between_poles=20;
            }
            //                arr.add(r);
            //width_of_the_pole=40;
            this.arr.add(r);
        }
        obje.set_cc(count_cherries);
    }

    public void run() {
        do_work();

    }
}
