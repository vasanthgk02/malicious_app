package io.hansel.core.network.request.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;

public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f5210a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public a f5211b;

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f5212c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5213d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5214e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5215f;
    public Thread g;
    public final Runnable h = new a();
    public d i = null;
    public long j = -1;
    public c k = null;
    public b l = null;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            e.this.f5212c = null;
            e.this.f5211b = null;
            e.this.g = null;
            e.this.f5215f = false;
        }
    }

    public interface b {
        void a();
    }

    public interface c {
        void a();
    }

    public interface d {
        void a(Bitmap bitmap);
    }

    private boolean a() {
        return (this.f5213d || this.f5214e) && this.f5211b != null && this.g == null;
    }

    private void g() {
        if (a()) {
            Thread thread = new Thread(this);
            this.g = thread;
            thread.start();
        }
    }

    public void a(int i2) {
        if (this.f5211b.b() != i2 && this.f5211b.b(i2 - 1) && !this.f5213d) {
            this.f5214e = true;
            g();
        }
    }

    public void a(d dVar) {
        this.i = dVar;
    }

    public void a(byte[] bArr) {
        a aVar = new a();
        this.f5211b = aVar;
        try {
            aVar.a(bArr);
            if (this.f5213d) {
                g();
            } else {
                a(0);
            }
        } catch (Exception unused) {
            this.f5211b = null;
        }
    }

    public int b() {
        return this.f5211b.d();
    }

    public int c() {
        return this.f5211b.c();
    }

    public boolean d() {
        return this.f5213d;
    }

    public void e() {
        this.f5211b.l();
        a(0);
    }

    public void f() {
        this.f5213d = true;
        g();
    }

    public void run() {
        long j2;
        b bVar = this.l;
        if (bVar != null) {
            bVar.a();
        }
        while (true) {
            if (!this.f5213d && !this.f5214e) {
                break;
            }
            boolean a2 = this.f5211b.a();
            try {
                long nanoTime = System.nanoTime();
                Bitmap h2 = this.f5211b.h();
                this.f5212c = h2;
                d dVar = this.i;
                if (dVar != null) {
                    dVar.a(h2);
                }
                j2 = (System.nanoTime() - nanoTime) / 1000000;
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused) {
                j2 = 0;
            }
            this.f5214e = false;
            if (this.f5213d && a2) {
                try {
                    int g2 = (int) (((long) this.f5211b.g()) - j2);
                    if (g2 > 0) {
                        long j3 = this.j;
                        if (j3 <= 0) {
                            j3 = (long) g2;
                        }
                        Thread.sleep(j3);
                    }
                } catch (InterruptedException unused2) {
                }
                if (!this.f5213d) {
                    break;
                }
            } else {
                this.f5213d = false;
            }
        }
        this.f5213d = false;
        if (this.f5215f) {
            this.f5210a.post(this.h);
        }
        this.g = null;
        c cVar = this.k;
        if (cVar != null) {
            cVar.a();
        }
    }
}
