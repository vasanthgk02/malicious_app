package com.twitter.sdk.android.core.models;

import java.util.List;

public class TweetBuilder {
    public Card card;
    public Coordinates coordinates;
    public String createdAt;
    public Object currentUserRetweet;
    public List<Integer> displayTextRange;
    public TweetEntities entities;
    public TweetEntities extendedEntities;
    public Integer favoriteCount;
    public boolean favorited;
    public String filterLevel;
    public long id = -1;
    public String idStr;
    public String inReplyToScreenName;
    public long inReplyToStatusId;
    public String inReplyToStatusIdStr;
    public long inReplyToUserId;
    public String inReplyToUserIdStr;
    public String lang;
    public Place place;
    public boolean possiblySensitive;
    public Tweet quotedStatus;
    public long quotedStatusId;
    public String quotedStatusIdStr;
    public int retweetCount;
    public boolean retweeted;
    public Tweet retweetedStatus;
    public Object scopes;
    public String source;
    public String text;
    public boolean truncated;
    public User user;
    public boolean withheldCopyright;
    public List<String> withheldInCountries;
    public String withheldScope;

    public Tweet build() {
        Tweet tweet = new Tweet(this.coordinates, this.createdAt, this.currentUserRetweet, this.entities, this.extendedEntities, this.favoriteCount, this.favorited, this.filterLevel, this.id, this.idStr, this.inReplyToScreenName, this.inReplyToStatusId, this.inReplyToStatusIdStr, this.inReplyToUserId, this.inReplyToUserIdStr, this.lang, this.place, this.possiblySensitive, this.scopes, this.quotedStatusId, this.quotedStatusIdStr, this.quotedStatus, this.retweetCount, this.retweeted, this.retweetedStatus, this.source, this.text, this.displayTextRange, this.truncated, this.user, this.withheldCopyright, this.withheldInCountries, this.withheldScope, this.card);
        return tweet;
    }

    public TweetBuilder copy(Tweet tweet) {
        this.coordinates = tweet.coordinates;
        this.createdAt = tweet.createdAt;
        this.currentUserRetweet = tweet.currentUserRetweet;
        this.entities = tweet.entities;
        this.extendedEntities = tweet.extendedEntities;
        this.favoriteCount = tweet.favoriteCount;
        this.favorited = tweet.favorited;
        this.filterLevel = tweet.filterLevel;
        this.id = tweet.id;
        this.idStr = tweet.idStr;
        this.inReplyToScreenName = tweet.inReplyToScreenName;
        this.inReplyToStatusId = tweet.inReplyToStatusId;
        String str = tweet.inReplyToStatusIdStr;
        this.inReplyToStatusIdStr = str;
        this.inReplyToUserId = tweet.inReplyToUserId;
        this.inReplyToUserIdStr = str;
        this.lang = tweet.lang;
        this.place = tweet.place;
        this.possiblySensitive = tweet.possiblySensitive;
        this.scopes = tweet.scopes;
        this.quotedStatusId = tweet.quotedStatusId;
        this.quotedStatusIdStr = tweet.quotedStatusIdStr;
        this.quotedStatus = tweet.quotedStatus;
        this.retweetCount = tweet.retweetCount;
        this.retweeted = tweet.retweeted;
        this.retweetedStatus = tweet.retweetedStatus;
        this.source = tweet.source;
        this.text = tweet.text;
        this.displayTextRange = tweet.displayTextRange;
        this.truncated = tweet.truncated;
        this.user = tweet.user;
        this.withheldCopyright = tweet.withheldCopyright;
        this.withheldInCountries = tweet.withheldInCountries;
        this.withheldScope = tweet.withheldScope;
        this.card = tweet.card;
        return this;
    }
}
