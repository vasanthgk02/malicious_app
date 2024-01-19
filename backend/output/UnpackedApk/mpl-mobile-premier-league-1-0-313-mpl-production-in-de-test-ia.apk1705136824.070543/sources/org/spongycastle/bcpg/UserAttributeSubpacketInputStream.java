package org.spongycastle.bcpg;

import java.io.IOException;
import java.io.InputStream;

public class UserAttributeSubpacketInputStream extends InputStream {

    /* renamed from: in  reason: collision with root package name */
    public InputStream f6253in;

    public UserAttributeSubpacketInputStream(InputStream inputStream) {
        this.f6253in = inputStream;
    }

    public int available() throws IOException {
        return this.f6253in.available();
    }

    public int read() throws IOException {
        return this.f6253in.read();
    }
}
