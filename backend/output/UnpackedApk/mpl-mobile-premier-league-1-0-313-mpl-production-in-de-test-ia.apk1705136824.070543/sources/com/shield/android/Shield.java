package com.shield.android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.content.ComponentName;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.netcore.android.SMTConfigConstants;
import com.shield.android.Shield.DeviceResultStateListener;
import com.shield.android.c.k;
import com.shield.android.c.o;
import com.shield.android.c.p;
import com.shield.android.c.q;
import com.shield.android.f.d;
import com.shield.android.f.d.a;
import com.shield.android.internal.b;
import com.shield.android.internal.c;
import com.shield.android.internal.i;
import com.shield.android.internal.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.json.JSONObject;

public class Shield {
    public static LogLevel LOG_LEVEL = LogLevel.NONE;

    /* renamed from: c  reason: collision with root package name */
    public static final List<String> f1453c = new ArrayList(1);

    /* renamed from: d  reason: collision with root package name */
    public static volatile Shield f1454d = null;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1455a = false;

    /* renamed from: b  reason: collision with root package name */
    public ShieldFingerprintUseCase f1456b;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public final Application f1457a;

        /* renamed from: b  reason: collision with root package name */
        public Activity f1458b;

        /* renamed from: c  reason: collision with root package name */
        public String f1459c;

        /* renamed from: d  reason: collision with root package name */
        public String f1460d;

        /* renamed from: e  reason: collision with root package name */
        public String f1461e;

        /* renamed from: f  reason: collision with root package name */
        public String f1462f;
        public String g;
        public String i;
        public String j;
        public LogLevel k = LogLevel.NONE;
        public Boolean l;
        public ShieldCallback<JSONObject> m;
        public Boolean n;
        public Thread o;
        public String p;
        public Boolean q;
        public boolean r;
        public boolean s;

