package com.mpl.securepreferences;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Keep;
import java.security.GeneralSecurityException;
import java.util.Map;
import java.util.Set;

@Keep
public class MPreferences {
    public static final String GENERAL_PREF_FILE_NAME = "mpl_general_preferences";
    public static final String SECURE_PREF_FILE_NAME = "mpl_secure_preferences";
    public static final String TAG = "MPreferences";
    public static SharedPreferences mPreferences;
    public static SharedPreferences mSecurePreferences;
    public static boolean sLoggingEnabled;

    public static synchronized void changePassword(Context context, String str) {
        synchronized (MPreferences.class) {
            if (context != null) {
                if (context instanceof Application) {
                    try {
                        ((b) getSecure()).a(str, context);
                    } catch (GeneralSecurityException unused) {
                    }
                }
            }
            throw new RuntimeException("Please provide Application Context");
        }
    }

    public static void checkInitiation() {
    }

    public static synchronized void clear(boolean z) {
        synchronized (MPreferences.class) {
            checkInitiation();
            if (z) {
                getSecure().edit().clear().apply();
            } else {
                getGeneral().edit().clear().apply();
            }
        }
    }

    public static synchronized boolean contains(String str, boolean z) {
        synchronized (MPreferences.class) {
            try {
                checkInitiation();
                if (z) {
                    boolean contains = getSecure().contains(str);
                    return contains;
                }
                boolean contains2 = getGeneral().contains(str);
                return contains2;
            }
        }
    }

    public static synchronized Map<String, ?> getAll(boolean z) {
        synchronized (MPreferences.class) {
            try {
                checkInitiation();
                if (z) {
                    Map<String, ?> all = getSecure().getAll();
                    return all;
                }
                Map<String, ?> all2 = getGeneral().getAll();
                return all2;
            }
        }
    }

    public static synchronized boolean getBoolean(String str, boolean z, boolean z2) {
        synchronized (MPreferences.class) {
            try {
                checkInitiation();
                if (z2) {
                    boolean z3 = getSecure().getBoolean(str, z);
                    return z3;
                }
                boolean z4 = getGeneral().getBoolean(str, z);
                return z4;
            }
        }
    }

    public static synchronized float getFloat(String str, float f2, boolean z) {
        synchronized (MPreferences.class) {
            checkInitiation();
            if (z) {
                float f3 = getSecure().getFloat(str, f2);
                return f3;
            }
            float f4 = getGeneral().getFloat(str, f2);
            return f4;
        }
    }

    public static synchronized SharedPreferences getGeneral() {
        SharedPreferences sharedPreferences;
        synchronized (MPreferences.class) {
            try {
                if (mPreferences != null) {
                    sharedPreferences = mPreferences;
                } else {
                    throw new RuntimeException("First Initialize this.Call MPreferences.init(Context)");
                }
            }
        }
        return sharedPreferences;
    }

    public static synchronized int getInt(String str, int i, boolean z) {
        synchronized (MPreferences.class) {
            try {
                checkInitiation();
                if (z) {
                    int i2 = getSecure().getInt(str, i);
                    return i2;
                }
                int i3 = getGeneral().getInt(str, i);
                return i3;
            }
        }
    }

    public static synchronized long getLong(String str, long j, boolean z) {
        synchronized (MPreferences.class) {
            try {
                checkInitiation();
                if (z) {
                    long j2 = getSecure().getLong(str, j);
                    return j2;
                }
                long j3 = getGeneral().getLong(str, j);
                return j3;
            }
        }
    }

    public static synchronized SharedPreferences getSecure() {
        SharedPreferences sharedPreferences;
        synchronized (MPreferences.class) {
            try {
                if (mSecurePreferences != null) {
                    sharedPreferences = mSecurePreferences;
                } else {
                    throw new RuntimeException("First Initialize this. Call MPreferences.init(Context)");
                }
            }
        }
        return sharedPreferences;
    }

    public static synchronized String getString(String str, String str2, boolean z) {
        synchronized (MPreferences.class) {
            try {
                checkInitiation();
                if (z) {
                    String string = getSecure().getString(str, str2);
                    return string;
                }
                String string2 = getGeneral().getString(str, str2);
                return string2;
            }
        }
    }

