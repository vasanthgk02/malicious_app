package com.cardinalcommerce.dependencies.internal.nimbusds.jose.util;

public class Base64URL extends Base64 {
    public Base64URL(String str) {
        super(str);
    }

    public static Base64URL a(String str) {
        if (str == null) {
            return null;
        }
        return new Base64URL(str);
    }

    public static Base64URL a(byte[] bArr) {
        return new Base64URL(a.a(bArr, true));
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof Base64URL) && this.f2053a.equals(obj.toString());
    }
}
