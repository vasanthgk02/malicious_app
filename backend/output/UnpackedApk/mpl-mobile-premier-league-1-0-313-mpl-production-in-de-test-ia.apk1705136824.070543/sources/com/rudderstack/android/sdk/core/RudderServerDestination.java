package com.rudderstack.android.sdk.core;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class RudderServerDestination implements Serializable {
    @SerializedName("config")
    public Object destinationConfig;
    @SerializedName("destinationDefinition")
    public RudderServerDestinationDefinition destinationDefinition;
    @SerializedName("id")
    public String destinationId;
    @SerializedName("name")
    public String destinationName;
    @SerializedName("enabled")
    public boolean isDestinationEnabled;
    @SerializedName("updatedAt")
    public String updatedAt;
}
