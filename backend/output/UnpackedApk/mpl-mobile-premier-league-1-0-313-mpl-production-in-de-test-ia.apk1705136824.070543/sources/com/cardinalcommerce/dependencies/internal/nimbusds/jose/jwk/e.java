package com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Objects;

public final class e implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final e f2033a = new e("sig");

    /* renamed from: b  reason: collision with root package name */
    public static final e f2034b = new e("enc");

    /* renamed from: c  reason: collision with root package name */
    public final String f2035c;

    public e(String str) {
        this.f2035c = str;
    }

    public static e a(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals(f2033a.f2035c)) {
            return f2033a;
        }
        if (str.equals(f2034b.f2035c)) {
            return f2034b;
        }
        if (!str.trim().isEmpty()) {
            return new e(str);
        }
        throw new ParseException("JWK use value must not be empty or blank", 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return Objects.equals(this.f2035c, ((e) obj).f2035c);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f2035c});
    }

    public String toString() {
        return this.f2035c;
    }
}
