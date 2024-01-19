package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.FirebaseApp;
import java.util.List;

public class Metadata {
    public String appVersionCode;
    public String appVersionName;
    public final Context context;
    public int gmsVersionCode;
    public int iidImplementation = 0;

    public Metadata(Context context2) {
        this.context = context2;
    }

    public static String getDefaultSenderId(FirebaseApp firebaseApp) {
        firebaseApp.checkNotDeleted();
        String str = firebaseApp.options.gcmSenderId;
        if (str != null) {
            return str;
        }
        firebaseApp.checkNotDeleted();
        String str2 = firebaseApp.options.applicationId;
        if (!str2.startsWith("1:")) {
            return str2;
        }
        String[] split = str2.split(":");
        if (split.length < 2) {
            return null;
        }
        String str3 = split[1];
        if (str3.isEmpty()) {
            return null;
        }
        return str3;
    }

    public synchronized String getAppVersionCode() {
        try {
            if (this.appVersionCode == null) {
                populateAppVersionInfo();
            }
        }
        return this.appVersionCode;
    }

    public final PackageInfo getPackageInfo(String str) {
        try {
            return this.context.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e2) {
            "Failed to find package " + e2;
            return null;
        }
    }

    public boolean isGmscorePresent() {
        int i;
        synchronized (this) {
            if (this.iidImplementation != 0) {
                i = this.iidImplementation;
            } else {
                PackageManager packageManager = this.context.getPackageManager();
                if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
                    i = 0;
                } else {
                    if (!PlatformVersion.isAtLeastO()) {
                        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                        intent.setPackage("com.google.android.gms");
                        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
                        if (queryIntentServices != null && queryIntentServices.size() > 0) {
                            this.iidImplementation = 1;
                            i = 1;
                        }
                    }
                    Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
                    intent2.setPackage("com.google.android.gms");
                    List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
                    if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
                        if (PlatformVersion.isAtLeastO()) {
                            this.iidImplementation = 2;
                        } else {
                            this.iidImplementation = 1;
                        }
                        i = this.iidImplementation;
                    } else {
                        this.iidImplementation = 2;
                        i = 2;
                    }
                }
            }
        }
        if (i != 0) {
            return true;
        }
        return false;
    }

    public final synchronized void populateAppVersionInfo() {
        PackageInfo packageInfo = getPackageInfo(this.context.getPackageName());
        if (packageInfo != null) {
            this.appVersionCode = Integer.toString(packageInfo.versionCode);
            this.appVersionName = packageInfo.versionName;
        }
    }
}
