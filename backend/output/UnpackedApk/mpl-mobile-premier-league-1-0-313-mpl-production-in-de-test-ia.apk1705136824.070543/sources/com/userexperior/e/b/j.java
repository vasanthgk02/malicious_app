package com.userexperior.e.b;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class j extends ByteArrayOutputStream {

    /* renamed from: a  reason: collision with root package name */
    public final b f3962a;

    public j(b bVar, int i) {
        this.f3962a = bVar;
        this.buf = bVar.a(Math.max(i, 256));
    }

    private void a(int i) {
        int i2 = this.count;
        if (i2 + i > this.buf.length) {
            byte[] a2 = this.f3962a.a((i2 + i) * 2);
            System.arraycopy(this.buf, 0, a2, 0, this.count);
            this.f3962a.a(this.buf);
            this.buf = a2;
        }
    }

    public final void close() throws IOException {
        this.f3962a.a(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.f3962a.a(this.buf);
    }

    public final synchronized void write(int i) {
        a(1);
        super.write(i);
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        a(i2);
        super.write(bArr, i, i2);
    }
}
