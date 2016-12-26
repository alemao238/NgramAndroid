package com.nico.ngram.api;

import com.nico.ngram.model.Post;

import java.util.ArrayList;

/**
 * Created by nico on 26/12/16.
 */

public class PostResponse {
    ArrayList<Post> postList = new ArrayList<>();

    public void setPostList(ArrayList<Post> postList){
        this.postList = postList;
    }

    public ArrayList<Post> getPostList(){
        return postList;
    }
}
