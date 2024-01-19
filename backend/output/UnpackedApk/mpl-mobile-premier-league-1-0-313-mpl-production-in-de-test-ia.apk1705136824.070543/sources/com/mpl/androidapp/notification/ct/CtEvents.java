package com.mpl.androidapp.notification.ct;

import android.app.Notification;
import androidx.core.app.NotificationCompat;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.netcore.android.notification.SMTNotificationConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/mpl/androidapp/notification/ct/CtEvents;", "", "()V", "logEventToClevertap", "", "json", "Lorg/json/JSONObject;", "notification", "Landroid/app/Notification;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CtEvents.kt */
public final class CtEvents {
    public static final CtEvents INSTANCE = new CtEvents();

    public final void logEventToClevertap(JSONObject jSONObject, Notification notification) {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        Intrinsics.checkNotNullParameter(notification, "notification");
        HashMap hashMap = new HashMap();
        String optString = jSONObject.optString(NotificationCompat.EXTRA_TITLE, "");
        Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"android.title\", \"\")");
        hashMap.put("title", optString);
        String optString2 = jSONObject.optString(NotificationCompat.EXTRA_TEXT, "");
        Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"android.text\", \"\")");
        hashMap.put(SMTNotificationConstants.NOTIF_BODY_KEY, optString2);
        String string = notification.extras.getString("Notification Name", "default");
        Intrinsics.checkNotNullExpressionValue(string, "notification.extras.getS…ication Name\", \"default\")");
        hashMap.put("Notification Name", string);
        String optString3 = jSONObject.optString("category", "");
        Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"category\", \"\")");
        hashMap.put("Notif Category", optString3);
        String optString4 = jSONObject.optString("subCategory", "");
        Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(\"subCategory\", \"\")");
        hashMap.put("Notif Subcategory", optString4);
        String optString5 = jSONObject.optString("actionParams", "");
        Intrinsics.checkNotNullExpressionValue(optString5, "json.optString(\"actionParams\", \"\")");
        hashMap.put("Deeplink", optString5);
        CleverTapAnalyticsUtils.sendEvent((String) "Notification added", hashMap);
    }
}
