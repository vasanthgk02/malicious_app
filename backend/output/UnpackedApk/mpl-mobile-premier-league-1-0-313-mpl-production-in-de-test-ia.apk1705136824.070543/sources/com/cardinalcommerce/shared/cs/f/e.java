package com.cardinalcommerce.shared.cs.f;

import android.location.Location;
import com.cardinalcommerce.shared.cs.utils.a;
import com.cardinalcommerce.shared.cs.utils.h;
import org.json.JSONException;
import org.json.JSONObject;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public char[] f2128a;

    /* renamed from: b  reason: collision with root package name */
    public char[] f2129b;

    public e() {
    }

    public e(Location location) {
        this.f2128a = h.a(String.valueOf(location.getLatitude()));
        this.f2129b = h.a(String.valueOf(location.getLongitude()));
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("Latitude", h.b(this.f2128a));
            jSONObject.putOpt("Longitude", h.b(this.f2129b));
        } catch (JSONException e2) {
            a.e().b(String.valueOf(13101), e2.getLocalizedMessage(), null);
        }
        return jSONObject;
    }
}
