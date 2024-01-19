package io.hansel.actions.configs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import io.hansel.actions.HSLConfigDataType;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.logger.HSLLogger;

public class j {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5073a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
        static {
            /*
                io.hansel.actions.HSLConfigDataType[] r0 = io.hansel.actions.HSLConfigDataType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5073a = r0
                io.hansel.actions.HSLConfigDataType r1 = io.hansel.actions.HSLConfigDataType.num     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r0 = 2
                int[] r1 = f5073a     // Catch:{ NoSuchFieldError -> 0x0016 }
                io.hansel.actions.HSLConfigDataType r2 = io.hansel.actions.HSLConfigDataType.bool     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 0
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = f5073a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.hansel.actions.HSLConfigDataType r3 = io.hansel.actions.HSLConfigDataType.str     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5073a     // Catch:{ NoSuchFieldError -> 0x0024 }
                io.hansel.actions.HSLConfigDataType r2 = io.hansel.actions.HSLConfigDataType.json     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.actions.configs.j.a.<clinit>():void");
        }
    }

    public static Boolean a(Context context, String str, String str2) {
        SharedPreferences defaultSharedPreferences = HSLInternalUtils.isEmpty(str) ? PreferenceManager.getDefaultSharedPreferences(context) : context.getSharedPreferences(str, 0);
        if (defaultSharedPreferences.contains(str2)) {
            return Boolean.valueOf(defaultSharedPreferences.getBoolean(str2, false));
        }
        return null;
    }

    public static Object a(Context context, String str, String str2, Object obj, HSLConfigDataType hSLConfigDataType) {
        if (hSLConfigDataType != null) {
            try {
                int i = a.f5073a[hSLConfigDataType.ordinal()];
                if (i == 1) {
                    return b(context, str, str2);
                }
                if (i == 2) {
                    return a(context, str, str2);
                }
                if (i == 3) {
                    return c(context, str, str2);
                }
                if (i == 4) {
                    return c(context, str, str2);
                }
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return obj;
    }

    public static Double b(Context context, String str, String str2) {
        SharedPreferences defaultSharedPreferences = HSLInternalUtils.isEmpty(str) ? PreferenceManager.getDefaultSharedPreferences(context) : context.getSharedPreferences(str, 0);
        if (defaultSharedPreferences.contains(str2)) {
            return Double.valueOf((double) defaultSharedPreferences.getFloat(str2, 0.0f));
        }
        return null;
    }

    public static String c(Context context, String str, String str2) {
        SharedPreferences defaultSharedPreferences = HSLInternalUtils.isEmpty(str) ? PreferenceManager.getDefaultSharedPreferences(context) : context.getSharedPreferences(str, 0);
        if (defaultSharedPreferences.contains(str2)) {
            return defaultSharedPreferences.getString(str2, null);
        }
        return null;
    }
}
