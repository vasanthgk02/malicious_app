package org.jboss.netty.util.internal.jzlib;

public final class Adler32 {
    public static final int BASE = 65521;
    public static final int NMAX = 5552;

    public static long adler32(long j, byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return 1;
        }
        long j2 = j & 65535;
        long j3 = (j >> 16) & 65535;
        while (i2 > 0) {
            int i3 = NMAX;
            if (i2 < 5552) {
                i3 = i2;
            }
            i2 -= i3;
            while (i3 >= 16) {
                int i4 = i + 1;
                long j4 = j2 + ((long) (bArr[i] & 255));
                long j5 = j3 + j4;
                int i5 = i4 + 1;
                long j6 = j4 + ((long) (bArr[i4] & 255));
                long j7 = j5 + j6;
                int i6 = i5 + 1;
                long j8 = j6 + ((long) (bArr[i5] & 255));
                long j9 = j7 + j8;
                int i7 = i6 + 1;
                long j10 = j8 + ((long) (bArr[i6] & 255));
                long j11 = j9 + j10;
                int i8 = i7 + 1;
                long j12 = j10 + ((long) (bArr[i7] & 255));
                long j13 = j11 + j12;
                int i9 = i8 + 1;
                long j14 = j12 + ((long) (bArr[i8] & 255));
                long j15 = j13 + j14;
                int i10 = i9 + 1;
                long j16 = j14 + ((long) (bArr[i9] & 255));
                long j17 = j15 + j16;
                int i11 = i10 + 1;
                long j18 = j16 + ((long) (bArr[i10] & 255));
                long j19 = j17 + j18;
                int i12 = i11 + 1;
                long j20 = j18 + ((long) (bArr[i11] & 255));
                long j21 = j19 + j20;
                int i13 = i12 + 1;
                long j22 = j20 + ((long) (bArr[i12] & 255));
                long j23 = j21 + j22;
                int i14 = i13 + 1;
                long j24 = j22 + ((long) (bArr[i13] & 255));
                long j25 = j23 + j24;
                int i15 = i14 + 1;
                long j26 = j24 + ((long) (bArr[i14] & 255));
                long j27 = j25 + j26;
                int i16 = i15 + 1;
                long j28 = j26 + ((long) (bArr[i15] & 255));
                long j29 = j27 + j28;
                int i17 = i16 + 1;
                long j30 = j28 + ((long) (bArr[i16] & 255));
                long j31 = j29 + j30;
                int i18 = i17 + 1;
                long j32 = j30 + ((long) (bArr[i17] & 255));
                long j33 = j31 + j32;
                i = i18 + 1;
                j2 = j32 + ((long) (bArr[i18] & 255));
                j3 = j33 + j2;
                i3 -= 16;
            }
            if (i3 != 0) {
                do {
                    j2 += (long) (bArr[i] & 255);
                    j3 += j2;
                    i3--;
                    i++;
                } while (i3 != 0);
            }
            j2 %= 65521;
            j3 %= 65521;
        }
        return (j3 << 16) | j2;
    }
}
