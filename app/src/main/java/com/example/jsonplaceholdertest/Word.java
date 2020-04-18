package com.example.jsonplaceholdertest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Word {
    class result{
        public result(String definition, String partOfSpeech, String[] synonyms, String[] similarTo, String[] derivation, String[] typeOf, String[] hasTypes, String[] hasMembers, String[] examples) {
            this.definition = definition;
            this.partOfSpeech = partOfSpeech;
            this.synonyms = synonyms;
            this.similarTo = similarTo;
            this.derivation = derivation;
            this.typeOf = typeOf;
            this.hasTypes = hasTypes;
            this.hasMembers = hasMembers;
            this.examples = examples;
        }
        String definition;
        String partOfSpeech;
        String[] synonyms;
        String[] similarTo;
        String[] derivation;
        String[] typeOf;
        String[] hasTypes;
        String[] hasMembers;
        String[] examples;
    }
    @SerializedName("word")
    @Expose
    private String word;

    @SerializedName("results")
    @Expose
    private result[] results;

    @SerializedName("syllables")
    @Expose
    private String syllables;

    @SerializedName("pronunciation")
    @Expose
    private String pronunciation;
    @SerializedName("frequency")
    @Expose
    private float frequency;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public result[] getResults() {
        return results;
    }

    public void setResults(result[] results) {
        this.results = results;
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
}

