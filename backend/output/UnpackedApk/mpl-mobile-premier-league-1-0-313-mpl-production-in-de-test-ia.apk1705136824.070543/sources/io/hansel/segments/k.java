package io.hansel.segments;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.filters.HSLFiltersInternal;
import io.hansel.core.logger.HSLLogger;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

public class k {

    public class a implements FileFilter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Pattern f5267a;

        public a(Pattern pattern) {
            this.f5267a = pattern;
        }

        public boolean accept(File file) {
            return this.f5267a.matcher(file.getName()).matches();
        }
    }

    public static SharedPreferences a(Context context, boolean z) {
        String str;
        if (z && !c(context, a())) {
            b(context);
        }
        String uniqueId = HSLFiltersInternal.getInstance().getUniqueId();
        SharedPreferences sharedPreferences = context.getSharedPreferences("promptDisplayTimeSPNameMap", 0);
        if (sharedPreferences.contains(uniqueId)) {
            str = sharedPreferences.getString(uniqueId, "promptDisplayTimeMapSharedPref-");
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("promptDisplayTimeMapSharedPref-");
            outline73.append(System.currentTimeMillis());
            String sb = outline73.toString();
            sharedPreferences.edit().putString(uniqueId, sb).apply();
            str = sb;
        }
        return context.getSharedPreferences(str, 0);
    }

    public static String a() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("promptDisplayTimeMapSharedPref_");
        outline73.append(HSLFiltersInternal.getInstance().getUniqueId());
        return outline73.toString();
    }

    public static Map<String, ?> a(Context context) {
        return a(context, true).getAll();
    }

    public static void a(Context context, String str) {
        try {
            for (File delete : new File(context.getFilesDir().getParent() + "/shared_prefs/").listFiles(new a(Pattern.compile(str + ".+")))) {
                delete.delete();
            }
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, String str, long j) {
        Editor edit = a(context, true).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public static void a(Context context, Set<String> set) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("promptFreqMapSharedPref", 0);
        Editor edit = sharedPreferences.edit();
        ArrayList arrayList = new ArrayList(sharedPreferences.getAll().keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            if (!set.contains(str)) {
                edit.remove(str);
                d(context, str);
            }
        }
        edit.apply();
    }

    public static long b(Context context, String str) {
        return a(context, true).getLong(str, -1);
    }

    public static void b(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(a(), 0);
            Set<Entry<String, ?>> entrySet = sharedPreferences.getAll().entrySet();
            if (entrySet.size() > 0) {
                Editor edit = a(context, false).edit();
                for (Entry next : entrySet) {
                    edit.putLong((String) next.getKey(), ((Long) next.getValue()).longValue());
                }
                edit.apply();
            }
            sharedPreferences.edit().clear().apply();
        } catch (Throwable unused) {
        }
        e(context, a());
        a(context, (String) "promptDisplayTimeMapSharedPref_");
    }

    public static boolean c(Context context, String str) {
        return context.getSharedPreferences("promptDisplayTimeSPMigrationMap", 0).getBoolean(str, false);
    }

    public static void d(Context context, String str) {
        a(context, true).edit().remove(str).apply();
    }

    public static void e(Context context, String str) {
        context.getSharedPreferences("promptDisplayTimeSPMigrationMap", 0).edit().putBoolean(str, true).apply();
    }
}
