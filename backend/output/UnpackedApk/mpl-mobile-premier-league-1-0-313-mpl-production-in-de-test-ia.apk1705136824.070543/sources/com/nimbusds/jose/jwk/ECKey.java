package com.nimbusds.jose.jwk;

import com.google.android.material.resources.TextAppearanceConfig;
import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.util.Base64;
import com.nimbusds.jose.util.Base64URL;
import java.math.BigInteger;
import java.net.URI;
import java.security.KeyStore;
import java.security.spec.ECFieldFp;
import java.security.spec.EllipticCurve;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minidev.json.JSONObject;

public final class ECKey extends JWK {
    public static final Set<Curve> SUPPORTED_CURVES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Curve[]{Curve.P_256, Curve.P_384, Curve.P_521})));
    public static final long serialVersionUID = 1;
    public final Curve crv;

    /* renamed from: d  reason: collision with root package name */
    public final Base64URL f1332d;
    public final Base64URL x;
    public final Base64URL y;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ECKey(Curve curve, Base64URL base64URL, Base64URL base64URL2, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL3, Base64URL base64URL4, List<Base64> list, KeyStore keyStore) {
        // Curve curve2 = curve;
        super(KeyType.EC, keyUse, set, algorithm, str, uri, base64URL3, base64URL4, list, null);
        if (curve2 != null) {
            this.crv = curve2;
            this.x = base64URL;
            this.y = base64URL2;
            ensurePublicCoordinatesOnCurve(curve, base64URL, base64URL2);
            this.f1332d = null;
            return;
        }
        throw new IllegalArgumentException("The curve must not be null");
    }

    public static void ensurePublicCoordinatesOnCurve(Curve curve, Base64URL base64URL, Base64URL base64URL2) {
        if (SUPPORTED_CURVES.contains(curve)) {
            BigInteger bigInteger = new BigInteger(1, base64URL.decode());
            BigInteger bigInteger2 = new BigInteger(1, base64URL2.decode());
            EllipticCurve curve2 = ECParameterTable.get(curve).getCurve();
            BigInteger a2 = curve2.getA();
            BigInteger b2 = curve2.getB();
            BigInteger p = ((ECFieldFp) curve2.getField()).getP();
            if (!bigInteger2.pow(2).mod(p).equals(bigInteger.pow(3).add(a2.multiply(bigInteger)).add(b2).mod(p))) {
                throw new IllegalArgumentException("Invalid EC JWK: The 'x' and 'y' public coordinates are not on the " + curve + " curve");
            }
            return;
        }
        throw new IllegalArgumentException("Unknown / unsupported curve: " + curve);
    }

    public static ECKey parse(JSONObject jSONObject) throws ParseException {
        JSONObject jSONObject2 = jSONObject;
        Curve parse = Curve.parse(TextAppearanceConfig.getString(jSONObject2, "crv"));
        Base64URL base64URL = new Base64URL(TextAppearanceConfig.getString(jSONObject2, "x"));
        Base64URL base64URL2 = new Base64URL(TextAppearanceConfig.getString(jSONObject2, "y"));
        if (TextAppearanceConfig.parseKeyType(jSONObject) == KeyType.EC) {
            Base64URL base64URL3 = null;
            if (jSONObject2.get("d") != null) {
                base64URL3 = new Base64URL(TextAppearanceConfig.getString(jSONObject2, "d"));
            }
            Base64URL base64URL4 = base64URL3;
            if (base64URL4 == null) {
                try {
                    ECKey eCKey = new ECKey(parse, base64URL, base64URL2, TextAppearanceConfig.parseKeyUse(jSONObject), TextAppearanceConfig.parseKeyOperations(jSONObject), TextAppearanceConfig.parseAlgorithm(jSONObject), TextAppearanceConfig.parseKeyID(jSONObject), TextAppearanceConfig.parseX509CertURL(jSONObject), TextAppearanceConfig.parseX509CertThumbprint(jSONObject), TextAppearanceConfig.parseX509CertSHA256Thumbprint(jSONObject), TextAppearanceConfig.parseX509CertChain(jSONObject), null);
                    return eCKey;
                } catch (IllegalArgumentException e2) {
                    throw new ParseException(e2.getMessage(), 0);
                }
            } else {
                ECKey eCKey2 = new ECKey(parse, base64URL, base64URL2, base64URL4, TextAppearanceConfig.parseKeyUse(jSONObject), TextAppearanceConfig.parseKeyOperations(jSONObject), TextAppearanceConfig.parseAlgorithm(jSONObject), TextAppearanceConfig.parseKeyID(jSONObject), TextAppearanceConfig.parseX509CertURL(jSONObject), TextAppearanceConfig.parseX509CertThumbprint(jSONObject), TextAppearanceConfig.parseX509CertSHA256Thumbprint(jSONObject), TextAppearanceConfig.parseX509CertChain(jSONObject), null);
                return eCKey2;
            }
        } else {
            throw new ParseException("The key type \"kty\" must be EC", 0);
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("crv", this.crv.name);
        jSONObject.put("x", this.x.value);
        jSONObject.put("y", this.y.value);
        Base64URL base64URL = this.f1332d;
        if (base64URL != null) {
            jSONObject.put("d", base64URL.value);
        }
        return jSONObject;
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ECKey(Curve curve, Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL4, Base64URL base64URL5, List<Base64> list, KeyStore keyStore) {
        // Curve curve2 = curve;
        // Base64URL base64URL6 = base64URL3;
        super(KeyType.EC, keyUse, set, algorithm, str, uri, base64URL4, base64URL5, list, null);
        if (curve2 != null) {
            this.crv = curve2;
            this.x = base64URL;
            this.y = base64URL2;
            ensurePublicCoordinatesOnCurve(curve, base64URL, base64URL2);
            if (base64URL6 != null) {
                this.f1332d = base64URL6;
                return;
            }
            throw new IllegalArgumentException("The 'd' coordinate must not be null");
        }
        throw new IllegalArgumentException("The curve must not be null");
    }
}
