package com.rudderstack.android.sdk.core;

import android.os.Build;
import com.google.gson.annotations.SerializedName;
import com.rudderstack.android.sdk.core.util.Utils;

public class RudderDeviceInfo {
    @SerializedName("adTrackingEnabled")
    public Boolean adTrackingEnabled;
    @SerializedName("advertisingId")
    public String advertisingId;
    @SerializedName("id")
    public String deviceId = Utils.getDeviceId(RudderClient.getApplication());
    @SerializedName("manufacturer")
    public String manufacturer = Build.MANUFACTURER;
    @SerializedName("model")
    public String model = Build.MODEL;
    @SerializedName("name")
    public String name = Build.DEVICE;
    @SerializedName("token")
    public String token;
    @SerializedName("type")
    public String type = "Android";

    public RudderDeviceInfo(String str, String str2) {
        if (str != null && !str.isEmpty()) {
            this.advertisingId = str;
            this.adTrackingEnabled = Boolean.TRUE;
        }
        if (str2 != null && !str2.isEmpty()) {
            this.token = str2;
        }
    }

    public String getAdvertisingId() {
        return this.advertisingId;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public boolean isAdTrackingEnabled() {
        return this.adTrackingEnabled.booleanValue();
    }

    public void setAdTrackingEnabled(boolean z) {
        this.adTrackingEnabled = Boolean.valueOf(z);
    }

    public void setAdvertisingId(String str) {
        this.advertisingId = str;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
