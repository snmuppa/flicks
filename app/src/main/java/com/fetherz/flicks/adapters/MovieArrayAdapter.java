package com.fetherz.flicks.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.fetherz.flicks.models.movie.Movie;
import com.fetherz.flicks.views.MovieItemView;

import java.util.List;

/**
 * Created by sm032858 on 3/10/17.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(@NonNull Context context, List<Movie> movies) {
        super(context, 0, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MovieItemView movieItemView = (MovieItemView)convertView;
        if (movieItemView == null) {
            movieItemView = MovieItemView.inflate(parent);
        }

        int orientation = getContext().getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            movieItemView.setPortraitMovieItem(getItem(position));
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            movieItemView.setLandscapeMovieItem(getItem(position));
        }

        return movieItemView;
    }

}
