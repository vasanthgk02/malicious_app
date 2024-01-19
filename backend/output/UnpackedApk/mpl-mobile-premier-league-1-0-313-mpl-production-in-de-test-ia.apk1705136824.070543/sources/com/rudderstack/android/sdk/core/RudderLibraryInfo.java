package com.rudderstack.android.sdk.core;

import com.google.gson.annotations.SerializedName;

public class RudderLibraryInfo {
    @SerializedName("name")
    public String name = "com.rudderstack.android.sdk.corempx";
    @SerializedName("version")
    public String version = Constants.RUDDER_LIBRARY_VERSION;
}
