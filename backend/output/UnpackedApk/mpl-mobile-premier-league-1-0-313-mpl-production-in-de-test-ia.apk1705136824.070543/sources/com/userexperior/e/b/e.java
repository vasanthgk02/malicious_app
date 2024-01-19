package com.userexperior.e.b;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class e extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    public int f3959a;

    public e(InputStream inputStream) {
        super(inputStream);
        this.f3959a = 0;
    }

    public /* synthetic */ e(InputStream inputStream, byte b2) {
        this(inputStream);
    }

    public final int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.f3959a++;
        }
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.f3959a += read;
        }
        return read;
    }
}
