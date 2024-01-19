package io.hansel.ujmtracker.m;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class b {
    public static NetworkInfo a(Context context) {
        if (b(context)) {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        }
        return null;
    }

    public static boolean b(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0;
    }
}
