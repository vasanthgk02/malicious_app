package com.twitter.sdk.android.core.services;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ConfigurationService {
    @GET("/1.1/help/configuration.json")
    Call<Object> configuration();
}
