package com.airbnb.lottie.utils;

import com.airbnb.lottie.LottieLogger;

public class Logger {
    public static LottieLogger INSTANCE = new LogcatLogger();

    public static void debug(String str) {
        if (((LogcatLogger) INSTANCE) == null) {
            throw null;
        }
    }

    public static void warning(String str) {
        if (((LogcatLogger) INSTANCE) == null) {
            throw null;
        } else if (!LogcatLogger.loggedMessages.contains(str)) {
            LogcatLogger.loggedMessages.add(str);
        }
    }

    public static void warning(String str, Throwable th) {
        if (((LogcatLogger) INSTANCE) == null) {
            throw null;
        } else if (!LogcatLogger.loggedMessages.contains(str)) {
            LogcatLogger.loggedMessages.add(str);
        }
    }
}
