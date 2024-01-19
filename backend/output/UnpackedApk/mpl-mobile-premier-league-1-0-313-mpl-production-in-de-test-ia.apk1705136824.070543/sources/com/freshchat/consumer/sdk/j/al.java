package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class al {
    public static boolean aS(Context context) {
        if (context != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        }
        throw new IllegalArgumentException("isConnected() requires a valid context");
    }
}
