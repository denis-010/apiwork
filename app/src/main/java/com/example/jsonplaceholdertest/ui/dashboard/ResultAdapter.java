package com.example.jsonplaceholdertest.ui.dashboard;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonplaceholdertest.R;


import java.util.ArrayList;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.TestsViewHolder> {

    private static int viewHolderCount;
    private ArrayList<String> users_answers;
    private ArrayList<String> answers;
    private Context adapterContext;


    public ResultAdapter(Context adapterContext, ArrayList<String> answers, ArrayList users_answers) {
        viewHolderCount = 0;
        this.adapterContext = adapterContext;
        this.users_answers = users_answers;
        this.answers = answers;

    }

    @NonNull
    @Override
    public TestsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.result_of_in_overview;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view;
        view = inflater.inflate(layoutIdForListItem, parent, false);
        TestsViewHolder viewHolder = new TestsViewHolder(view);
        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestsViewHolder holder, int position) {
        holder.rightAnwers.setText(viewHolderCount);

    }

    @Override
    public int getItemCount() {
        return viewHolderCount;
    }

    class TestsViewHolder extends RecyclerView.ViewHolder {

        TextView UsersAnswers;
        TextView rightAnwers;

        public TestsViewHolder(final View View) {
            super(View);

            UsersAnswers = View.findViewById(R.id.right_answer);
            rightAnwers = View.findViewById(R.id.user_answer);
            rightAnwers.setText(users_answers.get(viewHolderCount));
            UsersAnswers.setText(answers.get(viewHolderCount));
        }
    }
}

