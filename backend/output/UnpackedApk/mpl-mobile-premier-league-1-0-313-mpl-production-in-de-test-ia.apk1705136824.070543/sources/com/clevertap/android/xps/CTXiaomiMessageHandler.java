package com.clevertap.android.xps;

import com.clevertap.android.sdk.interfaces.INotificationParser;
import com.xiaomi.mipush.sdk.MiPushMessage;

public class CTXiaomiMessageHandler implements IMiMessageHandler {
    public final INotificationParser<MiPushMessage> mParser;

    public CTXiaomiMessageHandler(INotificationParser<MiPushMessage> iNotificationParser) {
        this.mParser = iNotificationParser;
    }
}
