package com.razorpay;

public class G__G_ {
    public static void Q_$2$(byte[] bArr, byte b2, long j) {
        for (int i = 0; i < bArr.length; i++) {
            if (((1 << i) & j) != 0) {
                bArr[i] = (byte) (bArr[i] ^ b2);
            }
        }
    }
}
