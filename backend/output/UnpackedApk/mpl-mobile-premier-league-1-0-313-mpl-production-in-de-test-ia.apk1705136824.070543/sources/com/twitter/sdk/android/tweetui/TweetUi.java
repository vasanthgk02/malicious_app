package com.twitter.sdk.android.tweetui;

import android.annotation.SuppressLint;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterCore;

public class TweetUi {
    @SuppressLint({"StaticFieldLeak"})
    public static volatile TweetUi instance;
    public Picasso imageLoader;
    public TweetRepository tweetRepository;

    public TweetUi() {
        TwitterCore.getInstance();
        Twitter.getInstance();
        throw null;
    }

    public static TweetUi getInstance() {
        if (instance == null) {
            synchronized (TweetUi.class) {
                try {
                    if (instance == null) {
                        TwitterCore.getInstance();
                        Twitter.getInstance();
                        throw null;
                    }
                }
            }
        }
        return instance;
    }
}
