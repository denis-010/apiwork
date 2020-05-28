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
    public boolean Check(String answer){
        if(answer.equals(test.getRightAnswers().get(questionNumber))){
            result.add(1);
            questionNumber++;
            return true;
        }
        else{
            result.add(0);
            questionNumber++;
            return false;
        }
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
