package com.fetherz.flicks.models.movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sm032858 on 3/10/17.
 */

public class MovieVideoResponse {

    @SerializedName("id")
    private int id;

    @SerializedName("results")
    private List<MovieVideo> videos;


    public int getId() {
        return id;
    }

    public List<MovieVideo> getVideos() {
        return videos;
    }
}
