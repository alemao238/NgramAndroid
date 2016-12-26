package com.nico.ngram.api;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by nico on 26/12/16.
 */

public interface NgramFirebaseService {

    @GET("post.json")
    Call<PostResponse> getPostList();
}
