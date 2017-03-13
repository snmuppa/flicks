package com.fetherz.flicks.network;

/**
 * Created by sm032858 on 3/12/17.
 */

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

public class OkHttpUtil {

    private OkHttpClient client;
    private Request.Builder builder;

    public OkHttpUtil() {
        client = new OkHttpClient();
        builder = new Request.Builder();
    }

    public void get(String baseUrl, Map<String, String> queryParams, HttpCallback callback) {
        call("GET", baseUrl, queryParams, callback);
    }

    public void post(String baseUrl, Map<String, String> queryParams, HttpCallback cb) {
        call("POST", baseUrl, queryParams, cb);
    }

    private void call(String method, String baseUrl, Map<String, String> queryParams,  final HttpCallback callback){

        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUrl).newBuilder();
        if(queryParams != null)
        {
            for (Map.Entry<String, String> entry: queryParams.entrySet()) {
                if(entry.getKey() != null && !entry.getKey().isEmpty()
                        && entry.getValue() != null && !entry.getValue().isEmpty()) {
                    urlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
                }
            }
        }

        String absoluteUrl = urlBuilder.build().toString();
        
        Request request = builder.url(absoluteUrl).method(method, method.equals("GET") ? null : new RequestBody() {
            // don't care much about request body
            @Override
            public MediaType contentType() {
                return null;
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {

            }
        }).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(null, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    callback.onFailure(response, null);
                    return;
                }
                callback.onSuccess(response);
            }
        });

    }

    public interface HttpCallback {

        public void onFailure(Response response, IOException e);

        public void onSuccess(Response response);

    }
}