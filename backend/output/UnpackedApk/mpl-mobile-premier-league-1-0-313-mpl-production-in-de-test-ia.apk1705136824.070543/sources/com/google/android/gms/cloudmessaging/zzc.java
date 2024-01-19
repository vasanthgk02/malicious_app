package com.google.android.gms.cloudmessaging;

import android.os.Build.VERSION;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
public final class zzc extends ClassLoader {
    public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        if (!"com.google.android.gms.iid.MessengerCompat".equals(str)) {
            return super.loadClass(str, z);
        }
        if (!Log.isLoggable("CloudMessengerCompat", 3) && VERSION.SDK_INT == 23) {
            boolean isLoggable = Log.isLoggable("CloudMessengerCompat", 3);
        }
        return zzd.class;
    }
}
