package com.example.jsonplaceholdertest.ui.notifications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.jsonplaceholdertest.R;

import java.util.ArrayList;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordsViewHolder> {
    private static int viewHolderCount;
    private int numberOfItems;
    Context adapterContext;
    ArrayList<String> words;

    public WordAdapter(int numberOfItems, Context adapterContext, ArrayList<String> words) {
        this.numberOfItems = numberOfItems;
        viewHolderCount = 0;
        this.adapterContext = adapterContext;
        this.words = words;
    }
    @NonNull
    @Override
    public WordAdapter.WordsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.word_vocabulary;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view;
        view = inflater.inflate(layoutIdForListItem, parent, false);
        WordAdapter.WordsViewHolder viewHolder = new WordAdapter.WordsViewHolder(view);
        viewHolderCount++;
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull WordAdapter.WordsViewHolder holder, int position) {
        holder.bind(position);
    }
    @Override
    public int getItemCount() {
        return numberOfItems;
    }

    class WordsViewHolder extends RecyclerView.ViewHolder {

        TextView TextViewHolder;

        public WordsViewHolder(View WordView) {
            super(WordView);
            TextViewHolder = WordView.findViewById(R.id.wordsinfo);

            WordView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    WordFragment bottomSheet = new WordFragment();
                    bottomSheet.show(((AppCompatActivity)adapterContext).getSupportFragmentManager(), "exampleBottomSheet");
                }
            });
        }
        void bind(int listIndex) {
            TextViewHolder.setText(words.get(listIndex));
        }
    }
}
