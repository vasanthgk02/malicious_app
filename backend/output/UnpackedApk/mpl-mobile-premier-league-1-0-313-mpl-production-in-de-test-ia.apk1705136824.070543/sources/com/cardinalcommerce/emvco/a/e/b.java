package com.cardinalcommerce.emvco.a.e;

public class b {

    /* renamed from: e  reason: collision with root package name */
    public static b f2058e;

    /* renamed from: a  reason: collision with root package name */
    public int f2059a = 0;

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f2058e == null) {
                f2058e = new b();
            }
            bVar = f2058e;
        }
        return bVar;
    }
}
