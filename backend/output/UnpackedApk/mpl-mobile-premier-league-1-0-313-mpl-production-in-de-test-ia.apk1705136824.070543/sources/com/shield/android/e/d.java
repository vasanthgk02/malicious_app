package com.shield.android.e;

import com.shield.android.internal.f;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f1572a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f1573b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(Long l, String str, String str2) {
        try {
            return a(str, a(l.toString(), str2));
        } catch (GeneralSecurityException e2) {
            if (f.a().f1677b && e2.getMessage() != null) {
                e2.getLocalizedMessage();
            }
            return "";
        }
    }

    public static String a(String str, String str2) throws GeneralSecurityException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "HmacSHA256");
        Mac instance = Mac.getInstance("HmacSHA256");
        instance.init(secretKeySpec);
        return a(instance.doFinal(str.getBytes()));
    }

    public static String a(byte[] bArr) {
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        char[] cArr = new char[(bArr.length * 2)];
        char[] cArr2 = f1572a;
        for (int i = 0; i < bArr.length; i++) {
            int length = byteOrder == ByteOrder.BIG_ENDIAN ? i : (bArr.length - i) - 1;
            int i2 = i << 1;
            cArr[i2] = cArr2[(bArr[length] >> 4) & 15];
            cArr[i2 + 1] = cArr2[bArr[length] & 15];
        }
        return new String(cArr);
    }
}
