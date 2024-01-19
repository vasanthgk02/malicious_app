package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.netcore.android.notification.SMTNotificationConstants;

public final class a {
    public IntentFilter valueOf = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: com.appsflyer.internal.a$a  reason: collision with other inner class name */
    public static final class C0062a {
        public static final a valueOf = new a();
    }

    public static final class d {
        public final float AFInAppEventType;
        public final String AFKeystoreWrapper;

        public d(float f2, String str) {
            this.AFInAppEventType = f2;
            this.AFKeystoreWrapper = str;
        }
    }

    public final d values(Context context) {
        String str = null;
        float f2 = 0.0f;
        try {
            Intent registerReceiver = context.registerReceiver(null, this.valueOf);
            if (registerReceiver != null) {
                if (2 == registerReceiver.getIntExtra("status", -1)) {
                    int intExtra = registerReceiver.getIntExtra("plugged", -1);
                    str = intExtra != 1 ? intExtra != 2 ? intExtra != 4 ? SMTNotificationConstants.NOTIF_ATTRIBUTION_OTHER : "wireless" : "usb" : "ac";
                } else {
                    str = "no";
                }
                int intExtra2 = registerReceiver.getIntExtra("level", -1);
                int intExtra3 = registerReceiver.getIntExtra("scale", -1);
                if (!(-1 == intExtra2 || -1 == intExtra3)) {
                    f2 = (((float) intExtra2) * 100.0f) / ((float) intExtra3);
                }
            }
        } catch (Throwable unused) {
        }
        return new d(f2, str);
    }
}
