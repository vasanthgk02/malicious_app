package sfs2x.client.util;

import com.smartfoxserver.bitswarm.util.ByteUtils;

public class CryptoKey {
    public static final int SIZE = 16;
    public byte[] initVector = new byte[16];
    public byte[] secretKey;

    public CryptoKey(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        this.secretKey = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        System.arraycopy(bArr, 16, this.initVector, 0, 16);
    }

    public byte[] getInitVector() {
        return this.initVector;
    }

    public byte[] getSecretKey() {
        return this.secretKey;
    }

    public String toString() {
        return "CryptoKey: " + ByteUtils.fullHexDump(this.secretKey) + "\nIV: " + ByteUtils.fullHexDump(this.initVector);
    }
}
