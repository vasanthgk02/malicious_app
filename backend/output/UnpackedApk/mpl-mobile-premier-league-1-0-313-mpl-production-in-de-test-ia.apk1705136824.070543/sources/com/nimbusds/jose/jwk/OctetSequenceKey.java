package com.nimbusds.jose.jwk;

import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.util.Base64;
import com.nimbusds.jose.util.Base64URL;
import com.userexperior.utilities.k;
import java.net.URI;
import java.security.KeyStore;
import java.util.List;
import java.util.Set;
import net.minidev.json.JSONObject;

public final class OctetSequenceKey extends JWK {
    public static final long serialVersionUID = 1;
    public final Base64URL k;

    public OctetSequenceKey(Base64URL base64URL, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL2, Base64URL base64URL3, List<Base64> list, KeyStore keyStore) {
        super(KeyType.OCT, keyUse, set, algorithm, str, uri, base64URL2, base64URL3, list, null);
        this.k = base64URL;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put(k.f4287a, this.k.value);
        return jSONObject;
    }
}
