package com.cardinalcommerce.shared.cs.f;

import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import com.cardinalcommerce.shared.cs.utils.a;
import com.cardinalcommerce.shared.cs.utils.h;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class i implements Serializable {
    public static final char[] j = h.a((String) "Android");

    /* renamed from: a  reason: collision with root package name */
    public char[] f2140a = ((char[]) j.clone());

    /* renamed from: b  reason: collision with root package name */
    public char[] f2141b = h.a(VERSION.RELEASE);

    /* renamed from: c  reason: collision with root package name */
    public char[] f2142c = h.a(String.valueOf(VERSION.SDK_INT));

    /* renamed from: d  reason: collision with root package name */
    public char[] f2143d = h.a(VERSION_CODES.class.getFields()[VERSION.SDK_INT].getName());

    /* renamed from: e  reason: collision with root package name */
    public char[] f2144e = h.a(VERSION.CODENAME);

    /* renamed from: f  reason: collision with root package name */
    public char[] f2145f = h.a(VERSION.INCREMENTAL);
    public int g;
    public int h;
    public char[] i;

    public i() {
        if (VERSION.SDK_INT >= 23) {
            this.g = VERSION.PREVIEW_SDK_INT;
        }
        int i2 = VERSION.SDK_INT;
        this.h = i2;
        if (i2 >= 23) {
            this.i = h.a(VERSION.SECURITY_PATCH);
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ApiVersion", h.b(this.f2142c));
            jSONObject.putOpt("CodeName", h.b(this.f2144e));
            jSONObject.putOpt("Incremental", h.b(this.f2145f));
            jSONObject.putOpt("OsName", h.b(this.f2143d));
            jSONObject.putOpt("PreviewSdkInt", Integer.valueOf(this.g));
            jSONObject.putOpt("SdkInt", Integer.valueOf(this.h));
            jSONObject.putOpt("SecurityPatch", h.b(this.i));
            jSONObject.putOpt("Type", h.b(this.f2140a));
            jSONObject.putOpt("Version", h.b(this.f2141b));
        } catch (JSONException e2) {
            a.e().b(String.valueOf(13101), e2.getLocalizedMessage(), null);
        }
        return jSONObject;
    }
}
