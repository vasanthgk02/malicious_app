package com.xiaomi.push;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f4530a;

    /* renamed from: a  reason: collision with other field name */
    public final OutputStream f405a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f406a;

    /* renamed from: b  reason: collision with root package name */
    public int f4531b;

    public static class a extends IOException {
        public a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public c(OutputStream outputStream, byte[] bArr) {
        this.f405a = outputStream;
        this.f406a = bArr;
        this.f4531b = 0;
        this.f4530a = bArr.length;
    }

    public c(byte[] bArr, int i, int i2) {
        this.f405a = null;
        this.f406a = bArr;
        this.f4531b = i;
        this.f4530a = i + i2;
    }

    public static int a(int i) {
        if (i >= 0) {
            return d(i);
        }
        return 10;
    }

    public static int a(int i, int i2) {
        return a(i2) + c(i);
    }

    public static int a(int i, long j) {
        return a(j) + c(i);
    }

    public static int a(int i, a aVar) {
        return a(aVar) + c(i);
    }

    public static int a(int i, e eVar) {
        return a(eVar) + c(i);
    }

    public static int a(int i, String str) {
        return a(str) + c(i);
    }

    public static int a(int i, boolean z) {
        return a(z) + c(i);
    }

    public static int a(long j) {
        return b(j);
    }

    public static int a(a aVar) {
        return aVar.a() + d(aVar.a());
    }

    public static int a(e eVar) {
        int b2 = eVar.b();
        return d(b2) + b2;
    }

    public static int a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return d(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int a(boolean z) {
        return 1;
    }

    public static c a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    public static c a(OutputStream outputStream, int i) {
        return new c(outputStream, new byte[i]);
    }

    public static c a(byte[] bArr, int i, int i2) {
        return new c(bArr, i, i2);
    }

    public static int b(int i) {
        return d(i);
    }

    public static int b(int i, int i2) {
        return b(i2) + c(i);
    }

    public static int b(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int c(int i) {
        return d(f.a(i, 0));
    }

    private void c() {
        OutputStream outputStream = this.f405a;
        if (outputStream != null) {
            outputStream.write(this.f406a, 0, this.f4531b);
            this.f4531b = 0;
            return;
        }
        throw new a();
    }

    public static int d(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public int a() {
        if (this.f405a == null) {
            return this.f4530a - this.f4531b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m547a() {
        if (this.f405a != null) {
            c();
        }
    }

    public void a(byte b2) {
        if (this.f4531b == this.f4530a) {
            c();
        }
        byte[] bArr = this.f406a;
        int i = this.f4531b;
        this.f4531b = i + 1;
        bArr[i] = b2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m548a(int i) {
        if (i >= 0) {
            d(i);
        } else {
            b((long) i);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m549a(int i, int i2) {
        c(i, 0);
        a(i2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m550a(int i, long j) {
        c(i, 0);
        a(j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m551a(int i, a aVar) {
        c(i, 2);
        a(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m552a(int i, e eVar) {
        c(i, 2);
        a(eVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m553a(int i, String str) {
        c(i, 2);
        a(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m554a(int i, boolean z) {
        c(i, 0);
        a(z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m555a(long j) {
        b(j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m556a(a aVar) {
        byte[] a2 = aVar.a();
        d(a2.length);
        a(a2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m557a(e eVar) {
        d(eVar.a());
        eVar.a(this);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m558a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        d(bytes.length);
        a(bytes);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m559a(boolean z) {
        c(z ? 1 : 0);
    }

    public void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m560a(byte[] bArr, int i, int i2) {
        int i3 = this.f4530a;
        int i4 = this.f4531b;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.f406a, i4, i2);
            this.f4531b += i2;
            return;
        }
        int i5 = i3 - i4;
        System.arraycopy(bArr, i, this.f406a, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.f4531b = this.f4530a;
        c();
        if (i7 <= this.f4530a) {
            System.arraycopy(bArr, i6, this.f406a, 0, i7);
            this.f4531b = i7;
            return;
        }
        this.f405a.write(bArr, i6, i7);
    }

    public void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m561b(int i) {
        d(i);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m562b(int i, int i2) {
        c(i, 0);
        b(i2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m563b(long j) {
        while ((-128 & j) != 0) {
            c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        c((int) j);
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m564c(int i) {
        a((byte) i);
    }

    public void c(int i, int i2) {
        d(f.a(i, i2));
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m565d(int i) {
        while ((i & -128) != 0) {
            c((i & 127) | 128);
            i >>>= 7;
        }
        c(i);
    }
}
