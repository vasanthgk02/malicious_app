package org.spongycastle.openpgp;

import java.io.IOException;
import java.util.Date;
import org.spongycastle.bcpg.BCPGInputStream;
import org.spongycastle.bcpg.LiteralDataPacket;

public class PGPLiteralData {
    static {
        new Date(0);
    }

    public PGPLiteralData(BCPGInputStream bCPGInputStream) throws IOException {
        LiteralDataPacket literalDataPacket = (LiteralDataPacket) bCPGInputStream.readPacket();
    }
}
