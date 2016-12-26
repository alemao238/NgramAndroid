package com.nico.ngram.api;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.nico.ngram.model.Post;

import java.io.IOException;

/**
 * Created by nico on 26/12/16.
 */

public class PostResponseTypeAdapter extends TypeAdapter{

    @Override
    public void write(JsonWriter out, Object value) throws IOException {

    }

    @Override
    public Object read(JsonReader in) throws IOException {
        Post post = new Post();
        in.nextName();
        in.beginObject();
        while (in.hasNext()){
            String next = in.nextName();
            switch (next) {
                case "author":
                    post.setAuthor(in.nextString());
                    break;
                case "imageUrl":
                    post.setImageUrl(in.nextString());
                    break;
                case "timestamp":
                    post.setTimestampCreated(in.nextDouble());
                    break;
            }
        }

        in.endObject();
        return post;
    }
}
