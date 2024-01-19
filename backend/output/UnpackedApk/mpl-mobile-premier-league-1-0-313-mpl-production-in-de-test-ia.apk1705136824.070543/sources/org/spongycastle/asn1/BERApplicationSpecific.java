package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class BERApplicationSpecific extends ASN1ApplicationSpecific {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public BERApplicationSpecific(int i, ASN1EncodableVector aSN1EncodableVector) {
        // ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // int i2 = 0;
        while (i2 != aSN1EncodableVector.size()) {
            try {
                // byteArrayOutputStream.write(((ASN1Object) aSN1EncodableVector.get(i2)).getEncoded("BER"));
                // i2++;
            } catch (IOException e2) {
                // throw new ASN1ParsingException("malformed object: " + e2, e2);
            }
        }
        super(true, i, byteArrayOutputStream.toByteArray());
    }

    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeTag(this.isConstructed ? 96 : 64, this.tag);
        aSN1OutputStream.write(128);
        aSN1OutputStream.os.write(this.octets);
        aSN1OutputStream.write(0);
        aSN1OutputStream.write(0);
    }
}
