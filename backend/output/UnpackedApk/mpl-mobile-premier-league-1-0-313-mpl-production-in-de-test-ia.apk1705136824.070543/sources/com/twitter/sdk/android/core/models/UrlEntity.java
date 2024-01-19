package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;

public class UrlEntity extends Entity {
    @SerializedName("display_url")
    public final String displayUrl;
    @SerializedName("expanded_url")
    public final String expandedUrl;
    @SerializedName("url")
    public final String url;
}
