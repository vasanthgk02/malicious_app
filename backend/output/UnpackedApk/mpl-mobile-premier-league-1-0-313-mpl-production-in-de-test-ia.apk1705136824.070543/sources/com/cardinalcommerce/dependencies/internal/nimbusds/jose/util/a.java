package com.cardinalcommerce.dependencies.internal.nimbusds.jose.util;

import java.util.Arrays;
import okio.Utf8;
import org.apache.fontbox.ttf.GlyfDescript;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f2054a = (!a.class.desiredAssertionStatus());

    public static byte a(int i) {
        if (f2054a || (i >= 0 && i <= 63)) {
            int a2 = a(i, 26);
            int b2 = b(i, 25) & a(i, 52);
            int b3 = b(i, 51) & a(i, 62);
            int c2 = c(i, 62);
            int c3 = c(i, 63);
            return (byte) (a(b3, (i - 52) + 48, 0) | a(a2, i + 0 + 65, 0) | a(b2, (i - 26) + 97, 0) | a(c2, 43, 0) | a(c3, 47, 0));
        }
        throw new AssertionError();
    }

    public static int a(int i, int i2) {
        return (int) ((((long) i) - ((long) i2)) >>> 63);
    }

    public static int a(int i, int i2, int i3) {
        return ((i - 1) & (i3 ^ i2)) ^ i2;
    }

    public static String a(byte[] bArr, boolean z) {
        int i;
        int i2 = 0;
        int length = bArr != null ? bArr.length : 0;
        if (length == 0) {
            return "";
        }
        int i3 = length / 3;
        int i4 = i3 * 3;
        if (length == 0) {
            i = 0;
        } else if (z) {
            i = i3 << 2;
            int i5 = length % 3;
            if (i5 != 0) {
                i = i + i5 + 1;
            }
        } else {
            i = (((length - 1) / 3) + 1) << 2;
        }
        byte[] bArr2 = new byte[i];
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            int i8 = i6 + 1;
            int i9 = i8 + 1;
            byte b2 = ((bArr[i6] & 255) << GlyfDescript.X_DUAL) | ((bArr[i8] & 255) << 8);
            int i10 = i9 + 1;
            byte b3 = b2 | (bArr[i9] & 255);
            int i11 = i7 + 1;
            int i12 = (b3 >>> 18) & 63;
            if (z) {
                bArr2[i7] = b(i12);
                int i13 = i11 + 1;
                bArr2[i11] = b((b3 >>> MqttWireMessage.MESSAGE_TYPE_PINGREQ) & 63);
                int i14 = i13 + 1;
                bArr2[i13] = b((b3 >>> 6) & 63);
                i7 = i14 + 1;
                bArr2[i14] = b(b3 & Utf8.REPLACEMENT_BYTE);
            } else {
                bArr2[i7] = a(i12);
                int i15 = i11 + 1;
                bArr2[i11] = a((b3 >>> MqttWireMessage.MESSAGE_TYPE_PINGREQ) & 63);
                int i16 = i15 + 1;
                bArr2[i15] = a((b3 >>> 6) & 63);
                i7 = i16 + 1;
                bArr2[i16] = a((int) b3 & Utf8.REPLACEMENT_BYTE);
            }
            i6 = i10;
        }
        int i17 = length - i4;
        if (i17 > 0) {
            int i18 = (bArr[i4] & 255) << 10;
            if (i17 == 2) {
                i2 = (bArr[length - 1] & 255) << 2;
            }
            int i19 = i18 | i2;
            if (!z) {
                bArr2[i - 4] = a(i19 >> 12);
                bArr2[i - 3] = a((i19 >>> 6) & 63);
                bArr2[i - 2] = i17 == 2 ? a(i19 & 63) : 61;
                bArr2[i - 1] = 61;
            } else if (i17 == 2) {
                bArr2[i - 3] = b(i19 >> 12);
                bArr2[i - 2] = b((i19 >>> 6) & 63);
                bArr2[i - 1] = b(i19 & 63);
            } else {
                bArr2[i - 2] = b(i19 >> 12);
                bArr2[i - 1] = b((i19 >>> 6) & 63);
            }
        }
        return new String(bArr2, i.f2055a);
    }

    public static byte b(int i) {
        if (f2054a || (i >= 0 && i <= 63)) {
            int a2 = a(i, 26);
            int b2 = b(i, 25) & a(i, 52);
            int b3 = b(i, 51) & a(i, 62);
            int c2 = c(i, 62);
            int c3 = c(i, 63);
            return (byte) (a(b3, (i - 52) + 48, 0) | a(a2, i + 0 + 65, 0) | a(b2, (i - 26) + 97, 0) | a(c2, 45, 0) | a(c3, 95, 0));
        }
        throw new AssertionError();
    }

    public static int b(int i, int i2) {
        return (int) ((((long) i2) - ((long) i)) >>> 63);
    }

    public static int c(int i, int i2) {
        int i3 = i ^ i2;
        return ((~i3) & (i3 - 1)) >>> 63;
    }

    public static byte[] a(String str) {
        String str2 = str;
        if (str2 == null || str.isEmpty()) {
            return new byte[0];
        }
        byte[] bytes = str2.getBytes(i.f2055a);
        int length = bytes.length;
        long j = (((long) length) * 6) >> 3;
        int i = (int) j;
        if (((long) i) == j) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            int i3 = 0;
            while (i2 < bytes.length) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < 4 && i2 < length) {
                    int i6 = i2 + 1;
                    byte b2 = bytes[i2];
                    int b3 = b(b2, 64) & a((int) b2, 91);
                    int b4 = b(b2, 96) & a((int) b2, 123);
                    int b5 = b(b2, 47) & a((int) b2, 58);
                    int c2 = c(b2, 45) | c(b2, 43);
                    int c3 = c(b2, 47) | c(b2, 95);
                    byte[] bArr2 = bytes;
                    int a2 = a(b3, (b2 - 65) + 0, 0);
                    int a3 = a(b4, (b2 - 97) + 26, 0) | a2 | a(b5, (b2 - 48) + 52, 0) | a(c2, 62, 0) | a(c3, 63, 0) | a(b3 | b4 | b5 | c2 | c3, 0, -1);
                    if (f2054a || (a3 >= -1 && a3 <= 63)) {
                        if (a3 >= 0) {
                            i5 |= a3 << (18 - (i4 * 6));
                            i4++;
                        }
                        i2 = i6;
                        bytes = bArr2;
                    } else {
                        throw new AssertionError();
                    }
                }
                byte[] bArr3 = bytes;
                if (i4 >= 2) {
                    int i7 = i3 + 1;
                    bArr[i3] = (byte) (i5 >> 16);
                    if (i4 >= 3) {
                        i3 = i7 + 1;
                        bArr[i7] = (byte) (i5 >> 8);
                        if (i4 >= 4) {
                            i7 = i3 + 1;
                            bArr[i3] = (byte) i5;
                        }
                    }
                    i3 = i7;
                }
                bytes = bArr3;
            }
            return Arrays.copyOf(bArr, i3);
        }
        throw new IllegalArgumentException(j + " cannot be cast to int without changing its value.");
    }
}
