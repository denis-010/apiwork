package com.example.jsonplaceholdertest.ui.dashboard;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonplaceholdertest.R;
import com.example.jsonplaceholdertest.test.Test;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private RecyclerView testList;
    private FloatingActionButton addtest;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        testList = root.findViewById(R.id.recyclerView);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        testList.setLayoutManager(layoutManager);

        addtest = root.findViewById(R.id.floatingActionButton);
        addtest.setOnClickListener(AddTest);

        ArrayList<Test> UserTests = new ArrayList<>();
        for (int i = 0 ; i < 3; i++){
          ArrayList<String> RightAnswers = new ArrayList<>();
          RightAnswers.add("lol");
          ArrayList<String> questions = new ArrayList<>();
          questions.add("lol");
          Test test = new Test("lol",RightAnswers,questions,"i"+1,"i"+1);
          UserTests.add(test);
    }
        testList.setHasFixedSize(true);
        TestAdapter adapter =  new TestAdapter(UserTests.size(),getContext(), UserTests);
        testList.setAdapter(adapter);
        return root;
    }
    View.OnClickListener AddTest = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Navigation.findNavController(v).navigate(R.id.action_navigation_dashboard_to_addTest);
        }
    };

}
