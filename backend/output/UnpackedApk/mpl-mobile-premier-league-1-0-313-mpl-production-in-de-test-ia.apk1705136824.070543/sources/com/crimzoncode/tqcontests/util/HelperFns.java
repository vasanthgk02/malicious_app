package com.crimzoncode.tqcontests.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class HelperFns {
    public static String formatTimeUnit(long j, int i) {
        String outline42 = GeneratedOutlineSupport.outline42("%", i, "d");
        return String.format(Locale.US, outline42, new Object[]{Long.valueOf(j)}).replace(' ', '0');
    }

    public static String getFormattedTime(long j, boolean z, boolean z2) {
        long j2 = j / 60000;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j) % 60;
        long j3 = j % 1000;
        if (z) {
            if (z2) {
                return j2 + " min " + seconds + " sec " + formatTimeUnit(j3, 3) + " ms";
            }
            return formatTimeUnit(j2, 2) + ":" + formatTimeUnit(seconds, 2) + ":" + formatTimeUnit(j3, 3);
        } else if (z2) {
            return j2 + " min " + seconds + " sec";
        } else {
            return formatTimeUnit(j2, 2) + ":" + formatTimeUnit(seconds, 2);
        }
    }

    public static Gson getGson() {
        return new GsonBuilder().setDateFormat((String) TQConstants.SERVER_DATE_FORMAT).registerTypeAdapter(Double.class, new JsonSerializer<Double>() {
            public JsonElement serialize(Double d2, Type type, JsonSerializationContext jsonSerializationContext) {
                if (d2.doubleValue() == ((double) d2.longValue())) {
                    return new JsonPrimitive((Number) Long.valueOf(d2.longValue()));
                }
                return new JsonPrimitive((Number) d2);
            }
        }).create();
    }

    public static boolean isInternetConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    public static <T extends Enum<T>> T stringToEnum(Class<T> cls, String str, T t) {
        if (cls == null || TextUtils.isEmpty(str)) {
            return t;
        }
        try {
            return Enum.valueOf(cls, str.trim().toUpperCase());
        } catch (IllegalArgumentException unused) {
            return t;
        }
    }
}
