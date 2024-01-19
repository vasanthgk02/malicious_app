package org.spongycastle.bcpg;

import java.io.IOException;

public class ECDHPublicBCPGKey extends ECPublicBCPGKey {
    public byte hashFunctionId;
    public byte reserved;
    public byte symAlgorithmId;

    public ECDHPublicBCPGKey(BCPGInputStream bCPGInputStream) throws IOException {
        super(bCPGInputStream);
        int read = bCPGInputStream.read();
        byte[] bArr = new byte[read];
        if (read == 3) {
            bCPGInputStream.readFully(bArr);
            this.reserved = bArr[0];
            byte b2 = bArr[1];
            this.hashFunctionId = b2;
            byte b3 = bArr[2];
            this.symAlgorithmId = b3;
            switch (b2) {
                case 8:
                case 9:
                case 10:
                    if (b3 != 7 && b3 != 8 && b3 != 9) {
                        throw new IllegalStateException("Symmetric key algorithm must be AES-128 or stronger.");
                    }
                    return;
                default:
                    throw new IllegalStateException("Hash algorithm must be SHA-256 or stronger.");
            }
        } else {
            throw new IllegalStateException("kdf parameters size of 3 expected.");
        }
    }

    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        super.encode(bCPGOutputStream);
        bCPGOutputStream.write(3);
        bCPGOutputStream.write(this.reserved);
        bCPGOutputStream.write(this.hashFunctionId);
        bCPGOutputStream.write(this.symAlgorithmId);
    }
}
