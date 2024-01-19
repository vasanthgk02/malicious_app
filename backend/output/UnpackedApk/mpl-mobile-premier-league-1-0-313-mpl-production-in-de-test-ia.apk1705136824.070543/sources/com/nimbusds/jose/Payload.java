package com.nimbusds.jose;

import com.nimbusds.jose.util.Base64;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.StandardCharset;
import java.io.Serializable;
import net.minidev.json.JSONObject;

public final class Payload implements Serializable {
    public static final long serialVersionUID = 1;
    public final Base64URL base64URL;
    public final byte[] bytes = null;
    public final JSONObject jsonObject = null;
    public final JWSObject jwsObject;
    public final String string = null;

    public enum Origin {
        JSON,
        STRING,
        BYTE_ARRAY,
        BASE64URL,
        JWS_OBJECT,
        SIGNED_JWT
    }

    public Payload(Base64URL base64URL2) {
        this.base64URL = base64URL2;
        this.jwsObject = null;
        Origin origin = Origin.BASE64URL;
    }

    public String toString() {
        String str = this.string;
        if (str != null) {
            return str;
        }
        JWSObject jWSObject = this.jwsObject;
        if (jWSObject == null) {
            JSONObject jSONObject = this.jsonObject;
            if (jSONObject != null) {
                return jSONObject.toString();
            }
            byte[] bArr = this.bytes;
            String str2 = null;
            if (bArr != null) {
                return new String(bArr, StandardCharset.UTF_8);
            }
            Base64URL base64URL2 = this.base64URL;
            if (base64URL2 != null) {
                str2 = new String(base64URL2.decode(), Base64.CHARSET);
            }
            return str2;
        } else if (jWSObject.getParsedString() != null) {
            return this.jwsObject.getParsedString();
        } else {
            JWSObject jWSObject2 = this.jwsObject;
            jWSObject2.ensureSignedOrVerifiedState();
            return String.valueOf(jWSObject2.signingInputString) + '.' + jWSObject2.signature.value;
        }
    }
}
