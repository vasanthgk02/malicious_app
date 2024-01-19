package com.google.zxing.oned;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public class Code93Writer extends OneDimensionalCodeWriter {
    public static int appendPattern(boolean[] zArr, int i, int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i + 1;
            zArr[i] = iArr[i2] != 0;
            i2++;
            i = i3;
        }
        return 9;
    }

    public static int computeChecksumIndex(String str, int i) {
        int i2 = 0;
        int i3 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i2 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i3;
            i3++;
            if (i3 > i) {
                i3 = 1;
            }
        }
        return i2 % 47;
    }

    public static void toIntArray(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) == 0) {
                i3 = 0;
            }
            iArr[i2] = i3;
        }
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_93) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got " + barcodeFormat);
    }

    public boolean[] encode(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            boolean[] zArr = new boolean[(((str.length() + 2 + 2) * 9) + 1)];
            toIntArray(Code93Reader.CHARACTER_ENCODINGS[47], iArr);
            appendPattern(zArr, 0, iArr);
            int i = 9;
            for (int i2 = 0; i2 < length; i2++) {
                toIntArray(Code93Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i2))], iArr);
                appendPattern(zArr, i, iArr);
                i += 9;
            }
            int computeChecksumIndex = computeChecksumIndex(str, 20);
            toIntArray(Code93Reader.CHARACTER_ENCODINGS[computeChecksumIndex], iArr);
            appendPattern(zArr, i, iArr);
            int i3 = i + 9;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73(str);
            outline73.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(computeChecksumIndex));
            toIntArray(Code93Reader.CHARACTER_ENCODINGS[computeChecksumIndex(outline73.toString(), 15)], iArr);
            appendPattern(zArr, i3, iArr);
            int i4 = i3 + 9;
            toIntArray(Code93Reader.CHARACTER_ENCODINGS[47], iArr);
            appendPattern(zArr, i4, iArr);
            zArr[i4 + 9] = true;
            return zArr;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline40("Requested contents should be less than 80 digits long, but got ", length));
    }
}
