package com.example.demo1;

import java.io.Serializable;
import java.util.Vector;

public class User implements Serializable {

    private game_state state;
    private String name;
    private final String password;

    private Vector<Integer> number_of_cherries;
    private int highes_number_of_cherries;

    private Vector<Integer> scores;
    private int highest_score;

    public User(String name,String password) {
        this.name=name;
        this.password=password;
        number_of_cherries=new Vector<>();
        scores=new Vector<>();
        highes_number_of_cherries=0;
        highest_score=0;
    }

    public void set_name(String name) {
        this.name=name;
    }

    public String get_name() {
        return this.name;
    }

    public String get_password() {
        return this.password;
    }

    public Vector<Integer> getScores() {
        return scores;
    }

    public void setScores(Vector<Integer> scores) {
        this.scores = scores;
    }

    public int getHighest_score() {
        return highest_score;
    }

    public void setHighest_score(int highest_score) {
        this.highest_score = highest_score;
    }

    public void add_score(int score) {
        this.scores.add(score);
    }

    public void add_cherries(int n) {
        this.number_of_cherries.add(n);
    }

    public int getHighes_number_of_cherries() {
        return highes_number_of_cherries;
    }

    public void setHighes_number_of_cherries(int highes_number_of_cherries) {
        this.highes_number_of_cherries = highes_number_of_cherries;
    }
    @Override
    public boolean equals(Object o) {
        if (o!=null && o.getClass()==this.getClass()) {
            User s=(User)o;
            return this.get_name().equals(s.get_name()) && this.get_password().equals(s.get_password());
        }
        return false;
    }

    public game_state getState() {
        return state;
    }

    public void setState(game_state state) {
        this.state = state;
    }
}
