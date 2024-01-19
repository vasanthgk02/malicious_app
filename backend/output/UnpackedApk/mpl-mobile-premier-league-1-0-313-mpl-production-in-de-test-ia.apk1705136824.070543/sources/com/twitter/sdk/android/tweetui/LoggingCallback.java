package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.TwitterException;

public abstract class LoggingCallback<T> extends Callback<T> {
    public final Callback cb;
    public final DefaultLogger logger;

    public LoggingCallback(Callback callback, DefaultLogger defaultLogger) {
        this.cb = callback;
        this.logger = defaultLogger;
    }

    public void failure(TwitterException twitterException) {
        DefaultLogger defaultLogger = this.logger;
        twitterException.getMessage();
        if (defaultLogger != null) {
            Callback callback = this.cb;
            if (callback != null) {
                callback.failure(twitterException);
                return;
            }
            return;
        }
        throw null;
    }
}
