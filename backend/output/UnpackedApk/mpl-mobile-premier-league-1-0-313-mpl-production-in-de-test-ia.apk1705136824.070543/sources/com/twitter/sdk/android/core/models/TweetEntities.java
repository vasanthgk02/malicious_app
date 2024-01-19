package com.twitter.sdk.android.core.models;

import com.google.android.material.resources.TextAppearanceConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TweetEntities {
    public static final TweetEntities EMPTY;
    @SerializedName("hashtags")
    public final List<Object> hashtags;
    @SerializedName("media")
    public final List<MediaEntity> media;
    @SerializedName("symbols")
    public final List<Object> symbols;
    @SerializedName("urls")
    public final List<UrlEntity> urls;
    @SerializedName("user_mentions")
    public final List<Object> userMentions;

    static {
        TweetEntities tweetEntities = new TweetEntities(null, null, null, null, null);
        EMPTY = tweetEntities;
    }

    public TweetEntities() {
        this(null, null, null, null, null);
    }

    public TweetEntities(List<UrlEntity> list, List<Object> list2, List<MediaEntity> list3, List<Object> list4, List<Object> list5) {
        this.urls = TextAppearanceConfig.getSafeList(null);
        this.userMentions = TextAppearanceConfig.getSafeList(null);
        this.media = TextAppearanceConfig.getSafeList(null);
        this.hashtags = TextAppearanceConfig.getSafeList(null);
        this.symbols = TextAppearanceConfig.getSafeList(null);
    }
}
