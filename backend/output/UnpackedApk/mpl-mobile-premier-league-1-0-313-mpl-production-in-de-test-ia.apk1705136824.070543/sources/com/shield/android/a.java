package com.shield.android;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManager.DisplayListener;
import android.location.Criteria;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.format.Formatter;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.SMTConfigConstants;
import com.razorpay.AnalyticsConstants;
import com.shield.android.Shield.DeviceResultStateListener;
import com.shield.android.Shield.LogLevel;
import com.shield.android.ShieldFingerprintUseCase.h;
import com.shield.android.a.c;
import com.shield.android.d.d;
import com.shield.android.internal.i;
import com.shield.android.internal.j;
import com.shield.android.view.InternalBlockedDialog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import org.json.JSONObject;

public class a implements ActivityLifecycleCallbacks {
    public static final AtomicBoolean E = new AtomicBoolean(false);
    public static WeakReference<String> F;
    public static WeakReference<Activity> G;
    public static boolean H = false;
    public final boolean A;
    public final String B;
    public final BlockedDialog C;
    public boolean D = false;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1492a = true;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1493b = false;

    /* renamed from: c  reason: collision with root package name */
    public String f1494c = "";

    /* renamed from: d  reason: collision with root package name */
    public final Application f1495d;

    /* renamed from: e  reason: collision with root package name */
    public com.shield.android.d.c f1496e;

    /* renamed from: f  reason: collision with root package name */
    public com.shield.android.d.b f1497f;
    public com.shield.android.d.a g;
    public long h = 0;
    public boolean i = false;
    public boolean j = false;
    public DisplayListener k;
    public NetworkCallback l;
    public ShieldFingerprintUseCase m;
    public ScreenshotChecker n;
    public final boolean o;
    public final ShieldCallback<JSONObject> p;
    public final Thread q;
    public final boolean r;
    public com.shield.android.f.b s;
    public final String t;
    public final String u;
    public final String v;
    public final String w;
    public final String x;
    public final String y;
    public final LogLevel z;

    /* renamed from: com.shield.android.a$a  reason: collision with other inner class name */
    public class C0019a implements com.shield.android.d.e {
        public C0019a() {
        }

        public void a() {
            a.this.e().sendDeviceSignature((String) a.F.get(), GeneratedOutlineSupport.outline87("event_name", "display_changed"), null);
        }

        public void b() {
            a.this.e().sendDeviceSignature((String) a.F.get(), GeneratedOutlineSupport.outline87("event_name", "display_changed"), null);
        }

        public void c() {
            a.this.e().sendDeviceSignature((String) a.F.get(), GeneratedOutlineSupport.outline87("event_name", "display_changed"), null);
        }
    }

    public class b implements DisplayListener {
        public b() {
        }

