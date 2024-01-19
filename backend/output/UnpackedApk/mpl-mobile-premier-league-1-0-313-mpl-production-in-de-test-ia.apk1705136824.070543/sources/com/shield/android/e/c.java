package com.shield.android.e;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.shield.android.ShieldException;
import com.shield.android.ShieldException.Kind;
import com.shield.android.e.e.a;
import com.shield.android.internal.b;
import com.shield.android.internal.d;
import com.shield.android.internal.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends e {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, Object> f1566a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final b f1567b;

    /* renamed from: c  reason: collision with root package name */
    public final d f1568c;

    /* renamed from: d  reason: collision with root package name */
    public final String f1569d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1570e = false;

    /* renamed from: f  reason: collision with root package name */
    public ShieldException f1571f;
    public String g;
    public String h;
    public final String i;

    public c(String str, String str2, b bVar, d dVar) {
        this.f1569d = str;
        this.f1567b = bVar;
        this.f1568c = dVar;
        this.i = str2;
    }

    public String a() {
        return this.g;
    }

    public a b() {
        return a.POST;
    }

    public HashMap<String, String> c() {
        HashMap<String, String> outline87 = GeneratedOutlineSupport.outline87("Accept-Encoding", "gzip");
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        outline87.put("Timestamp", String.valueOf(currentTimeMillis));
        outline87.put("Site-Id", this.f1569d);
        outline87.put("Shield-Signature", d.a(Long.valueOf(currentTimeMillis), this.f1569d, this.i));
        return outline87;
    }

    public Map<String, Object> d() {
        return this.f1566a;
    }

    public e.b e() {
        return e.b.TEXT;
    }

    public String f() {
        return this.f1569d;
    }

    public String g() {
        return "/shield-fp/v1/mobile/device-attributes";
    }

    public String h() {
        return this.h;
    }

    public void a(String str) {
        try {
            this.f1571f = null;
            f a2 = f.a();
            a2.a("send attributes: " + str, new Object[0]);
            this.f1570e = new JSONObject(str).getBoolean("success");
        } catch (JSONException e2) {
            this.f1571f = ShieldException.unexpectedError(e2);
            if (f.a().f1677b && e2.getMessage() != null) {
                e2.getLocalizedMessage();
            }
        }
    }

    public void a(ShieldException shieldException) {
        try {
            if (shieldException.kind == Kind.HTTP) {
                b bVar = this.f1567b;
                bVar.a(shieldException, "%s - %s", shieldException.message, shieldException.body);
            } else {
                this.f1567b.a(shieldException, shieldException.message, new Object[0]);
            }
            this.f1571f = shieldException;
        } catch (Exception unused) {
        }
    }
}
