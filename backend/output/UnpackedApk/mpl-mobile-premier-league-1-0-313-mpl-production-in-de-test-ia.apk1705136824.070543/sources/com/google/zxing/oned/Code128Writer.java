package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class Code128Writer extends OneDimensionalCodeWriter {

    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    public static CType findCType(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        int i2 = i + 1;
        if (i2 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i2);
        if (charAt2 < '0' || charAt2 > '9') {
            return CType.ONE_DIGIT;
        }
        return CType.TWO_DIGITS;
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0076, code lost:
        if (findCType(r14, r4 + 3) == com.google.zxing.oned.Code128Writer.CType.TWO_DIGITS) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0088, code lost:
        if (r11 == com.google.zxing.oned.Code128Writer.CType.ONE_DIGIT) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0099, code lost:
        if (r8 == com.google.zxing.oned.Code128Writer.CType.TWO_DIGITS) goto L_0x009e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x003e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean[] encode(java.lang.String r14) {
        /*
            r13 = this;
            int r0 = r14.length()
            if (r0 <= 0) goto L_0x012d
            r1 = 80
            if (r0 > r1) goto L_0x012d
            r1 = 0
            r2 = 0
        L_0x000c:
            r3 = 32
            if (r2 >= r0) goto L_0x0034
            char r4 = r14.charAt(r2)
            if (r4 < r3) goto L_0x001a
            r3 = 126(0x7e, float:1.77E-43)
            if (r4 <= r3) goto L_0x0031
        L_0x001a:
            switch(r4) {
                case 241: goto L_0x0031;
                case 242: goto L_0x0031;
                case 243: goto L_0x0031;
                case 244: goto L_0x0031;
                default: goto L_0x001d;
            }
        L_0x001d:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Bad character in input: "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        L_0x0031:
            int r2 = r2 + 1
            goto L_0x000c
        L_0x0034:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 1
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 1
        L_0x003e:
            if (r4 >= r0) goto L_0x00e7
            com.google.zxing.oned.Code128Writer$CType r8 = findCType(r14, r4)
            com.google.zxing.oned.Code128Writer$CType r9 = com.google.zxing.oned.Code128Writer.CType.UNCODABLE
            r10 = 100
            if (r8 == r9) goto L_0x009c
            com.google.zxing.oned.Code128Writer$CType r9 = com.google.zxing.oned.Code128Writer.CType.ONE_DIGIT
            if (r8 != r9) goto L_0x004f
            goto L_0x009c
        L_0x004f:
            r9 = 99
            if (r6 != r9) goto L_0x0054
            goto L_0x008b
        L_0x0054:
            if (r6 != r10) goto L_0x008d
            com.google.zxing.oned.Code128Writer$CType r11 = com.google.zxing.oned.Code128Writer.CType.FNC_1
            if (r8 != r11) goto L_0x005b
            goto L_0x008b
        L_0x005b:
            int r8 = r4 + 2
            com.google.zxing.oned.Code128Writer$CType r8 = findCType(r14, r8)
            com.google.zxing.oned.Code128Writer$CType r11 = com.google.zxing.oned.Code128Writer.CType.UNCODABLE
            if (r8 == r11) goto L_0x008b
            com.google.zxing.oned.Code128Writer$CType r11 = com.google.zxing.oned.Code128Writer.CType.ONE_DIGIT
            if (r8 != r11) goto L_0x006a
            goto L_0x008b
        L_0x006a:
            com.google.zxing.oned.Code128Writer$CType r11 = com.google.zxing.oned.Code128Writer.CType.FNC_1
            if (r8 != r11) goto L_0x0079
            int r8 = r4 + 3
            com.google.zxing.oned.Code128Writer$CType r8 = findCType(r14, r8)
            com.google.zxing.oned.Code128Writer$CType r11 = com.google.zxing.oned.Code128Writer.CType.TWO_DIGITS
            if (r8 != r11) goto L_0x009c
            goto L_0x009e
        L_0x0079:
            int r8 = r4 + 4
        L_0x007b:
            com.google.zxing.oned.Code128Writer$CType r11 = findCType(r14, r8)
            com.google.zxing.oned.Code128Writer$CType r12 = com.google.zxing.oned.Code128Writer.CType.TWO_DIGITS
            if (r11 != r12) goto L_0x0086
            int r8 = r8 + 2
            goto L_0x007b
        L_0x0086:
            com.google.zxing.oned.Code128Writer$CType r8 = com.google.zxing.oned.Code128Writer.CType.ONE_DIGIT
            if (r11 != r8) goto L_0x009e
            goto L_0x009c
        L_0x008b:
            r9 = r6
            goto L_0x009e
        L_0x008d:
            com.google.zxing.oned.Code128Writer$CType r11 = com.google.zxing.oned.Code128Writer.CType.FNC_1
            if (r8 != r11) goto L_0x0097
            int r8 = r4 + 1
            com.google.zxing.oned.Code128Writer$CType r8 = findCType(r14, r8)
        L_0x0097:
            com.google.zxing.oned.Code128Writer$CType r11 = com.google.zxing.oned.Code128Writer.CType.TWO_DIGITS
            if (r8 != r11) goto L_0x009c
            goto L_0x009e
        L_0x009c:
            r9 = 100
        L_0x009e:
            if (r9 != r6) goto L_0x00c7
            char r8 = r14.charAt(r4)
            switch(r8) {
                case 241: goto L_0x00b6;
                case 242: goto L_0x00b3;
                case 243: goto L_0x00b0;
                case 244: goto L_0x00c5;
                default: goto L_0x00a7;
            }
        L_0x00a7:
            if (r6 != r10) goto L_0x00b9
            char r8 = r14.charAt(r4)
            int r10 = r8 + -32
            goto L_0x00c5
        L_0x00b0:
            r10 = 96
            goto L_0x00c5
        L_0x00b3:
            r10 = 97
            goto L_0x00c5
        L_0x00b6:
            r10 = 102(0x66, float:1.43E-43)
            goto L_0x00c5
        L_0x00b9:
            int r8 = r4 + 2
            java.lang.String r8 = r14.substring(r4, r8)
            int r10 = java.lang.Integer.parseInt(r8)
            int r4 = r4 + 1
        L_0x00c5:
            int r4 = r4 + r3
            goto L_0x00d7
        L_0x00c7:
            if (r6 != 0) goto L_0x00d5
            if (r9 != r10) goto L_0x00d0
            r6 = 104(0x68, float:1.46E-43)
            r10 = 104(0x68, float:1.46E-43)
            goto L_0x00d6
        L_0x00d0:
            r6 = 105(0x69, float:1.47E-43)
            r10 = 105(0x69, float:1.47E-43)
            goto L_0x00d6
        L_0x00d5:
            r10 = r9
        L_0x00d6:
            r6 = r9
        L_0x00d7:
            int[][] r8 = com.google.zxing.oned.Code128Reader.CODE_PATTERNS
            r8 = r8[r10]
            r2.add(r8)
            int r10 = r10 * r7
            int r5 = r5 + r10
            if (r4 == 0) goto L_0x003e
            int r7 = r7 + 1
            goto L_0x003e
        L_0x00e7:
            int r5 = r5 % 103
            int[][] r14 = com.google.zxing.oned.Code128Reader.CODE_PATTERNS
            r14 = r14[r5]
            r2.add(r14)
            int[][] r14 = com.google.zxing.oned.Code128Reader.CODE_PATTERNS
            r0 = 106(0x6a, float:1.49E-43)
            r14 = r14[r0]
            r2.add(r14)
            java.util.Iterator r14 = r2.iterator()
            r0 = 0
        L_0x00fe:
            boolean r4 = r14.hasNext()
            if (r4 == 0) goto L_0x0114
            java.lang.Object r4 = r14.next()
            int[] r4 = (int[]) r4
            int r5 = r4.length
            r6 = 0
        L_0x010c:
            if (r6 >= r5) goto L_0x00fe
            r7 = r4[r6]
            int r0 = r0 + r7
            int r6 = r6 + 1
            goto L_0x010c
        L_0x0114:
            boolean[] r14 = new boolean[r0]
            java.util.Iterator r0 = r2.iterator()
        L_0x011a:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x012c
            java.lang.Object r2 = r0.next()
            int[] r2 = (int[]) r2
            int r2 = com.google.zxing.oned.OneDimensionalCodeWriter.appendPattern(r14, r1, r2, r3)
            int r1 = r1 + r2
            goto L_0x011a
        L_0x012c:
            return r14
        L_0x012d:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Contents length should be between 1 and 80 characters, but got "
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline40(r1, r0)
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Writer.encode(java.lang.String):boolean[]");
    }
}
