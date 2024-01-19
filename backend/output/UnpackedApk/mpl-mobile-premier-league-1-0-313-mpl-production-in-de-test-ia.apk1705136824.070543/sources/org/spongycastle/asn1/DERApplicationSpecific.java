package org.spongycastle.asn1;

import java.io.IOException;

public class DERApplicationSpecific extends ASN1ApplicationSpecific {
    public DERApplicationSpecific(boolean z, int i, byte[] bArr) {
        super(z, i, bArr);
    }

    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(this.isConstructed ? 96 : 64, this.tag, this.octets);
    }
}
