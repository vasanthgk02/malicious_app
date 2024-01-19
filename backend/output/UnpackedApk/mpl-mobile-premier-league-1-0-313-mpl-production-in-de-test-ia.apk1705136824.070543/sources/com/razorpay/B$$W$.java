package com.razorpay;

import org.apache.fontbox.ttf.GlyfDescript;
import sfs2x.client.entities.invitation.InvitationReply;

public final class B$$W$ {
    public static byte[] E$_j$ = new byte[256];
    public static final int[] G__G_ = new int[256];
    public static final int[] Q_$2$ = new int[256];
    public static final int[] R$$r_ = new int[256];
    public static final int[] a_$P$ = new int[256];
    public static final byte[] d__1_ = new byte[256];
    public static int[] r$_Y_ = new int[10];

    static {
        byte[] bArr;
        byte b2;
        byte b3 = 1;
        byte b4 = 1;
        do {
            b3 = (byte) (((b3 & 128) != 0 ? (byte) 27 : 0) ^ ((b3 << 1) ^ b3));
            byte b5 = (byte) (b4 ^ (b4 << 1));
            byte b6 = (byte) (b5 ^ (b5 << 2));
            byte b7 = (byte) (b6 ^ (b6 << 4));
            b4 = (byte) (b7 ^ ((b7 & 128) != 0 ? (byte) 9 : 0));
            bArr = E$_j$;
            b2 = b3 & 255;
            byte b8 = b4 & 255;
            bArr[b2] = (byte) (((((b4 ^ 99) ^ ((b8 << 1) | (b8 >> 7))) ^ ((b8 << 2) | (b8 >> 6))) ^ ((b8 << 3) | (b8 >> 5))) ^ ((b8 >> 4) | (b8 << 4)));
        } while (b2 != 1);
        bArr[0] = 99;
        for (int i = 0; i < 256; i++) {
            byte b9 = E$_j$[i] & 255;
            d__1_[b9] = (byte) i;
            int i2 = i << 1;
            if (i2 >= 256) {
                i2 ^= 283;
            }
            int i3 = i2 << 1;
            if (i3 >= 256) {
                i3 ^= 283;
            }
            int i4 = i3 << 1;
            if (i4 >= 256) {
                i4 ^= 283;
            }
            int i5 = i4 ^ i;
            int i6 = ((i2 ^ (i3 ^ i4)) << 24) | (i5 << 16) | ((i5 ^ i3) << 8) | (i5 ^ i2);
            a_$P$[b9] = i6;
            G__G_[b9] = (i6 >>> 8) | (i6 << 24);
            R$$r_[b9] = (i6 >>> 16) | (i6 << 16);
            Q_$2$[b9] = (i6 << 8) | (i6 >>> 24);
        }
        r$_Y_[0] = 16777216;
        int i7 = 1;
        for (int i8 = 1; i8 < 10; i8++) {
            i7 <<= 1;
            if (i7 >= 256) {
                i7 ^= 283;
            }
            r$_Y_[i8] = i7 << 24;
        }
    }

