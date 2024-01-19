package com.appsflyer.internal;

import android.content.SharedPreferences;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.appsflyer.AFLogger;

public final class bc implements bv {
    public final SharedPreferences valueOf;

    public bc(SharedPreferences sharedPreferences) {
        this.valueOf = sharedPreferences;
    }

    public final void AFInAppEventParameterName(String str, String str2) {
        this.valueOf.edit().putString(str, str2).apply();
    }

    public final String AFInAppEventType(String str, String str2) {
        try {
            return this.valueOf.getString(str, str2);
        } catch (ClassCastException e2) {
            AFLogger.valueOf("Unexpected data type found for key ".concat(String.valueOf(str)), e2);
            return str2;
        }
    }

    public final long AFKeystoreWrapper(String str) {
        try {
            return this.valueOf.getLong(str, 0);
        } catch (ClassCastException e2) {
            AFLogger.valueOf("Unexpected data type found for key ".concat(String.valueOf(str)), e2);
            return 0;
        }
    }

    public final int valueOf(String str) {
        try {
            return this.valueOf.getInt(str, 0);
        } catch (ClassCastException e2) {
            AFLogger.valueOf("Unexpected data type found for key ".concat(String.valueOf(str)), e2);
            return 0;
        }
    }

    public final boolean AFInAppEventParameterName(String str) {
        try {
            return this.valueOf.getBoolean(str, false);
        } catch (ClassCastException e2) {
            AFLogger.valueOf("Unexpected data type found for key ".concat(String.valueOf(str)), e2);
            return false;
        }
    }

    public final void AFInAppEventType(String str, boolean z) {
        this.valueOf.edit().putBoolean(str, z).apply();
    }

    public final void AFKeystoreWrapper(String str, long j) {
        this.valueOf.edit().putLong(str, j).apply();
    }

    public final void AFInAppEventType(String str) {
        GeneratedOutlineSupport.outline93(this.valueOf, str);
    }
}
