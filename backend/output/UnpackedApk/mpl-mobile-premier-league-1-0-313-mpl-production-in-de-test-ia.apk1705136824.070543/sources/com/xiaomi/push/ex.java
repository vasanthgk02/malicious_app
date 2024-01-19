package com.xiaomi.push;

public final class ex extends ey {

    /* renamed from: a  reason: collision with root package name */
    public int f4780a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f760a;

    /* renamed from: b  reason: collision with root package name */
    public int f4781b;

    public int a() {
        return this.f4780a;
    }

    public int a(byte[] bArr, int i, int i2) {
        int b2 = b();
        if (i2 > b2) {
            i2 = b2;
        }
        if (i2 > 0) {
            System.arraycopy(this.f760a, this.f4780a, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    public void a(int i) {
        this.f4780a += i;
    }

    public void a(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m743a(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m744a() {
        return this.f760a;
    }

    public int b() {
        return this.f4781b - this.f4780a;
    }

    public void b(byte[] bArr, int i, int i2) {
        this.f760a = bArr;
        this.f4780a = i;
        this.f4781b = i + i2;
    }
}
