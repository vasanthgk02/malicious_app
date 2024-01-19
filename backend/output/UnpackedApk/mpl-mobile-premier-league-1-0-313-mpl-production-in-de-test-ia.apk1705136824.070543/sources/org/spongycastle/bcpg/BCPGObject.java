package org.spongycastle.bcpg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class BCPGObject {
    public abstract void encode(BCPGOutputStream bCPGOutputStream) throws IOException;

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BCPGOutputStream bCPGOutputStream = new BCPGOutputStream(byteArrayOutputStream);
        encode(bCPGOutputStream);
        bCPGOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}