    public static synchronized Set<String> getStringSet(String str, Set<String> set, boolean z) {
        synchronized (MPreferences.class) {
            checkInitiation();
            if (z) {
                Set<String> stringSet = getSecure().getStringSet(str, set);
                return stringSet;
            }
            Set<String> stringSet2 = getGeneral().getStringSet(str, set);
            return stringSet2;
        }
    }

    public static void init(Context context, String str) {
        if (context == null || !(context instanceof Application)) {
            throw new RuntimeException("Context is null OR Provide Application Context");
        }
        if (!TextUtils.isEmpty(str) && mSecurePreferences == null) {
            mSecurePreferences = new b(context, str, SECURE_PREF_FILE_NAME);
        }
        if (mPreferences == null) {
            mPreferences = context.getSharedPreferences(GENERAL_PREF_FILE_NAME, 0);
        }
    }

    public static boolean isLoggingEnabled() {
        return sLoggingEnabled;
    }

    public static synchronized void putBoolean(String str, boolean z, boolean z2) {
        synchronized (MPreferences.class) {
            checkInitiation();
            if (z2) {
                getSecure().edit().putBoolean(str, z).apply();
            } else {
                getGeneral().edit().putBoolean(str, z).apply();
            }
        }
    }

    public static synchronized void putFloat(String str, float f2, boolean z) {
        synchronized (MPreferences.class) {
            checkInitiation();
            if (z) {
                getSecure().edit().putFloat(str, f2).apply();
            } else {
                getGeneral().edit().putFloat(str, f2).apply();
            }
        }
    }

    public static synchronized void putInt(String str, int i, boolean z) {
        synchronized (MPreferences.class) {
            checkInitiation();
            if (z) {
                getSecure().edit().putInt(str, i).apply();
            } else {
                getGeneral().edit().putInt(str, i).apply();
            }
        }
    }

    public static synchronized void putLong(String str, long j, boolean z) {
        synchronized (MPreferences.class) {
            checkInitiation();
            if (z) {
                getSecure().edit().putLong(str, j).apply();
            } else {
                getGeneral().edit().putLong(str, j).apply();
            }
        }
    }

    public static synchronized void putString(String str, String str2, boolean z) {
        synchronized (MPreferences.class) {
            checkInitiation();
            if (z) {
                getSecure().edit().putString(str, str2).apply();
            } else {
                getGeneral().edit().putString(str, str2).apply();
            }
        }
    }

    public static synchronized void putStringSet(String str, Set<String> set, boolean z) {
        synchronized (MPreferences.class) {
            checkInitiation();
            if (z) {
                getSecure().edit().putStringSet(str, set).apply();
            } else {
                getGeneral().edit().putStringSet(str, set).apply();
            }
        }
    }

    public static synchronized void remove(String str, boolean z) {
        synchronized (MPreferences.class) {
            checkInitiation();
            if (z) {
                getSecure().edit().remove(str).apply();
            } else {
                getGeneral().edit().remove(str).apply();
            }
        }
    }

    public static synchronized void isLoggingEnabled(boolean z) {
        synchronized (MPreferences.class) {
            sLoggingEnabled = z;
        }
    }

    public static synchronized void changePassword(Context context, String str, int i) {
        synchronized (MPreferences.class) {
            if (context != null) {
                if (context instanceof Application) {
                    try {
                        ((b) getSecure()).a(str, context, i);
                    } catch (GeneralSecurityException unused) {
                    }
                }
            }
            throw new RuntimeException("Please provide Application Context");
        }
    }

    public static void init(Context context, String str, int i) {
        if (context == null || !(context instanceof Application)) {
            throw new RuntimeException("Context is null OR Provide Application Context");
        }
        if (!TextUtils.isEmpty(str) && mSecurePreferences == null) {
            mSecurePreferences = new b(context, str, SECURE_PREF_FILE_NAME, i);
        }
        if (mPreferences == null) {
            mPreferences = context.getSharedPreferences(GENERAL_PREF_FILE_NAME, 0);
        }
    }
}
