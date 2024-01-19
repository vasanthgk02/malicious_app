package com.clevertap.android.sdk.pushnotification;

import com.clevertap.android.sdk.pushnotification.PushConstants.PushType;

public interface CTPushProvider {
    int getPlatform();

    PushType getPushType();

    boolean isAvailable();

    boolean isSupported();

    int minSDKSupportVersionCode();

    void requestToken();
}
