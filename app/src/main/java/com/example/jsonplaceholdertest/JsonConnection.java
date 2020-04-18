package com.example.jsonplaceholdertest;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

interface JSONPlaceholderAPI {
    @Headers({
            "x-rapidapi-host: wordsapiv1.p.rapidapi.com",
            "x-rapidapi-key : 8c838b737emsh0ebb0b1e5fbf1b4p19c0dejsnbbeeaa69ec46"
    })
    @GET("/words/{word}")
    Call<Word> getWord(@Path("word") String word);
}

public class JsonConnection {
    private final static String BASE_URL = "https://wordsapiv1.p.rapidapi.com";

    private static JsonConnection instance;
    Retrofit retrofit;

    private JsonConnection() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public JSONPlaceholderAPI getAPI() {
        return retrofit.create(JSONPlaceholderAPI.class);
    }

    public static JsonConnection getInstance() {
        if (instance == null) instance = new JsonConnection();
        return instance;
    }
}
