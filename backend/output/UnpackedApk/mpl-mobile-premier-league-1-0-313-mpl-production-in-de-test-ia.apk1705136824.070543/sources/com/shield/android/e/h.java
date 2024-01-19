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

public class h extends e {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, Object> f1594a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final b f1595b;

    /* renamed from: c  reason: collision with root package name */
    public final d f1596c;

    /* renamed from: d  reason: collision with root package name */
    public final String f1597d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1598e = false;

    /* renamed from: f  reason: collision with root package name */
    public ShieldException f1599f;
    public String g;
    public String h;
    public final String i;

    public h(String str, b bVar, d dVar, String str2) {
        this.f1597d = str;
        this.f1595b = bVar;
        this.f1596c = dVar;
        this.i = str2;
    }

    public String a() {
        return this.g;
    }

    public a b() {
        return a.POST;
    }

    public HashMap<String, String> c() {
        return GeneratedOutlineSupport.outline87("Accept-Encoding", "gzip");
    }

    public Map<String, Object> d() {
        return this.f1594a;
    }

    public e.b e() {
        return e.b.TEXT;
    }

    public String f() {
        return this.f1597d;
    }

    public String g() {
        return "/shield-fp/v1/api/attributes";
    }

    public String h() {
        return this.h;
    }

    public void a(String str) {
        try {
            this.f1599f = null;
            f a2 = f.a();
            a2.a("send attributes: " + str, new Object[0]);
            this.f1598e = new JSONObject(str).getBoolean("status");
        } catch (JSONException e2) {
            this.f1599f = ShieldException.unexpectedError(e2);
            if (f.a().f1677b && e2.getMessage() != null) {
                e2.getLocalizedMessage();
            }
        }
    }

    public void a(ShieldException shieldException) {
        try {
            if (shieldException.kind == Kind.HTTP) {
                b bVar = this.f1595b;
                bVar.a(shieldException, "%s - %s", shieldException.message, shieldException.body);
            } else {
                this.f1595b.a(shieldException, shieldException.message, new Object[0]);
            }
            this.f1599f = shieldException;
        } catch (Exception unused) {
        }
    }
}
