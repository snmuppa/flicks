package com.fetherz.flicks.models.movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sm032858 on 3/10/17.
 */

public class MoviesNowPlayingResponse {
    @SerializedName("page")
    private int page;

    @SerializedName("results")
    private List<Movie> movies;

    public int getPage() {
        return page;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
