package com.mpl.analytics;

import com.clevertap.android.sdk.CTInboxListener;
import com.clevertap.android.sdk.CleverTapAPI.DevicePushTokenRefreshListener;
import com.clevertap.android.sdk.InAppNotificationListener;
import com.clevertap.android.sdk.SyncListener;

public interface MPLCTLsterner {
    void setCTNotificationInboxListener(CTInboxListener cTInboxListener);

    void setDevicePushTokenRefreshListener(DevicePushTokenRefreshListener devicePushTokenRefreshListener);

    void setInAppNotificationButtonListener(MPLCTInAppNotificationButtonListener mPLCTInAppNotificationButtonListener);

    void setInAppNotificationListener(InAppNotificationListener inAppNotificationListener);

    void setNotificationHandler();

    void setSyncListener(SyncListener syncListener);
}
