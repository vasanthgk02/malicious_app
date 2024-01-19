package com.clevertap.android.xps;

import android.os.Bundle;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.interfaces.INotificationParser;
import com.xiaomi.mipush.sdk.MiPushMessage;

public class XiaomiNotificationParser implements INotificationParser<MiPushMessage> {
    public Bundle toBundle(MiPushMessage miPushMessage) {
        try {
            Bundle stringToBundle = Utils.stringToBundle(miPushMessage.getContent());
            Logger.d("PushProvider", XpsConstants.XIAOMI_LOG_TAG + "Found Valid Notification Message ");
            return stringToBundle;
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.d("PushProvider", XpsConstants.XIAOMI_LOG_TAG + "Invalid Notification Message ", th);
            return null;
        }
    }
}
