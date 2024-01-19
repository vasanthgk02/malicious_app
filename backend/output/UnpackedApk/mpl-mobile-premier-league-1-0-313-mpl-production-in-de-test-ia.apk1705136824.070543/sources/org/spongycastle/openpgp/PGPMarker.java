package org.spongycastle.openpgp;

import java.io.IOException;
import org.spongycastle.bcpg.BCPGInputStream;
import org.spongycastle.bcpg.MarkerPacket;

public class PGPMarker {
    public PGPMarker(BCPGInputStream bCPGInputStream) throws IOException {
        MarkerPacket markerPacket = (MarkerPacket) bCPGInputStream.readPacket();
    }
}
