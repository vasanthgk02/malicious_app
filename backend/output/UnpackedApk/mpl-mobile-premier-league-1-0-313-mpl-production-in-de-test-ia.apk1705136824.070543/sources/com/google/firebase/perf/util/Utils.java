package com.google.firebase.perf.util;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.perf.logging.AndroidLogger;

public class Utils {
    public static Boolean isDebugLoggingEnabled;

    public static boolean isDebugLoggingEnabled(Context context) {
        Boolean bool = isDebugLoggingEnabled;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean valueOf = Boolean.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("firebase_performance_logcat_enabled", false));
            isDebugLoggingEnabled = valueOf;
            return valueOf.booleanValue();
        } catch (NameNotFoundException | NullPointerException e2) {
            AndroidLogger instance = AndroidLogger.getInstance();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("No perf logcat meta data found ");
            outline73.append(e2.getMessage());
            instance.debug(outline73.toString());
            return false;
        }
    }

    public static int saturatedIntCast(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return j < -2147483648L ? LinearLayoutManager.INVALID_OFFSET : (int) j;
    }
}
