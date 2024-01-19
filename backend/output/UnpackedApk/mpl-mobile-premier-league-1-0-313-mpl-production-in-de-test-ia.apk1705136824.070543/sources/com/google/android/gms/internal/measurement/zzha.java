package com.google.android.gms.internal.measurement;

import android.os.Build.VERSION;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzha {
    public static volatile boolean zza = (!zza());

    public static boolean zza() {
        return VERSION.SDK_INT >= 24;
    }
}