    public static int[] G__G_(byte[] bArr, int i) throws IllegalArgumentException {
        if (bArr.length == 16) {
            int i2 = (i + 1) * 4;
            int[] iArr = new int[i2];
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i4 < 4) {
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                byte b2 = (bArr[i5] << 24) | ((bArr[i6] & 255) << GlyfDescript.X_DUAL);
                int i8 = i7 + 1;
                iArr[i4] = b2 | ((bArr[i7] & 255) << 8) | (bArr[i8] & 255);
                i4++;
                i5 = i8 + 1;
            }
            int i9 = 0;
            int i10 = 4;
            while (i10 < i2) {
                int i11 = iArr[i10 - 1];
                if (i3 == 0) {
                    byte[] bArr2 = E$_j$;
                    i11 = ((bArr2[i11 >>> 24] & 255) | (((bArr2[(i11 >>> 16) & InvitationReply.EXPIRED] << 24) | ((bArr2[(i11 >>> 8) & InvitationReply.EXPIRED] & 255) << GlyfDescript.X_DUAL)) | ((bArr2[i11 & InvitationReply.EXPIRED] & 255) << 8))) ^ r$_Y_[i9];
                    i9++;
                    i3 = 4;
                }
                iArr[i10] = i11 ^ iArr[i10 - 4];
                i10++;
                i3--;
            }
            return Q_$2$(bArr, iArr, i);
        }
        throw new IllegalArgumentException();
    }

    public static int[] Q_$2$(byte[] bArr, int[] iArr, int i) throws IllegalArgumentException {
        if (bArr.length == 16) {
            int i2 = 4;
            int[] iArr2 = new int[((i + 1) * 4)];
            int i3 = i * 4;
            int i4 = i3 + 1;
            iArr2[0] = iArr[i3];
            int i5 = i4 + 1;
            int i6 = iArr[i4];
            int i7 = 1;
            iArr2[1] = i6;
            int i8 = i5 + 1;
            iArr2[2] = iArr[i5];
            iArr2[3] = iArr[i8];
            int i9 = i8 - 7;
            while (i7 < i) {
                int i10 = i9 + 1;
                int i11 = iArr[i9];
                int i12 = i2 + 1;
                int[] iArr3 = a_$P$;
                byte[] bArr2 = E$_j$;
                int i13 = iArr3[bArr2[i11 >>> 24] & 255];
                int[] iArr4 = G__G_;
                int i14 = i13 ^ iArr4[bArr2[(i11 >>> 16) & InvitationReply.EXPIRED] & 255];
                int[] iArr5 = R$$r_;
                int i15 = i14 ^ iArr5[bArr2[(i11 >>> 8) & InvitationReply.EXPIRED] & 255];
                int[] iArr6 = Q_$2$;
                iArr2[i2] = iArr6[bArr2[i11 & InvitationReply.EXPIRED] & 255] ^ i15;
                int i16 = i10 + 1;
                int i17 = iArr[i10];
                int i18 = i12 + 1;
                iArr2[i12] = iArr6[bArr2[i17 & InvitationReply.EXPIRED] & 255] ^ ((iArr3[bArr2[i17 >>> 24] & 255] ^ iArr4[bArr2[(i17 >>> 16) & InvitationReply.EXPIRED] & 255]) ^ iArr5[bArr2[(i17 >>> 8) & InvitationReply.EXPIRED] & 255]);
                int i19 = i16 + 1;
                int i20 = iArr[i16];
                int i21 = i18 + 1;
                iArr2[i18] = iArr6[bArr2[i20 & InvitationReply.EXPIRED] & 255] ^ ((iArr3[bArr2[i20 >>> 24] & 255] ^ iArr4[bArr2[(i20 >>> 16) & InvitationReply.EXPIRED] & 255]) ^ iArr5[bArr2[(i20 >>> 8) & InvitationReply.EXPIRED] & 255]);
                int i22 = iArr[i19];
                int i23 = i21 + 1;
                iArr2[i21] = iArr6[bArr2[i22 & InvitationReply.EXPIRED] & 255] ^ ((iArr3[bArr2[i22 >>> 24] & 255] ^ iArr4[bArr2[(i22 >>> 16) & InvitationReply.EXPIRED] & 255]) ^ iArr5[bArr2[(i22 >>> 8) & InvitationReply.EXPIRED] & 255]);
                i9 = i19 - 7;
                i7++;
                i2 = i23;
            }
            int i24 = i2 + 1;
            int i25 = i9 + 1;
            iArr2[i2] = iArr[i9];
            int i26 = i24 + 1;
            int i27 = i25 + 1;
            iArr2[i24] = iArr[i25];
            iArr2[i26] = iArr[i27];
            iArr2[i26 + 1] = iArr[i27 + 1];
            return iArr2;
        }
        throw new IllegalArgumentException();
    }

    public static byte[][] d__1_(int i) {
        byte[][] bArr = new byte[4][];
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i >>> (i2 << 3);
            bArr[i2] = new byte[]{(byte) (i3 & 3), (byte) ((i3 >> 2) & 3), (byte) ((i3 >> 4) & 3), (byte) ((i3 >> 6) & 3)};
        }
        return bArr;
    }
}
