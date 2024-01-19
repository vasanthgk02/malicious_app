package org.spongycastle.bcpg;

import java.io.IOException;
import org.spongycastle.util.io.Streams;

public class PublicKeyEncSessionPacket extends ContainedPacket {
    public int algorithm;
    public byte[][] data;
    public long keyID;

    public PublicKeyEncSessionPacket(BCPGInputStream bCPGInputStream) throws IOException {
        bCPGInputStream.read();
        long read = this.keyID | (((long) bCPGInputStream.read()) << 56);
        this.keyID = read;
        long read2 = read | (((long) bCPGInputStream.read()) << 48);
        this.keyID = read2;
        long read3 = read2 | (((long) bCPGInputStream.read()) << 40);
        this.keyID = read3;
        long read4 = read3 | (((long) bCPGInputStream.read()) << 32);
        this.keyID = read4;
        long read5 = read4 | (((long) bCPGInputStream.read()) << 24);
        this.keyID = read5;
        long read6 = read5 | (((long) bCPGInputStream.read()) << 16);
        this.keyID = read6;
        long read7 = read6 | (((long) bCPGInputStream.read()) << 8);
        this.keyID = read7;
        this.keyID = read7 | ((long) bCPGInputStream.read());
        int read8 = bCPGInputStream.read();
        this.algorithm = read8;
        if (read8 == 1 || read8 == 2) {
            byte[][] bArr = new byte[1][];
            this.data = bArr;
            bArr[0] = new MPInteger(bCPGInputStream).getEncoded();
            return;
        }
        if (read8 != 16) {
            if (read8 == 18) {
                byte[][] bArr2 = new byte[1][];
                this.data = bArr2;
                bArr2[0] = Streams.readAll(bCPGInputStream);
                return;
            } else if (read8 != 20) {
                throw new IOException("unknown PGP public key algorithm encountered");
            }
        }
        byte[][] bArr3 = new byte[2][];
        this.data = bArr3;
        bArr3[0] = new MPInteger(bCPGInputStream).getEncoded();
        this.data[1] = new MPInteger(bCPGInputStream).getEncoded();
    }
}
