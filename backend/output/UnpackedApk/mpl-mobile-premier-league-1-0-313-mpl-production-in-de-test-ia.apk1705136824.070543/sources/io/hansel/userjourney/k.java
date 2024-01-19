package io.hansel.userjourney;

import android.content.Context;
import io.hansel.userjourney.models.PromptGoalEventInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class k {
    private void a(Context context, HashMap<String, PromptGoalEventInfo> hashMap) {
        Iterator it = new HashSet(hashMap.keySet()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!a(context, str, hashMap.get(str).getAttributionDurationMillis())) {
                hashMap.remove(str);
            }
        }
    }

    private void a(HashMap<String, PromptGoalEventInfo> hashMap, HashMap<String, ?> hashMap2) {
        Iterator it = new HashSet(hashMap.keySet()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!a(str, hashMap.get(str).getAttributionDurationMillis(), hashMap2)) {
                hashMap.remove(str);
            }
        }
    }

    private boolean a(Context context, String str, long j) {
        long b2 = io.hansel.segments.k.b(context, str);
        boolean z = false;
        if (b2 == -1) {
            return false;
        }
        if (System.currentTimeMillis() - b2 <= j) {
            z = true;
        }
        return z;
    }

    private boolean a(String str, long j, HashMap<String, ?> hashMap) {
        Object obj = hashMap.get(str);
        long longValue = obj instanceof Long ? ((Long) obj).longValue() : -1;
        boolean z = false;
        if (longValue == -1) {
            return false;
        }
        if (System.currentTimeMillis() - longValue <= j) {
            z = true;
        }
        return z;
    }

    public HashMap<String, PromptGoalEventInfo> a(Context context, String str, String str2) {
        HashMap<String, HashMap<String, PromptGoalEventInfo>> b2 = j.b(context, str);
        HashMap<String, PromptGoalEventInfo> hashMap = new HashMap<>();
        if (b2 == null || !b2.containsKey(str2)) {
            return hashMap;
        }
        HashMap<String, PromptGoalEventInfo> hashMap2 = b2.get(str2);
        a(context, hashMap2);
        return hashMap2;
    }

    public HashMap<String, PromptGoalEventInfo> a(String str, HashMap<String, HashMap<String, PromptGoalEventInfo>> hashMap, HashMap<String, ?> hashMap2) {
        HashMap<String, PromptGoalEventInfo> hashMap3 = new HashMap<>();
        if (hashMap == null || !hashMap.containsKey(str)) {
            return hashMap3;
        }
        HashMap<String, PromptGoalEventInfo> hashMap4 = hashMap.get(str);
        a(hashMap4, hashMap2);
        return hashMap4;
    }
}
