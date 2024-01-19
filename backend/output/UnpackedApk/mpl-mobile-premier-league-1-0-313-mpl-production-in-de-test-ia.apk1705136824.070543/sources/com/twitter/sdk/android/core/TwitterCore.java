package com.twitter.sdk.android.core;

import android.annotation.SuppressLint;
import com.google.android.material.resources.TextAppearanceConfig;
import com.twitter.sdk.android.core.internal.TwitterApi;
import com.twitter.sdk.android.core.internal.network.OAuth1aInterceptor;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Service;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.OkHttpClient.Builder;

public class TwitterCore {
    @SuppressLint({"StaticFieldLeak"})
    public static volatile TwitterCore instance;
    public final ConcurrentHashMap<Session, TwitterApiClient> apiClients;
    public final TwitterAuthConfig authConfig;
    public volatile TwitterApiClient guestClient;
    public SessionManager<GuestSession> guestSessionManager;
    public volatile GuestSessionProvider guestSessionProvider;
    public SessionManager<TwitterSession> twitterSessionManager;

    public static TwitterCore getInstance() {
        if (instance == null) {
            synchronized (TwitterCore.class) {
                if (instance == null) {
                    Twitter.getInstance();
                    throw null;
                }
            }
        }
        return instance;
    }

    public TwitterApiClient getApiClient(TwitterSession twitterSession) {
        if (!this.apiClients.containsKey(twitterSession)) {
            ConcurrentHashMap<Session, TwitterApiClient> concurrentHashMap = this.apiClients;
            TwitterAuthConfig twitterAuthConfig = getInstance().authConfig;
            if (twitterSession != null) {
                concurrentHashMap.putIfAbsent(twitterSession, new TwitterApiClient(new Builder().certificatePinner(TextAppearanceConfig.getCertificatePinner()).addInterceptor(new OAuth1aInterceptor(twitterSession, twitterAuthConfig)).build(), new TwitterApi()));
            } else {
                throw new IllegalArgumentException("Session must not be null.");
            }
        }
        return this.apiClients.get(twitterSession);
    }

    public GuestSessionProvider getGuestSessionProvider() {
        if (this.guestSessionProvider == null) {
            synchronized (this) {
                if (this.guestSessionProvider == null) {
                    this.guestSessionProvider = new GuestSessionProvider(new OAuth2Service(this, new TwitterApi()), this.guestSessionManager);
                }
            }
        }
        return this.guestSessionProvider;
    }
}
