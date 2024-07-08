package com.example.demo1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Rotate_rod {
    private Rectangle rectangle;

    private Rotate rotate;

    public Rectangle getRod() {
        return rectangle;
    }

    public void setRod(Rectangle rod) {
        this.rectangle = rod;
    }

    public Rotate_rod(Rectangle rod,Rotate rotate) {
        this.rectangle = rod;
        this.rotate=rotate;
    }
    public void rotate_rod() {
        rotate = new Rotate(0, rectangle.getX() + rectangle.getWidth() / 2, rectangle.getY() +rectangle.getHeight());
        rectangle.getTransforms().add(rotate);
        Timeline te=new Timeline(
                new KeyFrame(Duration.millis(10), event->{
                    rotate.setAngle(rotate.getAngle()+1);
                })
        );
        te.setCycleCount(90);
        //te.setRate(1.5);
        te.play();
    }

}
