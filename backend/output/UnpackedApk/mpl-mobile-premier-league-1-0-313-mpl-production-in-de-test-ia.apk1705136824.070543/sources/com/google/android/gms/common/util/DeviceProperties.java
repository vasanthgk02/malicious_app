package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class DeviceProperties {
    public static Boolean zzd;
    public static Boolean zze;
    public static Boolean zzg;
    public static Boolean zzi;

    @TargetApi(20)
    @KeepForSdk
    public static boolean isWearable(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (zzd == null) {
            zzd = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return zzd.booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        if ((android.os.Build.VERSION.SDK_INT >= 24) != false) goto L_0x0013;
     */
    @android.annotation.TargetApi(26)
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isWearableWithoutPlayStore(android.content.Context r4) {
        /*
            boolean r0 = isWearable(r4)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0013
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r0 < r3) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            if (r0 == 0) goto L_0x002a
        L_0x0013:
            boolean r4 = zza(r4)
            if (r4 == 0) goto L_0x002b
            boolean r4 = com.google.android.gms.common.util.PlatformVersion.isAtLeastO()
            if (r4 == 0) goto L_0x002a
            int r4 = android.os.Build.VERSION.SDK_INT
            r0 = 30
            if (r4 < r0) goto L_0x0027
            r4 = 1
            goto L_0x0028
        L_0x0027:
            r4 = 0
        L_0x0028:
            if (r4 == 0) goto L_0x002b
        L_0x002a:
            return r2
        L_0x002b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.DeviceProperties.isWearableWithoutPlayStore(android.content.Context):boolean");
    }

    @TargetApi(21)
    public static boolean zza(Context context) {
        if (zze == null) {
            zze = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return zze.booleanValue();
    }
}
