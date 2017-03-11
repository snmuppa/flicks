package com.fetherz.flicks.models.movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sm032858 on 3/10/17.
 */

public class MovieConfiguration {

    @SerializedName("base_url")
    private String baseUrl;

    @SerializedName("secure_base_url")
    private String secureBaseUrl;

    @SerializedName("logo_sizes")
    private List<String> logoSizes;

    @SerializedName("poster_sizes")
    private List<String> posterSizes;

    @SerializedName("profile_sizes")
    private List<String> profileSizes;

    @SerializedName("still_sizes")
    private List<String> stillSizes;

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getSecureBaseUrl() {
        return secureBaseUrl;
    }

    public List<String> getLogoSizes() {
        return logoSizes;
    }

    public List<String> getPosterSizes() {
        return posterSizes;
    }

    public List<String> getProfileSizes() {
        return profileSizes;
    }

    public List<String> getStillSizes() {
        return stillSizes;
    }
}
