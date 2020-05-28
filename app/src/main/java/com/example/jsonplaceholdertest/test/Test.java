package com.example.jsonplaceholdertest.test;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


import java.io.Serializable;
import java.util.ArrayList;


@Entity(tableName = "user_ tests")
public class Test implements Serializable {
    @ColumnInfo(name = "COLUMN_RIGHT_ANSWERS")
    private ArrayList<String> rightAnswers;
    @ColumnInfo(name = "COLUMN_TYPE")
    private String type;
    @ColumnInfo(name = "COLUMN_DIFFICULTY")
    private String difficulty;

    private int size;
    @ColumnInfo(name = "COLUMN_QUESTIONS")
    private ArrayList<String>  questions;
    @ColumnInfo(name = "COLUMN_NAME")
    private String name;
    @ColumnInfo(name = "COLUMN_ID")
    @PrimaryKey(autoGenerate = true)
    private long id;

    public Test(String name, ArrayList<String>  questions, ArrayList<String>  rightAnswers, String type, String difficulty) {
        this.questions = questions;
        this.rightAnswers = rightAnswers;
        this.type = type;
        this.difficulty = difficulty;
        this.name = name;
    }
    @NonNull
    @Override
    public String toString() {
        return name+"\t"+"Difficulty:"+"\t"+difficulty+"\t"+"Type:"+"\t"+type;
    }
    public void setRightAnswers(ArrayList<String> rightAnswers) {
        this.rightAnswers = rightAnswers;
    }
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
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
