package lib.android.paypal.com.magnessdk.network;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.HashMap;
import java.util.Map;
import lib.android.paypal.com.magnessdk.MagnesSettings;
import lib.android.paypal.com.magnessdk.MagnesSource;
import lib.android.paypal.com.magnessdk.b;
import lib.android.paypal.com.magnessdk.c$d;
import lib.android.paypal.com.magnessdk.c$e;
import lib.android.paypal.com.magnessdk.c$h$b;
import lib.android.paypal.com.magnessdk.c$h$c;
import lib.android.paypal.com.magnessdk.c$h$d;
import lib.android.paypal.com.magnessdk.e;
import lib.android.paypal.com.magnessdk.network.base.MagnesNetworking;
import lib.android.paypal.com.magnessdk.network.base.MagnesNetworkingFactoryImpl;
import lib.android.paypal.com.magnessdk.network.base.c;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends c {

    /* renamed from: b  reason: collision with root package name */
    public c$h$d f6113b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f6114c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public Handler f6115d;

    /* renamed from: e  reason: collision with root package name */
    public MagnesNetworkingFactoryImpl f6116e;

    /* renamed from: f  reason: collision with root package name */
    public MagnesSettings f6117f;
    public JSONObject g;

    /* renamed from: lib.android.paypal.com.magnessdk.network.a$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6118a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                lib.android.paypal.com.magnessdk.c$h$d[] r0 = lib.android.paypal.com.magnessdk.c$h$d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6118a = r0
                lib.android.paypal.com.magnessdk.c$h$d r1 = lib.android.paypal.com.magnessdk.c$h$d.RAMP_CONFIG_URL     // Catch:{ NoSuchFieldError -> 0x000f }
                r1 = 4
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = f6118a     // Catch:{ NoSuchFieldError -> 0x0017 }
                lib.android.paypal.com.magnessdk.c$h$d r1 = lib.android.paypal.com.magnessdk.c$h$d.REMOTE_CONFIG_URL     // Catch:{ NoSuchFieldError -> 0x0017 }
                r1 = 5
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: lib.android.paypal.com.magnessdk.network.a.AnonymousClass1.<clinit>():void");
        }
    }

    public a(c$h$d c_h_d, MagnesSettings magnesSettings, Handler handler, JSONObject jSONObject) {
        this.f6113b = c_h_d;
        this.f6117f = magnesSettings;
        this.f6115d = handler;
        this.f6116e = magnesSettings.magnesNetworkingFactoryImpl == null ? new MagnesNetworkingFactoryImpl() : magnesSettings.magnesNetworkingFactoryImpl;
        this.g = jSONObject;
    }

    public void a() {
        if (this.f6117f.enableNetworkOnCallerThread) {
            b();
        } else {
            d();
        }
    }

    public final void a(int i, String str) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("MagesGetRequest for ");
        outline73.append(this.f6113b.toString());
        outline73.append(" returned status code ");
        outline73.append(i);
        outline73.append(", and responseString: ");
        outline73.append(str);
        lib.android.paypal.com.magnessdk.b.a.a(a.class, 0, outline73.toString());
    }

    public void b() {
        Handler handler;
        Message obtain;
        if (this.f6113b == c$h$d.PRODUCTION_BEACON_URL) {
            JSONObject jSONObject = this.g;
            if (jSONObject != null) {
                this.f6114c.put("User-Agent", String.format("%s/%s/%s/%s/Android", new Object[]{jSONObject.optString(c$d.APP_ID.toString()), this.g.optString(c$d.APP_VERSION.toString()), this.g.optString(c$d.APP_VERSION.toString()), this.g.optString(c$d.APP_GUID.toString())}));
                this.f6114c.put("Accept-Language", "en-us");
            }
        }
        try {
            MagnesNetworking createHttpClient = this.f6116e.createHttpClient(c$h$b.GET);
            String e2 = e();
            if (e2 != null) {
                createHttpClient.setUri(Uri.parse(e2));
                if (this.f6114c != null && !this.f6114c.isEmpty()) {
                    createHttpClient.setHeader(this.f6114c);
                }
                if (this.f6115d != null) {
                    Handler handler2 = this.f6115d;
                    Handler handler3 = this.f6115d;
                    int a2 = c$h$c.GET_REQUEST_STARTED.a();
                    handler2.sendMessage(Message.obtain(handler3, a2, "Magnes Request Started for URL: " + e2));
                }
                int execute = createHttpClient.execute(null);
                String str = new String(createHttpClient.getResponseContent(), "UTF-8");
                a(execute, str);
                if (execute == c$h$c.HTTP_STATUS_200.a()) {
                    a(str);
                    if (this.f6115d != null) {
                        handler = this.f6115d;
                        obtain = Message.obtain(this.f6115d, c$h$c.GET_REQUEST_SUCCEEDED.a(), str);
                    }
                }
                if (this.f6115d != null) {
                    handler = this.f6115d;
                    Handler handler4 = this.f6115d;
                    int a3 = c$h$c.GET_REQUEST_ERROR.a();
                    obtain = Message.obtain(handler4, a3, execute + " : " + str);
                }
                handler.sendMessage(obtain);
            }
        } catch (Exception e3) {
            Handler handler5 = this.f6115d;
            if (handler5 != null) {
                handler5.sendMessage(Message.obtain(handler5, c$h$c.GET_REQUEST_ERROR.a(), e3));
            }
        }
    }

    public final String e() {
        c$h$d c_h_d = this.f6113b;
        c$h$d c_h_d2 = c$h$d.PRODUCTION_BEACON_URL;
        if (c_h_d == c_h_d2) {
            JSONObject jSONObject = this.g;
            String str = null;
            if (jSONObject == null) {
                return null;
            }
            if (jSONObject != null) {
                StringBuilder sb = new StringBuilder(c_h_d2.toString());
                sb.append("?p=");
                sb.append(this.g.optString("pairing_id"));
                sb.append("&i=");
                sb.append(this.g.optString(c$e.IP_ADDRS.toString()));
                sb.append("&t=");
                sb.append(String.valueOf(System.currentTimeMillis() / 1000));
                int i = this.f6117f.magnesSource;
                if (i == MagnesSource.DEFAULT.getVersion()) {
                    sb.append("&s=");
                    sb.append(this.g.optString(c$d.APP_ID.toString()));
                } else {
                    sb.append("&a=");
                    sb.append(i);
                }
                str = sb.toString();
            }
            if (str != null && str.length() > 0) {
                return str;
            }
        }
        return this.f6113b.toString();
    }

    public void run() {
        if (this.f6115d != null) {
            b();
        }
    }

    public final void a(String str) throws JSONException {
        int i = AnonymousClass1.f6118a[this.f6113b.ordinal()];
        if (i == 1) {
            b.a(this.f6117f.context, str, (String) "RAMP_CONFIG");
        } else if (i == 2) {
            JSONObject jSONObject = new JSONObject(str);
            b.a(this.f6117f.context, jSONObject.toString(), (String) "REMOTE_CONFIG");
            e.b(jSONObject);
            if (jSONObject.optJSONArray(c$d.NOT_COLLECTIBLE_LIST.toString()) != null) {
                e.o = true;
            }
        }
    }
}
