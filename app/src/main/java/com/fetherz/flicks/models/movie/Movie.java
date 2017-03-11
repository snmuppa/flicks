package com.fetherz.flicks.models.movie;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by sm032858 on 3/10/17.
 */

public class Movie {
    @SerializedName("poster_path")
    String posterPath;

    @SerializedName("adult")
    boolean adult;

    @SerializedName("overview")
    String overview;

    @SerializedName("release_date")
    Date releaseDate;

    @SerializedName("original_title")
    String originalTitle;

    @SerializedName("genre_ids")
    List<Integer> genreIds;

    @SerializedName("original_language")
    String originalLanguage;

    @SerializedName("title")
    String title;

    @SerializedName("backdrop_path")
    String backdropPath;

    @SerializedName("popularity")
    double popularity;

    @SerializedName("vote_count")
    double voteCount;

    @SerializedName("video")
    boolean isVideo;

    @SerializedName("vote_average")
    double voteAverage;

    public String getPosterPath() {
        return String.format("http://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public boolean isAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public double getPopularity() {
        return popularity;
    }

    public double getVoteCount() {
        return voteCount;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public double getVoteAverage() {
        return voteAverage;
    }
}
