package org.spongycastle.openpgp;

import java.io.IOException;
import org.spongycastle.bcpg.BCPGInputStream;
import org.spongycastle.bcpg.OnePassSignaturePacket;

public class PGPOnePassSignature {
    public PGPOnePassSignature(BCPGInputStream bCPGInputStream) throws IOException, PGPException {
        int i = ((OnePassSignaturePacket) bCPGInputStream.readPacket()).sigType;
    }
}
