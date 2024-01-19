package com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk;

import co.hyperverge.hypersnapsdk.c.k;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.a;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import java.net.URI;
import java.security.KeyStore;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class g extends JWK {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<Curve> f2037a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Curve[]{Curve.f2011f, Curve.g, Curve.h, Curve.i})));

    /* renamed from: b  reason: collision with root package name */
    public final Curve f2038b;

    /* renamed from: c  reason: collision with root package name */
    public final Base64URL f2039c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f2040d;

    /* renamed from: e  reason: collision with root package name */
    public final Base64URL f2041e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f2042f;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public g(Curve curve, Base64URL base64URL, e eVar, Set<c> set, a aVar, String str, URI uri, Base64URL base64URL2, Base64URL base64URL3, List<Base64> list, KeyStore keyStore) {
        // Curve curve2 = curve;
        // Base64URL base64URL4 = base64URL;
        super(d.f2031d, eVar, set, aVar, str, uri, base64URL2, base64URL3, list, null);
        if (curve2 == null) {
            throw new IllegalArgumentException("The curve must not be null");
        } else if (f2037a.contains(curve)) {
            this.f2038b = curve2;
            if (base64URL4 != null) {
                this.f2039c = base64URL4;
                this.f2040d = base64URL.a();
                this.f2041e = null;
                this.f2042f = null;
                return;
            }
            throw new IllegalArgumentException("The 'x' parameter must not be null");
        } else {
            throw new IllegalArgumentException("Unknown / unsupported curve: " + curve);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public g(Curve curve, Base64URL base64URL, Base64URL base64URL2, e eVar, Set<c> set, a aVar, String str, URI uri, Base64URL base64URL3, Base64URL base64URL4, List<Base64> list, KeyStore keyStore) {
        // Curve curve2 = curve;
        // Base64URL base64URL5 = base64URL;
        super(d.f2031d, eVar, set, aVar, str, uri, base64URL3, base64URL4, list, null);
        if (curve2 == null) {
            throw new IllegalArgumentException("The curve must not be null");
        } else if (f2037a.contains(curve)) {
            this.f2038b = curve2;
            if (base64URL5 != null) {
                this.f2039c = base64URL5;
                this.f2040d = base64URL.a();
                this.f2041e = base64URL2;
                this.f2042f = base64URL2.a();
                return;
            }
            throw new IllegalArgumentException("The 'x' parameter must not be null");
        } else {
            throw new IllegalArgumentException("Unknown / unsupported curve: " + curve);
        }
    }

    public static g a(JSONObject jSONObject) {
        if (d.f2031d.equals(k.a(jSONObject))) {
            try {
                Curve a2 = Curve.a(k.d(jSONObject, (String) "crv"));
                Base64URL j = k.j(jSONObject, "x");
                Base64URL j2 = k.j(jSONObject, "d");
                if (j2 == null) {
                    try {
                        g gVar = new g(a2, j, k.b(jSONObject), k.c(jSONObject), k.d(jSONObject), k.e(jSONObject), k.f(jSONObject), k.g(jSONObject), k.h(jSONObject), k.i(jSONObject), null);
                        return gVar;
                    } catch (IllegalArgumentException e2) {
                        throw new ParseException(e2.getMessage(), 0);
                    }
                } else {
                    g gVar2 = new g(a2, j, j2, k.b(jSONObject), k.c(jSONObject), k.d(jSONObject), k.e(jSONObject), k.f(jSONObject), k.g(jSONObject), k.h(jSONObject), k.i(jSONObject), null);
                    return gVar2;
                }
            } catch (IllegalArgumentException e3) {
                throw new ParseException(e3.getMessage(), 0);
            }
        } else {
            throw new ParseException("The key type \"kty\" must be OKP", 0);
        }
    }

    public boolean c() {
        return this.f2041e != null;
    }

    public JSONObject d() {
        JSONObject d2 = super.d();
        d2.put("crv", this.f2038b.j);
        d2.put("x", this.f2039c.f2053a);
        Base64URL base64URL = this.f2041e;
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
        if (!(obj instanceof g) || !super.equals(obj)) {
            return false;
        }
        g gVar = (g) obj;
        if (!Objects.equals(this.f2038b, gVar.f2038b) || !Objects.equals(this.f2039c, gVar.f2039c) || !Arrays.equals(this.f2040d, gVar.f2040d) || !Objects.equals(this.f2041e, gVar.f2041e) || !Arrays.equals(this.f2042f, gVar.f2042f)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        Object[] objArr = {Integer.valueOf(super.hashCode()), this.f2038b, this.f2039c, this.f2041e};
        int hashCode = Arrays.hashCode(this.f2040d);
        return Arrays.hashCode(this.f2042f) + ((hashCode + (Objects.hash(objArr) * 31)) * 31);
    }
}
