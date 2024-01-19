package com.cardinalcommerce.shared.cs.a;

import com.cardinalcommerce.shared.cs.f.g;
import com.cardinalcommerce.shared.cs.f.j;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static g f2069a;

    /* renamed from: b  reason: collision with root package name */
    public static b f2070b;

    /* renamed from: c  reason: collision with root package name */
    public j f2071c;

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            try {
                if (f2070b == null) {
                    f2070b = new b();
                    f2069a = new g();
                }
                bVar = f2070b;
            }
        }
        return bVar;
    }
}
