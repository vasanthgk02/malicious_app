package lib.android.paypal.com.magnessdk;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import lib.android.paypal.com.magnessdk.a.c;
import lib.android.paypal.com.magnessdk.b.a;
import org.json.JSONObject;

public abstract class b {
    public static JSONObject a(String str, Context context) {
        Class<b> cls = b.class;
        a.a(cls, 0, (String) "entering getCachedConfig");
        try {
            a.a(cls, 0, (String) "Loading loadCachedConfigData");
            File filesDir = context.getFilesDir();
            String a2 = c.a(new File(filesDir, str + "_DATA"));
            if (!a2.isEmpty()) {
                a.a(cls, 0, (String) "leaving getCachedConfig,cached config loadsuccessfully");
                return new JSONObject(a2);
            }
            a.a(cls, 0, (String) "leaving getCachedConfig,cached config loaded empty");
            return null;
        } catch (Exception e2) {
            a.a(cls, 3, (Throwable) e2);
        }
    }

    public static void a(Context context, String str, String str2) {
        a.a(b.class, 0, (String) "entering saveConfigData");
        File file = new File(context.getFilesDir(), GeneratedOutlineSupport.outline50(str2, "_DATA"));
        File file2 = new File(context.getFilesDir(), GeneratedOutlineSupport.outline50(str2, "_TIME"));
        c.a(file, str);
        c.a(file2, String.valueOf(System.currentTimeMillis()));
    }

    public static boolean a(Context context, String str) {
        a.a(b.class, 0, (String) "entering deleteCachedConfigDataFromDisk");
        return c.c(new File(context.getFilesDir(), GeneratedOutlineSupport.outline50(str, "_DATA"))) && c.c(new File(context.getFilesDir(), GeneratedOutlineSupport.outline50(str, "_TIME")));
    }

    public static boolean a(JSONObject jSONObject, long j, c$c c_c) {
        return System.currentTimeMillis() > (jSONObject.optLong(c_c == c$c.RAMP ? c$i.g.toString() : c_c == c$c.REMOTE ? c$j.CONF_REFRESH_TIME_KEY.toString() : "", 0) * 1000) + j;
    }

    public String c(Context context, String str) {
        a.a(getClass(), 0, (String) "Loading loadCachedConfigTime");
        return c.a(new File(context.getFilesDir(), GeneratedOutlineSupport.outline50(str, "_TIME")));
    }
}
