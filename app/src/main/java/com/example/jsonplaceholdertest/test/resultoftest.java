package com.example.jsonplaceholdertest.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.example.jsonplaceholdertest.R;

public class resultoftest extends DialogFragment {
    Button nextQuestion;
    private TextView RightAnswer;
    private TextView CorrectOrWrong;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.result_of_test, container, false);
        nextQuestion = root.findViewById(R.id.Continue_test);
        nextQuestion.setOnClickListener(nextquestion);
        RightAnswer = root.findViewById(R.id.right_answer);
        CorrectOrWrong = root.findViewById(R.id.correct_or_not);

        Bundle bundle= getArguments();
        String[] strtext = bundle.getStringArray("RESULT_OK");
        CorrectOrWrong.setText(strtext[0]);
        RightAnswer.setText(strtext[1]);
        return root;
    }

    final View.OnClickListener nextquestion = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Navigation.findNavController(v).navigate(R.id.action_resultoftest_to_testFragment);
        }
    };
    @Override
    public void onDestroy() {
        super.onDestroy();
        resultoftest self = new resultoftest();
        getFragmentManager().beginTransaction().remove((Fragment) self).commitAllowingStateLoss();
    }
}
