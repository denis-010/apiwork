package com.example.jsonplaceholdertest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Word {
    @SerializedName("word")
    @Expose
    private String word;
    @SerializedName("results")
    @Expose
    private result[] results;



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
        @SerializedName("definition")
        @Expose
        String definition;
        @SerializedName("partOfSpeech")
        @Expose
        String partOfSpeech;
        @SerializedName("synonyms")
        @Expose
        String[] synonyms;
        @SerializedName("similarTo")
        @Expose
        String[] similarTo;
        @SerializedName("derivation")
        @Expose
        String[] derivation;
        @SerializedName("typeOf")
        @Expose
        String[] typeOf;
        @SerializedName("hasTypes")
        @Expose
        String[] hasTypes;
        @SerializedName("hasMembers")
        @Expose
        String[] hasMembers;
        @SerializedName("examples")
        @Expose
        String[] examples;


        public String getDefinition() {
            return definition;
        }

        public void setDefinition(String definition) {
            this.definition = definition;
        }

        public String getPartOfSpeech() {
            return partOfSpeech;
        }

        public void setPartOfSpeech(String partOfSpeech) {
            this.partOfSpeech = partOfSpeech;
        }

        public String[] getSynonyms() {
            return synonyms;
        }

        public void setSynonyms(String[] synonyms) {
            this.synonyms = synonyms;
        }

        public String[] getSimilarTo() {
            return similarTo;
        }

        public void setSimilarTo(String[] similarTo) {
            this.similarTo = similarTo;
        }

        public String[] getDerivation() {
            return derivation;
        }

        public void setDerivation(String[] derivation) {
            this.derivation = derivation;
        }

        public String[] getTypeOf() {
            return typeOf;
        }

        public void setTypeOf(String[] typeOf) {
            this.typeOf = typeOf;
        }

        public String[] getHasTypes() {
            return hasTypes;
        }

        public void setHasTypes(String[] hasTypes) {
            this.hasTypes = hasTypes;
        }

        public String[] getHasMembers() {
            return hasMembers;
        }

        public void setHasMembers(String[] hasMembers) {
            this.hasMembers = hasMembers;
        }

        public String[] getExamples() {
            return examples;
        }

        public void setExamples(String[] examples) {
            this.examples = examples;
        }
    }
    @SerializedName("syllables")
    @Expose
    private String syllables;
    class syllables{
        @SerializedName("count")
        @Expose
        int count;
        @SerializedName("listz")
        @Expose
        String[] list;

    }
    @SerializedName("pronunciation")
    @Expose
    private String pronunciation;
    @SerializedName("frequency")
    @Expose
    private float frequency;


    public String getWords() {
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

