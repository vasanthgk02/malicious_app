package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.material.resources.TextAppearanceConfig;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.User;

public class ShareTweetAction implements OnClickListener {
    public final Tweet tweet;

    public ShareTweetAction(Tweet tweet2, TweetUi tweetUi) {
        this.tweet = tweet2;
    }

    public void onClick(View view) {
        Context context = view.getContext();
        Resources resources = view.getResources();
        Tweet tweet2 = this.tweet;
        if (tweet2 != null) {
            User user = tweet2.user;
            if (user != null) {
                String string = resources.getString(R$string.tw__share_subject_format, new Object[]{user.name, user.screenName});
                int i = R$string.tw__share_content_format;
                Tweet tweet3 = this.tweet;
                String string2 = resources.getString(i, new Object[]{tweet3.user.screenName, Long.toString(tweet3.id)});
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.SUBJECT", string);
                intent.putExtra("android.intent.extra.TEXT", string2);
                intent.setType("text/plain");
                TextAppearanceConfig.safeStartActivity(context, Intent.createChooser(intent, resources.getString(R$string.tw__share_tweet)));
            }
        }
    }
}
