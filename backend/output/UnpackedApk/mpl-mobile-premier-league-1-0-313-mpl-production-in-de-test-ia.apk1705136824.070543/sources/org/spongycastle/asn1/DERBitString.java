package org.spongycastle.asn1;

import java.io.IOException;

public class DERBitString extends ASN1BitString {
    public DERBitString(byte[] bArr) {
        super(bArr, 0);
    }

    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        byte[] derForm = ASN1BitString.derForm(this.data, this.padBits);
        int length = derForm.length + 1;
        byte[] bArr = new byte[length];
        bArr[0] = (byte) this.padBits;
        System.arraycopy(derForm, 0, bArr, 1, length - 1);
        aSN1OutputStream.writeEncoded(3, bArr);
    }

    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.data.length + 1) + 1 + this.data.length + 1;
    }

    public boolean isConstructed() {
        return false;
    }

    public DERBitString(byte[] bArr, int i) {
        super(bArr, i);
    }
}
