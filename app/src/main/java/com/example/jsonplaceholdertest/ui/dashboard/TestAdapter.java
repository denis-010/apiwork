package com.example.jsonplaceholdertest.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonplaceholdertest.MainActivity;
import com.example.jsonplaceholdertest.R;
import com.example.jsonplaceholdertest.test.Test;
import com.example.jsonplaceholdertest.test.TestFragment;

import java.util.ArrayList;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestsViewHolder>{
    private static int viewHolderCount;
    private int numberOfItems;
    Context adapterContext;
    ArrayList<Test> UserTests;

    public TestAdapter(int numberOfItems, Context adapterContext,ArrayList<Test> UserTests){
        this.numberOfItems = numberOfItems;
        viewHolderCount = 0;
        this.adapterContext = adapterContext;
        this.UserTests = UserTests;
    }//comment
    @NonNull
    @Override
    public TestsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.user_tests_lists;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view;
        view = inflater.inflate(layoutIdForListItem, parent, false);
        TestsViewHolder viewHolder = new TestsViewHolder(view);
        viewHolder.TextViewHolder.setText("");
        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestsViewHolder holder, int position) {
        holder.bind(position);
    }
    @Override
    public int getItemCount() {
        return numberOfItems;
    }

    class TestsViewHolder extends RecyclerView.ViewHolder{

        LinearLayout listItemView;
        TextView TextViewHolder;

        public TestsViewHolder(final View TestView){
            super(TestView);

            listItemView = TestView.findViewById(R.id.Test);
            TextViewHolder = TestView.findViewById(R.id.testInformation);
            TestView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    Navigation.findNavController(v).navigate(R.id.action_navigation_dashboard_to_nested_graph_test);
                }
            });
        }
        void bind(int listIndex){
            TextViewHolder.setText(UserTests.get(listIndex).toString());
        }
    }
}
