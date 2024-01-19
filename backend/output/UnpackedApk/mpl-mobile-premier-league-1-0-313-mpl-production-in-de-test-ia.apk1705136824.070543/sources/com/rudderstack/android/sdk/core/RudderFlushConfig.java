package com.rudderstack.android.sdk.core;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class RudderFlushConfig implements Serializable {
    @SerializedName("anonymousHeaderString")
    public String anonymousHeaderString;
    @SerializedName("authHeaderString")
    public String authHeaderString;
    @SerializedName("dataPlaneUrl")
    public String dataPlaneUrl;
    @SerializedName("flushQueueSize")
    public int flushQueueSize;
    @SerializedName("logLevel")
    public int logLevel;

    public RudderFlushConfig(String str, String str2, String str3, int i, int i2) {
        this.dataPlaneUrl = str;
        this.authHeaderString = str2;
        this.anonymousHeaderString = str3;
        this.flushQueueSize = i;
        this.logLevel = i2;
    }

    public String getAnonymousHeaderString() {
        return this.anonymousHeaderString;
    }

    public String getAuthHeaderString() {
        return this.authHeaderString;
    }

    public String getDataPlaneUrl() {
        return this.dataPlaneUrl;
    }

    public int getFlushQueueSize() {
        return this.flushQueueSize;
    }

    public int getLogLevel() {
        return this.logLevel;
    }
}
