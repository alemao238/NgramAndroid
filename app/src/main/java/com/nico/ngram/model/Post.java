package com.nico.ngram.model;

import java.util.HashMap;

/**
 * Created by nico on 26/12/16.
 */

public class Post {

    public String uid;
    public String author;
    public String imageUrl;
    public HashMap<String, Object> timestampCreated;

    public Post(String author, String imageUrl, HashMap<String, Object> timestampCreated) {
        this.author = author;
        this.imageUrl = imageUrl;
        this.timestampCreated = timestampCreated;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public HashMap<String, Object> getTimestampCreated() {
        return timestampCreated;
    }

    public void setTimestampCreated(HashMap<String, Object> timestampCreated) {
        this.timestampCreated = timestampCreated;
    }


}
