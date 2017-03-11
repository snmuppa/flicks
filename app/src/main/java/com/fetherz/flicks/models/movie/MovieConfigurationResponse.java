package com.fetherz.flicks.models.movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sm032858 on 3/10/17.
 */

public class MovieConfigurationResponse {

    @SerializedName("images")
    private MovieConfiguration movieImageConfiguration;

    @SerializedName("changes_keys")
    private List<String> changeKeys;

    public MovieConfiguration getMovieImageConfiguration() {
        return movieImageConfiguration;
    }

    public List<String> getChangeKeys() {
        return changeKeys;
    }
}
