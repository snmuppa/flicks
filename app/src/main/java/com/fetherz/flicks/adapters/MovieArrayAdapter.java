package com.fetherz.flicks.adapters;

import android.content.Context;
import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by sm032858 on 3/10/17.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(@NonNull Context context, List<Movie> movies) {
        super(context, 0, movies);
    }


}
