package com.fetherz.flicks.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.fetherz.flicks.R;
import com.fetherz.flicks.adapters.MovieArrayAdapter;
import com.fetherz.flicks.models.movie.Movie;
import com.fetherz.flicks.models.movie.MoviesNowPlayingResponse;
import com.fetherz.flicks.network.MoviesDbRestClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

import static com.fetherz.flicks.utils.JsonHelper.GetResponseObject;

public class MovieActivity extends AppCompatActivity {
    List<Movie> movies;
    ArrayAdapter<Movie> movieArrayAdapter;
    ListView lvMoviesNowPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        lvMoviesNowPlaying = (ListView) findViewById(R.id.lvMoviesNowPlaying);

        movies = new ArrayList<>();
        movieArrayAdapter = new MovieArrayAdapter(this, movies);
        lvMoviesNowPlaying.setAdapter(movieArrayAdapter);

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
                    movies = moviesNowPlayingResponse.getMovies();
                    movieArrayAdapter.addAll(movies);
                    movieArrayAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
