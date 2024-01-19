package com.twitter.sdk.android.core.models;

import com.google.android.material.resources.TextAppearanceConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

public class Place {
    @SerializedName("attributes")
    public final Map<String, String> attributes;
    @SerializedName("bounding_box")
    public final BoundingBox boundingBox;
    @SerializedName("country")
    public final String country;
    @SerializedName("country_code")
    public final String countryCode;
    @SerializedName("full_name")
    public final String fullName;
    @SerializedName("id")
    public final String id;
    @SerializedName("name")
    public final String name;
    @SerializedName("place_type")
    public final String placeType;
    @SerializedName("url")
    public final String url;

    public static class BoundingBox {
        @SerializedName("coordinates")
        public final List<List<List<Double>>> coordinates = TextAppearanceConfig.getSafeList(null);
        @SerializedName("type")
        public final String type = null;
    }
}
