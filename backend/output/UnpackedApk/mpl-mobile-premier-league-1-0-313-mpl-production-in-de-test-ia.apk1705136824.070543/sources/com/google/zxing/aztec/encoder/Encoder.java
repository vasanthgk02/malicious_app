package com.google.zxing.aztec.encoder;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

public final class Encoder {
    public static final int[] WORD_SIZE = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    public static void drawBullsEye(BitMatrix bitMatrix, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 > i6) {
                    break;
                }
                bitMatrix.set(i5, i4);
                bitMatrix.set(i5, i6);
                bitMatrix.set(i4, i5);
                bitMatrix.set(i6, i5);
                i5++;
            }
        }
        int i7 = i - i2;
        bitMatrix.set(i7, i7);
        int i8 = i7 + 1;
        bitMatrix.set(i8, i7);
        bitMatrix.set(i7, i8);
        int i9 = i + i2;
        bitMatrix.set(i9, i7);
        bitMatrix.set(i9, i8);
        bitMatrix.set(i9, i9 - 1);
    }

    public static BitArray generateCheckWords(BitArray bitArray, int i, int i2) {
        GenericGF genericGF;
        int i3 = bitArray.size / i2;
        if (i2 == 4) {
            genericGF = GenericGF.AZTEC_PARAM;
        } else if (i2 == 6) {
            genericGF = GenericGF.AZTEC_DATA_6;
        } else if (i2 == 8) {
            genericGF = GenericGF.AZTEC_DATA_8;
        } else if (i2 == 10) {
            genericGF = GenericGF.AZTEC_DATA_10;
        } else if (i2 == 12) {
            genericGF = GenericGF.AZTEC_DATA_12;
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline40("Unsupported word size ", i2));
        }
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(genericGF);
        int i4 = i / i2;
        int[] iArr = new int[i4];
        int i5 = bitArray.size / i2;
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < i2; i8++) {
                i7 |= bitArray.get((i6 * i2) + i8) ? 1 << ((i2 - i8) - 1) : 0;
            }
            iArr[i6] = i7;
        }
        reedSolomonEncoder.encode(iArr, i4 - i3);
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, i % i2);
        for (int i9 = 0; i9 < i4; i9++) {
            bitArray2.appendBits(iArr[i9], i2);
        }
        return bitArray2;
    }

    public static BitArray stuffBits(BitArray bitArray, int i) {
        BitArray bitArray2 = new BitArray();
        int i2 = bitArray.size;
        int i3 = (1 << i) - 2;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = 0;
            for (int i6 = 0; i6 < i; i6++) {
                int i7 = i4 + i6;
                if (i7 >= i2 || bitArray.get(i7)) {
                    i5 |= 1 << ((i - 1) - i6);
                }
            }
            int i8 = i5 & i3;
            if (i8 == i3) {
                bitArray2.appendBits(i8, i);
            } else if (i8 == 0) {
                bitArray2.appendBits(i5 | 1, i);
            } else {
                bitArray2.appendBits(i5, i);
                i4 += i;
            }
            i4--;
            i4 += i;
        }
        return bitArray2;
    }
}
