package com.cardinalcommerce.dependencies.internal.nimbusds.jose;

import com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.i;
import java.io.Serializable;

public final class Payload implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final JSONObject f1971b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1972c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f1973d;

    /* renamed from: e  reason: collision with root package name */
    public final Base64URL f1974e;

    /* renamed from: f  reason: collision with root package name */
    public final JWSObject f1975f;

    public enum a {
        JSON,
        STRING,
        BYTE_ARRAY,
        BASE64URL,
        JWS_OBJECT,
        SIGNED_JWT
    }

    public Payload(byte[] bArr) {
        if (bArr != null) {
            this.f1971b = null;
            this.f1972c = null;
            this.f1973d = bArr;
            this.f1974e = null;
            this.f1975f = null;
            a aVar = a.BYTE_ARRAY;
            return;
        }
        throw new IllegalArgumentException("The byte array must not be null");
    }

    public String toString() {
        String str = this.f1972c;
        if (str != null) {
            return str;
        }
        JSONObject jSONObject = this.f1971b;
        if (jSONObject != null) {
            return jSONObject.toString();
        }
        byte[] bArr = this.f1973d;
        String str2 = null;
        if (bArr != null) {
            return new String(bArr, i.f2055a);
        }
        Base64URL base64URL = this.f1974e;
        if (base64URL != null) {
            str2 = new String(base64URL.a(), i.f2055a);
        }
        return str2;
    }
}
