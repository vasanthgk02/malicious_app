package com.google.zxing.datamatrix.encoder;

import java.util.Arrays;

public class DefaultPlacement {
    public final byte[] bits;
    public final CharSequence codewords;
    public final int numcols;
    public final int numrows;

    public DefaultPlacement(CharSequence charSequence, int i, int i2) {
        this.codewords = charSequence;
        this.numcols = i;
        this.numrows = i2;
        byte[] bArr = new byte[(i * i2)];
        this.bits = bArr;
        Arrays.fill(bArr, -1);
    }

    public final boolean hasBit(int i, int i2) {
        return this.bits[(i2 * this.numcols) + i] >= 0;
    }

    public final void module(int i, int i2, int i3, int i4) {
        if (i < 0) {
            int i5 = this.numrows;
            i += i5;
            i2 += 4 - ((i5 + 4) % 8);
        }
        if (i2 < 0) {
            int i6 = this.numcols;
            i2 += i6;
            i += 4 - ((i6 + 4) % 8);
        }
        boolean z = true;
        if ((this.codewords.charAt(i3) & (1 << (8 - i4))) == 0) {
            z = false;
        }
        setBit(i2, i, z);
    }

    public final void setBit(int i, int i2, boolean z) {
        this.bits[(i2 * this.numcols) + i] = z ? (byte) 1 : 0;
    }

    public final void utah(int i, int i2, int i3) {
        int i4 = i - 2;
        int i5 = i2 - 2;
        module(i4, i5, i3, 1);
        int i6 = i2 - 1;
        module(i4, i6, i3, 2);
        int i7 = i - 1;
        module(i7, i5, i3, 3);
        module(i7, i6, i3, 4);
        module(i7, i2, i3, 5);
        module(i, i5, i3, 6);
        module(i, i6, i3, 7);
        module(i, i2, i3, 8);
    }
}
