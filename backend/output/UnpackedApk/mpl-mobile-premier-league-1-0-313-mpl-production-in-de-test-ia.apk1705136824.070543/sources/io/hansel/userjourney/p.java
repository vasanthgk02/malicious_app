package io.hansel.userjourney;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.brentvatne.react.ReactVideoViewManager;
import io.hansel.actions.HSLConfigDataType;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.filters.HSLFiltersInternal;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.utils.HSLUtils;
import io.hansel.userjourney.prompts.h0;
import io.hansel.userjourney.prompts.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class p {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5473a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0051 */
        static {
            /*
                io.hansel.actions.HSLConfigDataType[] r0 = io.hansel.actions.HSLConfigDataType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5473a = r0
                io.hansel.actions.HSLConfigDataType r1 = io.hansel.actions.HSLConfigDataType.num     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r0 = 2
                int[] r1 = f5473a     // Catch:{ NoSuchFieldError -> 0x0016 }
                io.hansel.actions.HSLConfigDataType r2 = io.hansel.actions.HSLConfigDataType.bool     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 0
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = f5473a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.hansel.actions.HSLConfigDataType r3 = io.hansel.actions.HSLConfigDataType.str     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r0 = 4
                int[] r2 = f5473a     // Catch:{ NoSuchFieldError -> 0x0024 }
                io.hansel.actions.HSLConfigDataType r3 = io.hansel.actions.HSLConfigDataType.json     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                r1 = 5
                int[] r2 = f5473a     // Catch:{ NoSuchFieldError -> 0x002b }
                io.hansel.actions.HSLConfigDataType r3 = io.hansel.actions.HSLConfigDataType.array     // Catch:{ NoSuchFieldError -> 0x002b }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r0 = 6
                int[] r2 = f5473a     // Catch:{ NoSuchFieldError -> 0x0032 }
                io.hansel.actions.HSLConfigDataType r3 = io.hansel.actions.HSLConfigDataType.list     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                r1 = 7
                int[] r2 = f5473a     // Catch:{ NoSuchFieldError -> 0x0039 }
                io.hansel.actions.HSLConfigDataType r3 = io.hansel.actions.HSLConfigDataType.color     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                r0 = 8
                int[] r2 = f5473a     // Catch:{ NoSuchFieldError -> 0x0041 }
                io.hansel.actions.HSLConfigDataType r3 = io.hansel.actions.HSLConfigDataType.image     // Catch:{ NoSuchFieldError -> 0x0041 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0041 }
            L_0x0041:
                r1 = 9
                int[] r2 = f5473a     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.hansel.actions.HSLConfigDataType r3 = io.hansel.actions.HSLConfigDataType.rich_text     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r0 = 10
                int[] r2 = f5473a     // Catch:{ NoSuchFieldError -> 0x0051 }
                io.hansel.actions.HSLConfigDataType r3 = io.hansel.actions.HSLConfigDataType.hashmap     // Catch:{ NoSuchFieldError -> 0x0051 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                int[] r1 = f5473a     // Catch:{ NoSuchFieldError -> 0x0059 }
                io.hansel.actions.HSLConfigDataType r2 = io.hansel.actions.HSLConfigDataType.linkedlist     // Catch:{ NoSuchFieldError -> 0x0059 }
                r2 = 11
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.p.a.<clinit>():void");
        }
    }

    public static void A(Context context, String str) {
        context.getSharedPreferences("journeyIdAdMapSharedPref", 0).edit().remove(str).apply();
    }

    public static void B(Context context, String str) {
        x(context, str).edit().clear().apply();
    }

    public static void C(Context context, String str) {
        context.getSharedPreferences("journeyIdEventsMapSharedPref", 0).edit().remove(str).apply();
    }

    public static void D(Context context, String str) {
        context.getSharedPreferences("journeyIdJourneyHashMapSharedPref", 0).edit().remove(str).apply();
    }

    public static void E(Context context, String str) {
        context.getSharedPreferences("configIdjourneyIdMapSharedPref", 0).edit().remove(str).apply();
    }

    public static void F(Context context, String str) {
        SharedPreferences j = j(context);
        Set<String> d2 = d(context);
        d2.remove(str);
        j.edit().putStringSet("journeyIdsListSharedPref", d2).apply();
    }

    public static void G(Context context, String str) {
        context.getSharedPreferences("rollOutEventIdjourneyIdsMapSharedPref", 0).edit().remove(str).apply();
    }

    public static void H(Context context, String str) {
        context.getSharedPreferences("journeyIdJourneyJsonMapSharedPref", 0).edit().remove(str).apply();
    }

    public static void I(Context context, String str) {
        context.getSharedPreferences("journeyIdLeadNodeIdMapSharedPref", 0).edit().remove(str).apply();
    }

    public static void J(Context context, String str) {
        Editor edit = context.getSharedPreferences("jIdPromptIdMapSharedPref", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    public static void K(Context context, String str) {
        Editor edit = context.getSharedPreferences("jIdViewCreatedMapSharedPref", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    public static void L(Context context, String str) {
        context.getSharedPreferences("journeyIdAbEventsMapSharedPref", 0).edit().remove(str).apply();
    }

    public static void M(Context context, String str) {
        context.getSharedPreferences("journeyIdSegmentsMapSharedPref", 0).edit().remove(str).apply();
    }

    public static void N(Context context, String str) {
        boolean isEmpty = HSLInternalUtils.isEmpty(str);
        Editor edit = j(context).edit();
        (isEmpty ? edit.remove("AEP_DIL") : edit.putString("AEP_DIL", str)).apply();
    }

    public static void O(Context context, String str) {
        boolean isEmpty = HSLInternalUtils.isEmpty(str);
        Editor edit = j(context).edit();
        (isEmpty ? edit.remove("AEP_JOURNEY") : edit.putString("AEP_JOURNEY", str)).apply();
    }

    public static Object a(Context context, String str, String str2, Object obj, HSLConfigDataType hSLConfigDataType) {
        SharedPreferences x = x(context, str);
        if (hSLConfigDataType != null && x.contains(str2)) {
            try {
                switch (a.f5473a[hSLConfigDataType.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        return x.getString(str2, (String) obj);
                }
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2, GeneratedOutlineSupport.outline53("Unable to find config value for config: ", str2, " in journey: ", str), LogGroup.CJ);
            }
        }
        return null;
    }

    public static String a(SharedPreferences sharedPreferences, String str, String str2) {
        try {
            return sharedPreferences.getString(str, "");
        } catch (ClassCastException unused) {
            HSLLogger.d("UJSP Data missing:  " + str2 + " for key " + str);
            return "";
        }
    }

    public static String a(SharedPreferences sharedPreferences, String str, String str2, String str3) {
        if (!(str == null || sharedPreferences == null)) {
            try {
                return sharedPreferences.getString(str, str3);
            } catch (ClassCastException unused) {
                HSLLogger.d("UJSP Data missing:  " + str2 + " for key " + str);
            }
        }
        return str3;
    }

    public static Map<String, ?> a(SharedPreferences sharedPreferences) {
        return new HashMap(sharedPreferences.getAll());
    }

    public static Set<String> a(SharedPreferences sharedPreferences, String str) {
        try {
            return new HashSet(sharedPreferences.getStringSet(str, new HashSet()));
        } catch (ClassCastException unused) {
            return new HashSet();
        }
    }

    public static TreeSet<j> a(Context context, List<String> list, String str) {
        TreeSet<j> treeSet = new TreeSet<>();
        if (list == null) {
            return treeSet;
        }
        for (int i = 0; i < list.size(); i++) {
            String str2 = list.get(i);
            treeSet.add(new j(str2, p(context, str2), str));
        }
        return treeSet;
    }

    public static void a(Context context) {
        try {
            context.getSharedPreferences("journeyIdLeadNodeIdMapCopySharedPref", 0).edit().clear().apply();
        } catch (Throwable unused) {
            HSLLogger.d("Exception caught while clearing the copy of journeyIdLeafNodeId Map", LogGroup.PT);
        }
    }

    public static void a(Context context, long j, String str) {
        context.getSharedPreferences("promptIdPriorityMapSharedPref", 0).edit().putLong(str, j);
    }

    public static void a(Context context, CoreJSONObject coreJSONObject) {
        Editor edit = context.getSharedPreferences("testJourneyMapSharedPref", 0).edit();
        ArrayList arrayList = new ArrayList(coreJSONObject.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            String optString = coreJSONObject.optString(str, null);
            if (HSLUtils.isSet(optString) && !"null".equals(optString)) {
                edit.putString(str, optString);
            }
        }
        edit.apply();
    }

    public static void a(Context context, String str) {
        SharedPreferences j = j(context);
        Set<String> d2 = d(context);
        d2.add(str);
        j.edit().putStringSet("journeyIdsListSharedPref", d2).apply();
    }

    public static void a(Context context, String str, long j) {
        context.getSharedPreferences("journeyIdAdMapSharedPref", 0).edit().putLong(str, j).apply();
    }

    public static void a(Context context, String str, CoreJSONObject coreJSONObject) {
        context.getSharedPreferences("journeyIdJourneyJsonMapSharedPref", 0).edit().putString(str, coreJSONObject.toString()).apply();
    }

    public static void a(Context context, String str, String str2) {
        context.getSharedPreferences("eventNameIdMapSharedPref", 0).edit().putString(str, str2).apply();
    }

    public static void a(Context context, String str, Set<String> set) {
        context.getSharedPreferences("journeyIdEventsMapSharedPref", 0).edit().putStringSet(str, set).apply();
    }

    public static void a(Context context, ArrayList<String> arrayList) {
        if (arrayList != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("eventPromptIdArrSharedPref", 0);
            Editor edit = sharedPreferences.edit();
            ArrayList arrayList2 = new ArrayList(a(sharedPreferences).keySet());
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                String str = (String) arrayList2.get(i);
                String string = sharedPreferences.getString(str, "");
                ArrayList arrayList3 = string == null ? new ArrayList() : new ArrayList(Arrays.asList(string.split(",")));
                arrayList3.removeAll(arrayList);
                StringBuilder sb = new StringBuilder();
                int size2 = arrayList3.size();
                if (size2 > 0) {
                    sb = new StringBuilder((String) arrayList3.get(0));
                }
                for (int i2 = 1; i2 < size2; i2++) {
                    sb.append(",");
                    sb.append((String) arrayList3.get(i2));
                }
                edit.putString(str, sb.toString());
            }
            edit.apply();
        }
    }

    public static void a(Context context, HashMap<String, String> hashMap) {
        Editor edit = context.getSharedPreferences("promptIdPromptJsonMapSharedPref", 0).edit();
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            edit.putString(str, hashMap.get(str));
        }
        edit.apply();
    }

    public static void a(Context context, HashMap<String, Object> hashMap, String str) {
        Editor edit = x(context, str).edit();
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str2 = (String) arrayList.get(i);
            Object obj = hashMap.get(str2);
            if (obj != null) {
                edit.putString(str2, String.valueOf(obj)).apply();
            }
        }
    }

    public static void a(Context context, Set<String> set) {
        Editor edit = context.getSharedPreferences("promptIdPromptJsonMapSharedPref", 0).edit();
        ArrayList arrayList = new ArrayList(set);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            edit.remove((String) arrayList.get(i));
        }
        edit.apply();
    }

    public static void a(Context context, TreeSet<j> treeSet) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("eventPromptIdArrSharedPref", 0);
        Editor edit = sharedPreferences.edit();
        ArrayList arrayList = new ArrayList(treeSet);
        HashMap hashMap = new HashMap();
        Map<String, ?> all = sharedPreferences.getAll();
        ArrayList arrayList2 = new ArrayList(all.keySet());
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList2.get(i);
            String str2 = (String) all.get(str);
            List arrayList3 = new ArrayList();
            if (str2 != null) {
                try {
                    if (!str2.isEmpty()) {
                        arrayList3 = Arrays.asList(str2.split(","));
                    }
                } catch (Throwable unused) {
                }
            }
            hashMap.put(str, a(context, arrayList3, str));
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            j jVar = (j) arrayList.get(size2);
            String a2 = jVar.a();
            TreeSet treeSet2 = (TreeSet) hashMap.get(a2);
            if (treeSet2 == null) {
                treeSet2 = new TreeSet();
            }
            treeSet2.add(jVar);
            hashMap.put(a2, treeSet2);
        }
        for (String str3 : hashMap.keySet()) {
            TreeSet treeSet3 = (TreeSet) hashMap.get(str3);
            ArrayList arrayList4 = new ArrayList();
            try {
                arrayList4 = new ArrayList(treeSet3);
            } catch (Throwable unused2) {
            }
            StringBuilder sb = new StringBuilder("");
            for (int i2 = 0; i2 < arrayList4.size(); i2++) {
                if (i2 != 0) {
                    sb.append(",");
                }
                sb.append(((j) arrayList4.get(i2)).b());
            }
            edit.putString(str3, sb.toString());
        }
        edit.apply();
    }

    public static void b(Context context) {
        context.getSharedPreferences("testJourneyMapSharedPref", 0).edit().clear().apply();
    }

    public static void b(Context context, String str) {
        c(context, str, 0);
    }

    public static void b(Context context, String str, long j) {
        Editor edit = j(context).edit();
        edit.putLong(str + "_LAST_SYNC", j).apply();
    }

    public static void b(Context context, String str, CoreJSONObject coreJSONObject) {
        context.getSharedPreferences("userFrequencyMapSharedPref", 0).edit().putString(str, coreJSONObject.toString()).apply();
    }

    public static void b(Context context, String str, String str2) {
        context.getSharedPreferences("journeyIdJourneyHashMapSharedPref", 0).edit().putString(str, str2).apply();
    }

    public static void b(Context context, String str, Set<String> set) {
        Editor edit = context.getSharedPreferences("jIdPromptIdMapSharedPref", 0).edit();
        edit.putStringSet(str, set);
        edit.apply();
        Editor edit2 = context.getSharedPreferences("promptIdJidMapSharedPref", 0).edit();
        if (set != null) {
            for (String putString : set) {
                edit2.putString(putString, str);
            }
            edit2.apply();
        }
    }

    public static long c(Context context, String str) {
        return context.getSharedPreferences("journeyIdAdMapSharedPref", 0).getLong(str, 1440);
    }

    public static void c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("journeyIdLeadNodeIdMapSharedPref", 0);
            Editor edit = context.getSharedPreferences("journeyIdLeadNodeIdMapCopySharedPref", 0).edit();
            for (String next : d(context)) {
                String string = sharedPreferences.getString(next, null);
                if (string != null) {
                    edit.putString(next, string);
                }
            }
            edit.apply();
        } catch (Throwable unused) {
            HSLLogger.d("Exception caught while creating the copy of journeyIdLeafNodeId Map", LogGroup.PT);
        }
    }

    public static void c(Context context, String str, long j) {
        Editor edit = j(context).edit();
        edit.putLong(str + "_NEXT_SYNC", j).apply();
    }

    public static void c(Context context, String str, String str2) {
        context.getSharedPreferences("configIdjourneyIdMapSharedPref", 0).edit().putString(str, str2).apply();
    }

    public static void c(Context context, String str, Set<String> set) {
        Editor edit = context.getSharedPreferences("jIdViewCreatedMapSharedPref", 0).edit();
        edit.putStringSet(str, set);
        edit.apply();
    }

    public static HashMap<String, Object> d(Context context, String str) {
        SharedPreferences x = x(context, str);
        HashMap<String, Object> hashMap = new HashMap<>();
        Map<String, ?> all = x.getAll();
        if (all == null) {
            return hashMap;
        }
        for (String next : all.keySet()) {
            hashMap.put(next, x.getString(next, null));
        }
        return hashMap;
    }

    public static Set<String> d(Context context) {
        return a(j(context), (String) "journeyIdsListSharedPref");
    }

    public static void d(Context context, String str, long j) {
        Editor edit = j(context).edit();
        edit.putLong(str + "_TTL", j).apply();
    }

    public static void d(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("segmentIdJourneyIdsSharedPref", 0);
        HashSet hashSet = new HashSet(a(sharedPreferences, str));
        hashSet.add(str2);
        sharedPreferences.edit().putStringSet(str, hashSet).apply();
    }

    public static void d(Context context, String str, Set<String> set) {
        context.getSharedPreferences("journeyIdAbEventsMapSharedPref", 0).edit().putStringSet(str, set).apply();
    }

    public static String e(Context context, String str) {
        return context.getSharedPreferences("eventNameIdMapSharedPref", 0).getString(str, null);
    }

    public static HashMap<String, String> e(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("configIdjourneyIdMapSharedPref", 0);
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            HashMap hashMap2 = (HashMap) sharedPreferences.getAll();
            for (String str : hashMap2.keySet()) {
                hashMap.put(str, hashMap2.get(str));
            }
        } catch (Throwable unused) {
        }
        return hashMap;
    }

    public static void e(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("eventIdjourneyIdsMapSharedPref", 0);
        HashSet hashSet = new HashSet(a(sharedPreferences, str));
        hashSet.add(str2);
        sharedPreferences.edit().putStringSet(str, hashSet).apply();
    }

    public static void e(Context context, String str, Set<String> set) {
        context.getSharedPreferences("journeyIdSegmentsMapSharedPref", 0).edit().putStringSet(str, set).apply();
    }

    public static String f(Context context, String str) {
        return a(context.getSharedPreferences("journeyIdJourneyHashMapSharedPref", 0), str, (String) "JourneyHash missing");
    }

    public static HashMap<String, String> f(Context context) {
        HashMap<String, String> hashMap = new HashMap<>();
        SharedPreferences sharedPreferences = context.getSharedPreferences("eventNameIdMapSharedPref", 0);
        Map<String, ?> all = sharedPreferences.getAll();
        if (all == null) {
            return hashMap;
        }
        for (String next : all.keySet()) {
            hashMap.put(next, sharedPreferences.getString(next, null));
        }
        return hashMap;
    }

    public static void f(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("rollOutEventIdjourneyIdsMapSharedPref", 0);
        HashSet hashSet = new HashSet(a(sharedPreferences, str));
        hashSet.add(str2);
        sharedPreferences.edit().putStringSet(str, hashSet).apply();
    }

    public static String g(Context context, String str) {
        return context.getSharedPreferences("configIdjourneyIdMapSharedPref", 0).getString(str, null);
    }

    public static HashMap<String, ArrayList<String>> g(Context context) {
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        SharedPreferences sharedPreferences = context.getSharedPreferences("eventIdjourneyIdsMapSharedPref", 0);
        Map<String, ?> all = sharedPreferences.getAll();
        if (all == null) {
            return hashMap;
        }
        for (String next : all.keySet()) {
            hashMap.put(next, new ArrayList(a(sharedPreferences, next)));
        }
        return hashMap;
    }

    public static void g(Context context, String str, String str2) {
        if (str2 != null) {
            context.getSharedPreferences("journeyIdJourneyNameMapSharedPref", 0).edit().putString(str, str2).apply();
        }
    }

    public static String h(Context context) {
        return j(context).getString("AEP_JOURNEY", null);
    }

    public static Set<String> h(Context context, String str) {
        return a(context.getSharedPreferences("segmentIdJourneyIdsSharedPref", 0), str);
    }

    public static void h(Context context, String str, String str2) {
        context.getSharedPreferences("journeyIdLeadNodeIdMapSharedPref", 0).edit().putString(str, str2).apply();
    }

    public static HashMap<String, ArrayList<String>> i(Context context) {
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        SharedPreferences sharedPreferences = context.getSharedPreferences("rollOutEventIdjourneyIdsMapSharedPref", 0);
        Map<String, ?> all = sharedPreferences.getAll();
        if (all == null) {
            return hashMap;
        }
        for (String next : all.keySet()) {
            hashMap.put(next, new ArrayList(a(sharedPreferences, next)));
        }
        return hashMap;
    }

    public static Set<String> i(Context context, String str) {
        return a(context.getSharedPreferences("eventIdjourneyIdsMapSharedPref", 0), str);
    }

    public static void i(Context context, String str, String str2) {
        Editor edit = j(context).edit();
        edit.putString(str + "_VERSION", str2).apply();
    }

    public static SharedPreferences j(Context context) {
        return context.getSharedPreferences("ujm_cf", 0);
    }

    public static Set<String> j(Context context, String str) {
        return a(context.getSharedPreferences("rollOutEventIdjourneyIdsMapSharedPref", 0), str);
    }

    public static void j(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("eventIdjourneyIdsMapSharedPref", 0);
        HashSet hashSet = new HashSet(a(sharedPreferences, str));
        hashSet.remove(str2);
        sharedPreferences.edit().putStringSet(str, hashSet).apply();
    }

    public static CoreJSONObject k(Context context, String str) {
        try {
            return new CoreJSONObject(context.getSharedPreferences("journeyIdJourneyJsonMapSharedPref", 0).getString(str, ""));
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
            HSLLogger.d("UJSP Data missing:  Unable to find journey JSON for journey Id " + str);
            return null;
        }
    }

    public static void k(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("segmentIdJourneyIdsSharedPref", 0);
        HashSet hashSet = new HashSet(a(sharedPreferences, str));
        hashSet.remove(str2);
        sharedPreferences.edit().putStringSet(str, hashSet).apply();
    }

    public static boolean k(Context context) {
        return j(context).getBoolean("push_initiated", false);
    }

    public static String l(Context context, String str) {
        String a2 = a(context.getSharedPreferences("promptIdJidMapSharedPref", 0), str, "Journey Id is missing.", null);
        if (a2 == null) {
            return null;
        }
        return a(context.getSharedPreferences("journeyIdJourneyNameMapSharedPref", 0), a2, "Journey Name is missing.", null);
    }

    public static void l(Context context) {
        j(context).edit().remove("journeyIdsListSharedPref").apply();
    }

    public static String m(Context context, String str) {
        return a(context.getSharedPreferences("journeyIdLeadNodeIdMapSharedPref", 0), str, (String) "LeafNodeId missing");
    }

    public static void m(Context context) {
        context.getSharedPreferences("eventPromptIdArrSharedPref", 0).edit().clear().apply();
    }

    public static int n(Context context) {
        CoreJSONObject y = y(context, HSLFiltersInternal.getInstance().getUniqueId());
        if (y == null || !y.has(ReactVideoViewManager.PROP_REPEAT) || y.optJSONObject(ReactVideoViewManager.PROP_REPEAT) == null || !y.optJSONObject(ReactVideoViewManager.PROP_REPEAT).has("session") || y.optJSONObject(ReactVideoViewManager.PROP_REPEAT).optString("session") == null) {
            return 1;
        }
        return Integer.parseInt(y.optJSONObject(ReactVideoViewManager.PROP_REPEAT).optString("session"));
    }

    public static String n(Context context, String str) {
        return context.getSharedPreferences("testJourneyMapSharedPref", 0).getString(str, null);
    }

    public static String o(Context context, String str) {
        return context.getSharedPreferences("journeyIdLeadNodeIdMapCopySharedPref", 0).getString(str, null);
    }

    public static long p(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("promptIdPriorityMapSharedPref", 0);
        Map<String, ?> all = sharedPreferences.getAll();
        long j = sharedPreferences.getLong(str, 0);
        if (j == 0 && !all.keySet().contains(str)) {
            String r = r(context, str);
            if (r == null) {
                a(context, 0, str);
                return 0;
            }
            try {
                CoreJSONObject coreJSONObject = new CoreJSONObject(r);
                CoreJSONObject optJSONObject = coreJSONObject.optJSONObject("changes").optJSONObject("prompt");
                if (!h0.b(coreJSONObject)) {
                    j = optJSONObject.optJSONObject("props").optLong("priority", 0);
                }
                a(context, j, str);
                return j;
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return j;
    }

    public static List<String> q(Context context, String str) {
        String string = context.getSharedPreferences("eventPromptIdArrSharedPref", 0).getString(str, "");
        return (string == null || "".equals(string)) ? new ArrayList() : Arrays.asList(string.split(","));
    }

    public static String r(Context context, String str) {
        return context.getSharedPreferences("promptIdPromptJsonMapSharedPref", 0).getString(str, null);
    }

    public static ArrayList<String> s(Context context, String str) {
        return new ArrayList<>(a(context.getSharedPreferences("jIdPromptIdMapSharedPref", 0), str));
    }

    public static long t(Context context, String str) {
        try {
            SharedPreferences j = j(context);
            return j.getLong(str + "_LAST_SYNC", 0);
        } catch (ClassCastException e2) {
            HSLLogger.printStackTrace(e2);
            return 0;
        }
    }

    public static long u(Context context, String str) {
        try {
            SharedPreferences j = j(context);
            return j.getLong(str + "_NEXT_SYNC", 0);
        } catch (ClassCastException e2) {
            HSLLogger.printStackTrace(e2);
            return 0;
        }
    }

    public static long v(Context context, String str) {
        try {
            SharedPreferences j = j(context);
            return j.getLong(str + "_TTL", 0);
        } catch (ClassCastException e2) {
            HSLLogger.printStackTrace(e2);
            return 0;
        }
    }

    public static Set<String> w(Context context, String str) {
        return a(context.getSharedPreferences("journeyIdAbEventsMapSharedPref", 0), str);
    }

    public static SharedPreferences x(Context context, String str) {
        return context.getSharedPreferences("ujm_" + str, 0);
    }

    public static CoreJSONObject y(Context context, String str) {
        try {
            return new CoreJSONObject(context.getSharedPreferences("userFrequencyMapSharedPref", 0).getString(str, ""));
        } catch (CoreJSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String z(Context context, String str) {
        try {
            SharedPreferences j = j(context);
            return j.getString(str + "_VERSION", "");
        } catch (ClassCastException e2) {
            HSLLogger.printStackTrace(e2);
            return "";
        }
    }
}
