package com.fetherz.flicks.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.widget.RatingBar;
import android.widget.TextView;

import com.fetherz.flicks.R;
import com.fetherz.flicks.models.movie.Movie;
import com.fetherz.flicks.utils.DynamicHeightImageView;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class MovieDetailActivity extends AppCompatActivity {

    private static final String EXTRA_MOVIE = "movie";

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Movie movie = (Movie) getIntent().getSerializableExtra(EXTRA_MOVIE);

        //todo populate detail views

        setDetails(movie);
    }

    private void setDetails(Movie movie) {
        TextView movieTitleTextView = (TextView) findViewById(R.id.tvMovieDetailTitle);
        TextView movieVoteAvg = (TextView) findViewById(R.id.tvMovieVoteAverage);
        TextView movieVoteCount = (TextView) findViewById(R.id.tvMovieVoteCount);
        TextView movieLanguageTextView = (TextView) findViewById(R.id.tvMovieOriginalLanguage);
        TextView movieOverviewTextView = (TextView) findViewById(R.id.tvMovieDetailOverview);
        TextView movieReleaseDateTextView = (TextView) findViewById(R.id.tvMovieReleaseDate);
        DynamicHeightImageView movieBackdropImageView = (DynamicHeightImageView) findViewById(R.id.ivMovieBackdrop);
        DynamicHeightImageView moviePosterImageView = (DynamicHeightImageView) findViewById(R.id.ivMoviePoster);
        RatingBar movieRatingBar = (RatingBar) findViewById(R.id.rbMovieRating);

        movieTitleTextView.setText(movie.getTitle());
        movieRatingBar.setRating(((float)movie.getVoteAverage() / 2));
        movieVoteAvg.setText(getDetailText("Vote Average", String.valueOf(movie.getVoteAverage())));
        movieVoteCount.setText(getDetailText("Vote Count", String.valueOf(movie.getVoteCount())));
        movieLanguageTextView.setText(getDetailText("Original Language", movie.getOriginalLanguage()));
        movieOverviewTextView.setText(movie.getOverview());
        movieReleaseDateTextView.setText(getDetailText("Release Date", movie.getReleaseDate()));

        movieBackdropImageView.setHeightRatio(((double)192)/342);
        Picasso.with(this).load(movie.getBackdropPath())
                .transform(new RoundedCornersTransformation(10, 10))
                .placeholder(R.drawable.image_spinner)
                .error(R.drawable.image_error)
                .into(movieBackdropImageView);

        Picasso.with(this).load(movie.getPosterPath())
                .transform(new RoundedCornersTransformation(10, 10))
                .fit()
                .centerCrop()
                .placeholder(R.drawable.image_spinner)
                .error(R.drawable.image_error)
                .into(moviePosterImageView);
    }

    private Spanned getDetailText(String sideHeader, String value) {
        return Html.fromHtml(String.format(getString(R.string.movie_details), sideHeader, value));
    }
}

