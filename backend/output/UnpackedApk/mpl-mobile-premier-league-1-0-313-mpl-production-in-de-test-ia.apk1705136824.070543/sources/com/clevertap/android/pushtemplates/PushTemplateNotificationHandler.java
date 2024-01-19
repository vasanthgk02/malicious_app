package com.clevertap.android.pushtemplates;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import co.hyperverge.hypersnapsdk.c.k;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.interfaces.ActionButtonClickHandler;
import java.util.HashMap;
import java.util.Objects;
import org.apache.pdfbox.pdfparser.BaseParser;

public class PushTemplateNotificationHandler implements ActionButtonClickHandler {
    public boolean onActionButtonClick(Context context, Bundle bundle, int i) {
        CleverTapAPI cleverTapAPI;
        String string = bundle.getString("actionId");
        String string2 = bundle.getString("pt_dismiss_on_click");
        CleverTapInstanceConfig cleverTapInstanceConfig = (CleverTapInstanceConfig) bundle.getParcelable("config");
        if (string2 == null || !string2.equalsIgnoreCase(BaseParser.TRUE)) {
            return false;
        }
        if (string != null && string.contains("remind")) {
            if (cleverTapInstanceConfig != null) {
                cleverTapAPI = CleverTapAPI.instanceWithConfig(context, cleverTapInstanceConfig);
            } else {
                cleverTapAPI = CleverTapAPI.getDefaultInstance(context);
            }
            HashMap hashMap = new HashMap();
            for (String str : bundle.keySet()) {
                if (str.contains("pt_event_property")) {
                    if (bundle.getString(str) == null || bundle.getString(str).isEmpty()) {
                        k.verbose("Property Key is Empty. Skipping Property: " + str);
                    } else if (str.contains("pt_event_property_")) {
                        hashMap.put(str.split("pt_event_property_")[1], bundle.getString(str));
                    } else {
                        k.verbose("Property " + str + " does not have the separator");
                    }
                }
            }
            String eventNameFromExtras = k.getEventNameFromExtras(bundle);
            if (eventNameFromExtras != null && !eventNameFromExtras.isEmpty()) {
                if (cleverTapAPI != null) {
                    cleverTapAPI.pushEvent(eventNameFromExtras, hashMap);
                } else {
                    k.debug("CleverTap instance is NULL, not raising the event");
                }
            }
        }
        ((NotificationManager) context.getSystemService("notification")).cancel(i);
        return true;
    }

    public boolean onMessageReceived(Context context, Bundle bundle, String str) {
        try {
            k.debug("Inside Push Templates");
            ((CleverTapAPI) Objects.requireNonNull(CleverTapAPI.fromAccountId(context, k.getAccountIdFromNotificationBundle(bundle)))).renderPushNotification(new TemplateRenderer(context, bundle), context, bundle);
        } catch (Throwable th) {
            k.verbose("Error parsing FCM payload", th);
        }
        return true;
    }
}
