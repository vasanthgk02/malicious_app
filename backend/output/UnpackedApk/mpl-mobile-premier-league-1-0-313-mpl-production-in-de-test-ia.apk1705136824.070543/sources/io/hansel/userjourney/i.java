package io.hansel.userjourney;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class i {
    public static Set<String> a(Context context) {
        return context.getSharedPreferences("NP_GROUPS", 0).getStringSet("NP_GROUPS", new HashSet());
    }

    public static Set<String> a(Context context, String str) {
        return context.getSharedPreferences("NP_NUDGE_JOURNEY_MAP", 0).getStringSet(str, new HashSet());
    }

    public static void a(Context context, int i) {
        HashSet hashSet;
        SharedPreferences sharedPreferences = context.getSharedPreferences("NP_GROUPS", 0);
        Editor edit = sharedPreferences.edit();
        Set<String> stringSet = sharedPreferences.getStringSet("NP_GROUPS", null);
        if (stringSet != null) {
            hashSet = new HashSet(stringSet);
        } else {
            hashSet = new HashSet();
        }
        hashSet.add(String.valueOf(i));
        edit.putStringSet("NP_GROUPS", hashSet).apply();
    }

    public static void a(Context context, String str, int i) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("NP_GROUP_NUDGE_MAP", 0);
        Editor edit = sharedPreferences.edit();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        String valueOf = String.valueOf(i);
        Set<String> stringSet = sharedPreferences.getStringSet(valueOf, null);
        if (stringSet != null) {
            linkedHashSet = new LinkedHashSet(stringSet);
        }
        linkedHashSet.add(str);
        edit.putStringSet(valueOf, linkedHashSet);
        edit.apply();
    }

    public static void a(Context context, String str, CoreJSONObject coreJSONObject) {
        Editor edit = context.getSharedPreferences("NP_NUDGE_RAW_JSON", 0).edit();
        edit.putString(str, coreJSONObject.toString());
        edit.apply();
    }

    public static void a(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("NP_NUDGE_JOURNEY_MAP", 0);
        Editor edit = sharedPreferences.edit();
        HashSet hashSet = new HashSet();
        Set<String> stringSet = sharedPreferences.getStringSet(str, null);
        if (stringSet != null) {
            hashSet = new HashSet(stringSet);
        }
        hashSet.add(str2);
        edit.putStringSet(str, hashSet);
        edit.apply();
    }

    public static void a(Context context, String str, boolean z) {
        context.getSharedPreferences("NP_NUDGE_DISPLAY_ELIGIBILITY_WITHIN_GROUP_MAP", 0).edit().putBoolean(str, z).apply();
    }

    public static void b(Context context, String str, int i) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("NP_GROUP_NUDGE_MAP", 0);
        Editor edit = sharedPreferences.edit();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        String valueOf = String.valueOf(i);
        Set<String> stringSet = sharedPreferences.getStringSet(valueOf, null);
        if (stringSet != null) {
            linkedHashSet = new LinkedHashSet(stringSet);
        }
        linkedHashSet.remove(str);
        if (linkedHashSet.size() > 0) {
            edit.putStringSet(valueOf, linkedHashSet);
        } else {
            edit.remove(valueOf);
        }
        edit.apply();
    }

    public static void b(Context context, String str, boolean z) {
        context.getSharedPreferences("NP_NUDGE_DISPLAY_FLAG_MAP", 0).edit().putBoolean(str, z).apply();
    }

    public static boolean b(Context context, String str) {
        return context.getSharedPreferences("NP_NUDGE_DISPLAY_ELIGIBILITY_WITHIN_GROUP_MAP", 0).getBoolean(str, false);
    }

    public static void c(Context context, String str, int i) {
        context.getSharedPreferences("NP_NUDGE_GROUP_MAP", 0).edit().putInt(str, i).apply();
    }

    public static boolean c(Context context, String str) {
        return context.getSharedPreferences("NP_NUDGE_DISPLAY_FLAG_MAP", 0).getBoolean(str, false);
    }

    public static int d(Context context, String str) {
        return context.getSharedPreferences("NP_NUDGE_GROUP_MAP", 0).getInt(str, 0);
    }

    public static void d(Context context, String str, int i) {
        context.getSharedPreferences("NP_NUDGE_PRIORITY_MAP", 0).edit().putInt(str, i).apply();
    }

    public static CoreJSONObject e(Context context, String str) {
        try {
            return new CoreJSONObject(context.getSharedPreferences("NP_NUDGE_RAW_JSON", 0).getString(str, ""));
        } catch (CoreJSONException unused) {
            return new CoreJSONObject();
        }
    }

    public static Set<String> f(Context context, String str) {
        return context.getSharedPreferences("NP_GROUP_NUDGE_MAP", 0).getStringSet(str, new LinkedHashSet());
    }

    public static int g(Context context, String str) {
        return context.getSharedPreferences("NP_NUDGE_PRIORITY_MAP", 0).getInt(str, 0);
    }

    public static void h(Context context, String str) {
        context.getSharedPreferences("NP_NUDGE_JOURNEY_MAP", 0).edit().remove(str).apply();
    }

    public static void i(Context context, String str) {
        context.getSharedPreferences("NP_NUDGE_DISPLAY_ELIGIBILITY_WITHIN_GROUP_MAP", 0).edit().remove(str).apply();
    }

    public static void j(Context context, String str) {
        context.getSharedPreferences("NP_NUDGE_DISPLAY_FLAG_MAP", 0).edit().remove(str).apply();
    }

    public static void k(Context context, String str) {
        context.getSharedPreferences("NP_NUDGE_GROUP_MAP", 0).edit().remove(str).apply();
    }

    public static void l(Context context, String str) {
        context.getSharedPreferences("NP_NUDGE_PRIORITY_MAP", 0).edit().remove(str).apply();
    }

    public static void m(Context context, String str) {
        context.getSharedPreferences("NP_NUDGE_RAW_JSON", 0).edit().remove(str).apply();
    }
}
