package com.bumptech.glide.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class StrictLineReader implements Closeable {
    public byte[] buf;
    public final Charset charset;
    public int end;

    /* renamed from: in  reason: collision with root package name */
    public final InputStream f1838in;
    public int pos;

    public StrictLineReader(InputStream inputStream, Charset charset2) {
        if (charset2 == null) {
            throw null;
        } else if (charset2.equals(Util.US_ASCII)) {
            this.f1838in = inputStream;
            this.charset = charset2;
            this.buf = new byte[8192];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() throws IOException {
        synchronized (this.f1838in) {
            if (this.buf != null) {
                this.buf = null;
                this.f1838in.close();
            }
        }
    }

    public final void fillBuf() throws IOException {
        InputStream inputStream = this.f1838in;
        byte[] bArr = this.buf;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.pos = 0;
            this.end = read;
            return;
        }
        throw new EOFException();
    }

    public String readLine() throws IOException {
        int i;
        int i2;
        synchronized (this.f1838in) {
            try {
                if (this.buf != null) {
                    if (this.pos >= this.end) {
                        fillBuf();
                    }
                    for (int i3 = this.pos; i3 != this.end; i3++) {
                        if (this.buf[i3] == 10) {
                            if (i3 != this.pos) {
                                i2 = i3 - 1;
                                if (this.buf[i2] == 13) {
                                    String str = new String(this.buf, this.pos, i2 - this.pos, this.charset.name());
                                    this.pos = i3 + 1;
                                    return str;
                                }
                            }
                            i2 = i3;
                            String str2 = new String(this.buf, this.pos, i2 - this.pos, this.charset.name());
                            this.pos = i3 + 1;
                            return str2;
                        }
                    }
                    AnonymousClass1 r1 = new ByteArrayOutputStream((this.end - this.pos) + 80) {
                        public String toString() {
                            int i = this.count;
                            try {
                                return new String(this.buf, 0, (i <= 0 || this.buf[i + -1] != 13) ? this.count : i - 1, StrictLineReader.this.charset.name());
                            } catch (UnsupportedEncodingException e2) {
                                throw new AssertionError(e2);
                            }
                        }
                    };
                    loop1:
                    while (true) {
                        r1.write(this.buf, this.pos, this.end - this.pos);
                        this.end = -1;
                        fillBuf();
                        i = this.pos;
                        while (true) {
                            if (i != this.end) {
                                if (this.buf[i] == 10) {
                                    break loop1;
                                }
                                i++;
                            }
                        }
                    }
                    if (i != this.pos) {
                        r1.write(this.buf, this.pos, i - this.pos);
                    }
                    this.pos = i + 1;
                    String r12 = r1.toString();
                    return r12;
                }
                throw new IOException("LineReader is closed");
            }
        }
    }
}
