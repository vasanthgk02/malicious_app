package com.clevertap.android.sdk.pushnotification;

import java.util.HashMap;

public interface CTPushNotificationListener {
    void onNotificationClickedPayloadReceived(HashMap<String, Object> hashMap);
}
