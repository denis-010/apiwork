package com.example.jsonplaceholdertest.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonplaceholdertest.R;
import com.example.jsonplaceholdertest.test.Test;
import com.example.jsonplaceholdertest.test.SharedTestViewModel;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestsViewHolder> {
    SharedTestViewModel sharedTestViewModel;
    private static int viewHolderCount;
    private int numberOfItems;
    Context adapterContext;
    List<Test> UserTests;

    public TestAdapter(Context adapterContext, List<Test> UserTests) {
        viewHolderCount = 0;
        this.adapterContext = adapterContext;
        this.UserTests = UserTests;

    }
    public void setUserTests(List<Test> newTests){
        UserTests = newTests;
        notifyDataSetChanged();
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
        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestsViewHolder holder, int position) {
        Test currentTest = UserTests.get(position);
        holder.TextViewHolder.setText(currentTest.toString());

    }

    @Override
    public int getItemCount() {
        return UserTests.size();
    }

    class TestsViewHolder extends RecyclerView.ViewHolder {

        LinearLayout listItemView;
        TextView TextViewHolder;

        public TestsViewHolder(final View TestView) {
            super(TestView);

            listItemView = TestView.findViewById(R.id.Test);
            TextViewHolder = TestView.findViewById(R.id.testInformation);
            TestView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sharedTestViewModel = ViewModelProviders.of((FragmentActivity) adapterContext).get(SharedTestViewModel.class);
                    sharedTestViewModel.setPickedTest(UserTests.get(viewHolderCount-1));
                    Navigation.findNavController(v).navigate(R.id.action_navigation_dashboard_to_nested_graph_test);
                }
            });
        }
    }
}
