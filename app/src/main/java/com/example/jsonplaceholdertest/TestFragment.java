package com.example.jsonplaceholdertest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

public class TestFragment extends Fragment {
    TextView question;
    Button check;
    EditText answer;
    @Override
    public View onCreate(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.new_words,container,false);
        Button check = view.findViewById(R.id.Check);
        TextView question = view.findViewById(R.id.question);
        EditText answer = view.findViewById(R.id.answer);
        return view;
    }
}
