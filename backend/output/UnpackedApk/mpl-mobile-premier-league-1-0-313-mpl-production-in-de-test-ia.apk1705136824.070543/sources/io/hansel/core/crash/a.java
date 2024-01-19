package io.hansel.core.crash;

import com.netcore.android.SMTConfigConstants;
import com.razorpay.AnalyticsConstants;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f5120a;

    /* renamed from: b  reason: collision with root package name */
    public String f5121b;

    /* renamed from: c  reason: collision with root package name */
    public String f5122c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5123d;

    /* renamed from: e  reason: collision with root package name */
    public C0073a f5124e = C0073a.UNKNOWN;

    /* renamed from: f  reason: collision with root package name */
    public int f5125f;
    public long g;
    public long h;
    public b i = b.UNKNOWN;
    public long j;
    public String k;
    public String l;

    /* renamed from: io.hansel.core.crash.a$a  reason: collision with other inner class name */
    public enum C0073a {
        WIFI(AnalyticsConstants.WIFI),
        CELLULAR(AnalyticsConstants.CELLULAR),
        NONE("none"),
        UNKNOWN("unknown");
        

        /* renamed from: a  reason: collision with root package name */
        public String f5131a;

        /* access modifiers changed from: public */
        C0073a(String str) {
            this.f5131a = str;
        }

        public static C0073a a(String str) {
            if (str != null) {
                C0073a aVar = WIFI;
                if (str.equals(aVar.a())) {
                    return aVar;
                }
                C0073a aVar2 = CELLULAR;
                if (str.equals(aVar2.a())) {
                    return aVar2;
                }
                C0073a aVar3 = NONE;
                if (str.equals(aVar3.a())) {
                    return aVar3;
                }
            }
            return UNKNOWN;
        }

        public String a() {
            return this.f5131a;
        }
    }

    public enum b {
        UNKNOWN("unknown", 0),
        PROTRAIT(SMTConfigConstants.SCREEN_ORIENTATION_PORTRAIT, 1),
        LANDSCAPE(SMTConfigConstants.SCREEN_ORIENTATION_LANDSCAPE, 2);
        

        /* renamed from: a  reason: collision with root package name */
        public String f5136a;

        /* access modifiers changed from: public */
        b(String str, int i) {
            this.f5136a = str;
        }

        public static b a(String str) {
            if (str != null) {
                b bVar = PROTRAIT;
                if (str.equals(bVar.f5136a)) {
                    return bVar;
                }
                b bVar2 = LANDSCAPE;
                if (str.equals(bVar2.f5136a)) {
                    return bVar2;
                }
            }
            return UNKNOWN;
        }

        public String a() {
            return this.f5136a;
        }
    }

    public a() {
    }

    public a(String str) {
        a(str);
    }

    public String a() {
        return this.k;
    }

    public void a(int i2) {
        this.f5125f = i2;
    }

    public void a(long j2) {
        this.j = j2;
    }

    public void a(C0073a aVar) {
        this.f5124e = aVar;
    }

    public void a(b bVar) {
        this.i = bVar;
    }

    public void a(String str) {
        try {
            CoreJSONObject coreJSONObject = new CoreJSONObject(str);
            a(coreJSONObject.optLong("event_time"));
            f(coreJSONObject.optString("title"));
            c(coreJSONObject.optString("description"));
            e(coreJSONObject.optString("trace"));
            a(coreJSONObject.optBoolean("isConnected"));
            a(C0073a.a(coreJSONObject.optString("connection_type")));
            a(coreJSONObject.optInt("battery_level"));
            b(coreJSONObject.optLong("free_disk_space"));
            c(coreJSONObject.optLong("total_disk_space"));
            a(b.a(coreJSONObject.optString("orientation")));
            d(coreJSONObject.optString("os_version"));
            b(coreJSONObject.optString("imagesFolder", null));
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
    }

    public void a(boolean z) {
        this.f5123d = z;
    }

    public CoreJSONObject b() {
        try {
            CoreJSONObject c2 = c();
            c2.put((String) "imagesFolder", (Object) a());
            return c2;
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
            return null;
        }
    }

    public void b(long j2) {
        this.g = j2;
    }

    public void b(String str) {
        this.k = str;
    }

    public CoreJSONObject c() {
        CoreJSONObject coreJSONObject = new CoreJSONObject();
        try {
            coreJSONObject.put((String) "event_time", this.j);
            String str = this.f5120a;
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            coreJSONObject.put((String) "title", (Object) str);
            String str3 = this.f5121b;
            if (str3 == null) {
                str3 = str2;
            }
            coreJSONObject.put((String) "description", (Object) str3);
            String str4 = this.f5122c;
            if (str4 != null) {
                str2 = str4;
            }
            coreJSONObject.put((String) "trace", (Object) str2);
            coreJSONObject.put((String) "isConnected", this.f5123d);
            coreJSONObject.put((String) "connection_type", (Object) this.f5124e.a());
            coreJSONObject.put((String) "battery_level", this.f5125f);
            coreJSONObject.put((String) "free_disk_space", this.g);
            coreJSONObject.put((String) "total_disk_space", this.h);
            coreJSONObject.put((String) "orientation", (Object) this.i.a());
            coreJSONObject.put((String) "os_version", (Object) this.l);
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
        }
        return coreJSONObject;
    }

    public void c(long j2) {
        this.h = j2;
    }

    public void c(String str) {
        this.f5121b = str;
    }

    public void d(String str) {
        this.l = str;
    }

    public void e(String str) {
        this.f5122c = str;
    }

    public void f(String str) {
        this.f5120a = str;
    }

    public String toString() {
        return b().toString();
    }
}
