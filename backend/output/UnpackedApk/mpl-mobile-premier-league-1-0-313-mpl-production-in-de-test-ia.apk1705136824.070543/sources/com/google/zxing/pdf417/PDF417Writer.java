package com.google.zxing.pdf417;

import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import java.lang.reflect.Array;

public final class PDF417Writer implements Writer {
    public static BitMatrix bitMatrixFrombitArray(byte[][] bArr, int i) {
        int i2 = i * 2;
        BitMatrix bitMatrix = new BitMatrix(bArr[0].length + i2, bArr.length + i2);
        int length = bitMatrix.bits.length;
        for (int i3 = 0; i3 < length; i3++) {
            bitMatrix.bits[i3] = 0;
        }
        int i4 = (bitMatrix.height - i) - 1;
        int i5 = 0;
        while (i5 < bArr.length) {
            for (int i6 = 0; i6 < bArr[0].length; i6++) {
                if (bArr[i5][i6] == 1) {
                    bitMatrix.set(i6 + i, i4);
                }
            }
            i5++;
            i4--;
        }
        return bitMatrix;
    }

    public static byte[][] rotateArray(byte[][] bArr) {
        int length = bArr[0].length;
        int[] iArr = new int[2];
        iArr[1] = bArr.length;
        iArr[0] = length;
        byte[][] bArr2 = (byte[][]) Array.newInstance(byte.class, iArr);
        for (int i = 0; i < bArr.length; i++) {
            int length2 = (bArr.length - i) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length2] = bArr[i][i2];
            }
        }
        return bArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:88:0x0235 A[LOOP:6: B:87:0x0233->B:88:0x0235, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x025f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.common.BitMatrix encode(java.lang.String r19, com.google.zxing.BarcodeFormat r20, int r21, int r22, java.util.Map<com.google.zxing.EncodeHintType, ?> r23) throws com.google.zxing.WriterException {
        /*
            r18 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            com.google.zxing.BarcodeFormat r4 = com.google.zxing.BarcodeFormat.PDF_417
            if (r0 != r4) goto L_0x02e2
            com.google.zxing.pdf417.encoder.Compaction r0 = com.google.zxing.pdf417.encoder.Compaction.AUTO
            r4 = 0
            if (r3 == 0) goto L_0x00a9
            com.google.zxing.EncodeHintType r5 = com.google.zxing.EncodeHintType.PDF417_COMPACT
            boolean r5 = r3.containsKey(r5)
            if (r5 == 0) goto L_0x002c
            com.google.zxing.EncodeHintType r5 = com.google.zxing.EncodeHintType.PDF417_COMPACT
            java.lang.Object r5 = r3.get(r5)
            java.lang.String r5 = r5.toString()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            boolean r5 = r5.booleanValue()
            goto L_0x002d
        L_0x002c:
            r5 = 0
        L_0x002d:
            com.google.zxing.EncodeHintType r6 = com.google.zxing.EncodeHintType.PDF417_COMPACTION
            boolean r6 = r3.containsKey(r6)
            if (r6 == 0) goto L_0x0043
            com.google.zxing.EncodeHintType r0 = com.google.zxing.EncodeHintType.PDF417_COMPACTION
            java.lang.Object r0 = r3.get(r0)
            java.lang.String r0 = r0.toString()
            com.google.zxing.pdf417.encoder.Compaction r0 = com.google.zxing.pdf417.encoder.Compaction.valueOf(r0)
        L_0x0043:
            com.google.zxing.EncodeHintType r6 = com.google.zxing.EncodeHintType.PDF417_DIMENSIONS
            boolean r6 = r3.containsKey(r6)
            if (r6 == 0) goto L_0x005b
            com.google.zxing.EncodeHintType r6 = com.google.zxing.EncodeHintType.PDF417_DIMENSIONS
            java.lang.Object r6 = r3.get(r6)
            com.google.zxing.pdf417.encoder.Dimensions r6 = (com.google.zxing.pdf417.encoder.Dimensions) r6
            if (r6 == 0) goto L_0x005a
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            goto L_0x0061
        L_0x005a:
            throw r4
        L_0x005b:
            r6 = 2
            r7 = 30
            r8 = 2
            r9 = 30
        L_0x0061:
            com.google.zxing.EncodeHintType r10 = com.google.zxing.EncodeHintType.MARGIN
            boolean r10 = r3.containsKey(r10)
            if (r10 == 0) goto L_0x0078
            com.google.zxing.EncodeHintType r10 = com.google.zxing.EncodeHintType.MARGIN
            java.lang.Object r10 = r3.get(r10)
            java.lang.String r10 = r10.toString()
            int r10 = java.lang.Integer.parseInt(r10)
            goto L_0x007a
        L_0x0078:
            r10 = 30
        L_0x007a:
            com.google.zxing.EncodeHintType r11 = com.google.zxing.EncodeHintType.ERROR_CORRECTION
            boolean r11 = r3.containsKey(r11)
            if (r11 == 0) goto L_0x0091
            com.google.zxing.EncodeHintType r11 = com.google.zxing.EncodeHintType.ERROR_CORRECTION
            java.lang.Object r11 = r3.get(r11)
            java.lang.String r11 = r11.toString()
            int r11 = java.lang.Integer.parseInt(r11)
            goto L_0x0092
        L_0x0091:
            r11 = 2
        L_0x0092:
            com.google.zxing.EncodeHintType r12 = com.google.zxing.EncodeHintType.CHARACTER_SET
            boolean r12 = r3.containsKey(r12)
            if (r12 == 0) goto L_0x00b3
            com.google.zxing.EncodeHintType r4 = com.google.zxing.EncodeHintType.CHARACTER_SET
            java.lang.Object r3 = r3.get(r4)
            java.lang.String r3 = r3.toString()
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r3)
            goto L_0x00b3
        L_0x00a9:
            r5 = 0
            r6 = 2
            r7 = 30
            r8 = 2
            r9 = 30
            r10 = 30
            r11 = 2
        L_0x00b3:
            int r3 = com.google.zxing.pdf417.encoder.PDF417ErrorCorrection.getErrorCorrectionCodewordCount(r11)
            r12 = r19
            java.lang.String r0 = com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.encodeHighLevel(r12, r0, r4)
            int r4 = r0.length()
            r13 = 0
            r14 = 0
            r15 = r6
        L_0x00c4:
            if (r15 > r7) goto L_0x011b
            int r16 = r4 + 1
            int r16 = r16 + r3
            int r17 = r16 / r15
            int r17 = r17 + 1
            r20 = r7
            int r7 = r15 * r17
            int r12 = r16 + r15
            if (r7 < r12) goto L_0x00d8
            int r17 = r17 + -1
        L_0x00d8:
            r7 = r17
            if (r7 < r8) goto L_0x011b
            if (r7 > r9) goto L_0x0110
            int r12 = r15 * 17
            int r12 = r12 + 69
            float r12 = (float) r12
            r16 = 1052166324(0x3eb6c8b4, float:0.357)
            float r12 = r12 * r16
            r16 = r9
            float r9 = (float) r7
            r17 = 1073741824(0x40000000, float:2.0)
            float r9 = r9 * r17
            float r12 = r12 / r9
            if (r13 == 0) goto L_0x0104
            r9 = 1077936128(0x40400000, float:3.0)
            float r17 = r12 - r9
            float r17 = java.lang.Math.abs(r17)
            float r9 = r14 - r9
            float r9 = java.lang.Math.abs(r9)
            int r9 = (r17 > r9 ? 1 : (r17 == r9 ? 0 : -1))
            if (r9 > 0) goto L_0x0112
        L_0x0104:
            r9 = 2
            int[] r9 = new int[r9]
            r13 = 0
            r9[r13] = r15
            r13 = 1
            r9[r13] = r7
            r13 = r9
            r14 = r12
            goto L_0x0112
        L_0x0110:
            r16 = r9
        L_0x0112:
            int r15 = r15 + 1
            r12 = r19
            r7 = r20
            r9 = r16
            goto L_0x00c4
        L_0x011b:
            if (r13 != 0) goto L_0x0138
            int r7 = r4 + 1
            int r7 = r7 + r3
            int r9 = r7 / r6
            r12 = 1
            int r9 = r9 + r12
            int r14 = r6 * r9
            int r7 = r7 + r6
            if (r14 < r7) goto L_0x012b
            int r9 = r9 + -1
        L_0x012b:
            if (r9 >= r8) goto L_0x0136
            r7 = 2
            int[] r13 = new int[r7]
            r7 = 0
            r13[r7] = r6
            r13[r12] = r8
            goto L_0x013a
        L_0x0136:
            r7 = 0
            goto L_0x013a
        L_0x0138:
            r7 = 0
            r12 = 1
        L_0x013a:
            if (r13 == 0) goto L_0x02da
            r6 = r13[r7]
            r7 = r13[r12]
            int r8 = r6 * r7
            int r8 = r8 - r3
            int r9 = r4 + 1
            if (r8 <= r9) goto L_0x014b
            int r8 = r8 - r4
            int r8 = r8 + -1
            goto L_0x014c
        L_0x014b:
            r8 = 0
        L_0x014c:
            int r3 = r3 + r4
            int r3 = r3 + 1
            r9 = 929(0x3a1, float:1.302E-42)
            if (r3 > r9) goto L_0x02bd
            int r4 = r4 + r8
            int r4 = r4 + 1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            char r4 = (char) r4
            r3.append(r4)
            r3.append(r0)
            r0 = 0
        L_0x0163:
            if (r0 >= r8) goto L_0x016d
            r4 = 900(0x384, float:1.261E-42)
            r3.append(r4)
            int r0 = r0 + 1
            goto L_0x0163
        L_0x016d:
            java.lang.String r0 = r3.toString()
            int r3 = com.google.zxing.pdf417.encoder.PDF417ErrorCorrection.getErrorCorrectionCodewordCount(r11)
            char[] r4 = new char[r3]
            int r8 = r0.length()
            r12 = 0
        L_0x017c:
            if (r12 >= r8) goto L_0x01b5
            char r13 = r0.charAt(r12)
            int r14 = r3 + -1
            char r15 = r4[r14]
            int r13 = r13 + r15
            int r13 = r13 % r9
        L_0x0188:
            if (r14 <= 0) goto L_0x01a2
            int[][] r15 = com.google.zxing.pdf417.encoder.PDF417ErrorCorrection.EC_COEFFICIENTS
            r15 = r15[r11]
            r15 = r15[r14]
            int r15 = r15 * r13
            int r15 = r15 % r9
            int r15 = 929 - r15
            int r16 = r14 + -1
            char r17 = r4[r16]
            int r15 = r17 + r15
            int r15 = r15 % r9
            char r15 = (char) r15
            r4[r14] = r15
            r14 = r16
            goto L_0x0188
        L_0x01a2:
            int[][] r14 = com.google.zxing.pdf417.encoder.PDF417ErrorCorrection.EC_COEFFICIENTS
            r14 = r14[r11]
            r15 = 0
            r14 = r14[r15]
            int r13 = r13 * r14
            int r13 = r13 % r9
            int r13 = 929 - r13
            int r13 = r13 % r9
            char r13 = (char) r13
            r4[r15] = r13
            int r12 = r12 + 1
            goto L_0x017c
        L_0x01b5:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r3)
        L_0x01ba:
            int r3 = r3 + -1
            if (r3 < 0) goto L_0x01cf
            char r9 = r4[r3]
            if (r9 == 0) goto L_0x01c9
            char r9 = r4[r3]
            int r9 = 929 - r9
            char r9 = (char) r9
            r4[r3] = r9
        L_0x01c9:
            char r9 = r4[r3]
            r8.append(r9)
            goto L_0x01ba
        L_0x01cf:
            java.lang.String r3 = r8.toString()
            com.google.zxing.pdf417.encoder.BarcodeMatrix r4 = new com.google.zxing.pdf417.encoder.BarcodeMatrix
            r4.<init>(r7, r6)
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r0, r3)
            r3 = 0
            r8 = 0
        L_0x01de:
            if (r3 >= r7) goto L_0x027b
            int r9 = r3 % 3
            int r12 = r4.currentRow
            int r12 = r12 + 1
            r4.currentRow = r12
            r12 = 130728(0x1fea8, float:1.83189E-40)
            com.google.zxing.pdf417.encoder.BarcodeRow r13 = r4.getCurrentRow()
            r14 = 17
            com.google.zxing.pdf417.encoder.PDF417.encodeChar(r12, r14, r13)
            if (r9 != 0) goto L_0x0202
            int r12 = r3 / 3
            int r12 = r12 * 30
            int r13 = r7 + -1
            int r13 = r13 / 3
            int r13 = r13 + r12
            int r15 = r6 + -1
            goto L_0x0214
        L_0x0202:
            r12 = 1
            if (r9 != r12) goto L_0x0216
            int r12 = r3 / 3
            int r12 = r12 * 30
            int r13 = r11 * 3
            int r13 = r13 + r12
            int r15 = r7 + -1
            int r16 = r15 % 3
            int r13 = r16 + r13
            int r15 = r15 / 3
        L_0x0214:
            int r15 = r15 + r12
            goto L_0x0225
        L_0x0216:
            int r12 = r3 / 3
            int r12 = r12 * 30
            int r13 = r6 + -1
            int r13 = r13 + r12
            int r15 = r11 * 3
            int r15 = r15 + r12
            int r12 = r7 + -1
            int r12 = r12 % 3
            int r15 = r15 + r12
        L_0x0225:
            int[][] r12 = com.google.zxing.pdf417.encoder.PDF417.CODEWORD_TABLE
            r12 = r12[r9]
            r12 = r12[r13]
            com.google.zxing.pdf417.encoder.BarcodeRow r13 = r4.getCurrentRow()
            com.google.zxing.pdf417.encoder.PDF417.encodeChar(r12, r14, r13)
            r12 = 0
        L_0x0233:
            if (r12 >= r6) goto L_0x024f
            int[][] r13 = com.google.zxing.pdf417.encoder.PDF417.CODEWORD_TABLE
            r13 = r13[r9]
            char r16 = r0.charAt(r8)
            r13 = r13[r16]
            r19 = r0
            com.google.zxing.pdf417.encoder.BarcodeRow r0 = r4.getCurrentRow()
            com.google.zxing.pdf417.encoder.PDF417.encodeChar(r13, r14, r0)
            int r8 = r8 + 1
            int r12 = r12 + 1
            r0 = r19
            goto L_0x0233
        L_0x024f:
            r19 = r0
            r0 = 260649(0x3fa29, float:3.65247E-40)
            if (r5 == 0) goto L_0x025f
            com.google.zxing.pdf417.encoder.BarcodeRow r9 = r4.getCurrentRow()
            r12 = 1
            com.google.zxing.pdf417.encoder.PDF417.encodeChar(r0, r12, r9)
            goto L_0x0275
        L_0x025f:
            int[][] r12 = com.google.zxing.pdf417.encoder.PDF417.CODEWORD_TABLE
            r9 = r12[r9]
            r9 = r9[r15]
            com.google.zxing.pdf417.encoder.BarcodeRow r12 = r4.getCurrentRow()
            com.google.zxing.pdf417.encoder.PDF417.encodeChar(r9, r14, r12)
            r9 = 18
            com.google.zxing.pdf417.encoder.BarcodeRow r12 = r4.getCurrentRow()
            com.google.zxing.pdf417.encoder.PDF417.encodeChar(r0, r9, r12)
        L_0x0275:
            int r3 = r3 + 1
            r0 = r19
            goto L_0x01de
        L_0x027b:
            r0 = 4
            r3 = 1
            byte[][] r0 = r4.getScaledMatrix(r3, r0)
            r3 = 0
            if (r2 <= r1) goto L_0x0286
            r5 = 1
            goto L_0x0287
        L_0x0286:
            r5 = 0
        L_0x0287:
            r6 = r0[r3]
            int r6 = r6.length
            int r7 = r0.length
            if (r6 >= r7) goto L_0x028f
            r6 = 1
            goto L_0x0290
        L_0x028f:
            r6 = 0
        L_0x0290:
            r5 = r5 ^ r6
            if (r5 == 0) goto L_0x0299
            byte[][] r0 = rotateArray(r0)
            r5 = 1
            goto L_0x029a
        L_0x0299:
            r5 = 0
        L_0x029a:
            r3 = r0[r3]
            int r3 = r3.length
            int r1 = r1 / r3
            int r3 = r0.length
            int r2 = r2 / r3
            if (r1 >= r2) goto L_0x02a3
            goto L_0x02a4
        L_0x02a3:
            r1 = r2
        L_0x02a4:
            r2 = 1
            if (r1 <= r2) goto L_0x02b8
            int r0 = r1 << 2
            byte[][] r0 = r4.getScaledMatrix(r1, r0)
            if (r5 == 0) goto L_0x02b3
            byte[][] r0 = rotateArray(r0)
        L_0x02b3:
            com.google.zxing.common.BitMatrix r0 = bitMatrixFrombitArray(r0, r10)
            goto L_0x02bc
        L_0x02b8:
            com.google.zxing.common.BitMatrix r0 = bitMatrixFrombitArray(r0, r10)
        L_0x02bc:
            return r0
        L_0x02bd:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Encoded message contains too many code words, message too big ("
            r1.<init>(r2)
            int r2 = r19.length()
            r1.append(r2)
            java.lang.String r2 = " bytes)"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x02da:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Unable to fit message in columns"
            r0.<init>(r1)
            throw r0
        L_0x02e2:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Can only encode PDF_417, but got "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.PDF417Writer.encode(java.lang.String, com.google.zxing.BarcodeFormat, int, int, java.util.Map):com.google.zxing.common.BitMatrix");
    }
}
