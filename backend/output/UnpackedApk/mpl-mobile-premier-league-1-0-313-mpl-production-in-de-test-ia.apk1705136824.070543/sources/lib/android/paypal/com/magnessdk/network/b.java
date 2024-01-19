package lib.android.paypal.com.magnessdk.network;

import android.os.Build.VERSION;
import android.os.Handler;
import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.InflateView;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import lib.android.paypal.com.magnessdk.Environment;
import lib.android.paypal.com.magnessdk.MagnesSDK;
import lib.android.paypal.com.magnessdk.MagnesSettings;
import lib.android.paypal.com.magnessdk.b.a;
import lib.android.paypal.com.magnessdk.c$d;
import lib.android.paypal.com.magnessdk.c$h$d;
import lib.android.paypal.com.magnessdk.c$j;
import lib.android.paypal.com.magnessdk.network.base.MagnesNetworkingFactoryImpl;
import lib.android.paypal.com.magnessdk.network.base.c;
import org.json.JSONObject;

public class b extends c {

    /* renamed from: b  reason: collision with root package name */
    public c$h$d f6119b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f6120c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public Handler f6121d;

    /* renamed from: e  reason: collision with root package name */
    public MagnesNetworkingFactoryImpl f6122e;

    /* renamed from: f  reason: collision with root package name */
    public MagnesSettings f6123f;
    public JSONObject h;
    public boolean i;

