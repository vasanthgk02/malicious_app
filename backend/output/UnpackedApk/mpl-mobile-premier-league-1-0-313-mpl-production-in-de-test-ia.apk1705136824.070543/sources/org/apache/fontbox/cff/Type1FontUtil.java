package org.apache.fontbox.cff;

import org.apache.fontbox.type1.Type1Parser;

public final class Type1FontUtil {
    public static byte[] charstringDecrypt(byte[] bArr, int i) {
        return decrypt(bArr, Type1Parser.CHARSTRING_KEY, i);
    }

    public static byte[] charstringEncrypt(byte[] bArr, int i) {
        return encrypt(bArr, Type1Parser.CHARSTRING_KEY, i);
    }

    public static byte[] decrypt(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            byte b2 = bArr[i3] & 255;
            bArr2[i3] = (byte) ((i >> 8) ^ b2);
            i = 65535 & (((b2 + i) * 52845) + 22719);
        }
        int length = bArr.length - i2;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr2, i2, bArr3, 0, length);
        return bArr3;
    }

    public static byte[] eexecDecrypt(byte[] bArr) {
        return decrypt(bArr, Type1Parser.EEXEC_KEY, 4);
    }

    public static byte[] eexecEncrypt(byte[] bArr) {
        return encrypt(bArr, Type1Parser.EEXEC_KEY, 4);
    }

    public static byte[] encrypt(byte[] bArr, int i, int i2) {
        int length = bArr.length + i2;
        byte[] bArr2 = new byte[length];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr2[i3] = 0;
        }
        System.arraycopy(bArr, 0, bArr2, i2, length - i2);
        byte[] bArr3 = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            byte b2 = (bArr2[i4] & 255) ^ (i >> 8);
            bArr3[i4] = (byte) b2;
            i = 65535 & (((b2 + i) * 52845) + 22719);
        }
        return bArr3;
    }

    public static byte[] hexDecode(String str) {
        if (str.length() % 2 == 0) {
            byte[] bArr = new byte[(str.length() / 2)];
            int i = 0;
            while (i < str.length()) {
                int i2 = i + 2;
                bArr[i / 2] = (byte) Integer.parseInt(str.substring(i, i2), 16);
                i = i2;
            }
            return bArr;
        }
        throw new IllegalArgumentException();
    }

    public static String hexEncode(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString.toUpperCase());
        }
        return sb.toString();
    }
}
