package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;

public class ImageValue {
    @SerializedName("alt")
    public final String alt;
    @SerializedName("height")
    public final int height;
    @SerializedName("url")
    public final String url;
    @SerializedName("width")
    public final int width;
}
