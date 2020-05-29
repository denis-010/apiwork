package com.example.jsonplaceholdertest.api;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jsonplaceholdertest.MainActivity;
import com.example.jsonplaceholdertest.R;
import com.example.jsonplaceholdertest.test.SharedTestViewModel;
import com.example.jsonplaceholdertest.ui.notifications.Word;
import com.example.jsonplaceholdertest.ui.notifications.WordsApi;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class RequestWords extends Activity {
    TextView textView;
    Button button;
    Button NextActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        Button home= findViewById(R.id.button3);
        home.setOnClickListener(homescreen);
        button = findViewById(R.id.button);
        button.setOnClickListener(resquet);
}
    View.OnClickListener homescreen = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(RequestWords.this, MainActivity.class);
            startActivity(i);
        }
    };
    View.OnClickListener resquet = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SendRequsetTask task = new SendRequsetTask();
            task.execute();
        }
    };

    private class SendRequsetTask extends AsyncTask {
        private WordsApi word;

        @Override
        protected Object doInBackground(Object[] objects) {
            ApiConnection api = JsonConnection.getInstance().getAPI();
            Call<WordsApi> call = api.getWord("cool");
            try {
                Response<WordsApi> response = call.execute();
                word = response.body();
            } catch (IOException e) {
                e.printStackTrace();
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
                textView.setText((CharSequence) word.getPronunciation());
            }
        }
    }
}
