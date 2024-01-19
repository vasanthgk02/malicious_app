package io.hansel.ujmtracker.m;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public long f5396a = 0;

    private long b(f fVar) {
        long j = this.f5396a;
        if (j == 0) {
            return 10;
        }
        return j;
    }

    public void a(long j) {
        this.f5396a = j;
    }

    public boolean a(f fVar) {
        return fVar.b() == 0 && System.currentTimeMillis() - fVar.c() > b(fVar) * 1000 && fVar.e() > 0;
    }
}
