package com.nimbusds.jwt;

import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.util.Base64URL;
import java.io.Serializable;
import java.text.ParseException;

public class SignedJWT extends JWSObject implements Serializable {
    public static final long serialVersionUID = 1;

    public SignedJWT(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3) throws ParseException {
        super(base64URL, base64URL2, base64URL3);
    }

    public static SignedJWT parse(String str) throws ParseException {
        Base64URL[] base64URLArr;
        String trim = str.trim();
        int indexOf = trim.indexOf(".");
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = trim.indexOf(".", i);
            if (indexOf2 != -1) {
                int i2 = indexOf2 + 1;
                int indexOf3 = trim.indexOf(".", i2);
                if (indexOf3 == -1) {
                    base64URLArr = new Base64URL[]{new Base64URL(trim.substring(0, indexOf)), new Base64URL(trim.substring(i, indexOf2)), new Base64URL(trim.substring(i2))};
                } else {
                    int i3 = indexOf3 + 1;
                    int indexOf4 = trim.indexOf(".", i3);
                    if (indexOf4 == -1) {
                        throw new ParseException("Invalid serialized JWE object: Missing fourth delimiter", 0);
                    } else if (indexOf4 == -1 || trim.indexOf(".", indexOf4 + 1) == -1) {
                        base64URLArr = new Base64URL[]{new Base64URL(trim.substring(0, indexOf)), new Base64URL(trim.substring(i, indexOf2)), new Base64URL(trim.substring(i2, indexOf3)), new Base64URL(trim.substring(i3, indexOf4)), new Base64URL(trim.substring(indexOf4 + 1))};
                    } else {
                        throw new ParseException("Invalid serialized unsecured/JWS/JWE object: Too many part delimiters", 0);
                    }
                }
                if (base64URLArr.length == 3) {
                    return new SignedJWT(base64URLArr[0], base64URLArr[1], base64URLArr[2]);
                }
                throw new ParseException("Unexpected number of Base64URL parts, must be three", 0);
            }
            throw new ParseException("Invalid serialized unsecured/JWS/JWE object: Missing second delimiter", 0);
        }
        throw new ParseException("Invalid serialized unsecured/JWS/JWE object: Missing part delimiters", 0);
    }
}
