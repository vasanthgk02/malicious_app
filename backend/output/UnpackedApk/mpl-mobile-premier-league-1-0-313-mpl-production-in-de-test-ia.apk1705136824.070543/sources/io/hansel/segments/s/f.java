package io.hansel.segments.s;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public int f5304a;

    /* renamed from: b  reason: collision with root package name */
    public String f5305b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5306c;

    /* renamed from: d  reason: collision with root package name */
    public String f5307d;

    public f(int i, Class<? extends Object> cls, boolean z, String str) {
        this.f5304a = i;
        this.f5305b = (cls.equals(Long.class) || cls.equals(Integer.class)) ? "INTEGER" : (cls.equals(Double.class) || cls.equals(Float.class)) ? "REAL" : cls.equals(String.class) ? "TEXT" : "BLOB";
        this.f5306c = z;
        this.f5307d = str;
    }

    public String a() {
        return this.f5307d;
    }

    public int b() {
        return this.f5304a;
    }

    public String c() {
        return this.f5305b;
    }

    public boolean d() {
        return this.f5306c;
    }
}
