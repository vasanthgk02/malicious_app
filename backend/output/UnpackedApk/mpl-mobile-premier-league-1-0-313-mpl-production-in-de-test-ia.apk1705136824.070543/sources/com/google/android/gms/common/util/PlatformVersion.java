package com.google.android.gms.common.util;

import android.os.Build.VERSION;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class PlatformVersion {
    @KeepForSdk
    public static boolean isAtLeastO() {
        return VERSION.SDK_INT >= 26;
    }

    @KeepForSdk
    public static boolean isAtLeastP() {
        return VERSION.SDK_INT >= 28;
    }
}
