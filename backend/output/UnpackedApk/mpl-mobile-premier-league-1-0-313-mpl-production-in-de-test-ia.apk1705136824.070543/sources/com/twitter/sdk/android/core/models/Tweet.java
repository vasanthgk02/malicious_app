package com.twitter.sdk.android.core.models;

import com.google.android.material.resources.TextAppearanceConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Tweet {
    @SerializedName("card")
    public final Card card;
    @SerializedName("coordinates")
    public final Coordinates coordinates;
    @SerializedName("created_at")
    public final String createdAt;
    @SerializedName("current_user_retweet")
    public final Object currentUserRetweet;
    @SerializedName("display_text_range")
    public final List<Integer> displayTextRange;
    @SerializedName("entities")
    public final TweetEntities entities;
    @SerializedName("extended_entities")
    public final TweetEntities extendedEntities;
    @SerializedName("favorite_count")
    public final Integer favoriteCount;
    @SerializedName("favorited")
    public final boolean favorited;
    @SerializedName("filter_level")
    public final String filterLevel;
    @SerializedName("id")
    public final long id;
    @SerializedName("id_str")
    public final String idStr;
    @SerializedName("in_reply_to_screen_name")
    public final String inReplyToScreenName;
    @SerializedName("in_reply_to_status_id")
    public final long inReplyToStatusId;
    @SerializedName("in_reply_to_status_id_str")
    public final String inReplyToStatusIdStr;
    @SerializedName("in_reply_to_user_id")
    public final long inReplyToUserId;
    @SerializedName("in_reply_to_user_id_str")
    public final String inReplyToUserIdStr;
    @SerializedName("lang")
    public final String lang;
    @SerializedName("place")
    public final Place place;
    @SerializedName("possibly_sensitive")
    public final boolean possiblySensitive;
    @SerializedName("quoted_status")
    public final Tweet quotedStatus;
    @SerializedName("quoted_status_id")
    public final long quotedStatusId;
    @SerializedName("quoted_status_id_str")
    public final String quotedStatusIdStr;
    @SerializedName("retweet_count")
    public final int retweetCount;
    @SerializedName("retweeted")
    public final boolean retweeted;
    @SerializedName("retweeted_status")
    public final Tweet retweetedStatus;
    @SerializedName("scopes")
    public final Object scopes;
    @SerializedName("source")
    public final String source;
    @SerializedName(alternate = {"full_text"}, value = "text")
    public final String text;
    @SerializedName("truncated")
    public final boolean truncated;
    @SerializedName("user")
    public final User user;
    @SerializedName("withheld_copyright")
    public final boolean withheldCopyright;
    @SerializedName("withheld_in_countries")
    public final List<String> withheldInCountries;
    @SerializedName("withheld_scope")
    public final String withheldScope;

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Tweet() {
        /*
            r39 = this;
            r0 = r39
            com.twitter.sdk.android.core.models.TweetEntities r5 = com.twitter.sdk.android.core.models.TweetEntities.EMPTY
            r4 = r5
            r1 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)
            r1 = 0
            r2 = 0
            r3 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r11 = "0"
            r12 = 0
            r13 = 0
            java.lang.String r15 = "0"
            r16 = 0
            java.lang.String r18 = "0"
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            java.lang.String r25 = "0"
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r15, r16, r18, r19, r20, r21, r22, r23, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.core.models.Tweet.<init>():void");
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null || !(obj instanceof Tweet)) {
            return false;
        }
        if (this.id == ((Tweet) obj).id) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (int) this.id;
    }

    public Tweet(Coordinates coordinates2, String str, Object obj, TweetEntities tweetEntities, TweetEntities tweetEntities2, Integer num, boolean z, String str2, long j, String str3, String str4, long j2, String str5, long j3, String str6, String str7, Place place2, boolean z2, Object obj2, long j4, String str8, Tweet tweet, int i, boolean z3, Tweet tweet2, String str9, String str10, List<Integer> list, boolean z4, User user2, boolean z5, List<String> list2, String str11, Card card2) {
        this.coordinates = coordinates2;
        this.createdAt = str;
        this.currentUserRetweet = obj;
        this.entities = tweetEntities == null ? TweetEntities.EMPTY : tweetEntities;
        this.extendedEntities = tweetEntities2 == null ? TweetEntities.EMPTY : tweetEntities2;
        this.favoriteCount = num;
        this.favorited = z;
        this.filterLevel = str2;
        this.id = j;
        this.idStr = str3;
        this.inReplyToScreenName = str4;
        this.inReplyToStatusId = j2;
        this.inReplyToStatusIdStr = str5;
        this.inReplyToUserId = j3;
        this.inReplyToUserIdStr = str6;
        this.lang = str7;
        this.place = place2;
        this.possiblySensitive = z2;
        this.scopes = obj2;
        this.quotedStatusId = j4;
        this.quotedStatusIdStr = str8;
        this.quotedStatus = tweet;
        this.retweetCount = i;
        this.retweeted = z3;
        this.retweetedStatus = tweet2;
        this.source = str9;
        this.text = str10;
        this.displayTextRange = TextAppearanceConfig.getSafeList(list);
        this.truncated = z4;
        this.user = user2;
        this.withheldCopyright = z5;
        this.withheldInCountries = TextAppearanceConfig.getSafeList(list2);
        this.withheldScope = str11;
        this.card = card2;
    }
}
