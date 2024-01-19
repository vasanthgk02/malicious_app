package io.hansel.userjourney.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import com.paynimo.android.payment.UPIFragment;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import java.util.ArrayList;
import java.util.HashMap;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f5439a;

    /* renamed from: b  reason: collision with root package name */
    public String f5440b;

    /* renamed from: c  reason: collision with root package name */
    public long f5441c;

    /* renamed from: d  reason: collision with root package name */
    public String f5442d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, Object> f5443e;

    /* renamed from: f  reason: collision with root package name */
    public CoreJSONObject f5444f;

    public b(String str, String str2, long j, String str3, String str4, CoreJSONObject coreJSONObject) {
        this.f5439a = str;
        this.f5440b = str2;
        this.f5441c = j;
        this.f5442d = str4;
        this.f5444f = coreJSONObject;
    }

    public b(String str, String str2, HashMap<String, Object> hashMap) {
        this.f5439a = str;
        this.f5440b = str2;
        this.f5443e = hashMap;
    }

    public static String a(String str, String str2) {
        return GeneratedOutlineSupport.outline50(str, str2);
    }

    public String a() {
        return this.f5439a;
    }

    public CoreJSONObject b() {
        return this.f5444f;
    }

    public HashMap<String, Object> c() {
        return this.f5443e;
    }

    public CoreJSONArray d() {
        String str;
        CoreJSONArray coreJSONArray = new CoreJSONArray();
        HashMap<String, Object> hashMap = this.f5443e;
        if (hashMap == null) {
            return coreJSONArray;
        }
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str2 = (String) arrayList.get(i);
            try {
                CoreJSONObject coreJSONObject = new CoreJSONObject();
                coreJSONObject.put((String) "id", (Object) str2);
                Object obj = this.f5443e.get(str2);
                if (obj instanceof Boolean) {
                    str = "boolean";
                } else {
                    if (!(obj instanceof Integer) && !(obj instanceof Double) && !(obj instanceof Long)) {
                        if (!(obj instanceof Float)) {
                            str = NetworkingModule.REQUEST_BODY_KEY_STRING;
                        }
                    }
                    str = UPIFragment.CONFIG_TYPE_NUMBER;
                }
                coreJSONObject.put((String) "type", (Object) str);
                coreJSONArray.put((Object) coreJSONObject);
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return coreJSONArray;
    }

    public long e() {
        return this.f5441c;
    }

    public String f() {
        return this.f5442d;
    }

    public String g() {
        return this.f5440b;
    }
}
