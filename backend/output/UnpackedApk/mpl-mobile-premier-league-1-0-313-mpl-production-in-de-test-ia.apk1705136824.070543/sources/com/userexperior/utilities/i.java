package com.userexperior.utilities;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4282a = "i";

    /* renamed from: b  reason: collision with root package name */
    public static i f4283b;

    public static i a() {
        if (f4283b == null) {
            synchronized (i.class) {
                try {
                    if (f4283b == null) {
                        f4283b = new i();
                    }
                }
            }
        }
        return f4283b;
    }

    public static boolean b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) a.a().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }
}
