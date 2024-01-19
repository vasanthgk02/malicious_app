package com.razorpay;

import sfs2x.client.entities.invitation.InvitationReply;

public final class d__1_ {
    public static void Q_$2$(int[] iArr) {
        for (int i = 0; i < iArr.length / 2; i++) {
            int i2 = iArr[i];
            iArr[i] = iArr[(iArr.length - i) - 1];
            iArr[(iArr.length - i) - 1] = i2;
        }
    }

    public static void R$$r_(int i, int i2, boolean z, int i3, int[] iArr, int[][] iArr2, int[] iArr3) {
        int[] iArr4 = iArr;
        if (!z) {
            Q_$2$(iArr);
        }
        int i4 = i;
        int i5 = i2;
        int i6 = 0;
        while (i6 < i3) {
            int i7 = i4 ^ iArr4[i6];
            int i8 = (i7 >>> 16) & InvitationReply.EXPIRED;
            int i9 = (i7 >>> 8) & InvitationReply.EXPIRED;
            int i10 = i7 & InvitationReply.EXPIRED;
            int[] iArr5 = iArr2[0];
            i6++;
            int i11 = i5 ^ ((iArr2[2][i9] ^ (iArr5[i7 >>> 24] + iArr2[1][i8])) + iArr2[3][i10]);
            i5 = i7;
            i4 = i11;
        }
        int i12 = i4 ^ iArr4[iArr4.length - 2];
        int i13 = i5 ^ iArr4[iArr4.length - 1];
        if (!z) {
            Q_$2$(iArr);
        }
        iArr3[0] = i13;
        iArr3[1] = i12;
    }
}
