package com.clevertap.android.sdk.pushnotification;

import android.content.Context;
import android.os.Bundle;
import co.hyperverge.hypersnapsdk.c.k;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.interfaces.ActionButtonClickHandler;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;

public class PushNotificationHandler implements ActionButtonClickHandler {

    public static class SingletonNotificationHandler {
        public static final PushNotificationHandler INSTANCE = new PushNotificationHandler(null);
    }

    public PushNotificationHandler(AnonymousClass1 r1) {
    }

    public static boolean isForPushTemplates(Bundle bundle) {
        String string = bundle.getString("pt_id");
        return !"0".equals(string) && string != null && !string.isEmpty();
    }

    public boolean onActionButtonClick(Context context, Bundle bundle, int i) {
        return false;
    }

    public synchronized boolean onMessageReceived(Context context, Bundle bundle, String str) {
        CleverTapAPI fromAccountId = CleverTapAPI.fromAccountId(context, k.getAccountIdFromNotificationBundle(bundle));
        if (!CleverTapAPI.getNotificationInfo(bundle).fromCleverTap) {
            return false;
        }
        if (fromAccountId != null) {
            CleverTapInstanceConfig cleverTapInstanceConfig = fromAccountId.coreState.config;
            cleverTapInstanceConfig.logger.verbose(cleverTapInstanceConfig.getDefaultSuffix("PushProvider"), str + "received notification from CleverTap: " + bundle.toString());
            if (!isForPushTemplates(bundle) || CleverTapAPI.sNotificationHandler == null) {
                "directcall".equals(bundle.getString(DefaultSettingsSpiCall.SOURCE_PARAM));
                fromAccountId.renderPushNotification(new CoreNotificationRenderer(), context, bundle);
            } else {
                CleverTapAPI.sNotificationHandler.onMessageReceived(context, bundle, str);
            }
        } else {
            Logger.d("PushProvider", str + "received notification from CleverTap: " + bundle.toString());
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" not renderning since cleverTapAPI is null");
            Logger.d("PushProvider", sb.toString());
        }
        return true;
    }
}
