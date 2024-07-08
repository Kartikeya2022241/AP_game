package com.example.demo1;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;



//package com.example.demo1;

import com.example.demo1.HelloApplication;
import com.example.demo1.make_rectangles;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Objects;
import java.util.Vector;

public class make_rectanglesTest {

    private make_rectangles testInstance;
    private double initialDistance;
    private Vector<Rectangle> testArr;
    private Vector<ImageView> testCherries;
    private int initialCountCherries;
    private HelloApplication testHelloApplication;

    private ImageView image;

    @Before
    public void setUp() {
        // Initialize your test environment here
        initialDistance = 100.0;
        testArr = new Vector<>();
        testCherries = new Vector<>();
        initialCountCherries = 0;
        testHelloApplication = new HelloApplication(); // This might need to be a mock if it's a complex class
        //image=new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("cherry_icon-removebg-preview.png"))));
//        for (int i=0;i<200;i++) {
//            testCherries.add(image);
//        }
        //testHelloApplication.set_obje(testHelloApplication);
        //HelloApplication.l();

        testInstance = new make_rectangles(initialDistance, testArr, testCherries, initialCountCherries, testHelloApplication);
    }

    @Test
    public void testDoWork1() {
        testInstance.do_work();
        System.out.println("this one");
        // Test the expected outcomes, for example, the size of the rectangles vector
        assertNotNull("Array should not be null", testInstance.getArr());
        assertFalse("Array should not be empty after do_work", testInstance.getArr().isEmpty());
        testDoWork2();

        // Add more assertions here based on expected behavior
        // You might want to check the properties of the rectangles added, etc.
    }

    @Test
    public void testDoWork2() {
        testInstance.do_work();
        assertEquals(40, testArr.size());
        //testInstance.do_work();
        //testInstance.do_work();
        System.out.println("this one1");


    }

    // Additional tests can be written to test other methods or behaviors

}

