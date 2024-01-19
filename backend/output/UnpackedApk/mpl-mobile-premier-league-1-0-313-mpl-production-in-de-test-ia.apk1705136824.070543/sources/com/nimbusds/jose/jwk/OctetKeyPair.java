package com.nimbusds.jose.jwk;

import com.google.android.material.resources.TextAppearanceConfig;
import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.util.Base64;
import com.nimbusds.jose.util.Base64URL;
import java.net.URI;
import java.security.KeyStore;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minidev.json.JSONObject;

public class OctetKeyPair extends JWK {
    public static final Set<Curve> SUPPORTED_CURVES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Curve[]{Curve.Ed25519, Curve.Ed448, Curve.X25519, Curve.X448})));
    public static final long serialVersionUID = 1;
    public final Curve crv;

    /* renamed from: d  reason: collision with root package name */
    public final Base64URL f1333d;
    public final Base64URL x;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public OctetKeyPair(Curve curve, Base64URL base64URL, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL2, Base64URL base64URL3, List<Base64> list, KeyStore keyStore) {
        // Curve curve2 = curve;
        super(KeyType.OKP, keyUse, set, algorithm, str, uri, base64URL2, base64URL3, list, null);
        if (curve2 == null) {
            throw new IllegalArgumentException("The curve must not be null");
        } else if (SUPPORTED_CURVES.contains(curve)) {
            this.crv = curve2;
            this.x = base64URL;
            this.f1333d = null;
        } else {
            throw new IllegalArgumentException("Unknown / unsupported curve: " + curve);
        }
    }

    public static OctetKeyPair parse(JSONObject jSONObject) throws ParseException {
        Curve parse = Curve.parse(TextAppearanceConfig.getString(jSONObject, "crv"));
        Base64URL base64URL = new Base64URL(TextAppearanceConfig.getString(jSONObject, "x"));
        if (TextAppearanceConfig.parseKeyType(jSONObject) == KeyType.OKP) {
            Base64URL base64URL2 = null;
            if (jSONObject.get("d") != null) {
                base64URL2 = new Base64URL(TextAppearanceConfig.getString(jSONObject, "d"));
            }
            Base64URL base64URL3 = base64URL2;
            if (base64URL3 == null) {
                try {
                    OctetKeyPair octetKeyPair = new OctetKeyPair(parse, base64URL, TextAppearanceConfig.parseKeyUse(jSONObject), TextAppearanceConfig.parseKeyOperations(jSONObject), TextAppearanceConfig.parseAlgorithm(jSONObject), TextAppearanceConfig.parseKeyID(jSONObject), TextAppearanceConfig.parseX509CertURL(jSONObject), TextAppearanceConfig.parseX509CertThumbprint(jSONObject), TextAppearanceConfig.parseX509CertSHA256Thumbprint(jSONObject), TextAppearanceConfig.parseX509CertChain(jSONObject), null);
                    return octetKeyPair;
                } catch (IllegalArgumentException e2) {
                    throw new ParseException(e2.getMessage(), 0);
                }
            } else {
                OctetKeyPair octetKeyPair2 = new OctetKeyPair(parse, base64URL, base64URL3, TextAppearanceConfig.parseKeyUse(jSONObject), TextAppearanceConfig.parseKeyOperations(jSONObject), TextAppearanceConfig.parseAlgorithm(jSONObject), TextAppearanceConfig.parseKeyID(jSONObject), TextAppearanceConfig.parseX509CertURL(jSONObject), TextAppearanceConfig.parseX509CertThumbprint(jSONObject), TextAppearanceConfig.parseX509CertSHA256Thumbprint(jSONObject), TextAppearanceConfig.parseX509CertChain(jSONObject), null);
                return octetKeyPair2;
            }
        } else {
            throw new ParseException("The key type \"kty\" must be OKP", 0);
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("crv", this.crv.name);
        jSONObject.put("x", this.x.value);
        Base64URL base64URL = this.f1333d;
        if (base64URL != null) {
            jSONObject.put("d", base64URL.value);
        }
        return jSONObject;
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public OctetKeyPair(Curve curve, Base64URL base64URL, Base64URL base64URL2, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL3, Base64URL base64URL4, List<Base64> list, KeyStore keyStore) {
        // Curve curve2 = curve;
        // Base64URL base64URL5 = base64URL2;
        super(KeyType.OKP, keyUse, set, algorithm, str, uri, base64URL3, base64URL4, list, null);
        if (curve2 == null) {
            throw new IllegalArgumentException("The curve must not be null");
        } else if (SUPPORTED_CURVES.contains(curve)) {
            this.crv = curve2;
            this.x = base64URL;
            if (base64URL5 != null) {
                this.f1333d = base64URL5;
                return;
            }
            throw new IllegalArgumentException("The 'd' parameter must not be null");
        } else {
            throw new IllegalArgumentException("Unknown / unsupported curve: " + curve);
        }
    }
}
