package com.twitter.sdk.android.core;

import com.google.gson.annotations.SerializedName;

public class TwitterSession extends Session<TwitterAuthToken> {
    @SerializedName("user_name")
    public final String userName;

    public TwitterSession(TwitterAuthToken twitterAuthToken, long j, String str) {
        super(twitterAuthToken, j);
        this.userName = str;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || TwitterSession.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        String str = this.userName;
        String str2 = ((TwitterSession) obj).userName;
        if (str != null) {
            z = str.equals(str2);
        } else if (str2 != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.userName;
        return hashCode + (str != null ? str.hashCode() : 0);
    }
}
