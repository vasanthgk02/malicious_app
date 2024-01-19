package com.shield.android.e;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.shield.android.ShieldException;
import com.shield.android.ShieldException.Kind;
import com.shield.android.e.e.b;
import com.shield.android.internal.f;
import java.util.HashMap;
import java.util.Map;

public class a extends e {

    /* renamed from: a  reason: collision with root package name */
    public final String f1557a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1558b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1559c;

    /* renamed from: d  reason: collision with root package name */
    public String f1560d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1561e = false;

    /* renamed from: f  reason: collision with root package name */
    public String f1562f;
    public ShieldException g;

    public a(String str, String str2, String str3) {
        this.f1557a = str3;
        this.f1558b = str;
        this.f1559c = str2;
    }

    public String a() {
        return this.f1560d;
    }

    public void a(String str) {
    }

    public com.shield.android.e.e.a b() {
        return com.shield.android.e.e.a.GET;
    }

    public HashMap<String, String> c() {
        HashMap<String, String> hashMap = new HashMap<>();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        hashMap.put("Timestamp", String.valueOf(currentTimeMillis));
        hashMap.put("Site-Id", this.f1558b);
        hashMap.put("Shield-Signature", d.a(Long.valueOf(currentTimeMillis), this.f1558b, this.f1559c));
        return hashMap;
    }

    public Map<String, Object> d() {
        HashMap outline87 = GeneratedOutlineSupport.outline87("platform", "APP");
        outline87.put("sdk", Boolean.TRUE);
        return outline87;
    }

    public b e() {
        return null;
    }

    public String f() {
        return this.f1558b;
    }

    public String g() {
        return String.format("/shield-fp/v1/api/intelligence/%s", new Object[]{this.f1557a});
    }

    public String h() {
        return this.f1562f;
    }

    public void a(ShieldException shieldException) {
        try {
            if (shieldException.kind == Kind.HTTP) {
                f a2 = f.a();
                Object[] objArr = {shieldException.message, shieldException.body};
                if (a2.f1677b) {
                    String.format("%s - %s", objArr);
                }
            } else {
                f a3 = f.a();
                String str = shieldException.message;
                Object[] objArr2 = new Object[0];
                if (a3.f1677b) {
                    String.format(str, objArr2);
                }
            }
            this.g = shieldException;
        } catch (Exception unused) {
        }
    }
}
