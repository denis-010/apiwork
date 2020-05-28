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
import java.util.List;

public class TestFragment extends Fragment {
    private TextView question;
    private Button check;
    private EditText answer;
    private Test testPickedByUser;

    TestUtility testUtility;
    private SharedTestViewModel sharedTestViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.new_words,container,false);

        question = root.findViewById(R.id.question);
        check = root.findViewById(R.id.Check);
        answer = root.findViewById(R.id.answer);
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
            Bundle bundle = new Bundle();
            if(testUtility.Check()) {
                if(testUtility.testHasEnded()){
                    bundle.putIntegerArrayList("Results",testUtility.getResult());
                    Navigation.findNavController(v).navigate(R.id.action_testFragment_to_testResultOverview);
                }
                else{
                    bundle.putString("RESULT_OK", "Your Answer is correct!");
                    testUtility.MoveToNextQuestion();
                    Navigation.findNavController(v).navigate(R.id.action_testFragment_to_resultoftest,bundle);

                }
            }
            else{
                bundle.putString("RESULT_OK", "Right answer is"+"\t"+testUtility.getRightAnswer());
                testUtility.MoveToNextQuestion();
                Navigation.findNavController(v).navigate(R.id.action_testFragment_to_resultoftest, bundle);
            }
        }
    };

}