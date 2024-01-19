package io.hansel.visualizer.f;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.razorpay.AnalyticsConstants;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.network.request.HSLServerRequest;
import io.hansel.core.network.request.HSLServerResponseHandler;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;
import java.io.InputStream;
import java.util.HashMap;

public class b extends g implements e {

    /* renamed from: d  reason: collision with root package name */
    public Handler f5918d;

    /* renamed from: e  reason: collision with root package name */
    public HandlerThread f5919e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5920f = false;
    public boolean g = false;
    public HashMap<f, e> h;
    public Context i;
    public HSLSDKIdentifiers j;
    public String k;
    public boolean l = false;
    public int m = 0;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5921a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|(2:1|2)|3|5|6|7|8|(2:9|10)|11|13|14|(3:15|16|18)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001d */
        static {
            /*
                io.hansel.visualizer.f.f[] r0 = io.hansel.visualizer.f.f.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5921a = r0
                io.hansel.visualizer.f.f r1 = io.hansel.visualizer.f.f.ws_close     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r0 = 2
                int[] r1 = f5921a     // Catch:{ NoSuchFieldError -> 0x0016 }
                io.hansel.visualizer.f.f r2 = io.hansel.visualizer.f.f.ws_open     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 0
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = f5921a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.hansel.visualizer.f.f r2 = io.hansel.visualizer.f.f.ws_inactive     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r2] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r1 = f5921a     // Catch:{ NoSuchFieldError -> 0x0024 }
                io.hansel.visualizer.f.f r2 = io.hansel.visualizer.f.f.ws_invalid_sid     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r1[r2] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                r1 = 6
                int[] r2 = f5921a     // Catch:{ NoSuchFieldError -> 0x002c }
                io.hansel.visualizer.f.f r3 = io.hansel.visualizer.f.f.ws_fetch_device_state     // Catch:{ NoSuchFieldError -> 0x002c }
                r3 = 5
                r2[r1] = r3     // Catch:{ NoSuchFieldError -> 0x002c }
            L_0x002c:
                int[] r2 = f5921a     // Catch:{ NoSuchFieldError -> 0x0032 }
                io.hansel.visualizer.f.f r3 = io.hansel.visualizer.f.f.ws_active     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.visualizer.f.b.a.<clinit>():void");
        }
    }

    /* renamed from: io.hansel.visualizer.f.b$b  reason: collision with other inner class name */
    public class C0095b implements HSLServerResponseHandler {
        public C0095b() {
        }

        public /* synthetic */ C0095b(b bVar, a aVar) {
            this();
        }

        public void parseResponse(HSLServerRequest hSLServerRequest, InputStream inputStream, int i) {
        }

        public void parseResponse(HSLServerRequest hSLServerRequest, String str, int i) {
            if (str != null) {
                try {
                    CoreJSONObject coreJSONObject = new CoreJSONObject(str);
                    if (!coreJSONObject.getBoolean("is_error")) {
                        CoreJSONObject optJSONObject = coreJSONObject.optJSONObject("api_response");
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("session_id");
                            b.this.c(optString);
                            b.this.b(optString);
                            HSLLogger.d("Received Session Id : " + optString);
                        }
                    }
                } catch (Exception e2) {
                    HSLLogger.printStackTrace(e2);
                }
            }
            b.this.g = false;
        }
    }

    public final class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message != null) {
                try {
                    Bundle data = message.getData();
                    String string = data.getString("message");
                    if (string == null) {
                        return;
                    }
                    if (string.equals(AnalyticsConstants.INIT) && data.containsKey("session_id")) {
                        b bVar = b.this;
                        bVar.a(f.ws_open, (e) bVar);
                        b bVar2 = b.this;
                        bVar2.a(f.ws_close, (e) bVar2);
                        b bVar3 = b.this;
                        bVar3.a(f.ws_active, (e) bVar3);
                        b bVar4 = b.this;
                        bVar4.a(f.ws_inactive, (e) bVar4);
                        b bVar5 = b.this;
                        bVar5.a(f.ws_invalid_sid, (e) bVar5);
                        b bVar6 = b.this;
                        bVar6.a(f.ws_fetch_device_state, (e) bVar6);
                        b.this.a(data.getString("session_id"), b.this.i);
                    } else if (string.equals("closed")) {
                        b.this.c();
                    } else if (string.equals("request_session")) {
                        post(new a(b.this.i, b.this.j, new C0095b(b.this, null)));
                    }
                } catch (Throwable th) {
                    HSLLogger.printStackTrace(th);
                }
            }
        }
    }

    public b(Context context, HSLSDKIdentifiers hSLSDKIdentifiers) {
        this.i = context;
        this.j = hSLSDKIdentifiers;
        this.h = new HashMap<>();
        f();
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        Message obtainMessage = this.f5918d.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putString("message", AnalyticsConstants.INIT);
        bundle.putString("session_id", str);
        obtainMessage.setData(bundle);
        this.f5918d.sendMessage(obtainMessage);
    }

    private void b(boolean z) {
        this.g = false;
        c();
        if (this.f5920f) {
            this.f5920f = false;
            if (z) {
                this.h.clear();
            }
            this.f5919e.quitSafely();
            this.f5919e = null;
        }
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        this.k = str;
    }

    private String e() {
        return this.k;
    }

    private void f() {
        HandlerThread handlerThread = new HandlerThread("HanselSocketHandler.HandlerThread");
        this.f5919e = handlerThread;
        handlerThread.start();
        this.f5918d = new c(this.f5919e.getLooper());
        this.f5920f = true;
    }

    private void g() {
        Message obtainMessage = this.f5918d.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putString("message", "request_session");
        obtainMessage.setData(bundle);
        this.f5918d.sendMessage(obtainMessage);
    }

    private void h() {
        String e2 = e();
        if (e2 == null) {
            g();
        } else {
            b(e2);
        }
    }

    public void a(d dVar) {
        e eVar = this.h.get(dVar.a());
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Received SocketEvent:");
        outline73.append(dVar.a());
        HSLLogger.d(outline73.toString(), LogGroup.WS);
        switch (a.f5921a[dVar.a().ordinal()]) {
            case 1:
            case 2:
            case 3:
                this.g = false;
                return;
            case 4:
                if (!this.l) {
                    HashMap<f, e> hashMap = this.h;
                    f fVar = f.ws_need_restart;
                    e eVar2 = hashMap.get(fVar);
                    if (eVar2 != null) {
                        eVar2.a(new d(fVar));
                        return;
                    }
                    return;
                }
                int i2 = this.m;
                if (i2 < 5) {
                    this.m = i2 + 1;
                    c(null);
                    b(false);
                    a(this.l);
                    return;
                }
                return;
            case 5:
            case 6:
                if (eVar != null) {
                    eVar.a(dVar);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void a(boolean z) {
        this.l = z;
        if (!this.f5920f) {
            f();
        }
        if (!this.g && !b()) {
            this.g = true;
            h();
        }
    }

    public void b(f fVar, e eVar) {
        this.h.put(fVar, eVar);
    }

    public void d() {
        this.m = 0;
    }
}
