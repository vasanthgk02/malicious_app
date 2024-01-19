package com.twitter.sdk.android.core.models;

import com.google.android.material.resources.TextAppearanceConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class UserEntities {
    @SerializedName("description")
    public final UrlEntities description;
    @SerializedName("url")
    public final UrlEntities url;

    public static class UrlEntities {
        @SerializedName("urls")
        public final List<UrlEntity> urls = TextAppearanceConfig.getSafeList(null);
    }
}
