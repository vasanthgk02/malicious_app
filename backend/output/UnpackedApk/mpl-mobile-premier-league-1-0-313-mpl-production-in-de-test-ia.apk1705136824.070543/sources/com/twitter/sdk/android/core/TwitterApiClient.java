package com.twitter.sdk.android.core;

import com.google.android.material.resources.TextAppearanceConfig;
import com.google.gson.GsonBuilder;
import com.twitter.sdk.android.core.internal.TwitterApi;
import com.twitter.sdk.android.core.internal.network.GuestAuthInterceptor;
import com.twitter.sdk.android.core.internal.network.GuestAuthNetworkInterceptor;
import com.twitter.sdk.android.core.internal.network.GuestAuthenticator;
import com.twitter.sdk.android.core.models.BindingValues;
import com.twitter.sdk.android.core.models.BindingValuesAdapter;
import com.twitter.sdk.android.core.models.SafeListAdapter;
import com.twitter.sdk.android.core.models.SafeMapAdapter;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TwitterApiClient {
    public final Retrofit retrofit;
    public final ConcurrentHashMap<Class, Object> services;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public TwitterApiClient() {
        // GuestSessionProvider guestSessionProvider = TwitterCore.getInstance().getGuestSessionProvider();
        this(new Builder().certificatePinner(TextAppearanceConfig.getCertificatePinner()).authenticator(new GuestAuthenticator(guestSessionProvider)).addInterceptor(new GuestAuthInterceptor(guestSessionProvider)).addNetworkInterceptor(new GuestAuthNetworkInterceptor()).build(), new TwitterApi());
    }

    public <T> T getService(Class<T> cls) {
        if (!this.services.contains(cls)) {
            this.services.putIfAbsent(cls, this.retrofit.create(cls));
        }
        return this.services.get(cls);
    }

    public TwitterApiClient(OkHttpClient okHttpClient, TwitterApi twitterApi) {
        this.services = new ConcurrentHashMap<>();
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(okHttpClient);
        builder.baseUrl(twitterApi.baseHostUrl);
        builder.converterFactories.add((Factory) Objects.requireNonNull(GsonConverterFactory.create(new GsonBuilder().registerTypeAdapterFactory(new SafeListAdapter()).registerTypeAdapterFactory(new SafeMapAdapter()).registerTypeAdapter(BindingValues.class, new BindingValuesAdapter()).create()), "factory == null"));
        this.retrofit = builder.build();
    }
}
