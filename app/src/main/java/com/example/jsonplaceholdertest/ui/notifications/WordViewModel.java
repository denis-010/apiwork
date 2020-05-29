package com.example.jsonplaceholdertest.ui.notifications;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jsonplaceholdertest.database.TestRepository;
import com.example.jsonplaceholdertest.test.SharedTestViewModel;
import com.example.jsonplaceholdertest.test.Test;

import java.util.ArrayList;
import java.util.List;

public class WordViewModel extends SharedTestViewModel {
    ArrayList<Word> vocabulary;
    Test testForTesting;
    TestRepository repository;
    private LiveData<List<Word>> allWords;
    private MutableLiveData<Word> PickedWord = new MutableLiveData<>();

    public LiveData<Word> getWord (){
        return PickedWord;
    }
    public WordViewModel(@NonNull Application application){
        super(application);
        repository = new TestRepository(application);
        allWords = repository.getAllWords();
        init();
    }

    public LiveData<List<Word>> getAllWords(){
        return allWords;
    }
    public void insert(Word word){
        repository.insert(word);
    }
    public void update(Word word ) {
        repository.update(word);
    }
    public void delete(Word word) { repository.delete(word); }
    public void deleteAllNotes() {
        repository.deleteAllTest();
    }
    public void init(){
    }
}
