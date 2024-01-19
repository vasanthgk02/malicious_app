package com.twitter.sdk.android.tweetui;

import java.util.List;

public class FormattedTweetText {
    public final List<FormattedUrlEntity> hashtagEntities;
    public final List<FormattedMediaEntity> mediaEntities;
    public final List<FormattedUrlEntity> mentionEntities;
    public final List<FormattedUrlEntity> symbolEntities;
    public String text;
    public final List<FormattedUrlEntity> urlEntities;
}
