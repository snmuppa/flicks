package com.fetherz.flicks.models.movie;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by sm032858 on 3/10/17.
 */

public class Movie {

    public static final int NON_POPULAR_TYPE = 1;
    public static final int POPULAR_TYPE = 2;

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
        return String.format("http://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public double getPopularity() {
        return popularity;
    }

    public int getViewType(){
        if(voteAverage > 5){
            return POPULAR_TYPE;
        }
        else{
            return NON_POPULAR_TYPE;
        }
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

    @Override
    public String toString() {
        return "Movie{" +
                "posterPath='" + posterPath + '\'' +
                ", adult=" + adult +
                ", overview='" + overview + '\'' +
                ", releaseDate=" + releaseDate +
                ", originalTitle='" + originalTitle + '\'' +
                ", genreIds=" + genreIds +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", title='" + title + '\'' +
                ", backdropPath='" + backdropPath + '\'' +
                ", popularity=" + popularity +
                ", voteCount=" + voteCount +
                ", isVideo=" + isVideo +
                ", voteAverage=" + voteAverage +
                '}';
    }
}
