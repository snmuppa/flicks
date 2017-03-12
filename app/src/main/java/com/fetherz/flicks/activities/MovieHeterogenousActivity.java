package com.fetherz.flicks.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.fetherz.flicks.R;
import com.fetherz.flicks.adapters.HeterogenousMovieRecyclerViewAdapter;
import com.fetherz.flicks.models.movie.Movie;
import com.fetherz.flicks.models.movie.MoviesNowPlayingResponse;
import com.fetherz.flicks.network.MoviesDbRestClient;
import com.fetherz.flicks.views.events.EndlessRecyclerViewScrollListener;
import com.google.gson.JsonSyntaxException;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

import static com.fetherz.flicks.utils.JsonHelper.GetResponseObject;

public class MovieHeterogenousActivity extends AppCompatActivity {
    RecyclerView rvHeterogenousMovies;
    List<Movie> movies;
    HeterogenousMovieRecyclerViewAdapter recyclerViewAdapter;

    // Store a member variable for the listener
    private EndlessRecyclerViewScrollListener scrollListener;

    private SwipeRefreshLayout swipeContainer;

    private static final int START_PAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_heterogenous);

        setSwipeRefreshContainer();

        setRecyclerView();

        resetEndlessScroller();

        //set the initial pages
        loadNextDataFromApi(START_PAGE);

        setToolBar();
    }

    private void setRecyclerView() {
        // Lookup the recyclerview in activity layout
        rvHeterogenousMovies = (RecyclerView)findViewById(R.id.rvHeterogenousMovies);

        // Initialize movies
        movies = new ArrayList<>();

        // Create adapter passing in the initial movie data
        recyclerViewAdapter = new HeterogenousMovieRecyclerViewAdapter(movies);

        // Attach the adapter to the recyclerview to populate items
        rvHeterogenousMovies.setAdapter(recyclerViewAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        // Set layout manager to position the items
        rvHeterogenousMovies.setLayoutManager(linearLayoutManager);

        // Retain an instance so that you can call `resetState()` for fresh searches
        scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to the bottom of the list
                loadNextDataFromApi(page + 1); //movie API page numbers start from 1, so next page 1 greater than the previous
            }
        };

        // Adds the scroll listener to RecyclerView
        rvHeterogenousMovies.addOnScrollListener(scrollListener);
    }

    private void setSwipeRefreshContainer() {
        // Lookup the swipe container view
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                swipeRefreshMovieData();
            }
        });

        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }

    private void swipeRefreshMovieData() {
        loadNextDataFromApi(START_PAGE, true); //start at first page
    }

    private void loadNextDataFromApi(int page){
        loadNextDataFromApi(page, false);
    }

    private void loadNextDataFromApi(int page, final boolean isSwipeRefresh) {
        RequestParams params = new RequestParams();
        params.put(getString(R.string.url_path_param_page_key), page);

        MoviesDbRestClient.getAsync(getString(R.string.url_path_movies_now_playing), params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                // Handle the failure and alert the user to retry
                Log.e("Error----> ", ""+statusCode+" ------ "+ responseString);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                MoviesNowPlayingResponse moviesNowPlayingResponse = null;
                try {
                    moviesNowPlayingResponse = GetResponseObject(responseString, MoviesNowPlayingResponse.class);
                }
                catch (JsonSyntaxException ex) {
                    Log.e("Error---->", ex.getMessage());
                }
                if(isSwipeRefresh){
                    resetEndlessScroller();
                }

                if(moviesNowPlayingResponse != null && moviesNowPlayingResponse.getMovies() != null && moviesNowPlayingResponse.getMovies().size() > 0)
                {
                    int currSize = recyclerViewAdapter.getItemCount();
                    movies.addAll(moviesNowPlayingResponse.getMovies());
                    recyclerViewAdapter.notifyItemRangeInserted(currSize, moviesNowPlayingResponse.getMovies().size() - 1);
                }

                if(isSwipeRefresh){
                    // Now we call setRefreshing(false) to signal refresh has finished
                    swipeContainer.setRefreshing(false);

                }
            }
        });
    }

    private void resetEndlessScroller() {
        // 1. First, clear the array of data
        movies.clear();
        // 2. Notify the adapter of the update
        recyclerViewAdapter.notifyDataSetChanged(); // or notifyItemRangeRemoved
        // 3. Reset endless scroll listener when performing a new search
        scrollListener.resetState();
    }

    private void setToolBar() {
        // Find the toolbar view and set as ActionBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.tbHeterogenousMovie);
        setSupportActionBar(toolbar);
    }
}
