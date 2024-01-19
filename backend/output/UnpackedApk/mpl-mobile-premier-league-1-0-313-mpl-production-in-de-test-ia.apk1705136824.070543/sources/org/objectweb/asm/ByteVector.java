package org.objectweb.asm;

import org.apache.pdfbox.pdmodel.common.function.type4.Parser.Tokenizer;

public class ByteVector {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f6184a;

    /* renamed from: b  reason: collision with root package name */
    public int f6185b;

    public ByteVector() {
        this.f6184a = new byte[64];
    }

    public ByteVector(int i) {
        this.f6184a = new byte[i];
    }

    public ByteVector a(int i, int i2) {
        int i3 = this.f6185b;
        if (i3 + 2 > this.f6184a.length) {
            a(2);
        }
        byte[] bArr = this.f6184a;
        int i4 = i3 + 1;
        bArr[i3] = (byte) i;
        bArr[i4] = (byte) i2;
        this.f6185b = i4 + 1;
        return this;
    }

    public final void a(int i) {
        int length = this.f6184a.length * 2;
        int i2 = this.f6185b + i;
        if (length <= i2) {
            length = i2;
        }
        byte[] bArr = new byte[length];
        System.arraycopy(this.f6184a, 0, bArr, 0, this.f6185b);
        this.f6184a = bArr;
    }

    public ByteVector b(int i, int i2) {
        int i3 = this.f6185b;
        if (i3 + 3 > this.f6184a.length) {
            a(3);
        }
        byte[] bArr = this.f6184a;
        int i4 = i3 + 1;
        bArr[i3] = (byte) i;
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        bArr[i5] = (byte) i2;
        this.f6185b = i5 + 1;
        return this;
    }

    public ByteVector c(String str, int i, int i2) {
        int i3;
        int length = str.length();
        int i4 = i;
        int i5 = i4;
        while (i4 < length) {
            char charAt = str.charAt(i4);
            i5 = (charAt < 1 || charAt > 127) ? charAt > 2047 ? i5 + 3 : i5 + 2 : i5 + 1;
            i4++;
        }
        if (i5 <= i2) {
            int i6 = (this.f6185b - i) - 2;
            if (i6 >= 0) {
                byte[] bArr = this.f6184a;
                bArr[i6] = (byte) (i5 >>> 8);
                bArr[i6 + 1] = (byte) i5;
            }
            if ((this.f6185b + i5) - i > this.f6184a.length) {
                a(i5 - i);
            }
            int i7 = this.f6185b;
            while (i < length) {
                char charAt2 = str.charAt(i);
                if (charAt2 < 1 || charAt2 > 127) {
                    byte[] bArr2 = this.f6184a;
                    int i8 = i7 + 1;
                    if (charAt2 > 2047) {
                        bArr2[i7] = (byte) (((charAt2 >> Tokenizer.FF) & 15) | 224);
                        int i9 = i8 + 1;
                        bArr2[i8] = (byte) (((charAt2 >> 6) & 63) | 128);
                        i3 = i9 + 1;
                        bArr2[i9] = (byte) ((charAt2 & '?') | 128);
                    } else {
                        bArr2[i7] = (byte) (((charAt2 >> 6) & 31) | 192);
                        i7 = i8 + 1;
                        bArr2[i8] = (byte) ((charAt2 & '?') | 128);
                        i++;
                    }
                } else {
                    i3 = i7 + 1;
                    this.f6184a[i7] = (byte) charAt2;
                }
                i7 = i3;
                i++;
            }
            this.f6185b = i7;
            return this;
        }
        throw new IllegalArgumentException();
    }

    public ByteVector putByte(int i) {
        int i2 = this.f6185b;
        int i3 = i2 + 1;
        if (i3 > this.f6184a.length) {
            a(1);
        }
        this.f6184a[i2] = (byte) i;
        this.f6185b = i3;
        return this;
    }

    public ByteVector putByteArray(byte[] bArr, int i, int i2) {
        if (this.f6185b + i2 > this.f6184a.length) {
            a(i2);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i, this.f6184a, this.f6185b, i2);
        }
        this.f6185b += i2;
        return this;
    }

    public ByteVector putInt(int i) {
        int i2 = this.f6185b;
        if (i2 + 4 > this.f6184a.length) {
            a(4);
        }
        byte[] bArr = this.f6184a;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >>> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i >>> 8);
        bArr[i5] = (byte) i;
        this.f6185b = i5 + 1;
        return this;
    }

    public ByteVector putLong(long j) {
        int i = this.f6185b;
        if (i + 8 > this.f6184a.length) {
            a(8);
        }
        byte[] bArr = this.f6184a;
        int i2 = (int) (j >>> 32);
        int i3 = i + 1;
        bArr[i] = (byte) (i2 >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 >>> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        int i6 = i5 + 1;
        bArr[i5] = (byte) i2;
        int i7 = (int) j;
        int i8 = i6 + 1;
        bArr[i6] = (byte) (i7 >>> 24);
        int i9 = i8 + 1;
        bArr[i8] = (byte) (i7 >>> 16);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (i7 >>> 8);
        bArr[i10] = (byte) i7;
        this.f6185b = i10 + 1;
        return this;
    }

    public ByteVector putShort(int i) {
        int i2 = this.f6185b;
        if (i2 + 2 > this.f6184a.length) {
            a(2);
        }
        byte[] bArr = this.f6184a;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 8);
        bArr[i3] = (byte) i;
        this.f6185b = i3 + 1;
        return this;
    }
}
