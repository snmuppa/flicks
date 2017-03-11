package com.fetherz.flicks.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.fetherz.flicks.R;
import com.fetherz.flicks.models.movie.MoviesNowPlayingResponse;
import com.fetherz.flicks.network.MoviesDbRestClient;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

import static com.fetherz.flicks.utils.JsonHelper.GetResponseObject;

public class MovieActivity extends AppCompatActivity {
    MoviesNowPlayingResponse movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        getMoviesPlayingNow();
    }

    private void getMoviesPlayingNow() {
        MoviesDbRestClient.getAsync(getString(R.string.url_path_movies_now_playing), null, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                // Handle the failure and alert the user to retry
                Log.e("Error----> ", ""+statusCode+" ------ "+ responseString);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                movies = GetResponseObject(responseString, MoviesNowPlayingResponse.class);
            }
        });
    }
}
