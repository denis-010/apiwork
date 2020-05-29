package com.example.jsonplaceholdertest.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.jsonplaceholdertest.test.Test;
import com.example.jsonplaceholdertest.ui.notifications.Word;


import java.util.List;

@Dao
public interface TestDao {
    @Insert
    void insert(Test test);
    @Update
    void update(Test test);
    @Delete
    void delete(Test test);
    @Query("DELETE FROM `user_ tests`")
    void deleteAllTests();
    @Query("SELECT * FROM `user_ tests`")
    LiveData<List<Test>> getAllTests();
    @Insert
    void insert(Word word);
    @Update
    void update(Word word);
    @Delete
    void delete(Word word);
    @Query("DELETE FROM `words`")
    void deleteAllWords();
    @Query("SELECT * FROM `words`")
    LiveData<List<Word>> getAllWords();
}
