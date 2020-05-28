package com.example.jsonplaceholdertest.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.jsonplaceholdertest.R;

public class NameYourTest extends Fragment {
    EditText name;
    EditText difficulty;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.name_your_tests,container,false);
        name =root.findViewById(R.id.name_of_new_test);
        difficulty = root.findViewById(R.id.difficulty);

        return root;
    }
    public String[] getCreatedTestInfo(){
        String name_of_test = name.getText().toString();
        String dificulty_of_test = difficulty.getText().toString();
        String[] data ={name_of_test,dificulty_of_test};
        return data;
    }

}
