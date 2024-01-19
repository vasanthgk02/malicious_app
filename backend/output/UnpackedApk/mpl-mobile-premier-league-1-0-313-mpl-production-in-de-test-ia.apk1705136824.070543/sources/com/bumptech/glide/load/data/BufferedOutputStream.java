package com.bumptech.glide.load.data;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.OutputStream;

public final class BufferedOutputStream extends OutputStream {
    public ArrayPool arrayPool;
    public byte[] buffer;
    public int index;
    public final OutputStream out;

    public BufferedOutputStream(OutputStream outputStream, ArrayPool arrayPool2) {
        this.out = outputStream;
        this.arrayPool = arrayPool2;
        this.buffer = (byte[]) arrayPool2.get(65536, byte[].class);
    }

    /* JADX INFO: finally extract failed */
    public void close() throws IOException {
        try {
            flush();
            this.out.close();
            byte[] bArr = this.buffer;
            if (bArr != null) {
                this.arrayPool.put(bArr);
                this.buffer = null;
            }
        } catch (Throwable th) {
            this.out.close();
            throw th;
        }
    }

    public void flush() throws IOException {
        int i = this.index;
        if (i > 0) {
            this.out.write(this.buffer, 0, i);
            this.index = 0;
        }
        this.out.flush();
    }

    public void write(int i) throws IOException {
        byte[] bArr = this.buffer;
        int i2 = this.index;
        int i3 = i2 + 1;
        this.index = i3;
        bArr[i2] = (byte) i;
        if (i3 == bArr.length && i3 > 0) {
            this.out.write(bArr, 0, i3);
            this.index = 0;
        }
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            if (this.index != 0 || i4 < this.buffer.length) {
                int min = Math.min(i4, this.buffer.length - this.index);
                System.arraycopy(bArr, i5, this.buffer, this.index, min);
                int i6 = this.index + min;
                this.index = i6;
                i3 += min;
                byte[] bArr2 = this.buffer;
                if (i6 == bArr2.length && i6 > 0) {
                    this.out.write(bArr2, 0, i6);
                    this.index = 0;
                    continue;
                }
            } else {
                this.out.write(bArr, i5, i4);
                return;
            }
        } while (i3 < i2);
    }
}
