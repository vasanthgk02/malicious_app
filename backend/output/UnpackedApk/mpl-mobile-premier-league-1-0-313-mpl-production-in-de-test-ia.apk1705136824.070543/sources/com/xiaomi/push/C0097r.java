package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.xiaomi.push.r  reason: case insensitive filesystem */
public class C0097r {

    /* renamed from: a  reason: collision with root package name */
    public int f4803a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f774a;

    /* renamed from: a  reason: collision with other field name */
    public a f775a;

    /* renamed from: a  reason: collision with other field name */
    public volatile b f776a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f777a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f4804b;

    /* renamed from: com.xiaomi.push.r$a */
    public class a extends Thread {

        /* renamed from: a  reason: collision with other field name */
        public final LinkedBlockingQueue<b> f778a = new LinkedBlockingQueue<>();

        public a() {
            super("PackageProcessor");
        }

        private void a(int i, b bVar) {
            try {
                C0097r.a(C0097r.this).sendMessage(C0097r.a(C0097r.this).obtainMessage(i, bVar));
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a((Throwable) e2);
            }
        }

        public void a(b bVar) {
            try {
                this.f778a.add(bVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void run() {
            long a2 = C0097r.a(C0097r.this) > 0 ? (long) C0097r.a(C0097r.this) : Long.MAX_VALUE;
            while (!C0097r.a(C0097r.this)) {
                try {
                    b poll = this.f778a.poll(a2, TimeUnit.SECONDS);
                    C0097r.this.f776a = poll;
                    if (poll != null) {
                        a(0, poll);
                        poll.b();
                        a(1, poll);
                    } else if (C0097r.a(C0097r.this) > 0) {
                        C0097r.a(C0097r.this);
                    }
                } catch (InterruptedException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a((Throwable) e2);
                }
            }
        }
    }

    /* renamed from: com.xiaomi.push.r$b */
    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        public void c() {
        }
    }

    public C0097r() {
        this(false);
    }

    public C0097r(boolean z) {
        this(z, 0);
    }

    public C0097r(boolean z, int i) {
        this.f774a = null;
        this.f777a = false;
        this.f4803a = 0;
        this.f774a = new s(this, Looper.getMainLooper());
        this.f4804b = z;
        this.f4803a = i;
    }

    private synchronized void a() {
        this.f775a = null;
        this.f777a = true;
    }

    public synchronized void a(b bVar) {
        if (this.f775a == null) {
            a aVar = new a();
            this.f775a = aVar;
            aVar.setDaemon(this.f4804b);
            this.f777a = false;
            this.f775a.start();
        }
        this.f775a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.f774a.postDelayed(new t(this, bVar), j);
    }
}
