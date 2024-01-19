package io.hansel.ujmtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.logger.HSLLogger;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

public class k {

    public class a implements FileFilter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Pattern f5343a;

        public a(Pattern pattern) {
            this.f5343a = pattern;
        }

        public boolean accept(File file) {
            return this.f5343a.matcher(file.getName()).matches();
        }
    }

    public static long a(Context context, long j) {
        return e(context).getLong("BRANCH_TRACKER_TTL_IN_MILLIS", j);
    }

    public static String a(Context context) {
        return e(context).getString("AEP_ADD_EVENTS", null);
    }

    public static void a(Context context, String str) {
        if (h(context)) {
            for (File delete : new File(context.getFilesDir().getParent() + "/shared_prefs/").listFiles(new a(Pattern.compile(str + ".+")))) {
                try {
                    delete.delete();
                } catch (Exception e2) {
                    HSLLogger.printStackTrace(e2);
                }
            }
        }
    }

    public static void a(Context context, String str, Integer num) {
        e(context).edit().putInt(GeneratedOutlineSupport.outline50(str, "KL"), num.intValue()).apply();
    }

    public static void a(Context context, String str, HashMap<String, String> hashMap) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("NUDGE_EVENTS_DATA_FOR_ANALYTICS_SHARED_PREF", 0);
            Editor edit = sharedPreferences.edit();
            HashSet hashSet = new HashSet(sharedPreferences.getStringSet("NUDGE_EVENTS_DATA_FOR_ANALYTICS_KEYS", new HashSet()));
            hashSet.add(str);
            edit.putStringSet("NUDGE_EVENTS_DATA_FOR_ANALYTICS_KEYS", hashSet).apply();
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("NUDGE_EVENTS_DATA_FOR_ANALYTICS_PREFIX_" + str, 0);
            for (Entry next : hashMap.entrySet()) {
                sharedPreferences2.edit().putString((String) next.getKey(), (String) next.getValue()).apply();
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public static void a(Context context, boolean z) {
        context.getSharedPreferences("DELETE_SHARED_PREF_FILES", 0).edit().putBoolean("DELETE_SHARED_PREF_FILES", z).apply();
    }

    public static Integer b(Context context, String str) {
        SharedPreferences e2 = e(context);
        return Integer.valueOf(e2.getInt(str + "OL", 100));
    }

    public static ArrayList<HashMap<String, String>> b(Context context) {
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        try {
            Set<String> stringSet = context.getSharedPreferences("NUDGE_EVENTS_DATA_FOR_ANALYTICS_SHARED_PREF", 0).getStringSet("NUDGE_EVENTS_DATA_FOR_ANALYTICS_KEYS", new HashSet());
            if (stringSet != null) {
                Iterator<String> it = stringSet.iterator();
                while (it.hasNext()) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("NUDGE_EVENTS_DATA_FOR_ANALYTICS_PREFIX_" + it.next(), 0);
                    HashMap hashMap = new HashMap();
                    for (String next : sharedPreferences.getAll().keySet()) {
                        hashMap.put(next, sharedPreferences.getString(next, ""));
                    }
                    arrayList.add(hashMap);
                }
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return arrayList;
    }

    public static void b(Context context, long j) {
        e(context).edit().putLong("BRANCH_TRACKER_TTL_IN_MILLIS", j).apply();
    }

    public static void b(Context context, String str, Integer num) {
        e(context).edit().putInt(GeneratedOutlineSupport.outline50(str, "OL"), num.intValue()).apply();
    }

    public static void b(Context context, String str, HashMap<String, String> hashMap) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("NUDGE_EVENTS_PENDING_KEYS_SET_SHARED_PREF", 0);
            Set<String> stringSet = sharedPreferences.getStringSet("NUDGE_EVENTS_PENDING_KEYS_SET_SHARED_KEY", new HashSet());
            stringSet.add(str);
            sharedPreferences.edit().putStringSet("NUDGE_EVENTS_PENDING_KEYS_SET_SHARED_KEY", stringSet).apply();
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("NUDGE_EVENTS_PROPS_DATA_SHARED_PREF_" + str, 0);
            for (String next : hashMap.keySet()) {
                sharedPreferences2.edit().putString(next, hashMap.get(next)).apply();
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public static ArrayList<HashMap<String, String>> c(Context context) {
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("NUDGE_EVENTS_PENDING_KEYS_SET_SHARED_PREF", 0);
            Iterator<String> it = sharedPreferences.getStringSet("NUDGE_EVENTS_PENDING_KEYS_SET_SHARED_KEY", new HashSet()).iterator();
            while (it.hasNext()) {
                SharedPreferences sharedPreferences2 = context.getSharedPreferences("NUDGE_EVENTS_PROPS_DATA_SHARED_PREF_" + it.next(), 0);
                HashMap hashMap = new HashMap();
                for (String next : sharedPreferences2.getAll().keySet()) {
                    hashMap.put(next, sharedPreferences.getString(next, ""));
                }
                arrayList.add(hashMap);
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return arrayList;
    }

    public static void c(Context context, long j) {
        e(context).edit().putLong("BRANCH_TRACKER_TIMESTAMP", j).apply();
    }

    public static void c(Context context, String str) {
        try {
            context.getSharedPreferences("NUDGE_EVENTS_DATA_FOR_ANALYTICS_PREFIX_" + str, 0).edit().clear().apply();
            SharedPreferences sharedPreferences = context.getSharedPreferences("NUDGE_EVENTS_DATA_FOR_ANALYTICS_SHARED_PREF", 0);
            HashSet hashSet = new HashSet(sharedPreferences.getStringSet("NUDGE_EVENTS_DATA_FOR_ANALYTICS_KEYS", new HashSet()));
            hashSet.remove(str);
            sharedPreferences.edit().putStringSet("NUDGE_EVENTS_DATA_FOR_ANALYTICS_KEYS", hashSet).apply();
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public static void d(Context context, String str) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("NUDGE_EVENTS_PENDING_KEYS_SET_SHARED_PREF", 0);
            Set<String> stringSet = sharedPreferences.getStringSet("NUDGE_EVENTS_PENDING_KEYS_SET_SHARED_KEY", new HashSet());
            stringSet.remove(str);
            sharedPreferences.edit().putStringSet("NUDGE_EVENTS_PENDING_KEYS_SET_SHARED_KEY", stringSet).apply();
            context.getSharedPreferences("NUDGE_EVENTS_PROPS_DATA_SHARED_PREF_" + str, 0).edit().clear().apply();
            a(context, (String) "NUDGE_EVENTS_PROPS_DATA_SHARED_PREF_");
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public static boolean d(Context context) {
        return context.getSharedPreferences("DELETE_SHARED_PREF_FILES", 0).getBoolean("DELETE_SHARED_PREF_FILES", true);
    }

    public static SharedPreferences e(Context context) {
        return context.getSharedPreferences("_HANSEL_TRACKER_SP", 0);
    }

    public static void e(Context context, String str) {
        boolean isEmpty = HSLInternalUtils.isEmpty(str);
        Editor edit = e(context).edit();
        (isEmpty ? edit.remove("AEP_ADD_EVENTS") : edit.putString("AEP_ADD_EVENTS", str)).apply();
    }

    public static long f(Context context) {
        return e(context).getLong("BRANCH_TRACKER_TIMESTAMP", 0);
    }

    public static void f(Context context, String str) {
        boolean isEmpty = HSLInternalUtils.isEmpty(str);
        Editor edit = e(context).edit();
        (isEmpty ? edit.remove("AEP_TRACK_EVENTS") : edit.putString("AEP_TRACK_EVENTS", str)).apply();
    }

    public static String g(Context context) {
        return e(context).getString("AEP_TRACK_EVENTS", null);
    }

    public static boolean h(Context context) {
        boolean d2 = d(context);
        if (d2) {
            a(context, false);
        }
        return d2;
    }
}
