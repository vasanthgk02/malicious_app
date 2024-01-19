package com.razorpay;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import sfs2x.client.entities.invitation.InvitationReply;

public final class R$$r_ extends FilterInputStream {
    public int B$$W$;
    public int D$_X_;
    public int[] G__G_ = new int[8];
    public int[] Q_$2$ = new int[8];
    public final int R$$r_;
    public Q_$2$ a_$P$;
    public int b__J_ = 8;
    public int[] d__1_ = new int[8];
    public int[] r$_Y_ = new int[2];

    public R$$r_(InputStream inputStream, int[] iArr, byte[] bArr, int i, boolean z, int i2) throws IOException {
        super(inputStream);
        this.R$$r_ = Math.min(Math.max(i, 3), 16);
        this.D$_X_ = i2;
        if (i2 == 2) {
            System.arraycopy(G__G_(bArr), 0, this.Q_$2$, 0, 8);
        }
        this.a_$P$ = new Q_$2$(iArr, this.R$$r_, true);
        this.B$$W$ = this.in.read();
    }

    public static int[] G__G_(byte[] bArr) {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = bArr[i] & 255;
        }
        return iArr;
    }

    public final int available() throws IOException {
        return 8 - this.b__J_;
    }

    public final boolean markSupported() {
        return false;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        int read = read();
        if (read == -1) {
            return -1;
        }
        bArr[i] = (byte) read;
        int i3 = 1;
        while (i3 < i2) {
            int read2 = read();
            if (read2 == -1) {
                return i3;
            }
            bArr[i + i3] = (byte) read2;
            i3++;
        }
        return i3;
    }

    public final long skip(long j) throws IOException {
        long j2 = 0;
        while (j2 < j && read() != -1) {
            j2++;
        }
        return j2;
    }

    public final int read() throws IOException {
        if (this.b__J_ == 8) {
            int i = this.B$$W$;
            if (i == -1) {
                Arrays.fill(this.d__1_, -1);
            } else {
                this.d__1_[0] = i;
                for (int i2 = 1; i2 < 8; i2++) {
                    this.d__1_[i2] = this.in.read();
                }
                if (this.D$_X_ == 2) {
                    int[] iArr = this.d__1_;
                    System.arraycopy(iArr, 0, this.G__G_, 0, iArr.length);
                }
                int[] iArr2 = this.d__1_;
                int i3 = ((iArr2[0] << 24) & -16777216) + ((iArr2[1] << 16) & 16711680) + ((iArr2[2] << 8) & 65280) + (iArr2[3] & InvitationReply.EXPIRED);
                int i4 = (-16777216 & (iArr2[4] << 24)) + (16711680 & (iArr2[5] << 16)) + (65280 & (iArr2[6] << 8)) + (iArr2[7] & InvitationReply.EXPIRED);
                int i5 = this.R$$r_;
                Q_$2$ q_$2$ = this.a_$P$;
                d__1_.R$$r_(i3, i4, false, i5, q_$2$.Q_$2$, q_$2$.a_$P$, this.r$_Y_);
                int[] iArr3 = this.r$_Y_;
                int i6 = iArr3[0];
                int i7 = iArr3[1];
                int[] iArr4 = this.d__1_;
                iArr4[0] = i6 >>> 24;
                iArr4[1] = (i6 >> 16) & InvitationReply.EXPIRED;
                iArr4[2] = (i6 >> 8) & InvitationReply.EXPIRED;
                iArr4[3] = i6 & InvitationReply.EXPIRED;
                iArr4[4] = i7 >>> 24;
                iArr4[5] = (i7 >> 16) & InvitationReply.EXPIRED;
                iArr4[6] = (i7 >> 8) & InvitationReply.EXPIRED;
                iArr4[7] = i7 & InvitationReply.EXPIRED;
                if (this.D$_X_ == 2) {
                    for (int i8 = 0; i8 < 8; i8++) {
                        int[] iArr5 = this.d__1_;
                        iArr5[i8] = (iArr5[i8] ^ this.Q_$2$[i8]) & InvitationReply.EXPIRED;
                    }
                    int[] iArr6 = this.G__G_;
                    System.arraycopy(iArr6, 0, this.Q_$2$, 0, iArr6.length);
                }
                int read = this.in.read();
                this.B$$W$ = read;
                if (read == -1) {
                    int[] iArr7 = this.d__1_;
                    Arrays.fill(iArr7, 8 - iArr7[7], 8, -1);
                }
            }
            this.b__J_ = 0;
        }
        int[] iArr8 = this.d__1_;
        int i9 = this.b__J_;
        this.b__J_ = i9 + 1;
        return iArr8[i9];
    }
}
