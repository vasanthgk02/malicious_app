package com.clevertap.android.sdk.pushnotification.fcm;

import android.os.Bundle;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.interfaces.INotificationParser;
import com.clevertap.android.sdk.pushnotification.PushConstants;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map.Entry;

public class FcmNotificationParser implements INotificationParser<RemoteMessage> {
    public Bundle toBundle(Object obj) {
        RemoteMessage remoteMessage = (RemoteMessage) obj;
        try {
            Bundle bundle = new Bundle();
            for (Entry next : remoteMessage.getData().entrySet()) {
                bundle.putString((String) next.getKey(), (String) next.getValue());
            }
            Logger.d("PushProvider", PushConstants.FCM_LOG_TAG + "Found Valid Notification Message ");
            return bundle;
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.d("PushProvider", PushConstants.FCM_LOG_TAG + "Invalid Notification Message ", th);
            return null;
        }
    }
}
