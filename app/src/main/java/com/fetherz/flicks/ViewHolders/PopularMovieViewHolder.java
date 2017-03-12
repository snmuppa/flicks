package com.fetherz.flicks.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fetherz.flicks.R;
import com.fetherz.flicks.utils.DynamicHeightImageView;

/**
 * Created by sm032858 on 3/11/17.
 */

public class PopularMovieViewHolder extends RecyclerView.ViewHolder {
    private DynamicHeightImageView ivPopularMovie;

    public PopularMovieViewHolder(View v) {
        super(v);
        ivPopularMovie = (DynamicHeightImageView) v.findViewById(R.id.ivPopularMovie);
    }

    public DynamicHeightImageView getPopularMovieImage() {
        return ivPopularMovie;
    }

    public void setPopularMovieImage(DynamicHeightImageView popularMovieImage) {
        ivPopularMovie = popularMovieImage;
    }
}

