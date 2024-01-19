package com.mpl;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.beautifier.BundleBeautifier;
import com.mpl.beautifier.ExceptionBeautifier;
import com.mpl.beautifier.MLogBeautifier;
import java.util.HashMap;
import java.util.Map;

public final class MLog {
    public static Map<Class, MLogBeautifier> BEAUTIFIERS = new HashMap();
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static int LOG_LEVEL = 2;
    public static final Object SENSITIVE = new Object();
    public static String TAG = "MLog";
    public static final int VERBOSE = 2;
    public static final int WARNING = 5;
    public static boolean isLogEnabled;

    static {
        registerBeautifier(BundleBeautifier.getInstance());
        registerBeautifier(ExceptionBeautifier.getInstance());
    }

    public static void d(String str, Object... objArr) {
        log(3, str, objArr);
    }

    public static void e(String str, Object... objArr) {
        log(6, str, objArr);
    }

    public static void i(String str, Object... objArr) {
        log(4, str, objArr);
    }

    public static void log(int i, String str, Object... objArr) {
        if (isLogEnabled && i >= LOG_LEVEL) {
            String outline62 = GeneratedOutlineSupport.outline62(new StringBuilder(), TAG == null ? "" : GeneratedOutlineSupport.outline62(new StringBuilder(), TAG, "/"), str);
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            for (Object obj : objArr) {
                if (z) {
                    sb.append("{XXXXXXXXXX} ");
                    z = false;
                } else if (obj == null) {
                    sb.append("NULL ");
                } else if (obj == SENSITIVE) {
                    z = true;
                } else if (BEAUTIFIERS.containsKey(obj.getClass())) {
                    try {
                        sb.append(BEAUTIFIERS.get(obj.getClass()).beautify(obj));
                        sb.append(' ');
                    } catch (Exception e2) {
                        sb.append("Unhandled exception in beautifier ");
                        sb.append(e2.getMessage());
                        sb.append(' ');
                    }
                } else {
                    sb.append(obj);
                    sb.append(' ');
                }
            }
            sb.setLength(Math.max(sb.length() - 1, 0));
            Log.println(i, outline62, sb.toString());
        }
    }

    public static void registerBeautifier(MLogBeautifier mLogBeautifier) {
        BEAUTIFIERS.put(mLogBeautifier.getType(), mLogBeautifier);
    }

    public static void setBaseTag(String str) {
        TAG = str;
    }

    public static void setIsLogEnabled(boolean z) {
        isLogEnabled = z;
    }

    public static void setLogLevel(int i) {
        LOG_LEVEL = i;
    }

    public static void t(Context context, int i, Object... objArr) {
        if (i < 0) {
            i = 0;
        }
        if (i > 1) {
            i = 1;
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj == null) {
                sb.append("NULL ");
            } else {
                sb.append(obj);
                sb.append(' ');
            }
        }
        if (isLogEnabled) {
            Toast.makeText(context, sb.toString(), i).show();
        }
    }

    public static void v(String str, Object... objArr) {
        log(2, str, objArr);
    }

    public static void w(String str, Object... objArr) {
        log(5, str, objArr);
    }
}
