package co.hyperverge.hypersnapsdk.c;

import java.io.Serializable;

/* compiled from: TimingUtils */
public class q implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public int f3139a;

    /* renamed from: c  reason: collision with root package name */
    public long f3140c;

    public q() {
        this.f3139a = 1;
        this.f3140c = 0;
        this.f3140c = a();
    }

    public long a() {
        int i = this.f3139a;
        if (i == 1) {
            return System.currentTimeMillis();
        }
        if (i == 2) {
            return System.nanoTime() / 1000;
        }
        if (i != 3) {
            return System.currentTimeMillis();
        }
        return System.nanoTime();
    }

    public long b() {
        long longValue = c().longValue();
        this.f3140c = a();
        return longValue;
    }

    public Long c() {
        return Long.valueOf(a() - this.f3140c);
    }

    public void d() {
        this.f3140c = a();
    }
}
