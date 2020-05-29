package com.example.jsonplaceholdertest.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonplaceholdertest.MainActivity;
import com.example.jsonplaceholdertest.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class TestResultOverview extends Fragment {
    int wrong;
    int right;
    RecyclerView result_of_test;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.test_overview,container,false);
        Bundle bundle = getArguments();
        ArrayList<String> rightAnswers = bundle.getStringArrayList("RightAnswers");
        ArrayList<Integer> results = bundle.getIntegerArrayList("results");
        result_of_test.setLayoutManager(new RecyclerView.LayoutManager() {
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return null;
            }
        });
        right = 0;
        wrong = 0;
        result_of_test = root.findViewById(R.id.results_of_test_list);
        for (int i = 0; i <results.size();i++){
            if(results.get(i)==1){
                right+=1;
            }
        }
        DecimalFormat df = new DecimalFormat("#.##");
        df.format(right/rightAnswers.size());
        ResultAdapter resultAdapter = new ResultAdapter(getActivity(), bundle.getStringArrayList("Answers"),results);
        result_of_test.setAdapter(resultAdapter);
        return root;
    }

}
