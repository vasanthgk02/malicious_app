package com.google.firebase.perf.logging;

import java.util.Locale;

public class AndroidLogger {
    public static volatile AndroidLogger instance;
    public boolean isLogcatEnabled = false;
    public final LogWrapper logWrapper;

    public AndroidLogger() {
        LogWrapper logWrapper2;
        synchronized (LogWrapper.class) {
            if (LogWrapper.instance == null) {
                LogWrapper.instance = new LogWrapper();
            }
            logWrapper2 = LogWrapper.instance;
        }
        this.logWrapper = logWrapper2;
    }

    public static AndroidLogger getInstance() {
        if (instance == null) {
            synchronized (AndroidLogger.class) {
                try {
                    if (instance == null) {
                        instance = new AndroidLogger();
                    }
                }
            }
        }
        return instance;
    }

    public void debug(String str) {
        if (this.isLogcatEnabled && this.logWrapper == null) {
            throw null;
        }
    }

    public void error(String str, Object... objArr) {
        if (this.isLogcatEnabled) {
            LogWrapper logWrapper2 = this.logWrapper;
            String.format(Locale.ENGLISH, str, objArr);
            if (logWrapper2 == null) {
                throw null;
            }
        }
    }

    public void info(String str, Object... objArr) {
        if (this.isLogcatEnabled) {
            LogWrapper logWrapper2 = this.logWrapper;
            String.format(Locale.ENGLISH, str, objArr);
            if (logWrapper2 == null) {
                throw null;
            }
        }
    }

    public void warn(String str) {
        if (this.isLogcatEnabled && this.logWrapper == null) {
            throw null;
        }
    }

    public void debug(String str, Object... objArr) {
        if (this.isLogcatEnabled) {
            LogWrapper logWrapper2 = this.logWrapper;
            String.format(Locale.ENGLISH, str, objArr);
            if (logWrapper2 == null) {
                throw null;
            }
        }
    }

    public void warn(String str, Object... objArr) {
        if (this.isLogcatEnabled) {
            LogWrapper logWrapper2 = this.logWrapper;
            String.format(Locale.ENGLISH, str, objArr);
            if (logWrapper2 == null) {
                throw null;
            }
        }
    }
}
