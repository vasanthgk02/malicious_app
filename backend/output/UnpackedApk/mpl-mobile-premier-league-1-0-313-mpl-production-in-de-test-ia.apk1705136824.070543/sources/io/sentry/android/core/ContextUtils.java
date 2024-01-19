package io.sentry.android.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import io.sentry.ILogger;
import io.sentry.SentryLevel;

public final class ContextUtils {
    public static PackageInfo getPackageInfo(Context context, ILogger iLogger) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (Exception e2) {
            iLogger.log(SentryLevel.ERROR, (String) "Error getting package info.", (Throwable) e2);
            return null;
        }
    }

    public static String getVersionCode(PackageInfo packageInfo) {
        if (VERSION.SDK_INT >= 28) {
            return Long.toString(packageInfo.getLongVersionCode());
        }
        return getVersionCodeDep(packageInfo);
    }

    public static String getVersionCodeDep(PackageInfo packageInfo) {
        return Integer.toString(packageInfo.versionCode);
    }
}
