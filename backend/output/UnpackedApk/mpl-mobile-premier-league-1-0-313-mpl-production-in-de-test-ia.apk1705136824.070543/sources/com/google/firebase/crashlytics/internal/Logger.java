package com.google.firebase.crashlytics.internal;

import android.util.Log;

public class Logger {
    public static final Logger DEFAULT_LOGGER = new Logger(TAG);
    public static final String TAG = "FirebaseCrashlytics";
    public int logLevel = 4;
    public final String tag;

    public Logger(String str) {
        this.tag = str;
    }

    private boolean canLog(int i) {
        return this.logLevel <= i || Log.isLoggable(this.tag, i);
    }

    public static Logger getLogger() {
        return DEFAULT_LOGGER;
    }

    public void d(String str, Throwable th) {
        boolean canLog = canLog(3);
    }

    public void e(String str, Throwable th) {
        boolean canLog = canLog(6);
    }

    public void i(String str, Throwable th) {
        boolean canLog = canLog(4);
    }

    public void log(int i, String str) {
        log(i, str, false);
    }

    public void v(String str, Throwable th) {
        boolean canLog = canLog(2);
    }

    public void w(String str, Throwable th) {
        boolean canLog = canLog(5);
    }

    public void d(String str) {
        d(str, null);
    }

    public void e(String str) {
        e(str, null);
    }

    public void i(String str) {
        i(str, null);
    }

    public void log(int i, String str, boolean z) {
        if (z || canLog(i)) {
            Log.println(i, this.tag, str);
        }
    }

    public void v(String str) {
        v(str, null);
    }

    public void w(String str) {
        w(str, null);
    }
}
