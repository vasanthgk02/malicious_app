package com.freshchat.consumer.sdk.j;

import android.util.Patterns;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import java.util.regex.Pattern;

public class av {
    public static boolean a(String str, int i, String... strArr) {
        boolean a2 = as.a(str);
        if (a2 && i != 0 && str.length() > i) {
            a2 = false;
        }
        if (a2 && strArr != null) {
            for (String str2 : strArr) {
                if (as.a(str2)) {
                    try {
                        if (!str.matches(str2)) {
                            return false;
                        }
                    } catch (Exception e2) {
                        ai.e("FRESHCHAT_WARNING", e2.toString());
                    }
                }
            }
        }
        return a2;
    }

    public static boolean a(String str, String... strArr) {
        return a(str, 0, strArr);
    }

    public static boolean aK(String str) {
        return a(str, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, Patterns.EMAIL_ADDRESS.pattern());
    }

    public static boolean aL(String str) {
        return a(str, 6, "\\+?[0-9]+");
    }

    public static boolean aM(String str) {
        return a(str, 16, Patterns.PHONE.pattern());
    }

    public static boolean aN(String str) {
        return a(str, 256, new String[0]);
    }

    public static boolean aO(String str) {
        return a(str, 32, "[\\w -]+");
    }

    public static boolean bM(String str) {
        return a(str, 140, Pattern.compile("(\\+?|-?)\\d{1,140}+\\.?\\d*").pattern());
    }

    public static boolean bN(String str) {
        return a(str, Pattern.compile("^\\+?(-?\\d){9,15}$").pattern());
    }

    public static boolean d(String str, int i) {
        return a(str, i, new String[0]);
    }

    public static boolean e(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof Double) || (obj instanceof String);
    }
}
