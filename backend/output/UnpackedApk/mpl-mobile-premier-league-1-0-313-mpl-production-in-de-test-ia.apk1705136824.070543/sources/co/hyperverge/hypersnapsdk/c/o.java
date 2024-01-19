package co.hyperverge.hypersnapsdk.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import co.hyperverge.hypersnapsdk.f.i;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: SPHelper */
public class o {

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences f3131b;

    /* renamed from: c  reason: collision with root package name */
    public static Editor f3132c;

    /* compiled from: SPHelper */
    public static class a extends TypeToken<HashMap<String, Integer>> {
    }

    public static int a(String str, String str2) {
        int i = 0;
        try {
            String b2 = b(str, str2);
            HashMap<String, Integer> d2 = d();
            if (d2.containsKey(b2)) {
                i = d2.get(b2).intValue();
            }
            return i;
        } catch (Exception e2) {
            i.a((Throwable) e2);
            return 0;
        }
    }

    public static String b(String str, String str2) {
        String[] split = str.split("/");
        String str3 = split[split.length - 1];
        return (str2 == null || str2.trim().isEmpty()) ? str3 : GeneratedOutlineSupport.outline52(str3, "_", str2);
    }

    public static Editor c() {
        if (f3132c == null) {
            f3132c = f3131b.edit();
        }
        return f3132c;
    }

    public static String d(String str, String str2) {
        if (i().trim().isEmpty()) {
            return null;
        }
        HashMap<String, Integer> d2 = d();
        String b2 = b(str, str2);
        boolean containsKey = d2.containsKey(b2);
        Integer valueOf = Integer.valueOf(1);
        if (containsKey) {
            d2.put(b2, Integer.valueOf(d2.get(b2).intValue() + 1));
        } else {
            d2.put(b2, valueOf);
        }
        if (d2.containsKey("totalAttempts")) {
            d2.put("totalAttempts", Integer.valueOf(d2.get("totalAttempts").intValue() + 1));
        } else {
            d2.put("totalAttempts", valueOf);
        }
        String json = new Gson().toJson((Object) d2);
        if (f3131b != null) {
            c().putString(i(), json);
            c().commit();
        }
        return json;
    }

    public static String i() {
        SharedPreferences sharedPreferences = f3131b;
        if (sharedPreferences != null) {
            return sharedPreferences.getString("transactionId", "");
        }
        return "";
    }

    public static JSONObject c(String str, String str2) {
        HashMap<String, Integer> d2 = d();
        JSONObject jSONObject = new JSONObject();
        String b2 = b(str, str2);
        int i = 1;
        int intValue = d2.containsKey("totalAttempts") ? d2.get("totalAttempts").intValue() + 1 : 1;
        if (d2.containsKey(b2)) {
            i = 1 + d2.get(b2).intValue();
        }
        try {
            jSONObject.put("attempts", i);
            jSONObject.put("totalAttempts", intValue);
        } catch (Exception e2) {
            i.a((Throwable) e2);
        }
        return jSONObject;
    }

    public static HashMap<String, Integer> d() {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = f3131b;
        String str = "";
        if (sharedPreferences != null) {
            str = sharedPreferences.getString(i(), str);
        }
        HashMap<String, Integer> hashMap = (HashMap) gson.fromJson(str, new a().getType());
        return hashMap == null ? new HashMap<>() : hashMap;
    }
}