        public Builder(Activity activity, String str, String str2) {
            Boolean bool = Boolean.FALSE;
            this.n = bool;
            this.q = bool;
            boolean z = false;
            this.r = false;
            this.s = false;
            this.f1458b = activity;
            if (activity != null) {
                Application application = (Application) activity.getApplicationContext();
                this.f1457a = application;
                if (application != null) {
                    if (!(activity.checkCallingOrSelfPermission("android.permission.INTERNET") == 0 ? true : z)) {
                        throw new IllegalArgumentException("INTERNET permission is required.");
                    } else if (!j.a((CharSequence) str)) {
                        this.f1459c = str;
                        if (!j.a((CharSequence) str2)) {
                            this.i = str2;
                            return;
                        }
                        throw new IllegalArgumentException("secretKey must not be null or empty.");
                    } else {
                        throw new IllegalArgumentException("siteId must not be null or empty.");
                    }
                } else {
                    throw new IllegalArgumentException("Application context must not be null.");
                }
            } else {
                throw new IllegalArgumentException("Activity must not be null. If you are initializing on Application's onCreate, use the initializer with context argument.");
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
            com.shield.android.internal.b.b(r1.k).a("SHIELD FP PROCESS -> shield initialized", new java.lang.Object[0]);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r1.f1460d = java.util.UUID.randomUUID().toString().replaceAll("[^a-zA-Z0-9]", "");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
            r1.f1460d = java.util.UUID.randomUUID().toString();
         */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x007d  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0089  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0091  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0099  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00a1  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00a9  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00ea  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00f0  */
        @android.annotation.SuppressLint({"NewApi"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.shield.android.Shield build() {
            /*
                r20 = this;
                r1 = r20
                boolean r0 = com.shield.android.Shield.stop()
                if (r0 == 0) goto L_0x0014
                com.shield.android.Shield r0 = new com.shield.android.Shield
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r2 = r0
                r2.<init>(r3, r4, r5, r6, r7)
                return r0
            L_0x0014:
                java.lang.String r0 = r1.j
                boolean r0 = com.shield.android.internal.j.a(r0)
                if (r0 == 0) goto L_0x0020
                java.lang.String r0 = r1.f1459c
                r1.j = r0
            L_0x0020:
                java.util.List<java.lang.String> r2 = com.shield.android.Shield.f1453c
                monitor-enter(r2)
                java.util.List<java.lang.String> r0 = com.shield.android.Shield.f1453c     // Catch:{ all -> 0x010c }
                java.lang.String r3 = r1.f1459c     // Catch:{ all -> 0x010c }
                boolean r0 = r0.contains(r3)     // Catch:{ all -> 0x010c }
                r3 = 0
                if (r0 == 0) goto L_0x0030
                monitor-exit(r2)     // Catch:{ all -> 0x010c }
                return r3
            L_0x0030:
                java.util.List<java.lang.String> r0 = com.shield.android.Shield.f1453c     // Catch:{ all -> 0x010c }
                java.lang.String r4 = r1.j     // Catch:{ all -> 0x010c }
                r0.add(r4)     // Catch:{ all -> 0x010c }
                monitor-exit(r2)     // Catch:{ all -> 0x010c }
                com.shield.android.Shield$LogLevel r0 = r1.k
                com.shield.android.internal.b r0 = com.shield.android.internal.b.b(r0)
                r2 = 0
                java.lang.Object[] r2 = new java.lang.Object[r2]
                java.lang.String r4 = "SHIELD FP PROCESS -> shield initialized"
                r0.a(r4, r2)
                java.util.UUID r0 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x0059 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0059 }
                java.lang.String r2 = "[^a-zA-Z0-9]"
                java.lang.String r4 = ""
                java.lang.String r0 = r0.replaceAll(r2, r4)     // Catch:{ Exception -> 0x0059 }
                r1.f1460d = r0     // Catch:{ Exception -> 0x0059 }
                goto L_0x0063
            L_0x0059:
                java.util.UUID r0 = java.util.UUID.randomUUID()
                java.lang.String r0 = r0.toString()
                r1.f1460d = r0
            L_0x0063:
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0071 }
                r6 = 1000(0x3e8, double:4.94E-321)
                long r4 = r4 / r6
                java.lang.String r0 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0071 }
                r1.f1461e = r0     // Catch:{ Exception -> 0x0071 }
                goto L_0x0075
            L_0x0071:
                java.lang.String r0 = ""
                r1.f1461e = r0
            L_0x0075:
                java.lang.String r0 = r1.f1462f
                boolean r0 = com.shield.android.internal.j.a(r0)
                if (r0 == 0) goto L_0x0081
                java.lang.String r0 = "US"
                r1.f1462f = r0
            L_0x0081:
                java.lang.String r0 = r1.g
                boolean r0 = com.shield.android.internal.j.a(r0)
                if (r0 == 0) goto L_0x008d
                java.lang.String r0 = "PROD"
                r1.g = r0
            L_0x008d:
                com.shield.android.Shield$LogLevel r0 = r1.k
                if (r0 != 0) goto L_0x0095
                com.shield.android.Shield$LogLevel r0 = com.shield.android.Shield.LogLevel.NONE
                r1.k = r0
            L_0x0095:
                java.lang.Boolean r0 = r1.l
                if (r0 != 0) goto L_0x009d
                java.lang.Boolean r0 = java.lang.Boolean.TRUE
                r1.l = r0
            L_0x009d:
                java.lang.Boolean r0 = r1.n
                if (r0 != 0) goto L_0x00a5
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                r1.n = r0
            L_0x00a5:
                java.lang.String r0 = r1.p
                if (r0 != 0) goto L_0x00ad
                java.lang.String r0 = ""
                r1.p = r0
            L_0x00ad:
                com.shield.android.a r0 = new com.shield.android.a
                android.app.Application r5 = r1.f1457a
                java.lang.String r6 = r1.f1459c
                java.lang.String r7 = r1.i
                java.lang.String r8 = r1.f1461e
                boolean r9 = r1.s
                java.lang.Boolean r2 = r1.q
                boolean r10 = r2.booleanValue()
                com.shield.android.ShieldCallback<org.json.JSONObject> r11 = r1.m
                java.lang.Thread r12 = r1.o
                java.lang.Boolean r2 = r1.n
                boolean r13 = r2.booleanValue()
                java.lang.String r14 = r1.f1460d
                java.lang.String r15 = r1.p
                r16 = 0
                java.lang.String r2 = r1.g
                com.shield.android.Shield$LogLevel r4 = r1.k
                boolean r3 = r1.r
                r18 = r4
                r4 = r0
                r17 = r2
                r19 = r3
                r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
                android.app.Application r2 = r1.f1457a
                r2.registerActivityLifecycleCallbacks(r0)
                android.app.Application r2 = r1.f1457a
                android.app.Application r3 = com.shield.android.internal.f.f1675d
                if (r3 != 0) goto L_0x00ec
                com.shield.android.internal.f.f1675d = r2
            L_0x00ec:
                android.app.Activity r2 = r1.f1458b
                if (r2 == 0) goto L_0x00f4
                r3 = 0
                r0.onActivityCreated(r2, r3)
            L_0x00f4:
                com.shield.android.Shield r2 = new com.shield.android.Shield
                android.app.Application r5 = r1.f1457a
                java.lang.Boolean r3 = r1.n
                boolean r6 = r3.booleanValue()
                java.lang.Boolean r3 = r1.q
                boolean r7 = r3.booleanValue()
                boolean r8 = r1.s
                r4 = r2
                r9 = r0
                r4.<init>(r5, r6, r7, r8, r9)
                return r2
            L_0x010c:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x010c }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shield.android.Shield.Builder.build():com.shield.android.Shield");
        }
    }

    public interface DeviceResultStateListener {
        void isReady();
    }

    public enum LogLevel {
        NONE,
        INFO,
        DEBUG,
        VERBOSE
    }

    public Shield(Application application, boolean z, boolean z2, boolean z3, a aVar) {
        if (!stop()) {
            this.f1455a = z;
            this.f1456b = aVar.e();
            if (this.f1455a) {
                UUID.randomUUID().toString().replaceAll("[^a-zA-Z0-9]", "");
                UUID.randomUUID().toString().replaceAll("[^a-zA-Z0-9]", "");
                UUID.randomUUID().toString().replaceAll("[^a-zA-Z0-9]", "");
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(application, aVar) {
                public final /* synthetic */ Application f$0;
                public final /* synthetic */ a f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void run() {
                    Shield.a(this.f$0, this.f$1);
                }
            }, (long) (new Random().nextInt(1000) + 2000));
            b.b(LOG_LEVEL).a("SHIELD FP PROCESS -> shield initialized finished", new Object[0]);
        }
    }

    public static /* synthetic */ void a(Application application, a aVar) {
        try {
            if (!a.H) {
                b.b(LOG_LEVEL).a("SHIELD FP PROCESS -> starting late fingerprinting", new Object[0]);
                ActivityManager activityManager = (ActivityManager) application.getSystemService("activity");
                if (activityManager != null) {
                    for (RunningTaskInfo next : activityManager.getRunningTasks(Integer.MAX_VALUE)) {
                        if (next != null) {
                            ComponentName componentName = next.baseActivity;
                            if (!(componentName == null || componentName.getPackageName() == null || !next.baseActivity.getPackageName().equals(application.getPackageName()))) {
                                b b2 = b.b(LOG_LEVEL);
                                b2.a("SHIELD FP PROCESS -> Activity " + next.baseActivity.getClassName() + " is active", new Object[0]);
                                aVar.onActivityCreated(new ShieldInitializeActivity(), null);
                                return;
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static Shield getInstance() {
        if (f1454d != null) {
            return f1454d;
        }
        throw new IllegalStateException("Singleton instance hasn't created yet. Please set singleton instance after building via builder");
    }

    @SuppressLint({"NewApi"})
    public static boolean stop() {
        try {
            return Process.isIsolated();
        } catch (Exception unused) {
            return false;
        }
    }

    public JSONObject getLatestDeviceResult() {
        ShieldFingerprintUseCase shieldFingerprintUseCase = this.f1456b;
        if (shieldFingerprintUseCase.i != null) {
            d dVar = (d) shieldFingerprintUseCase.f1468e;
            dVar.b((i) new a(new ShieldFingerprintUseCase.d()));
        }
        c cVar = shieldFingerprintUseCase.h;
        if (cVar != null) {
            boolean z = cVar.f1669a;
            boolean z2 = cVar.f1670b;
            if (z) {
                if (!shieldFingerprintUseCase.appInBackground) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            ShieldFingerprintUseCase.this.c();
                        }
                    });
                }
            } else if (z2 && !shieldFingerprintUseCase.appInBackground) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        ShieldFingerprintUseCase.this.d();
                    }
                });
            }
        }
        return shieldFingerprintUseCase.i;
    }

