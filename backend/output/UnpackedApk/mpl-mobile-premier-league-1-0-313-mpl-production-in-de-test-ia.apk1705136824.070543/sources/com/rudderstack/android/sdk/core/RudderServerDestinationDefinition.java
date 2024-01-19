package com.rudderstack.android.sdk.core;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class RudderServerDestinationDefinition implements Serializable {
    @SerializedName("name")
    public String definitionName;
    @SerializedName("displayName")
    public String displayName;
    @SerializedName("updatedAt")
    public String updatedAt;
}
