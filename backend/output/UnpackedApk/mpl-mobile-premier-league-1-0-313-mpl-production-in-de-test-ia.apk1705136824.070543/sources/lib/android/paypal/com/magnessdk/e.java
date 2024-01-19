package lib.android.paypal.com.magnessdk;

import android.content.Context;
import android.os.Handler;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.BitSet;
import lib.android.paypal.com.magnessdk.network.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e extends b {
    public static BitSet n;
    public static boolean o;
    public static JSONArray p;
    public Context i;
    public MagnesSettings j;
    public JSONObject k;
    public Handler l;
    public boolean m = false;

    public e(MagnesSettings magnesSettings, Handler handler) {
        JSONObject jSONObject;
        Class<e> cls = e.class;
        this.j = magnesSettings;
        Context context = magnesSettings.context;
        this.i = context;
        this.l = handler;
        this.m = magnesSettings.disableRemoteConfig;
        try {
            jSONObject = b.a((String) "REMOTE_CONFIG", context);
            if (jSONObject == null) {
                new a(c$h$d.REMOTE_CONFIG_URL, this.j, this.l, null).a();
            } else if (a(jSONObject.optString(c$e.CONF_VERSION.toString(), ""), "5.0")) {
                boolean a2 = b.a(jSONObject, Long.parseLong(c(this.i, "REMOTE_CONFIG")), c$c.REMOTE);
                if (!this.m && a2) {
                    new a(c$h$d.REMOTE_CONFIG_URL, this.j, this.l, null).a();
                }
                Class<?> cls2 = getClass();
                lib.android.paypal.com.magnessdk.b.a.a(cls2, 0, "Using cached currentConfig due to isRemoteConfigDisabled : " + this.m + " or isConfigExpired : " + a2);
                b(jSONObject);
                this.k = jSONObject;
                lib.android.paypal.com.magnessdk.b.a.a(getClass(), 0, this.k.toString(2));
            } else {
                b.a(this.i, (String) "REMOTE_CONFIG");
            }
        } catch (Exception e2) {
            lib.android.paypal.com.magnessdk.b.a.a(cls, 3, (Throwable) e2);
        }
        lib.android.paypal.com.magnessdk.b.a.a(cls, 0, (String) "entering getDefaultRemoteConfig");
        jSONObject = new JSONObject();
        try {
            jSONObject.put(c$j.CONF_VERSION.toString(), "5.0");
            jSONObject.put(c$j.CONF_REFRESH_TIME_KEY.toString(), 86400);
            jSONObject.put(c$j.CONF_ENDPOINT_URL.toString(), c$h$d.DEVICE_INFO_URL.toString());
        } catch (JSONException e3) {
            lib.android.paypal.com.magnessdk.b.a.a(cls, 3, (Throwable) e3);
        }
        b(jSONObject);
        this.k = jSONObject;
        try {
            lib.android.paypal.com.magnessdk.b.a.a(getClass(), 0, this.k.toString(2));
        } catch (JSONException e4) {
            lib.android.paypal.com.magnessdk.b.a.a(cls, 3, (Throwable) e4);
        }
    }

    public static void b(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray(c$j.NOT_COLLECTABLE.toString());
        if (optJSONArray != null) {
            p = optJSONArray;
        }
        BitSet bitSet = new BitSet(128);
        n = bitSet;
        bitSet.set(0, 128, true);
        int i2 = 0;
        while (optJSONArray != null && i2 < optJSONArray.length()) {
            try {
                n.set(optJSONArray.getInt(i2), false);
            } catch (JSONException e2) {
                lib.android.paypal.com.magnessdk.b.a.a(e.class, 3, (Throwable) e2);
            }
            i2++;
        }
    }

    public boolean a(int i2) {
        return n.get(i2);
    }

    public final boolean a(String str, String str2) {
        Class<e> cls = e.class;
        lib.android.paypal.com.magnessdk.b.a.a(cls, 0, (String) "entering shouldUseCachedConfiguration");
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        lib.android.paypal.com.magnessdk.b.a.a(cls, 0, GeneratedOutlineSupport.outline53("Comparing Cached version is ", str, " default version is ", str2));
        int i2 = 0;
        while (i2 < split.length && i2 < split2.length && split[i2].equals(split2[i2])) {
            i2++;
        }
        return Integer.valueOf(Integer.signum((i2 >= split.length || i2 >= split2.length) ? split.length - split2.length : Integer.valueOf(split[i2]).compareTo(Integer.valueOf(split2[i2])))).intValue() >= 0;
    }
}
