package com.example.jsonplaceholdertest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {
    TextView question;
    Button check;
    EditText answer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_words);
        question = findViewById(R.id.question);
        check = findViewById(R.id.Check);
        answer = findViewById(R.id.answer);
    }
}
