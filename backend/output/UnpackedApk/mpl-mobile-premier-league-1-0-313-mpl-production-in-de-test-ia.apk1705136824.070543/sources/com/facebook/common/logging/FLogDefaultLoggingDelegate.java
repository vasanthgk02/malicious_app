package com.facebook.common.logging;

import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.PrintWriter;
import java.io.StringWriter;

public class FLogDefaultLoggingDelegate implements LoggingDelegate {
    public static final FLogDefaultLoggingDelegate sInstance = new FLogDefaultLoggingDelegate();
    public String mApplicationTag = "unknown";
    public int mMinimumLoggingLevel = 5;

    public boolean isLoggable(int i) {
        return this.mMinimumLoggingLevel <= i;
    }

    public final String prefixTag(String str) {
        return this.mApplicationTag != null ? GeneratedOutlineSupport.outline63(new StringBuilder(), this.mApplicationTag, ":", str) : str;
    }

    public final void println(int i, String str, String str2) {
        Log.println(i, prefixTag(str), str2);
    }

    public final void println(int i, String str, String str2, Throwable th) {
        String str3;
        String prefixTag = prefixTag(str);
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(10);
        if (th == null) {
            str3 = "";
        } else {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            str3 = stringWriter.toString();
        }
        sb.append(str3);
        Log.println(i, prefixTag, sb.toString());
    }
}
