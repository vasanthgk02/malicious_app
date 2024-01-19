package io.hansel.ujmtracker.m;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public long f5360a;

    /* renamed from: b  reason: collision with root package name */
    public Object f5361b;

    /* renamed from: c  reason: collision with root package name */
    public String f5362c;

    /* renamed from: d  reason: collision with root package name */
    public long f5363d;

    /* renamed from: e  reason: collision with root package name */
    public long f5364e;

    /* renamed from: f  reason: collision with root package name */
    public a f5365f;

    public enum a {
        CSTATE_NOT_CACHED,
        CSTATE_CACHED
    }

    public d() {
        a(System.nanoTime() + System.currentTimeMillis());
        a(a.CSTATE_NOT_CACHED);
    }

    public d(Object obj, String str, long j) {
        a(System.nanoTime() + System.currentTimeMillis());
        a(obj);
        a(str);
        b(j);
        a(a.CSTATE_NOT_CACHED);
    }

    public a a() {
        return this.f5365f;
    }

    public void a(long j) {
        this.f5360a = j;
    }

    public void a(a aVar) {
        this.f5365f = aVar;
    }

    public void a(Object obj) {
        this.f5361b = obj;
    }

    public void a(String str) {
        this.f5362c = str;
    }

    public Object b() {
        return this.f5361b;
    }

    public void b(long j) {
        this.f5364e = j;
    }

    public String c() {
        return this.f5362c;
    }

    public long d() {
        return this.f5360a;
    }

    public long e() {
        return this.f5363d;
    }

    public long f() {
        return this.f5364e;
    }
}
