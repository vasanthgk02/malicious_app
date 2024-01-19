package com.google.android.gms.internal.p001authapi;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;

/* renamed from: com.google.android.gms.internal.auth-api.zbbc  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbbc {
    public static final int zba;

    static {
        int i = VERSION.SDK_INT;
        int i2 = 33554432;
        if (i < 31 && (i < 30 || VERSION.CODENAME.length() != 1 || VERSION.CODENAME.charAt(0) < 'S' || VERSION.CODENAME.charAt(0) > 'Z')) {
            i2 = 0;
        }
        zba = i2;
    }

    public static PendingIntent zba(Context context, int i, Intent intent, int i2) {
        return PendingIntent.getActivity(context, 2000, intent, i2);
    }
}
