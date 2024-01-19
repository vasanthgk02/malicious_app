package com.xiaomi.push;

import android.content.Context;

public class m {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f4796a = "0123456789ABCDEF".toCharArray();

    public static String a(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder(i2 * 2);
        for (int i3 = 0; i3 < i2; i3++) {
            byte b2 = bArr[i + i3] & 255;
            sb.append(f4796a[b2 >> 4]);
            sb.append(f4796a[b2 & 15]);
        }
        return sb.toString();
    }

    public static boolean a(Context context) {
        return l.f763a;
    }
}
