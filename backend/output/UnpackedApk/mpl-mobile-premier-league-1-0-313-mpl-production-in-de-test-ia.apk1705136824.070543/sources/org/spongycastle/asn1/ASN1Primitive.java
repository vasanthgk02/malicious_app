package org.spongycastle.asn1;

import java.io.IOException;

public abstract class ASN1Primitive extends ASN1Object {
    public static ASN1Primitive fromByteArray(byte[] bArr) throws IOException {
        ASN1InputStream aSN1InputStream = new ASN1InputStream(bArr);
        try {
            ASN1Primitive readObject = aSN1InputStream.readObject();
            if (aSN1InputStream.available() == 0) {
                return readObject;
            }
            throw new IOException("Extra data detected in stream");
        } catch (ClassCastException unused) {
            throw new IOException("cannot recognise object in stream");
        }
    }

    public abstract boolean asn1Equals(ASN1Primitive aSN1Primitive);

    public abstract void encode(ASN1OutputStream aSN1OutputStream) throws IOException;

    public abstract int encodedLength() throws IOException;

    public final boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ASN1Encodable) || !asn1Equals(((ASN1Encodable) obj).toASN1Primitive())) {
            z = false;
        }
        return z;
    }

    public abstract boolean isConstructed();

    public ASN1Primitive toASN1Primitive() {
        return this;
    }

    public ASN1Primitive toDERObject() {
        return this;
    }

    public ASN1Primitive toDLObject() {
        return this;
    }
}
