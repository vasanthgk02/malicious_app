package com.shield.android.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.shield.android.Shield;
import com.shield.android.Shield.LogLevel;
import com.shield.android.ShieldCallback;
import com.shield.android.ShieldException;
import com.shield.android.c.$$Lambda$9pK2c0lUyHOgWbnR_t0aTpA_gY;
import com.shield.android.c.$$Lambda$TktqsE1N3wDoHK8z8n_FYB2tdlQ;
import com.shield.android.c.$$Lambda$WAPUZ8hW9794uBwQdqt9HqjBrtc;
import com.shield.android.c.m;
import com.shield.android.c.n;
import com.shield.android.c.r;
import com.shield.android.c.t;
import com.shield.android.c.u;
import com.shield.android.c.v;
import com.shield.android.e.g.C0020g;
import com.shield.android.internal.NativeUtils;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java8.util.concurrent.CompletableFuture;
import org.json.JSONObject;

public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public com.shield.android.e.g f1624a;

    /* renamed from: b  reason: collision with root package name */
    public t f1625b;

    /* renamed from: c  reason: collision with root package name */
    public com.shield.android.c.g f1626c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f1627d;

    /* renamed from: e  reason: collision with root package name */
    public ExecutorService f1628e;

    /* renamed from: f  reason: collision with root package name */
    public com.shield.android.e.k f1629f;
    public com.shield.android.e.h g;
    public com.shield.android.e.i h;
    public com.shield.android.e.c i;
    public e j;
    public e k;
    public com.shield.android.e.a l;
    public String m;
    public String n;
    public String o;
    public final String p;
    public final Context q;
    public final String r;
    public final String s;
    public NativeUtils t;
    public final boolean u;
    public final boolean v;
    public final String w;
    public com.shield.android.internal.b x;
    public final LogLevel y;
    public com.shield.android.internal.d z;

    public class a extends com.shield.android.internal.i {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ShieldCallback f1630d;

        public a(ShieldCallback shieldCallback) {
            this.f1630d = shieldCallback;
        }

        public Object call() throws Exception {
            String str = this.f1680c;
            if (str == null || str.length() <= 0) {
                d.a(d.this, this.f1678a, this.f1679b, this.f1630d);
            }
            return null;
        }
    }

    public class b extends com.shield.android.internal.i {
        public b() {
        }

        public Object call() throws Exception {
            String str = this.f1680c;
            if (str == null || str.length() <= 0) {
                d.a(d.this, this.f1678a, this.f1679b, (ShieldCallback) null);
            }
            return null;
        }
    }

    public class c extends com.shield.android.internal.i {
        public Object call() throws Exception {
            return null;
        }
    }

    /* renamed from: com.shield.android.f.d$d  reason: collision with other inner class name */
    public class C0021d implements ShieldCallback<Pair<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.shield.android.internal.i f1633a;

        public C0021d(com.shield.android.internal.i iVar) {
            this.f1633a = iVar;
        }

        public void onFailure(ShieldException shieldException) {
            String str;
            if (shieldException != null) {
                try {
                    str = shieldException.code + ": " + shieldException.message;
                } catch (Exception unused) {
                    return;
                }
            } else {
                str = "Unkown error";
            }
            this.f1633a.f1680c = str;
            this.f1633a.call();
        }

        public void onSuccess(Object obj) {
            Pair pair = (Pair) obj;
            if (pair != null) {
                try {
                    this.f1633a.f1678a = (String) pair.first;
                    this.f1633a.f1679b = (String) pair.second;
                } catch (Exception unused) {
                    return;
                }
            }
            this.f1633a.call();
        }
    }

    public class e implements ShieldCallback<Pair<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.shield.android.internal.i f1634a;

        public e(com.shield.android.internal.i iVar) {
            this.f1634a = iVar;
        }

        public void onFailure(ShieldException shieldException) {
            String str;
            if (shieldException != null) {
                try {
                    str = shieldException.code + ": " + shieldException.message;
                } catch (Exception unused) {
                    return;
                }
            } else {
                str = "Unkown error";
            }
            this.f1634a.f1680c = str;
            this.f1634a.call();
        }

        public void onSuccess(Object obj) {
            Pair pair = (Pair) obj;
            if (pair != null) {
                try {
                    this.f1634a.f1678a = (String) pair.first;
                    this.f1634a.f1679b = (String) pair.second;
                } catch (Exception unused) {
                    return;
                }
            }
            this.f1634a.call();
        }
    }

    public class f extends com.shield.android.internal.i {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f1635d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShieldCallback f1636e;

        public f(boolean z, ShieldCallback shieldCallback) {
            this.f1635d = z;
            this.f1636e = shieldCallback;
        }

        public Object call() throws Exception {
            d.a(d.this, this.f1678a, this.f1679b, this.f1635d, this.f1636e);
            return null;
        }
    }

    public class g extends com.shield.android.internal.i {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f1638d;

        public g(boolean z) {
            this.f1638d = z;
        }

        public Object call() throws Exception {
            d.a(d.this, this.f1678a, this.f1679b, this.f1638d, (ShieldCallback) null);
            return null;
        }
    }

    public class h extends com.shield.android.internal.i {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ShieldCallback f1640d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f1641e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HashMap f1642f;

        public h(ShieldCallback shieldCallback, String str, HashMap hashMap) {
            this.f1640d = shieldCallback;
            this.f1641e = str;
            this.f1642f = hashMap;
        }

        public Object call() throws Exception {
            String str = this.f1680c;
            if (str == null || str.length() <= 0) {
                d.a(d.this, this.f1678a, this.f1679b, this.f1641e, this.f1642f, this.f1640d);
            } else {
                this.f1640d.onFailure(ShieldException.unexpectedError(new Throwable(this.f1680c)));
            }
            return null;
        }
    }

    public class i extends com.shield.android.internal.i {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ShieldCallback f1643d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f1644e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HashMap f1645f;

        public i(ShieldCallback shieldCallback, String str, HashMap hashMap) {
            this.f1643d = shieldCallback;
            this.f1644e = str;
            this.f1645f = hashMap;
        }

        public Object call() throws Exception {
            String str = this.f1680c;
            if (str == null || str.length() <= 0) {
                d.a(d.this, this.f1678a, this.f1679b, this.f1644e, this.f1645f, this.f1643d);
            } else {
                this.f1643d.onFailure(ShieldException.unexpectedError(new Throwable(this.f1680c)));
            }
            return null;
        }
    }

    public class j extends com.shield.android.internal.i {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ShieldCallback f1646d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f1647e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HashMap f1648f;

        public j(ShieldCallback shieldCallback, String str, HashMap hashMap) {
            this.f1646d = shieldCallback;
            this.f1647e = str;
            this.f1648f = hashMap;
        }

        public Object call() throws Exception {
            String str = this.f1680c;
            if (str == null || str.length() <= 0) {
                d.b(d.this, this.f1678a, this.f1679b, this.f1647e, this.f1648f, this.f1646d);
            } else {
                ShieldCallback shieldCallback = this.f1646d;
                if (shieldCallback != null) {
                    shieldCallback.onFailure(ShieldException.unexpectedError(new Throwable(this.f1680c)));
                }
            }
            return null;
        }
    }

    public class k extends com.shield.android.internal.i {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ShieldCallback f1649d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f1650e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HashMap f1651f;

        public k(ShieldCallback shieldCallback, String str, HashMap hashMap) {
            this.f1649d = shieldCallback;
            this.f1650e = str;
            this.f1651f = hashMap;
        }

        public Object call() throws Exception {
            String str = this.f1680c;
            if (str == null || str.length() <= 0) {
                d.b(d.this, this.f1678a, this.f1679b, this.f1650e, this.f1651f, this.f1649d);
            } else {
                ShieldCallback shieldCallback = this.f1649d;
                if (shieldCallback != null) {
                    shieldCallback.onFailure(ShieldException.unexpectedError(new Throwable(this.f1680c)));
                }
            }
            return null;
        }
    }

    public class l extends com.shield.android.internal.i {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f1652d;

        public l(boolean z) {
            this.f1652d = z;
        }

        public Object call() throws Exception {
            d dVar = d.this;
            String str = this.f1678a;
            String str2 = this.f1679b;
            boolean z = this.f1652d;
            if (dVar != null) {
                try {
                    dVar.q().f1616e = str;
                    dVar.q().f1613b = str2;
                    com.shield.android.e.k q = dVar.q();
                    if (z) {
                        q.f1617f = 1;
                    } else {
                        q.f1617f = 0;
                    }
                    dVar.m().b(dVar.q());
                } catch (Exception e2) {
                    if (com.shield.android.internal.f.a().f1677b && e2.getMessage() != null) {
                        e2.getLocalizedMessage();
                    }
                }
                return null;
            }
            throw null;
        }
    }

    public d(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, LogLevel logLevel, boolean z2, boolean z3) {
        this.q = context;
        this.r = str5;
        this.w = str7;
        this.u = z2;
        this.v = z3;
        this.s = str6;
        this.y = logLevel;
        this.m = str;
        this.n = str2;
        this.o = str3;
        this.p = str4;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(Looper looper, ShieldCallback shieldCallback, Thread thread, C0020g gVar) {
        if (gVar != C0020g.FINISHED) {
            return;
        }
        if (looper == null || looper != Looper.getMainLooper()) {
            new Thread(new Runnable(shieldCallback) {
                public final /* synthetic */ ShieldCallback f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    d.this.b(this.f$1);
                }
            }, thread.getName()).start();
        } else {
            new Handler(looper).post(new Runnable(shieldCallback) {
                public final /* synthetic */ ShieldCallback f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    d.this.c(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(ShieldCallback shieldCallback) {
        if (n().f1599f != null) {
            shieldCallback.onFailure(n().f1599f);
        } else {
            shieldCallback.onSuccess(Boolean.valueOf(n().f1598e));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(ShieldCallback shieldCallback) {
        if (o().f1605f != null) {
            shieldCallback.onFailure(o().f1605f);
        } else {
            shieldCallback.onSuccess(new Pair(o().f1604e, o().f1603d));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(ShieldCallback shieldCallback) {
        if (d().g != null) {
            shieldCallback.onFailure(d().g);
        } else {
            shieldCallback.onSuccess(Boolean.valueOf(d().f1561e));
        }
    }

    public void a(com.shield.android.internal.i iVar) {
        try {
            if (this.k == null) {
                e eVar = new e(this.q, this.w, m(), this.m, this.o, true, f());
                this.k = eVar;
            }
            this.k.a(new C0021d(iVar));
        } catch (Exception unused) {
        }
    }

    public void b(com.shield.android.internal.i iVar) {
        try {
            if (this.j == null) {
                e eVar = new e(this.q, this.w, m(), this.m, this.o, false, f());
                this.j = eVar;
            }
            this.j.a(new e(iVar));
        } catch (Exception unused) {
        }
    }

    public final com.shield.android.e.a d() {
        if (this.l == null) {
            this.l = new com.shield.android.e.a(this.m, this.o, this.n);
        }
        return this.l;
    }

    public final com.shield.android.internal.b f() {
        if (this.x == null) {
            this.x = com.shield.android.internal.b.b(this.y);
        }
        return this.x;
    }

    public final com.shield.android.internal.d h() {
        if (this.z == null) {
            if (this.t == null) {
                this.t = new NativeUtils(this.q);
            }
            this.z = new com.shield.android.internal.d(this.t);
        }
        return this.z;
    }

    public final com.shield.android.e.c j() {
        if (this.i == null) {
            this.i = new com.shield.android.e.c(this.m, this.o, f(), h());
        }
        return this.i;
    }

    public final com.shield.android.e.g m() {
        com.shield.android.e.g gVar;
        if (this.f1624a == null) {
            com.shield.android.e.g.e eVar = new com.shield.android.e.g.e();
            synchronized (com.shield.android.e.g.class) {
                gVar = new com.shield.android.e.g(eVar);
            }
            this.f1624a = gVar;
        }
        return this.f1624a;
    }

    public final com.shield.android.e.h n() {
        if (this.g == null) {
            this.g = new com.shield.android.e.h(this.m, f(), h(), this.w);
        }
        return this.g;
    }

    public final com.shield.android.e.i o() {
        if (this.h == null) {
            com.shield.android.e.i iVar = new com.shield.android.e.i(this.m, this.n, f(), h(), this.w);
            this.h = iVar;
        }
        return this.h;
    }

    public final t p() {
        d dVar = this;
        if (dVar.f1625b == null) {
            Context context = dVar.q;
            String str = dVar.m;
            String str2 = dVar.n;
            String str3 = dVar.r;
            String str4 = dVar.s;
            if (dVar.t == null) {
                dVar.t = new NativeUtils(context);
            }
            NativeUtils nativeUtils = dVar.t;
            boolean z2 = dVar.u;
            boolean z3 = dVar.v;
            n nVar = r12;
            n nVar2 = new n(context, z2);
            ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
            com.shield.android.b.a aVar = new com.shield.android.b.a(context);
            ConcurrentHashMap concurrentHashMap = r8;
            ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
            com.shield.android.c.a aVar2 = r9;
            com.shield.android.c.a aVar3 = new com.shield.android.c.a(context);
            com.shield.android.c.h hVar = new com.shield.android.c.h(context, aVar, newCachedThreadPool);
            u uVar = r13;
            u uVar2 = new u(context, nVar2, str4);
            v vVar = r1;
            v vVar2 = new v(context);
            com.shield.android.c.l lVar = r1;
            com.shield.android.c.l lVar2 = new com.shield.android.c.l(nativeUtils);
            com.shield.android.c.j jVar = r1;
            com.shield.android.c.j jVar2 = new com.shield.android.c.j(context);
            t tVar = r2;
            NativeUtils nativeUtils2 = nativeUtils;
            r rVar = r1;
            r rVar2 = new r(context);
            m mVar = r1;
            m mVar2 = new m(context, nativeUtils2);
            com.shield.android.c.i iVar = r0;
            com.shield.android.c.i iVar2 = new com.shield.android.c.i(context);
            t tVar2 = new t(context, str, str2, str3, concurrentHashMap, aVar2, hVar, nVar, uVar, vVar, lVar, jVar, rVar, mVar, iVar, z3);
            dVar = this;
            dVar.f1625b = tVar;
        }
        return dVar.f1625b;
    }

    public final com.shield.android.e.k q() {
        if (this.f1629f == null) {
            this.f1629f = new com.shield.android.e.k(this.m, this.o, this.n);
        }
        return this.f1629f;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(Looper looper, ShieldCallback shieldCallback, Thread thread, C0020g gVar) {
        if (gVar != C0020g.FINISHED) {
            return;
        }
        if (looper == null || looper != Looper.getMainLooper()) {
            new Thread(new Runnable(shieldCallback) {
                public final /* synthetic */ ShieldCallback f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    d.this.f(this.f$1);
                }
            }, thread.getName()).start();
        } else {
            new Handler(looper).post(new Runnable(shieldCallback) {
                public final /* synthetic */ ShieldCallback f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    d.this.g(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(ShieldCallback shieldCallback) {
        if (o().f1605f != null) {
            shieldCallback.onFailure(o().f1605f);
        } else {
            shieldCallback.onSuccess(new Pair(o().f1604e, o().f1603d));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:76:? A[ADDED_TO_REGION, ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r8, com.shield.android.ShieldCallback r9, android.os.Looper r10, java.lang.Thread r11) {
        /*
            r7 = this;
            java.lang.String r8 = ""
            com.shield.android.c.g r0 = r7.f1626c
            if (r0 != 0) goto L_0x0011
            com.shield.android.c.g r0 = new com.shield.android.c.g
            android.content.Context r1 = r7.q
            java.lang.String r2 = r7.m
            r0.<init>(r1, r2)
            r7.f1626c = r0
        L_0x0011:
            com.shield.android.c.g r0 = r7.f1626c
            r1 = 0
            if (r0 == 0) goto L_0x0171
            java.lang.String r2 = "error"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            android.content.Context r4 = r0.f1510b     // Catch:{ Exception -> 0x0081 }
            java.lang.String r5 = "android.permission.BLUETOOTH"
            boolean r4 = com.shield.android.internal.j.h(r4, r5)     // Catch:{ Exception -> 0x0081 }
            if (r4 == 0) goto L_0x007e
            android.bluetooth.BluetoothAdapter r4 = android.bluetooth.BluetoothAdapter.getDefaultAdapter()     // Catch:{ Exception -> 0x0081 }
            if (r4 != 0) goto L_0x002e
            goto L_0x0081
        L_0x002e:
            boolean r5 = r4.isEnabled()     // Catch:{ Exception -> 0x0081 }
            if (r5 != 0) goto L_0x0035
            goto L_0x007e
        L_0x0035:
            java.util.Set r5 = r4.getBondedDevices()     // Catch:{ Exception -> 0x0081 }
            if (r5 != 0) goto L_0x003d
            r3 = r8
            goto L_0x0082
        L_0x003d:
            java.util.Set r4 = r4.getBondedDevices()     // Catch:{ Exception -> 0x0081 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x0081 }
        L_0x0045:
            boolean r5 = r4.hasNext()     // Catch:{ Exception -> 0x0081 }
            if (r5 == 0) goto L_0x006a
            java.lang.Object r5 = r4.next()     // Catch:{ Exception -> 0x0081 }
            android.bluetooth.BluetoothDevice r5 = (android.bluetooth.BluetoothDevice) r5     // Catch:{ Exception -> 0x0081 }
            java.lang.String r6 = r5.getAddress()     // Catch:{ Exception -> 0x0081 }
            r3.append(r6)     // Catch:{ Exception -> 0x0081 }
            java.lang.String r6 = "@"
            r3.append(r6)     // Catch:{ Exception -> 0x0081 }
            java.lang.String r5 = r5.getName()     // Catch:{ Exception -> 0x0081 }
            r3.append(r5)     // Catch:{ Exception -> 0x0081 }
            java.lang.String r5 = ","
            r3.append(r5)     // Catch:{ Exception -> 0x0081 }
            goto L_0x0045
        L_0x006a:
            int r4 = r3.length()     // Catch:{ Exception -> 0x0081 }
            if (r4 <= 0) goto L_0x0079
            int r4 = r3.length()     // Catch:{ Exception -> 0x0081 }
            int r4 = r4 + -1
            r3.setLength(r4)     // Catch:{ Exception -> 0x0081 }
        L_0x0079:
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0081 }
            goto L_0x0082
        L_0x007e:
            java.lang.String r3 = "disabled"
            goto L_0x0082
        L_0x0081:
            r3 = r2
        L_0x0082:
            if (r3 != 0) goto L_0x0085
            r3 = r8
        L_0x0085:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r4 = r0.f1517a
            java.lang.String r5 = "PAIRED_BT_DEVICES"
            r4.put(r5, r3)
            java.lang.String r3 = r0.f1511c
            if (r3 == 0) goto L_0x00ae
            java.lang.String r4 = "c936ac876525a84c4bfd132313b849b808d35f69"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x00ae
            android.content.Context r3 = r0.f1510b
            com.shield.android.ArpDataCollector r4 = new com.shield.android.ArpDataCollector     // Catch:{ Exception -> 0x00a7 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r3 = r4.getARP()     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r2 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x00a7 }
        L_0x00a7:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r3 = r0.f1517a
            java.lang.String r4 = "MAC_ADDRESSES"
            r3.put(r4, r2)
        L_0x00ae:
            java.lang.String r2 = com.shield.android.e.g.f1583b
            if (r2 != 0) goto L_0x00b3
            r2 = r8
        L_0x00b3:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r3 = r0.f1517a
            java.lang.String r4 = "SERVER_CERTIFICATE_ISSUER"
            r3.put(r4, r2)
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r0 = r0.f1517a
            if (r0 == 0) goto L_0x0170
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0170
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.String r3 = r7.m
            java.lang.String r4 = "site_id"
            r2.put(r4, r3)
            java.lang.String r3 = r7.p
            if (r3 == 0) goto L_0x00e1
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x00e1
            java.lang.String r3 = r7.p
            java.lang.String r4 = "partner_id"
            r2.put(r4, r3)
        L_0x00e1:
            java.lang.String r3 = r7.n
            java.lang.String r4 = "session_id"
            r2.put(r4, r3)
            r2.putAll(r0)
            com.shield.android.e.c r0 = r7.j()
            if (r0 == 0) goto L_0x016f
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0139 }
            r1.<init>()     // Catch:{ Exception -> 0x0139 }
            java.util.Set r2 = r2.entrySet()     // Catch:{ Exception -> 0x0139 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0139 }
        L_0x00fe:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0139 }
            if (r3 == 0) goto L_0x012e
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0139 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ Exception -> 0x0139 }
            java.lang.Object r4 = r3.getValue()     // Catch:{ Exception -> 0x0139 }
            if (r4 == 0) goto L_0x0122
            java.lang.Object r4 = r3.getKey()     // Catch:{ Exception -> 0x0139 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0139 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ Exception -> 0x0139 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0139 }
            r1.put(r4, r3)     // Catch:{ Exception -> 0x0139 }
            goto L_0x00fe
        L_0x0122:
            java.lang.Object r3 = r3.getKey()     // Catch:{ Exception -> 0x0139 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0139 }
            java.lang.Object r4 = org.json.JSONObject.NULL     // Catch:{ Exception -> 0x0139 }
            r1.put(r3, r4)     // Catch:{ Exception -> 0x0139 }
            goto L_0x00fe
        L_0x012e:
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0139 }
            com.shield.android.internal.d r2 = r0.f1568c     // Catch:{ Exception -> 0x0139 }
            java.lang.String r8 = r2.c(r1)     // Catch:{ Exception -> 0x0139 }
            goto L_0x0144
        L_0x0139:
            r1 = move-exception
            com.shield.android.internal.b r2 = r0.f1567b
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "error serializing data"
            r2.a(r1, r4, r3)
        L_0x0144:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.f1566a
            r1.clear()
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r0.f1566a
            java.lang.String r1 = "data"
            r0.put(r1, r8)
            if (r9 == 0) goto L_0x0163
            com.shield.android.e.g r8 = r7.m()
            com.shield.android.e.c r0 = r7.j()
            com.shield.android.f.-$$Lambda$d$UirGUCOXdU4VEfgmo6fy4cPrdEI r1 = new com.shield.android.f.-$$Lambda$d$UirGUCOXdU4VEfgmo6fy4cPrdEI
            r1.<init>(r10, r9, r11)
            r8.a(r0, r1)
            goto L_0x0170
        L_0x0163:
            com.shield.android.e.g r8 = r7.m()
            com.shield.android.e.c r9 = r7.j()
            r8.b(r9)
            goto L_0x0170
        L_0x016f:
            throw r1
        L_0x0170:
            return
        L_0x0171:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shield.android.f.d.a(boolean, com.shield.android.ShieldCallback, android.os.Looper, java.lang.Thread):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(ShieldCallback shieldCallback) {
        if (j().f1571f != null) {
            shieldCallback.onFailure(j().f1571f);
        } else {
            shieldCallback.onSuccess(Boolean.valueOf(j().f1570e));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Looper looper, ShieldCallback shieldCallback, Thread thread, C0020g gVar) {
        if (gVar != C0020g.FINISHED) {
            return;
        }
        if (looper == null || looper != Looper.getMainLooper()) {
            new Thread(new Runnable(shieldCallback) {
                public final /* synthetic */ ShieldCallback f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    d.this.d(this.f$1);
                }
            }, thread.getName()).start();
        } else {
            new Handler(looper).post(new Runnable(shieldCallback) {
                public final /* synthetic */ ShieldCallback f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    d.this.e(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(ShieldCallback shieldCallback) {
        if (j().f1571f != null) {
            shieldCallback.onFailure(j().f1571f);
        } else {
            shieldCallback.onSuccess(Boolean.valueOf(j().f1570e));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(ShieldCallback shieldCallback) {
        if (d().g != null) {
            shieldCallback.onFailure(d().g);
        } else {
            shieldCallback.onSuccess(Boolean.valueOf(d().f1561e));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(ShieldCallback shieldCallback) {
        if (n().f1599f != null) {
            shieldCallback.onFailure(n().f1599f);
        } else {
            shieldCallback.onSuccess(Boolean.valueOf(n().f1598e));
        }
    }

    public static Void b(d dVar, String str, String str2, String str3, HashMap hashMap, ShieldCallback shieldCallback) {
        dVar.n().g = str;
        dVar.n().h = str2;
        Looper myLooper = Looper.myLooper();
        Thread currentThread = Thread.currentThread();
        try {
            if (dVar.f1627d == null) {
                dVar.f1627d = Executors.newSingleThreadExecutor();
            }
            ExecutorService executorService = dVar.f1627d;
            $$Lambda$d$oH957Fqv8GzReIrPP8Uk5LnhMNk r0 = new Runnable(str3, hashMap, shieldCallback, myLooper, currentThread) {
                public final /* synthetic */ String f$1;
                public final /* synthetic */ HashMap f$2;
                public final /* synthetic */ ShieldCallback f$3;
                public final /* synthetic */ Looper f$4;
                public final /* synthetic */ Thread f$5;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                    this.f$5 = r6;
                }

                public final void run() {
                    d.this.a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
                }
            };
            executorService.submit(r0);
        } catch (Exception e2) {
            if (shieldCallback != null) {
                shieldCallback.onFailure(ShieldException.unexpectedError(e2));
            }
        }
        return null;
    }

    public static Void a(d dVar, String str, String str2, boolean z2, ShieldCallback shieldCallback) {
        dVar.j().g = str;
        dVar.j().h = str2;
        try {
            Looper myLooper = Looper.myLooper();
            Thread currentThread = Thread.currentThread();
            if (dVar.f1628e == null) {
                dVar.f1628e = Executors.newSingleThreadExecutor();
            }
            ExecutorService executorService = dVar.f1628e;
            $$Lambda$d$TO7Nv0s4Q9_NgU4aO6JeIGYwAk r0 = new Runnable(z2, shieldCallback, myLooper, currentThread) {
                public final /* synthetic */ boolean f$1;
                public final /* synthetic */ ShieldCallback f$2;
                public final /* synthetic */ Looper f$3;
                public final /* synthetic */ Thread f$4;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void run() {
                    d.this.a(this.f$1, this.f$2, this.f$3, this.f$4);
                }
            };
            executorService.submit(r0);
        } catch (Exception unused) {
        }
        return null;
    }

    public static Void a(d dVar, String str, String str2, String str3, HashMap hashMap, ShieldCallback shieldCallback) {
        dVar.o().h = str;
        dVar.o().k = str2;
        com.shield.android.e.i o2 = dVar.o();
        o2.i.put("Fp-Trigger-Time", String.valueOf(System.currentTimeMillis()));
        Looper myLooper = Looper.myLooper();
        Thread currentThread = Thread.currentThread();
        try {
            if (dVar.f1627d == null) {
                dVar.f1627d = Executors.newSingleThreadExecutor();
            }
            ExecutorService executorService = dVar.f1627d;
            $$Lambda$d$HHRjUz2oJTzkLjRD7HAsh2FsZQ r1 = new Runnable(hashMap, str3, myLooper, shieldCallback, currentThread) {
                public final /* synthetic */ HashMap f$1;
                public final /* synthetic */ String f$2;
                public final /* synthetic */ Looper f$3;
                public final /* synthetic */ ShieldCallback f$4;
                public final /* synthetic */ Thread f$5;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                    this.f$5 = r6;
                }

                public final void run() {
                    d.this.a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
                }
            };
            executorService.submit(r1);
        } catch (Exception e2) {
            shieldCallback.onFailure(ShieldException.unexpectedError(e2));
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void a(HashMap hashMap, String str, Looper looper, ShieldCallback shieldCallback, Thread thread) {
        CompletableFuture completableFuture;
        String str2;
        t p2 = p();
        if (hashMap != null) {
            String str3 = (String) hashMap.get("event_name");
        }
        if (p2 != null) {
            ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
            boolean z2 = true;
            if (p2.f1517a.size() <= 1) {
                completableFuture = CompletableFuture.runAsync(new Runnable() {
                    public final void run() {
                        t.this.j();
                    }
                }).exceptionally($$Lambda$9pK2c0lUyHOgWbnR_t0aTpA_gY.INSTANCE);
            } else if (!p2.s || p2.g != null) {
                completableFuture = null;
            } else {
                throw null;
            }
            CompletableFuture exceptionally = CompletableFuture.runAsync(new Runnable() {
                public final void run() {
                    t.this.k();
                }
            }).exceptionally($$Lambda$TktqsE1N3wDoHK8z8n_FYB2tdlQ.INSTANCE);
            CompletableFuture exceptionally2 = CompletableFuture.runAsync(new Runnable() {
                public final void run() {
                    t.this.l();
                }
            }).exceptionally($$Lambda$WAPUZ8hW9794uBwQdqt9HqjBrtc.INSTANCE);
            if (completableFuture != null) {
                try {
                    CompletableFuture.andTree(new CompletableFuture[]{exceptionally, exceptionally2, completableFuture}, 0, 2).get();
                } catch (Exception unused) {
                }
            } else {
                CompletableFuture.andTree(new CompletableFuture[]{exceptionally, exceptionally2}, 0, 1).get();
            }
            com.shield.android.internal.b.b(Shield.LOG_LEVEL).a("SHIELD FP PROCESS -> end collecting all contexts", new Object[0]);
            newCachedThreadPool.shutdown();
            HashMap hashMap2 = new HashMap(p2.f1517a);
            hashMap2.put("SCREEN_NAME", str);
            String str4 = this.p;
            if (str4 != null && str4.length() > 0) {
                hashMap2.put("partner_id", this.p);
            }
            if (hashMap != null) {
                hashMap2.putAll(hashMap);
            }
            com.shield.android.e.i o2 = o();
            if (o2 != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    String str5 = o2.g;
                    if (str5 == null || !str5.equalsIgnoreCase("Dev")) {
                        z2 = false;
                    }
                    jSONObject.put("test", z2);
                    for (Entry entry : hashMap2.entrySet()) {
                        if (entry.getValue() != null) {
                            jSONObject.put((String) entry.getKey(), entry.getValue().toString());
                        } else {
                            jSONObject.put((String) entry.getKey(), JSONObject.NULL);
                        }
                    }
                    str2 = o2.f1602c.c(jSONObject.toString());
                } catch (Exception e2) {
                    o2.f1601b.a(e2, "error serializing data", new Object[0]);
                    str2 = "";
                }
                o2.f1600a.clear();
                o2.f1600a.put("data", str2);
                com.shield.android.internal.b.b(Shield.LOG_LEVEL).a("SHIELD FP PROCESS -> payload processed and sent to server", new Object[0]);
                m().a(o(), new com.shield.android.e.f(looper, shieldCallback, thread) {
                    public final /* synthetic */ Looper f$1;
                    public final /* synthetic */ ShieldCallback f$2;
                    public final /* synthetic */ Thread f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void a(C0020g gVar) {
                        d.this.d(this.f$1, this.f$2, this.f$3, gVar);
                    }
                });
                return;
            }
            throw null;
        }
        throw null;
    }

    public static Void a(d dVar, String str, String str2, ShieldCallback shieldCallback) {
        if (dVar != null) {
            try {
                dVar.d().f1560d = str;
                dVar.d().f1562f = str2;
                Looper myLooper = Looper.myLooper();
                Thread currentThread = Thread.currentThread();
                if (shieldCallback != null) {
                    dVar.m().a(dVar.d(), new com.shield.android.e.f(myLooper, shieldCallback, currentThread) {
                        public final /* synthetic */ Looper f$1;
                        public final /* synthetic */ ShieldCallback f$2;
                        public final /* synthetic */ Thread f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final void a(C0020g gVar) {
                            d.this.a(this.f$1, this.f$2, this.f$3, gVar);
                        }
                    });
                } else {
                    dVar.m().b(dVar.d());
                }
            } catch (Exception e2) {
                if (com.shield.android.internal.f.a().f1677b && e2.getMessage() != null) {
                    e2.getLocalizedMessage();
                }
            }
            return null;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Looper looper, ShieldCallback shieldCallback, Thread thread, C0020g gVar) {
        if (gVar != C0020g.FINISHED) {
            return;
        }
        if (looper == null || looper != Looper.getMainLooper()) {
            new Thread(new Runnable(shieldCallback) {
                public final /* synthetic */ ShieldCallback f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    d.this.h(this.f$1);
                }
            }, thread.getName()).start();
        } else {
            new Handler(looper).post(new Runnable(shieldCallback) {
                public final /* synthetic */ ShieldCallback f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    d.this.i(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, HashMap hashMap, ShieldCallback shieldCallback, Looper looper, Thread thread) {
        String str2;
        HashMap outline87 = GeneratedOutlineSupport.outline87("screen_name", str);
        outline87.put("site_id", this.m);
        String str3 = this.p;
        if (str3 != null && str3.length() > 0) {
            outline87.put("partner_id", this.p);
        }
        outline87.put("session_id", this.n);
        if (hashMap != null) {
            for (String str4 : hashMap.keySet()) {
                if (str4 != null) {
                    outline87.put(str4.toLowerCase(), hashMap.get(str4));
                }
            }
        }
        com.shield.android.e.h n2 = n();
        if (n2 != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                String str5 = n2.i;
                jSONObject.put("test", str5 != null && str5.equalsIgnoreCase("Dev"));
                for (Entry entry : outline87.entrySet()) {
                    if (entry.getValue() != null) {
                        jSONObject.put((String) entry.getKey(), entry.getValue().toString());
                    } else {
                        jSONObject.put((String) entry.getKey(), JSONObject.NULL);
                    }
                }
                str2 = n2.f1596c.c(jSONObject.toString());
            } catch (Exception e2) {
                n2.f1595b.a(e2, "error serializing data", new Object[0]);
                str2 = "";
            }
            n2.f1594a.clear();
            n2.f1594a.put("data", str2);
            if (shieldCallback != null) {
                m().a(n(), new com.shield.android.e.f(looper, shieldCallback, thread) {
                    public final /* synthetic */ Looper f$1;
                    public final /* synthetic */ ShieldCallback f$2;
                    public final /* synthetic */ Thread f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void a(C0020g gVar) {
                        d.this.b(this.f$1, this.f$2, this.f$3, gVar);
                    }
                });
            } else {
                m().b(n());
            }
        } else {
            throw null;
        }
    }
}
