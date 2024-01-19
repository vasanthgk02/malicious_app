package com.nimbusds.jose.jwk;

import java.io.Serializable;

public final class Curve implements Serializable {
    public static final Curve Ed25519 = new Curve("Ed25519", "Ed25519", null);
    public static final Curve Ed448 = new Curve("Ed448", "Ed448", null);
    public static final Curve P_256 = new Curve("P-256", "secp256r1", "1.2.840.10045.3.1.7");
    public static final Curve P_384 = new Curve("P-384", "secp384r1", "1.3.132.0.34");
    public static final Curve P_521 = new Curve("P-521", "secp521r1", "1.3.132.0.35");
    public static final Curve X25519 = new Curve("X25519", "X25519", null);
    public static final Curve X448 = new Curve("X448", "X448", null);
    public static final long serialVersionUID = 1;
    public final String name;

    public Curve(String str, String str2, String str3) {
        if (str != null) {
            this.name = str;
            return;
        }
        throw new IllegalArgumentException("The JOSE cryptographic curve name must not be null");
    }

    public static Curve parse(String str) {
        if (str.trim().isEmpty()) {
            throw new IllegalArgumentException("The cryptographic curve string must not be null or empty");
        } else if (str.equals(P_256.name)) {
            return P_256;
        } else {
            if (str.equals(P_384.name)) {
                return P_384;
            }
            if (str.equals(P_521.name)) {
                return P_521;
            }
            if (str.equals(Ed25519.name)) {
                return Ed25519;
            }
            if (str.equals(Ed448.name)) {
                return Ed448;
            }
            if (str.equals(X25519.name)) {
                return X25519;
            }
            if (str.equals(X448.name)) {
                return X448;
            }
            return new Curve(str, null, null);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof Curve) && this.name.equals(obj.toString());
    }

    public String toString() {
        return this.name;
    }
}
