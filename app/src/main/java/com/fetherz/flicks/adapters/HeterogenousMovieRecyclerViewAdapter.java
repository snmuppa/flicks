package com.fetherz.flicks.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fetherz.flicks.R;
import com.fetherz.flicks.ViewHolders.NonPopularMovieViewHolder;
import com.fetherz.flicks.ViewHolders.PopularMovieViewHolder;
import com.fetherz.flicks.models.movie.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by sm032858 on 3/11/17.
 */

public class HeterogenousMovieRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // The items to display in your RecyclerView
    private List<Movie> movies;

    private Context context;

    // Provide a suitable constructor (depends on the kind of dataset)
    public HeterogenousMovieRecyclerViewAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return this.movies.size();
    }

    @Override
    public int getItemViewType(int position) {
        Movie movie = movies.get(position);
        return movie.getViewType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder;

        context = viewGroup.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        switch (viewType) {
            case Movie.POPULAR_TYPE:
                View popularView = inflater.inflate(R.layout.layout_popular_movie, viewGroup, false);
                viewHolder = new PopularMovieViewHolder(popularView);
                break;
            default:
                View nonPopularView = inflater.inflate(R.layout.layout_non_popular_movie, viewGroup, false);
                viewHolder = new NonPopularMovieViewHolder(nonPopularView, movies);
                break;
        }


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case Movie.POPULAR_TYPE:
                PopularMovieViewHolder popularMovieViewHolder = (PopularMovieViewHolder) viewHolder;
                configurePopularViewHolder(popularMovieViewHolder, position);
                break;
            default:
                NonPopularMovieViewHolder nonPopularMovieViewHolder = (NonPopularMovieViewHolder) viewHolder;
                configureNonPopularViewHolder(nonPopularMovieViewHolder, position);
                break;
        }
    }

    private void configurePopularViewHolder(final PopularMovieViewHolder popularMovieViewHolder, int position) {
        Movie movie = movies.get(position);
        if (movie != null) {

            // `popularMovieViewHolder.getPopularMovieImage()` should be of type `DynamicHeightImageView`
            // Set the height ratio before loading in image into Picasso
            popularMovieViewHolder.getPopularMovieImage().setHeightRatio(((double)192)/342); //TODO: eliminate the hard code here
            // Load the image into the view using Picasso

            Picasso.with(context).load(movie.getBackdropPath())
                    .transform(new RoundedCornersTransformation(10, 10))
                    .placeholder(R.drawable.image_spinner)
                    .error(R.drawable.image_error)
                    .into(popularMovieViewHolder.getPopularMovieImage());
        }
    }

    private void configureNonPopularViewHolder(NonPopularMovieViewHolder nonPopularMovieViewHolder, int position) {
        Movie movie = movies.get(position);
        if (movie != null) {
            Picasso.with(context).load(movie.getPosterPath())
                    .transform(new RoundedCornersTransformation(10, 10))
                    .placeholder(R.drawable.image_spinner)
                    .error(R.drawable.image_error)
                    .into(nonPopularMovieViewHolder.getPopularMovieImage());

            nonPopularMovieViewHolder.getTvNonPopularMovieTitle().setText(movie.getTitle());
            nonPopularMovieViewHolder.getTvNonPopularMovieOverView().setText(movie.getOverview());
        }
    }

    // Clean all elements of the recycler
    public void clear() {
        movies.clear();
        notifyDataSetChanged();
    }

    // Add a list of items
    public void addAll(List<Movie> list) {
        movies.addAll(list);
        notifyDataSetChanged();
    }
}
