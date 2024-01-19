package com.xiaomi.push;

import okio.Utf8;

public class aa {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4392a = System.getProperty("line.separator");

    /* renamed from: a  reason: collision with other field name */
    public static byte[] f237a = new byte[128];

    /* renamed from: a  reason: collision with other field name */
    public static char[] f238a = new char[64];

    static {
        char c2 = 'A';
        int i = 0;
        while (c2 <= 'Z') {
            f238a[i] = c2;
            c2 = (char) (c2 + 1);
            i++;
        }
        char c3 = 'a';
        while (c3 <= 'z') {
            f238a[i] = c3;
            c3 = (char) (c3 + 1);
            i++;
        }
        char c4 = '0';
        while (c4 <= '9') {
            f238a[i] = c4;
            c4 = (char) (c4 + 1);
            i++;
        }
        char[] cArr = f238a;
        cArr[i] = '+';
        cArr[i + 1] = '/';
        int i2 = 0;
        while (true) {
            byte[] bArr = f237a;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        for (int i3 = 0; i3 < 64; i3++) {
            f237a[f238a[i3]] = (byte) i3;
        }
    }

    public static String a(String str) {
        return new String(a(str));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m388a(String str) {
        return a(str.toCharArray());
    }

    public static byte[] a(char[] cArr) {
        return a(cArr, 0, cArr.length);
    }

    public static byte[] a(char[] cArr, int i, int i2) {
        int i3;
        char c2;
        char c3;
        int i4;
        if (i2 % 4 == 0) {
            while (i2 > 0 && cArr[(i + i2) - 1] == '=') {
                i2--;
            }
            int i5 = (i2 * 3) / 4;
            byte[] bArr = new byte[i5];
            int i6 = i2 + i;
            int i7 = 0;
            while (i < i6) {
                int i8 = i + 1;
                char c4 = cArr[i];
                int i9 = i8 + 1;
                char c5 = cArr[i8];
                if (i9 < i6) {
                    i3 = i9 + 1;
                    c2 = cArr[i9];
                } else {
                    i3 = i9;
                    c2 = 'A';
                }
                if (i3 < i6) {
                    i4 = i3 + 1;
                    c3 = cArr[i3];
                } else {
                    i4 = i3;
                    c3 = 'A';
                }
                if (c4 > 127 || c5 > 127 || c2 > 127 || c3 > 127) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                byte[] bArr2 = f237a;
                byte b2 = bArr2[c4];
                byte b3 = bArr2[c5];
                byte b4 = bArr2[c2];
                byte b5 = bArr2[c3];
                if (b2 < 0 || b3 < 0 || b4 < 0 || b5 < 0) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                int i10 = (b2 << 2) | (b3 >>> 4);
                int i11 = ((b3 & 15) << 4) | (b4 >>> 2);
                byte b6 = ((b4 & 3) << 6) | b5;
                int i12 = i7 + 1;
                bArr[i7] = (byte) i10;
                if (i12 < i5) {
                    bArr[i12] = (byte) i11;
                    i12++;
                }
                if (i12 < i5) {
                    bArr[i12] = (byte) b6;
                    i7 = i12 + 1;
                } else {
                    i7 = i12;
                }
                i = i4;
            }
            return bArr;
        }
        throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    }

    public static char[] a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static char[] a(byte[] bArr, int i, int i2) {
        int i3;
        byte b2;
        byte b3;
        int i4 = ((i2 * 4) + 2) / 3;
        char[] cArr = new char[(((i2 + 2) / 3) * 4)];
        int i5 = i2 + i;
        int i6 = 0;
        while (i < i5) {
            int i7 = i + 1;
            byte b4 = bArr[i] & 255;
            if (i7 < i5) {
                i3 = i7 + 1;
                b2 = bArr[i7] & 255;
            } else {
                i3 = i7;
                b2 = 0;
            }
            if (i3 < i5) {
                b3 = bArr[i3] & 255;
                i3++;
            } else {
                b3 = 0;
            }
            int i8 = b4 >>> 2;
            int i9 = ((b4 & 3) << 4) | (b2 >>> 4);
            int i10 = ((b2 & 15) << 2) | (b3 >>> 6);
            byte b5 = b3 & Utf8.REPLACEMENT_BYTE;
            int i11 = i6 + 1;
            char[] cArr2 = f238a;
            cArr[i6] = cArr2[i8];
            int i12 = i11 + 1;
            cArr[i11] = cArr2[i9];
            char c2 = '=';
            cArr[i12] = i12 < i4 ? cArr2[i10] : '=';
            int i13 = i12 + 1;
            if (i13 < i4) {
                c2 = f238a[b5];
            }
            cArr[i13] = c2;
            i6 = i13 + 1;
            i = i3;
        }
        return cArr;
    }
}
