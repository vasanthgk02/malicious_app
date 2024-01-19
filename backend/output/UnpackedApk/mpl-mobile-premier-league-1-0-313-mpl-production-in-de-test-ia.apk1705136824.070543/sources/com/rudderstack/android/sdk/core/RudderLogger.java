package com.rudderstack.android.sdk.core;

public class RudderLogger {
    public static final String TAG = "RudderSDK";
    public static int logLevel = 3;

    public static class RudderLogLevel {
        public static final int DEBUG = 4;
        public static final int ERROR = 1;
        public static final int INFO = 3;
        public static final int NONE = 0;
        public static final int VERBOSE = 5;
        public static final int WARN = 2;
    }

    public static void init(int i) {
        if (i > 5) {
            i = 5;
        } else if (i < 0) {
            i = 0;
        }
        logLevel = i;
    }

    public static void logDebug(String str) {
        int i = logLevel;
    }

    public static void logError(Throwable th) {
        int i = logLevel;
    }

    public static void logInfo(String str) {
        int i = logLevel;
    }

    public static void logVerbose(String str) {
        int i = logLevel;
    }

    public static void logWarn(String str) {
        int i = logLevel;
    }

    public static void logError(Exception exc) {
        logError(exc.getMessage());
    }

    public static void logError(String str) {
        int i = logLevel;
    }
}
