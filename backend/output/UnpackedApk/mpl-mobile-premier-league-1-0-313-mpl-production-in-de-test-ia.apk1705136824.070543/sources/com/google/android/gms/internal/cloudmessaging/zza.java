package com.google.android.gms.internal.cloudmessaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
public final class zza {
    public static final int zza;

    static {
        int i = VERSION.SDK_INT;
        int i2 = 33554432;
        if (i < 31 && (i < 30 || VERSION.CODENAME.length() != 1 || VERSION.CODENAME.charAt(0) < 'S' || VERSION.CODENAME.charAt(0) > 'Z')) {
            i2 = 0;
        }
        zza = i2;
    }

    public static PendingIntent zza(Context context, int i, Intent intent, int i2) {
        return PendingIntent.getBroadcast(context, 0, intent, i2);
    }
}
