package com.appsflyer;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.appsflyer.internal.ac;
import com.appsflyer.internal.ak;
import com.appsflyer.internal.ay;
import com.smartfoxserver.v2.protocol.serialization.DefaultSFSDataSerializer;
import org.apache.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;

public final class AFLogger {
    public static final long AFInAppEventType = System.currentTimeMillis();

    public enum LogLevel {
        NONE(0),
        ERROR(1),
        WARNING(2),
        INFO(3),
        DEBUG(4),
        VERBOSE(5);
        
        public int AFInAppEventParameterName;

        /* access modifiers changed from: public */
        LogLevel(int i) {
            this.AFInAppEventParameterName = i;
        }

        public final int getLevel() {
            return this.AFInAppEventParameterName;
        }
    }

    public static String AFInAppEventParameterName(String str, boolean z) {
        if (str == null) {
            str = "null";
        }
        if (!z && LogLevel.VERBOSE.getLevel() > AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            return str;
        }
        StringBuilder sb = new StringBuilder("(");
        sb.append(System.currentTimeMillis() - AFInAppEventType);
        sb.append(") [");
        sb.append(Thread.currentThread().getName());
        sb.append("] ");
        sb.append(str);
        return sb.toString();
    }

    public static void AFInAppEventType(String str) {
        if (!AFInAppEventParameterName()) {
            AFInAppEventParameterName(str, false);
        }
        ak.AFInAppEventType().AFInAppEventParameterName((String) PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION, str);
    }

    public static void AFKeystoreWrapper(String str) {
        if (valueOf(LogLevel.VERBOSE)) {
            AFInAppEventParameterName(str, false);
        }
        ak.AFInAppEventType().AFInAppEventParameterName((String) DefaultSFSDataSerializer.FIELD_VALUE_KEY, AFInAppEventParameterName(str, true));
    }

    public static void AppsFlyer2dXConversionCallback(String str) {
        valueOf(str);
    }

    public static void valueOf(String str) {
        if (valueOf(LogLevel.WARNING)) {
            AFInAppEventParameterName(str, false);
        }
        ak.AFInAppEventType().AFInAppEventParameterName((String) "W", AFInAppEventParameterName(str, true));
    }

    public static void values(String str, boolean z) {
        if (valueOf(LogLevel.INFO)) {
            AFInAppEventParameterName(str, false);
        }
        if (z) {
            ak.AFInAppEventType().AFInAppEventParameterName((String) "I", AFInAppEventParameterName(str, true));
        }
    }

    public static boolean valueOf(LogLevel logLevel) {
        return logLevel.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel());
    }

    public static void values(String str) {
        values(str, true);
    }

    public static void AFInAppEventParameterName(String str, Throwable th, boolean z, boolean z2) {
        long j;
        if (valueOf(LogLevel.ERROR)) {
            if (str == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(th.getClass().getSimpleName());
                sb.append(" at ");
                sb.append(th.getStackTrace()[0].toString());
                str = sb.toString();
            }
            AFInAppEventParameterName(str, false);
        }
        ak.AFInAppEventType().valueOf(th);
        Application application = ay.AFInAppEventParameterName;
        if (application != null) {
            Editor edit = ac.AFInAppEventType((Context) application).edit();
            Application application2 = ay.AFInAppEventParameterName;
            if (application2 == null) {
                j = -1;
            } else {
                j = ac.AFInAppEventType((Context) application2).getLong("exception_number", 0);
            }
            edit.putLong("exception_number", j + 1).apply();
        }
    }

    public static void values(Throwable th) {
        AFInAppEventParameterName(null, th, false, false);
    }

    public static void valueOf(String str, Throwable th) {
        AFInAppEventParameterName(str, th, true, false);
    }

    public static boolean AFInAppEventParameterName() {
        return AppsFlyerProperties.getInstance().isLogsDisabledCompletely();
    }

    public static void AFInAppEventParameterName(String str, Throwable th) {
        AFInAppEventParameterName(str, th, true, true);
    }

    public static void AFInAppEventParameterName(String str) {
        if (valueOf(LogLevel.DEBUG)) {
            AFInAppEventParameterName(str, false);
        }
        ak.AFInAppEventType().AFInAppEventParameterName((String) "D", AFInAppEventParameterName(str, true));
    }
}
