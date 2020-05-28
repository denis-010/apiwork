package com.example.jsonplaceholdertest.test;

import java.util.ArrayList;

public class TestUtility {
    private Test test;
    private int questionNumber;
    private ArrayList<Integer> result;
    public TestUtility(Test test){
        this.test = test;
        questionNumber = 0;
        result = new ArrayList<>();
    }
    public boolean Check(){
        if(test.getQuestions().get(questionNumber).equals(test.getRightAnswers().get(questionNumber))){
            result.add(1);
            return true;
        }
        else{
            result.add(0);
            return false;
        }
    }
    public void MoveToNextQuestion(){
        questionNumber++;
    }
    public String getQuestion(){
        return test.getQuestions().get(questionNumber);
    }
    public boolean testHasEnded(){
        if (questionNumber == test.getSize()-1){
            return true;
        }
        else{
            return false;
        }
    }

    public ArrayList<Integer> getResult() {
        return result;
    }
    public String getRightAnswer(){
        return test.getRightAnswers().get(questionNumber);
    }

}
