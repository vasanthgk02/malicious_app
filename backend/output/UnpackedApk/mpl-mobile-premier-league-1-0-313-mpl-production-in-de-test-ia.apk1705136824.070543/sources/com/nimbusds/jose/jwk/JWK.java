package com.nimbusds.jose.jwk;

import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.util.Base64;
import com.nimbusds.jose.util.Base64URL;
import java.io.Serializable;
import java.net.URI;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import net.minidev.json.JSONAware;
import net.minidev.json.JSONObject;

public abstract class JWK implements JSONAware, Serializable {
    public static final long serialVersionUID = 1;
    public final Algorithm alg;
    public final String kid;
    public final KeyType kty;
    public final Set<KeyOperation> ops;
    public final KeyUse use;
    public final List<Base64> x5c;
    @Deprecated
    public final Base64URL x5t;
    public Base64URL x5t256;
    public final URI x5u;

    public JWK(KeyType keyType, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, KeyStore keyStore) {
        if (keyType != null) {
            this.kty = keyType;
            if (KeyUseAndOpsConsistency.areConsistent(keyUse, set)) {
                this.use = keyUse;
                this.ops = set;
                this.alg = algorithm;
                this.kid = str;
                this.x5u = uri;
                this.x5t = base64URL;
                this.x5t256 = base64URL2;
                this.x5c = list;
                return;
            }
            throw new IllegalArgumentException("The key use \"use\" and key options \"key_opts\" parameters are not consistent, see RFC 7517, section 4.3");
        }
        throw new IllegalArgumentException("The key type \"kty\" parameter must not be null");
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("kty", this.kty.value);
        KeyUse keyUse = this.use;
        if (keyUse != null) {
            jSONObject.put("use", keyUse.identifier());
        }
        if (this.ops != null) {
            ArrayList arrayList = new ArrayList(this.ops.size());
            for (KeyOperation identifier : this.ops) {
                arrayList.add(identifier.identifier());
            }
            jSONObject.put("key_ops", arrayList);
        }
        Algorithm algorithm = this.alg;
        if (algorithm != null) {
            jSONObject.put("alg", algorithm.name);
        }
        String str = this.kid;
        if (str != null) {
            jSONObject.put("kid", str);
        }
        URI uri = this.x5u;
        if (uri != null) {
            jSONObject.put("x5u", uri.toString());
        }
        Base64URL base64URL = this.x5t;
        if (base64URL != null) {
            jSONObject.put("x5t", base64URL.value);
        }
        Base64URL base64URL2 = this.x5t256;
        if (base64URL2 != null) {
            jSONObject.put("x5t#S256", base64URL2.value);
        }
        List<Base64> list = this.x5c;
        if (list != null) {
            jSONObject.put("x5c", list);
        }
        return jSONObject;
    }

    public String toJSONString() {
        return toJSONObject().toString();
    }

    public String toString() {
        return toJSONObject().toString();
    }
}
