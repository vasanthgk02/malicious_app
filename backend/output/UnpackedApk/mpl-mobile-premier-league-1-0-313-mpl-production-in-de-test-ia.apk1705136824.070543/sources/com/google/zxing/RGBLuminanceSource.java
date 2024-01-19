package com.google.zxing;

import com.android.tools.r8.GeneratedOutlineSupport;
import sfs2x.client.entities.invitation.InvitationReply;

public final class RGBLuminanceSource {
    public final int dataHeight;
    public final int dataWidth;
    public final int height;
    public final int left = 0;
    public final byte[] luminances;
    public final int top = 0;
    public final int width;

    public RGBLuminanceSource(int i, int i2, int[] iArr) {
        this.width = i;
        this.height = i2;
        this.dataWidth = i;
        this.dataHeight = i2;
        int i3 = i * i2;
        this.luminances = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr[i4];
            this.luminances[i4] = (byte) (((((i5 >> 16) & InvitationReply.EXPIRED) + ((i5 >> 7) & 510)) + (i5 & InvitationReply.EXPIRED)) / 4);
        }
    }

    public byte[] getMatrix() {
        int i = this.width;
        int i2 = this.height;
        if (i == this.dataWidth && i2 == this.dataHeight) {
            return this.luminances;
        }
        int i3 = i * i2;
        byte[] bArr = new byte[i3];
        int i4 = this.top;
        int i5 = this.dataWidth;
        int i6 = (i4 * i5) + this.left;
        if (i == i5) {
            System.arraycopy(this.luminances, i6, bArr, 0, i3);
            return bArr;
        }
        for (int i7 = 0; i7 < i2; i7++) {
            System.arraycopy(this.luminances, i6, bArr, i7 * i, i);
            i6 += this.dataWidth;
        }
        return bArr;
    }

    public byte[] getRow(int i, byte[] bArr) {
        if (i < 0 || i >= this.height) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline40("Requested row is outside the image: ", i));
        }
        int i2 = this.width;
        if (bArr == null || bArr.length < i2) {
            bArr = new byte[i2];
        }
        System.arraycopy(this.luminances, ((i + this.top) * this.dataWidth) + this.left, bArr, 0, i2);
        return bArr;
    }

    public final String toString() {
        int i = this.width;
        byte[] bArr = new byte[i];
        StringBuilder sb = new StringBuilder((i + 1) * this.height);
        for (int i2 = 0; i2 < this.height; i2++) {
            bArr = getRow(i2, bArr);
            for (int i3 = 0; i3 < this.width; i3++) {
                byte b2 = bArr[i3] & 255;
                sb.append(b2 < 64 ? '#' : b2 < 128 ? '+' : b2 < 192 ? '.' : ' ');
            }
            sb.append(10);
        }
        return sb.toString();
    }
}
