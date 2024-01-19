package com.cardinalcommerce.dependencies.internal.nimbusds.jose;

import com.cardinalcommerce.dependencies.internal.minidev.json.JSONArray;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.JWK;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.i;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class b implements Serializable {
    public static final Map<String, Object> f$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d = Collections.unmodifiableMap(new HashMap());

    /* renamed from: a  reason: collision with root package name */
    public final URI f1980a;
    public final a a$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d;

    /* renamed from: b  reason: collision with root package name */
    public final JWK f1981b;
    public final f b$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d;

    /* renamed from: c  reason: collision with root package name */
    public final URI f1982c;
    public final String c$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d;

    /* renamed from: d  reason: collision with root package name */
    public final Base64URL f1983d;
    public final Set<String> d$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d;

    /* renamed from: e  reason: collision with root package name */
    public final Base64URL f1984e;
    public final Map<String, Object> e$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d;

    /* renamed from: f  reason: collision with root package name */
    public final List<Base64> f1985f;
    public final String g;
    public final Base64URL g$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d;

    public b(a aVar, f fVar, String str, Set<String> set, URI uri, JWK jwk, URI uri2, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, String str2, Map<String, Object> map, Base64URL base64URL3) {
        if (aVar != null) {
            this.a$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d = aVar;
            this.b$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d = fVar;
            this.c$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d = str;
            List<Base64> list2 = null;
            this.d$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d = set != null ? Collections.unmodifiableSet(new HashSet(set)) : null;
            this.e$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d = map != null ? Collections.unmodifiableMap(new HashMap(map)) : f$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d;
            this.g$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d = base64URL3;
            this.f1980a = uri;
            this.f1981b = jwk;
            this.f1982c = uri2;
            this.f1983d = base64URL;
            this.f1984e = base64URL2;
            this.f1985f = list != null ? Collections.unmodifiableList(new ArrayList(list)) : list2;
            this.g = str2;
            return;
        }
        throw new IllegalArgumentException("The algorithm \"alg\" header parameter must not be null");
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject(this.e$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d);
        jSONObject.put("alg", this.a$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d.f1977b);
        f fVar = this.b$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d;
        if (fVar != null) {
            jSONObject.put("typ", fVar.f2005d);
        }
        String str = this.c$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d;
        if (str != null) {
            jSONObject.put("cty", str);
        }
        Set<String> set = this.d$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d;
        if (set != null && !set.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (String add : this.d$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d) {
                jSONArray.add(add);
            }
            jSONObject.put("crit", jSONArray);
        }
        URI uri = this.f1980a;
        if (uri != null) {
            jSONObject.put("jku", uri.toString());
        }
        JWK jwk = this.f1981b;
        if (jwk != null) {
            jSONObject.put("jwk", jwk.d());
        }
        URI uri2 = this.f1982c;
        if (uri2 != null) {
            jSONObject.put("x5u", uri2.toString());
        }
        Base64URL base64URL = this.f1983d;
        if (base64URL != null) {
            jSONObject.put("x5t", base64URL.f2053a);
        }
        Base64URL base64URL2 = this.f1984e;
        if (base64URL2 != null) {
            jSONObject.put("x5t#S256", base64URL2.f2053a);
        }
        List<Base64> list = this.f1985f;
        if (list != null && !list.isEmpty()) {
            jSONObject.put("x5c", this.f1985f);
        }
        String str2 = this.g;
        if (str2 != null) {
            jSONObject.put("kid", str2);
        }
        return jSONObject;
    }

    public Base64URL e() {
        Base64URL base64URL = this.g$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d;
        return base64URL == null ? Base64URL.a(b().toString().getBytes(i.f2055a)) : base64URL;
    }

    public String toString() {
        return b().toString();
    }
}
