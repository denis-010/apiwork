package com.example.jsonplaceholdertest.ui.notifications;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

@Entity(tableName = "words")
    public class Word {
    @ColumnInfo(name = "COLUMN_WORD")
    @SerializedName("word")
    @Expose
    private String word;
    @SerializedName("syllables")
    @Expose
    @ColumnInfo(name = "COLUMN_SYLLABLES")
    private String syllables;
    @SerializedName("definition")
    @Expose
    @ColumnInfo(name = "COLUMN_DEFINITION")
    private
    String definition;
    @SerializedName("partOfSpeech")
    @Expose
    @ColumnInfo(name = "COLUMN_PART_OF_SPEECH")
    private
    String partOfSpeech;
    @SerializedName("synonyms")
    @Expose
    @ColumnInfo(name = "COLUMN_SYNONYMS" )
    private
    ArrayList<String> synonyms;
    @SerializedName("examples")
    @Expose
    @ColumnInfo(name = "COLUMN_EXAMPLES")
    private
    ArrayList<String> examples;

    public Word(String word, String syllables, String definition, String partOfSpeech, ArrayList<String> synonyms, ArrayList<String> examples, String pronunciation, float frequency, int ID) {
        this.word = word;
        this.syllables = syllables;
        this.definition = definition;
        this.partOfSpeech = partOfSpeech;
        this.synonyms = synonyms;
        this.examples = examples;
        this.pronunciation = pronunciation;
        this.frequency = frequency;
        this.ID = ID;
    }

    public String getDefinition() {
        return definition;
    }
    @SerializedName("pronunciation")
    @Expose
    @ColumnInfo(name = "COLUMN_PRONUNCIATION")
    private String pronunciation;
    @SerializedName("frequency")
    @Expose
    @ColumnInfo(name = "COLUMN_FREQUENCY")
    private float frequency;
    @PrimaryKey
    @ColumnInfo(name = "COLUMN_ID")
    private int ID;


    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getPartOfSpeech() {
            return partOfSpeech;
    }
    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }
    public ArrayList<String> getSynonyms() {
            return synonyms;
    }
    public void setSynonyms(ArrayList<String> synonyms) {
            this.synonyms = synonyms;
    }
    public ArrayList<String> getExamples() {
        return examples;
    }
    public void setExamples(ArrayList<String> examples) {
        this.examples = examples;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
    public String getSyllables() {
        return syllables;
    }

    public void setSyllables(String syllables) {
        this.syllables = syllables;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }
    public float getFrequency() {
        return frequency;
    }
    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
}

