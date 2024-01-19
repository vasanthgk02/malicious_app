package lib.android.paypal.com.magnessdk;

import android.content.Context;
import android.hardware.Sensor;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Base64;
import com.mpl.androidapp.onesignal.OneSingnalConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lib.android.paypal.com.magnessdk.b.a;
import lib.android.paypal.com.magnessdk.c$d.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    public static <T> T a(Object obj, Class<T> cls) {
        if (obj == null || !cls.isAssignableFrom(obj.getClass())) {
            return null;
        }
        return cls.cast(obj);
    }

    public static String a(String str) throws UnsupportedEncodingException {
        return new String(Base64.decode(str, 2), "UTF-8");
    }

    public static String a(boolean z) {
        return z ? UUID.randomUUID().toString() : UUID.randomUUID().toString().replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }

    public static String a(Boolean[] boolArr) {
        String str;
        if (boolArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Boolean bool : boolArr) {
            if (bool.booleanValue()) {
                str = "1";
            } else if (!bool.booleanValue()) {
                str = "0";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static List<String> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(String.valueOf(jSONArray.get(i)));
            }
        }
        return arrayList;
    }

    public static Map<String, String> a(Map<String, String> map, Context context) throws Exception {
        String str = VERSION.RELEASE;
        String str2 = Build.MODEL;
        String packageName = context.getPackageName();
        String str3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        if (!a((Object) "5.1.1.release")) {
            map.put("comp_version", "5.1.1.release");
        }
        if (!a((Object) str)) {
            map.put("os_version", str);
        }
        if (!a((Object) "Android")) {
            map.put("os_type", "Android");
        }
        if (!a((Object) str2)) {
            map.put(OneSingnalConstant.TAG_DEVICE_MODEL, str2);
        }
        if (!a((Object) packageName)) {
            map.put("app_id", packageName);
        }
        if (!a((Object) str3)) {
            map.put("app_version", str3);
        }
        return map;
    }

    public static JSONObject a(Sensor sensor) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(e.f6007c.toString(), sensor.getName());
        jSONObject.put(e.f6010f.toString(), sensor.getVendor());
        jSONObject.put(e.f6008d.toString(), String.format("%.8f", new Object[]{Float.valueOf(sensor.getPower())}));
        jSONObject.put(e.g.toString(), String.valueOf(sensor.getVersion()));
        jSONObject.put(e.f6009e.toString(), String.format("%.8f", new Object[]{Float.valueOf(sensor.getResolution())}));
        jSONObject.put(e.f6006b.toString(), String.format("%.8f", new Object[]{Float.valueOf(sensor.getMaximumRange())}));
        jSONObject.put(e.f6005a.toString(), String.valueOf(sensor.getFifoMaxEventCount()));
        return jSONObject;
    }

    public static void a(Class<?> cls, Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                a.a(cls.getClass(), 3, (Throwable) e2);
            }
        }
    }

    public static boolean a(Object obj) {
        boolean z = true;
        if (obj == null) {
            return true;
        }
        if (obj instanceof String) {
            return ((String) obj).isEmpty();
        }
        if (obj instanceof Long) {
            if (((Long) obj).longValue() != 0) {
                z = false;
            }
            return z;
        }
        if ((obj instanceof Integer) && ((Integer) obj).intValue() != 0) {
            z = false;
        }
        return z;
    }

    public static boolean a(List<String> list, String str) {
        for (String equalsIgnoreCase : list) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
