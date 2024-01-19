package com.shield.android.e;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.shield.android.ShieldException;
import com.shield.android.ShieldException.Kind;
import com.shield.android.e.e.a;
import com.shield.android.internal.b;
import com.shield.android.internal.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class j extends e {

    /* renamed from: a  reason: collision with root package name */
    public final String f1606a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1607b;

    /* renamed from: c  reason: collision with root package name */
    public final b f1608c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f1609d;

    /* renamed from: e  reason: collision with root package name */
    public final String f1610e;

    /* renamed from: f  reason: collision with root package name */
    public ShieldException f1611f;
    public boolean h = false;

    public j(String str, String str2, String str3, boolean z, b bVar) {
        new HashMap();
        this.f1606a = str;
        this.f1607b = str2;
        this.f1610e = str3;
        this.f1608c = bVar;
        this.h = z;
    }

    public String a() {
        return "STAGING".equalsIgnoreCase(this.f1610e) ? "https://svc-discovery-staging.shield.com" : "https://service-discovery.shield.com";
    }

    public a b() {
        return a.GET;
    }

    public HashMap<String, String> c() {
        HashMap<String, String> hashMap = new HashMap<>();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        hashMap.put("Timestamp", String.valueOf(currentTimeMillis));
        hashMap.put("Site-Id", this.f1606a);
        hashMap.put("Shield-Signature", d.a(Long.valueOf(currentTimeMillis), this.f1606a, this.f1607b));
        return hashMap;
    }

    public Map<String, Object> d() {
        return null;
    }

    public e.b e() {
        return null;
    }

    public String f() {
        return this.f1606a;
    }

    public String g() {
        if (this.h) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("/discovery/v1/endpoint/fallback?sid=%s&created=");
            outline73.append(System.currentTimeMillis());
            return String.format(outline73.toString(), new Object[]{this.f1606a});
        }
        return String.format("/discovery/v1/endpoint?sid=%s", new Object[]{this.f1606a});
    }

    public String h() {
        return null;
    }

    public void a(String str) {
        try {
            this.f1611f = null;
            Object[] objArr = new Object[0];
            if (f.a().f1677b) {
                String.format(str, objArr);
            }
            this.f1609d = new JSONObject(str);
        } catch (Exception e2) {
            this.f1611f = ShieldException.unexpectedError(e2);
        }
    }

    public void a(ShieldException shieldException) {
        if (shieldException.kind == Kind.HTTP) {
            this.f1608c.a(shieldException, "%s - %s", shieldException.message, shieldException.body);
        } else {
            this.f1608c.a(shieldException, shieldException.message, new Object[0]);
        }
        this.f1611f = shieldException;
    }
}
