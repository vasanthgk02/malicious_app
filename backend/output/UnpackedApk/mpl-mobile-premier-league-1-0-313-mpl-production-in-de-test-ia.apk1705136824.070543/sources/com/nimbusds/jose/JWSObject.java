package com.nimbusds.jose;

import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.StandardCharset;
import java.text.ParseException;

public class JWSObject extends JOSEObject {
    public static final long serialVersionUID = 1;
    public final JWSHeader header;
    public Base64URL signature;
    public final String signingInputString;
    public State state;

    public enum State {
        UNSIGNED,
        SIGNED,
        VERIFIED
    }

    public JWSObject(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3) throws ParseException {
        if (base64URL != null) {
            try {
                this.header = JWSHeader.parse(base64URL);
                if (base64URL2 != null) {
                    this.payload = new Payload(base64URL2);
                    this.signingInputString = String.valueOf(base64URL.value) + '.' + base64URL2.value;
                    if (base64URL3 != null) {
                        this.signature = base64URL3;
                        this.state = State.SIGNED;
                        this.parsedParts = new Base64URL[]{base64URL, base64URL2, base64URL3};
                        return;
                    }
                    throw new IllegalArgumentException("The third part must not be null");
                }
                throw new IllegalArgumentException("The second part must not be null");
            } catch (ParseException e2) {
                throw new ParseException("Invalid JWS header: " + e2.getMessage(), 0);
            }
        } else {
            throw new IllegalArgumentException("The first part must not be null");
        }
    }

    public final void ensureSignedOrVerifiedState() {
        State state2 = this.state;
        if (state2 != State.SIGNED && state2 != State.VERIFIED) {
            throw new IllegalStateException("The JWS object must be in a signed or verified state");
        }
    }

    public synchronized boolean verify(JWSVerifier jWSVerifier) throws JOSEException {
        boolean verify;
        ensureSignedOrVerifiedState();
        try {
            verify = ((RSASSAVerifier) jWSVerifier).verify(this.header, this.signingInputString.getBytes(StandardCharset.UTF_8), this.signature);
            if (verify) {
                this.state = State.VERIFIED;
            }
        } catch (JOSEException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new JOSEException(e3.getMessage(), e3);
        }
        return verify;
    }
}
