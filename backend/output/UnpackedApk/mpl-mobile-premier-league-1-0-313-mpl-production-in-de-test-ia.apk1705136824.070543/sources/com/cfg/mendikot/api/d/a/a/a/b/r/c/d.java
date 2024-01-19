package com.cfg.mendikot.api.d.a.a.a.b.r.c;

import co.hyperverge.hypersnapsdk.c.k;
import com.cfg.mendikot.api.d.a.a.a.b.j;
import com.cfg.mendikot.api.d.a.a.a.b.q.a;
import com.cfg.mendikot.api.d.a.a.a.b.w.c;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

public class d implements com.cfg.mendikot.api.d.a.a.a.b.s.d {

    /* renamed from: a  reason: collision with root package name */
    public final c f2291a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f2292b;

    /* renamed from: c  reason: collision with root package name */
    public final c f2293c;

    /* renamed from: d  reason: collision with root package name */
    public final a f2294d;

    /* renamed from: e  reason: collision with root package name */
    public final CharsetDecoder f2295e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f2296f;
    public int g;
    public int h;
    public CharBuffer i;

    public d(c cVar, int i2) {
        k.a(cVar, (String) "HTTP transport metrcis");
        if (i2 > 0) {
            this.f2291a = cVar;
            this.f2292b = new byte[i2];
            this.g = 0;
            this.h = 0;
            this.f2294d = a.f2277c;
            this.f2293c = new c(i2);
            this.f2295e = null;
            return;
        }
        throw new IllegalArgumentException("Buffer size may not be negative or zero");
    }

    public int a(com.cfg.mendikot.api.d.a.a.a.b.w.d dVar) {
        int i2;
        k.a(dVar, (String) "Char array buffer");
        int i3 = this.f2294d.f2278a;
        boolean z = true;
        boolean z2 = true;
        int i4 = 0;
        while (z2) {
            int i5 = this.g;
            while (true) {
                if (i5 >= this.h) {
                    i5 = -1;
                    break;
                } else if (this.f2292b[i5] == 10) {
                    break;
                } else {
                    i5++;
                }
            }
            if (i3 > 0) {
                int i6 = this.f2293c.f2316b;
                if (i5 > 0) {
                    i2 = i5;
                } else {
                    i2 = this.h;
                }
                if ((i6 + i2) - this.g >= i3) {
                    throw new j("Maximum line length limit exceeded");
                }
            }
            if (i5 != -1) {
                if (this.f2293c.f2316b == 0) {
                    int i7 = this.g;
                    this.g = i5 + 1;
                    if (i5 > i7) {
                        int i8 = i5 - 1;
                        if (this.f2292b[i8] == 13) {
                            i5 = i8;
                        }
                    }
                    int i9 = i5 - i7;
                    if (this.f2295e == null) {
                        dVar.a(this.f2292b, i7, i9);
                    } else {
                        i9 = a(dVar, ByteBuffer.wrap(this.f2292b, i7, i9));
                    }
                    return i9;
                }
                int i10 = i5 + 1;
                int i11 = this.g;
                this.f2293c.a(this.f2292b, i11, i10 - i11);
                this.g = i10;
            } else {
                if (this.g < this.h) {
                    int i12 = this.h;
                    int i13 = this.g;
                    this.f2293c.a(this.f2292b, i13, i12 - i13);
                    this.g = this.h;
                }
                int i14 = this.g;
                if (i14 > 0) {
                    int i15 = this.h - i14;
                    if (i15 > 0) {
                        byte[] bArr = this.f2292b;
                        System.arraycopy(bArr, i14, bArr, 0, i15);
                    }
                    this.g = 0;
                    this.h = i15;
                }
                int i16 = this.h;
                byte[] bArr2 = this.f2292b;
                int length = bArr2.length - i16;
                InputStream inputStream = this.f2296f;
                if (inputStream != null) {
                    int read = inputStream.read(bArr2, i16, length);
                    if (read == -1) {
                        i4 = -1;
                    } else {
                        this.h = i16 + read;
                        this.f2291a.f2290a += (long) read;
                        i4 = read;
                    }
                    if (i4 != -1) {
                    }
                } else {
                    throw new IllegalStateException("Input stream is null");
                }
            }
            z2 = false;
        }
        if (i4 == -1) {
            if (this.f2293c.f2316b != 0) {
                z = false;
            }
            if (z) {
                return -1;
            }
        }
        c cVar = this.f2293c;
        int i17 = cVar.f2316b;
        if (i17 > 0) {
            int i18 = i17 - 1;
            if (cVar.f2315a[i18] == 10) {
                i17 = i18;
            }
            if (i17 > 0) {
                int i19 = i17 - 1;
                if (this.f2293c.f2315a[i19] == 13) {
                    i17 = i19;
                }
            }
        }
        if (this.f2295e == null) {
            c cVar2 = this.f2293c;
            if (cVar2 != null) {
                dVar.a(cVar2.f2315a, 0, i17);
            }
        } else {
            i17 = a(dVar, ByteBuffer.wrap(this.f2293c.f2315a, 0, i17));
        }
        this.f2293c.f2316b = 0;
        return i17;
    }

    public final int a(com.cfg.mendikot.api.d.a.a.a.b.w.d dVar, ByteBuffer byteBuffer) {
        int i2 = 0;
        if (!byteBuffer.hasRemaining()) {
            return 0;
        }
        if (this.i == null) {
            this.i = CharBuffer.allocate(1024);
        }
        this.f2295e.reset();
        while (byteBuffer.hasRemaining()) {
            i2 += a(this.f2295e.decode(byteBuffer, this.i, true), dVar);
        }
        int a2 = a(this.f2295e.flush(this.i), dVar) + i2;
        this.i.clear();
        return a2;
    }

    public final int a(CoderResult coderResult, com.cfg.mendikot.api.d.a.a.a.b.w.d dVar) {
        if (coderResult.isError()) {
            coderResult.throwException();
        }
        this.i.flip();
        int remaining = this.i.remaining();
        while (this.i.hasRemaining()) {
            dVar.a(this.i.get());
        }
        this.i.compact();
        return remaining;
    }
}
