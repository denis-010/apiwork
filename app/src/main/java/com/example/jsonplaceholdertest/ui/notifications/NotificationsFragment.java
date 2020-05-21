package com.example.jsonplaceholdertest.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonplaceholdertest.R;
import com.example.jsonplaceholdertest.test.Test;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {
    private RecyclerView Vocabulary;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        Vocabulary = root.findViewById(R.id.vocabulary);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        Vocabulary.setLayoutManager(layoutManager);
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0 ; i < 3; i++){
            words.add("lol");
        }
        WordAdapter adapter = new WordAdapter(words.size(),getContext(),words);
        Vocabulary.setAdapter(adapter);
        return root;
    }
}
