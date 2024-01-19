package com.clevertap.android.sdk;

import com.clevertap.android.sdk.interfaces.NotificationRenderedListener;
import com.clevertap.android.sdk.pushnotification.CTPushNotificationListener;
import com.clevertap.android.sdk.pushnotification.amp.CTPushAmpListener;
import java.lang.ref.WeakReference;

public class CallbackManager extends BaseCallbackManager {
    public final CleverTapInstanceConfig config;
    public final DeviceInfo deviceInfo;
    public FailureFlushListener failureFlushListener;
    public WeakReference<InAppNotificationButtonListener> inAppNotificationButtonListener;
    public InAppNotificationListener inAppNotificationListener;
    public CTInboxListener inboxListener;
    public NotificationRenderedListener notificationRenderedListener;
    public CTPushAmpListener pushAmpListener = null;
    public CTPushNotificationListener pushNotificationListener = null;
    public SyncListener syncListener = null;

    public CallbackManager(CleverTapInstanceConfig cleverTapInstanceConfig, DeviceInfo deviceInfo2) {
        this.config = cleverTapInstanceConfig;
        this.deviceInfo = deviceInfo2;
    }

    public void _notifyInboxMessagesDidUpdate() {
        if (this.inboxListener != null) {
            Utils.runOnUiThread(new Runnable() {
                public void run() {
                    CTInboxListener cTInboxListener = CallbackManager.this.inboxListener;
                    if (cTInboxListener != null) {
                        cTInboxListener.inboxMessagesDidUpdate();
                    }
                }
            });
        }
    }

    public InAppNotificationButtonListener getInAppNotificationButtonListener() {
        WeakReference<InAppNotificationButtonListener> weakReference = this.inAppNotificationButtonListener;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return (InAppNotificationButtonListener) this.inAppNotificationButtonListener.get();
    }

    public void notifyUserProfileInitialized(String str) {
        if (str == null) {
            str = this.deviceInfo.getDeviceID();
        }
        if (str != null) {
            try {
                SyncListener syncListener2 = this.syncListener;
                if (syncListener2 != null) {
                    syncListener2.profileDidInitialize(str);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
