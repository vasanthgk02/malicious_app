package org.spongycastle.bcpg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PublicKeyPacket extends ContainedPacket {
    public int algorithm;
    public BCPGKey key;
    public long time;
    public int validDays;
    public int version;

    public PublicKeyPacket(BCPGInputStream bCPGInputStream) throws IOException {
        this.version = bCPGInputStream.read();
        this.time = (((long) bCPGInputStream.read()) << 24) | ((long) (bCPGInputStream.read() << 16)) | ((long) (bCPGInputStream.read() << 8)) | ((long) bCPGInputStream.read());
        if (this.version <= 3) {
            this.validDays = (bCPGInputStream.read() << 8) | bCPGInputStream.read();
        }
        byte read = (byte) bCPGInputStream.read();
        this.algorithm = read;
        if (read == 1 || read == 2 || read == 3) {
            this.key = new RSAPublicBCPGKey(bCPGInputStream);
            return;
        }
        switch (read) {
            case 16:
            case 20:
                this.key = new ElGamalPublicBCPGKey(bCPGInputStream);
                return;
            case 17:
                this.key = new DSAPublicBCPGKey(bCPGInputStream);
                return;
            case 18:
                this.key = new ECDHPublicBCPGKey(bCPGInputStream);
                return;
            case 19:
                this.key = new ECDSAPublicBCPGKey(bCPGInputStream);
                return;
            default:
                throw new IOException("unknown PGP public key algorithm encountered");
        }
    }

    public byte[] getEncodedContents() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BCPGOutputStream bCPGOutputStream = new BCPGOutputStream(byteArrayOutputStream);
        bCPGOutputStream.write(this.version);
        bCPGOutputStream.write((byte) ((int) (this.time >> 24)));
        bCPGOutputStream.write((byte) ((int) (this.time >> 16)));
        bCPGOutputStream.write((byte) ((int) (this.time >> 8)));
        bCPGOutputStream.write((byte) ((int) this.time));
        if (this.version <= 3) {
            bCPGOutputStream.write((byte) (this.validDays >> 8));
            bCPGOutputStream.write((byte) this.validDays);
        }
        bCPGOutputStream.write(this.algorithm);
        ((BCPGObject) this.key).encode(bCPGOutputStream);
        bCPGOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}
