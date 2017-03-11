package com.fetherz.flicks.models.movie;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sm032858 on 3/10/17.
 */

public class YoutubeMovieTrailer {

    @SerializedName("name")
    private String name;

    @SerializedName("size")
    private String size;

    @SerializedName("source")
    private String source;

    @SerializedName("type")
    private String type;

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getSource() {
        return source;
    }

    public String getType() {
        return type;
    }
}
