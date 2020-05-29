package com.example.jsonplaceholdertest.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonplaceholdertest.R;
import com.example.jsonplaceholdertest.test.SharedTestViewModel;
import com.example.jsonplaceholdertest.test.Test;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private RecyclerView testList;
    private FloatingActionButton addtest;
    private SharedTestViewModel sharedTestViewModel;
    private TestAdapter adapter;
    private Button deleteAllTests;
    ArrayList<Test> UserTests;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        testList = root.findViewById(R.id.recyclerView);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        testList.setLayoutManager(layoutManager);
        deleteAllTests = root.findViewById(R.id.delete_all);
        addtest = root.findViewById(R.id.floatingActionButton);
        addtest.setOnClickListener(AddTest);
        deleteAllTests.setOnClickListener(deleteall);

        UserTests = new ArrayList<>();
        testList.setHasFixedSize(true);
        adapter =  new TestAdapter(getContext(), UserTests);
        testList.setAdapter(adapter);

        sharedTestViewModel = ViewModelProviders.of(this).get(SharedTestViewModel.class);
        sharedTestViewModel.getAllTests().observe(getActivity(), testListUpdateObserver);

        return root;
    }
    View.OnClickListener AddTest = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Navigation.findNavController(v).navigate(R.id.action_navigation_dashboard_to_addTest);
        }
    };
    public void onViewCreated(@NonNull View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    Observer<List<Test>> testListUpdateObserver = new Observer<List<Test>>() {
        @Override
        public void onChanged(List<Test> userArrayList) {
            adapter = new TestAdapter(getContext(),userArrayList);
            testList.setLayoutManager(new LinearLayoutManager(getContext()));
            testList.setAdapter(adapter);
        }
    };
    View.OnClickListener deleteall = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            sharedTestViewModel.deleteAllNotes();
        }
    };


}
