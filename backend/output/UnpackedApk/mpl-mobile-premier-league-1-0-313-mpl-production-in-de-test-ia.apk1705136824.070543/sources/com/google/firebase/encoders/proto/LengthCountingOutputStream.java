package com.google.firebase.encoders.proto;

import java.io.OutputStream;

public final class LengthCountingOutputStream extends OutputStream {
    public long length = 0;

    public void write(int i) {
        this.length++;
    }

    public void write(byte[] bArr) {
        this.length += (long) bArr.length;
    }

    public void write(byte[] bArr, int i, int i2) {
        if (i >= 0 && i <= bArr.length && i2 >= 0) {
            int i3 = i + i2;
            if (i3 <= bArr.length && i3 >= 0) {
                this.length += (long) i2;
                return;
            }
        }
        throw new IndexOutOfBoundsException();
    }
}
