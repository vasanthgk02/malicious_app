package com.cfg.mendikot.api.d.a.a.a.a.a.f;

import java.util.Arrays;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public final byte f2258a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2259b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2260c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2261d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2262e;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f2263a;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f2264c;

        /* renamed from: d  reason: collision with root package name */
        public int f2265d;

        /* renamed from: e  reason: collision with root package name */
        public int f2266e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f2267f;
        public int g;
        public int h;

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", new Object[]{a.class.getSimpleName(), Arrays.toString(this.f2264c), Integer.valueOf(this.g), Boolean.valueOf(this.f2267f), Integer.valueOf(this.f2263a), Long.valueOf(0), Integer.valueOf(this.h), Integer.valueOf(this.f2265d), Integer.valueOf(this.f2266e)});
        }
    }

    public b(int i, int i2, int i3, int i4) {
        this.f2259b = i;
        this.f2260c = i2;
        this.f2261d = i3 > 0 && i4 > 0 ? (i3 / i2) * i2 : 0;
        this.f2262e = i4;
        this.f2258a = 61;
    }

    public abstract void a(byte[] bArr, int i, int i2, a aVar);

    public byte[] a(int i, a aVar) {
        byte[] bArr = aVar.f2264c;
        if (bArr != null && bArr.length >= aVar.f2265d + i) {
            return bArr;
        }
        byte[] bArr2 = aVar.f2264c;
        if (bArr2 == null) {
            aVar.f2264c = new byte[8192];
            aVar.f2265d = 0;
            aVar.f2266e = 0;
        } else {
            byte[] bArr3 = new byte[(bArr2.length * 2)];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            aVar.f2264c = bArr3;
        }
        return aVar.f2264c;
    }
}
