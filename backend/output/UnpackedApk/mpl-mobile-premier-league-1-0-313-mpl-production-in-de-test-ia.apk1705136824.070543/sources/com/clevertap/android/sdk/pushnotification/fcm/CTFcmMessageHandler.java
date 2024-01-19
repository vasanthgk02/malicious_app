package com.clevertap.android.sdk.pushnotification.fcm;

import android.content.Context;
import android.os.Bundle;
import com.clevertap.android.sdk.interfaces.INotificationParser;
import com.clevertap.android.sdk.pushnotification.PushConstants.PushType;
import com.clevertap.android.sdk.pushnotification.PushNotificationHandler.SingletonNotificationHandler;
import com.google.firebase.messaging.RemoteMessage;
import org.apache.pdfbox.pdfparser.BaseParser;

public class CTFcmMessageHandler implements IFcmMessageHandler {
    public final INotificationParser<RemoteMessage> mParser = new FcmNotificationParser();

    public boolean createNotification(Context context, RemoteMessage remoteMessage) {
        Bundle bundle = this.mParser.toBundle(remoteMessage);
        if (bundle == null) {
            return false;
        }
        bundle.putString("wzrk_pn_h", BaseParser.TRUE);
        if (!bundle.containsKey("nh_source")) {
            bundle.putString("nh_source", "FcmMessageListenerService");
        }
        return SingletonNotificationHandler.INSTANCE.onMessageReceived(context, bundle, PushType.FCM.toString());
    }
}
