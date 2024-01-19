package org.spongycastle.bcpg;

import java.io.IOException;
import org.spongycastle.util.io.Streams;

public class SecretKeyPacket extends ContainedPacket {
    public int encAlgorithm;
    public byte[] iv;
    public PublicKeyPacket pubKeyPacket;
    public S2K s2k;
    public int s2kUsage;

    public SecretKeyPacket(BCPGInputStream bCPGInputStream) throws IOException {
        if (this instanceof SecretSubkeyPacket) {
            this.pubKeyPacket = new PublicSubkeyPacket(bCPGInputStream);
        } else {
            this.pubKeyPacket = new PublicKeyPacket(bCPGInputStream);
        }
        int read = bCPGInputStream.read();
        this.s2kUsage = read;
        if (read == 255 || read == 254) {
            this.encAlgorithm = bCPGInputStream.read();
            this.s2k = new S2K(bCPGInputStream);
        } else {
            this.encAlgorithm = read;
        }
        S2K s2k2 = this.s2k;
        if (!((s2k2 != null && s2k2.type == 101 && s2k2.protectionMode == 1) || this.s2kUsage == 0)) {
            if (this.encAlgorithm < 7) {
                this.iv = new byte[8];
            } else {
                this.iv = new byte[16];
            }
            byte[] bArr = this.iv;
            bCPGInputStream.readFully(bArr, 0, bArr.length);
        }
        Streams.readAll(bCPGInputStream);
    }
}
