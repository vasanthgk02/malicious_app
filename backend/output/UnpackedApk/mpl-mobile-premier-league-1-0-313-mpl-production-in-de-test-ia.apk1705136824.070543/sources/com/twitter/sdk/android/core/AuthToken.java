package com.twitter.sdk.android.core;

import com.google.gson.annotations.SerializedName;

public abstract class AuthToken {
    @SerializedName("created_at")
    public final long createdAt = System.currentTimeMillis();
}
