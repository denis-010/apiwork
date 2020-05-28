package com.example.jsonplaceholdertest.test;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.jsonplaceholdertest.database.TestRepository;


import java.util.ArrayList;
import java.util.List;

public class SharedTestViewModel extends AndroidViewModel {
    ArrayList<Test> testArrayList;
    Test testForTesting;
    TestRepository repository;
    private LiveData<List<Test>> allTests;
    private MutableLiveData<Test> PickedTest = new MutableLiveData<>();

    public void setPickedTest(Test test){
        PickedTest.setValue(test);
    }
    public LiveData<Test> getTest (){
        return PickedTest;
    }
    public SharedTestViewModel(@NonNull Application application){
        super(application);
        repository = new TestRepository(application);
        allTests = repository.getAllTests();
        init();
    }

    public LiveData<List<Test>> getAllTests(){
        return allTests;
    }
    public void insert(Test test){
        repository.insert(test);
    }
    public void update(Test test ) {
        repository.update(test);
    }
    public void delete(Test test) {
        repository.delete(test);
    }
    public void deleteAllNotes() {
        repository.deleteAllTest();
    }
    public void init(){
        ArrayList<String> rightAnswers = new ArrayList<>();
        rightAnswers.add("1");
        ArrayList<String> questions = new ArrayList<>();
        questions.add("1");
        testForTesting = new Test("test",questions,rightAnswers,"easy","translation");
        insert(testForTesting);
    }
    public void populateList(){
        ArrayList<String> rightAnswers = new ArrayList<>();
        rightAnswers.add("1");
        ArrayList<String> questions = new ArrayList<>();
        questions.add("1");
        testForTesting = new Test("test",questions,rightAnswers,"easy","translation");
        testArrayList.add(testForTesting);
    }
}
