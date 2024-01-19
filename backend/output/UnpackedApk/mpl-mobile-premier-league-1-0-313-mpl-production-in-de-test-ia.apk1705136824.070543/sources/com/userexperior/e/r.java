package com.userexperior.e;

public final class r<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f4027a;

    /* renamed from: b  reason: collision with root package name */
    public final c f4028b;

    /* renamed from: c  reason: collision with root package name */
    public final y f4029c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4030d;

    public r(y yVar) {
        this.f4030d = false;
        this.f4027a = null;
        this.f4028b = null;
        this.f4029c = yVar;
    }

    public r(T t, c cVar) {
        this.f4030d = false;
        this.f4027a = t;
        this.f4028b = cVar;
        this.f4029c = null;
    }

    public static <T> r<T> a(T t, c cVar) {
        return new r<>(t, cVar);
    }
}
