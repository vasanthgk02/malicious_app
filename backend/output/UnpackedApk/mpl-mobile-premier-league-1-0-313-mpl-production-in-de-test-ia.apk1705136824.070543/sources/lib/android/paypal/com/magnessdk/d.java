package lib.android.paypal.com.magnessdk;

import android.content.Context;
import android.os.Handler;
import com.android.tools.r8.GeneratedOutlineSupport;
import lib.android.paypal.com.magnessdk.network.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends b {

    /* renamed from: e  reason: collision with root package name */
    public Context f6099e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f6100f;
    public MagnesSettings g;
    public JSONObject h;

    public d(MagnesSettings magnesSettings, Handler handler) {
        JSONObject jSONObject;
        c$i.CONF_REFRESH_TIME_KEY.toString();
        Context context = magnesSettings.context;
        this.f6099e = context;
        this.g = magnesSettings;
        this.f6100f = handler;
        try {
            jSONObject = b.a((String) "RAMP_CONFIG", context);
            if (jSONObject == null) {
                new a(c$h$d.RAMP_CONFIG_URL, this.g, this.f6100f, null).a();
                jSONObject = a();
            } else if (b.a(jSONObject, Long.parseLong(c(this.f6099e, "RAMP_CONFIG")), c$c.RAMP)) {
                lib.android.paypal.com.magnessdk.b.a.a(getClass(), 0, (String) "Cached config used while fetching.");
                new a(c$h$d.RAMP_CONFIG_URL, this.g, this.f6100f, null).a();
            }
        } catch (Exception e2) {
            lib.android.paypal.com.magnessdk.b.a.a(d.class, 3, (Throwable) e2);
            jSONObject = a();
        }
        this.h = jSONObject;
        try {
            lib.android.paypal.com.magnessdk.b.a.a(getClass(), 0, this.h.toString(2));
        } catch (JSONException unused) {
        }
    }

    public JSONObject a() {
        Class<d> cls = d.class;
        lib.android.paypal.com.magnessdk.b.a.a(cls, 0, (String) "entering getDefaultConfig");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", e());
            jSONObject.put("hw", e());
            jSONObject.put("ts", e());
            jSONObject.put("td", e());
            jSONObject.put(c$i.CONF_REFRESH_TIME_KEY.toString(), 7200);
        } catch (JSONException e2) {
            lib.android.paypal.com.magnessdk.b.a.a(cls, 3, (Throwable) e2);
        }
        return jSONObject;
    }

    public final JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(c$i.OPEN.toString(), false);
            jSONObject.put(c$i.RAMP_THRESHOLD.toString(), 0);
            jSONObject.put(c$i.MIN_VERSION.toString(), "4.4.0");
            jSONObject.put(c$i.EXCLUDED.toString(), new JSONArray());
            jSONObject.put(c$i.APP_IDS.toString(), new JSONArray());
            jSONObject.put(c$i.APP_SOURCES.toString(), new JSONArray());
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failed to create deafult config due to ");
            outline73.append(e2.getLocalizedMessage());
            lib.android.paypal.com.magnessdk.b.a.a(d.class, 3, outline73.toString());
        }
        return jSONObject;
    }
}
