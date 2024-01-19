package io.hansel.core.security;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class d {
    public static String a(String str, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "HmacSHA1");
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(secretKeySpec);
        return a(instance.doFinal(bArr));
    }

    public static String a(byte[] bArr) {
        char[] charArray = "0123456789abcdef".toCharArray();
        char[] cArr = new char[(bArr.length * 2)];
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            byte b2 = bArr[i] & 255;
            int i2 = i * 2;
            cArr[i2] = charArray[b2 >>> 4];
            cArr[i2 + 1] = charArray[b2 & 15];
        }
        return new String(cArr);
    }

    public static String b(String str, byte[] bArr) {
        return a(str, bArr);
    }
}
