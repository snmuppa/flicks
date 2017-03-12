package com.fetherz.flicks.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fetherz.flicks.R;

/**
 * Created by sm032858 on 3/11/17.
 */

public class NonPopularMovieViewHolder extends RecyclerView.ViewHolder {

    private ImageView ivNonPopularMovie;
    private TextView tvNonPopularMovieTitle;
    private TextView tvNonPopularMovieOverView;

    public NonPopularMovieViewHolder(View v) {
        super(v);
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
