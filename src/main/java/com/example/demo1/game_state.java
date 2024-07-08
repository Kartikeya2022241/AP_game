package com.example.demo1;

import java.io.Serializable;

public class game_state implements Serializable {
    private int score;
    private int cherries;

    public game_state(int score, int cherries) {
        this.score = score;
        this.cherries = cherries;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCherries() {
        return cherries;
    }

    public void setCherries(int cherries) {
        this.cherries = cherries;
    }
}
