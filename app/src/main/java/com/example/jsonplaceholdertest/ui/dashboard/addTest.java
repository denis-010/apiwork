package com.example.jsonplaceholdertest.ui.dashboard;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;

import com.example.jsonplaceholdertest.R;
import com.example.jsonplaceholdertest.test.NameYourTest;
import com.example.jsonplaceholdertest.test.SharedTestViewModel;
import com.example.jsonplaceholdertest.test.Test;

import java.util.ArrayList;
import java.util.List;


public class addTest extends  Fragment {
    String name;
    private ArrayList<String> questions;
    private ArrayList<String> rightAnswers;
    private EditText YourQuestion;
    private EditText RightAnswer;
    private Button NextQuestion;
    boolean TestIsCreated;
    SharedTestViewModel myViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        questions = new ArrayList<>();
        rightAnswers = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.add_test, container, false);

        YourQuestion = root.findViewById(R.id.YourQuestion);
        RightAnswer = root.findViewById(R.id.add_right_answer);
        NextQuestion = root.findViewById(R.id.next_question);

        NextQuestion.setOnClickListener(nextQuestion);
        return root;
    }

    private View.OnClickListener nextQuestion = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addQuestion();
            YourQuestion.getText().clear();
            RightAnswer.getText().clear();
        }
    };
    private View.OnClickListener done = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            NameYourTest frag = new NameYourTest();
            FragmentTransaction mTransaction = getChildFragmentManager().beginTransaction();
            mTransaction.replace(R.id.name_of_new_test, frag).commit();

        }
    };
    private void addQuestion(){
        questions.add(YourQuestion.getText().toString());
        rightAnswers.add(YourQuestion.getText().toString());
    }
}
