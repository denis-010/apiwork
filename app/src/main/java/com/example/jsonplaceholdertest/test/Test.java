package com.example.jsonplaceholdertest.test;

import androidx.annotation.NonNull;

import java.util.ArrayList;


public class Test {
    private ArrayList<String> rightAnswers;
    private String type;
    private String difficulty;
    private int size;
    private ArrayList<String>  questions;
    private String name;

    public Test(String name, ArrayList<String>  questions, ArrayList<String>  rightAnswers, String type, String difficulty) {
        this.questions = questions;
        this.rightAnswers = rightAnswers;
        this.type = type;
        this.difficulty = difficulty;
        this.name = name;
    }
    @NonNull
    @Override
    public String toString() { return name+"\t"+"Difficulty:"+"\t"+difficulty+"\t"+"Type:"+"\t"+type; }
    public void setRightAnswers(ArrayList<String> rightAnswers) { this.rightAnswers = rightAnswers; }
    public void setType(String type) {
        this.type = type;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public void setQuestions(ArrayList<String> questions) {
        this.questions = questions;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<String> getRightAnswers() {
        return rightAnswers;
    }
    public String getType() {
        return type;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public int getSize() {
        return size;
    }
    public ArrayList<String> getQuestions() {
        return questions;
    }
    public String getName() {
        return name;
    }
}
