package io.hansel.segments;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.security.ICrypto;
import io.hansel.core.utils.HSLUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class p {
    /* JADX WARNING: Can't wrap try/catch for region: R(3:9|10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r1.edit().remove(r3).apply();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0017 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.hansel.core.json.CoreJSONObject a(android.content.Context r2, java.lang.String r3, io.hansel.core.security.ICrypto r4) {
        /*
            r0 = 0
            android.content.SharedPreferences r1 = h(r2)     // Catch:{ Exception -> 0x0030 }
            boolean r2 = e(r2, r3)     // Catch:{ Exception -> 0x0030 }
            if (r2 == 0) goto L_0x0023
            java.lang.String r2 = r1.getString(r3, r0)     // Catch:{ Exception -> 0x0030 }
            if (r2 != 0) goto L_0x0012
            return r0
        L_0x0012:
            java.lang.String r2 = r4.aesDecrypt(r2)     // Catch:{ Exception -> 0x0017 }
            goto L_0x0027
        L_0x0017:
            android.content.SharedPreferences$Editor r2 = r1.edit()     // Catch:{ Exception -> 0x0030 }
            android.content.SharedPreferences$Editor r2 = r2.remove(r3)     // Catch:{ Exception -> 0x0030 }
            r2.apply()     // Catch:{ Exception -> 0x0030 }
            return r0
        L_0x0023:
            java.lang.String r2 = r1.getString(r3, r0)     // Catch:{ Exception -> 0x0030 }
        L_0x0027:
            if (r2 != 0) goto L_0x002a
            return r0
        L_0x002a:
            io.hansel.core.json.CoreJSONObject r3 = new io.hansel.core.json.CoreJSONObject     // Catch:{ Exception -> 0x0030 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0030 }
            return r3
        L_0x0030:
            r2 = move-exception
            io.hansel.core.logger.HSLLogger.printStackTrace(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.segments.p.a(android.content.Context, java.lang.String, io.hansel.core.security.ICrypto):io.hansel.core.json.CoreJSONObject");
    }

    public static Set<String> a(Context context) {
        return h(context).getAll().keySet();
    }

    public static void a(Context context, String str) {
        Editor edit = h(context).edit();
        edit.remove(str);
        edit.apply();
    }

    public static void a(Context context, String str, CoreJSONObject coreJSONObject) {
        try {
            j(context).edit().putString(str, coreJSONObject.toString()).apply();
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
        }
    }

    public static void a(Context context, String str, CoreJSONObject coreJSONObject, ICrypto iCrypto, Boolean bool) {
        Editor edit = h(context).edit();
        String coreJSONObject2 = coreJSONObject.toString();
        try {
            g(context).edit().putBoolean(str, bool.booleanValue()).apply();
            if (bool.booleanValue()) {
                edit.putString(str, iCrypto.aesEncrypt(coreJSONObject2));
            } else {
                edit.putString(str, coreJSONObject2);
            }
            edit.apply();
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
        }
    }

    public static void a(Context context, String str, Boolean bool) {
        Editor edit = i(context).edit();
        edit.putBoolean(str, bool.booleanValue());
        edit.apply();
    }

    public static void a(Context context, String str, boolean z) {
        Editor edit = c(context).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static void a(Context context, HashMap<String, Set<String>> hashMap) {
        Editor edit = context.getSharedPreferences("sub_segment_fields", 0).edit();
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            edit.putStringSet(str, hashMap.get(str));
        }
        edit.apply();
    }

    public static void a(Context context, Set<String> set, String str) {
        if (set != null && set.size() != 0 && HSLUtils.isSet(str)) {
            Editor edit = context.getSharedPreferences("subsegid_to_segid_map", 0).edit();
            for (String putString : set) {
                edit.putString(putString, str);
            }
            edit.apply();
            Editor edit2 = context.getSharedPreferences("segid_to_subsegid_map", 0).edit();
            edit2.putStringSet(str, set);
            edit2.apply();
        }
    }

    public static void a(Context context, Set<String> set, String str, boolean z) {
        SharedPreferences b2 = b(context);
        Editor edit = b2.edit();
        ArrayList arrayList = new ArrayList(set);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str2 = (String) arrayList.get(i);
            Set<String> stringSet = b2.getStringSet(str2, new HashSet());
            if (stringSet != null) {
                HashSet hashSet = new HashSet(stringSet);
                if (z) {
                    hashSet.add(str);
                } else {
                    hashSet.remove(str);
                }
                edit.putStringSet(str2, hashSet);
            }
        }
        edit.apply();
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences("attribute_segment_map", 0);
    }

    public static Boolean b(Context context, String str) {
        return Boolean.valueOf(i(context).getBoolean(str, false));
    }

    public static void b(Context context, HashMap<String, Long> hashMap) {
        Editor edit = context.getSharedPreferences("sub_segment_timestamp", 0).edit();
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            Long l = hashMap.get(str);
            edit.putLong(str, l == null ? 0 : l.longValue());
        }
        edit.apply();
    }

    public static void b(Context context, Set<String> set, String str) {
        Editor edit = context.getSharedPreferences("sub_segment_seg", 0).edit();
        edit.putStringSet(str, set);
        edit.apply();
    }

    public static void b(Context context, Set<String> set, String str, boolean z) {
        SharedPreferences e2 = e(context);
        Editor edit = e2.edit();
        ArrayList arrayList = new ArrayList(set);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str2 = (String) arrayList.get(i);
            Set<String> stringSet = e2.getStringSet(str2, new HashSet());
            if (stringSet != null) {
                HashSet hashSet = new HashSet(stringSet);
                if (z) {
                    hashSet.add(str);
                } else {
                    hashSet.remove(str);
                }
                edit.putStringSet(str2, hashSet);
            }
        }
        edit.apply();
    }

    public static SharedPreferences c(Context context) {
        return context.getSharedPreferences("sub_segment_map", 0);
    }

    public static Set<String> c(Context context, String str) {
        return new HashSet(b(context).getStringSet(str, new HashSet()));
    }

    public static void c(Context context, HashMap<String, Boolean> hashMap) {
        Editor edit = context.getSharedPreferences("sub_segment_values", 0).edit();
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            Boolean bool = hashMap.get(str);
            edit.putBoolean(str, bool == null ? false : bool.booleanValue());
        }
        edit.apply();
    }

    public static Map<String, ?> d(Context context) {
        return new HashMap(c(context).getAll());
    }

    public static Set<String> d(Context context, String str) {
        return new HashSet(e(context).getStringSet(str, new HashSet()));
    }

    public static SharedPreferences e(Context context) {
        return context.getSharedPreferences("event_segment_map", 0);
    }

    public static boolean e(Context context, String str) {
        return g(context).getBoolean(str, false);
    }

    public static CoreJSONObject f(Context context, String str) {
        try {
            String string = j(context).getString(str, null);
            if (string == null) {
                return null;
            }
            return new CoreJSONObject(string);
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
            return null;
        }
    }

    public static Map<String, ?> f(Context context) {
        return new HashMap(context.getSharedPreferences("sub_segment_fields", 0).getAll());
    }

    public static SharedPreferences g(Context context) {
        return context.getSharedPreferences("hansel_segment_encrypted_map", 0);
    }

    public static void g(Context context, String str) {
        Editor edit = c(context).edit();
        edit.remove(str);
        edit.apply();
    }

    public static SharedPreferences h(Context context) {
        return context.getSharedPreferences("segment_map", 0);
    }

    public static void h(Context context, String str) {
        Editor edit = i(context).edit();
        edit.remove(str);
        edit.apply();
        m(context, str);
        l(context, str);
    }

    public static SharedPreferences i(Context context) {
        return context.getSharedPreferences("attribute_value_map", 0);
    }

    public static void i(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("sub_segment_fields", 0);
        Map<String, ?> all = sharedPreferences.getAll();
        Editor edit = sharedPreferences.edit();
        ArrayList arrayList = new ArrayList(all.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str2 = (String) arrayList.get(i);
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.apply();
    }

    public static SharedPreferences j(Context context) {
        return context.getSharedPreferences("hansel_stop_condition_prompt_map", 0);
    }

    public static void j(Context context, String str) {
        if (HSLUtils.isSet(str)) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("segid_to_subsegid_map", 0);
            HashSet hashSet = new HashSet(sharedPreferences.getStringSet(str, new HashSet()));
            sharedPreferences.edit().remove(str).apply();
            if (hashSet.size() > 0) {
                Editor edit = context.getSharedPreferences("subsegid_to_segid_map", 0).edit();
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    edit.remove((String) it.next());
                }
                edit.apply();
            }
        }
    }

    public static Map<String, ?> k(Context context) {
        return new HashMap(context.getSharedPreferences("sub_segment_seg", 0).getAll());
    }

    public static void k(Context context, String str) {
        Editor edit = context.getSharedPreferences("sub_segment_seg", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    public static Map<String, ?> l(Context context) {
        return new HashMap(context.getSharedPreferences("sub_segment_timestamp", 0).getAll());
    }

    public static void l(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("sub_segment_timestamp", 0);
        Map<String, ?> all = sharedPreferences.getAll();
        Editor edit = sharedPreferences.edit();
        ArrayList arrayList = new ArrayList(all.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str2 = (String) arrayList.get(i);
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.apply();
    }

    public static Map<String, ?> m(Context context) {
        return new HashMap(context.getSharedPreferences("sub_segment_values", 0).getAll());
    }

    public static void m(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("sub_segment_values", 0);
        Map<String, ?> all = sharedPreferences.getAll();
        Editor edit = sharedPreferences.edit();
        ArrayList arrayList = new ArrayList(all.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str2 = (String) arrayList.get(i);
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.apply();
    }

    public static Set<String> n(Context context) {
        try {
            return j(context).getAll().keySet();
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
            return null;
        }
    }
}
