package com.userexperior.e;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Locale;

public class z {

    /* renamed from: a  reason: collision with root package name */
    public static String f4033a = "Volley";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f4034b;

    public static void a(String str, Object... objArr) {
        if (f4034b) {
            d(str, objArr);
        }
    }

    public static void a(Throwable th, String str, Object... objArr) {
        d(str, objArr);
    }

    public static void b(String str, Object... objArr) {
        d(str, objArr);
    }

    public static void c(String str, Object... objArr) {
        d(str, objArr);
    }

    public static String d(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClass().equals(z.class)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                StringBuilder outline78 = GeneratedOutlineSupport.outline78(substring.substring(substring.lastIndexOf(36) + 1), ".");
                outline78.append(stackTrace[i].getMethodName());
                str2 = outline78.toString();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }
}
