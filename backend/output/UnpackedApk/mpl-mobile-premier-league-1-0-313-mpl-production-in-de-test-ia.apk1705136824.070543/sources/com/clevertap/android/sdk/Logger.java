package com.clevertap.android.sdk;

import com.clevertap.android.sdk.CleverTapAPI.LogLevel;
import okhttp3.internal.platform.android.AndroidLog;

public final class Logger {
    public int debugLevel;

    public Logger(int i) {
        this.debugLevel = i;
    }

    public static void d(String str) {
        int i = CleverTapAPI.debugLevel;
        int intValue = LogLevel.INFO.intValue();
    }

    public static void i(String str) {
        int i = CleverTapAPI.debugLevel;
        int intValue = LogLevel.INFO.intValue();
    }

    public static void v(String str) {
        int i = CleverTapAPI.debugLevel;
        int intValue = LogLevel.DEBUG.intValue();
    }

    public void debug(String str) {
        int i = CleverTapAPI.debugLevel;
        int intValue = LogLevel.INFO.intValue();
    }

    public void info(String str) {
        LogLevel.INFO.intValue();
    }

    public void verbose(String str) {
        int i = CleverTapAPI.debugLevel;
        int intValue = LogLevel.DEBUG.intValue();
    }

    public void info(String str, String str2) {
        LogLevel.INFO.intValue();
    }

    public static void d(String str, String str2) {
        int i = CleverTapAPI.debugLevel;
        int intValue = LogLevel.INFO.intValue();
    }

    public static void v(String str, String str2) {
        int i = CleverTapAPI.debugLevel;
        int intValue = LogLevel.DEBUG.intValue();
    }

    public void debug(String str, String str2) {
        if (CleverTapAPI.debugLevel > LogLevel.INFO.intValue() && str2.length() > 4000) {
            str2.substring(0, AndroidLog.MAX_LOG_LENGTH);
            debug(str, str2.substring(AndroidLog.MAX_LOG_LENGTH));
        }
    }

    public void verbose(String str, String str2) {
        if (CleverTapAPI.debugLevel > LogLevel.DEBUG.intValue() && str2.length() > 4000) {
            str2.substring(0, AndroidLog.MAX_LOG_LENGTH);
            verbose(str, str2.substring(AndroidLog.MAX_LOG_LENGTH));
        }
    }

    public static void d(String str, String str2, Throwable th) {
        int i = CleverTapAPI.debugLevel;
        int intValue = LogLevel.INFO.intValue();
    }

    public static void v(String str, Throwable th) {
        int i = CleverTapAPI.debugLevel;
        int intValue = LogLevel.DEBUG.intValue();
    }

    public void debug(String str, String str2, Throwable th) {
        int i = CleverTapAPI.debugLevel;
        int intValue = LogLevel.INFO.intValue();
    }

    public void verbose(String str, String str2, Throwable th) {
        int i = CleverTapAPI.debugLevel;
        int intValue = LogLevel.DEBUG.intValue();
    }

    public void verbose(String str, Throwable th) {
        int i = CleverTapAPI.debugLevel;
        int intValue = LogLevel.DEBUG.intValue();
    }
}
