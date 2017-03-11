package com.fetherz.flicks.models.movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sm032858 on 3/10/17.
 */

public class MovieTrailerResponse {
    @SerializedName("id")
    private int id;

    @SerializedName("youtube")
    private List<YoutubeMovieTrailer> youtubeTrailers;
}
