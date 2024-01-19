package com.clevertap.android.sdk.pushnotification.fcm;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.pushnotification.PushConstants;
import com.clevertap.android.sdk.pushnotification.PushConstants.PushType;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FcmMessageListenerService extends FirebaseMessagingService {
    public IFcmMessageHandler mHandler = new CTFcmMessageHandler();

    public void onMessageReceived(RemoteMessage remoteMessage) {
        ((CTFcmMessageHandler) this.mHandler).createNotification(getApplicationContext(), remoteMessage);
    }

    public void onNewToken(String str) {
        super.onNewToken(str);
        IFcmMessageHandler iFcmMessageHandler = this.mHandler;
        Context applicationContext = getApplicationContext();
        if (((CTFcmMessageHandler) iFcmMessageHandler) != null) {
            try {
                String type = PushType.FCM.getType();
                if (type.equals(PushType.FCM.getType())) {
                    CleverTapAPI.tokenRefresh(applicationContext, str, PushType.FCM);
                } else if (type.equals(PushType.HPS.getType())) {
                    CleverTapAPI.tokenRefresh(applicationContext, str, PushType.HPS);
                } else if (type.equals(PushType.XPS.getType())) {
                    CleverTapAPI.tokenRefresh(applicationContext, str, PushType.XPS);
                }
                Logger.d("PushProvider", PushConstants.FCM_LOG_TAG + "New token received from FCM - " + str);
            } catch (Throwable th) {
                Logger.d("PushProvider", PushConstants.FCM_LOG_TAG + "Error onNewToken", th);
            }
        } else {
            throw null;
        }
    }
}
