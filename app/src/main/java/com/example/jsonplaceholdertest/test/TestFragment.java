package com.example.jsonplaceholdertest.test;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

import com.example.jsonplaceholdertest.R;

import java.util.ArrayList;

public class TestFragment extends Fragment {

    TextView question;
    Button check;
    EditText answer;
    ArrayList<String> rightAnswers;
    ArrayList<String> questions;
    public int questionNumber;
    Test testPickedByUser;
    ArrayList<String> RightAnswers;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.new_words,container,false);
        questionNumber = 0;


        question = root.findViewById(R.id.question);
        check = root.findViewById(R.id.Check);
        answer = root.findViewById(R.id.answer);

        RightAnswers = new ArrayList<>();
        RightAnswers.add("lol");
        RightAnswers.add("what is lol");
        questions = new ArrayList<>();
        questions.add("lol");
        questions.add("What is lol");


        testPickedByUser= new Test("lol",questions,RightAnswers,"translation","easy");

        setQuestion(questions.get(questionNumber));
        check.setOnClickListener(nextquestion);
        return root;
    }
    public void setQuestion(String questions) {
        question.setText(questions);
    }
    public boolean Check(String rightAnswer){
        if(answer.getText().toString().equals(rightAnswer))
        {return true;}
        else{return false;}
    }
    View.OnClickListener nextquestion = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(Check(testPickedByUser.getRightAnswers().get(questionNumber))) {
                if(questionNumber == questions.size()){
                }
                else{
                    questionNumber++;
                    setQuestion(questions.get(questionNumber));
                    Navigation.findNavController(v).navigate(R.id.action_testFragment_to_resultoftest);
                }
            }
            else{
            }
        }
    };

}
