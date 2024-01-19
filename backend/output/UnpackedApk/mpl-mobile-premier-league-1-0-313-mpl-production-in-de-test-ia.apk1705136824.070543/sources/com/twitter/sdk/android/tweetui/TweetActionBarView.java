package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.models.Tweet;

public class TweetActionBarView extends LinearLayout {
    public Callback<Tweet> actionCallback;
    public final DependencyProvider dependencyProvider;
    public ToggleImageButton likeButton;
    public ImageButton shareButton;

    public static class DependencyProvider {
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public TweetActionBarView(Context context, AttributeSet attributeSet) {
        // DependencyProvider dependencyProvider2 = new DependencyProvider();
        super(context, attributeSet);
        this.dependencyProvider = dependencyProvider2;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.likeButton = (ToggleImageButton) findViewById(R$id.tw__tweet_like_button);
        this.shareButton = (ImageButton) findViewById(R$id.tw__tweet_share_button);
    }

    public void setLike(Tweet tweet) {
        if (this.dependencyProvider != null) {
            TweetUi instance = TweetUi.getInstance();
            if (tweet != null) {
                this.likeButton.setToggledOn(tweet.favorited);
                this.likeButton.setOnClickListener(new LikeTweetAction(tweet, instance, this.actionCallback));
                return;
            }
            return;
        }
        throw null;
    }

    public void setOnActionCallback(Callback<Tweet> callback) {
        this.actionCallback = callback;
    }

    public void setShare(Tweet tweet) {
        if (this.dependencyProvider != null) {
            TweetUi instance = TweetUi.getInstance();
            if (tweet != null) {
                this.shareButton.setOnClickListener(new ShareTweetAction(tweet, instance));
                return;
            }
            return;
        }
        throw null;
    }

    public void setTweet(Tweet tweet) {
        setLike(tweet);
        setShare(tweet);
    }
}
