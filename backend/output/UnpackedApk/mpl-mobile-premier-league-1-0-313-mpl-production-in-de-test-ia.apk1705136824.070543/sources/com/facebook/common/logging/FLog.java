package com.facebook.common.logging;

public class FLog {
    public static LoggingDelegate sHandler = FLogDefaultLoggingDelegate.sInstance;

    public static void d(String str, String str2) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(3)) {
            ((FLogDefaultLoggingDelegate) sHandler).println(3, str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(6)) {
            ((FLogDefaultLoggingDelegate) sHandler).println(6, str, str2);
        }
    }

    public static String formatString(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    public static boolean isLoggable(int i) {
        return ((FLogDefaultLoggingDelegate) sHandler).mMinimumLoggingLevel <= i;
    }

    public static void v(String str, String str2, Object obj, Object obj2) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(2)) {
            FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = (FLogDefaultLoggingDelegate) sHandler;
            fLogDefaultLoggingDelegate.println(2, str, formatString(str2, obj, obj2));
        }
    }

    public static void w(String str, String str2) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(5)) {
            ((FLogDefaultLoggingDelegate) sHandler).println(5, str, str2);
        }
    }

    public static void wtf(String str, String str2, Object... objArr) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(6)) {
            ((FLogDefaultLoggingDelegate) sHandler).println(6, str, formatString(str2, objArr));
        }
    }

    public static void d(String str, String str2, Object obj) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(3)) {
            FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = (FLogDefaultLoggingDelegate) sHandler;
            fLogDefaultLoggingDelegate.println(3, str, formatString(str2, obj));
        }
    }

    public static void e(Class<?> cls, String str) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(6)) {
            ((FLogDefaultLoggingDelegate) sHandler).println(6, cls.getSimpleName(), str);
        }
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(2)) {
            FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = (FLogDefaultLoggingDelegate) sHandler;
            fLogDefaultLoggingDelegate.println(2, str, formatString(str2, obj, obj2, obj3));
        }
    }

    public static void w(Class<?> cls, String str) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(5)) {
            ((FLogDefaultLoggingDelegate) sHandler).println(5, cls.getSimpleName(), str);
        }
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(2)) {
            FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = (FLogDefaultLoggingDelegate) sHandler;
            fLogDefaultLoggingDelegate.println(2, str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(6)) {
            ((FLogDefaultLoggingDelegate) sHandler).println(6, str, formatString(str2, objArr));
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(5)) {
            ((FLogDefaultLoggingDelegate) sHandler).println(5, str, formatString(str2, objArr));
        }
    }

    public static void v(Class<?> cls, String str) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(2)) {
            ((FLogDefaultLoggingDelegate) sHandler).println(2, cls.getSimpleName(), str);
        }
    }

    public static void e(Class<?> cls, String str, Object... objArr) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(6)) {
            ((FLogDefaultLoggingDelegate) sHandler).println(6, cls.getSimpleName(), formatString(str, objArr));
        }
    }

    public static void w(Class<?> cls, String str, Object... objArr) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(5)) {
            ((FLogDefaultLoggingDelegate) sHandler).println(5, cls.getSimpleName(), formatString(str, objArr));
        }
    }

    public static void v(Class<?> cls, String str, Object obj) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(2)) {
            LoggingDelegate loggingDelegate = sHandler;
            FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = (FLogDefaultLoggingDelegate) loggingDelegate;
            fLogDefaultLoggingDelegate.println(2, cls.getSimpleName(), formatString(str, obj));
        }
    }

    public static void e(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(6)) {
            ((FLogDefaultLoggingDelegate) sHandler).println(6, cls.getSimpleName(), formatString(str, objArr), th);
        }
    }

    public static void w(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            w(cls, formatString(str, objArr), th);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(5)) {
            ((FLogDefaultLoggingDelegate) sHandler).println(5, str, str2, th);
        }
    }

    public static void v(Class<?> cls, String str, Object obj, Object obj2) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(2)) {
            LoggingDelegate loggingDelegate = sHandler;
            FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = (FLogDefaultLoggingDelegate) loggingDelegate;
            fLogDefaultLoggingDelegate.println(2, cls.getSimpleName(), formatString(str, obj, obj2));
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(6)) {
            ((FLogDefaultLoggingDelegate) sHandler).println(6, str, str2, th);
        }
    }

    public static void w(Class<?> cls, String str, Throwable th) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(5)) {
            ((FLogDefaultLoggingDelegate) sHandler).println(5, cls.getSimpleName(), str, th);
        }
    }

    public static void e(Class<?> cls, String str, Throwable th) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(6)) {
            ((FLogDefaultLoggingDelegate) sHandler).println(6, cls.getSimpleName(), str, th);
        }
    }

    public static void v(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            v(cls, formatString(str, obj, obj2, obj3));
        }
    }

    public static void v(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(2)) {
            LoggingDelegate loggingDelegate = sHandler;
            FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = (FLogDefaultLoggingDelegate) loggingDelegate;
            fLogDefaultLoggingDelegate.println(2, cls.getSimpleName(), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (((FLogDefaultLoggingDelegate) sHandler).isLoggable(2)) {
            ((FLogDefaultLoggingDelegate) sHandler).println(2, str, formatString(str2, objArr));
        }
    }
}
