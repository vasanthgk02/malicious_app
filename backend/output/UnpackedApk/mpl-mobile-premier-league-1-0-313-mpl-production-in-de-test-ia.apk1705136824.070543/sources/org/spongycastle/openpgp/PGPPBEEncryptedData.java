package org.spongycastle.openpgp;

import org.spongycastle.bcpg.InputStreamPacket;
import org.spongycastle.bcpg.SymmetricKeyEncSessionPacket;

public class PGPPBEEncryptedData extends PGPEncryptedData {
    public PGPPBEEncryptedData(SymmetricKeyEncSessionPacket symmetricKeyEncSessionPacket, InputStreamPacket inputStreamPacket) {
        super(inputStreamPacket);
    }
}
