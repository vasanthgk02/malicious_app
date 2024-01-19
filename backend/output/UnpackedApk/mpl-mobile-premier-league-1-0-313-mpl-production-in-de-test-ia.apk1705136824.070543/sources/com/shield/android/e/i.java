package com.shield.android.e;

import com.mpl.androidapp.login.LoginReactModule;
import com.paynimo.android.payment.util.Constant;
import com.shield.android.ShieldException;
import com.shield.android.ShieldException.Kind;
import com.shield.android.e.e.a;
import com.shield.android.internal.b;
import com.shield.android.internal.c;
import com.shield.android.internal.d;
import com.shield.android.internal.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class i extends e {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, Object> f1600a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final b f1601b;

    /* renamed from: c  reason: collision with root package name */
    public final d f1602c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f1603d = new JSONObject();

    /* renamed from: e  reason: collision with root package name */
    public c f1604e;

    /* renamed from: f  reason: collision with root package name */
    public ShieldException f1605f;
    public final String g;
    public String h;
    public final HashMap<String, String> i;
    public final String j;
    public String k;

    public i(String str, String str2, b bVar, d dVar, String str3) {
        HashMap<String, String> hashMap = new HashMap<>();
        this.i = hashMap;
        this.j = str;
        this.f1601b = bVar;
        this.f1602c = dVar;
        this.g = str3;
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("SESSION_ID", str2);
    }

    public String a() {
        return this.h;
    }

    public a b() {
        return a.POST;
    }

    public HashMap<String, String> c() {
        return this.i;
    }

    public Map<String, Object> d() {
        return this.f1600a;
    }

    public e.b e() {
        return e.b.TEXT;
    }

    public String f() {
        return this.j;
    }

    public String g() {
        return String.format("/wfp/%s", new Object[]{"send-event.php"}).toLowerCase();
    }

    public String h() {
        return this.k;
    }

    public void a(ShieldException shieldException) {
        if (shieldException.kind == Kind.HTTP) {
            this.f1601b.a(shieldException, "%s - %s", shieldException.message, shieldException.body);
        } else {
            this.f1601b.a(shieldException, shieldException.message, new Object[0]);
        }
        this.f1605f = shieldException;
    }

    public void a(String str) {
        try {
            this.f1605f = null;
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.getBoolean("status");
            String optString = jSONObject.optString("code", "");
            if (this.f1604e == null) {
                this.f1604e = new c();
            }
            boolean optBoolean = jSONObject.optBoolean("auto_block", this.f1604e.f1669a);
            boolean optBoolean2 = jSONObject.optBoolean("auto_captcha", this.f1604e.f1670b);
            boolean optBoolean3 = jSONObject.optBoolean("callback", this.f1604e.f1671c);
            long optLong = jSONObject.optLong("feature_version", this.f1604e.f1672d);
            c cVar = this.f1604e;
            cVar.f1669a = optBoolean;
            cVar.f1670b = optBoolean2;
            cVar.f1671c = optBoolean3;
            cVar.f1672d = optLong;
            if (optString.equals(Constant.TRANSACTION_SUBTYPE_IFSC)) {
                this.f1603d = jSONObject.optJSONObject(LoginReactModule.RESULT);
            } else {
                this.f1605f = ShieldException.unexpectedError(new Throwable(jSONObject.optString("message")));
            }
        } catch (JSONException e2) {
            this.f1605f = ShieldException.unexpectedError(e2);
            if (f.a().f1677b && e2.getMessage() != null) {
                e2.getLocalizedMessage();
            }
        }
    }
}
