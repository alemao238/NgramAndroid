package com.nico.ngram.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nico on 26/12/16.
 */

public class NgramClient {

    private Retrofit retrofit;
    private final static String FIREBASE_BASE_URL = "https://ngram-50c77.firebaseio.com/ ";


    public NgramClient(Retrofit retrofit) {
        Gson gson = new GsonBuilder()
                            .registerTypeAdapter(PostResponse.class, new PostResponseTypeAdapter())
                            .create();

        retrofit = new Retrofit.Builder()
                            .baseUrl(FIREBASE_BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .build();
    }

    public NgramFirebaseService getService(){
        return retrofit.create(NgramFirebaseService.class);
    }
}
