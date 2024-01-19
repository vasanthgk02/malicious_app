package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Intent;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterSession;

public class OAuthHandler extends AuthHandler {
    public OAuthHandler(TwitterAuthConfig twitterAuthConfig, Callback<TwitterSession> callback, int i) {
        super(twitterAuthConfig, callback, i);
    }

    public boolean authorize(Activity activity) {
        Intent intent = new Intent(activity, OAuthActivity.class);
        intent.putExtra("auth_config", this.config);
        activity.startActivityForResult(intent, this.requestCode);
        return true;
    }
}
