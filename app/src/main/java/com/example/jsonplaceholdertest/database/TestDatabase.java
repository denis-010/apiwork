package com.example.jsonplaceholdertest.database;

import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;

import com.example.jsonplaceholdertest.Converters;
import com.example.jsonplaceholdertest.test.Test;
import com.example.jsonplaceholdertest.ui.notifications.Word;



@Database(entities = {Test.class, Word.class}, version = 2)
@TypeConverters({Converters.class})
public abstract class TestDatabase extends RoomDatabase {

        private static TestDatabase instance;
        protected abstract TestDao testDao();

        public static synchronized TestDatabase getInstance(Context context) {
            if (instance == null) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        TestDatabase.class, "test_database")
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback)
                        .build();
            }
            return instance;
        }
        private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
                new PopulateDbAsyncTask(instance).execute();
            }
        };
        private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
            private TestDao testdao;
            private PopulateDbAsyncTask(TestDatabase db) {
                testdao  = db.testDao();
            }
           @Override
          protected Void doInBackground(Void... voids) {
                return null;
           }
        }
    }

