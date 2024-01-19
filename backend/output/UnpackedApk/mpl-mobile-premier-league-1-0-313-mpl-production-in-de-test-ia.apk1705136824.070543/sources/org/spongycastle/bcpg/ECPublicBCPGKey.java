package org.spongycastle.bcpg;

import java.io.IOException;
import java.math.BigInteger;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;

public abstract class ECPublicBCPGKey extends BCPGObject implements BCPGKey {
    public ASN1ObjectIdentifier oid;
    public BigInteger point;

    public ECPublicBCPGKey(BCPGInputStream bCPGInputStream) throws IOException {
        int read = bCPGInputStream.read();
        if (read == 0 || read == 255) {
            throw new IOException("future extensions not yet implemented.");
        }
        int i = read + 2;
        byte[] bArr = new byte[i];
        bCPGInputStream.readFully(bArr, 2, i - 2);
        bArr[0] = 6;
        bArr[1] = (byte) read;
        this.oid = ASN1ObjectIdentifier.getInstance(ASN1Primitive.fromByteArray(bArr));
        byte[] bArr2 = new byte[((((bCPGInputStream.read() << 8) | bCPGInputStream.read()) + 7) / 8)];
        bCPGInputStream.readFully(bArr2);
        this.point = new BigInteger(1, bArr2);
    }

    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        byte[] encoded = this.oid.getEncoded();
        bCPGOutputStream.write(encoded, 1, encoded.length - 1);
        bCPGOutputStream.writeObject(new MPInteger(this.point));
    }

    public byte[] getEncoded() {
        try {
            return super.getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }
}
