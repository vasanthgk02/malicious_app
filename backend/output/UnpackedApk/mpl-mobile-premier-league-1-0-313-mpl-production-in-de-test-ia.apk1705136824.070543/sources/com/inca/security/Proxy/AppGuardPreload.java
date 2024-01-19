package com.inca.security.Proxy;

import android.app.ZygotePreload;
import android.content.pm.ApplicationInfo;

public class AppGuardPreload implements ZygotePreload {
    public void doPreload(ApplicationInfo applicationInfo) {
        try {
            System.loadLibrary("compatible");
        } catch (UnsatisfiedLinkError unused) {
        }
    }
}
