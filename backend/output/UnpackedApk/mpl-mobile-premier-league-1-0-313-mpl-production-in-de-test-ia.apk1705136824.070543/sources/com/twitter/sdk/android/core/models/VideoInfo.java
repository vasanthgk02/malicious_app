package com.twitter.sdk.android.core.models;

import com.google.android.material.resources.TextAppearanceConfig;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class VideoInfo implements Serializable {
    @SerializedName("aspect_ratio")
    public final List<Integer> aspectRatio = TextAppearanceConfig.getSafeList(null);
    @SerializedName("duration_millis")
    public final long durationMillis = 0;
    @SerializedName("variants")
    public final List<Variant> variants = TextAppearanceConfig.getSafeList(null);

    public static class Variant implements Serializable {
        @SerializedName("bitrate")
        public final long bitrate;
        @SerializedName("content_type")
        public final String contentType;
        @SerializedName("url")
        public final String url;
    }
}
