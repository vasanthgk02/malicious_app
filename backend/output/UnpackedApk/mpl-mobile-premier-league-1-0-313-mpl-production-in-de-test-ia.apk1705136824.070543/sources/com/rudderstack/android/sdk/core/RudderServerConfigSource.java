package com.rudderstack.android.sdk.core;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class RudderServerConfigSource implements Serializable {
    @SerializedName("destinations")
    public List<RudderServerDestination> destinations;
    @SerializedName("enabled")
    public boolean isSourceEnabled;
    @SerializedName("id")
    public String sourceId;
    @SerializedName("name")
    public String sourceName;
    @SerializedName("updatedAt")
    public String updatedAt;
}