    public void sendDeviceSignature(String str) {
        p pVar;
        ShieldFingerprintUseCase shieldFingerprintUseCase = this.f1456b;
        if (shieldFingerprintUseCase != null) {
            HashMap hashMap = new HashMap();
            if ("shield_gps_provider_xyz".equals(str)) {
                hashMap.put("event_name", "gps_provider_change_detected");
                shieldFingerprintUseCase.sendDeviceSignature("gps_provider", hashMap, null);
                return;
            }
            hashMap.put("event_name", "manual_triggered");
            if ((j.h(shieldFingerprintUseCase.l.getApplicationContext(), SMTConfigConstants.LOCATION_PERMISSION_MF_KEY) || j.h(shieldFingerprintUseCase.l.getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION")) && j.c(shieldFingerprintUseCase.l.getApplicationContext())) {
                try {
                    if (j.b(shieldFingerprintUseCase.l.getApplicationContext())) {
                        pVar = new k(shieldFingerprintUseCase.l.getApplicationContext());
                    } else {
                        pVar = new o(shieldFingerprintUseCase.l.getApplicationContext());
                    }
                    p pVar2 = pVar;
                    pVar2.a();
                    $$Lambda$ShieldFingerprintUseCase$WrteC5_ZKrEFrRJe5YzVoYyGzVY r0 = new q(hashMap, pVar2, str, null) {
                        public final /* synthetic */ HashMap f$1;
                        public final /* synthetic */ p f$2;
                        public final /* synthetic */ String f$3;
                        public final /* synthetic */ DeviceResultStateListener f$4;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                        }

                        public final void a(Location location) {
                            ShieldFingerprintUseCase.this.a(this.f$1, this.f$2, this.f$3, this.f$4, location);
                        }
                    };
                    pVar2.a(r0);
                    pVar2.c();
                } catch (Exception unused) {
                    shieldFingerprintUseCase.sendDeviceSignature(str, hashMap, null);
                }
            } else {
                shieldFingerprintUseCase.sendDeviceSignature(str, hashMap, null);
            }
        } else {
            throw null;
        }
    }
}
