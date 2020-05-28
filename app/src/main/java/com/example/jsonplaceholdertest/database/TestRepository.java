package com.example.jsonplaceholdertest.database;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;

import com.example.jsonplaceholdertest.test.Test;

import java.util.List;

public class TestRepository {
    private TestDao testDao;
    private LiveData<List<Test>> allTests;

    public TestRepository(Application application) {
        TestDatabase database = TestDatabase.getInstance(application);
        testDao = database.testDao();
        allTests = testDao.getAllTests();
    }

    public void insert(Test test) {
        new InsertTestsAsyncTask(testDao).execute(test);
    }
    public void update(Test test) {
        new UpdateTestAsyncTask(testDao).execute(test);
    }
    public void delete(Test test) {
        new DeleteTestAsyncTask(testDao).execute(test);
    }
    public void deleteAllTest() {
        new DeleteAllTestsAsyncTask(testDao).execute();
    }
    public LiveData<List<Test>> getAllTests() {
        return allTests;
    }

    public TestDao getTest() {
        return testDao;
    }

    private static class InsertTestsAsyncTask extends AsyncTask<Test, Void, Void> {
        private TestDao testDao;
        private InsertTestsAsyncTask(TestDao testDao) {
            this.testDao = testDao;
        }
        @Override
        protected final Void doInBackground(Test... tests) {
            testDao.insert(tests[0]);
            return null;
        }

    }

    private static class UpdateTestAsyncTask extends AsyncTask<Test, Void, Void> {
        private TestDao testDao;
        private UpdateTestAsyncTask(TestDao noteDao) {
            this.testDao = noteDao;
        }
        @Override
        protected Void doInBackground(Test... tests) {
            testDao.update(tests[0]);
            return null;
        }
    }

    private static class DeleteTestAsyncTask extends AsyncTask<Test, Void, Void> {
        private TestDao testDao;
        private DeleteTestAsyncTask(TestDao testDao) {
            this.testDao = testDao;
        }
        @Override
        protected Void doInBackground(Test... tests) {
            testDao.delete(tests[0]);
            return null;
        }
    }

    private static class DeleteAllTestsAsyncTask extends AsyncTask<Void, Void, Void> {
        private TestDao noteDao;
        private DeleteAllTestsAsyncTask(TestDao testDao) {
            this.noteDao = testDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAllTests();
            return null;
        }
    }
}