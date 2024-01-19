package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class Entity implements Serializable {
    @SerializedName("indices")
    public final List<Integer> indices;
}
