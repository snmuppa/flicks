package com.fetherz.flicks.network;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;

/**
 * Created by sm032858 on 3/9/17.
 */

public class MoviesDbRestClient {
    private static final String BASE_URL = "https://api.themoviedb.org/3/movie/";
    private static final String API_KEY = "api_key";
    private static final String API_KEY_VALUE = "6c923ac5aaa1ba64c14f123661d35d0a";

    private static AsyncHttpClient asyncClient = new AsyncHttpClient();

    private static SyncHttpClient syncClient = new SyncHttpClient();

    public static void getAsync(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        asyncClient.get(getAbsoluteUrl(url), getRequestParams(params), responseHandler);
    }

    public static void postAsync(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        asyncClient.post(getAbsoluteUrl(url), getRequestParams(params), responseHandler);
    }

    public static void getSync(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        syncClient.get(getAbsoluteUrl(url), getRequestParams(params), responseHandler);
    }

    public static void postSync(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        syncClient.post(getAbsoluteUrl(url), getRequestParams(params), responseHandler);
    }

    private static RequestParams getRequestParams(RequestParams params) {
        if(params == null) {
            params = new RequestParams();
        }
        params.add(API_KEY, API_KEY_VALUE);

        return params;
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
