package com.twitter.sdk.android.core.models;

import com.google.android.material.resources.TextAppearanceConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ApiErrors {
    @SerializedName("errors")
    public final List<ApiError> errors = TextAppearanceConfig.getSafeList(null);
}
