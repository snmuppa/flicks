package com.fetherz.flicks.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fetherz.flicks.R;
import com.fetherz.flicks.utils.DynamicHeightImageView;

/**
 * Created by sm032858 on 3/11/17.
 */

public class PopularMovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private DynamicHeightImageView ivPopularMovie;

    public PopularMovieViewHolder(View view) {
        super(view);
        ivPopularMovie = (DynamicHeightImageView) view.findViewById(R.id.ivPopularMovie);

        view.setOnClickListener(this);
    }

    public DynamicHeightImageView getPopularMovieImage() {
        return ivPopularMovie;
    }

    public void setPopularMovieImage(DynamicHeightImageView popularMovieImage) {
        ivPopularMovie = popularMovieImage;
    }

    @Override
    public void onClick(View v) {
        //TODO: implement something on the click handler
    }
}

