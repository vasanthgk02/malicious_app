package com.google.android.gms.internal.base;

import android.os.Build.VERSION;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zan {
    public static boolean zaa() {
        return VERSION.SDK_INT >= 33 || VERSION.CODENAME.charAt(0) == 'T';
    }
}
