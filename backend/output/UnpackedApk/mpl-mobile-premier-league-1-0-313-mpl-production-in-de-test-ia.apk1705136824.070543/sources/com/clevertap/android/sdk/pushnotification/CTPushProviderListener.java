package com.clevertap.android.sdk.pushnotification;

import com.clevertap.android.sdk.pushnotification.PushConstants.PushType;

public interface CTPushProviderListener {
    void onNewToken(String str, PushType pushType);
}
