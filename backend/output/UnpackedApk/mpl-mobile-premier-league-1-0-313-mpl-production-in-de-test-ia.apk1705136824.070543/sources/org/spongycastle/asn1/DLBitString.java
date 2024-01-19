package org.spongycastle.asn1;

import java.io.IOException;

public class DLBitString extends ASN1BitString {
    public DLBitString(byte[] bArr, int i) {
        super(bArr, i);
    }

    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        byte[] bArr = this.data;
        int length = bArr.length + 1;
        byte[] bArr2 = new byte[length];
        bArr2[0] = (byte) this.padBits;
        System.arraycopy(bArr, 0, bArr2, 1, length - 1);
        aSN1OutputStream.writeEncoded(3, bArr2);
    }

    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.data.length + 1) + 1 + this.data.length + 1;
    }

    public boolean isConstructed() {
        return false;
    }
}
