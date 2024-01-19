package com.rudderstack.android.sdk.core;

import android.os.Build.VERSION;
import com.google.gson.annotations.SerializedName;

public class RudderOSInfo {
    @SerializedName("name")
    public String name = "Android";
    @SerializedName("version")
    public String version = VERSION.RELEASE;
}
