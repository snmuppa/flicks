package com.fetherz.flicks.activities;

import android.os.Bundle;
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
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

import static com.fetherz.flicks.utils.JsonHelper.GetResponseObject;


public class MovieHeterogenousActivity extends AppCompatActivity {

    RecyclerView rvHeterogenousMovies;
    List<Movie> movies;
    HeterogenousMovieRecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_heterogenous);

        // Lookup the recyclerview in activity layout
        rvHeterogenousMovies = (RecyclerView)findViewById(R.id.rvHeterogenousMovies);

        // Initialize movies
        movies = new ArrayList<>();

        // Create adapter passing in the initial movie data
        recyclerViewAdapter = new HeterogenousMovieRecyclerViewAdapter(movies);

        // Attach the adapter to the recyclerview to populate items
        rvHeterogenousMovies.setAdapter(recyclerViewAdapter);

        // Set layout manager to position the items
        rvHeterogenousMovies.setLayoutManager(new LinearLayoutManager(this));

        setToolBar();

        fetchMoviesPlayingNow();
    }

    private void fetchMoviesPlayingNow() {
        MoviesDbRestClient.getAsync(getString(R.string.url_path_movies_now_playing), null, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                // Handle the failure and alert the user to retry
                Log.e("Error----> ", ""+statusCode+" ------ "+ responseString);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                MoviesNowPlayingResponse moviesNowPlayingResponse = GetResponseObject(responseString, MoviesNowPlayingResponse.class);
                if(moviesNowPlayingResponse != null && moviesNowPlayingResponse.getMovies() != null)
                {
                    movies.addAll(0, moviesNowPlayingResponse.getMovies());
                    recyclerViewAdapter.notifyItemRangeInserted(0, moviesNowPlayingResponse.getMovies().size());
                }
            }
        });
    }

    private void setToolBar() {
        // Find the toolbar view and set as ActionBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.tbHeterogenousMovie);
        setSupportActionBar(toolbar);
    }
}
