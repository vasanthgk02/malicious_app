package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.SMTEventParamKeys;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.xiaomi.channel.commonutils.android.c;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f4333a;

    /* renamed from: a  reason: collision with other field name */
    public Context f193a;

    /* renamed from: a  reason: collision with other field name */
    public C0067a f194a;

    /* renamed from: a  reason: collision with other field name */
    public String f195a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, C0067a> f196a;

    /* renamed from: com.xiaomi.mipush.sdk.a$a  reason: collision with other inner class name */
    public static class C0067a {

        /* renamed from: a  reason: collision with root package name */
        public int f4334a = 1;

        /* renamed from: a  reason: collision with other field name */
        public Context f197a;

        /* renamed from: a  reason: collision with other field name */
        public String f198a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f199a = true;

        /* renamed from: b  reason: collision with root package name */
        public String f4335b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f200b = false;

        /* renamed from: c  reason: collision with root package name */
        public String f4336c;

        /* renamed from: d  reason: collision with root package name */
        public String f4337d;

        /* renamed from: e  reason: collision with root package name */
        public String f4338e;

        /* renamed from: f  reason: collision with root package name */
        public String f4339f;
        public String g;
        public String h;

        public C0067a(Context context) {
            this.f197a = context;
        }

        public static C0067a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                C0067a aVar = new C0067a(context);
                aVar.f198a = jSONObject.getString(SMTEventParamKeys.SMT_APP_ID);
                aVar.f4335b = jSONObject.getString("appToken");
                aVar.f4336c = jSONObject.getString(SMTPreferenceConstants.OLD_SDK_TOKEN);
                aVar.f4337d = jSONObject.getString("regSec");
                aVar.f4339f = jSONObject.getString("devId");
                aVar.f4338e = jSONObject.getString("vName");
                aVar.f199a = jSONObject.getBoolean("valid");
                aVar.f200b = jSONObject.getBoolean("paused");
                aVar.f4334a = jSONObject.getInt("envType");
                aVar.g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                b.a(th);
                return null;
            }
        }

        private String a() {
            Context context = this.f197a;
            return com.xiaomi.channel.commonutils.android.a.a(context, context.getPackageName());
        }

        public static String a(C0067a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(SMTEventParamKeys.SMT_APP_ID, aVar.f198a);
                jSONObject.put("appToken", aVar.f4335b);
                jSONObject.put(SMTPreferenceConstants.OLD_SDK_TOKEN, aVar.f4336c);
                jSONObject.put("regSec", aVar.f4337d);
                jSONObject.put("devId", aVar.f4339f);
                jSONObject.put("vName", aVar.f4338e);
                jSONObject.put("valid", aVar.f199a);
                jSONObject.put("paused", aVar.f200b);
                jSONObject.put("envType", aVar.f4334a);
                jSONObject.put("regResource", aVar.g);
                return jSONObject.toString();
            } catch (Throwable th) {
                b.a(th);
                return null;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m353a() {
            a.a(this.f197a).edit().clear().commit();
            this.f198a = null;
            this.f4335b = null;
            this.f4336c = null;
            this.f4337d = null;
            this.f4339f = null;
            this.f4338e = null;
            this.f199a = false;
            this.f200b = false;
            this.h = null;
            this.f4334a = 1;
        }

        public void a(int i) {
            this.f4334a = i;
        }

        public void a(String str, String str2) {
            this.f4336c = str;
            this.f4337d = str2;
            this.f4339f = c.e(this.f197a);
            this.f4338e = a();
            this.f199a = true;
        }

        public void a(String str, String str2, String str3) {
            this.f198a = str;
            this.f4335b = str2;
            this.g = str3;
            Editor edit = a.a(this.f197a).edit();
            edit.putString(SMTEventParamKeys.SMT_APP_ID, this.f198a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.f200b = z;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m354a() {
            return a(this.f198a, this.f4335b);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m355a(String str, String str2) {
            boolean equals = TextUtils.equals(this.f198a, str);
            boolean equals2 = TextUtils.equals(this.f4335b, str2);
            boolean z = !TextUtils.isEmpty(this.f4336c);
            boolean z2 = !TextUtils.isEmpty(this.f4337d);
            boolean z3 = TextUtils.equals(this.f4339f, c.e(this.f197a)) || TextUtils.equals(this.f4339f, c.d(this.f197a));
            boolean z4 = equals && equals2 && z && z2 && z3;
            if (!z4) {
                b.e(String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s;did=%s", new Object[]{Boolean.valueOf(equals), Boolean.valueOf(equals2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}));
            }
            return z4;
        }

        public void b() {
            this.f199a = false;
            a.a(this.f197a).edit().putBoolean("valid", this.f199a).commit();
        }

        public void b(String str, String str2, String str3) {
            this.f4336c = str;
            this.f4337d = str2;
            this.f4339f = c.e(this.f197a);
            this.f4338e = a();
            this.f199a = true;
            this.h = str3;
            Editor edit = a.a(this.f197a).edit();
            edit.putString(SMTPreferenceConstants.OLD_SDK_TOKEN, str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f4339f);
            edit.putString("vName", a());
            edit.putBoolean("valid", true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f198a = str;
            this.f4335b = str2;
            this.g = str3;
        }
    }

    public a(Context context) {
        this.f193a = context;
        c();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static a m340a(Context context) {
        if (f4333a == null) {
            synchronized (a.class) {
                if (f4333a == null) {
                    f4333a = new a(context);
                }
            }
        }
        return f4333a;
    }

    private void c() {
        this.f194a = new C0067a(this.f193a);
        this.f196a = new HashMap();
        SharedPreferences a2 = a(this.f193a);
        this.f194a.f198a = a2.getString(SMTEventParamKeys.SMT_APP_ID, null);
        this.f194a.f4335b = a2.getString("appToken", null);
        this.f194a.f4336c = a2.getString(SMTPreferenceConstants.OLD_SDK_TOKEN, null);
        this.f194a.f4337d = a2.getString("regSec", null);
        this.f194a.f4339f = a2.getString("devId", null);
        if (!TextUtils.isEmpty(this.f194a.f4339f) && c.a(this.f194a.f4339f)) {
            this.f194a.f4339f = c.e(this.f193a);
            a2.edit().putString("devId", this.f194a.f4339f).commit();
        }
        this.f194a.f4338e = a2.getString("vName", null);
        this.f194a.f199a = a2.getBoolean("valid", true);
        this.f194a.f200b = a2.getBoolean("paused", false);
        this.f194a.f4334a = a2.getInt("envType", 1);
        this.f194a.g = a2.getString("regResource", null);
        this.f194a.h = a2.getString("appRegion", null);
    }

    public int a() {
        return this.f194a.f4334a;
    }

    public C0067a a(String str) {
        if (this.f196a.containsKey(str)) {
            return this.f196a.get(str);
        }
        String outline50 = GeneratedOutlineSupport.outline50("hybrid_app_info_", str);
        SharedPreferences a2 = a(this.f193a);
        if (!a2.contains(outline50)) {
            return null;
        }
        C0067a a3 = C0067a.a(this.f193a, a2.getString(outline50, ""));
        this.f196a.put(outline50, a3);
        return a3;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m341a() {
        return this.f194a.f198a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m342a() {
        this.f194a.a();
    }

    public void a(int i) {
        this.f194a.a(i);
        a(this.f193a).edit().putInt("envType", i).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m343a(String str) {
        Editor edit = a(this.f193a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f194a.f4338e = str;
    }

    public void a(String str, C0067a aVar) {
        this.f196a.put(str, aVar);
        String a2 = C0067a.a(aVar);
        a(this.f193a).edit().putString(GeneratedOutlineSupport.outline50("hybrid_app_info_", str), a2).commit();
    }

    public void a(String str, String str2, String str3) {
        this.f194a.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.f194a.a(z);
        a(this.f193a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m344a() {
        Context context = this.f193a;
        return !TextUtils.equals(com.xiaomi.channel.commonutils.android.a.a(context, context.getPackageName()), this.f194a.f4338e);
    }

    public boolean a(String str, String str2) {
        return this.f194a.a(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m345a(String str, String str2, String str3) {
        C0067a a2 = a(str3);
        return a2 != null && TextUtils.equals(str, a2.f198a) && TextUtils.equals(str2, a2.f4335b);
    }

    public String b() {
        return this.f194a.f4335b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m346b() {
        this.f194a.b();
    }

    public void b(String str) {
        this.f196a.remove(str);
        a(this.f193a).edit().remove("hybrid_app_info_" + str).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f194a.b(str, str2, str3);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m347b() {
        if (this.f194a.a()) {
            return true;
        }
        b.a((String) "Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m348c() {
        return this.f194a.f4336c;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m349c() {
        return this.f194a.a();
    }

    public String d() {
        return this.f194a.f4337d;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m350d() {
        return !TextUtils.isEmpty(this.f194a.f198a) && !TextUtils.isEmpty(this.f194a.f4335b) && !TextUtils.isEmpty(this.f194a.f4336c) && !TextUtils.isEmpty(this.f194a.f4337d);
    }

    public String e() {
        return this.f194a.g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m351e() {
        return this.f194a.f200b;
    }

    public String f() {
        return this.f194a.h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m352f() {
        return !this.f194a.f199a;
    }
}
