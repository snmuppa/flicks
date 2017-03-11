package com.fetherz.flicks.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fetherz.flicks.R;
import com.fetherz.flicks.models.movie.Movie;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by sm032858 on 3/10/17.
 */

public class MovieItemView extends RelativeLayout {
    private TextView tvMovieTitle;
    private TextView tvMovieOverview;
    private ImageView ivMovieImage;

    public static MovieItemView inflate(ViewGroup parent) {
        MovieItemView movieItemView = (MovieItemView)LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item_view, parent, false);
        return movieItemView;
    }

    public MovieItemView(Context c) {
        this(c, null);
    }

    public MovieItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MovieItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LayoutInflater.from(context).inflate(R.layout.movie_item_view_children, this, true);
        setupChildren();
    }

    private void setupChildren() {
        tvMovieTitle = (TextView) findViewById(R.id.tvMovieTitle);
        tvMovieOverview = (TextView) findViewById(R.id.tvMovieOverView);
        ivMovieImage = (ImageView) findViewById(R.id.ivMovieImage);
    }

    public void setPortraitMovieItem(Movie movie) {
        tvMovieTitle.setText(movie.getTitle());
        tvMovieOverview.setText(movie.getOverview());
        Picasso.with(getContext()).load(movie.getPosterPath())
                .fit()
                .centerCrop()
                .transform(new RoundedCornersTransformation(10, 10))
                .placeholder(R.drawable.image_spinner)
                .error(R.drawable.image_error)
                .into(ivMovieImage);
    }

    public void setLandscapeMovieItem(Movie movie) {
        tvMovieTitle.setText(movie.getTitle());
        tvMovieOverview.setText(movie.getOverview());
        Picasso.with(getContext()).load(movie.getBackdropPath())
                .fit()
                .centerCrop()
                .transform(new RoundedCornersTransformation(10, 10))
                .placeholder(R.drawable.image_spinner)
                .error(R.drawable.image_error)
                .into(ivMovieImage);
    }

    public ImageView getImageView () {
        return ivMovieImage;
    }

    public TextView getTitleTextView() {
        return tvMovieTitle;
    }

    public TextView getDescriptionTextView() {
        return tvMovieOverview;
    }
}