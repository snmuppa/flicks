package com.fetherz.flicks.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fetherz.flicks.R;
import com.fetherz.flicks.models.movie.Movie;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by sm032858 on 3/11/17.
 */

public class NonPopularMovieViewHolder extends RecyclerView.ViewHolder {

    private ImageView ivNonPopularMovie;
    private TextView tvNonPopularMovieTitle;
    private TextView tvNonPopularMovieOverView;

    public NonPopularMovieViewHolder(View v, final List<Movie> movies) {
        super(v);

        // Define click listener for the ViewHolder's View.
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, movies.get(getAdapterPosition()) + " clicked."); //place holder for movies click, TODO: add an intent to show details view
            }
        });

        ivNonPopularMovie = (ImageView) v.findViewById(R.id.ivNonPopularMovie);
        tvNonPopularMovieTitle = (TextView) v.findViewById(R.id.tvNonPopularMovieTitle);
        tvNonPopularMovieOverView = (TextView) v.findViewById(R.id.tvNonPopularMovieOverView);
    }

    public TextView getTvNonPopularMovieTitle() {
        return tvNonPopularMovieTitle;
    }

    public void setTvNonPopularMovieTitle(TextView tvNonPopularMovieTitle) {
        this.tvNonPopularMovieTitle = tvNonPopularMovieTitle;
    }

    public TextView getTvNonPopularMovieOverView() {
        return tvNonPopularMovieOverView;
    }

    public void setTvNonPopularMovieOverView(TextView tvNonPopularMovieOverView) {
        this.tvNonPopularMovieOverView = tvNonPopularMovieOverView;
    }

    public ImageView getPopularMovieImage() {
        return ivNonPopularMovie;
    }

    public void setPopularMovieImage(ImageView popularMovieImage) {
        ivNonPopularMovie = popularMovieImage;
    }
}
