package com.rudderstack.android.sdk.core;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class RudderServerConfig implements Serializable {
    @SerializedName("source")
    public RudderServerConfigSource source;
}
