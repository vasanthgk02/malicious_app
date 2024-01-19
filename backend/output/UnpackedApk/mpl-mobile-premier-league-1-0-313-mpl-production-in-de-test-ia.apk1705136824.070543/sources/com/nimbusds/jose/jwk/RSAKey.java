package com.nimbusds.jose.jwk;

import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.util.Base64;
import com.nimbusds.jose.util.Base64URL;
import java.io.Serializable;
import java.net.URI;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import sfs2x.client.requests.mmo.SetUserPositionRequest;

public final class RSAKey extends JWK {
    public static final long serialVersionUID = 1;

    /* renamed from: d  reason: collision with root package name */
    public final Base64URL f1334d;
    public final Base64URL dp;
    public final Base64URL dq;

    /* renamed from: e  reason: collision with root package name */
    public final Base64URL f1335e;
    public final Base64URL n;
    public final List<OtherPrimesInfo> oth;
    public final Base64URL p;
    public final Base64URL q;
    public final Base64URL qi;

    public static class OtherPrimesInfo implements Serializable {
        public static final long serialVersionUID = 1;

        /* renamed from: d  reason: collision with root package name */
        public final Base64URL f1336d;
        public final Base64URL r;
        public final Base64URL t;

        public OtherPrimesInfo(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3) {
            this.r = base64URL;
            this.f1336d = base64URL2;
            this.t = base64URL3;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public RSAKey(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4, Base64URL base64URL5, Base64URL base64URL6, Base64URL base64URL7, Base64URL base64URL8, List<OtherPrimesInfo> list, PrivateKey privateKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL9, Base64URL base64URL10, List<Base64> list2, KeyStore keyStore) {
        Base64URL base64URL11;
        // Base64URL base64URL12 = base64URL4;
        // Base64URL base64URL13 = base64URL5;
        // Base64URL base64URL14 = base64URL6;
        // Base64URL base64URL15 = base64URL7;
        // Base64URL base64URL16 = base64URL8;
        super(KeyType.RSA, keyUse, set, algorithm, str, uri, base64URL9, base64URL10, list2, null);
        this.n = base64URL;
        this.f1335e = base64URL2;
        this.f1334d = base64URL3;
        if (base64URL12 == null || base64URL13 == null || base64URL14 == null || base64URL15 == null) {
            base64URL11 = base64URL8;
        } else {
            base64URL11 = base64URL8;
            if (base64URL11 != null) {
                this.p = base64URL12;
                this.q = base64URL13;
                this.dp = base64URL14;
                this.dq = base64URL15;
                this.qi = base64URL11;
                if (list != null) {
                    this.oth = Collections.unmodifiableList(list);
                    return;
                } else {
                    this.oth = Collections.emptyList();
                    return;
                }
            }
        }
        if (base64URL12 == null && base64URL13 == null && base64URL14 == null && base64URL15 == null && base64URL11 == null && list == null) {
            this.p = null;
            this.q = null;
            this.dp = null;
            this.dq = null;
            this.qi = null;
            this.oth = Collections.emptyList();
        } else if (base64URL12 == null && base64URL13 == null && base64URL14 == null && base64URL15 == null && base64URL11 == null) {
            this.p = null;
            this.q = null;
            this.dp = null;
            this.dq = null;
            this.qi = null;
            this.oth = Collections.emptyList();
        } else if (base64URL12 == null) {
            throw new IllegalArgumentException("Incomplete second private (CRT) representation: The first prime factor must not be null");
        } else if (base64URL13 == null) {
            throw new IllegalArgumentException("Incomplete second private (CRT) representation: The second prime factor must not be null");
        } else if (base64URL14 == null) {
            throw new IllegalArgumentException("Incomplete second private (CRT) representation: The first factor CRT exponent must not be null");
        } else if (base64URL15 == null) {
            throw new IllegalArgumentException("Incomplete second private (CRT) representation: The second factor CRT exponent must not be null");
        } else {
            throw new IllegalArgumentException("Incomplete second private (CRT) representation: The first CRT coefficient must not be null");
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("n", this.n.value);
        jSONObject.put("e", this.f1335e.value);
        Base64URL base64URL = this.f1334d;
        if (base64URL != null) {
            jSONObject.put("d", base64URL.value);
        }
        Base64URL base64URL2 = this.p;
        if (base64URL2 != null) {
            jSONObject.put("p", base64URL2.value);
        }
        Base64URL base64URL3 = this.q;
        if (base64URL3 != null) {
            jSONObject.put(SetUserPositionRequest.KEY_PLUS_ITEM_LIST, base64URL3.value);
        }
        Base64URL base64URL4 = this.dp;
        if (base64URL4 != null) {
            jSONObject.put("dp", base64URL4.value);
        }
        Base64URL base64URL5 = this.dq;
        if (base64URL5 != null) {
            jSONObject.put("dq", base64URL5.value);
        }
        Base64URL base64URL6 = this.qi;
        if (base64URL6 != null) {
            jSONObject.put("qi", base64URL6.value);
        }
        List<OtherPrimesInfo> list = this.oth;
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (OtherPrimesInfo next : this.oth) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("r", next.r.value);
                jSONObject2.put("d", next.f1336d.value);
                jSONObject2.put("t", next.t.value);
                jSONArray.add(jSONObject2);
            }
            jSONObject.put("oth", jSONArray);
        }
        return jSONObject;
    }
}
