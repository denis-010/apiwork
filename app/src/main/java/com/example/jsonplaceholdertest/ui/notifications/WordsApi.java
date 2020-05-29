package com.example.jsonplaceholdertest.ui.notifications;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;


public class WordsApi {
    public String getWord() {
        return word;
    }

    public WordsApi(String word, ArrayList<result> results, Syllables syllables, Pronunciation pronunciation, float frequency) {
        this.word = word;
        this.results = results;
        this.syllables = syllables;
        this.pronunciation = pronunciation;
        this.frequency = frequency;
    }

    class result {
        public result(String definition, String partOfSpeech, ArrayList<String> synonyms, ArrayList<String> similarTo,
                      ArrayList<String> derivation, ArrayList<String> typeOf, ArrayList<String> hasTypes, ArrayList<String>
                              hasMembers, ArrayList<String> examples) {
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
        ArrayList<String> synonyms;
        @SerializedName("similarTo")
        @Expose
        ArrayList<String> similarTo;
        @SerializedName("derivation")
        @Expose
        ArrayList<String> derivation;
        @SerializedName("typeOf")
        @Expose
        ArrayList<String> typeOf;
        @SerializedName("hasTypes")
        @Expose
        ArrayList<String> hasTypes;
        @SerializedName("hasMembers")
        @Expose
        ArrayList<String> hasMembers;
        @SerializedName("examples")
        @Expose
        ArrayList<String> examples;

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

        public ArrayList<String> getSynonyms() {
            return synonyms;
        }

        public void setSynonyms(ArrayList<String> synonyms) {
            this.synonyms = synonyms;
        }

        public ArrayList<String> getSimilarTo() {
            return similarTo;
        }

        public void setSimilarTo(ArrayList<String> similarTo) {
            this.similarTo = similarTo;
        }

        public ArrayList<String> getDerivation() {
            return derivation;
        }

        public void setDerivation(ArrayList<String> derivation) {
            this.derivation = derivation;
        }

        public ArrayList<String> getTypeOf() {
            return typeOf;
        }

        public void setTypeOf(ArrayList<String> typeOf) {
            this.typeOf = typeOf;
        }

        public ArrayList<String> getHasTypes() {
            return hasTypes;
        }

        public void setHasTypes(ArrayList<String> hasTypes) {
            this.hasTypes = hasTypes;
        }

        public ArrayList<String> getHasMembers() {
            return hasMembers;
        }

        public void setHasMembers(ArrayList<String> hasMembers) {
            this.hasMembers = hasMembers;
        }

        public ArrayList<String> getExamples() {
            return examples;
        }

        public void setExamples(ArrayList<String> examples) {
            this.examples = examples;
        }

        @Override
        public String toString() {
            return "result{" +
                    "definition='" + definition + '\'' +
                    ", partOfSpeech='" + partOfSpeech + '\'' +
                    ", synonyms=" + synonyms +
                    ", similarTo=" + similarTo +
                    ", derivation=" + derivation +
                    ", typeOf=" + typeOf +
                    ", hasTypes=" + hasTypes +
                    ", hasMembers=" + hasMembers +
                    ", examples=" + examples +
                    '}';
        }

        public class syllables {
            public syllables(String count, ArrayList<String> list) {
                this.count = count;
                this.list = list;
            }

            String count;
            ArrayList<String> list;

            public String getCount() {
                return count;
            }

            public void setCount(String count) {
                this.count = count;
            }

            public ArrayList<String> getList() {
                return list;
            }

            public void setList(ArrayList<String> list) {
                this.list = list;
            }
        }
    }

    @SerializedName("word")
    @Expose
    private String word;

    @SerializedName("results")
    @Expose
    private ArrayList<result> results;

    @SerializedName("syllables")
    @Expose
    private Syllables syllables;

    @SerializedName("pronunciation")
    @Expose
    private Pronunciation pronunciation;
    @SerializedName("frequency")
    @Expose
    private float frequency;

    public String getWords() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public ArrayList<result> getResults() {
        return results;
    }

    public void setResults(ArrayList<result> results) {
        this.results = results;
    }

    public Syllables getSyllables() {
        return syllables;
    }

    public void setSyllables(Syllables syllables) {
        this.syllables = syllables;
    }

    public Pronunciation getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(Pronunciation pronunciation) {
        this.pronunciation = pronunciation;
    }

    public float getFrequency() {
        return frequency;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    public class Syllables {
        public Syllables(String count, ArrayList<String> list) {
            this.count = count;
            this.list = list;
        }

        @Override
        public String toString() {
            return "Syllables{" +
                    "count='" + count + '\'' +
                    ", list=" + list +
                    '}';
        }

        String count;
        ArrayList<String> list;

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public ArrayList<String> getList() {
            return list;
        }

        public void setList(ArrayList<String> list) {
            this.list = list;
        }
    }
    public class Pronunciation{
        String all;

        public Pronunciation(String all) {
            this.all = all;
        }

        public String getAll() {
            return all;
        }

        public void setAll(String all) {
            this.all = all;
        }

        @Override
        public String toString() {
            return "Pronunciation{" +
                    "all='" + all + '\'' +
                    '}';
        }
    }
    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", " + results.toString() +
                ", " + syllables + '\'' +
                ", " + pronunciation + '\'' +
                ", frequency=" + frequency +
                '}';
    }
}



