package com.example.jsonplaceholdertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask task = new SendRequsetTask();
                task.execute();
            }
        });
    }

    private class SendRequsetTask extends AsyncTask{
        private Word word;
        @Override
        protected Object doInBackground(Object[] objects) {
            JSONPlaceholderAPI api = JsonConnection.getInstance().getAPI();
            Call<Word> call = api.getWord("dead");
            try {
                Response<Word> response = call.execute();
                word = response.body();
            } catch (IOException e) {
                word = null;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            if (word == null) {
                textView.setText("Null response");
            } else if (word.getWord() == null) {
                textView.setText("Empty title");
            } else {
                textView.setText(word.getWord());
            }
        }
    }
}
