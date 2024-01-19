package io.hansel.core.logger;

import com.android.tools.r8.GeneratedOutlineSupport;

public class HSLLogger {
    public static void d(String str) {
        boolean isEnabled = HSLLogLevel.debug.isEnabled();
    }

    public static void d(String str, LogGroup logGroup) {
        if (HSLLogLevel.mid.isEnabled()) {
            boolean isEnabled = logGroup.isEnabled();
        }
    }

    public static void e(String str) {
        boolean isEnabled = HSLLogLevel.debug.isEnabled();
    }

    public static void e(String str, HSLLogLevel hSLLogLevel) {
        boolean isEnabled = hSLLogLevel.isEnabled();
    }

    public static void i(String str) {
    }

    public static void printStackTrace(Throwable th) {
        if (th != null && HSLLogLevel.all.isEnabled()) {
            th.printStackTrace();
        }
    }

    public static void printStackTrace(Throwable th, String str, LogGroup logGroup) {
        if (th == null) {
            w(str, logGroup);
            return;
        }
        StringBuilder outline78 = GeneratedOutlineSupport.outline78(str, "  reason:  ");
        outline78.append(th.getMessage());
        w(outline78.toString(), logGroup);
        if (HSLLogLevel.all.isEnabled()) {
            th.printStackTrace();
        }
    }

    public static void printStackTraceMin(Throwable th, String str) {
        if (th == null) {
            wMin(str);
            return;
        }
        StringBuilder outline78 = GeneratedOutlineSupport.outline78(str, "  reason:  ");
        outline78.append(th.getMessage());
        wMin(outline78.toString());
        if (HSLLogLevel.all.isEnabled()) {
            th.printStackTrace();
        }
    }

    public static void w(String str, LogGroup logGroup) {
        if (HSLLogLevel.mid.isEnabled()) {
            boolean isEnabled = logGroup.isEnabled();
        }
    }

    public static void wMin(String str) {
    }
}
