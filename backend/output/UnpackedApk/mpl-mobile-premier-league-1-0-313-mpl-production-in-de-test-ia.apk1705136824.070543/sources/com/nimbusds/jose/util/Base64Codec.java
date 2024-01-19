package com.nimbusds.jose.util;

import java.util.Arrays;

public final class Base64Codec {
    public static final char[] CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    public static final char[] CA_URL_SAFE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".toCharArray();
    public static final int[] IA;
    public static final int[] IA_URL_SAFE = new int[256];

    static {
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = CA.length;
        for (int i = 0; i < length; i++) {
            IA[CA[i]] = i;
        }
        IA[61] = 0;
        Arrays.fill(IA_URL_SAFE, -1);
        int length2 = CA_URL_SAFE.length;
        for (int i2 = 0; i2 < length2; i2++) {
            IA_URL_SAFE[CA_URL_SAFE[i2]] = i2;
        }
        IA_URL_SAFE[61] = 0;
    }

    public static int countIllegalChars(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (IA[charAt] == -1 && IA_URL_SAFE[charAt] == -1) {
                i++;
            }
        }
        return i;
    }

    public static byte[] decode(String str) {
        if (str == null || str.isEmpty()) {
            return new byte[0];
        }
        int length = str.length();
        int countIllegalChars = (length - countIllegalChars(str)) % 4;
        int i = countIllegalChars == 0 ? 0 : 4 - countIllegalChars;
        char[] cArr = new char[(length + i)];
        str.getChars(0, length, cArr, 0);
        for (int i2 = 0; i2 < i; i2++) {
            cArr[length + i2] = '=';
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (cArr[i3] == '_') {
                cArr[i3] = '/';
            } else if (cArr[i3] == '-') {
                cArr[i3] = '+';
            }
        }
        String str2 = new String(cArr);
        int length2 = str2.length();
        int countIllegalChars2 = length2 - countIllegalChars(str2);
        if (countIllegalChars2 % 4 != 0) {
            return new byte[0];
        }
        int i4 = 0;
        while (length2 > 1) {
            length2--;
            if (IA[str2.charAt(length2)] > 0) {
                break;
            } else if (str2.charAt(length2) == '=') {
                i4++;
            }
        }
        int i5 = ((countIllegalChars2 * 6) >> 3) - i4;
        byte[] bArr = new byte[i5];
        int i6 = 0;
        int i7 = 0;
        while (i7 < i5) {
            int i8 = 0;
            int i9 = 0;
            while (i8 < 4) {
                int i10 = i6 + 1;
                int i11 = IA[str2.charAt(i6)];
                if (i11 >= 0) {
                    i9 |= i11 << (18 - (i8 * 6));
                } else {
                    i8--;
                }
                i8++;
                i6 = i10;
            }
            int i12 = i7 + 1;
            bArr[i7] = (byte) (i9 >> 16);
            if (i12 < i5) {
                i7 = i12 + 1;
                bArr[i12] = (byte) (i9 >> 8);
                if (i7 < i5) {
                    i12 = i7 + 1;
                    bArr[i7] = (byte) i9;
                }
            }
            i7 = i12;
        }
        return bArr;
    }
}
