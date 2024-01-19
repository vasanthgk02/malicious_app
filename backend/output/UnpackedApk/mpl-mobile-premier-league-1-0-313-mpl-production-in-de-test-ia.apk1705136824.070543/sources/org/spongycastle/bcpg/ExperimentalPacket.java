package org.spongycastle.bcpg;

import java.io.IOException;
import org.spongycastle.util.io.Streams;

public class ExperimentalPacket extends ContainedPacket {
    public ExperimentalPacket(int i, BCPGInputStream bCPGInputStream) throws IOException {
        Streams.readAll(bCPGInputStream);
    }
}
