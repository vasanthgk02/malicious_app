package io.hansel.ujmtracker.n;

import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import java.util.ArrayList;
import java.util.HashMap;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public CoreJSONObject f5401a = new CoreJSONObject();

    private b a(String str, double d2) {
        try {
            this.f5401a.put(str, d2);
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
        return this;
    }

    private b a(String str, String str2) {
        try {
            this.f5401a.put(str, (Object) str2);
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
        return this;
    }

    private b a(String str, boolean z) {
        try {
            this.f5401a.put(str, z);
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
        return this;
    }

    public static b a(HashMap<String, Object> hashMap, String str) {
        String str2;
        b bVar = new b();
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str3 = (String) arrayList.get(i);
            Object obj = hashMap.get(str3);
            if (obj == null || (obj instanceof String)) {
                str2 = obj == null ? null : obj.toString();
            } else if ((obj instanceof Double) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float)) {
                bVar.a(str3, Double.valueOf(obj.toString()).doubleValue());
            } else {
                boolean z = obj instanceof Boolean;
                str2 = obj.toString();
                if (z) {
                    bVar.a(str3, Boolean.valueOf(str2).booleanValue());
                }
            }
            bVar.a(str3, str2);
        }
        bVar.a((String) "_hsl_vendor", str);
        return bVar;
    }

    public CoreJSONObject a() {
        return this.f5401a;
    }
}