        public void onDisplayAdded(int i) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("event_name", "display_changed");
                a.this.e().sendDeviceSignature((String) a.F.get(), hashMap, null);
            } catch (Exception unused) {
            }
        }

        public void onDisplayChanged(int i) {
        }

        public void onDisplayRemoved(int i) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("event_name", "display_changed");
                a.this.e().sendDeviceSignature((String) a.F.get(), hashMap, null);
            } catch (Exception unused) {
            }
        }
    }

    public class c implements DeviceResultStateListener {
        public c() {
        }

        /* access modifiers changed from: private */
        public void a() {
            ShieldFingerprintUseCase shieldFingerprintUseCase = a.this.m;
            com.shield.android.f.d dVar = (com.shield.android.f.d) shieldFingerprintUseCase.f1468e;
            dVar.b((i) new com.shield.android.f.d.f(false, new h(false)));
        }

        /* access modifiers changed from: private */
        public void b() {
            ShieldFingerprintUseCase shieldFingerprintUseCase = a.this.m;
            com.shield.android.f.d dVar = (com.shield.android.f.d) shieldFingerprintUseCase.f1468e;
            dVar.b((i) new com.shield.android.f.d.f(false, new h(false)));
        }

        public void isReady() {
            try {
                if (a.this.t == null || !a.this.t.equalsIgnoreCase("c936ac876525a84c4bfd132313b849b808d35f69")) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public final void run() {
                            c.this.b();
                        }
                    }, 100);
                    return;
                }
                WifiInfo connectionInfo = ((WifiManager) a.this.f1495d.getSystemService(AnalyticsConstants.WIFI)).getConnectionInfo();
                if (connectionInfo != null) {
                    String formatIpAddress = Formatter.formatIpAddress(connectionInfo.getIpAddress());
                    String substring = formatIpAddress.substring(0, formatIpAddress.lastIndexOf(".") + 1);
                    $$Lambda$a$c$W5EHxYF2tpQERaG0GRQr08r0P8 r1 = new com.shield.android.d.d() {
                        public final void a() {
                            c.this.a();
                        }
                    };
                    ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
                    newSingleThreadExecutor.execute(new Runnable(substring, r1) {
                        public final /* synthetic */ String f$0;
                        public final /* synthetic */ d f$1;

                        {
                            this.f$0 = r1;
                            this.f$1 = r2;
                        }

                        public final void run() {
                            ArpDataCollector.a(this.f$0, this.f$1);
                        }
                    });
                    newSingleThreadExecutor.shutdown();
                }
            } catch (Exception unused) {
            }
        }
    }

    public class d implements com.shield.android.d.e {
        public d() {
        }

        public void a() {
            a.this.e().sendDeviceSignature((String) a.F.get(), GeneratedOutlineSupport.outline87("event_name", "display_changed"), null);
        }

        public void b() {
            a.this.e().sendDeviceSignature((String) a.F.get(), GeneratedOutlineSupport.outline87("event_name", "display_changed"), null);
        }

        public void c() {
            a.this.e().sendDeviceSignature((String) a.F.get(), GeneratedOutlineSupport.outline87("event_name", "display_changed"), null);
        }
    }

    public class e extends NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConnectivityManager f1502a;

        public e(ConnectivityManager connectivityManager) {
            this.f1502a = connectivityManager;
        }

        public void onAvailable(Network network) {
            NetworkCapabilities networkCapabilities = this.f1502a.getNetworkCapabilities(network);
            if (!a.this.f1492a || (networkCapabilities != null && networkCapabilities.hasTransport(4) && !a.this.f1493b)) {
                a.this.f1493b = networkCapabilities != null && networkCapabilities.hasTransport(4);
                a.this.e().sendDeviceSignature((String) a.F.get(), GeneratedOutlineSupport.outline87("event_name", "network_change_detected"), null);
            }
            a.this.f1492a = true;
            super.onAvailable(network);
        }

        public void onLost(Network network) {
            super.onLost(network);
            a.this.f1492a = false;
        }

        public void onUnavailable() {
            super.onUnavailable();
            a.this.f1492a = false;
        }
    }

    public class f extends NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConnectivityManager f1504a;

        public f(ConnectivityManager connectivityManager) {
            this.f1504a = connectivityManager;
        }

        public void onAvailable(Network network) {
            NetworkCapabilities networkCapabilities = this.f1504a.getNetworkCapabilities(network);
            if (!a.this.f1492a || (networkCapabilities != null && networkCapabilities.hasTransport(4) && !a.this.f1493b)) {
                a.this.f1493b = networkCapabilities != null && networkCapabilities.hasTransport(4);
                a.this.e().sendDeviceSignature((String) a.F.get(), GeneratedOutlineSupport.outline87("event_name", "network_change_detected"), null);
            }
            a.this.f1492a = true;
            super.onAvailable(network);
        }

        public void onLost(Network network) {
            super.onLost(network);
            a.this.f1492a = false;
        }

        public void onUnavailable() {
            super.onUnavailable();
            a.this.f1492a = false;
        }
    }

    public a(Application application, String str, String str2, String str3, boolean z2, boolean z3, ShieldCallback shieldCallback, Thread thread, boolean z4, String str4, String str5, String str6, String str7, LogLevel logLevel, boolean z5) {
        boolean z6 = true;
        this.f1495d = application;
        this.j = z2;
        this.o = z3;
        this.p = shieldCallback;
        this.q = thread;
        this.r = z4;
        this.t = str;
        this.u = str2;
        this.v = str3;
        this.w = str4;
        this.x = str5;
        this.y = str7;
        this.z = logLevel;
        this.A = z5;
        this.B = null;
        this.C = null;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) application.getSystemService("connectivity");
            if (connectivityManager.getActiveNetworkInfo() == null || !connectivityManager.getActiveNetworkInfo().isConnected()) {
                z6 = false;
            }
            this.f1492a = z6;
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        e().sendDeviceSignature((String) F.get(), GeneratedOutlineSupport.outline87("event_name", "gps_provider_change_detected"), null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0048 */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056 A[Catch:{ Exception -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007d A[Catch:{ Exception -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h() {
        /*
            r5 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = E     // Catch:{ Exception -> 0x0080 }
            boolean r1 = r0.get()     // Catch:{ Exception -> 0x0080 }
            if (r1 != 0) goto L_0x0080
            java.lang.ref.WeakReference<android.app.Activity> r1 = G     // Catch:{ Exception -> 0x0080 }
            if (r1 != 0) goto L_0x0080
            r1 = 1
            r0.set(r1)     // Catch:{ Exception -> 0x0080 }
            com.shield.android.ShieldFingerprintUseCase r0 = r5.e()     // Catch:{ Exception -> 0x0080 }
            r0.appInBackground = r1     // Catch:{ Exception -> 0x0080 }
            boolean r0 = r5.i     // Catch:{ Exception -> 0x0080 }
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x0033
            com.shield.android.ScreenshotChecker r0 = r5.n     // Catch:{ Exception -> 0x0080 }
            android.app.Application r4 = r5.f1495d     // Catch:{ Exception -> 0x0080 }
            if (r0 == 0) goto L_0x0032
            android.database.ContentObserver r0 = com.shield.android.ScreenshotChecker.f1448b     // Catch:{ Exception -> 0x0080 }
            if (r0 == 0) goto L_0x002f
            android.content.ContentResolver r0 = r4.getContentResolver()     // Catch:{ Exception -> 0x002f }
            android.database.ContentObserver r4 = com.shield.android.ScreenshotChecker.f1448b     // Catch:{ Exception -> 0x002f }
            r0.unregisterContentObserver(r4)     // Catch:{ Exception -> 0x002f }
        L_0x002f:
            r5.i = r2     // Catch:{ Exception -> 0x0080 }
            goto L_0x0033
        L_0x0032:
            throw r3     // Catch:{ Exception -> 0x0080 }
        L_0x0033:
            android.hardware.display.DisplayManager$DisplayListener r0 = r5.k     // Catch:{ Exception -> 0x0080 }
            if (r0 == 0) goto L_0x0048
            android.app.Application r0 = r5.f1495d     // Catch:{ Exception -> 0x0048 }
            java.lang.String r4 = "display"
            java.lang.Object r0 = r0.getSystemService(r4)     // Catch:{ Exception -> 0x0048 }
            android.hardware.display.DisplayManager r0 = (android.hardware.display.DisplayManager) r0     // Catch:{ Exception -> 0x0048 }
            android.hardware.display.DisplayManager$DisplayListener r4 = r5.k     // Catch:{ Exception -> 0x0048 }
            r0.unregisterDisplayListener(r4)     // Catch:{ Exception -> 0x0048 }
            r5.k = r3     // Catch:{ Exception -> 0x0048 }
        L_0x0048:
            com.shield.android.ShieldFingerprintUseCase r0 = r5.m     // Catch:{ Exception -> 0x0080 }
            com.shield.android.f.b r0 = r0.f1468e     // Catch:{ Exception -> 0x0080 }
            com.shield.android.f.d r0 = (com.shield.android.f.d) r0     // Catch:{ Exception -> 0x0080 }
            com.shield.android.c.t r0 = r0.p()     // Catch:{ Exception -> 0x0080 }
            com.shield.android.c.m r0 = r0.f1550e     // Catch:{ Exception -> 0x0080 }
            if (r0 == 0) goto L_0x0067
            java.util.concurrent.ScheduledThreadPoolExecutor r4 = r0.f1533b     // Catch:{ Exception -> 0x0080 }
            if (r4 == 0) goto L_0x0067
            boolean r4 = r4.isShutdown()     // Catch:{ Exception -> 0x0080 }
            if (r4 != 0) goto L_0x0067
            java.util.concurrent.ScheduledThreadPoolExecutor r4 = r0.f1533b     // Catch:{ Exception -> 0x0080 }
            r4.shutdownNow()     // Catch:{ Exception -> 0x0080 }
            r0.f1533b = r3     // Catch:{ Exception -> 0x0080 }
        L_0x0067:
            java.lang.String r0 = "Shield: ApplicationLifecycle"
            com.shield.android.internal.f r0 = com.shield.android.internal.f.a(r0)     // Catch:{ Exception -> 0x0080 }
            java.lang.String r3 = "isBackgrounded at %s"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0080 }
            java.lang.ref.WeakReference<java.lang.String> r4 = F     // Catch:{ Exception -> 0x0080 }
            java.lang.Object r4 = r4.get()     // Catch:{ Exception -> 0x0080 }
            r1[r2] = r4     // Catch:{ Exception -> 0x0080 }
            boolean r0 = r0.f1677b     // Catch:{ Exception -> 0x0080 }
            if (r0 == 0) goto L_0x0080
            java.lang.String.format(r3, r1)     // Catch:{ Exception -> 0x0080 }
        L_0x0080:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shield.android.a.h():void");
    }

    /* access modifiers changed from: private */
    public void i() {
        this.m.sendDeviceSignature((String) F.get(), GeneratedOutlineSupport.outline87("event_name", "tools_change_detected"), null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j() {
        try {
            Intent intent = new Intent(this.f1495d, InternalBlockedDialog.class);
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            this.f1495d.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        e().sendDeviceSignature((String) F.get(), GeneratedOutlineSupport.outline87("event_name", "network_change_detected"), null);
    }

    /* access modifiers changed from: private */
    public void l() {
        try {
            String bestProvider = ((LocationManager) this.f1495d.getSystemService("location")).getBestProvider(new Criteria(), true);
            long currentTimeMillis = System.currentTimeMillis();
            if (bestProvider != this.f1494c && currentTimeMillis - this.h > 300) {
                HashMap hashMap = new HashMap();
                hashMap.put("event_name", "gps_provider_change_detected");
                e().sendDeviceSignature((String) F.get(), hashMap, null);
                a();
            }
            this.h = currentTimeMillis;
            this.f1494c = bestProvider;
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        e().sendDeviceSignature((String) F.get(), GeneratedOutlineSupport.outline87("event_name", "gps_provider_change_detected"), null);
        a();
    }

    /* access modifiers changed from: private */
    public void n() {
        e().sendDeviceSignature((String) F.get(), GeneratedOutlineSupport.outline87("event_name", "network_change_detected"), null);
    }

    /* access modifiers changed from: private */
    public void o() {
        try {
            String bestProvider = ((LocationManager) this.f1495d.getSystemService("location")).getBestProvider(new Criteria(), true);
            long currentTimeMillis = System.currentTimeMillis();
            if (bestProvider != this.f1494c && currentTimeMillis - this.h > 300) {
                HashMap hashMap = new HashMap();
                hashMap.put("event_name", "gps_provider_change_detected");
                e().sendDeviceSignature((String) F.get(), hashMap, null);
                a();
            }
            this.h = currentTimeMillis;
            this.f1494c = bestProvider;
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void p() {
        e().sendDeviceSignature((String) F.get(), GeneratedOutlineSupport.outline87("event_name", "gps_provider_change_detected"), null);
        a();
    }

    public final void a() {
        try {
            if ((j.i(this.f1495d, SMTConfigConstants.LOCATION_PERMISSION_MF_KEY) || j.i(this.f1495d, "android.permission.ACCESS_COARSE_LOCATION")) && j.c(this.f1495d)) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public final void run() {
                        a.this.g();
                    }
                }, 8000);
            }
        } catch (Exception unused) {
        }
    }

    public ShieldFingerprintUseCase e() {
        ShieldCallback<JSONObject> shieldCallback;
        Thread thread;
        boolean z2;
        if (this.m == null) {
            Context applicationContext = this.f1495d.getApplicationContext();
            boolean z3 = this.o;
            ShieldCallback<JSONObject> shieldCallback2 = this.p;
            Thread thread2 = this.q;
            boolean z4 = this.r;
            if (this.s == null) {
                z2 = z4;
                thread = thread2;
                shieldCallback = shieldCallback2;
                com.shield.android.f.d dVar = new com.shield.android.f.d(this.f1495d.getApplicationContext(), this.t, this.w, this.u, this.x, this.v, this.B, this.y, this.z, this.o, this.A);
                this.s = dVar;
            } else {
                shieldCallback = shieldCallback2;
                thread = thread2;
                z2 = z4;
            }
            ShieldFingerprintUseCase shieldFingerprintUseCase = new ShieldFingerprintUseCase(applicationContext, z3, shieldCallback, thread, z2, this.s, this.w);
            this.m = shieldFingerprintUseCase;
        }
        return this.m;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|(1:4)|5|6|7|(1:9)|10|(10:12|13|14|15|(3:17|(1:19)|20)|21|(8:23|24|(2:26|(3:28|(1:30)|31))(3:32|33|34)|35|36|(2:38|39)|40|41)|42|44|45)|46|48) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00ec */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x0118 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0036 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0052 A[Catch:{ Exception -> 0x0127 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x010c A[SYNTHETIC, Splitter:B:38:0x010c] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003a A[Catch:{ Exception -> 0x0127 }] */
    @android.annotation.SuppressLint({"MissingPermission"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityCreated(android.app.Activity r5, android.os.Bundle r6) {
        /*
            r4 = this;
            com.shield.android.Shield$LogLevel r6 = com.shield.android.Shield.LOG_LEVEL
            com.shield.android.internal.b r6 = com.shield.android.internal.b.b(r6)
            java.lang.String r0 = "SHIELD FP PROCESS -> onActivityCreated "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r1 = r5.getLocalClassName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r6.a(r0, r2)
            boolean r6 = r4.D     // Catch:{ Exception -> 0x0036 }
            if (r6 == 0) goto L_0x0032
            android.os.Handler r6 = new android.os.Handler     // Catch:{ Exception -> 0x0036 }
            android.os.Looper r0 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x0036 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x0036 }
            com.shield.android.-$$Lambda$a$3tVc8dekVzYlckJgJtmBIwvTCcM r0 = new com.shield.android.-$$Lambda$a$3tVc8dekVzYlckJgJtmBIwvTCcM     // Catch:{ Exception -> 0x0036 }
            r0.<init>()     // Catch:{ Exception -> 0x0036 }
            r6.post(r0)     // Catch:{ Exception -> 0x0036 }
        L_0x0032:
            boolean r6 = r5 instanceof com.shield.android.view.InternalBlockedDialog     // Catch:{ Exception -> 0x0036 }
            r4.D = r6     // Catch:{ Exception -> 0x0036 }
        L_0x0036:
            boolean r6 = r4.j     // Catch:{ Exception -> 0x0127 }
            if (r6 == 0) goto L_0x0043
            android.view.Window r6 = r5.getWindow()     // Catch:{ Exception -> 0x0127 }
            r0 = 8192(0x2000, float:1.148E-41)
            r6.setFlags(r0, r0)     // Catch:{ Exception -> 0x0127 }
        L_0x0043:
            java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x0127 }
            java.lang.String r0 = r5.getLocalClassName()     // Catch:{ Exception -> 0x0127 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x0127 }
            F = r6     // Catch:{ Exception -> 0x0127 }
            boolean r6 = H     // Catch:{ Exception -> 0x0127 }
            if (r6 != 0) goto L_0x0127
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ Exception -> 0x0127 }
            r6.<init>()     // Catch:{ Exception -> 0x0127 }
            java.lang.String r0 = "event_name"
            java.lang.String r2 = "sdk_initialized"
            r6.put(r0, r2)     // Catch:{ Exception -> 0x0127 }
            com.shield.android.Shield$LogLevel r0 = r4.z     // Catch:{ Exception -> 0x0127 }
            com.shield.android.internal.b r0 = com.shield.android.internal.b.b(r0)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r2 = "SHIELD FP PROCESS -> start sending first fp"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0127 }
            r0.a(r2, r3)     // Catch:{ Exception -> 0x0127 }
            com.shield.android.ShieldFingerprintUseCase r0 = r4.e()     // Catch:{ Exception -> 0x0127 }
            java.lang.ref.WeakReference<java.lang.String> r2 = F     // Catch:{ Exception -> 0x0127 }
            java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x0127 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0127 }
            com.shield.android.a$c r3 = new com.shield.android.a$c     // Catch:{ Exception -> 0x0127 }
            r3.<init>()     // Catch:{ Exception -> 0x0127 }
            r0.sendDeviceSignature(r2, r6, r3)     // Catch:{ Exception -> 0x0127 }
            com.shield.android.a$d r6 = new com.shield.android.a$d     // Catch:{ Exception -> 0x0127 }
            r6.<init>()     // Catch:{ Exception -> 0x0127 }
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.newSingleThreadExecutor()     // Catch:{ Exception -> 0x0127 }
            com.shield.android.-$$Lambda$eijyD49Kvm33hkcMa7g9gaRw3Pk r2 = new com.shield.android.-$$Lambda$eijyD49Kvm33hkcMa7g9gaRw3Pk     // Catch:{ Exception -> 0x0127 }
            r2.<init>()     // Catch:{ Exception -> 0x0127 }
            r0.execute(r2)     // Catch:{ Exception -> 0x0127 }
            r0.shutdown()     // Catch:{ Exception -> 0x0127 }
            boolean r6 = r4.i     // Catch:{ Exception -> 0x0127 }
            if (r6 != 0) goto L_0x00ad
            com.shield.android.ScreenshotChecker r6 = r4.n     // Catch:{ Exception -> 0x0127 }
            if (r6 != 0) goto L_0x00a6
            com.shield.android.ScreenshotChecker r6 = new com.shield.android.ScreenshotChecker     // Catch:{ Exception -> 0x0127 }
            com.shield.android.ShieldFingerprintUseCase r0 = r4.e()     // Catch:{ Exception -> 0x0127 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x0127 }
            r4.n = r6     // Catch:{ Exception -> 0x0127 }
        L_0x00a6:
            com.shield.android.ScreenshotChecker r6 = r4.n     // Catch:{ Exception -> 0x0127 }
            android.app.Application r0 = r4.f1495d     // Catch:{ Exception -> 0x0127 }
            r6.start(r0)     // Catch:{ Exception -> 0x0127 }
        L_0x00ad:
            com.shield.android.ShieldFingerprintUseCase r6 = r4.e()     // Catch:{ Exception -> 0x0127 }
            boolean r6 = r6.needBackgroundListener     // Catch:{ Exception -> 0x0127 }
            if (r6 == 0) goto L_0x0124
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0124 }
            r0 = 24
            if (r6 < r0) goto L_0x00d6
            java.lang.String r6 = "connectivity"
            java.lang.Object r6 = r5.getSystemService(r6)     // Catch:{ Exception -> 0x0124 }
            android.net.ConnectivityManager r6 = (android.net.ConnectivityManager) r6     // Catch:{ Exception -> 0x0124 }
            if (r6 == 0) goto L_0x00ec
            android.net.ConnectivityManager$NetworkCallback r0 = r4.l     // Catch:{ Exception -> 0x0124 }
            if (r0 != 0) goto L_0x00d0
            com.shield.android.a$e r0 = new com.shield.android.a$e     // Catch:{ Exception -> 0x0124 }
            r0.<init>(r6)     // Catch:{ Exception -> 0x0124 }
            r4.l = r0     // Catch:{ Exception -> 0x0124 }
        L_0x00d0:
            android.net.ConnectivityManager$NetworkCallback r0 = r4.l     // Catch:{ Exception -> 0x0124 }
            r6.registerDefaultNetworkCallback(r0)     // Catch:{ Exception -> 0x0124 }
            goto L_0x00ec
        L_0x00d6:
            com.shield.android.d.c r6 = new com.shield.android.d.c     // Catch:{ Exception -> 0x0124 }
            com.shield.android.-$$Lambda$a$C8A73eOHo5OLPyKpToxUHsSmq6A r0 = new com.shield.android.-$$Lambda$a$C8A73eOHo5OLPyKpToxUHsSmq6A     // Catch:{ Exception -> 0x0124 }
            r0.<init>()     // Catch:{ Exception -> 0x0124 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x0124 }
            r4.f1496e = r6     // Catch:{ Exception -> 0x0124 }
            android.content.IntentFilter r0 = new android.content.IntentFilter     // Catch:{ Exception -> 0x00ec }
            java.lang.String r2 = "android.net.conn.CONNECTIVITY_CHANGE"
            r0.<init>(r2)     // Catch:{ Exception -> 0x00ec }
            r5.registerReceiver(r6, r0)     // Catch:{ Exception -> 0x00ec }
        L_0x00ec:
            com.shield.android.d.b r6 = new com.shield.android.d.b     // Catch:{ Exception -> 0x0124 }
            com.shield.android.-$$Lambda$a$xWid2M4zl_E0_LvUum8lhxSEJaA r0 = new com.shield.android.-$$Lambda$a$xWid2M4zl_E0_LvUum8lhxSEJaA     // Catch:{ Exception -> 0x0124 }
            r0.<init>()     // Catch:{ Exception -> 0x0124 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x0124 }
            r4.f1497f = r6     // Catch:{ Exception -> 0x0124 }
            com.shield.android.d.a r6 = new com.shield.android.d.a     // Catch:{ Exception -> 0x0124 }
            com.shield.android.-$$Lambda$a$UVIQRUGEGacTzJSC8lpoUeZLKoA r0 = new com.shield.android.-$$Lambda$a$UVIQRUGEGacTzJSC8lpoUeZLKoA     // Catch:{ Exception -> 0x0124 }
            r0.<init>()     // Catch:{ Exception -> 0x0124 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x0124 }
            r4.g = r6     // Catch:{ Exception -> 0x0124 }
            android.app.Application r6 = r4.f1495d     // Catch:{ Exception -> 0x0124 }
            boolean r6 = com.shield.android.internal.j.b(r6)     // Catch:{ Exception -> 0x0124 }
            if (r6 == 0) goto L_0x0118
            com.shield.android.d.a r6 = r4.g     // Catch:{ Exception -> 0x0118 }
            android.content.IntentFilter r0 = new android.content.IntentFilter     // Catch:{ Exception -> 0x0118 }
            java.lang.String r2 = "android.location.MODE_CHANGED"
            r0.<init>(r2)     // Catch:{ Exception -> 0x0118 }
            r5.registerReceiver(r6, r0)     // Catch:{ Exception -> 0x0118 }
        L_0x0118:
            com.shield.android.d.b r6 = r4.f1497f     // Catch:{ Exception -> 0x0124 }
            android.content.IntentFilter r0 = new android.content.IntentFilter     // Catch:{ Exception -> 0x0124 }
            java.lang.String r2 = "android.location.PROVIDERS_CHANGED"
            r0.<init>(r2)     // Catch:{ Exception -> 0x0124 }
            r5.registerReceiver(r6, r0)     // Catch:{ Exception -> 0x0124 }
        L_0x0124:
            r6 = 1
            H = r6     // Catch:{ Exception -> 0x0127 }
        L_0x0127:
            com.shield.android.Shield$LogLevel r6 = com.shield.android.Shield.LOG_LEVEL
            com.shield.android.internal.b r6 = com.shield.android.internal.b.b(r6)
            java.lang.String r0 = "SHIELD FP PROCESS -> end onActivityCreated "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r5 = r5.getLocalClassName()
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.Object[] r0 = new java.lang.Object[r1]
            r6.a(r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shield.android.a.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    public void onActivityDestroyed(Activity activity) {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:2|3|(2:5|(1:7))|8|9|(1:11)|12|13|(3:15|16|(1:18))|19|20|(1:22)|23|24) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x001f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x002e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0035 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0018 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001c A[Catch:{ Exception -> 0x001f }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0027 A[SYNTHETIC, Splitter:B:15:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0032 A[Catch:{ Exception -> 0x0035 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityPaused(android.app.Activity r4) {
        /*
            r3 = this;
            boolean r0 = r3.o
            r1 = 0
            if (r0 != 0) goto L_0x003b
            android.net.ConnectivityManager$NetworkCallback r0 = r3.l     // Catch:{ Exception -> 0x0018 }
            if (r0 == 0) goto L_0x0018
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r4.getSystemService(r0)     // Catch:{ Exception -> 0x0018 }
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch:{ Exception -> 0x0018 }
            if (r0 == 0) goto L_0x0018
            android.net.ConnectivityManager$NetworkCallback r2 = r3.l     // Catch:{ Exception -> 0x0018 }
            r0.unregisterNetworkCallback(r2)     // Catch:{ Exception -> 0x0018 }
        L_0x0018:
            com.shield.android.d.c r0 = r3.f1496e     // Catch:{ Exception -> 0x001f }
            if (r0 == 0) goto L_0x001f
            r4.unregisterReceiver(r0)     // Catch:{ Exception -> 0x001f }
        L_0x001f:
            android.app.Application r0 = r3.f1495d     // Catch:{ Exception -> 0x003b }
            boolean r0 = com.shield.android.internal.j.b(r0)     // Catch:{ Exception -> 0x003b }
            if (r0 == 0) goto L_0x002e
            com.shield.android.d.a r0 = r3.g     // Catch:{ Exception -> 0x002e }
            if (r0 == 0) goto L_0x002e
            r4.unregisterReceiver(r0)     // Catch:{ Exception -> 0x002e }
        L_0x002e:
            com.shield.android.d.b r0 = r3.f1497f     // Catch:{ Exception -> 0x0035 }
            if (r0 == 0) goto L_0x0035
            r4.unregisterReceiver(r0)     // Catch:{ Exception -> 0x0035 }
        L_0x0035:
            r3.f1496e = r1     // Catch:{ Exception -> 0x003b }
            r3.f1497f = r1     // Catch:{ Exception -> 0x003b }
            r3.g = r1     // Catch:{ Exception -> 0x003b }
        L_0x003b:
            java.lang.String r0 = "Shield: ApplicationLifecycle"
            com.shield.android.internal.f r0 = com.shield.android.internal.f.a(r0)
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            boolean r0 = r0.f1677b
            if (r0 == 0) goto L_0x004d
            java.lang.String r0 = "onPaused"
            java.lang.String.format(r0, r2)
        L_0x004d:
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            java.lang.String r4 = r4.getLocalClassName()
            r0.<init>(r4)
            F = r0
            G = r1
            android.os.Handler r4 = new android.os.Handler
            r4.<init>()
            com.shield.android.-$$Lambda$a$MG54J8NuMAU51MOfK9T8-BepCsA r0 = new com.shield.android.-$$Lambda$a$MG54J8NuMAU51MOfK9T8-BepCsA
            r0.<init>()
            r1 = 750(0x2ee, double:3.705E-321)
            r4.postDelayed(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shield.android.a.onActivityPaused(android.app.Activity):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:2|3|(2:5|(1:7))|8|9|(1:11)|(8:12|13|(3:15|16|(1:18))|(3:19|20|(1:22))|23|25|26|28)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x001e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x002d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0017 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b A[Catch:{ Exception -> 0x001e }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0026 A[SYNTHETIC, Splitter:B:15:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0031 A[Catch:{ Exception -> 0x0034 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityPreDestroyed(android.app.Activity r3) {
        /*
            r2 = this;
            boolean r0 = r2.o
            if (r0 == 0) goto L_0x003b
            android.net.ConnectivityManager$NetworkCallback r0 = r2.l     // Catch:{ Exception -> 0x0017 }
            if (r0 == 0) goto L_0x0017
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r3.getSystemService(r0)     // Catch:{ Exception -> 0x0017 }
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch:{ Exception -> 0x0017 }
            if (r0 == 0) goto L_0x0017
            android.net.ConnectivityManager$NetworkCallback r1 = r2.l     // Catch:{ Exception -> 0x0017 }
            r0.unregisterNetworkCallback(r1)     // Catch:{ Exception -> 0x0017 }
        L_0x0017:
            com.shield.android.d.c r0 = r2.f1496e     // Catch:{ Exception -> 0x001e }
            if (r0 == 0) goto L_0x001e
            r3.unregisterReceiver(r0)     // Catch:{ Exception -> 0x001e }
        L_0x001e:
            android.app.Application r0 = r2.f1495d     // Catch:{ Exception -> 0x003b }
            boolean r0 = com.shield.android.internal.j.b(r0)     // Catch:{ Exception -> 0x003b }
            if (r0 == 0) goto L_0x002d
            com.shield.android.d.a r0 = r2.g     // Catch:{ Exception -> 0x002d }
            if (r0 == 0) goto L_0x002d
            r3.unregisterReceiver(r0)     // Catch:{ Exception -> 0x002d }
        L_0x002d:
            com.shield.android.d.b r0 = r2.f1497f     // Catch:{ Exception -> 0x0034 }
            if (r0 == 0) goto L_0x0034
            r3.unregisterReceiver(r0)     // Catch:{ Exception -> 0x0034 }
        L_0x0034:
            r3 = 0
            r2.f1496e = r3     // Catch:{ Exception -> 0x003b }
            r2.f1497f = r3     // Catch:{ Exception -> 0x003b }
            r2.g = r3     // Catch:{ Exception -> 0x003b }
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shield.android.a.onActivityPreDestroyed(android.app.Activity):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:7|8|9|10|(1:12)|13|(3:15|(1:17)|18)|19|(2:21|22)|23|24) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:0|(1:2)|3|4|5|(11:7|8|9|10|(1:12)|13|(3:15|(1:17)|18)|19|(2:21|22)|23|24)|25|26|(8:28|(2:30|(3:32|(1:34)|35))(3:36|37|38)|39|40|(2:42|43)|44|45|47)(1:49)) */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x00ba */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x00c6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0101 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x012d */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ca A[Catch:{ Exception -> 0x0139 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0121 A[SYNTHETIC, Splitter:B:42:0x0121] */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"MissingPermission"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResumed(android.app.Activity r8) {
        /*
            r7 = this;
            java.lang.String r0 = "Shield: ApplicationLifecycle"
            com.shield.android.internal.f r1 = com.shield.android.internal.f.a(r0)
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            boolean r1 = r1.f1677b
            if (r1 == 0) goto L_0x0012
            java.lang.String r1 = "onResumed"
            java.lang.String.format(r1, r3)
        L_0x0012:
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            java.lang.String r3 = r8.getLocalClassName()
            r1.<init>(r3)
            F = r1
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r8)
            G = r1
            java.util.concurrent.atomic.AtomicBoolean r1 = E     // Catch:{ Exception -> 0x00c6 }
            boolean r3 = r1.get()     // Catch:{ Exception -> 0x00c6 }
            if (r3 == 0) goto L_0x00c6
            com.shield.android.internal.f r0 = com.shield.android.internal.f.a(r0)     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r3 = "foreground at %s"
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00c6 }
            java.lang.ref.WeakReference<java.lang.String> r6 = F     // Catch:{ Exception -> 0x00c6 }
            java.lang.Object r6 = r6.get()     // Catch:{ Exception -> 0x00c6 }
            r5[r2] = r6     // Catch:{ Exception -> 0x00c6 }
            boolean r0 = r0.f1677b     // Catch:{ Exception -> 0x00c6 }
            if (r0 == 0) goto L_0x0044
            java.lang.String.format(r3, r5)     // Catch:{ Exception -> 0x00c6 }
        L_0x0044:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x00c6 }
            r0.<init>()     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r3 = "event_name"
            java.lang.String r5 = "application_on_resumed"
            r0.put(r3, r5)     // Catch:{ Exception -> 0x00c6 }
            com.shield.android.ShieldFingerprintUseCase r3 = r7.e()     // Catch:{ Exception -> 0x00c6 }
            java.lang.ref.WeakReference<java.lang.String> r5 = F     // Catch:{ Exception -> 0x00c6 }
            java.lang.Object r5 = r5.get()     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x00c6 }
            r6 = 0
            r3.sendDeviceSignature(r5, r0, r6)     // Catch:{ Exception -> 0x00c6 }
            r1.set(r2)     // Catch:{ Exception -> 0x00c6 }
            com.shield.android.ShieldFingerprintUseCase r0 = r7.e()     // Catch:{ Exception -> 0x00c6 }
            r0.appInBackground = r2     // Catch:{ Exception -> 0x00c6 }
            boolean r0 = r7.i     // Catch:{ Exception -> 0x00c6 }
            if (r0 != 0) goto L_0x0085
            com.shield.android.ScreenshotChecker r0 = r7.n     // Catch:{ Exception -> 0x00c6 }
            if (r0 != 0) goto L_0x007c
            com.shield.android.ScreenshotChecker r0 = new com.shield.android.ScreenshotChecker     // Catch:{ Exception -> 0x00c6 }
            com.shield.android.ShieldFingerprintUseCase r1 = r7.e()     // Catch:{ Exception -> 0x00c6 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00c6 }
            r7.n = r0     // Catch:{ Exception -> 0x00c6 }
        L_0x007c:
            com.shield.android.ScreenshotChecker r0 = r7.n     // Catch:{ Exception -> 0x00c6 }
            android.app.Application r1 = r7.f1495d     // Catch:{ Exception -> 0x00c6 }
            r0.start(r1)     // Catch:{ Exception -> 0x00c6 }
            r7.i = r4     // Catch:{ Exception -> 0x00c6 }
        L_0x0085:
            com.shield.android.a$a r0 = new com.shield.android.a$a     // Catch:{ Exception -> 0x00c6 }
            r0.<init>()     // Catch:{ Exception -> 0x00c6 }
            java.util.concurrent.ExecutorService r1 = java.util.concurrent.Executors.newSingleThreadExecutor()     // Catch:{ Exception -> 0x00c6 }
            com.shield.android.-$$Lambda$eijyD49Kvm33hkcMa7g9gaRw3Pk r2 = new com.shield.android.-$$Lambda$eijyD49Kvm33hkcMa7g9gaRw3Pk     // Catch:{ Exception -> 0x00c6 }
            r2.<init>()     // Catch:{ Exception -> 0x00c6 }
            r1.execute(r2)     // Catch:{ Exception -> 0x00c6 }
            r1.shutdown()     // Catch:{ Exception -> 0x00c6 }
            android.hardware.display.DisplayManager$DisplayListener r0 = r7.k     // Catch:{ Exception -> 0x00c6 }
            if (r0 != 0) goto L_0x00ba
            android.app.Application r0 = r7.f1495d     // Catch:{ Exception -> 0x00ba }
            java.lang.String r1 = "display"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch:{ Exception -> 0x00ba }
            android.hardware.display.DisplayManager r0 = (android.hardware.display.DisplayManager) r0     // Catch:{ Exception -> 0x00ba }
            com.shield.android.a$b r1 = new com.shield.android.a$b     // Catch:{ Exception -> 0x00ba }
            r1.<init>()     // Catch:{ Exception -> 0x00ba }
            r7.k = r1     // Catch:{ Exception -> 0x00ba }
            android.os.Handler r2 = new android.os.Handler     // Catch:{ Exception -> 0x00ba }
            android.os.Looper r3 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x00ba }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00ba }
            r0.registerDisplayListener(r1, r2)     // Catch:{ Exception -> 0x00ba }
        L_0x00ba:
            com.shield.android.ShieldFingerprintUseCase r0 = r7.e()     // Catch:{ Exception -> 0x00c6 }
            com.shield.android.-$$Lambda$a$nuZQARv3tRFTez_h3BP-w5WSK-s r1 = new com.shield.android.-$$Lambda$a$nuZQARv3tRFTez_h3BP-w5WSK-s     // Catch:{ Exception -> 0x00c6 }
            r1.<init>()     // Catch:{ Exception -> 0x00c6 }
            r0.startFridaListener(r1)     // Catch:{ Exception -> 0x00c6 }
        L_0x00c6:
            boolean r0 = r7.o     // Catch:{ Exception -> 0x0139 }
            if (r0 != 0) goto L_0x0139
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0139 }
            r1 = 24
            if (r0 < r1) goto L_0x00eb
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r8.getSystemService(r0)     // Catch:{ Exception -> 0x0139 }
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch:{ Exception -> 0x0139 }
            if (r0 == 0) goto L_0x0101
            android.net.ConnectivityManager$NetworkCallback r1 = r7.l     // Catch:{ Exception -> 0x0139 }
            if (r1 != 0) goto L_0x00e5
            com.shield.android.a$f r1 = new com.shield.android.a$f     // Catch:{ Exception -> 0x0139 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0139 }
            r7.l = r1     // Catch:{ Exception -> 0x0139 }
        L_0x00e5:
            android.net.ConnectivityManager$NetworkCallback r1 = r7.l     // Catch:{ Exception -> 0x0139 }
            r0.registerDefaultNetworkCallback(r1)     // Catch:{ Exception -> 0x0139 }
            goto L_0x0101
        L_0x00eb:
            com.shield.android.d.c r0 = new com.shield.android.d.c     // Catch:{ Exception -> 0x0139 }
            com.shield.android.-$$Lambda$a$OSTbcg11yUSsi9EDsI7kHf7xZZI r1 = new com.shield.android.-$$Lambda$a$OSTbcg11yUSsi9EDsI7kHf7xZZI     // Catch:{ Exception -> 0x0139 }
            r1.<init>()     // Catch:{ Exception -> 0x0139 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0139 }
            r7.f1496e = r0     // Catch:{ Exception -> 0x0139 }
            android.content.IntentFilter r1 = new android.content.IntentFilter     // Catch:{ Exception -> 0x0101 }
            java.lang.String r2 = "android.net.conn.CONNECTIVITY_CHANGE"
            r1.<init>(r2)     // Catch:{ Exception -> 0x0101 }
            r8.registerReceiver(r0, r1)     // Catch:{ Exception -> 0x0101 }
        L_0x0101:
            com.shield.android.d.b r0 = new com.shield.android.d.b     // Catch:{ Exception -> 0x0139 }
            com.shield.android.-$$Lambda$a$1tydNHeNo-rAGVrQDvGxK5EBCHc r1 = new com.shield.android.-$$Lambda$a$1tydNHeNo-rAGVrQDvGxK5EBCHc     // Catch:{ Exception -> 0x0139 }
            r1.<init>()     // Catch:{ Exception -> 0x0139 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0139 }
            r7.f1497f = r0     // Catch:{ Exception -> 0x0139 }
            com.shield.android.d.a r0 = new com.shield.android.d.a     // Catch:{ Exception -> 0x0139 }
            com.shield.android.-$$Lambda$a$MLrvToJLJNaBjSXaqBzsyrnJd44 r1 = new com.shield.android.-$$Lambda$a$MLrvToJLJNaBjSXaqBzsyrnJd44     // Catch:{ Exception -> 0x0139 }
            r1.<init>()     // Catch:{ Exception -> 0x0139 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0139 }
            r7.g = r0     // Catch:{ Exception -> 0x0139 }
            android.app.Application r0 = r7.f1495d     // Catch:{ Exception -> 0x0139 }
            boolean r0 = com.shield.android.internal.j.b(r0)     // Catch:{ Exception -> 0x0139 }
            if (r0 == 0) goto L_0x012d
            com.shield.android.d.a r0 = r7.g     // Catch:{ Exception -> 0x012d }
            android.content.IntentFilter r1 = new android.content.IntentFilter     // Catch:{ Exception -> 0x012d }
            java.lang.String r2 = "android.location.MODE_CHANGED"
            r1.<init>(r2)     // Catch:{ Exception -> 0x012d }
            r8.registerReceiver(r0, r1)     // Catch:{ Exception -> 0x012d }
        L_0x012d:
            com.shield.android.d.b r0 = r7.f1497f     // Catch:{ Exception -> 0x0139 }
            android.content.IntentFilter r1 = new android.content.IntentFilter     // Catch:{ Exception -> 0x0139 }
            java.lang.String r2 = "android.location.PROVIDERS_CHANGED"
            r1.<init>(r2)     // Catch:{ Exception -> 0x0139 }
            r8.registerReceiver(r0, r1)     // Catch:{ Exception -> 0x0139 }
        L_0x0139:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shield.android.a.onActivityResumed(android.app.Activity):void");
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
