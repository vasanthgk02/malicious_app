package com.cardinalcommerce.emvco.a.g;

import com.cardinalcommerce.emvco.a.b.b;

public class a extends com.cardinalcommerce.shared.cs.utils.a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f2068d;

    public a() {
        if (f2068d != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance.");
        }
    }

    public static a a() {
        if (f2068d == null) {
            synchronized (a.class) {
                try {
                    if (f2068d == null) {
                        f2068d = new a();
                    }
                }
            }
        }
        return f2068d;
    }

    public void a(String str, String str2) {
        if (com.cardinalcommerce.shared.cs.utils.a.f2213a) {
            com.cardinalcommerce.shared.cs.utils.a.f2214b = new b().f2057f;
            com.cardinalcommerce.shared.cs.utils.a.f2215c = "EMVCoLoggerV1";
            super.a(str, str2, null);
        }
    }

    public com.cardinalcommerce.shared.cs.utils.b b() {
        return super.b();
    }

    public void b(String str, String str2) {
        if (com.cardinalcommerce.shared.cs.utils.a.f2213a) {
            com.cardinalcommerce.shared.cs.utils.a.f2214b = new b().f2057f;
            com.cardinalcommerce.shared.cs.utils.a.f2215c = "EMVCoLoggerV1";
            super.b(str, str2, null);
        }
    }

    public void c() {
        super.c();
    }
}
