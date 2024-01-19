package io.hansel.core.sdkmodels;

import io.hansel.core.base.utils.HSLVersion;

public class HSLSDKIdentifiers {
    public String appId;
    public HSLVersion appVersion;
    public String deviceId;
    public String guid;
    public String secret;

    public HSLSDKIdentifiers(String str, String str2, HSLVersion hSLVersion, String str3, String str4) {
        this.appId = str;
        this.appVersion = hSLVersion;
        this.deviceId = str3;
        this.secret = str2;
        this.guid = str4;
    }

    public String getAppId() {
        return this.appId;
    }

    public HSLVersion getAppVersion() {
        return this.appVersion;
    }

    public String getDeviceId() {
        if (this.deviceId == null) {
            this.deviceId = "";
        }
        return this.deviceId;
    }

    public String getSecret() {
        return this.secret;
    }
}
