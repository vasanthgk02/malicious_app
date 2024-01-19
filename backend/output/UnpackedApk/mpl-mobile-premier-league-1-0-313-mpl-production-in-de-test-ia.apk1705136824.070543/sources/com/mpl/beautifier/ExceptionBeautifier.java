package com.mpl.beautifier;

import android.util.Log;

public final class ExceptionBeautifier implements MLogBeautifier {
    public static ExceptionBeautifier INSTANCE;

    public static ExceptionBeautifier getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ExceptionBeautifier();
        }
        return INSTANCE;
    }

    public String beautify(Object obj) {
        Throwable th = (Throwable) obj;
        return String.format("\n%s\n%s\n", new Object[]{th.getMessage(), Log.getStackTraceString(th)});
    }

    public Class getType() {
        return Throwable.class;
    }
}
