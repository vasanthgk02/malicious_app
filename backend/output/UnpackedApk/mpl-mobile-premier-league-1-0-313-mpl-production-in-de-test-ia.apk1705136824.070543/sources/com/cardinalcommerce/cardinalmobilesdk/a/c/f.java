package com.cardinalcommerce.cardinalmobilesdk.a.c;

import android.util.Base64;
import co.hyperverge.hypersnapsdk.c.k;
import com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse;
import com.cardinalcommerce.shared.cs.e.b;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f1884a;

    /* renamed from: b  reason: collision with root package name */
    public String f1885b;

    /* renamed from: c  reason: collision with root package name */
    public String f1886c;

    /* renamed from: d  reason: collision with root package name */
    public ValidateResponse f1887d;

    /* renamed from: e  reason: collision with root package name */
    public b f1888e;

    /* renamed from: f  reason: collision with root package name */
    public int f1889f;
    public boolean g;

    public f(String str) {
        String optString = new JSONObject(k.a(str)).optString("Payload", "");
        if (optString != null && !optString.equalsIgnoreCase("")) {
            JSONObject jSONObject = new JSONObject(optString);
            this.g = jSONObject.optBoolean("Successful", false);
            this.f1889f = jSONObject.optInt("ErrorNumber", 0);
            this.f1884a = jSONObject.optString("ErrorDescription", "");
            String optString2 = jSONObject.optString("CRes", "");
            this.f1885b = optString2;
            if (optString2 != null && !optString2.equalsIgnoreCase("")) {
                this.f1888e = new b(new String(Base64.decode(this.f1885b, 0), StandardCharsets.UTF_8));
            }
            String optString3 = jSONObject.optString("ValidateResponse", "");
            this.f1886c = optString3;
            if (optString3 != null && !optString3.equalsIgnoreCase("")) {
                this.f1887d = new ValidateResponse(this.f1886c);
            }
        }
    }
}
