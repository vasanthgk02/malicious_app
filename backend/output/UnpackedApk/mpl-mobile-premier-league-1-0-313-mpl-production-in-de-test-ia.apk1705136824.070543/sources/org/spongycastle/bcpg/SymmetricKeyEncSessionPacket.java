package org.spongycastle.bcpg;

import java.io.DataInputStream;
import java.io.IOException;
import org.spongycastle.util.io.Streams;

public class SymmetricKeyEncSessionPacket extends ContainedPacket {
    public SymmetricKeyEncSessionPacket(BCPGInputStream bCPGInputStream) throws IOException {
        bCPGInputStream.read();
        bCPGInputStream.read();
        DataInputStream dataInputStream = new DataInputStream(bCPGInputStream);
        int read = dataInputStream.read();
        dataInputStream.read();
        if (read == 101) {
            dataInputStream.read();
            dataInputStream.read();
            dataInputStream.read();
            dataInputStream.read();
        } else if (read != 0) {
            dataInputStream.readFully(new byte[8], 0, 8);
            if (read == 3) {
                dataInputStream.read();
            }
        }
        Streams.readAll(bCPGInputStream);
    }
}
