package com.nimbusds.jose;

import com.nimbusds.jose.util.Base64URL;
import java.io.Serializable;

public abstract class JOSEObject implements Serializable {
    public static final long serialVersionUID = 1;
    public Base64URL[] parsedParts = null;
    public Payload payload = null;

    public String getParsedString() {
        if (this.parsedParts == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Base64URL base64URL : this.parsedParts) {
            if (sb.length() > 0) {
                sb.append('.');
            }
            if (base64URL != null) {
                sb.append(base64URL.value);
            }
        }
        return sb.toString();
    }
}
