package com.razorpay;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.fontbox.ttf.GlyfDescript;
import sfs2x.client.entities.invitation.InvitationReply;

public final class a_$P$ extends FilterInputStream {
    public static final byte[] G__G_ = B$$W$.d__1_;
    public static final int[] Q_$2$ = B$$W$.Q_$2$;
    public static final int[] R$$r_ = B$$W$.G__G_;
    public static final int[] a_$P$ = B$$W$.R$$r_;
    public static final int[] d__1_ = B$$W$.a_$P$;
    public final int[] B$$W$;
    public final byte[] D$_X_ = new byte[16];
    public final byte[] E$_6$ = new byte[16];
    public final byte[][] E$_j$;
    public int Y$_o$ = 16;
    public final int[] b__J_ = new int[4];
    public int c__C_ = 16;
    public int l_$w$ = Integer.MAX_VALUE;
    public final int r$_Y_;

    public a_$P$(InputStream inputStream, int i, byte[] bArr, byte[][] bArr2) {
        super(inputStream);
        this.r$_Y_ = i;
        this.B$$W$ = B$$W$.G__G_(bArr, i);
        this.E$_j$ = Q_$2$(bArr2);
    }

    public static byte[][] Q_$2$(byte[][] bArr) {
        byte[][] bArr2 = new byte[bArr.length][];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = new byte[bArr[i].length];
            for (int i2 = 0; i2 < bArr[i].length; i2++) {
                bArr2[i][bArr[i][i2]] = (byte) i2;
            }
        }
        return bArr2;
    }

    private void R$$r_(byte[] bArr, byte[] bArr2) {
        int[] iArr = this.b__J_;
        char c2 = 1;
        byte b2 = (bArr[0] << 24) | ((bArr[1] & 255) << GlyfDescript.X_DUAL) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        int[] iArr2 = this.B$$W$;
        iArr[0] = b2 ^ iArr2[0];
        iArr[1] = ((((bArr[4] << 24) | ((bArr[5] & 255) << GlyfDescript.X_DUAL)) | ((bArr[6] & 255) << 8)) | (bArr[7] & 255)) ^ iArr2[1];
        iArr[2] = ((((bArr[8] << 24) | ((bArr[9] & 255) << GlyfDescript.X_DUAL)) | ((bArr[10] & 255) << 8)) | (bArr[11] & 255)) ^ iArr2[2];
        int i = (bArr[13] & 255) << GlyfDescript.X_DUAL;
        iArr[3] = iArr2[3] ^ (((i | (bArr[12] << 24)) | ((bArr[14] & 255) << 8)) | (bArr[15] & 255));
        int i2 = 1;
        int i3 = 4;
        while (i2 < this.r$_Y_) {
            int[] iArr3 = d__1_;
            int[] iArr4 = this.b__J_;
            byte[][] bArr3 = this.E$_j$;
            int i4 = iArr3[iArr4[bArr3[0][0]] >>> 24];
            int[] iArr5 = R$$r_;
            int i5 = i4 ^ iArr5[(iArr4[bArr3[c2][0]] >>> 16) & InvitationReply.EXPIRED];
            int[] iArr6 = a_$P$;
            int i6 = iArr6[(iArr4[bArr3[2][0]] >>> 8) & InvitationReply.EXPIRED] ^ i5;
            int[] iArr7 = Q_$2$;
            int i7 = iArr7[iArr4[bArr3[3][0]] & InvitationReply.EXPIRED] ^ i6;
            int[] iArr8 = this.B$$W$;
            int i8 = i7 ^ iArr8[i3];
            int i9 = ((iArr6[(iArr4[bArr3[2][c2]] >>> 8) & InvitationReply.EXPIRED] ^ (iArr3[iArr4[bArr3[0][c2]] >>> 24] ^ iArr5[(iArr4[bArr3[c2][c2]] >>> 16) & InvitationReply.EXPIRED])) ^ iArr7[iArr4[bArr3[3][c2]] & InvitationReply.EXPIRED]) ^ iArr8[i3 + 1];
            int i10 = (((iArr5[(iArr4[bArr3[c2][2]] >>> 16) & InvitationReply.EXPIRED] ^ iArr3[iArr4[bArr3[0][2]] >>> 24]) ^ iArr6[(iArr4[bArr3[2][2]] >>> 8) & InvitationReply.EXPIRED]) ^ iArr7[iArr4[bArr3[3][2]] & InvitationReply.EXPIRED]) ^ iArr8[i3 + 2];
            iArr4[0] = i8;
            iArr4[1] = i9;
            iArr4[2] = i10;
            iArr4[3] = (((iArr3[iArr4[bArr3[0][3]] >>> 24] ^ iArr5[(iArr4[bArr3[1][3]] >>> 16) & InvitationReply.EXPIRED]) ^ iArr6[(iArr4[bArr3[2][3]] >>> 8) & InvitationReply.EXPIRED]) ^ iArr7[iArr4[bArr3[3][3]] & InvitationReply.EXPIRED]) ^ iArr8[i3 + 3];
            i2++;
            i3 += 4;
            c2 = 1;
        }
        int[] iArr9 = this.B$$W$;
        int i11 = iArr9[i3];
        byte[] bArr4 = G__G_;
        int[] iArr10 = this.b__J_;
        byte[][] bArr5 = this.E$_j$;
        bArr2[0] = (byte) (bArr4[iArr10[bArr5[0][0]] >>> 24] ^ (i11 >>> 24));
        bArr2[1] = (byte) (bArr4[(iArr10[bArr5[1][0]] >>> 16) & InvitationReply.EXPIRED] ^ (i11 >>> 16));
        bArr2[2] = (byte) (bArr4[(iArr10[bArr5[2][0]] >>> 8) & InvitationReply.EXPIRED] ^ (i11 >>> 8));
        bArr2[3] = (byte) (i11 ^ bArr4[iArr10[bArr5[3][0]] & InvitationReply.EXPIRED]);
        int i12 = iArr9[i3 + 1];
        bArr2[4] = (byte) (bArr4[iArr10[bArr5[0][1]] >>> 24] ^ (i12 >>> 24));
        bArr2[5] = (byte) (bArr4[(iArr10[bArr5[1][1]] >>> 16) & InvitationReply.EXPIRED] ^ (i12 >>> 16));
        bArr2[6] = (byte) (bArr4[(iArr10[bArr5[2][1]] >>> 8) & InvitationReply.EXPIRED] ^ (i12 >>> 8));
        bArr2[7] = (byte) (i12 ^ bArr4[iArr10[bArr5[3][1]] & InvitationReply.EXPIRED]);
        int i13 = iArr9[i3 + 2];
        bArr2[8] = (byte) (bArr4[iArr10[bArr5[0][2]] >>> 24] ^ (i13 >>> 24));
        bArr2[9] = (byte) (bArr4[(iArr10[bArr5[1][2]] >>> 16) & InvitationReply.EXPIRED] ^ (i13 >>> 16));
        bArr2[10] = (byte) (bArr4[(iArr10[bArr5[2][2]] >>> 8) & InvitationReply.EXPIRED] ^ (i13 >>> 8));
        bArr2[11] = (byte) (i13 ^ bArr4[iArr10[bArr5[3][2]] & InvitationReply.EXPIRED]);
        int i14 = iArr9[i3 + 3];
        bArr2[12] = (byte) (bArr4[iArr10[bArr5[0][3]] >>> 24] ^ (i14 >>> 24));
        bArr2[13] = (byte) (bArr4[(iArr10[bArr5[1][3]] >>> 16) & InvitationReply.EXPIRED] ^ (i14 >>> 16));
        bArr2[14] = (byte) (bArr4[(iArr10[bArr5[2][3]] >>> 8) & InvitationReply.EXPIRED] ^ (i14 >>> 8));
        bArr2[15] = (byte) (i14 ^ bArr4[iArr10[bArr5[3][3]] & InvitationReply.EXPIRED]);
    }

    private int d__1_() throws IOException {
        if (this.l_$w$ == Integer.MAX_VALUE) {
            this.l_$w$ = this.in.read();
        }
        int i = 16;
        if (this.c__C_ == 16) {
            this.D$_X_[0] = (byte) this.l_$w$;
            int i2 = 1;
            do {
                i2 += this.in.read(this.D$_X_, i2, 16 - i2);
            } while (i2 < 16);
            R$$r_(this.D$_X_, this.E$_6$);
            int read = this.in.read();
            this.l_$w$ = read;
            this.c__C_ = 0;
            if (read < 0) {
                i = 16 - (this.E$_6$[15] & 255);
            }
            this.Y$_o$ = i;
        }
        return this.Y$_o$;
    }

    public final int available() throws IOException {
        return this.Y$_o$ - this.c__C_;
    }

    public final void close() throws IOException {
        super.close();
    }

    public final synchronized void mark(int i) {
    }

    public final boolean markSupported() {
        return false;
    }

    public final int read() throws IOException {
        d__1_();
        int i = this.c__C_;
        if (i >= this.Y$_o$) {
            return -1;
        }
        byte[] bArr = this.E$_6$;
        this.c__C_ = i + 1;
        return bArr[i] & 255;
    }

    public final synchronized void reset() throws IOException {
    }

    public final long skip(long j) throws IOException {
        long j2 = 0;
        while (j2 < j && read() != -1) {
            j2++;
        }
        return j2;
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = i;
        while (i4 < i3) {
            d__1_();
            int i5 = this.c__C_;
            if (i5 < this.Y$_o$) {
                byte[] bArr2 = this.E$_6$;
                this.c__C_ = i5 + 1;
                bArr[i4] = bArr2[i5];
                i4++;
            } else if (i4 == i) {
                return -1;
            } else {
                return i2 - (i3 - i4);
            }
        }
        return i2;
    }
}
