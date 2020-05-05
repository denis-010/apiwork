package com.example.jsonplaceholdertest;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyTests extends AppCompatActivity {
    private RecyclerView testList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_tests);

        testList = findViewById(R.id.recyclerView);

        ArrayList<Test> UserTests = new ArrayList<>();
        for (int i = 0 ; i < 50; i++){
            String RightAnswers[] = {"lol"};
            Test test = new Test(RightAnswers,"i","i", "name"+i);
            UserTests.add(test);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        testList.setLayoutManager(layoutManager);
        testList.setHasFixedSize(true);
        TestAdapter adapter =  new TestAdapter(50,this, UserTests);
        testList.setAdapter(adapter);
    }
}
