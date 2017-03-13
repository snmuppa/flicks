package com.fetherz.flicks.ViewHolders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fetherz.flicks.R;
import com.fetherz.flicks.activities.MovieDetailActivity;
import com.fetherz.flicks.models.movie.Movie;

import java.util.List;

import static com.loopj.android.http.AsyncHttpClient.LOG_TAG;

/**
 * Created by sm032858 on 3/11/17.
 */

public class NonPopularMovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView ivNonPopularMovie;
    private TextView tvNonPopularMovieTitle;
    private TextView tvNonPopularMovieOverView;

    private List<Movie> movies;
    private Context context;

    public NonPopularMovieViewHolder(View view, final List<Movie> movies) {
        super(view);

        context = view.getContext();
        view.setOnClickListener(this);

        this.movies = movies;
        ivNonPopularMovie = (ImageView) view.findViewById(R.id.ivNonPopularMovie);
        tvNonPopularMovieTitle = (TextView) view.findViewById(R.id.tvNonPopularMovieTitle);
        tvNonPopularMovieOverView = (TextView) view.findViewById(R.id.tvNonPopularMovieOverView);
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

    @Override
    public void onClick(View v) {
        int position = getLayoutPosition();
        Movie movie = movies.get(position);

        Intent i = MovieDetailActivity.newIntent(context);
        i.putExtra("movie", movie);

        context.startActivity(i);
        Log.d(LOG_TAG, "Movie clicked: " + movie);
    }
}
