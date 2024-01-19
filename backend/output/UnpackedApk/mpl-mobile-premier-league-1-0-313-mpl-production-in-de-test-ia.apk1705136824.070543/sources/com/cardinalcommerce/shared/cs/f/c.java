package com.cardinalcommerce.shared.cs.f;

import android.content.Context;
import com.cardinalcommerce.shared.cs.utils.a;
import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public h f2120a;

    /* renamed from: b  reason: collision with root package name */
    public b f2121b;

    public c(Context context) {
        this.f2120a = new h(context);
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f2121b != null) {
                jSONObject.putOpt("BluetoothData", this.f2121b.a());
            }
            if (this.f2120a != null) {
                jSONObject.putOpt("NetworkData", this.f2120a.a());
            }
        } catch (JSONException e2) {
            a.e().b(String.valueOf(13101), e2.getLocalizedMessage(), null);
        }
        return jSONObject;
    }
}
