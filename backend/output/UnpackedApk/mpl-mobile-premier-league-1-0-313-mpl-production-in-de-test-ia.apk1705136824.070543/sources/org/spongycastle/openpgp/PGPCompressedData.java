package org.spongycastle.openpgp;

import java.io.IOException;
import org.spongycastle.bcpg.BCPGInputStream;
import org.spongycastle.bcpg.CompressedDataPacket;

public class PGPCompressedData {
    public PGPCompressedData(BCPGInputStream bCPGInputStream) throws IOException {
        CompressedDataPacket compressedDataPacket = (CompressedDataPacket) bCPGInputStream.readPacket();
    }
}
