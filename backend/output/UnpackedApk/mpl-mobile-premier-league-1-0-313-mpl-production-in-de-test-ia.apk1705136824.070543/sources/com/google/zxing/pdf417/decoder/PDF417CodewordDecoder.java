package com.google.zxing.pdf417.decoder;

import com.google.android.material.resources.TextAppearanceConfig;
import com.google.zxing.pdf417.PDF417Common;
import java.lang.reflect.Array;

public final class PDF417CodewordDecoder {
    public static final float[][] RATIOS_TABLE;

    static {
        int i;
        int length = PDF417Common.SYMBOL_TABLE.length;
        int[] iArr = new int[2];
        iArr[1] = 8;
        iArr[0] = length;
        RATIOS_TABLE = (float[][]) Array.newInstance(float.class, iArr);
        int i2 = 0;
        while (true) {
            int[] iArr2 = PDF417Common.SYMBOL_TABLE;
            if (i2 < iArr2.length) {
                int i3 = iArr2[i2];
                int i4 = i3 & 1;
                int i5 = 0;
                while (i5 < 8) {
                    float f2 = 0.0f;
                    while (true) {
                        i = i3 & 1;
                        if (i != i4) {
                            break;
                        }
                        f2 += 1.0f;
                        i3 >>= 1;
                    }
                    RATIOS_TABLE[i2][(8 - i5) - 1] = f2 / 17.0f;
                    i5++;
                    i4 = i;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public static int getDecodedValue(int[] iArr) {
        float sum = (float) TextAppearanceConfig.sum(iArr);
        int[] iArr2 = new int[8];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 17; i3++) {
            if (((float) (iArr[i] + i2)) <= ((((float) i3) * sum) / 17.0f) + (sum / 34.0f)) {
                i2 += iArr[i];
                i++;
            }
            iArr2[i] = iArr2[i] + 1;
        }
        long j = 0;
        for (int i4 = 0; i4 < 8; i4++) {
            for (int i5 = 0; i5 < iArr2[i4]; i5++) {
                j = (j << 1) | ((long) (i4 % 2 == 0 ? 1 : 0));
            }
        }
        int i6 = (int) j;
        int i7 = -1;
        if (PDF417Common.getCodeword(i6) == -1) {
            i6 = -1;
        }
        if (i6 != -1) {
            return i6;
        }
        int sum2 = TextAppearanceConfig.sum(iArr);
        float[] fArr = new float[8];
        for (int i8 = 0; i8 < 8; i8++) {
            fArr[i8] = ((float) iArr[i8]) / ((float) sum2);
        }
        float f2 = Float.MAX_VALUE;
        int i9 = 0;
        while (true) {
            float[][] fArr2 = RATIOS_TABLE;
            if (i9 >= fArr2.length) {
                return i7;
            }
            float f3 = 0.0f;
            float[] fArr3 = fArr2[i9];
            for (int i10 = 0; i10 < 8; i10++) {
                float f4 = fArr3[i10] - fArr[i10];
                f3 += f4 * f4;
                if (f3 >= f2) {
                    break;
                }
            }
            if (f3 < f2) {
                i7 = PDF417Common.SYMBOL_TABLE[i9];
                f2 = f3;
            }
            i9++;
        }
    }
}
