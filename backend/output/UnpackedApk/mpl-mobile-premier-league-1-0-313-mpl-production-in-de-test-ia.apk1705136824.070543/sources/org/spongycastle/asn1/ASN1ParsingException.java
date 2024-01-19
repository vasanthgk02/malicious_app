package org.spongycastle.asn1;

public class ASN1ParsingException extends IllegalStateException {
    public Throwable cause;

    public ASN1ParsingException(String str) {
        super(str);
    }

    public Throwable getCause() {
        return this.cause;
    }

    public ASN1ParsingException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }
}
