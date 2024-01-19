package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.util.AttributeSet;
import com.twitter.sdk.android.core.models.MediaEntity;

public class CompactTweetView extends BaseTweetView {
    public CompactTweetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void applyStyles() {
        super.applyStyles();
        setPadding(0, getResources().getDimensionPixelSize(R$dimen.tw__compact_tweet_container_padding_top), 0, 0);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.tw__media_view_radius);
        this.tweetMediaView.setRoundedCornersRadii(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
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
        return R$layout.tw__tweet_compact;
    }

    public void render() {
        super.render();
        this.screenNameView.requestLayout();
    }

    public CompactTweetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
