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
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.jsonplaceholdertest.R;

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
        if (questionNumber == test.getSize()){
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

    public static class TestFragment extends Fragment {
        private TextView question;
        private Button check;
        private EditText answer;
        private Test testPickedByUser;
        private ArrayList<String> usersAnswers;

        TestUtility testUtility;
        private SharedTestViewModel sharedTestViewModel;


        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View root = inflater.inflate(R.layout.new_words, container, false);
            question = root.findViewById(R.id.question);
            check = root.findViewById(R.id.Check);
            answer = root.findViewById(R.id.answer);

            usersAnswers = new ArrayList<>();

            sharedTestViewModel = ViewModelProviders.of(getActivity()).get(SharedTestViewModel.class);
            sharedTestViewModel.getTest().observe(getActivity(), new Observer<Test>() {
                @Override
                public void onChanged(@Nullable Test tests) {
                    testPickedByUser = tests;
                }
            });

            testUtility = new TestUtility(testPickedByUser);
            question.setText(testUtility.getQuestion());
            check.setOnClickListener(nextquestion);
            return root;
    }
        private View.OnClickListener nextquestion = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usersAnswers.add(answer.getText().toString());
                Bundle bundle = new Bundle();
                if(testUtility.testHasEnded()) {
                    bundle.putIntegerArrayList("results",testUtility.getResult());
                    bundle.putStringArrayList("Answers",usersAnswers);
                    bundle.putStringArrayList("RightAnswers",testPickedByUser.getRightAnswers());
                    Navigation.findNavController(v).navigate(R.id.action_testFragment_to_testResultOverview,bundle);
                }else {
                    if (testUtility.Check(answer.getText().toString())) {
                        bundle.putStringArray("RESULT_OK", new String[]{"Correct!", "Your Answer is correct!"});
                        resultoftest dialogFragment = new resultoftest();
                        dialogFragment.show(getChildFragmentManager(),"resultoftest");
                        dialogFragment.setArguments(bundle);
                    } else {
                        bundle.putStringArray("RESULT_OK", new String[]{"Wrong", "Right answer is" + "\t" + testUtility.getRightAnswer()});
                        resultoftest dialogFragment = new resultoftest();
                        dialogFragment.show(getChildFragmentManager(),"resultoftest");
                        dialogFragment.setArguments(bundle);
                    }

                }

            }
        };
    }
}
