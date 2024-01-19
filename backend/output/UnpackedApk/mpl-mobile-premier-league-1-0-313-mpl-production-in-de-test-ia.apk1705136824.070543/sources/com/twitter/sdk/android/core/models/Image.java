package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("h")
    public final int h;
    @SerializedName("image_type")
    public final String imageType;
    @SerializedName("w")
    public final int w;
}
