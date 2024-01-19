package com.appsflyer.internal;

import android.content.Context;
import android.os.Build.VERSION;

public final class cf {
    public static boolean values(Context context) {
        if (VERSION.SDK_INT >= 26) {
            return context.getPackageManager().isInstantApp();
        }
        try {
            context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
