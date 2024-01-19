package org.spongycastle.bcpg;

import java.io.IOException;

public class OnePassSignaturePacket extends ContainedPacket {
    public long keyID;
    public int sigType;

    public OnePassSignaturePacket(BCPGInputStream bCPGInputStream) throws IOException {
        bCPGInputStream.read();
        this.sigType = bCPGInputStream.read();
        bCPGInputStream.read();
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
        bCPGInputStream.read();
    }
}
