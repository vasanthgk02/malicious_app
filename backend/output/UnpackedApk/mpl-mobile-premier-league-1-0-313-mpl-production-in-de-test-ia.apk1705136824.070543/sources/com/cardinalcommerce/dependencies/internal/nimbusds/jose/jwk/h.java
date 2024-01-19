package com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk;

import com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.a;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.userexperior.utilities.k;
import java.net.URI;
import java.security.KeyStore;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class h extends JWK {

    /* renamed from: a  reason: collision with root package name */
    public final Base64URL f2043a;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public h(Base64URL base64URL, e eVar, Set<c> set, a aVar, String str, URI uri, Base64URL base64URL2, Base64URL base64URL3, List<Base64> list, KeyStore keyStore) {
        // Base64URL base64URL4 = base64URL;
        super(d.f2030c, eVar, set, aVar, str, uri, base64URL2, base64URL3, list, null);
        if (base64URL4 != null) {
            this.f2043a = base64URL4;
            return;
        }
        throw new IllegalArgumentException("The key value must not be null");
    }

    public boolean c() {
        return true;
    }

    public JSONObject d() {
        JSONObject d2 = super.d();
        d2.put(k.f4287a, this.f2043a.f2053a);
        return d2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof h) && super.equals(obj)) {
            return Objects.equals(this.f2043a, ((h) obj).f2043a);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.f2043a});
    }
}
