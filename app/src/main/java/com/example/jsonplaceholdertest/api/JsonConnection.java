package com.example.jsonplaceholdertest.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

interface ApiConnection {
        @Headers({
                "x-rapidapi-host: wordsapiv1.p.rapidapi.com",
                "x-rapidapi-key: 838b737emsh0ebb0b1e5fbf1b4p19c0dejsnbbeeaa69ec46"
        })
        @GET("/words/")
        Call<Word> getWord(@Query("word") String word);
}

public class  JsonConnection {
    private final static String BASE_URL = "https://wordsapiv1.p.rapidapi.com";

    private static JsonConnection instance;
    Retrofit retrofit;

    private JsonConnection() {
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public ApiConnection getAPI() {
        return retrofit.create(ApiConnection.class);
    }

    public static JsonConnection getInstance() {
        if (instance == null) instance = new JsonConnection();
        return instance;
    }
}
