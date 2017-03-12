package com.fetherz.flicks.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.fetherz.flicks.R;

/**
 * Created by sm032858 on 3/11/17.
 */

public class PopularMovieViewHolder extends RecyclerView.ViewHolder {
    private ImageView ivPopularMovie;

    public PopularMovieViewHolder(View v) {
        super(v);
        ivPopularMovie = (ImageView) v.findViewById(R.id.ivPopularMovie);
    }

    public ImageView getPopularMovieImage() {
        return ivPopularMovie;
    }

    public void setPopularMovieImage(ImageView popularMovieImage) {
        ivPopularMovie = popularMovieImage;
    }
}
