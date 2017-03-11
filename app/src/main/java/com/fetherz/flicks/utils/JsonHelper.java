package com.fetherz.flicks.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by sm032858 on 3/10/17.
 */

public class JsonHelper {
    public static <T> T GetResponseObject(String responseString, Class<T> responseClass) {
        Gson gson = new GsonBuilder().create();
        T responseObject = gson.fromJson(responseString, responseClass);
        return responseObject;
    }
}
