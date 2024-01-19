package org.spongycastle.bcpg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class TrustPacket extends ContainedPacket {
    public TrustPacket(BCPGInputStream bCPGInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = bCPGInputStream.read();
            if (read >= 0) {
                byteArrayOutputStream.write(read);
            } else {
                byteArrayOutputStream.toByteArray();
                return;
            }
        }
    }
}
