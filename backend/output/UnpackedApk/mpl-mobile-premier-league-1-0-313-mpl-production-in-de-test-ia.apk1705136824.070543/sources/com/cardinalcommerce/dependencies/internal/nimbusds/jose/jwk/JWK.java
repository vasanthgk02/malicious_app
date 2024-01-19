package com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONArray;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONAware;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.a;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import java.io.Serializable;
import java.net.URI;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import sfs2x.client.requests.mmo.SetUserPositionRequest;

public abstract class JWK implements JSONAware, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final d f2018a;

    /* renamed from: b  reason: collision with root package name */
    public final e f2019b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<c> f2020c;

    /* renamed from: d  reason: collision with root package name */
    public final a f2021d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2022e;

    /* renamed from: f  reason: collision with root package name */
    public final URI f2023f;
    @Deprecated
    public final Base64URL g;
    public Base64URL h;
    public final List<Base64> i;
    public final List<X509Certificate> j;
    public final KeyStore k;

    public JWK(d dVar, e eVar, Set<c> set, a aVar, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, KeyStore keyStore) {
        if (dVar != null) {
            this.f2018a = dVar;
            if (f.a(eVar, set)) {
                this.f2019b = eVar;
                this.f2020c = set;
                this.f2021d = aVar;
                this.f2022e = str;
                this.f2023f = uri;
                this.g = base64URL;
                this.h = base64URL2;
                if (list == null || !list.isEmpty()) {
                    this.i = list;
                    try {
                        this.j = k.a(list);
                        this.k = keyStore;
                    } catch (ParseException e2) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid X.509 certificate chain \"x5c\": ");
                        outline73.append(e2.getMessage());
                        throw new IllegalArgumentException(outline73.toString(), e2);
                    }
                } else {
                    throw new IllegalArgumentException("The X.509 certificate chain \"x5c\" must not be empty");
                }
            } else {
                throw new IllegalArgumentException("The key use \"use\" and key options \"key_opts\" parameters are not consistent, see RFC 7517, section 4.3");
            }
        } else {
            throw new IllegalArgumentException("The key type \"kty\" parameter must not be null");
        }
    }

    public static JWK b(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        d a2 = d.a(k.d(jSONObject2, (String) "kty"));
        if (a2 == d.f2028a) {
            return ECKey.a(jSONObject);
        }
        d dVar = d.f2029b;
        if (a2 != dVar) {
            d dVar2 = d.f2030c;
            if (a2 == dVar2) {
                if (dVar2.equals(k.a(jSONObject))) {
                    try {
                        h hVar = new h(k.j(jSONObject2, com.userexperior.utilities.k.f4287a), k.b(jSONObject), k.c(jSONObject), k.d(jSONObject), k.e(jSONObject), k.f(jSONObject), k.g(jSONObject), k.h(jSONObject), k.i(jSONObject), null);
                        return hVar;
                    } catch (IllegalArgumentException e2) {
                        throw new ParseException(e2.getMessage(), 0);
                    }
                } else {
                    throw new ParseException("The key type \"kty\" must be oct", 0);
                }
            } else if (a2 == d.f2031d) {
                return g.a(jSONObject);
            } else {
                throw new ParseException("Unsupported key type \"kty\" parameter: " + a2, 0);
            }
        } else if (dVar.equals(k.a(jSONObject))) {
            Base64URL j2 = k.j(jSONObject2, "n");
            Base64URL j3 = k.j(jSONObject2, "e");
            Base64URL j4 = k.j(jSONObject2, "d");
            Base64URL j5 = k.j(jSONObject2, "p");
            Base64URL j6 = k.j(jSONObject2, SetUserPositionRequest.KEY_PLUS_ITEM_LIST);
            Base64URL j7 = k.j(jSONObject2, "dp");
            Base64URL j8 = k.j(jSONObject2, "dq");
            Base64URL j9 = k.j(jSONObject2, "qi");
            ArrayList arrayList = null;
            if (jSONObject2.containsKey("oth")) {
                JSONArray f2 = k.f(jSONObject2, "oth");
                if (f2 != null) {
                    arrayList = new ArrayList(f2.size());
                    Iterator it = f2.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (next instanceof JSONObject) {
                            JSONObject jSONObject3 = (JSONObject) next;
                            try {
                                arrayList.add(new i.a(k.j(jSONObject3, "r"), k.j(jSONObject3, "dq"), k.j(jSONObject3, "t")));
                            } catch (IllegalArgumentException e3) {
                                throw new ParseException(e3.getMessage(), 0);
                            }
                        }
                    }
                }
            }
            try {
                i iVar = new i(j2, j3, j4, j5, j6, j7, j8, j9, arrayList, null, k.b(jSONObject), k.c(jSONObject), k.d(jSONObject), k.e(jSONObject), k.f(jSONObject), k.g(jSONObject), k.h(jSONObject), k.i(jSONObject), null);
                return iVar;
            } catch (IllegalArgumentException e4) {
                throw new ParseException(e4.getMessage(), 0);
            }
        } else {
            throw new ParseException("The key type \"kty\" must be RSA", 0);
        }
    }

    public abstract boolean c();

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("kty", this.f2018a.f2032e);
        e eVar = this.f2019b;
        if (eVar != null) {
            jSONObject.put("use", eVar.f2035c);
        }
        if (this.f2020c != null) {
            JSONArray jSONArray = new JSONArray();
            for (c a2 : this.f2020c) {
                jSONArray.add(a2.a());
            }
            jSONObject.put("key_ops", jSONArray);
        }
        a aVar = this.f2021d;
        if (aVar != null) {
            jSONObject.put("alg", aVar.f1977b);
        }
        String str = this.f2022e;
        if (str != null) {
            jSONObject.put("kid", str);
        }
        URI uri = this.f2023f;
        if (uri != null) {
            jSONObject.put("x5u", uri.toString());
        }
        Base64URL base64URL = this.g;
        if (base64URL != null) {
            jSONObject.put("x5t", base64URL.f2053a);
        }
        Base64URL base64URL2 = this.h;
        if (base64URL2 != null) {
            jSONObject.put("x5t#S256", base64URL2.f2053a);
        }
        if (this.i != null) {
            JSONArray jSONArray2 = new JSONArray();
            for (Base64 base64 : this.i) {
                jSONArray2.add(base64.f2053a);
            }
            jSONObject.put("x5c", jSONArray2);
        }
        return jSONObject;
    }

    public List<X509Certificate> e() {
        List<X509Certificate> list = this.j;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JWK)) {
            return false;
        }
        JWK jwk = (JWK) obj;
        if (!Objects.equals(this.f2018a, jwk.f2018a) || !Objects.equals(this.f2019b, jwk.f2019b) || !Objects.equals(this.f2020c, jwk.f2020c) || !Objects.equals(this.f2021d, jwk.f2021d) || !Objects.equals(this.f2022e, jwk.f2022e) || !Objects.equals(this.f2023f, jwk.f2023f) || !Objects.equals(this.g, jwk.g) || !Objects.equals(this.h, jwk.h) || !Objects.equals(this.i, jwk.i) || !Objects.equals(this.k, jwk.k)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f2018a, this.f2019b, this.f2020c, this.f2021d, this.f2022e, this.f2023f, this.g, this.h, this.i, this.k});
    }

    public String toJSONString() {
        return d().toString();
    }

    public String toString() {
        return d().toString();
    }
}
