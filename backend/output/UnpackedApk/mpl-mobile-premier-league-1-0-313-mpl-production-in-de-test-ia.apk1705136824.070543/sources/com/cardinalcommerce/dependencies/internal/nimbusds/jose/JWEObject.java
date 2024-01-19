package com.cardinalcommerce.dependencies.internal.nimbusds.jose;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import java.text.ParseException;

public class JWEObject extends e {

    /* renamed from: a  reason: collision with root package name */
    public JWEHeader f1960a;

    /* renamed from: b  reason: collision with root package name */
    public Base64URL f1961b;

    /* renamed from: c  reason: collision with root package name */
    public Base64URL f1962c;

    /* renamed from: d  reason: collision with root package name */
    public Base64URL f1963d;

    /* renamed from: e  reason: collision with root package name */
    public Base64URL f1964e;

    /* renamed from: f  reason: collision with root package name */
    public a f1965f;

    public enum a {
        UNENCRYPTED,
        ENCRYPTED,
        DECRYPTED
    }

    public JWEObject(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4, Base64URL base64URL5) {
        if (base64URL != null) {
            try {
                this.f1960a = JWEHeader.a(base64URL);
                if (base64URL2 == null || base64URL2.f2053a.isEmpty()) {
                    this.f1961b = null;
                } else {
                    this.f1961b = base64URL2;
                }
                if (base64URL3 == null || base64URL3.f2053a.isEmpty()) {
                    this.f1962c = null;
                } else {
                    this.f1962c = base64URL3;
                }
                if (base64URL4 != null) {
                    this.f1963d = base64URL4;
                    if (base64URL5 == null || base64URL5.f2053a.isEmpty()) {
                        this.f1964e = null;
                    } else {
                        this.f1964e = base64URL5;
                    }
                    this.f1965f = a.ENCRYPTED;
                    this.f2004b = new Base64URL[]{base64URL, base64URL2, base64URL3, base64URL4, base64URL5};
                    return;
                }
                throw new IllegalArgumentException("The fourth part must not be null");
            } catch (ParseException e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid JWE header: ");
                outline73.append(e2.getMessage());
                throw new ParseException(outline73.toString(), 0);
            }
        } else {
            throw new IllegalArgumentException("The first part must not be null");
        }
    }
}
