package com.shield.android.e;

import com.shield.android.ShieldException;
import com.shield.android.e.e.a;
import com.shield.android.e.e.b;
import com.shield.android.internal.f;
import java.util.HashMap;
import java.util.Map;

public final class k extends e {

    /* renamed from: a  reason: collision with root package name */
    public final String f1612a;

    /* renamed from: b  reason: collision with root package name */
    public String f1613b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1614c;

    /* renamed from: d  reason: collision with root package name */
    public final String f1615d;

    /* renamed from: e  reason: collision with root package name */
    public String f1616e;

    /* renamed from: f  reason: collision with root package name */
    public int f1617f = 0;

    public k(String str, String str2, String str3) {
        this.f1612a = str3;
        this.f1614c = str;
        this.f1615d = str2;
    }

    public String a() {
        return this.f1616e;
    }

    public void a(String str) {
    }

    public a b() {
        return a.PUT;
    }

    public HashMap<String, String> c() {
        HashMap<String, String> hashMap = new HashMap<>();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        hashMap.put("Timestamp", String.valueOf(currentTimeMillis));
        hashMap.put("Site-Id", this.f1614c);
        hashMap.put("Shield-Signature", d.a(Long.valueOf(currentTimeMillis), this.f1614c, this.f1615d).toLowerCase());
        return hashMap;
    }

    public Map<String, Object> d() {
        return new HashMap();
    }

    public b e() {
        return b.TEXT;
    }

    public String f() {
        return this.f1614c;
    }

    public String g() {
        return String.format("/shield-fp/v1/api/intelligence/%s?recaptcha=%d", new Object[]{this.f1612a, Integer.valueOf(this.f1617f)});
    }

    public String h() {
        return this.f1613b;
    }

    public void a(ShieldException shieldException) {
        if (f.a().f1677b && shieldException.getMessage() != null) {
            shieldException.getLocalizedMessage();
        }
    }
}
