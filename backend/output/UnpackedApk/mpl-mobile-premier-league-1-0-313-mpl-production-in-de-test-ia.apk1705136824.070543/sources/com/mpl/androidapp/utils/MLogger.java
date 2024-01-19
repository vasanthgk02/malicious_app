package com.mpl.androidapp.utils;

import android.content.Context;
import com.mpl.MLog;

public class MLogger {
    public static final String TAG = "MLogger";

    public static void d(String str, Object... objArr) {
        MTimber.d(str, objArr);
    }

    public static void e(String str, Object... objArr) {
        MTimber.e(str, objArr);
    }

    public static void i(String str, Object... objArr) {
        MTimber.i(str, objArr);
    }

    public static void printStackTrace(Throwable th) {
        MTimber.printStackTrace(th);
    }

    public static void setIsLogEnabled(boolean z) {
        MLog.setIsLogEnabled(z);
    }

    public static void t(Context context, int i, Object... objArr) {
        MTimber.t(context, i, objArr);
    }

    public static void v(String str, Object... objArr) {
        MTimber.v(str, objArr);
    }

    public static void w(String str, Object... objArr) {
        MTimber.w(str, objArr);
    }
}
