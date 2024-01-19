package com.shield.android.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.shield.android.IIsolatedService;
import com.shield.android.IIsolatedService.Stub;
import com.shield.android.Shield;
import com.shield.android.internal.b;
import com.shield.android.internal.f;
import com.shield.android.service.ShieldIsolatedService;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java8.util.concurrent.CompletableFuture;

public final class t extends f {

    /* renamed from: b  reason: collision with root package name */
    public final Context f1547b;

    /* renamed from: c  reason: collision with root package name */
    public final a f1548c;

    /* renamed from: d  reason: collision with root package name */
    public final h f1549d;

    /* renamed from: e  reason: collision with root package name */
    public final m f1550e;

    /* renamed from: f  reason: collision with root package name */
    public final n f1551f;
    public final u g;
    public final v h;
    public final l i;
    public final r j;
    public final j k;
    public final i l;
    public final String m;
    public final String n;
    public final String o;
    public boolean p = false;
    public ServiceConnection q = null;
    public IIsolatedService r;
    public boolean s = true;

    public class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f1552a;

        public a(Context context) {
            this.f1552a = context;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                t.this.r = Stub.asInterface(iBinder);
                if (t.this.r.isMagiskPresent()) {
                    t.this.p = true;
                    Shield.getInstance().sendDeviceSignature("shield_isolated_process");
                }
                this.f1552a.unbindService(t.this.q);
                this.f1552a.stopService(new Intent(this.f1552a, ShieldIsolatedService.class));
            } catch (Exception e2) {
                if (f.a().f1677b && e2.getMessage() != null) {
                    e2.getLocalizedMessage();
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            t.this.r = null;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public t(Context context, String str, String str2, String str3, ConcurrentMap<String, String> concurrentMap, a aVar, h hVar, n nVar, u uVar, v vVar, l lVar, j jVar, r rVar, m mVar, i iVar, boolean z) {
        // ConcurrentMap<String, String> concurrentMap2 = concurrentMap;
        super(concurrentMap);
        this.f1547b = context;
        this.m = str;
        this.n = str2;
        this.o = str3;
        this.f1548c = aVar;
        this.f1549d = hVar;
        this.f1551f = nVar;
        this.g = uVar;
        this.h = vVar;
        this.i = lVar;
        this.k = jVar;
        this.j = rVar;
        this.f1550e = mVar;
        this.l = iVar;
        if (z) {
            this.q = new a(context);
            if (VERSION.SDK_INT >= 29) {
                try {
                    context.bindIsolatedService(new Intent(context, ShieldIsolatedService.class), 1, d(), context.getMainExecutor(), this.q);
                } catch (Exception e2) {
                    if (f.a().f1677b && e2.getMessage() != null) {
                        e2.getLocalizedMessage();
                    }
                }
            } else {
                try {
                    context.bindService(new Intent(context, ShieldIsolatedService.class), this.q, 1);
                } catch (Exception e3) {
                    if (f.a().f1677b && e3.getMessage() != null) {
                        e3.getLocalizedMessage();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e A[SYNTHETIC, Splitter:B:12:0x001e] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.concurrent.CountDownLatch r8, java.util.concurrent.ExecutorService r9) {
        /*
            r7 = this;
            java.lang.String r0 = "error"
            java.lang.String r1 = "IDFA"
            android.content.Context r2 = r7.f1547b     // Catch:{ Exception -> 0x003e }
            r3 = 1
            r4 = 0
            java.lang.String r5 = "com.google.android.gms.ads.identifier.AdvertisingIdClient"
            java.lang.Class.forName(r5)     // Catch:{ Exception -> 0x0019 }
            com.google.android.gms.common.GoogleApiAvailability r5 = com.google.android.gms.common.GoogleApiAvailability.zab     // Catch:{ Exception -> 0x0019 }
            int r6 = com.google.android.gms.common.GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE     // Catch:{ Exception -> 0x0019 }
            int r2 = r5.isGooglePlayServicesAvailable(r2, r6)     // Catch:{ Exception -> 0x0019 }
            if (r2 != 0) goto L_0x0019
            r2 = 1
            goto L_0x001a
        L_0x0019:
            r2 = 0
        L_0x001a:
            java.lang.String r5 = ""
            if (r2 == 0) goto L_0x0048
            android.content.Context r2 = r7.f1547b     // Catch:{ Exception -> 0x003e }
            com.shield.android.AdvertisingIdClient$AdInfo r2 = com.google.android.material.resources.TextAppearanceConfig.getAdvertisingIdInfo(r2)     // Catch:{ Exception -> 0x003e }
            java.lang.String r3 = r2.f1442a     // Catch:{ Exception -> 0x003e }
            if (r3 == 0) goto L_0x0041
            java.lang.String r3 = r2.f1442a     // Catch:{ Exception -> 0x003e }
            int r3 = r3.length()     // Catch:{ Exception -> 0x003e }
            if (r3 != 0) goto L_0x0031
            goto L_0x0041
        L_0x0031:
            java.lang.String r2 = r2.f1442a     // Catch:{ Exception -> 0x003e }
            if (r2 != 0) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            r5 = r2
        L_0x0037:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r2 = r7.f1517a     // Catch:{ Exception -> 0x003e }
            r2.put(r1, r5)     // Catch:{ Exception -> 0x003e }
            goto L_0x00c5
        L_0x003e:
            r2 = move-exception
            goto L_0x00af
        L_0x0041:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r2 = r7.f1517a     // Catch:{ Exception -> 0x003e }
            r2.put(r1, r0)     // Catch:{ Exception -> 0x003e }
            goto L_0x00c5
        L_0x0048:
            java.lang.String r2 = "androidx.ads.identifier.AdvertisingIdClient"
            java.lang.Class.forName(r2)     // Catch:{ Exception -> 0x004e }
            goto L_0x004f
        L_0x004e:
            r3 = 0
        L_0x004f:
            if (r3 == 0) goto L_0x0095
            android.content.Context r2 = r7.f1547b     // Catch:{ Exception -> 0x003e }
            boolean r2 = androidx.ads.identifier.AdvertisingIdClient.isAdvertisingIdProviderAvailable(r2)     // Catch:{ Exception -> 0x003e }
            if (r2 == 0) goto L_0x0095
            android.content.Context r2 = r7.f1547b     // Catch:{ Exception -> 0x003e }
            com.google.common.util.concurrent.ListenableFuture r2 = androidx.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r2)     // Catch:{ Exception -> 0x003e }
            androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture r2 = (androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture) r2
            java.lang.Object r3 = r2.get()     // Catch:{ Exception -> 0x003e }
            androidx.ads.identifier.AdvertisingIdInfo r3 = (androidx.ads.identifier.AdvertisingIdInfo) r3     // Catch:{ Exception -> 0x003e }
            androidx.ads.identifier.AutoValue_AdvertisingIdInfo r3 = (androidx.ads.identifier.AutoValue_AdvertisingIdInfo) r3     // Catch:{ Exception -> 0x003e }
            java.lang.String r3 = r3.id     // Catch:{ Exception -> 0x003e }
            java.lang.Object r3 = r2.get()     // Catch:{ Exception -> 0x003e }
            androidx.ads.identifier.AdvertisingIdInfo r3 = (androidx.ads.identifier.AdvertisingIdInfo) r3     // Catch:{ Exception -> 0x003e }
            androidx.ads.identifier.AutoValue_AdvertisingIdInfo r3 = (androidx.ads.identifier.AutoValue_AdvertisingIdInfo) r3     // Catch:{ Exception -> 0x003e }
            java.lang.String r3 = r3.id     // Catch:{ Exception -> 0x003e }
            int r3 = r3.length()     // Catch:{ Exception -> 0x003e }
            if (r3 != 0) goto L_0x0081
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r2 = r7.f1517a     // Catch:{ Exception -> 0x003e }
            r2.put(r1, r0)     // Catch:{ Exception -> 0x003e }
            goto L_0x00c5
        L_0x0081:
            java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x003e }
            androidx.ads.identifier.AdvertisingIdInfo r2 = (androidx.ads.identifier.AdvertisingIdInfo) r2     // Catch:{ Exception -> 0x003e }
            androidx.ads.identifier.AutoValue_AdvertisingIdInfo r2 = (androidx.ads.identifier.AutoValue_AdvertisingIdInfo) r2     // Catch:{ Exception -> 0x003e }
            java.lang.String r2 = r2.id     // Catch:{ Exception -> 0x003e }
            if (r2 != 0) goto L_0x008e
            goto L_0x008f
        L_0x008e:
            r5 = r2
        L_0x008f:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r2 = r7.f1517a     // Catch:{ Exception -> 0x003e }
            r2.put(r1, r5)     // Catch:{ Exception -> 0x003e }
            goto L_0x00c5
        L_0x0095:
            android.content.Context r2 = r7.f1547b     // Catch:{ Exception -> 0x00a7 }
            com.shield.android.AdvertisingIdClient$AdInfo r2 = com.google.android.material.resources.TextAppearanceConfig.getAdvertisingIdInfo(r2)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r2 = r2.f1442a     // Catch:{ Exception -> 0x00a7 }
            if (r2 != 0) goto L_0x00a0
            goto L_0x00a1
        L_0x00a0:
            r5 = r2
        L_0x00a1:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r2 = r7.f1517a     // Catch:{ Exception -> 0x00a7 }
            r2.put(r1, r5)     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00c5
        L_0x00a7:
            java.lang.String r2 = "disabled"
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r3 = r7.f1517a     // Catch:{ Exception -> 0x003e }
            r3.put(r1, r2)     // Catch:{ Exception -> 0x003e }
            goto L_0x00c5
        L_0x00af:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r3 = r7.f1517a
            r3.put(r1, r0)
            com.shield.android.internal.f r0 = com.shield.android.internal.f.a()
            boolean r0 = r0.f1677b
            if (r0 == 0) goto L_0x00c5
            java.lang.String r0 = r2.getMessage()
            if (r0 == 0) goto L_0x00c5
            r2.getLocalizedMessage()
        L_0x00c5:
            r8.countDown()     // Catch:{ Exception -> 0x00cb }
            r9.shutdown()     // Catch:{ Exception -> 0x00cb }
        L_0x00cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shield.android.c.t.a(java.util.concurrent.CountDownLatch, java.util.concurrent.ExecutorService):void");
    }

    /* access modifiers changed from: private */
    public void f() {
        h hVar = this.f1549d;
        if (hVar != null) {
            try {
                CompletableFuture exceptionally = CompletableFuture.runAsync(new Runnable() {
                    public final void run() {
                        h.this.p();
                    }
                }, hVar.f1521e).exceptionally($$Lambda$_PrJBc1Fr7lRukMSaE4FU86CtrY.INSTANCE);
                CompletableFuture exceptionally2 = CompletableFuture.runAsync(new Runnable() {
                    public final void run() {
                        h.this.q();
                    }
                }, hVar.f1521e).exceptionally($$Lambda$IuQKERVYII8TT_Gl64G4mA7PRE.INSTANCE);
                CompletableFuture.andTree(new CompletableFuture[]{exceptionally, CompletableFuture.runAsync(new Runnable() {
                    public final void run() {
                        h.this.r();
                    }
                }, hVar.f1521e).exceptionally($$Lambda$QPcuqOvOOmCB_zj40XKSUVvoVo.INSTANCE), exceptionally2, CompletableFuture.runAsync(new Runnable() {
                    public final void run() {
                        h.this.s();
                    }
                }, hVar.f1521e).exceptionally($$Lambda$AR_MSf5NHpTfSco4ZolC5YL9mY4.INSTANCE)}, 0, 3).get();
                hVar.f1521e.shutdown();
            } catch (Exception e2) {
                if (f.a().f1677b && e2.getMessage() != null) {
                    e2.getLocalizedMessage();
                }
            }
            this.f1517a.putAll(hVar.f1517a);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void g() {
        String str;
        m mVar = this.f1550e;
        if (mVar != null) {
            String str2 = "";
            try {
                str = mVar.f1535d.d();
            } catch (Exception unused) {
                str = str2;
            }
            if (str != null) {
                str2 = str;
            }
            mVar.f1517a.put("JAILBROKEN", str2);
            this.f1517a.putAll(mVar.f1517a);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void h() {
        String str = this.m;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        this.f1517a.put("SITE_ID", str);
        String str3 = this.n;
        if (str3 == null) {
            str3 = str2;
        }
        this.f1517a.put("SESSION_ID", str3);
        String str4 = this.o;
        if (str4 == null) {
            str4 = str2;
        }
        this.f1517a.put("SESSION_CREATED", str4);
        this.f1517a.put("FWVERSION", "1.5.33");
        String valueOf = String.valueOf(1053300);
        if (valueOf != null) {
            str2 = valueOf;
        }
        this.f1517a.put("FWBUILD", str2);
        this.f1517a.put("FWFLAVOR", "lite");
    }

    /* access modifiers changed from: private */
    public void i() {
        a aVar = this.f1548c;
        if (aVar != null) {
            try {
                aVar.a(aVar.f1509b);
            } catch (Exception e2) {
                if (f.a().f1677b && e2.getMessage() != null) {
                    e2.getLocalizedMessage();
                }
            }
            this.f1517a.putAll(aVar.f1517a);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void j() {
        b.b(Shield.LOG_LEVEL).a("SHIELD FP PROCESS -> start collecting unchanged contexts", new Object[0]);
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        CompletableFuture exceptionally = CompletableFuture.runAsync(new Runnable() {
            public final void run() {
                t.this.h();
            }
        }).exceptionally($$Lambda$KpiWYhAhHm0HUICPAvbQ_XiqogI.INSTANCE);
        try {
            CompletableFuture.andTree(new CompletableFuture[]{CompletableFuture.runAsync(new Runnable() {
                public final void run() {
                    t.this.c();
                }
            }, newCachedThreadPool).exceptionally($$Lambda$O9Kia9GX8XlRh7IiYWeS8o7JIVg.INSTANCE), CompletableFuture.runAsync(new Runnable() {
                public final void run() {
                    t.this.i();
                }
            }, newCachedThreadPool).exceptionally($$Lambda$KJigLdPx4KUlnGSkwFWWNGwvTOk.INSTANCE), CompletableFuture.runAsync(new Runnable() {
                public final void run() {
                    t.this.f();
                }
            }, newCachedThreadPool).exceptionally($$Lambda$RC2uH9Pk6FG6rhBNVKA9x33iQU.INSTANCE), CompletableFuture.runAsync(new Runnable() {
                public final void run() {
                    t.this.g();
                }
            }, newCachedThreadPool).exceptionally($$Lambda$QxS8Xa0pzUJXnlGXRzYpFPeiQE4.INSTANCE), exceptionally}, 0, 4).get();
        } catch (Exception unused) {
        }
        newCachedThreadPool.shutdown();
        b.b(Shield.LOG_LEVEL).a("SHIELD FP PROCESS -> end collecting unchanged contexts", new Object[0]);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0302 A[Catch:{ Exception -> 0x032b }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x035a  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x037e A[Catch:{ Exception -> 0x0390 }, LOOP:3: B:143:0x0378->B:145:0x037e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x03a8  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x03cd A[Catch:{ Exception -> 0x03df }, LOOP:4: B:158:0x03c7->B:160:0x03cd, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x03f7  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0416  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x042f  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x044d A[Catch:{ Exception -> 0x0474 }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x046f A[Catch:{ Exception -> 0x0474 }] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x048a  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x04a2  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x04ab  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x04c9  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x04cc  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x032b A[EDGE_INSN: B:231:0x032b->B:124:0x032b ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x017a A[Catch:{ Exception -> 0x01b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0267 A[Catch:{ Exception -> 0x0271 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0294  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k() {
        /*
            r17 = this;
            r1 = r17
            com.shield.android.Shield$LogLevel r0 = com.shield.android.Shield.LOG_LEVEL
            com.shield.android.internal.b r0 = com.shield.android.internal.b.b(r0)
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = "SHIELD FP PROCESS -> start collecting system contexts"
            r0.a(r4, r3)
            com.shield.android.c.u r3 = r1.g
            if (r3 == 0) goto L_0x04f5
            java.lang.String r4 = "accessibility"
            java.lang.String r5 = "RUNNING_TASKS"
            java.lang.String r6 = "|"
            java.lang.String r7 = ","
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r0 = r0.getDisplayLanguage()
            java.lang.String r8 = ""
            if (r0 != 0) goto L_0x0029
            r0 = r8
        L_0x0029:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r9 = r3.f1517a
            java.lang.String r10 = "LANGUAGE"
            r9.put(r10, r0)
            r9 = 1
            android.graphics.Typeface r0 = android.graphics.Typeface.DEFAULT     // Catch:{ Exception -> 0x0078 }
            android.graphics.Typeface r0 = android.graphics.Typeface.create(r0, r2)     // Catch:{ Exception -> 0x0078 }
            java.lang.Class<android.graphics.Typeface> r10 = android.graphics.Typeface.class
            java.lang.String r11 = "sSystemFontMap"
            java.lang.reflect.Field r10 = r10.getDeclaredField(r11)     // Catch:{ Exception -> 0x0078 }
            r10.setAccessible(r9)     // Catch:{ Exception -> 0x0078 }
            java.lang.Object r0 = r10.get(r0)     // Catch:{ Exception -> 0x0078 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x0078 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ Exception -> 0x0078 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0078 }
            r10 = r8
        L_0x0051:
            boolean r11 = r0.hasNext()     // Catch:{ Exception -> 0x0076 }
            if (r11 == 0) goto L_0x008d
            java.lang.Object r11 = r0.next()     // Catch:{ Exception -> 0x0076 }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ Exception -> 0x0076 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0076 }
            r12.<init>()     // Catch:{ Exception -> 0x0076 }
            r12.append(r10)     // Catch:{ Exception -> 0x0076 }
            java.lang.Object r11 = r11.getKey()     // Catch:{ Exception -> 0x0076 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x0076 }
            r12.append(r11)     // Catch:{ Exception -> 0x0076 }
            r12.append(r7)     // Catch:{ Exception -> 0x0076 }
            java.lang.String r10 = r12.toString()     // Catch:{ Exception -> 0x0076 }
            goto L_0x0051
        L_0x0076:
            r0 = move-exception
            goto L_0x007a
        L_0x0078:
            r0 = move-exception
            r10 = r8
        L_0x007a:
            java.lang.String r11 = r3.f1514c
            com.shield.android.internal.f r11 = com.shield.android.internal.f.a(r11)
            boolean r11 = r11.f1677b
            if (r11 == 0) goto L_0x008d
            java.lang.String r11 = r0.getMessage()
            if (r11 == 0) goto L_0x008d
            r0.getLocalizedMessage()
        L_0x008d:
            int r0 = r10.length()
            if (r0 <= 0) goto L_0x009d
            int r0 = r10.length()
            int r0 = r0 - r9
            java.lang.String r0 = r10.substring(r2, r0)
            goto L_0x009e
        L_0x009d:
            r0 = r8
        L_0x009e:
            if (r0 != 0) goto L_0x00a1
            r0 = r8
        L_0x00a1:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r2 = r3.f1517a
            java.lang.String r9 = "FONTS"
            r2.put(r9, r0)
            java.lang.String r0 = android.os.Build.VERSION.RELEASE
            if (r0 != 0) goto L_0x00ad
            r0 = r8
        L_0x00ad:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r2 = r3.f1517a
            java.lang.String r9 = "OS"
            r2.put(r9, r0)
            android.content.Context r0 = r3.f1513b
            java.lang.String r2 = "window"
            java.lang.Object r2 = r0.getSystemService(r2)     // Catch:{ Exception -> 0x0115 }
            android.view.WindowManager r2 = (android.view.WindowManager) r2     // Catch:{ Exception -> 0x0115 }
            android.view.Display r2 = r2.getDefaultDisplay()     // Catch:{ Exception -> 0x0115 }
            android.util.DisplayMetrics r9 = new android.util.DisplayMetrics     // Catch:{ Exception -> 0x0115 }
            r9.<init>()     // Catch:{ Exception -> 0x0115 }
            r2.getRealMetrics(r9)     // Catch:{ Exception -> 0x0115 }
            int r2 = r9.widthPixels     // Catch:{ Exception -> 0x0115 }
            int r10 = r9.heightPixels     // Catch:{ Exception -> 0x0115 }
            int r11 = r9.densityDpi     // Catch:{ Exception -> 0x0115 }
            float r12 = r9.xdpi     // Catch:{ Exception -> 0x0115 }
            float r9 = r9.ydpi     // Catch:{ Exception -> 0x0115 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x0115 }
            android.content.res.Configuration r0 = r0.getConfiguration()     // Catch:{ Exception -> 0x0115 }
            int r0 = r0.orientation     // Catch:{ Exception -> 0x0115 }
            double r13 = (double) r2
            double r0 = (double) r12
            double r13 = r13 / r0
            double r0 = (double) r10
            r12 = r8
            double r8 = (double) r9
            double r0 = r0 / r8
            r8 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r13 = java.lang.Math.pow(r13, r8)     // Catch:{ Exception -> 0x0113 }
            double r0 = java.lang.Math.pow(r0, r8)     // Catch:{ Exception -> 0x0113 }
            double r13 = r13 + r0
            double r0 = java.lang.Math.sqrt(r13)     // Catch:{ Exception -> 0x0113 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0113 }
            r8.<init>()     // Catch:{ Exception -> 0x0113 }
            r8.append(r2)     // Catch:{ Exception -> 0x0113 }
            r8.append(r6)     // Catch:{ Exception -> 0x0113 }
            r8.append(r10)     // Catch:{ Exception -> 0x0113 }
            r8.append(r6)     // Catch:{ Exception -> 0x0113 }
            r8.append(r0)     // Catch:{ Exception -> 0x0113 }
            r8.append(r6)     // Catch:{ Exception -> 0x0113 }
            r8.append(r11)     // Catch:{ Exception -> 0x0113 }
            java.lang.String r0 = r8.toString()     // Catch:{ Exception -> 0x0113 }
            goto L_0x012b
        L_0x0113:
            r0 = move-exception
            goto L_0x0117
        L_0x0115:
            r0 = move-exception
            r12 = r8
        L_0x0117:
            java.lang.String r1 = r3.f1514c
            com.shield.android.internal.f r1 = com.shield.android.internal.f.a(r1)
            boolean r1 = r1.f1677b
            if (r1 == 0) goto L_0x012a
            java.lang.String r1 = r0.getMessage()
            if (r1 == 0) goto L_0x012a
            r0.getLocalizedMessage()
        L_0x012a:
            r0 = r12
        L_0x012b:
            if (r0 != 0) goto L_0x012e
            r0 = r12
        L_0x012e:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r1 = r3.f1517a
            java.lang.String r2 = "DISPLAY"
            r1.put(r2, r0)
            java.lang.String r0 = "http.agent"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            if (r0 != 0) goto L_0x013e
            r0 = r12
        L_0x013e:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r1 = r3.f1517a
            java.lang.String r2 = "BROWSER"
            r1.put(r2, r0)
            java.util.GregorianCalendar r0 = new java.util.GregorianCalendar
            r0.<init>()
            java.util.TimeZone r0 = r0.getTimeZone()
            int r0 = r0.getRawOffset()
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.HOURS
            long r8 = (long) r0
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r0 = r1.convert(r8, r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            if (r0 != 0) goto L_0x0162
            r0 = r12
        L_0x0162:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r1 = r3.f1517a
            java.lang.String r2 = "GMT"
            r1.put(r2, r0)
            android.content.Context r0 = r3.f1513b
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x01b6 }
            r1.<init>()     // Catch:{ Exception -> 0x01b6 }
            java.lang.String r2 = "activity"
            java.lang.Object r0 = r0.getSystemService(r2)     // Catch:{ Exception -> 0x01b6 }
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0     // Catch:{ Exception -> 0x01b6 }
            if (r0 == 0) goto L_0x01b1
            r2 = 2147483647(0x7fffffff, float:NaN)
            java.util.List r0 = r0.getRunningTasks(r2)     // Catch:{ Exception -> 0x01b6 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x01b6 }
        L_0x0185:
            boolean r2 = r0.hasNext()     // Catch:{ Exception -> 0x01b6 }
            if (r2 == 0) goto L_0x01b1
            java.lang.Object r2 = r0.next()     // Catch:{ Exception -> 0x01b6 }
            android.app.ActivityManager$RunningTaskInfo r2 = (android.app.ActivityManager.RunningTaskInfo) r2     // Catch:{ Exception -> 0x01b6 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b6 }
            r8.<init>()     // Catch:{ Exception -> 0x01b6 }
            android.content.ComponentName r9 = r2.baseActivity     // Catch:{ Exception -> 0x01b6 }
            java.lang.String r9 = r9.toShortString()     // Catch:{ Exception -> 0x01b6 }
            r8.append(r9)     // Catch:{ Exception -> 0x01b6 }
            java.lang.String r9 = ":"
            r8.append(r9)     // Catch:{ Exception -> 0x01b6 }
            int r2 = r2.numRunning     // Catch:{ Exception -> 0x01b6 }
            r8.append(r2)     // Catch:{ Exception -> 0x01b6 }
            java.lang.String r2 = r8.toString()     // Catch:{ Exception -> 0x01b6 }
            r1.add(r2)     // Catch:{ Exception -> 0x01b6 }
            goto L_0x0185
        L_0x01b1:
            java.lang.String r0 = android.text.TextUtils.join(r6, r1)     // Catch:{ Exception -> 0x01b6 }
            goto L_0x01c9
        L_0x01b6:
            java.lang.String r0 = r3.f1514c
            com.shield.android.internal.f r0 = com.shield.android.internal.f.a(r0)
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            boolean r0 = r0.f1677b
            if (r0 == 0) goto L_0x01c7
            java.lang.String.format(r5, r1)
        L_0x01c7:
            java.lang.String r0 = "error"
        L_0x01c9:
            if (r0 != 0) goto L_0x01cc
            r0 = r12
        L_0x01cc:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r1 = r3.f1517a
            r1.put(r5, r0)
            android.content.Context r0 = r3.f1513b
            java.lang.String r1 = "voltage"
            java.lang.String r2 = "temperature"
            java.lang.String r5 = "technology"
            java.lang.String r6 = "present"
            java.lang.String r8 = "scale"
            java.lang.String r9 = "level"
            java.lang.String r10 = "status"
            java.lang.String r11 = "plugged"
            java.lang.String r13 = "health"
            java.util.HashMap r14 = new java.util.HashMap
            r14.<init>()
            android.content.IntentFilter r15 = new android.content.IntentFilter     // Catch:{ Exception -> 0x0273 }
            r16 = r12
            java.lang.String r12 = "android.intent.action.BATTERY_CHANGED"
            r15.<init>(r12)     // Catch:{ Exception -> 0x0271 }
            r12 = 0
            android.content.Intent r0 = r0.registerReceiver(r12, r15)     // Catch:{ Exception -> 0x0271 }
            r12 = -1
            int r15 = r0.getIntExtra(r13, r12)     // Catch:{ Exception -> 0x0271 }
            java.lang.String r15 = java.lang.String.valueOf(r15)     // Catch:{ Exception -> 0x0271 }
            r14.put(r13, r15)     // Catch:{ Exception -> 0x0271 }
            int r13 = r0.getIntExtra(r11, r12)     // Catch:{ Exception -> 0x0271 }
            java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch:{ Exception -> 0x0271 }
            r14.put(r11, r13)     // Catch:{ Exception -> 0x0271 }
            int r11 = r0.getIntExtra(r10, r12)     // Catch:{ Exception -> 0x0271 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0271 }
            r14.put(r10, r11)     // Catch:{ Exception -> 0x0271 }
            int r10 = r0.getIntExtra(r9, r12)     // Catch:{ Exception -> 0x0271 }
            int r11 = r0.getIntExtra(r8, r12)     // Catch:{ Exception -> 0x0271 }
            java.lang.String r12 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x0271 }
            r14.put(r9, r12)     // Catch:{ Exception -> 0x0271 }
            java.lang.String r9 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0271 }
            r14.put(r8, r9)     // Catch:{ Exception -> 0x0271 }
            java.lang.String r8 = "percentage"
            float r9 = (float) r10
            float r10 = (float) r11
            float r9 = r9 / r10
            r10 = 1120403456(0x42c80000, float:100.0)
            float r9 = r9 * r10
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x0271 }
            r14.put(r8, r9)     // Catch:{ Exception -> 0x0271 }
            r8 = 1
            boolean r8 = r0.getBooleanExtra(r6, r8)     // Catch:{ Exception -> 0x0271 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x0271 }
            r14.put(r6, r8)     // Catch:{ Exception -> 0x0271 }
            java.lang.String r6 = r0.getStringExtra(r5)     // Catch:{ Exception -> 0x0271 }
            r14.put(r5, r6)     // Catch:{ Exception -> 0x0271 }
            r5 = -1
            int r6 = r0.getIntExtra(r2, r5)     // Catch:{ Exception -> 0x0271 }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x0271 }
            r14.put(r2, r6)     // Catch:{ Exception -> 0x0271 }
            int r0 = r0.getIntExtra(r1, r5)     // Catch:{ Exception -> 0x0271 }
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r0 >= r2) goto L_0x0269
            int r0 = r0 * 1000
        L_0x0269:
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0271 }
            r14.put(r1, r0)     // Catch:{ Exception -> 0x0271 }
            goto L_0x0289
        L_0x0271:
            r0 = move-exception
            goto L_0x0276
        L_0x0273:
            r0 = move-exception
            r16 = r12
        L_0x0276:
            java.lang.String r1 = r3.f1514c
            com.shield.android.internal.f r1 = com.shield.android.internal.f.a(r1)
            boolean r1 = r1.f1677b
            if (r1 == 0) goto L_0x0289
            java.lang.String r1 = r0.getMessage()
            if (r1 == 0) goto L_0x0289
            r0.getLocalizedMessage()
        L_0x0289:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r14)
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x0296
            r0 = r16
        L_0x0296:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r1 = r3.f1517a
            java.lang.String r2 = "BATTERY"
            r1.put(r2, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02bf }
            r0.<init>()     // Catch:{ Exception -> 0x02bf }
            java.lang.String r1 = "realtime:"
            r0.append(r1)     // Catch:{ Exception -> 0x02bf }
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x02bf }
            r0.append(r1)     // Catch:{ Exception -> 0x02bf }
            java.lang.String r1 = ",uptime:"
            r0.append(r1)     // Catch:{ Exception -> 0x02bf }
            long r1 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception -> 0x02bf }
            r0.append(r1)     // Catch:{ Exception -> 0x02bf }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02bf }
            goto L_0x02d5
        L_0x02bf:
            r0 = move-exception
            java.lang.String r1 = r3.f1514c
            com.shield.android.internal.f r1 = com.shield.android.internal.f.a(r1)
            boolean r1 = r1.f1677b
            if (r1 == 0) goto L_0x02d3
            java.lang.String r1 = r0.getMessage()
            if (r1 == 0) goto L_0x02d3
            r0.getLocalizedMessage()
        L_0x02d3:
            r0 = r16
        L_0x02d5:
            if (r0 != 0) goto L_0x02d9
            r0 = r16
        L_0x02d9:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r1 = r3.f1517a
            java.lang.String r2 = "TIME_SINCE_BOOT"
            r1.put(r2, r0)
            android.content.Context r0 = r3.f1513b
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0342 }
            r1.<init>()     // Catch:{ Exception -> 0x0342 }
            java.lang.String r2 = "using_vpn"
            boolean r5 = r3.m(r0)     // Catch:{ Exception -> 0x0342 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0342 }
            r1.put(r2, r5)     // Catch:{ Exception -> 0x0342 }
            java.lang.String r2 = "vpn_port"
            java.util.Enumeration r5 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch:{ Exception -> 0x032b }
            r6 = r16
        L_0x02fc:
            boolean r8 = r5.hasMoreElements()     // Catch:{ Exception -> 0x032b }
            if (r8 == 0) goto L_0x032b
            java.lang.Object r8 = r5.nextElement()     // Catch:{ Exception -> 0x032b }
            java.net.NetworkInterface r8 = (java.net.NetworkInterface) r8     // Catch:{ Exception -> 0x032b }
            boolean r9 = r8.isUp()     // Catch:{ Exception -> 0x032b }
            if (r9 == 0) goto L_0x0312
            java.lang.String r6 = r8.getName()     // Catch:{ Exception -> 0x032b }
        L_0x0312:
            java.lang.String r8 = "tun"
            boolean r8 = r6.contains(r8)     // Catch:{ Exception -> 0x032b }
            if (r8 != 0) goto L_0x032d
            java.lang.String r8 = "ppp"
            boolean r8 = r6.contains(r8)     // Catch:{ Exception -> 0x032b }
            if (r8 != 0) goto L_0x032d
            java.lang.String r8 = "pptp"
            boolean r8 = r6.contains(r8)     // Catch:{ Exception -> 0x032b }
            if (r8 == 0) goto L_0x02fc
            goto L_0x032d
        L_0x032b:
            java.lang.String r6 = "tun0"
        L_0x032d:
            r1.put(r2, r6)     // Catch:{ Exception -> 0x0342 }
            java.lang.String r2 = "using_fakegps"
            boolean r0 = r3.l(r0)     // Catch:{ Exception -> 0x0342 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0342 }
            r1.put(r2, r0)     // Catch:{ Exception -> 0x0342 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0342 }
            goto L_0x0358
        L_0x0342:
            r0 = move-exception
            java.lang.String r1 = r3.f1514c
            com.shield.android.internal.f r1 = com.shield.android.internal.f.a(r1)
            boolean r1 = r1.f1677b
            if (r1 == 0) goto L_0x0356
            java.lang.String r1 = r0.getMessage()
            if (r1 == 0) goto L_0x0356
            r0.getLocalizedMessage()
        L_0x0356:
            r0 = r16
        L_0x0358:
            if (r0 != 0) goto L_0x035c
            r0 = r16
        L_0x035c:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r1 = r3.f1517a
            java.lang.String r2 = "BACKGROUND_APP_USAGE"
            r1.put(r2, r0)
            android.content.Context r0 = r3.f1513b
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.Object r0 = r0.getSystemService(r4)     // Catch:{ Exception -> 0x0390 }
            android.view.accessibility.AccessibilityManager r0 = (android.view.accessibility.AccessibilityManager) r0     // Catch:{ Exception -> 0x0390 }
            java.util.List r0 = r0.getInstalledAccessibilityServiceList()     // Catch:{ Exception -> 0x0390 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0390 }
        L_0x0378:
            boolean r2 = r0.hasNext()     // Catch:{ Exception -> 0x0390 }
            if (r2 == 0) goto L_0x03a2
            java.lang.Object r2 = r0.next()     // Catch:{ Exception -> 0x0390 }
            android.accessibilityservice.AccessibilityServiceInfo r2 = (android.accessibilityservice.AccessibilityServiceInfo) r2     // Catch:{ Exception -> 0x0390 }
            android.content.pm.ResolveInfo r2 = r2.getResolveInfo()     // Catch:{ Exception -> 0x0390 }
            android.content.pm.ServiceInfo r2 = r2.serviceInfo     // Catch:{ Exception -> 0x0390 }
            java.lang.String r2 = r2.packageName     // Catch:{ Exception -> 0x0390 }
            r1.add(r2)     // Catch:{ Exception -> 0x0390 }
            goto L_0x0378
        L_0x0390:
            r0 = move-exception
            com.shield.android.internal.f r2 = com.shield.android.internal.f.a()
            boolean r2 = r2.f1677b
            if (r2 == 0) goto L_0x03a2
            java.lang.String r2 = r0.getMessage()
            if (r2 == 0) goto L_0x03a2
            r0.getLocalizedMessage()
        L_0x03a2:
            java.lang.String r0 = android.text.TextUtils.join(r7, r1)
            if (r0 != 0) goto L_0x03aa
            r0 = r16
        L_0x03aa:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r1 = r3.f1517a
            java.lang.String r2 = "INSTALLED_ACCESSIBILITY_SERVICES"
            r1.put(r2, r0)
            android.content.Context r0 = r3.f1513b
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.Object r0 = r0.getSystemService(r4)     // Catch:{ Exception -> 0x03df }
            android.view.accessibility.AccessibilityManager r0 = (android.view.accessibility.AccessibilityManager) r0     // Catch:{ Exception -> 0x03df }
            r2 = -1
            java.util.List r0 = r0.getEnabledAccessibilityServiceList(r2)     // Catch:{ Exception -> 0x03df }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x03df }
        L_0x03c7:
            boolean r2 = r0.hasNext()     // Catch:{ Exception -> 0x03df }
            if (r2 == 0) goto L_0x03f1
            java.lang.Object r2 = r0.next()     // Catch:{ Exception -> 0x03df }
            android.accessibilityservice.AccessibilityServiceInfo r2 = (android.accessibilityservice.AccessibilityServiceInfo) r2     // Catch:{ Exception -> 0x03df }
            android.content.pm.ResolveInfo r2 = r2.getResolveInfo()     // Catch:{ Exception -> 0x03df }
            android.content.pm.ServiceInfo r2 = r2.serviceInfo     // Catch:{ Exception -> 0x03df }
            java.lang.String r2 = r2.packageName     // Catch:{ Exception -> 0x03df }
            r1.add(r2)     // Catch:{ Exception -> 0x03df }
            goto L_0x03c7
        L_0x03df:
            r0 = move-exception
            com.shield.android.internal.f r2 = com.shield.android.internal.f.a()
            boolean r2 = r2.f1677b
            if (r2 == 0) goto L_0x03f1
            java.lang.String r2 = r0.getMessage()
            if (r2 == 0) goto L_0x03f1
            r0.getLocalizedMessage()
        L_0x03f1:
            java.lang.String r0 = android.text.TextUtils.join(r7, r1)
            if (r0 != 0) goto L_0x03f9
            r0 = r16
        L_0x03f9:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r1 = r3.f1517a
            java.lang.String r2 = "ENABLED_ACCESSIBILITY_SERVICES"
            r1.put(r2, r0)
            android.content.Context r0 = r3.f1513b
            java.lang.String r1 = "{ \"debuggable\": "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ Exception -> 0x0418 }
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()     // Catch:{ Exception -> 0x0418 }
            int r0 = r0.flags     // Catch:{ Exception -> 0x0418 }
            r0 = r0 & 2
            if (r0 == 0) goto L_0x0418
            r0 = 1
            goto L_0x0419
        L_0x0418:
            r0 = 0
        L_0x0419:
            r1.append(r0)
            java.lang.String r0 = ", \"debugger_connected\": "
            r1.append(r0)
            boolean r0 = android.os.Debug.isDebuggerConnected()     // Catch:{ Exception -> 0x0426 }
            goto L_0x0427
        L_0x0426:
            r0 = 0
        L_0x0427:
            java.lang.String r2 = " }"
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline66(r1, r0, r2)
            if (r0 != 0) goto L_0x0431
            r0 = r16
        L_0x0431:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r1 = r3.f1517a
            java.lang.String r2 = "IS_DEBUGGING"
            r1.put(r2, r0)
            android.content.Context r0 = r3.f1513b
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0474 }
            r1.<init>()     // Catch:{ Exception -> 0x0474 }
            java.lang.String r2 = "device_policy"
            java.lang.Object r0 = r0.getSystemService(r2)     // Catch:{ Exception -> 0x0474 }
            android.app.admin.DevicePolicyManager r0 = (android.app.admin.DevicePolicyManager) r0     // Catch:{ Exception -> 0x0474 }
            java.util.List r2 = r0.getActiveAdmins()     // Catch:{ Exception -> 0x0474 }
            if (r2 == 0) goto L_0x0469
            java.util.List r0 = r0.getActiveAdmins()     // Catch:{ Exception -> 0x0474 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0474 }
        L_0x0455:
            boolean r2 = r0.hasNext()     // Catch:{ Exception -> 0x0474 }
            if (r2 == 0) goto L_0x0469
            java.lang.Object r2 = r0.next()     // Catch:{ Exception -> 0x0474 }
            android.content.ComponentName r2 = (android.content.ComponentName) r2     // Catch:{ Exception -> 0x0474 }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ Exception -> 0x0474 }
            r1.add(r2)     // Catch:{ Exception -> 0x0474 }
            goto L_0x0455
        L_0x0469:
            boolean r0 = r1.isEmpty()     // Catch:{ Exception -> 0x0474 }
            if (r0 != 0) goto L_0x0486
            java.lang.String r0 = android.text.TextUtils.join(r7, r1)     // Catch:{ Exception -> 0x0474 }
            goto L_0x0488
        L_0x0474:
            r0 = move-exception
            com.shield.android.internal.f r1 = com.shield.android.internal.f.a()
            boolean r1 = r1.f1677b
            if (r1 == 0) goto L_0x0486
            java.lang.String r1 = r0.getMessage()
            if (r1 == 0) goto L_0x0486
            r0.getLocalizedMessage()
        L_0x0486:
            r0 = r16
        L_0x0488:
            if (r0 != 0) goto L_0x048c
            r0 = r16
        L_0x048c:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r1 = r3.f1517a
            java.lang.String r2 = "DEVICE_ADMINS"
            r1.put(r2, r0)
            android.content.Context r0 = r3.f1513b
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x04a4 }
            java.lang.String r1 = "data_roaming"
            int r0 = android.provider.Settings.Global.getInt(r0, r1)     // Catch:{ Exception -> 0x04a4 }
            r1 = 1
            if (r0 != r1) goto L_0x04a4
            r0 = 1
            goto L_0x04a5
        L_0x04a4:
            r0 = 0
        L_0x04a5:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            if (r0 != 0) goto L_0x04ad
            r0 = r16
        L_0x04ad:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r1 = r3.f1517a
            java.lang.String r2 = "DATA_ROAMING"
            r1.put(r2, r0)
            android.content.Context r0 = r3.f1513b
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x04c5 }
            android.content.res.Configuration r0 = r0.getConfiguration()     // Catch:{ Exception -> 0x04c5 }
            float r0 = r0.fontScale     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x04c5 }
            goto L_0x04c7
        L_0x04c5:
            java.lang.String r0 = "1.0"
        L_0x04c7:
            if (r0 != 0) goto L_0x04cc
            r8 = r16
            goto L_0x04cd
        L_0x04cc:
            r8 = r0
        L_0x04cd:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r0 = r3.f1517a
            java.lang.String r1 = "FONT_SCALE"
            r0.put(r1, r8)
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r0 = r3.f1517a
            java.lang.String r1 = "PLATFORM"
            java.lang.String r2 = "2"
            r0.put(r1, r2)
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r0 = r3.f1517a
            r1 = r17
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r2 = r1.f1517a
            r2.putAll(r0)
            com.shield.android.Shield$LogLevel r0 = com.shield.android.Shield.LOG_LEVEL
            com.shield.android.internal.b r0 = com.shield.android.internal.b.b(r0)
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "SHIELD FP PROCESS -> end collecting system contexts"
            r0.a(r3, r2)
            return
        L_0x04f5:
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shield.android.c.t.k():void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(106:2|(3:4|5|6)(1:9)|10|(2:11|12)|13|(2:15|16)|17|(2:19|20)|22|(1:(1:25)(1:26))(1:27)|28|29|30|32|(3:34|(4:37|(2:39|(2:41|374)(2:42|375))(1:373)|371|35)|372)|43|(2:44|45)|47|(1:59)(4:51|(4:54|(2:56|377)(1:378)|57|52)|376|58)|60|(2:61|62)|63|(2:65|66)|69|(2:70|71)|72|74|75|76|(2:78|79)|81|(3:83|84|85)(1:88)|89|(2:90|91)|93|(1:95)(2:96|(4:98|99|100|103)(1:104))|105|(2:106|107)|108|110|111|113|(1:115)(1:116)|117|(3:119|120|121)(1:122)|123|125|126|128|(1:130)(1:131)|132|(2:133|134)|136|(1:138)(1:139)|140|141|142|144|(1:146)(1:147)|148|(2:149|150)|151|153|154|155|(2:157|158)|160|(4:162|163|164|167)(1:168)|169|(2:170|171)|172|(2:174|175)|176|(2:178|179)|180|(2:182|183)|(2:186|187)|188|(2:190|191)|194|195|196|(2:198|199)|201|(1:203)(1:204)|205|(2:206|207)|208|210|211|212|(2:214|215)|216|(2:218|219)|220|222|223|224|225|(1:227)(2:228|(1:230))|233|(2:234|235)|237|(1:239)|240|(7:242|243|244|(1:246)|247|254|(24:256|257|258|259|260|(1:262)|263|264|265|266|(1:268)|269|270|271|272|(1:274)|275|276|277|278|(1:280)|281|288|(5:290|291|(1:298)(1:297)|305|(5:307|308|(5:310|311|312|(1:314)|315)|329|(9:331|332|333|(1:335)|336|343|(4:345|346|(1:348)(1:349)|350)|357|358)(2:359|360))(2:361|362))(2:363|364))(2:365|366))(2:367|368)) */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0381, code lost:
        r12 = "error";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:224:0x036d */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x0375 A[Catch:{ Exception -> 0x0381 }] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0377 A[Catch:{ Exception -> 0x0381 }] */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0390  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x03a3  */
    /* JADX WARNING: Removed duplicated region for block: B:367:0x0536  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void l() {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r2 = "JAILBROKEN"
            com.shield.android.Shield$LogLevel r0 = com.shield.android.Shield.LOG_LEVEL
            com.shield.android.internal.b r0 = com.shield.android.internal.b.b(r0)
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.lang.String r5 = "SHIELD FP PROCESS -> start collecting other contexts"
            r0.a(r5, r4)
            com.shield.android.c.i r0 = r1.l
            if (r0 == 0) goto L_0x0538
            java.lang.String r5 = "SETTING_CLASS_NAME"
            java.lang.String r6 = "settings_classname"
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            r8 = 17
            boolean r9 = com.shield.android.internal.j.a(r8)
            java.lang.String r10 = "adb_enabled"
            java.lang.String r11 = ""
            if (r9 == 0) goto L_0x0038
            android.content.Context r9 = r0.f1523b
            android.content.ContentResolver r9 = r9.getContentResolver()     // Catch:{ Exception -> 0x0036 }
            java.lang.String r9 = android.provider.Settings.Global.getString(r9, r10)     // Catch:{ Exception -> 0x0036 }
            goto L_0x003e
        L_0x0036:
            r9 = r11
            goto L_0x003e
        L_0x0038:
            android.content.Context r9 = r0.f1523b
            java.lang.String r9 = com.shield.android.internal.j.g(r9, r10)
        L_0x003e:
            java.lang.String r10 = "ADB_ENABLED"
            r7.put(r10, r9)     // Catch:{ JSONException -> 0x0043 }
        L_0x0043:
            android.content.Context r9 = r0.f1523b
            java.lang.String r10 = "screen_brightness"
            java.lang.String r9 = com.shield.android.internal.j.g(r9, r10)
            java.lang.String r10 = "SCREEN_BRIGHTNESS"
            r7.put(r10, r9)     // Catch:{ JSONException -> 0x0050 }
        L_0x0050:
            android.content.Context r9 = r0.f1523b
            java.lang.String r10 = "screen_brightness_mode"
            java.lang.String r9 = com.shield.android.internal.j.g(r9, r10)
            java.lang.String r10 = "AUTO_SCREEN_BRIGHTNESS_ENABLED"
            r7.put(r10, r9)     // Catch:{ JSONException -> 0x005e }
            goto L_0x005f
        L_0x005e:
        L_0x005f:
            android.content.Context r9 = r0.f1523b
            java.lang.String r10 = "audio"
            java.lang.Object r9 = r9.getSystemService(r10)
            android.media.AudioManager r9 = (android.media.AudioManager) r9
            int r9 = r9.getRingerMode()
            r10 = 1
            if (r9 == 0) goto L_0x0078
            if (r9 == r10) goto L_0x0075
            java.lang.String r9 = "NORMAL"
            goto L_0x007a
        L_0x0075:
            java.lang.String r9 = "VIBRATE"
            goto L_0x007a
        L_0x0078:
            java.lang.String r9 = "SILENT"
        L_0x007a:
            java.lang.String r12 = "RINGER_MODE"
            r7.put(r12, r9)     // Catch:{ JSONException -> 0x0080 }
            goto L_0x0081
        L_0x0080:
        L_0x0081:
            android.content.Context r9 = r0.f1523b
            java.lang.String r12 = "sensor"
            java.lang.Object r9 = r9.getSystemService(r12)
            android.hardware.SensorManager r9 = (android.hardware.SensorManager) r9
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r13 = -1
            java.util.List r9 = r9.getSensorList(r13)
            java.lang.String r13 = ", "
            if (r9 == 0) goto L_0x00c5
            java.util.Iterator r9 = r9.iterator()
        L_0x009d:
            boolean r14 = r9.hasNext()
            if (r14 == 0) goto L_0x00c5
            java.lang.Object r14 = r9.next()
            android.hardware.Sensor r14 = (android.hardware.Sensor) r14
            if (r14 != 0) goto L_0x00ac
            goto L_0x009d
        L_0x00ac:
            int r15 = r12.length()
            if (r15 != 0) goto L_0x00ba
            java.lang.String r14 = r14.getName()
            r12.append(r14)
            goto L_0x009d
        L_0x00ba:
            r12.append(r13)
            java.lang.String r14 = r14.getName()
            r12.append(r14)
            goto L_0x009d
        L_0x00c5:
            java.lang.String r9 = r12.toString()
            java.lang.String r12 = "SENSORS_COUNT"
            r7.put(r12, r9)     // Catch:{ JSONException -> 0x00cf }
            goto L_0x00d0
        L_0x00cf:
        L_0x00d0:
            android.content.Context r9 = r0.f1523b
            java.lang.String r12 = "input_method"
            java.lang.Object r9 = r9.getSystemService(r12)
            android.view.inputmethod.InputMethodManager r9 = (android.view.inputmethod.InputMethodManager) r9
            java.util.List r9 = r9.getInputMethodList()
            if (r9 == 0) goto L_0x0112
            int r12 = r9.size()
            if (r12 <= 0) goto L_0x0112
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r14 = 0
        L_0x00ec:
            int r15 = r9.size()
            if (r14 >= r15) goto L_0x010d
            java.lang.Object r15 = r9.get(r14)
            android.view.inputmethod.InputMethodInfo r15 = (android.view.inputmethod.InputMethodInfo) r15
            java.lang.String r15 = r15.getPackageName()
            r12.append(r15)
            int r15 = r14 + -1
            int r4 = r9.size()
            if (r15 >= r4) goto L_0x010a
            r12.append(r13)
        L_0x010a:
            int r14 = r14 + 1
            goto L_0x00ec
        L_0x010d:
            java.lang.String r4 = r12.toString()
            goto L_0x0113
        L_0x0112:
            r4 = r11
        L_0x0113:
            java.lang.String r9 = "INPUT_METHOD"
            r7.put(r9, r4)     // Catch:{ JSONException -> 0x0118 }
        L_0x0118:
            android.content.Context r4 = r0.f1523b
            java.lang.String r9 = "default_input_method"
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x0125 }
            java.lang.String r4 = android.provider.Settings.Secure.getString(r4, r9)     // Catch:{ Exception -> 0x0125 }
            goto L_0x0126
        L_0x0125:
            r4 = r11
        L_0x0126:
            java.lang.String r9 = "DEFAULT_INPUT_METHOD"
            r7.put(r9, r4)     // Catch:{ JSONException -> 0x012b }
        L_0x012b:
            android.content.Context r4 = r0.f1523b
            java.lang.String r9 = "accelerometer_rotation"
            int r4 = com.shield.android.internal.j.f(r4, r9)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r9 = "ACCELEROMETER_ROTATION"
            r7.put(r9, r4)     // Catch:{ JSONException -> 0x013c }
        L_0x013c:
            android.content.Context r4 = r0.f1523b
            java.lang.String r9 = "date_format"
            java.lang.String r4 = com.shield.android.internal.j.g(r4, r9)
            java.lang.String r9 = "DATE_FORMAT"
            r7.put(r9, r4)     // Catch:{ JSONException -> 0x014a }
            goto L_0x014b
        L_0x014a:
        L_0x014b:
            boolean r4 = com.shield.android.internal.j.a(r8)
            java.lang.String r9 = "device_provisioned"
            if (r4 == 0) goto L_0x0160
            android.content.Context r4 = r0.f1523b
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x015e }
            java.lang.String r4 = android.provider.Settings.Global.getString(r4, r9)     // Catch:{ Exception -> 0x015e }
            goto L_0x0166
        L_0x015e:
            r4 = r11
            goto L_0x0166
        L_0x0160:
            android.content.Context r4 = r0.f1523b
            java.lang.String r4 = com.shield.android.internal.j.g(r4, r9)
        L_0x0166:
            java.lang.String r9 = "DEVICE_PROVISIONED"
            r7.put(r9, r4)     // Catch:{ JSONException -> 0x016c }
            goto L_0x016d
        L_0x016c:
        L_0x016d:
            boolean r4 = com.shield.android.internal.j.a(r8)
            java.lang.String r9 = "development_settings_enabled"
            java.lang.String r12 = "0"
            if (r4 == 0) goto L_0x0182
            android.content.Context r4 = r0.f1523b
            int r4 = com.shield.android.internal.j.a(r4, r9)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            goto L_0x019c
        L_0x0182:
            r4 = 16
            boolean r4 = com.shield.android.internal.j.a(r4)
            if (r4 == 0) goto L_0x019b
            android.content.Context r4 = r0.f1523b
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ SettingNotFoundException -> 0x0195 }
            int r4 = android.provider.Settings.Secure.getInt(r4, r9)     // Catch:{ SettingNotFoundException -> 0x0195 }
            goto L_0x0196
        L_0x0195:
            r4 = 0
        L_0x0196:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            goto L_0x019c
        L_0x019b:
            r4 = r12
        L_0x019c:
            java.lang.String r9 = "DEVELOPER_OPTION_ENABLED"
            r7.put(r9, r4)     // Catch:{ JSONException -> 0x01a1 }
        L_0x01a1:
            android.content.Context r4 = r0.f1523b
            java.lang.String r9 = "dtmf_tone"
            int r4 = com.shield.android.internal.j.f(r4, r9)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r9 = "DTMF_TONE"
            r7.put(r9, r4)     // Catch:{ JSONException -> 0x01b3 }
            goto L_0x01b4
        L_0x01b3:
        L_0x01b4:
            boolean r4 = com.shield.android.internal.j.a(r8)
            java.lang.String r9 = "airplane_mode_on"
            if (r4 == 0) goto L_0x01c3
            android.content.Context r4 = r0.f1523b
            int r4 = com.shield.android.internal.j.a(r4, r9)
            goto L_0x01c9
        L_0x01c3:
            android.content.Context r4 = r0.f1523b
            int r4 = com.shield.android.internal.j.f(r4, r9)
        L_0x01c9:
            java.lang.String r9 = "last_airplane_mode_on"
            java.lang.String r13 = "-1"
            if (r4 != r10) goto L_0x01e9
            long r14 = java.lang.System.currentTimeMillis()
            java.lang.String r4 = java.lang.String.valueOf(r14)
            android.content.Context r14 = r0.f1523b     // Catch:{ Exception -> 0x01f3 }
            android.content.SharedPreferences r14 = androidx.preference.PreferenceManager.getDefaultSharedPreferences(r14)     // Catch:{ Exception -> 0x01f3 }
            android.content.SharedPreferences$Editor r14 = r14.edit()     // Catch:{ Exception -> 0x01f3 }
            android.content.SharedPreferences$Editor r9 = r14.putString(r9, r4)     // Catch:{ Exception -> 0x01f3 }
            r9.apply()     // Catch:{ Exception -> 0x01f3 }
            goto L_0x01f3
        L_0x01e9:
            android.content.Context r4 = r0.f1523b
            android.content.SharedPreferences r4 = androidx.preference.PreferenceManager.getDefaultSharedPreferences(r4)
            java.lang.String r4 = r4.getString(r9, r13)
        L_0x01f3:
            java.lang.String r9 = "LAST_AIRPLANE_MODE"
            r7.put(r9, r4)     // Catch:{ JSONException -> 0x01f9 }
            goto L_0x01fa
        L_0x01f9:
        L_0x01fa:
            boolean r4 = com.shield.android.internal.j.a(r8)
            java.lang.String r9 = "auto_time"
            if (r4 == 0) goto L_0x020d
            android.content.Context r4 = r0.f1523b
            int r4 = com.shield.android.internal.j.a(r4, r9)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            goto L_0x0217
        L_0x020d:
            android.content.Context r4 = r0.f1523b
            int r4 = com.shield.android.internal.j.f(r4, r9)
            java.lang.String r4 = java.lang.String.valueOf(r4)
        L_0x0217:
            java.lang.String r14 = "AUTO_TIME"
            r7.put(r14, r4)     // Catch:{ JSONException -> 0x021d }
            goto L_0x021e
        L_0x021d:
        L_0x021e:
            boolean r4 = com.shield.android.internal.j.a(r8)
            if (r4 == 0) goto L_0x022f
            android.content.Context r4 = r0.f1523b
            int r4 = com.shield.android.internal.j.a(r4, r9)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            goto L_0x0239
        L_0x022f:
            android.content.Context r4 = r0.f1523b
            int r4 = com.shield.android.internal.j.f(r4, r9)
            java.lang.String r4 = java.lang.String.valueOf(r4)
        L_0x0239:
            java.lang.String r9 = "AUTO_TIME_ZONE"
            r7.put(r9, r4)     // Catch:{ JSONException -> 0x023f }
            goto L_0x0240
        L_0x023f:
        L_0x0240:
            boolean r4 = com.shield.android.internal.j.a(r8)
            java.lang.String r9 = "bluetooth_on"
            if (r4 == 0) goto L_0x0253
            android.content.Context r4 = r0.f1523b
            int r4 = com.shield.android.internal.j.a(r4, r9)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            goto L_0x025d
        L_0x0253:
            android.content.Context r4 = r0.f1523b
            int r4 = com.shield.android.internal.j.f(r4, r9)
            java.lang.String r4 = java.lang.String.valueOf(r4)
        L_0x025d:
            java.lang.String r9 = "BLUETOOTH"
            r7.put(r9, r4)     // Catch:{ JSONException -> 0x0262 }
        L_0x0262:
            android.content.Context r4 = r0.f1523b
            java.lang.String r9 = "end_button_behavior"
            int r4 = com.shield.android.internal.j.f(r4, r9)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r9 = "END_BUTTON_BEHAVIOUR"
            r7.put(r9, r4)     // Catch:{ JSONException -> 0x0273 }
        L_0x0273:
            android.content.Context r4 = r0.f1523b
            java.lang.String r9 = "haptic_feedback_enabled"
            int r4 = com.shield.android.internal.j.f(r4, r9)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r9 = "HAPTIC_FEEDBACK"
            r7.put(r9, r4)     // Catch:{ JSONException -> 0x0285 }
            goto L_0x0286
        L_0x0285:
        L_0x0286:
            boolean r4 = com.shield.android.internal.j.a(r8)
            java.lang.String r9 = "install_non_market_apps"
            if (r4 == 0) goto L_0x029f
            android.content.Context r4 = r0.f1523b
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ SettingNotFoundException -> 0x0299 }
            int r4 = android.provider.Settings.Secure.getInt(r4, r9)     // Catch:{ SettingNotFoundException -> 0x0299 }
            goto L_0x029a
        L_0x0299:
            r4 = 0
        L_0x029a:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            goto L_0x02a9
        L_0x029f:
            android.content.Context r4 = r0.f1523b
            int r4 = com.shield.android.internal.j.f(r4, r9)
            java.lang.String r4 = java.lang.String.valueOf(r4)
        L_0x02a9:
            java.lang.String r9 = "NON_MARKET"
            r7.put(r9, r4)     // Catch:{ JSONException -> 0x02ae }
        L_0x02ae:
            android.content.Context r4 = r0.f1523b
            java.lang.String r9 = "keyguard"
            java.lang.Object r4 = r4.getSystemService(r9)
            android.app.KeyguardManager r4 = (android.app.KeyguardManager) r4
            boolean r4 = r4.isKeyguardSecure()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r9 = "LOCK_PATTERN_ENABLED"
            r7.put(r9, r4)     // Catch:{ JSONException -> 0x02c5 }
        L_0x02c5:
            android.content.Context r4 = r0.f1523b
            java.lang.String r9 = "screen_off_timeout"
            int r4 = com.shield.android.internal.j.f(r4, r9)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r9 = "SCREEN_OFF_TIME_OUT"
            r7.put(r9, r4)     // Catch:{ JSONException -> 0x02d6 }
        L_0x02d6:
            android.content.Context r4 = r0.f1523b
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x02e1 }
            java.lang.String r4 = android.provider.Settings.Secure.getString(r4, r6)     // Catch:{ Exception -> 0x02e1 }
            goto L_0x02e2
        L_0x02e1:
            r4 = r11
        L_0x02e2:
            r7.put(r5, r4)     // Catch:{ JSONException -> 0x02e5 }
        L_0x02e5:
            android.content.Context r4 = r0.f1523b
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x02f0 }
            java.lang.String r4 = android.provider.Settings.Secure.getString(r4, r6)     // Catch:{ Exception -> 0x02f0 }
            goto L_0x02f1
        L_0x02f0:
            r4 = r11
        L_0x02f1:
            r7.put(r5, r4)     // Catch:{ JSONException -> 0x02f4 }
        L_0x02f4:
            android.content.Context r4 = r0.f1523b
            java.lang.String r5 = "sound_effects_enabled"
            int r4 = com.shield.android.internal.j.f(r4, r5)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r5 = "SOUND_EFFECT"
            r7.put(r5, r4)     // Catch:{ JSONException -> 0x0306 }
            goto L_0x0307
        L_0x0306:
        L_0x0307:
            boolean r4 = com.shield.android.internal.j.a(r8)
            java.lang.String r5 = "stay_on_while_plugged_in"
            if (r4 == 0) goto L_0x031a
            android.content.Context r4 = r0.f1523b
            int r4 = com.shield.android.internal.j.a(r4, r5)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            goto L_0x0324
        L_0x031a:
            android.content.Context r4 = r0.f1523b
            int r4 = com.shield.android.internal.j.f(r4, r5)
            java.lang.String r4 = java.lang.String.valueOf(r4)
        L_0x0324:
            java.lang.String r5 = "PLUGGED_IN_SCREEN_ON"
            r7.put(r5, r4)     // Catch:{ JSONException -> 0x0329 }
        L_0x0329:
            android.content.Context r4 = r0.f1523b
            java.lang.String r5 = "auto_caps"
            int r4 = com.shield.android.internal.j.f(r4, r5)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r5 = "AUTO_CAPS"
            r7.put(r5, r4)     // Catch:{ JSONException -> 0x033a }
        L_0x033a:
            android.content.Context r4 = r0.f1523b
            java.lang.String r5 = "auto_punctuate"
            int r4 = com.shield.android.internal.j.f(r4, r5)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r5 = "AUTO_PUNCTUATE"
            r7.put(r5, r4)     // Catch:{ JSONException -> 0x034b }
        L_0x034b:
            android.content.Context r4 = r0.f1523b
            java.lang.String r5 = "auto_replace"
            int r4 = com.shield.android.internal.j.f(r4, r5)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r5 = "AUTO_REPLACE"
            r7.put(r5, r4)     // Catch:{ JSONException -> 0x035c }
        L_0x035c:
            android.content.Context r4 = r0.f1523b
            java.lang.String r5 = "show_password"
            int r4 = com.shield.android.internal.j.f(r4, r5)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r5 = "SHOW_PASSWORD"
            r7.put(r5, r4)     // Catch:{ JSONException -> 0x036d }
        L_0x036d:
            android.content.Context r4 = r0.f1523b     // Catch:{ Exception -> 0x0381 }
            android.nfc.NfcAdapter r4 = android.nfc.NfcAdapter.getDefaultAdapter(r4)     // Catch:{ Exception -> 0x0381 }
            if (r4 != 0) goto L_0x0377
            r12 = r13
            goto L_0x0383
        L_0x0377:
            boolean r4 = r4.isEnabled()     // Catch:{ Exception -> 0x0381 }
            if (r4 != 0) goto L_0x037e
            goto L_0x0383
        L_0x037e:
            java.lang.String r12 = "1"
            goto L_0x0383
        L_0x0381:
            java.lang.String r12 = "error"
        L_0x0383:
            java.lang.String r4 = "NFC"
            r7.put(r4, r12)     // Catch:{ JSONException -> 0x0389 }
            goto L_0x038a
        L_0x0389:
        L_0x038a:
            java.lang.String r4 = r7.toString()
            if (r4 != 0) goto L_0x0391
            r4 = r11
        L_0x0391:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r5 = r0.f1517a
            java.lang.String r6 = "SETTINGS_MAIN"
            r5.put(r6, r4)
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r0 = r0.f1517a
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r4 = r1.f1517a
            r4.putAll(r0)
            com.shield.android.c.v r4 = r1.h
            if (r4 == 0) goto L_0x0536
            java.lang.String r0 = "PHOTOS"
            android.content.Context r5 = r4.f1516b     // Catch:{ Exception -> 0x03b4 }
            java.lang.String r5 = r4.a(r5)     // Catch:{ Exception -> 0x03b4 }
            if (r5 != 0) goto L_0x03ae
            r5 = r11
        L_0x03ae:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r6 = r4.f1517a     // Catch:{ Exception -> 0x03b4 }
            r6.put(r0, r5)     // Catch:{ Exception -> 0x03b4 }
            goto L_0x03c6
        L_0x03b4:
            r0 = move-exception
            com.shield.android.internal.f r5 = com.shield.android.internal.f.a()
            boolean r5 = r5.f1677b
            if (r5 == 0) goto L_0x03c6
            java.lang.String r5 = r0.getMessage()
            if (r5 == 0) goto L_0x03c6
            r0.getLocalizedMessage()
        L_0x03c6:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r0 = r4.f1517a
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r4 = r1.f1517a
            r4.putAll(r0)
            com.shield.android.c.r r4 = r1.j
            if (r4 == 0) goto L_0x0534
            android.content.Context r0 = r4.f1512b     // Catch:{ Exception -> 0x0417 }
            r4.a(r0)     // Catch:{ Exception -> 0x0417 }
            java.lang.String r0 = "WIFI_IP"
            android.content.Context r5 = r4.f1512b     // Catch:{ Exception -> 0x0417 }
            java.lang.String r5 = r4.f(r5)     // Catch:{ Exception -> 0x0417 }
            if (r5 != 0) goto L_0x03e1
            r5 = r11
        L_0x03e1:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r6 = r4.f1517a     // Catch:{ Exception -> 0x0417 }
            r6.put(r0, r5)     // Catch:{ Exception -> 0x0417 }
            java.lang.String r0 = "WIFI_SSID"
            android.content.Context r5 = r4.f1512b     // Catch:{ Exception -> 0x0417 }
            java.lang.String r5 = r4.g(r5)     // Catch:{ Exception -> 0x0417 }
            if (r5 != 0) goto L_0x03f1
            r5 = r11
        L_0x03f1:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r6 = r4.f1517a     // Catch:{ Exception -> 0x0417 }
            r6.put(r0, r5)     // Catch:{ Exception -> 0x0417 }
            java.lang.String r0 = "WIFI_BSSID"
            android.content.Context r5 = r4.f1512b     // Catch:{ Exception -> 0x0417 }
            java.lang.String r5 = r4.e(r5)     // Catch:{ Exception -> 0x0417 }
            if (r5 != 0) goto L_0x0401
            r5 = r11
        L_0x0401:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r6 = r4.f1517a     // Catch:{ Exception -> 0x0417 }
            r6.put(r0, r5)     // Catch:{ Exception -> 0x0417 }
            java.lang.String r0 = "MOBILE_DBM"
            android.content.Context r5 = r4.f1512b     // Catch:{ Exception -> 0x0417 }
            java.lang.String r5 = r4.c(r5)     // Catch:{ Exception -> 0x0417 }
            if (r5 != 0) goto L_0x0411
            r5 = r11
        L_0x0411:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r6 = r4.f1517a     // Catch:{ Exception -> 0x0417 }
            r6.put(r0, r5)     // Catch:{ Exception -> 0x0417 }
            goto L_0x0429
        L_0x0417:
            r0 = move-exception
            com.shield.android.internal.f r5 = com.shield.android.internal.f.a()
            boolean r5 = r5.f1677b
            if (r5 == 0) goto L_0x0429
            java.lang.String r5 = r0.getMessage()
            if (r5 == 0) goto L_0x0429
            r0.getLocalizedMessage()
        L_0x0429:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r0 = r4.f1517a
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r4 = r1.f1517a
            r4.putAll(r0)
            com.shield.android.c.n r4 = r1.f1551f
            if (r4 == 0) goto L_0x0532
            android.content.Context r0 = r4.f1536b     // Catch:{ Exception -> 0x045e }
            java.lang.String r5 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r0 = com.shield.android.internal.j.h(r0, r5)     // Catch:{ Exception -> 0x045e }
            if (r0 != 0) goto L_0x0448
            android.content.Context r0 = r4.f1536b     // Catch:{ Exception -> 0x045e }
            java.lang.String r5 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r0 = com.shield.android.internal.j.h(r0, r5)     // Catch:{ Exception -> 0x045e }
            if (r0 == 0) goto L_0x0450
        L_0x0448:
            android.content.Context r0 = r4.f1536b     // Catch:{ Exception -> 0x045e }
            boolean r0 = com.shield.android.internal.j.c(r0)     // Catch:{ Exception -> 0x045e }
            if (r0 != 0) goto L_0x045a
        L_0x0450:
            java.lang.String r0 = "LATLNG"
            java.lang.String r5 = "disabled"
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r6 = r4.f1517a     // Catch:{ Exception -> 0x045e }
            r6.put(r0, r5)     // Catch:{ Exception -> 0x045e }
            goto L_0x0470
        L_0x045a:
            r4.e()     // Catch:{ Exception -> 0x045e }
            goto L_0x0470
        L_0x045e:
            r0 = move-exception
            com.shield.android.internal.f r5 = com.shield.android.internal.f.a()
            boolean r5 = r5.f1677b
            if (r5 == 0) goto L_0x0470
            java.lang.String r5 = r0.getMessage()
            if (r5 == 0) goto L_0x0470
            r0.getLocalizedMessage()
        L_0x0470:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r0 = r4.f1517a
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r4 = r1.f1517a
            r4.putAll(r0)
            com.shield.android.c.l r4 = r1.i
            if (r4 == 0) goto L_0x0530
            com.shield.android.internal.NativeUtils r0 = r4.f1532b     // Catch:{ Exception -> 0x04a5 }
            boolean r0 = r0.a()     // Catch:{ Exception -> 0x04a5 }
            if (r0 == 0) goto L_0x04b7
            java.lang.String r0 = "reversed_tools"
            java.lang.String r5 = r4.b()     // Catch:{ Exception -> 0x0492 }
            if (r5 != 0) goto L_0x048c
            r5 = r11
        L_0x048c:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r6 = r4.f1517a     // Catch:{ Exception -> 0x0492 }
            r6.put(r0, r5)     // Catch:{ Exception -> 0x0492 }
            goto L_0x04b7
        L_0x0492:
            r0 = move-exception
            com.shield.android.internal.f r5 = com.shield.android.internal.f.a()     // Catch:{ Exception -> 0x04a5 }
            boolean r5 = r5.f1677b     // Catch:{ Exception -> 0x04a5 }
            if (r5 == 0) goto L_0x04b7
            java.lang.String r5 = r0.getMessage()     // Catch:{ Exception -> 0x04a5 }
            if (r5 == 0) goto L_0x04b7
            r0.getLocalizedMessage()     // Catch:{ Exception -> 0x04a5 }
            goto L_0x04b7
        L_0x04a5:
            r0 = move-exception
            com.shield.android.internal.f r5 = com.shield.android.internal.f.a()
            boolean r5 = r5.f1677b
            if (r5 == 0) goto L_0x04b7
            java.lang.String r5 = r0.getMessage()
            if (r5 == 0) goto L_0x04b7
            r0.getLocalizedMessage()
        L_0x04b7:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r0 = r4.f1517a
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r4 = r1.f1517a
            r4.putAll(r0)
            com.shield.android.c.j r4 = r1.k
            if (r4 == 0) goto L_0x052e
            java.lang.String r0 = "SCREENS"
            java.lang.String r5 = r4.c()     // Catch:{ Exception -> 0x04d1 }
            if (r5 != 0) goto L_0x04cb
            r5 = r11
        L_0x04cb:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r6 = r4.f1517a     // Catch:{ Exception -> 0x04d1 }
            r6.put(r0, r5)     // Catch:{ Exception -> 0x04d1 }
            goto L_0x04e3
        L_0x04d1:
            r0 = move-exception
            com.shield.android.internal.f r5 = com.shield.android.internal.f.a()
            boolean r5 = r5.f1677b
            if (r5 == 0) goto L_0x04e3
            java.lang.String r5 = r0.getMessage()
            if (r5 == 0) goto L_0x04e3
            r0.getLocalizedMessage()
        L_0x04e3:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r0 = r4.f1517a
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r4 = r1.f1517a
            r4.putAll(r0)
            boolean r0 = r1.p
            if (r0 == 0) goto L_0x0520
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x050e }
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r4 = r1.f1517a     // Catch:{ JSONException -> 0x050e }
            java.lang.Object r4 = r4.get(r2)     // Catch:{ JSONException -> 0x050e }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ JSONException -> 0x050e }
            r0.<init>(r4)     // Catch:{ JSONException -> 0x050e }
            java.lang.String r4 = "isFoundMagisk"
            r0.put(r4, r10)     // Catch:{ JSONException -> 0x050e }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x050e }
            if (r0 != 0) goto L_0x0507
            goto L_0x0508
        L_0x0507:
            r11 = r0
        L_0x0508:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r0 = r1.f1517a     // Catch:{ JSONException -> 0x050e }
            r0.put(r2, r11)     // Catch:{ JSONException -> 0x050e }
            goto L_0x0520
        L_0x050e:
            r0 = move-exception
            com.shield.android.internal.f r2 = com.shield.android.internal.f.a()
            boolean r2 = r2.f1677b
            if (r2 == 0) goto L_0x0520
            java.lang.String r2 = r0.getMessage()
            if (r2 == 0) goto L_0x0520
            r0.getLocalizedMessage()
        L_0x0520:
            com.shield.android.Shield$LogLevel r0 = com.shield.android.Shield.LOG_LEVEL
            com.shield.android.internal.b r0 = com.shield.android.internal.b.b(r0)
            java.lang.Object[] r2 = new java.lang.Object[r3]
            java.lang.String r3 = "SHIELD FP PROCESS -> end collecting other contexts"
            r0.a(r3, r2)
            return
        L_0x052e:
            r2 = 0
            throw r2
        L_0x0530:
            r2 = 0
            throw r2
        L_0x0532:
            r2 = 0
            throw r2
        L_0x0534:
            r2 = 0
            throw r2
        L_0x0536:
            r2 = 0
            throw r2
        L_0x0538:
            r2 = 0
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shield.android.c.t.l():void");
    }

    public final void c() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        newSingleThreadExecutor.execute(new Runnable(countDownLatch, newSingleThreadExecutor) {
            public final /* synthetic */ CountDownLatch f$1;
            public final /* synthetic */ ExecutorService f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                t.this.a(this.f$1, this.f$2);
            }
        });
        try {
            countDownLatch.await(500, TimeUnit.MILLISECONDS);
        } catch (Exception unused) {
        }
    }

    public final String d() {
        try {
            String str = "abcdefghijklmnopqrstuvwxyz" + "abcdefghijklmnopqrstuvwxyz".toUpperCase(Locale.ROOT) + "0123456789_.";
            SecureRandom secureRandom = new SecureRandom();
            StringBuilder sb = new StringBuilder();
            int nextInt = secureRandom.nextInt(30);
            int i2 = 1;
            if (1 <= nextInt) {
                while (true) {
                    int i3 = i2 + 1;
                    sb.append(str.charAt(secureRandom.nextInt(str.length())));
                    if (i2 == nextInt) {
                        break;
                    }
                    i2 = i3;
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return "shieldservice";
        }
    }
}
