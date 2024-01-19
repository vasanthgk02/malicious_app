package com.twitter.sdk.android.tweetui;

import android.os.Handler;
import androidx.collection.LruCache;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.Tweet;

public class TweetRepository {
    public final Handler mainHandler;
    public final LruCache<Long, Tweet> tweetCache;
    public final TwitterCore twitterCore;

    public class SingleTweetCallback extends Callback<Tweet> {
        public final Callback<Tweet> cb;

        public SingleTweetCallback(Callback<Tweet> callback) {
            this.cb = callback;
        }

        public void failure(TwitterException twitterException) {
            this.cb.failure(twitterException);
        }

        public void success(Result<Tweet> result) {
            Tweet tweet = (Tweet) result.data;
            TweetRepository.this.tweetCache.put(Long.valueOf(tweet.id), tweet);
            Callback<Tweet> callback = this.cb;
            if (callback != null) {
                callback.success(new Result(tweet, result.response));
            }
        }
    }

    public abstract FormattedTweetText formatTweetText(Tweet tweet);

    public abstract void getUserSession(Callback<TwitterSession> callback);
}
