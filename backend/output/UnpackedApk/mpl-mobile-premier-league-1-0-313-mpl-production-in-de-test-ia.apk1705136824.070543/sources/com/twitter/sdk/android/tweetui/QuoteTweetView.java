package com.twitter.sdk.android.tweetui;

import android.content.Context;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.AbstractTweetView.DependencyProvider;

public class QuoteTweetView extends AbstractTweetView {
    public QuoteTweetView(Context context) {
        super(context, null, 0, new DependencyProvider());
    }

    public double getAspectRatio(MediaEntity mediaEntity) {
        double aspectRatio = super.getAspectRatio(mediaEntity);
        if (aspectRatio <= 1.0d) {
            return 1.0d;
        }
        if (aspectRatio > 3.0d) {
            return 3.0d;
        }
        if (aspectRatio < 1.3333333333333333d) {
            return 1.3333333333333333d;
        }
        return aspectRatio;
    }

    public double getAspectRatioForPhotoEntity(int i) {
        return 1.6d;
    }

    public int getLayout() {
        return R$layout.tw__tweet_quote;
    }

    public /* bridge */ /* synthetic */ Tweet getTweet() {
        return super.getTweet();
    }

    public /* bridge */ /* synthetic */ long getTweetId() {
        return super.getTweetId();
    }

    public void render() {
        super.render();
        this.screenNameView.requestLayout();
    }

    public /* bridge */ /* synthetic */ void setTweet(Tweet tweet) {
        super.setTweet(tweet);
    }

    public /* bridge */ /* synthetic */ void setTweetLinkClickListener(TweetLinkClickListener tweetLinkClickListener) {
        super.setTweetLinkClickListener(tweetLinkClickListener);
    }

    public /* bridge */ /* synthetic */ void setTweetMediaClickListener(TweetMediaClickListener tweetMediaClickListener) {
        super.setTweetMediaClickListener(tweetMediaClickListener);
    }
}
