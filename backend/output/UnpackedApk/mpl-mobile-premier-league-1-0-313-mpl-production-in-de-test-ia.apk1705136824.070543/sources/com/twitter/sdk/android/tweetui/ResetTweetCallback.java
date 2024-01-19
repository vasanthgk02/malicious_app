package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;

public class ResetTweetCallback extends Callback<Tweet> {
    public final BaseTweetView baseTweetView;
    public final Callback<Tweet> cb;
    public final TweetRepository tweetRepository;

    public ResetTweetCallback(BaseTweetView baseTweetView2, TweetRepository tweetRepository2, Callback<Tweet> callback) {
        this.baseTweetView = baseTweetView2;
        this.tweetRepository = tweetRepository2;
        this.cb = callback;
    }

    public void failure(TwitterException twitterException) {
        Callback<Tweet> callback = this.cb;
        if (callback != null) {
            callback.failure(twitterException);
        }
    }

    public void success(Result<Tweet> result) {
        TweetRepository tweetRepository2 = this.tweetRepository;
        Tweet tweet = (Tweet) result.data;
        tweetRepository2.tweetCache.put(Long.valueOf(tweet.id), tweet);
        this.baseTweetView.setTweet((Tweet) result.data);
        Callback<Tweet> callback = this.cb;
        if (callback != null) {
            callback.success(result);
        }
    }
}
