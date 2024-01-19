package com.cardinalcommerce.dependencies.internal.nimbusds.jose.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONAware;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONValue;
import java.io.Serializable;
import java.math.BigInteger;

public class Base64 implements JSONAware, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final String f2053a;

    public Base64(String str) {
        if (str != null) {
            this.f2053a = str;
            return;
        }
        throw new IllegalArgumentException("The Base64 value must not be null");
    }

    public byte[] a() {
        return a.a(this.f2053a);
    }

    public BigInteger b() {
        return new BigInteger(1, a());
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof Base64) && this.f2053a.equals(obj.toString());
    }

    public int hashCode() {
        return this.f2053a.hashCode();
    }

    public String toJSONString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("\"");
        outline73.append(JSONValue.escape(this.f2053a));
        outline73.append("\"");
        return outline73.toString();
    }

    public String toString() {
        return this.f2053a;
    }
}
