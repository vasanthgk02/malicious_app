package com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk;

import co.hyperverge.hypersnapsdk.c.k;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.a;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import java.math.BigInteger;
import java.net.URI;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECFieldFp;
import java.security.spec.EllipticCurve;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class ECKey extends JWK {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<Curve> f2012a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Curve[]{Curve.f2006a, Curve.f2007b, Curve.f2009d, Curve.f2010e})));

    /* renamed from: b  reason: collision with root package name */
    public final Curve f2013b;

    /* renamed from: c  reason: collision with root package name */
    public final Base64URL f2014c;

    /* renamed from: d  reason: collision with root package name */
    public final Base64URL f2015d;

    /* renamed from: e  reason: collision with root package name */
    public final Base64URL f2016e;

    /* renamed from: f  reason: collision with root package name */
    public final PrivateKey f2017f;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ECKey(Curve curve, Base64URL base64URL, Base64URL base64URL2, e eVar, Set<c> set, a aVar, String str, URI uri, Base64URL base64URL3, Base64URL base64URL4, List<Base64> list, KeyStore keyStore) {
        // Curve curve2 = curve;
        // Base64URL base64URL5 = base64URL;
        // Base64URL base64URL6 = base64URL2;
        super(d.f2028a, eVar, set, aVar, str, uri, base64URL3, base64URL4, list, null);
        if (curve2 != null) {
            this.f2013b = curve2;
            if (base64URL5 != null) {
                this.f2014c = base64URL5;
                if (base64URL6 != null) {
                    this.f2015d = base64URL6;
                    a(curve, base64URL, base64URL2);
                    a(e());
                    this.f2016e = null;
                    this.f2017f = null;
                    return;
                }
                throw new IllegalArgumentException("The 'y' coordinate must not be null");
            }
            throw new IllegalArgumentException("The 'x' coordinate must not be null");
        }
        throw new IllegalArgumentException("The curve must not be null");
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ECKey(Curve curve, Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, e eVar, Set<c> set, a aVar, String str, URI uri, Base64URL base64URL4, Base64URL base64URL5, List<Base64> list, KeyStore keyStore) {
        // Curve curve2 = curve;
        // Base64URL base64URL6 = base64URL;
        // Base64URL base64URL7 = base64URL2;
        super(d.f2028a, eVar, set, aVar, str, uri, base64URL4, base64URL5, list, null);
        if (curve2 != null) {
            this.f2013b = curve2;
            if (base64URL6 != null) {
                this.f2014c = base64URL6;
                if (base64URL7 != null) {
                    this.f2015d = base64URL7;
                    a(curve, base64URL, base64URL2);
                    a(e());
                    this.f2016e = base64URL3;
                    this.f2017f = null;
                    return;
                }
                throw new IllegalArgumentException("The 'y' coordinate must not be null");
            }
            throw new IllegalArgumentException("The 'x' coordinate must not be null");
        }
        throw new IllegalArgumentException("The curve must not be null");
    }

    public static ECKey a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (d.f2028a.equals(k.a(jSONObject))) {
            try {
                Curve a2 = Curve.a(k.d(jSONObject2, (String) "crv"));
                Base64URL j = k.j(jSONObject2, "x");
                Base64URL j2 = k.j(jSONObject2, "y");
                Base64URL j3 = k.j(jSONObject2, "d");
                if (j3 == null) {
                    try {
                        ECKey eCKey = new ECKey(a2, j, j2, k.b(jSONObject), k.c(jSONObject), k.d(jSONObject), k.e(jSONObject), k.f(jSONObject), k.g(jSONObject), k.h(jSONObject), k.i(jSONObject), null);
                        return eCKey;
                    } catch (IllegalArgumentException e2) {
                        throw new ParseException(e2.getMessage(), 0);
                    }
                } else {
                    ECKey eCKey2 = new ECKey(a2, j, j2, j3, k.b(jSONObject), k.c(jSONObject), k.d(jSONObject), k.e(jSONObject), k.f(jSONObject), k.g(jSONObject), k.h(jSONObject), k.i(jSONObject), null);
                    return eCKey2;
                }
            } catch (IllegalArgumentException e3) {
                throw new ParseException(e3.getMessage(), 0);
            }
        } else {
            throw new ParseException("The key type \"kty\" must be EC", 0);
        }
    }

    public static void a(Curve curve, Base64URL base64URL, Base64URL base64URL2) {
        if (f2012a.contains(curve)) {
            BigInteger b2 = base64URL.b();
            BigInteger b3 = base64URL2.b();
            EllipticCurve curve2 = a.a(curve).getCurve();
            BigInteger a2 = curve2.getA();
            BigInteger b4 = curve2.getB();
            BigInteger p = ((ECFieldFp) curve2.getField()).getP();
            if (!b3.pow(2).mod(p).equals(b2.pow(3).add(a2.multiply(b2)).add(b4).mod(p))) {
                throw new IllegalArgumentException("Invalid EC JWK: The 'x' and 'y' public coordinates are not on the " + curve + " curve");
            }
            return;
        }
        throw new IllegalArgumentException("Unknown / unsupported curve: " + curve);
    }

    public boolean c() {
        return (this.f2016e == null && this.f2017f == null) ? false : true;
    }

    public JSONObject d() {
        JSONObject d2 = super.d();
        d2.put("crv", this.f2013b.j);
        d2.put("x", this.f2014c.f2053a);
        d2.put("y", this.f2015d.f2053a);
        Base64URL base64URL = this.f2016e;
        if (base64URL != null) {
            d2.put("d", base64URL.f2053a);
        }
        return d2;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ECKey) || !super.equals(obj)) {
            return false;
        }
        ECKey eCKey = (ECKey) obj;
        if (!Objects.equals(this.f2013b, eCKey.f2013b) || !Objects.equals(this.f2014c, eCKey.f2014c) || !Objects.equals(this.f2015d, eCKey.f2015d) || !Objects.equals(this.f2016e, eCKey.f2016e) || !Objects.equals(this.f2017f, eCKey.f2017f)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.f2013b, this.f2014c, this.f2015d, this.f2016e, this.f2017f});
    }

    public final void a(List<X509Certificate> list) {
        if (list != null) {
            boolean z = false;
            X509Certificate x509Certificate = list.get(0);
            try {
                ECPublicKey eCPublicKey = (ECPublicKey) e().get(0).getPublicKey();
                if (this.f2014c.b().equals(eCPublicKey.getW().getAffineX()) && this.f2015d.b().equals(eCPublicKey.getW().getAffineY())) {
                    z = true;
                }
            } catch (ClassCastException unused) {
            }
            if (!z) {
                throw new IllegalArgumentException("The public subject key info of the first X.509 certificate in the chain must match the JWK type and public parameters");
            }
        }
    }
}
