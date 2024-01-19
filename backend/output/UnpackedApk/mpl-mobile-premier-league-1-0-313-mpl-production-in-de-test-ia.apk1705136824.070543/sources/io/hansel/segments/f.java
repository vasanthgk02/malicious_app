package io.hansel.segments;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Set;

public class f {
    public static int a(Context context) {
        return context.getSharedPreferences("eventIpaSharedPref", 0).getInt("duration_days", 7);
    }

    public static String a(Context context, String str) {
        return context.getSharedPreferences("promptFreqMapSharedPref", 0).getString(str, "");
    }

    public static void a(Context context, int i) {
        context.getSharedPreferences("eventIpaSharedPref", 0).edit().putInt("duration_days", i).apply();
    }

    public static void a(Context context, String str, String str2) {
        Editor edit = context.getSharedPreferences("promptFreqMapSharedPref", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void a(Context context, Set<String> set) {
        context.getSharedPreferences("eventIpaSharedPref", 0).edit().putStringSet("eventNameIpa", set).apply();
    }

    public static String b(Context context, String str) {
        return context.getSharedPreferences("userFreqMapSharedPref", 0).getString(str, "");
    }

    public static ArrayList<String> b(Context context) {
        Set<String> stringSet = context.getSharedPreferences("eventIpaSharedPref", 0).getStringSet("eventNameIpa", null);
        return stringSet == null ? new ArrayList<>() : new ArrayList(stringSet);
    }

    public static void b(Context context, String str, String str2) {
        Editor edit = context.getSharedPreferences("userFreqMapSharedPref", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static boolean c(Context context, String str) {
        boolean z = true;
        if (str.equals("hansel_nudge_eventhsl") || str.equals("_hsl_onAppLoadhsl") || str.equals("_hsl_page_loadhsl")) {
            return true;
        }
        Set<String> stringSet = context.getSharedPreferences("eventIpaSharedPref", 0).getStringSet("eventNameIpa", null);
        if (stringSet == null || !stringSet.contains(str)) {
            z = false;
        }
        return z;
    }
}
