package com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk;

import java.io.Serializable;

public final class Curve implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final Curve f2006a = new Curve("P-256", "secp256r1", "1.2.840.10045.3.1.7");

    /* renamed from: b  reason: collision with root package name */
    public static final Curve f2007b = new Curve("secp256k1", "secp256k1", "1.3.132.0.10");
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final Curve f2008c = new Curve("P-256K", "secp256k1", "1.3.132.0.10");

    /* renamed from: d  reason: collision with root package name */
    public static final Curve f2009d = new Curve("P-384", "secp384r1", "1.3.132.0.34");

    /* renamed from: e  reason: collision with root package name */
    public static final Curve f2010e = new Curve("P-521", "secp521r1", "1.3.132.0.35");

    /* renamed from: f  reason: collision with root package name */
    public static final Curve f2011f = new Curve("Ed25519", "Ed25519", null);
    public static final Curve g = new Curve("Ed448", "Ed448", null);
    public static final Curve h = new Curve("X25519", "X25519", null);
    public static final Curve i = new Curve("X448", "X448", null);
    public final String j;

    public Curve(String str, String str2, String str3) {
        if (str != null) {
            this.j = str;
            return;
        }
        throw new IllegalArgumentException("The JOSE cryptographic curve name must not be null");
    }

    public static Curve a(String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("The cryptographic curve string must not be null or empty");
        } else if (str.equals(f2006a.j)) {
            return f2006a;
        } else {
            if (str.equals(f2008c.j)) {
                return f2008c;
            }
            if (str.equals(f2007b.j)) {
                return f2007b;
            }
            if (str.equals(f2009d.j)) {
                return f2009d;
            }
            if (str.equals(f2010e.j)) {
                return f2010e;
            }
            if (str.equals(f2011f.j)) {
                return f2011f;
            }
            if (str.equals(g.j)) {
                return g;
            }
            if (str.equals(h.j)) {
                return h;
            }
            if (str.equals(i.j)) {
                return i;
            }
            return new Curve(str, null, null);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof Curve) && this.j.equals(obj.toString());
    }

    public String toString() {
        return this.j;
    }
}
