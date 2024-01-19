package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterSession;

public abstract class AuthHandler {
    public final TwitterAuthConfig config;
    public final int requestCode;

    public AuthHandler(TwitterAuthConfig twitterAuthConfig, Callback<TwitterSession> callback, int i) {
        this.config = twitterAuthConfig;
        this.requestCode = i;
    }

    public abstract boolean authorize(Activity activity);
}