    /* renamed from: lib.android.paypal.com.magnessdk.network.b$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6124a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|(2:1|2)|3|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0026 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001d */
        static {
            /*
                lib.android.paypal.com.magnessdk.c$h$d[] r0 = lib.android.paypal.com.magnessdk.c$h$d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6124a = r0
                lib.android.paypal.com.magnessdk.c$h$d r1 = lib.android.paypal.com.magnessdk.c$h$d.DEVICE_INFO_URL     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r0 = 6
                int[] r1 = f6124a     // Catch:{ NoSuchFieldError -> 0x0016 }
                lib.android.paypal.com.magnessdk.c$h$d r2 = lib.android.paypal.com.magnessdk.c$h$d.SANDBOX_DEVICE_INFO_URL     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = f6124a     // Catch:{ NoSuchFieldError -> 0x001d }
                lib.android.paypal.com.magnessdk.c$h$d r2 = lib.android.paypal.com.magnessdk.c$h$d.PRODUCTION_JSON_URL     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r2] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r1 = f6124a     // Catch:{ NoSuchFieldError -> 0x0026 }
                lib.android.paypal.com.magnessdk.c$h$d r2 = lib.android.paypal.com.magnessdk.c$h$d.STAGE_PROD_JSON_URL     // Catch:{ NoSuchFieldError -> 0x0026 }
                r2 = 10
                r3 = 4
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0026 }
            L_0x0026:
                int[] r1 = f6124a     // Catch:{ NoSuchFieldError -> 0x002e }
                lib.android.paypal.com.magnessdk.c$h$d r2 = lib.android.paypal.com.magnessdk.c$h$d.AUDIT_JSON_URL     // Catch:{ NoSuchFieldError -> 0x002e }
                r2 = 0
                r3 = 5
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = f6124a     // Catch:{ NoSuchFieldError -> 0x0036 }
                lib.android.paypal.com.magnessdk.c$h$d r2 = lib.android.paypal.com.magnessdk.c$h$d.STAGE_AUDIT_JSON_URL     // Catch:{ NoSuchFieldError -> 0x0036 }
                r2 = 9
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0036 }
            L_0x0036:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: lib.android.paypal.com.magnessdk.network.b.AnonymousClass1.<clinit>():void");
        }
    }

    public b(c$h$d c_h_d, JSONObject jSONObject, boolean z, MagnesSettings magnesSettings, Handler handler) {
        this.f6119b = c_h_d;
        this.h = jSONObject;
        this.i = z;
        this.f6121d = handler;
        this.f6123f = magnesSettings;
        this.f6122e = magnesSettings.magnesNetworkingFactoryImpl == null ? new MagnesNetworkingFactoryImpl() : magnesSettings.magnesNetworkingFactoryImpl;
    }

    public final void a(int i2, String str) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("MagnesPostRequest for ");
        outline73.append(this.f6119b.toString());
        outline73.append(" returned status code ");
        outline73.append(i2);
        outline73.append(", and responseString: ");
        outline73.append(str);
        a.a(b.class, 0, outline73.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        if (r4 != null) goto L_0x005b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r8 = this;
            java.lang.String r0 = "UTF-8"
            lib.android.paypal.com.magnessdk.MagnesSettings r1 = r8.f6123f
            r2 = 3
            if (r1 != 0) goto L_0x0008
            goto L_0x0064
        L_0x0008:
            int[] r1 = lib.android.paypal.com.magnessdk.network.b.AnonymousClass1.f6124a     // Catch:{ Exception -> 0x005e }
            lib.android.paypal.com.magnessdk.c$h$d r3 = r8.f6119b     // Catch:{ Exception -> 0x005e }
            int r3 = r3.ordinal()     // Catch:{ Exception -> 0x005e }
            r1 = r1[r3]     // Catch:{ Exception -> 0x005e }
            r3 = 1
            r4 = 0
            java.lang.String r5 = "Content-Type"
            if (r1 == r3) goto L_0x0032
            r3 = 2
            if (r1 == r3) goto L_0x0032
            lib.android.paypal.com.magnessdk.MagnesSettings r1 = r8.f6123f     // Catch:{ Exception -> 0x005e }
            android.content.Context r1 = r1.context     // Catch:{ Exception -> 0x005e }
            if (r1 != 0) goto L_0x0022
            goto L_0x002f
        L_0x0022:
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ Exception -> 0x005e }
            r4.<init>()     // Catch:{ Exception -> 0x005e }
            java.lang.String r3 = "application/json"
            r4.put(r5, r3)     // Catch:{ Exception -> 0x005e }
            lib.android.paypal.com.magnessdk.f.a(r4, r1)     // Catch:{ Exception -> 0x005e }
        L_0x002f:
            if (r4 == 0) goto L_0x0064
            goto L_0x005b
        L_0x0032:
            lib.android.paypal.com.magnessdk.MagnesSettings r1 = r8.f6123f     // Catch:{ Exception -> 0x005e }
            android.content.Context r1 = r1.context     // Catch:{ Exception -> 0x005e }
            if (r1 != 0) goto L_0x0039
            goto L_0x0059
        L_0x0039:
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ Exception -> 0x005e }
            r4.<init>()     // Catch:{ Exception -> 0x005e }
            java.lang.String r3 = "X-PAYPAL-RESPONSE-DATA-FORMAT"
            java.lang.String r6 = "NV"
            r4.put(r3, r6)     // Catch:{ Exception -> 0x005e }
            java.lang.String r3 = "X-PAYPAL-REQUEST-DATA-FORMAT"
            r4.put(r3, r6)     // Catch:{ Exception -> 0x005e }
            java.lang.String r3 = "X-PAYPAL-SERVICE-VERSION"
            java.lang.String r6 = "1.0.0"
            r4.put(r3, r6)     // Catch:{ Exception -> 0x005e }
            java.lang.String r3 = "application/x-www-form-urlencoded"
            r4.put(r5, r3)     // Catch:{ Exception -> 0x005e }
            lib.android.paypal.com.magnessdk.f.a(r4, r1)     // Catch:{ Exception -> 0x005e }
        L_0x0059:
            if (r4 == 0) goto L_0x0064
        L_0x005b:
            r8.f6120c = r4     // Catch:{ Exception -> 0x005e }
            goto L_0x0064
        L_0x005e:
            r1 = move-exception
            java.lang.Class<lib.android.paypal.com.magnessdk.f> r3 = lib.android.paypal.com.magnessdk.f.class
            lib.android.paypal.com.magnessdk.b.a.a(r3, r2, r1)
        L_0x0064:
            lib.android.paypal.com.magnessdk.network.base.MagnesNetworkingFactoryImpl r1 = r8.f6122e     // Catch:{ Exception -> 0x00e3 }
            lib.android.paypal.com.magnessdk.c$h$b r3 = lib.android.paypal.com.magnessdk.c$h$b.POST     // Catch:{ Exception -> 0x00e3 }
            lib.android.paypal.com.magnessdk.network.base.MagnesNetworking r1 = r1.createHttpClient(r3)     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r3 = r8.e()     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r4 = r8.f()     // Catch:{ Exception -> 0x00e3 }
            if (r3 == 0) goto L_0x00e2
            if (r4 != 0) goto L_0x0079
            goto L_0x00e2
        L_0x0079:
            android.net.Uri r5 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x00e3 }
            r1.setUri(r5)     // Catch:{ Exception -> 0x00e3 }
            java.util.Map<java.lang.String, java.lang.String> r5 = r8.f6120c     // Catch:{ Exception -> 0x00e3 }
            r1.setHeader(r5)     // Catch:{ Exception -> 0x00e3 }
            android.os.Handler r5 = r8.f6121d     // Catch:{ Exception -> 0x00e3 }
            android.os.Handler r6 = r8.f6121d     // Catch:{ Exception -> 0x00e3 }
            lib.android.paypal.com.magnessdk.c$h$c r7 = lib.android.paypal.com.magnessdk.c$h$c.POST_REQUEST_STARTED     // Catch:{ Exception -> 0x00e3 }
            int r7 = r7.a()     // Catch:{ Exception -> 0x00e3 }
            android.os.Message r3 = android.os.Message.obtain(r6, r7, r3)     // Catch:{ Exception -> 0x00e3 }
            r5.sendMessage(r3)     // Catch:{ Exception -> 0x00e3 }
            byte[] r3 = r4.getBytes(r0)     // Catch:{ Exception -> 0x00e3 }
            int r3 = r1.execute(r3)     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x00e3 }
            byte[] r5 = r1.getResponseContent()     // Catch:{ Exception -> 0x00e3 }
            r4.<init>(r5, r0)     // Catch:{ Exception -> 0x00e3 }
            r1.getPayPalDebugId()     // Catch:{ Exception -> 0x00e3 }
            r8.a(r3, r4)     // Catch:{ Exception -> 0x00e3 }
            lib.android.paypal.com.magnessdk.c$h$c r0 = lib.android.paypal.com.magnessdk.c$h$c.HTTP_STATUS_200     // Catch:{ Exception -> 0x00e3 }
            int r0 = r0.a()     // Catch:{ Exception -> 0x00e3 }
            if (r3 != r0) goto L_0x00cb
            android.os.Handler r0 = r8.f6121d     // Catch:{ Exception -> 0x00e3 }
            if (r0 == 0) goto L_0x00fa
            android.os.Handler r0 = r8.f6121d     // Catch:{ Exception -> 0x00e3 }
            android.os.Handler r1 = r8.f6121d     // Catch:{ Exception -> 0x00e3 }
            lib.android.paypal.com.magnessdk.c$h$c r3 = lib.android.paypal.com.magnessdk.c$h$c.POST_REQUEST_SUCCEEDED     // Catch:{ Exception -> 0x00e3 }
            int r3 = r3.a()     // Catch:{ Exception -> 0x00e3 }
            android.os.Message r1 = android.os.Message.obtain(r1, r3, r4)     // Catch:{ Exception -> 0x00e3 }
        L_0x00c7:
            r0.sendMessage(r1)     // Catch:{ Exception -> 0x00e3 }
            goto L_0x00fa
        L_0x00cb:
            android.os.Handler r0 = r8.f6121d     // Catch:{ Exception -> 0x00e3 }
            if (r0 == 0) goto L_0x00fa
            android.os.Handler r0 = r8.f6121d     // Catch:{ Exception -> 0x00e3 }
            android.os.Handler r1 = r8.f6121d     // Catch:{ Exception -> 0x00e3 }
            lib.android.paypal.com.magnessdk.c$h$c r4 = lib.android.paypal.com.magnessdk.c$h$c.POST_REQUEST_ERROR     // Catch:{ Exception -> 0x00e3 }
            int r4 = r4.a()     // Catch:{ Exception -> 0x00e3 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x00e3 }
            android.os.Message r1 = android.os.Message.obtain(r1, r4, r3)     // Catch:{ Exception -> 0x00e3 }
            goto L_0x00c7
        L_0x00e2:
            return
        L_0x00e3:
            r0 = move-exception
            java.lang.Class<lib.android.paypal.com.magnessdk.network.b> r1 = lib.android.paypal.com.magnessdk.network.b.class
            lib.android.paypal.com.magnessdk.b.a.a(r1, r2, r0)
            android.os.Handler r1 = r8.f6121d
            if (r1 == 0) goto L_0x00fa
            lib.android.paypal.com.magnessdk.c$h$c r2 = lib.android.paypal.com.magnessdk.c$h$c.POST_REQUEST_ERROR
            int r2 = r2.a()
            android.os.Message r0 = android.os.Message.obtain(r1, r2, r0)
            r1.sendMessage(r0)
        L_0x00fa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lib.android.paypal.com.magnessdk.network.b.b():void");
    }

    public final String e() {
        String str;
        if (this.f6123f == null || this.f6121d == null) {
            return null;
        }
        switch (AnonymousClass1.f6124a[this.f6119b.ordinal()]) {
            case 1:
            case 2:
                if (this.f6123f.environment == Environment.LIVE) {
                    str = MagnesSDK.getInstance().f5957a.k.optString(c$j.CONF_ENDPOINT_URL.toString(), c$h$d.DEVICE_INFO_URL.toString());
                } else {
                    str = c$h$d.SANDBOX_DEVICE_INFO_URL.toString();
                }
                return str;
            case 3:
            case 4:
            case 5:
            case 6:
                return (this.f6123f.environment == Environment.LIVE ? this.i ? c$h$d.AUDIT_JSON_URL : c$h$d.PRODUCTION_JSON_URL : this.i ? c$h$d.STAGE_AUDIT_JSON_URL : c$h$d.STAGE_PROD_JSON_URL).toString();
            default:
                return this.f6119b.toString();
        }
    }

    public final String f() throws Exception {
        String str;
        if (this.h == null) {
            return null;
        }
        int i2 = AnonymousClass1.f6124a[this.f6119b.ordinal()];
        boolean z = true;
        if (i2 != 1 && i2 != 2) {
            return this.h.toString();
        }
        if (this.h == null) {
            str = null;
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("appGuid", this.h.optString(c$d.APP_GUID.toString()));
            JSONObject jSONObject = this.h;
            hashMap.put("libraryVersion", String.format(Locale.US, "Dyson/%S (%S %S)", new Object[]{jSONObject.optString(c$d.COMP_VERSION.toString()), jSONObject.optString(c$d.OS_TYPE.toString()), VERSION.RELEASE}));
            hashMap.put("additionalData", this.h.toString());
            StringBuilder sb = new StringBuilder();
            for (Entry entry : hashMap.entrySet()) {
                if (z) {
                    z = false;
                } else {
                    sb.append("&");
                }
                sb.append(URLEncoder.encode((String) entry.getKey(), "UTF-8"));
                sb.append(InflateView.SETTER_EQUALS);
                sb.append(URLEncoder.encode((String) entry.getValue(), "UTF-8"));
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Encoded Device info payload : ");
            outline73.append(sb.toString());
            a.a(b.class, 0, outline73.toString());
            str = sb.toString();
        }
        if (str == null) {
            return null;
        }
        return str;
    }

    public void run() {
        if (this.f6121d != null) {
            b();
        }
    }
}
