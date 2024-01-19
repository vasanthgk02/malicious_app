package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.models.Tweet;

public class BaseTweetAction {
    public final Callback<Tweet> actionCallback;

    public BaseTweetAction(Callback<Tweet> callback) {
        this.actionCallback = callback;
    }
}
