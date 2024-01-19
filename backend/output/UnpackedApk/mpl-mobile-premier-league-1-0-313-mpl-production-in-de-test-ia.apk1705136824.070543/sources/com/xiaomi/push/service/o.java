package com.xiaomi.push.service;

import android.os.SystemClock;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.concurrent.RejectedExecutionException;

public class o {

    /* renamed from: a  reason: collision with root package name */
    public static long f4954a;

    /* renamed from: b  reason: collision with root package name */
    public static long f4955b;

    /* renamed from: c  reason: collision with root package name */
    public static long f4956c;

    /* renamed from: a  reason: collision with other field name */
    public final a f926a;

    /* renamed from: a  reason: collision with other field name */
    public final c f927a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final c f4957a;

        public a(c cVar) {
            this.f4957a = cVar;
        }

        public void finalize() {
            try {
                synchronized (this.f4957a) {
                    this.f4957a.f4961c = true;
                    this.f4957a.notify();
                }
                super.finalize();
            } catch (Throwable th) {
                super.finalize();
                throw th;
            }
        }
    }

    public static abstract class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public int f4958a;

        public b(int i) {
            this.f4958a = i;
        }
    }

    public static final class c extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public volatile long f4959a = 0;

        /* renamed from: a  reason: collision with other field name */
        public a f928a = new a();

        /* renamed from: a  reason: collision with other field name */
        public volatile boolean f929a = false;

        /* renamed from: b  reason: collision with root package name */
        public long f4960b = 50;

        /* renamed from: b  reason: collision with other field name */
        public boolean f930b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f4961c;

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public int f4962a;

            /* renamed from: a  reason: collision with other field name */
            public d[] f931a;

            /* renamed from: b  reason: collision with root package name */
            public int f4963b;

            /* renamed from: c  reason: collision with root package name */
            public int f4964c;

            public a() {
                this.f4962a = 256;
                this.f931a = new d[256];
                this.f4963b = 0;
                this.f4964c = 0;
            }

            /* access modifiers changed from: private */
            public int a(d dVar) {
                int i = 0;
                while (true) {
                    d[] dVarArr = this.f931a;
                    if (i >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i] == dVar) {
                        return i;
                    }
                    i++;
                }
            }

            private void c() {
                int i = this.f4963b - 1;
                int i2 = (i - 1) / 2;
                while (true) {
                    d[] dVarArr = this.f931a;
                    if (dVarArr[i].f932a < dVarArr[i2].f932a) {
                        d dVar = dVarArr[i];
                        dVarArr[i] = dVarArr[i2];
                        dVarArr[i2] = dVar;
                        int i3 = i2;
                        i2 = (i2 - 1) / 2;
                        i = i3;
                    } else {
                        return;
                    }
                }
            }

            private void c(int i) {
                int i2 = (i * 2) + 1;
                while (true) {
                    int i3 = this.f4963b;
                    if (i2 < i3 && i3 > 0) {
                        int i4 = i2 + 1;
                        if (i4 < i3) {
                            d[] dVarArr = this.f931a;
                            if (dVarArr[i4].f932a < dVarArr[i2].f932a) {
                                i2 = i4;
                            }
                        }
                        d[] dVarArr2 = this.f931a;
                        if (dVarArr2[i].f932a >= dVarArr2[i2].f932a) {
                            d dVar = dVarArr2[i];
                            dVarArr2[i] = dVarArr2[i2];
                            dVarArr2[i2] = dVar;
                            int i5 = i2;
                            i2 = (i2 * 2) + 1;
                            i = i5;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }

            public d a() {
                return this.f931a[0];
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m863a() {
                this.f931a = new d[this.f4962a];
                this.f4963b = 0;
            }

            public void a(int i) {
                for (int i2 = 0; i2 < this.f4963b; i2++) {
                    d[] dVarArr = this.f931a;
                    if (dVarArr[i2].f4965a == i) {
                        dVarArr[i2].a();
                    }
                }
                b();
            }

            public void a(int i, b bVar) {
                for (int i2 = 0; i2 < this.f4963b; i2++) {
                    d[] dVarArr = this.f931a;
                    if (dVarArr[i2].f933a == bVar) {
                        dVarArr[i2].a();
                    }
                }
                b();
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m864a(d dVar) {
                d[] dVarArr = this.f931a;
                int length = dVarArr.length;
                int i = this.f4963b;
                if (length == i) {
                    d[] dVarArr2 = new d[(i * 2)];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                    this.f931a = dVarArr2;
                }
                d[] dVarArr3 = this.f931a;
                int i2 = this.f4963b;
                this.f4963b = i2 + 1;
                dVarArr3[i2] = dVar;
                c();
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m865a() {
                return this.f4963b == 0;
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m866a(int i) {
                for (int i2 = 0; i2 < this.f4963b; i2++) {
                    if (this.f931a[i2].f4965a == i) {
                        return true;
                    }
                }
                return false;
            }

            public void b() {
                int i = 0;
                while (i < this.f4963b) {
                    if (this.f931a[i].f935a) {
                        this.f4964c++;
                        b(i);
                        i--;
                    }
                    i++;
                }
            }

            public void b(int i) {
                if (i >= 0) {
                    int i2 = this.f4963b;
                    if (i < i2) {
                        d[] dVarArr = this.f931a;
                        int i3 = i2 - 1;
                        this.f4963b = i3;
                        dVarArr[i] = dVarArr[i3];
                        dVarArr[i3] = null;
                        c(i);
                    }
                }
            }
        }

        public c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* access modifiers changed from: private */
        public void a(d dVar) {
            this.f928a.a(dVar);
            notify();
        }

        public synchronized void a() {
            this.f930b = true;
            this.f928a.a();
            notify();
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m862a() {
            return this.f929a && SystemClock.uptimeMillis() - this.f4959a > 600000;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:6|(2:8|(3:83|10|11)(2:12|13))(2:17|26)|14) */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            r10.f4959a = android.os.SystemClock.uptimeMillis();
            r10.f929a = true;
            r2.f933a.run();
            r10.f929a = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a4, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00a5, code lost:
            monitor-enter(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
            r10.f930b = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x00a9, code lost:
            throw r1;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0018 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r10 = this;
            L_0x0000:
                monitor-enter(r10)
                boolean r0 = r10.f930b     // Catch:{ all -> 0x00b3 }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r10)     // Catch:{ all -> 0x00b3 }
                return
            L_0x0007:
                com.xiaomi.push.service.o$c$a r0 = r10.f928a     // Catch:{ all -> 0x00b3 }
                boolean r0 = r0.a()     // Catch:{ all -> 0x00b3 }
                if (r0 == 0) goto L_0x001a
                boolean r0 = r10.f4961c     // Catch:{ all -> 0x00b3 }
                if (r0 == 0) goto L_0x0015
                monitor-exit(r10)     // Catch:{ all -> 0x00b3 }
                return
            L_0x0015:
                r10.wait()     // Catch:{ InterruptedException -> 0x0018 }
            L_0x0018:
                monitor-exit(r10)     // Catch:{ all -> 0x00b3 }
                goto L_0x0000
            L_0x001a:
                long r0 = com.xiaomi.push.service.o.a()     // Catch:{ all -> 0x00b3 }
                com.xiaomi.push.service.o$c$a r2 = r10.f928a     // Catch:{ all -> 0x00b3 }
                com.xiaomi.push.service.o$d r2 = r2.a()     // Catch:{ all -> 0x00b3 }
                java.lang.Object r3 = r2.f934a     // Catch:{ all -> 0x00b3 }
                monitor-enter(r3)     // Catch:{ all -> 0x00b3 }
                boolean r4 = r2.f935a     // Catch:{ all -> 0x00b0 }
                r5 = 0
                if (r4 == 0) goto L_0x0033
                com.xiaomi.push.service.o$c$a r0 = r10.f928a     // Catch:{ all -> 0x00b0 }
                r0.b(r5)     // Catch:{ all -> 0x00b0 }
                monitor-exit(r3)     // Catch:{ all -> 0x00b0 }
                goto L_0x0018
            L_0x0033:
                long r6 = r2.f932a     // Catch:{ all -> 0x00b0 }
                long r6 = r6 - r0
                monitor-exit(r3)     // Catch:{ all -> 0x00b0 }
                r0 = 50
                r3 = 0
                int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                if (r8 <= 0) goto L_0x0058
                long r2 = r10.f4960b     // Catch:{ all -> 0x00b3 }
                int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r4 <= 0) goto L_0x0047
                long r6 = r10.f4960b     // Catch:{ all -> 0x00b3 }
            L_0x0047:
                long r2 = r10.f4960b     // Catch:{ all -> 0x00b3 }
                long r2 = r2 + r0
                r10.f4960b = r2     // Catch:{ all -> 0x00b3 }
                r0 = 500(0x1f4, double:2.47E-321)
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 <= 0) goto L_0x0054
                r10.f4960b = r0     // Catch:{ all -> 0x00b3 }
            L_0x0054:
                r10.wait(r6)     // Catch:{ InterruptedException -> 0x0018 }
                goto L_0x0018
            L_0x0058:
                r10.f4960b = r0     // Catch:{ all -> 0x00b3 }
                java.lang.Object r0 = r2.f934a     // Catch:{ all -> 0x00b3 }
                monitor-enter(r0)     // Catch:{ all -> 0x00b3 }
                com.xiaomi.push.service.o$c$a r1 = r10.f928a     // Catch:{ all -> 0x00ad }
                com.xiaomi.push.service.o$d r1 = r1.a()     // Catch:{ all -> 0x00ad }
                long r6 = r1.f932a     // Catch:{ all -> 0x00ad }
                long r8 = r2.f932a     // Catch:{ all -> 0x00ad }
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 == 0) goto L_0x0072
                com.xiaomi.push.service.o$c$a r1 = r10.f928a     // Catch:{ all -> 0x00ad }
                int r1 = r1.a(r2)     // Catch:{ all -> 0x00ad }
                goto L_0x0073
            L_0x0072:
                r1 = 0
            L_0x0073:
                boolean r6 = r2.f935a     // Catch:{ all -> 0x00ad }
                if (r6 == 0) goto L_0x0084
                com.xiaomi.push.service.o$c$a r1 = r10.f928a     // Catch:{ all -> 0x00ad }
                com.xiaomi.push.service.o$c$a r3 = r10.f928a     // Catch:{ all -> 0x00ad }
                int r2 = r3.a(r2)     // Catch:{ all -> 0x00ad }
                r1.b(r2)     // Catch:{ all -> 0x00ad }
                monitor-exit(r0)     // Catch:{ all -> 0x00ad }
                goto L_0x0018
            L_0x0084:
                long r6 = r2.f932a     // Catch:{ all -> 0x00ad }
                r2.a(r6)     // Catch:{ all -> 0x00ad }
                com.xiaomi.push.service.o$c$a r6 = r10.f928a     // Catch:{ all -> 0x00ad }
                r6.b(r1)     // Catch:{ all -> 0x00ad }
                r2.f932a = r3     // Catch:{ all -> 0x00ad }
                monitor-exit(r0)     // Catch:{ all -> 0x00ad }
                monitor-exit(r10)     // Catch:{ all -> 0x00b3 }
                r0 = 1
                long r3 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x00a4 }
                r10.f4959a = r3     // Catch:{ all -> 0x00a4 }
                r10.f929a = r0     // Catch:{ all -> 0x00a4 }
                com.xiaomi.push.service.o$b r1 = r2.f933a     // Catch:{ all -> 0x00a4 }
                r1.run()     // Catch:{ all -> 0x00a4 }
                r10.f929a = r5     // Catch:{ all -> 0x00a4 }
                goto L_0x0000
            L_0x00a4:
                r1 = move-exception
                monitor-enter(r10)
                r10.f930b = r0     // Catch:{ all -> 0x00aa }
                monitor-exit(r10)     // Catch:{ all -> 0x00aa }
                throw r1
            L_0x00aa:
                r0 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x00aa }
                throw r0
            L_0x00ad:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00ad }
                throw r1     // Catch:{ all -> 0x00b3 }
            L_0x00b0:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x00b0 }
                throw r0     // Catch:{ all -> 0x00b3 }
            L_0x00b3:
                r0 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x00b3 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.o.c.run():void");
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public int f4965a;

        /* renamed from: a  reason: collision with other field name */
        public long f932a;

        /* renamed from: a  reason: collision with other field name */
        public b f933a;

        /* renamed from: a  reason: collision with other field name */
        public final Object f934a = new Object();

        /* renamed from: a  reason: collision with other field name */
        public boolean f935a;

        /* renamed from: b  reason: collision with root package name */
        public long f4966b;

        public void a(long j) {
            synchronized (this.f934a) {
                this.f4966b = j;
            }
        }

        public boolean a() {
            boolean z;
            synchronized (this.f934a) {
                z = !this.f935a && this.f932a > 0;
                this.f935a = true;
            }
            return z;
        }
    }

    static {
        long j = 0;
        if (SystemClock.elapsedRealtime() > 0) {
            j = SystemClock.elapsedRealtime();
        }
        f4954a = j;
        f4955b = j;
    }

    public o() {
        this(false);
    }

    public o(String str) {
        this(str, false);
    }

    public o(String str, boolean z) {
        if (str != null) {
            c cVar = new c(str, z);
            this.f927a = cVar;
            this.f926a = new a(cVar);
            return;
        }
        throw new NullPointerException("name == null");
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public o(boolean z) {
        // StringBuilder outline73 = GeneratedOutlineSupport.outline73("Timer-");
        // outline73.append(b());
        this(outline73.toString(), z);
    }

    public static synchronized long a() {
        long j;
        synchronized (o.class) {
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime > f4955b) {
                    f4954a = (elapsedRealtime - f4955b) + f4954a;
                }
                f4955b = elapsedRealtime;
                j = f4954a;
            }
        }
        return j;
    }

    public static synchronized long b() {
        long j;
        synchronized (o.class) {
            j = f4956c;
            f4956c = 1 + j;
        }
        return j;
    }

    private void b(b bVar, long j) {
        synchronized (this.f927a) {
            if (!c.a(this.f927a)) {
                long a2 = j + a();
                if (a2 >= 0) {
                    d dVar = new d();
                    dVar.f4965a = bVar.f4958a;
                    dVar.f933a = bVar;
                    dVar.f932a = a2;
                    this.f927a.a(dVar);
                } else {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
                }
            } else {
                throw new IllegalStateException("Timer was canceled");
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m858a() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("quit. finalizer:");
        outline73.append(this.f926a);
        com.xiaomi.channel.commonutils.logger.b.a(outline73.toString());
        this.f927a.a();
    }

    public void a(int i) {
        synchronized (this.f927a) {
            try {
                c.a(this.f927a).a(i);
            }
        }
    }

    public void a(int i, b bVar) {
        synchronized (this.f927a) {
            c.a(this.f927a).a(i, bVar);
        }
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() >= 1 || Thread.currentThread() == this.f927a) {
            bVar.run();
        } else {
            com.xiaomi.channel.commonutils.logger.b.d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
    }

    public void a(b bVar, long j) {
        if (j >= 0) {
            b(bVar, j);
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline45("delay < 0: ", j));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m859a() {
        return this.f927a.a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m860a(int i) {
        boolean a2;
        synchronized (this.f927a) {
            a2 = c.a(this.f927a).a(i);
        }
        return a2;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m861b() {
        synchronized (this.f927a) {
            c.a(this.f927a).a();
        }
    }
}
