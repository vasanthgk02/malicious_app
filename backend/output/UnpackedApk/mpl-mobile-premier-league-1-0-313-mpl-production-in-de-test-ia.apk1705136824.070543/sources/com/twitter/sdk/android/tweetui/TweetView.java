package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.util.AttributeSet;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.User;

public class TweetView extends BaseTweetView {
    public TweetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void setVerifiedCheck(Tweet tweet) {
        if (tweet != null) {
            User user = tweet.user;
            if (user != null && user.verified) {
                this.fullNameView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R$drawable.tw__ic_tweet_verified, 0);
                return;
            }
        }
        this.fullNameView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    public double getAspectRatioForPhotoEntity(int i) {
        return i == 4 ? 1.0d : 1.5d;
    }

    public int getLayout() {
        return R$layout.tw__tweet;
    }

    public void render() {
        super.render();
        setVerifiedCheck(this.tweet);
    }

    public TweetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
