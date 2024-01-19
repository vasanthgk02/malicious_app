package com.userexperior.a.a.b;

import java.io.IOException;
import java.io.Writer;

public final class r extends Writer {

    /* renamed from: a  reason: collision with root package name */
    public final Appendable f3716a;

    /* renamed from: b  reason: collision with root package name */
    public final s f3717b = new s();

    public r(Appendable appendable) {
        this.f3716a = appendable;
    }

    public final void close() {
    }

    public final void flush() {
    }

    public final void write(int i) throws IOException {
        this.f3716a.append((char) i);
    }

    public final void write(char[] cArr, int i, int i2) throws IOException {
        s sVar = this.f3717b;
        sVar.f3718a = cArr;
        this.f3716a.append(sVar, i, i2 + i);
    }
}
