package com.xiaomi.push;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f4391a = new a(new byte[0]);

    /* renamed from: a  reason: collision with other field name */
    public volatile int f235a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f236a;

    public a(byte[] bArr) {
        this.f236a = bArr;
    }

    public static a a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static a a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new a(bArr2);
    }

    public int a() {
        return this.f236a.length;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m387a() {
        byte[] bArr = this.f236a;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        byte[] bArr = this.f236a;
        int length = bArr.length;
        byte[] bArr2 = ((a) obj).f236a;
        if (length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.f235a;
        if (i == 0) {
            int i2 = r1;
            for (byte b2 : this.f236a) {
                i2 = (i2 * 31) + b2;
            }
            i = i2 == 0 ? 1 : i2;
            this.f235a = i;
        }
        return i;
    }
}
