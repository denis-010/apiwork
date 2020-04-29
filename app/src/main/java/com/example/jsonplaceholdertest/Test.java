package com.example.jsonplaceholdertest;

import java.util.Arrays;

public class Test {
    String[] rightAnswers;
    String type;
    String difficulty;

    public Test(String[] rightAnswers, String type, String difficulty) {
        this.rightAnswers = rightAnswers;
        this.type = type;
        this.difficulty = difficulty;
    }
    @Override
    public String toString() {
        return "Test" + "rightAnswers=" + Arrays.toString(rightAnswers) +
                ", type:'" + type +
                ", difficulty:'" + difficulty;
    }

    public String[] getRightAnswers() {
        return rightAnswers;
    }

    public void setRightAnswers(String[] rightAnswers) {
        this.rightAnswers = rightAnswers;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }


}
