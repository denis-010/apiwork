package com.example.jsonplaceholdertest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestsViewHolder>{
    private static int viewHolderCount;
    private int numberOfItems;

    public TestAdapter(int numberOfItems){
        this.numberOfItems = numberOfItems;
        viewHolderCount = 0;
    }
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

        public TestsViewHolder(View TestView){
            super(TestView);

            listItemView = TestView.findViewById(R.id .Test);
            TextViewHolder = TestView.findViewById(R.id.testInformation);
            TestView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){

                }
            });
        }
        void bind(int listIndex){
            TextViewHolder.setText(String.valueOf(listIndex));
        }
    }
}