package io.hansel.diagnostics;

import io.hansel.core.logger.HSLLogger;
import org.json.JSONObject;

public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f5226c = new a();

    /* renamed from: a  reason: collision with root package name */
    public c f5227a;

    /* renamed from: b  reason: collision with root package name */
    public String f5228b;

    /* renamed from: io.hansel.diagnostics.a$a  reason: collision with other inner class name */
    public enum C0079a {
        DEVICE_INFO
    }

    public static a a() {
        return f5226c;
    }

    public String a(String str) {
        try {
            String b2 = this.f5227a.b(str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("d", b2);
            jSONObject.put("i", this.f5228b);
            return jSONObject.toString();
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
            return null;
        }
    }

    public void a(String str, String str2) {
        this.f5228b = str;
        this.f5227a = new c(str, str2);
    }

    public String b(String str) {
        try {
            return this.f5227a.a(str);
        } catch (Throwable th) {
            HSLLogger.i("Message from unknown diagnostic appnull");
            HSLLogger.printStackTrace(th);
            return null;
        }
    }
}
