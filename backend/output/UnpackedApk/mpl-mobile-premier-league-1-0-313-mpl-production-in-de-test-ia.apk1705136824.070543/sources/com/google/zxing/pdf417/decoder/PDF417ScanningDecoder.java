package com.google.zxing.pdf417.decoder;

import com.google.android.material.resources.TextAppearanceConfig;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417Common;
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection;
import com.google.zxing.pdf417.decoder.ec.ModulusGF;
import com.google.zxing.pdf417.decoder.ec.ModulusPoly;

public final class PDF417ScanningDecoder {
    public static final ErrorCorrection errorCorrection = new ErrorCorrection();

    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.zxing.pdf417.decoder.BoundingBox adjustBoundingBox(com.google.zxing.pdf417.decoder.DetectionResultRowIndicatorColumn r15) throws com.google.zxing.NotFoundException {
        /*
            r0 = 0
            if (r15 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.google.zxing.pdf417.decoder.BarcodeMetadata r1 = r15.getBarcodeMetadata()
            r2 = -1
            r3 = 0
            r4 = 1
            if (r1 != 0) goto L_0x0010
            r5 = r0
            goto L_0x007a
        L_0x0010:
            com.google.zxing.pdf417.decoder.BoundingBox r5 = r15.boundingBox
            boolean r6 = r15.isLeft
            if (r6 == 0) goto L_0x0019
            com.google.zxing.ResultPoint r6 = r5.topLeft
            goto L_0x001b
        L_0x0019:
            com.google.zxing.ResultPoint r6 = r5.topRight
        L_0x001b:
            boolean r7 = r15.isLeft
            if (r7 == 0) goto L_0x0022
            com.google.zxing.ResultPoint r5 = r5.bottomLeft
            goto L_0x0024
        L_0x0022:
            com.google.zxing.ResultPoint r5 = r5.bottomRight
        L_0x0024:
            float r6 = r6.y
            int r6 = (int) r6
            int r6 = r15.imageRowToCodewordIndex(r6)
            float r5 = r5.y
            int r5 = (int) r5
            int r5 = r15.imageRowToCodewordIndex(r5)
            com.google.zxing.pdf417.decoder.Codeword[] r7 = r15.codewords
            r8 = -1
            r9 = 0
            r10 = 1
        L_0x0037:
            if (r6 >= r5) goto L_0x0060
            r11 = r7[r6]
            if (r11 == 0) goto L_0x005d
            r11 = r7[r6]
            r11.setRowNumberAsRowIndicatorColumn()
            int r12 = r11.rowNumber
            int r13 = r12 - r8
            if (r13 != 0) goto L_0x004b
            int r9 = r9 + 1
            goto L_0x005d
        L_0x004b:
            if (r13 != r4) goto L_0x0054
            int r10 = java.lang.Math.max(r10, r9)
            int r8 = r11.rowNumber
            goto L_0x005c
        L_0x0054:
            int r11 = r1.rowCount
            if (r12 < r11) goto L_0x005b
            r7[r6] = r0
            goto L_0x005d
        L_0x005b:
            r8 = r12
        L_0x005c:
            r9 = 1
        L_0x005d:
            int r6 = r6 + 1
            goto L_0x0037
        L_0x0060:
            int r1 = r1.rowCount
            int[] r5 = new int[r1]
            com.google.zxing.pdf417.decoder.Codeword[] r6 = r15.codewords
            int r7 = r6.length
            r8 = 0
        L_0x0068:
            if (r8 >= r7) goto L_0x007a
            r9 = r6[r8]
            if (r9 == 0) goto L_0x0077
            int r9 = r9.rowNumber
            if (r9 >= r1) goto L_0x0077
            r10 = r5[r9]
            int r10 = r10 + r4
            r5[r9] = r10
        L_0x0077:
            int r8 = r8 + 1
            goto L_0x0068
        L_0x007a:
            if (r5 != 0) goto L_0x007d
            return r0
        L_0x007d:
            int r0 = r5.length
            r1 = 0
            r6 = -1
        L_0x0080:
            if (r1 >= r0) goto L_0x008b
            r7 = r5[r1]
            int r6 = java.lang.Math.max(r6, r7)
            int r1 = r1 + 1
            goto L_0x0080
        L_0x008b:
            int r0 = r5.length
            r1 = 0
            r7 = 0
        L_0x008e:
            if (r1 >= r0) goto L_0x009a
            r8 = r5[r1]
            int r9 = r6 - r8
            int r7 = r7 + r9
            if (r8 > 0) goto L_0x009a
            int r1 = r1 + 1
            goto L_0x008e
        L_0x009a:
            com.google.zxing.pdf417.decoder.Codeword[] r0 = r15.codewords
            r1 = 0
        L_0x009d:
            if (r7 <= 0) goto L_0x00a8
            r8 = r0[r1]
            if (r8 != 0) goto L_0x00a8
            int r7 = r7 + -1
            int r1 = r1 + 1
            goto L_0x009d
        L_0x00a8:
            int r1 = r5.length
            int r1 = r1 - r4
            r8 = 0
        L_0x00ab:
            if (r1 < 0) goto L_0x00b9
            r9 = r5[r1]
            int r9 = r6 - r9
            int r8 = r8 + r9
            r9 = r5[r1]
            if (r9 > 0) goto L_0x00b9
            int r1 = r1 + -1
            goto L_0x00ab
        L_0x00b9:
            int r1 = r0.length
            int r1 = r1 - r4
        L_0x00bb:
            if (r8 <= 0) goto L_0x00c6
            r4 = r0[r1]
            if (r4 != 0) goto L_0x00c6
            int r8 = r8 + -1
            int r1 = r1 + -1
            goto L_0x00bb
        L_0x00c6:
            com.google.zxing.pdf417.decoder.BoundingBox r0 = r15.boundingBox
            boolean r15 = r15.isLeft
            com.google.zxing.ResultPoint r1 = r0.topLeft
            com.google.zxing.ResultPoint r4 = r0.bottomLeft
            com.google.zxing.ResultPoint r5 = r0.topRight
            com.google.zxing.ResultPoint r6 = r0.bottomRight
            if (r7 <= 0) goto L_0x00f0
            if (r15 == 0) goto L_0x00d8
            r9 = r1
            goto L_0x00d9
        L_0x00d8:
            r9 = r5
        L_0x00d9:
            float r10 = r9.y
            int r10 = (int) r10
            int r10 = r10 - r7
            if (r10 >= 0) goto L_0x00e0
            goto L_0x00e1
        L_0x00e0:
            r3 = r10
        L_0x00e1:
            com.google.zxing.ResultPoint r7 = new com.google.zxing.ResultPoint
            float r9 = r9.x
            float r3 = (float) r3
            r7.<init>(r9, r3)
            if (r15 == 0) goto L_0x00ed
            r1 = r7
            goto L_0x00f0
        L_0x00ed:
            r11 = r1
            r13 = r7
            goto L_0x00f2
        L_0x00f0:
            r11 = r1
            r13 = r5
        L_0x00f2:
            if (r8 <= 0) goto L_0x0116
            if (r15 == 0) goto L_0x00f9
            com.google.zxing.ResultPoint r1 = r0.bottomLeft
            goto L_0x00fb
        L_0x00f9:
            com.google.zxing.ResultPoint r1 = r0.bottomRight
        L_0x00fb:
            float r3 = r1.y
            int r3 = (int) r3
            int r3 = r3 + r8
            com.google.zxing.common.BitMatrix r5 = r0.image
            int r5 = r5.height
            if (r3 < r5) goto L_0x0107
            int r3 = r5 + -1
        L_0x0107:
            com.google.zxing.ResultPoint r2 = new com.google.zxing.ResultPoint
            float r1 = r1.x
            float r3 = (float) r3
            r2.<init>(r1, r3)
            if (r15 == 0) goto L_0x0113
            r4 = r2
            goto L_0x0116
        L_0x0113:
            r14 = r2
            r12 = r4
            goto L_0x0118
        L_0x0116:
            r12 = r4
            r14 = r6
        L_0x0118:
            r0.calculateMinMaxValues()
            com.google.zxing.pdf417.decoder.BoundingBox r15 = new com.google.zxing.pdf417.decoder.BoundingBox
            com.google.zxing.common.BitMatrix r10 = r0.image
            r9 = r15
            r9.<init>(r10, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.adjustBoundingBox(com.google.zxing.pdf417.decoder.DetectionResultRowIndicatorColumn):com.google.zxing.pdf417.decoder.BoundingBox");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005f, code lost:
        if (r5.rowCount == r7.rowCount) goto L_0x006a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x00b9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.zxing.common.DecoderResult decode(com.google.zxing.common.BitMatrix r23, com.google.zxing.ResultPoint r24, com.google.zxing.ResultPoint r25, com.google.zxing.ResultPoint r26, com.google.zxing.ResultPoint r27, int r28, int r29) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
            com.google.zxing.pdf417.decoder.BoundingBox r6 = new com.google.zxing.pdf417.decoder.BoundingBox
            r0 = r6
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r26
            r5 = r27
            r0.<init>(r1, r2, r3, r4, r5)
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x0015:
            r13 = 2
            if (r2 >= r13) goto L_0x00bc
            if (r24 == 0) goto L_0x0028
            r10 = 1
            r7 = r23
            r8 = r6
            r9 = r24
            r11 = r28
            r12 = r29
            com.google.zxing.pdf417.decoder.DetectionResultRowIndicatorColumn r3 = getRowIndicatorColumn(r7, r8, r9, r10, r11, r12)
        L_0x0028:
            if (r26 == 0) goto L_0x0038
            r10 = 0
            r7 = r23
            r8 = r6
            r9 = r26
            r11 = r28
            r12 = r29
            com.google.zxing.pdf417.decoder.DetectionResultRowIndicatorColumn r4 = getRowIndicatorColumn(r7, r8, r9, r10, r11, r12)
        L_0x0038:
            if (r3 != 0) goto L_0x003d
            if (r4 != 0) goto L_0x003d
            goto L_0x006c
        L_0x003d:
            if (r3 == 0) goto L_0x0062
            com.google.zxing.pdf417.decoder.BarcodeMetadata r5 = r3.getBarcodeMetadata()
            if (r5 != 0) goto L_0x0046
            goto L_0x0062
        L_0x0046:
            if (r4 == 0) goto L_0x006a
            com.google.zxing.pdf417.decoder.BarcodeMetadata r7 = r4.getBarcodeMetadata()
            if (r7 != 0) goto L_0x004f
            goto L_0x006a
        L_0x004f:
            int r8 = r5.columnCount
            int r9 = r7.columnCount
            if (r8 == r9) goto L_0x006a
            int r8 = r5.errorCorrectionLevel
            int r9 = r7.errorCorrectionLevel
            if (r8 == r9) goto L_0x006a
            int r8 = r5.rowCount
            int r7 = r7.rowCount
            if (r8 == r7) goto L_0x006a
            goto L_0x0064
        L_0x0062:
            if (r4 != 0) goto L_0x0066
        L_0x0064:
            r5 = 0
            goto L_0x006a
        L_0x0066:
            com.google.zxing.pdf417.decoder.BarcodeMetadata r5 = r4.getBarcodeMetadata()
        L_0x006a:
            if (r5 != 0) goto L_0x006e
        L_0x006c:
            r5 = 0
            goto L_0x009c
        L_0x006e:
            com.google.zxing.pdf417.decoder.BoundingBox r7 = adjustBoundingBox(r3)
            com.google.zxing.pdf417.decoder.BoundingBox r8 = adjustBoundingBox(r4)
            if (r7 != 0) goto L_0x007a
            r7 = r8
            goto L_0x0096
        L_0x007a:
            if (r8 != 0) goto L_0x007d
            goto L_0x0096
        L_0x007d:
            com.google.zxing.pdf417.decoder.BoundingBox r9 = new com.google.zxing.pdf417.decoder.BoundingBox
            com.google.zxing.common.BitMatrix r15 = r7.image
            com.google.zxing.ResultPoint r10 = r7.topLeft
            com.google.zxing.ResultPoint r7 = r7.bottomLeft
            com.google.zxing.ResultPoint r11 = r8.topRight
            com.google.zxing.ResultPoint r8 = r8.bottomRight
            r14 = r9
            r16 = r10
            r17 = r7
            r18 = r11
            r19 = r8
            r14.<init>(r15, r16, r17, r18, r19)
            r7 = r9
        L_0x0096:
            com.google.zxing.pdf417.decoder.DetectionResult r8 = new com.google.zxing.pdf417.decoder.DetectionResult
            r8.<init>(r5, r7)
            r5 = r8
        L_0x009c:
            if (r5 == 0) goto L_0x00b9
            if (r2 != 0) goto L_0x00b6
            com.google.zxing.pdf417.decoder.BoundingBox r7 = r5.boundingBox
            if (r7 == 0) goto L_0x00b6
            int r8 = r7.minY
            int r9 = r6.minY
            if (r8 < r9) goto L_0x00b0
            int r7 = r7.maxY
            int r8 = r6.maxY
            if (r7 <= r8) goto L_0x00b6
        L_0x00b0:
            com.google.zxing.pdf417.decoder.BoundingBox r6 = r5.boundingBox
            int r2 = r2 + 1
            goto L_0x0015
        L_0x00b6:
            r5.boundingBox = r6
            goto L_0x00bc
        L_0x00b9:
            com.google.zxing.NotFoundException r0 = com.google.zxing.NotFoundException.INSTANCE
            throw r0
        L_0x00bc:
            int r2 = r5.barcodeColumnCount
            r7 = 1
            int r2 = r2 + r7
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r8 = r5.detectionResultColumns
            r8[r1] = r3
            r8[r2] = r4
            if (r3 == 0) goto L_0x00ca
            r3 = 1
            goto L_0x00cb
        L_0x00ca:
            r3 = 0
        L_0x00cb:
            r4 = r28
            r8 = r29
            r9 = 1
        L_0x00d0:
            if (r9 > r2) goto L_0x01f5
            if (r3 == 0) goto L_0x00d6
            r11 = r9
            goto L_0x00d8
        L_0x00d6:
            int r11 = r2 - r9
        L_0x00d8:
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r12 = r5.detectionResultColumns
            r12 = r12[r11]
            if (r12 != 0) goto L_0x01ea
            if (r11 == 0) goto L_0x00e9
            if (r11 != r2) goto L_0x00e3
            goto L_0x00e9
        L_0x00e3:
            com.google.zxing.pdf417.decoder.DetectionResultColumn r12 = new com.google.zxing.pdf417.decoder.DetectionResultColumn
            r12.<init>(r6)
            goto L_0x00f3
        L_0x00e9:
            com.google.zxing.pdf417.decoder.DetectionResultRowIndicatorColumn r12 = new com.google.zxing.pdf417.decoder.DetectionResultRowIndicatorColumn
            if (r11 != 0) goto L_0x00ef
            r14 = 1
            goto L_0x00f0
        L_0x00ef:
            r14 = 0
        L_0x00f0:
            r12.<init>(r6, r14)
        L_0x00f3:
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r14 = r5.detectionResultColumns
            r14[r11] = r12
            int r14 = r6.minY
            r15 = r14
            r14 = -1
        L_0x00fb:
            int r0 = r6.maxY
            if (r15 > r0) goto L_0x01ea
            if (r3 == 0) goto L_0x0103
            r0 = 1
            goto L_0x0104
        L_0x0103:
            r0 = -1
        L_0x0104:
            int r1 = r11 - r0
            boolean r16 = isValidBarcodeColumn(r5, r1)
            if (r16 == 0) goto L_0x011b
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r7 = r5.detectionResultColumns
            r7 = r7[r1]
            com.google.zxing.pdf417.decoder.Codeword[] r13 = r7.codewords
            com.google.zxing.pdf417.decoder.BoundingBox r7 = r7.boundingBox
            int r7 = r7.minY
            int r7 = r15 - r7
            r7 = r13[r7]
            goto L_0x011c
        L_0x011b:
            r7 = 0
        L_0x011c:
            if (r7 == 0) goto L_0x0126
            if (r3 == 0) goto L_0x0123
            int r0 = r7.endX
            goto L_0x014f
        L_0x0123:
            int r0 = r7.startX
            goto L_0x014f
        L_0x0126:
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r7 = r5.detectionResultColumns
            r7 = r7[r11]
            com.google.zxing.pdf417.decoder.Codeword r7 = r7.getCodewordNearby(r15)
            if (r7 == 0) goto L_0x0138
            if (r3 == 0) goto L_0x0135
            int r0 = r7.startX
            goto L_0x014f
        L_0x0135:
            int r0 = r7.endX
            goto L_0x014f
        L_0x0138:
            boolean r13 = isValidBarcodeColumn(r5, r1)
            if (r13 == 0) goto L_0x0146
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r7 = r5.detectionResultColumns
            r1 = r7[r1]
            com.google.zxing.pdf417.decoder.Codeword r7 = r1.getCodewordNearby(r15)
        L_0x0146:
            if (r7 == 0) goto L_0x0152
            if (r3 == 0) goto L_0x014d
            int r0 = r7.endX
            goto L_0x014f
        L_0x014d:
            int r0 = r7.startX
        L_0x014f:
            r22 = r2
            goto L_0x0199
        L_0x0152:
            r7 = r11
            r1 = 0
        L_0x0154:
            int r7 = r7 - r0
            boolean r13 = isValidBarcodeColumn(r5, r7)
            if (r13 == 0) goto L_0x018c
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r13 = r5.detectionResultColumns
            r13 = r13[r7]
            com.google.zxing.pdf417.decoder.Codeword[] r13 = r13.codewords
            int r10 = r13.length
            r22 = r2
            r2 = 0
        L_0x0165:
            if (r2 >= r10) goto L_0x0185
            r28 = r7
            r7 = r13[r2]
            if (r7 == 0) goto L_0x0180
            if (r3 == 0) goto L_0x0172
            int r2 = r7.endX
            goto L_0x0174
        L_0x0172:
            int r2 = r7.startX
        L_0x0174:
            int r0 = r0 * r1
            int r1 = r7.endX
            int r7 = r7.startX
            int r1 = r1 - r7
            int r1 = r1 * r0
            int r0 = r1 + r2
            goto L_0x0199
        L_0x0180:
            int r2 = r2 + 1
            r7 = r28
            goto L_0x0165
        L_0x0185:
            r28 = r7
            int r1 = r1 + 1
            r2 = r22
            goto L_0x0154
        L_0x018c:
            r22 = r2
            if (r3 == 0) goto L_0x0195
            com.google.zxing.pdf417.decoder.BoundingBox r0 = r5.boundingBox
            int r0 = r0.minX
            goto L_0x0199
        L_0x0195:
            com.google.zxing.pdf417.decoder.BoundingBox r0 = r5.boundingBox
            int r0 = r0.maxX
        L_0x0199:
            if (r0 < 0) goto L_0x019f
            int r1 = r6.maxX
            if (r0 <= r1) goto L_0x01a3
        L_0x019f:
            r0 = -1
            if (r14 == r0) goto L_0x01de
            r0 = r14
        L_0x01a3:
            int r1 = r6.minX
            int r2 = r6.maxX
            r10 = r14
            r14 = r23
            r7 = r15
            r15 = r1
            r16 = r2
            r17 = r3
            r18 = r0
            r19 = r7
            r20 = r4
            r21 = r8
            com.google.zxing.pdf417.decoder.Codeword r1 = detectCodeword(r14, r15, r16, r17, r18, r19, r20, r21)
            if (r1 == 0) goto L_0x01e0
            com.google.zxing.pdf417.decoder.Codeword[] r2 = r12.codewords
            com.google.zxing.pdf417.decoder.BoundingBox r10 = r12.boundingBox
            int r10 = r10.minY
            int r15 = r7 - r10
            r2[r15] = r1
            int r2 = r1.endX
            int r10 = r1.startX
            int r2 = r2 - r10
            int r2 = java.lang.Math.min(r4, r2)
            int r4 = r1.endX
            int r1 = r1.startX
            int r4 = r4 - r1
            int r1 = java.lang.Math.max(r8, r4)
            r14 = r0
            r8 = r1
            r4 = r2
            goto L_0x01e1
        L_0x01de:
            r10 = r14
            r7 = r15
        L_0x01e0:
            r14 = r10
        L_0x01e1:
            int r15 = r7 + 1
            r2 = r22
            r1 = 0
            r7 = 1
            r13 = 2
            goto L_0x00fb
        L_0x01ea:
            r22 = r2
            int r9 = r9 + 1
            r2 = r22
            r1 = 0
            r7 = 1
            r13 = 2
            goto L_0x00d0
        L_0x01f5:
            com.google.zxing.pdf417.decoder.BarcodeMetadata r0 = r5.barcodeMetadata
            int r0 = r0.rowCount
            int r1 = r5.barcodeColumnCount
            r2 = 2
            int r1 = r1 + r2
            int[] r3 = new int[r2]
            r2 = 1
            r3[r2] = r1
            r1 = 0
            r3[r1] = r0
            java.lang.Class<com.google.zxing.pdf417.decoder.BarcodeValue> r0 = com.google.zxing.pdf417.decoder.BarcodeValue.class
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r0, r3)
            com.google.zxing.pdf417.decoder.BarcodeValue[][] r0 = (com.google.zxing.pdf417.decoder.BarcodeValue[][]) r0
            r1 = 0
        L_0x020e:
            int r2 = r0.length
            if (r1 >= r2) goto L_0x0226
            r2 = 0
        L_0x0212:
            r3 = r0[r1]
            int r3 = r3.length
            if (r2 >= r3) goto L_0x0223
            r3 = r0[r1]
            com.google.zxing.pdf417.decoder.BarcodeValue r4 = new com.google.zxing.pdf417.decoder.BarcodeValue
            r4.<init>()
            r3[r2] = r4
            int r2 = r2 + 1
            goto L_0x0212
        L_0x0223:
            int r1 = r1 + 1
            goto L_0x020e
        L_0x0226:
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r1 = r5.detectionResultColumns
            r2 = 0
            r1 = r1[r2]
            r5.adjustIndicatorColumnRowNumbers(r1)
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r1 = r5.detectionResultColumns
            int r3 = r5.barcodeColumnCount
            r4 = 1
            int r3 = r3 + r4
            r1 = r1[r3]
            r5.adjustIndicatorColumnRowNumbers(r1)
            r1 = 928(0x3a0, float:1.3E-42)
            r3 = 928(0x3a0, float:1.3E-42)
        L_0x023d:
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r6 = r5.detectionResultColumns
            r7 = r6[r2]
            if (r7 == 0) goto L_0x0296
            int r7 = r5.barcodeColumnCount
            int r7 = r7 + r4
            r4 = r6[r7]
            if (r4 != 0) goto L_0x024b
            goto L_0x0296
        L_0x024b:
            r4 = r6[r2]
            com.google.zxing.pdf417.decoder.Codeword[] r2 = r4.codewords
            r4 = r6[r7]
            com.google.zxing.pdf417.decoder.Codeword[] r4 = r4.codewords
            r6 = 0
        L_0x0254:
            int r7 = r2.length
            if (r6 >= r7) goto L_0x0296
            r7 = r2[r6]
            if (r7 == 0) goto L_0x0292
            r7 = r4[r6]
            if (r7 == 0) goto L_0x0292
            r7 = r2[r6]
            int r7 = r7.rowNumber
            r8 = r4[r6]
            int r8 = r8.rowNumber
            if (r7 != r8) goto L_0x0292
            r7 = 1
        L_0x026a:
            int r8 = r5.barcodeColumnCount
            if (r7 > r8) goto L_0x0292
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r8 = r5.detectionResultColumns
            r8 = r8[r7]
            com.google.zxing.pdf417.decoder.Codeword[] r8 = r8.codewords
            r8 = r8[r6]
            if (r8 == 0) goto L_0x028e
            r9 = r2[r6]
            int r9 = r9.rowNumber
            r8.rowNumber = r9
            boolean r8 = r8.hasValidRowNumber()
            if (r8 != 0) goto L_0x028e
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r8 = r5.detectionResultColumns
            r8 = r8[r7]
            com.google.zxing.pdf417.decoder.Codeword[] r8 = r8.codewords
            r9 = 0
            r8[r6] = r9
            goto L_0x028f
        L_0x028e:
            r9 = 0
        L_0x028f:
            int r7 = r7 + 1
            goto L_0x026a
        L_0x0292:
            r9 = 0
            int r6 = r6 + 1
            goto L_0x0254
        L_0x0296:
            r9 = 0
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r2 = r5.detectionResultColumns
            r4 = 0
            r6 = r2[r4]
            if (r6 != 0) goto L_0x029f
            goto L_0x02da
        L_0x029f:
            r2 = r2[r4]
            com.google.zxing.pdf417.decoder.Codeword[] r2 = r2.codewords
            r4 = 0
            r6 = 0
        L_0x02a5:
            int r7 = r2.length
            if (r4 >= r7) goto L_0x02d9
            r7 = r2[r4]
            if (r7 == 0) goto L_0x02d6
            r7 = r2[r4]
            int r7 = r7.rowNumber
            r10 = r6
            r6 = 1
            r8 = 0
        L_0x02b3:
            int r11 = r5.barcodeColumnCount
            r12 = 1
            int r11 = r11 + r12
            if (r6 >= r11) goto L_0x02d5
            r11 = 2
            if (r8 >= r11) goto L_0x02d5
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r11 = r5.detectionResultColumns
            r11 = r11[r6]
            com.google.zxing.pdf417.decoder.Codeword[] r11 = r11.codewords
            r11 = r11[r4]
            if (r11 == 0) goto L_0x02d2
            int r8 = com.google.zxing.pdf417.decoder.DetectionResult.adjustRowNumberIfValid(r7, r8, r11)
            boolean r11 = r11.hasValidRowNumber()
            if (r11 != 0) goto L_0x02d2
            int r10 = r10 + 1
        L_0x02d2:
            int r6 = r6 + 1
            goto L_0x02b3
        L_0x02d5:
            r6 = r10
        L_0x02d6:
            int r4 = r4 + 1
            goto L_0x02a5
        L_0x02d9:
            r4 = r6
        L_0x02da:
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r2 = r5.detectionResultColumns
            int r6 = r5.barcodeColumnCount
            r7 = 1
            int r6 = r6 + r7
            r7 = r2[r6]
            if (r7 != 0) goto L_0x02e6
            r7 = 0
            goto L_0x0320
        L_0x02e6:
            r2 = r2[r6]
            com.google.zxing.pdf417.decoder.Codeword[] r2 = r2.codewords
            r6 = 0
            r7 = 0
        L_0x02ec:
            int r8 = r2.length
            if (r6 >= r8) goto L_0x0320
            r8 = r2[r6]
            if (r8 == 0) goto L_0x031d
            r8 = r2[r6]
            int r8 = r8.rowNumber
            int r10 = r5.barcodeColumnCount
            r11 = 1
            int r10 = r10 + r11
            r11 = r10
            r10 = r7
            r7 = 0
        L_0x02fe:
            if (r11 <= 0) goto L_0x031c
            r12 = 2
            if (r7 >= r12) goto L_0x031c
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r12 = r5.detectionResultColumns
            r12 = r12[r11]
            com.google.zxing.pdf417.decoder.Codeword[] r12 = r12.codewords
            r12 = r12[r6]
            if (r12 == 0) goto L_0x0319
            int r7 = com.google.zxing.pdf417.decoder.DetectionResult.adjustRowNumberIfValid(r8, r7, r12)
            boolean r12 = r12.hasValidRowNumber()
            if (r12 != 0) goto L_0x0319
            int r10 = r10 + 1
        L_0x0319:
            int r11 = r11 + -1
            goto L_0x02fe
        L_0x031c:
            r7 = r10
        L_0x031d:
            int r6 = r6 + 1
            goto L_0x02ec
        L_0x0320:
            int r2 = r4 + r7
            if (r2 != 0) goto L_0x0327
            r2 = 0
            goto L_0x03ea
        L_0x0327:
            r4 = 1
        L_0x0328:
            int r6 = r5.barcodeColumnCount
            r7 = 1
            int r6 = r6 + r7
            if (r4 >= r6) goto L_0x03ea
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r6 = r5.detectionResultColumns
            r6 = r6[r4]
            com.google.zxing.pdf417.decoder.Codeword[] r6 = r6.codewords
            r7 = 0
        L_0x0335:
            int r8 = r6.length
            if (r7 >= r8) goto L_0x03e6
            r8 = r6[r7]
            if (r8 == 0) goto L_0x03e2
            r8 = r6[r7]
            boolean r8 = r8.hasValidRowNumber()
            if (r8 != 0) goto L_0x03e2
            r8 = r6[r7]
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r10 = r5.detectionResultColumns
            int r11 = r4 + -1
            r11 = r10[r11]
            com.google.zxing.pdf417.decoder.Codeword[] r11 = r11.codewords
            int r12 = r4 + 1
            r13 = r10[r12]
            if (r13 == 0) goto L_0x0359
            r10 = r10[r12]
            com.google.zxing.pdf417.decoder.Codeword[] r10 = r10.codewords
            goto L_0x035a
        L_0x0359:
            r10 = r11
        L_0x035a:
            r12 = 14
            com.google.zxing.pdf417.decoder.Codeword[] r13 = new com.google.zxing.pdf417.decoder.Codeword[r12]
            r14 = r11[r7]
            r15 = 2
            r13[r15] = r14
            r14 = 3
            r15 = r10[r7]
            r13[r14] = r15
            if (r7 <= 0) goto L_0x037c
            int r14 = r7 + -1
            r15 = r6[r14]
            r16 = 0
            r13[r16] = r15
            r15 = 4
            r16 = r11[r14]
            r13[r15] = r16
            r15 = 5
            r14 = r10[r14]
            r13[r15] = r14
        L_0x037c:
            r14 = 1
            if (r7 <= r14) goto L_0x0393
            r14 = 8
            int r15 = r7 + -2
            r16 = r6[r15]
            r13[r14] = r16
            r14 = 10
            r16 = r11[r15]
            r13[r14] = r16
            r14 = 11
            r15 = r10[r15]
            r13[r14] = r15
        L_0x0393:
            int r14 = r6.length
            r15 = 1
            int r14 = r14 - r15
            if (r7 >= r14) goto L_0x03a8
            int r14 = r7 + 1
            r16 = r6[r14]
            r13[r15] = r16
            r15 = 6
            r16 = r11[r14]
            r13[r15] = r16
            r15 = 7
            r14 = r10[r14]
            r13[r15] = r14
        L_0x03a8:
            int r14 = r6.length
            r15 = 2
            int r14 = r14 - r15
            if (r7 >= r14) goto L_0x03c1
            r14 = 9
            int r15 = r7 + 2
            r16 = r6[r15]
            r13[r14] = r16
            r14 = 12
            r11 = r11[r15]
            r13[r14] = r11
            r11 = 13
            r10 = r10[r15]
            r13[r11] = r10
        L_0x03c1:
            r10 = 0
        L_0x03c2:
            if (r10 >= r12) goto L_0x03e2
            r11 = r13[r10]
            if (r11 != 0) goto L_0x03c9
            goto L_0x03db
        L_0x03c9:
            boolean r14 = r11.hasValidRowNumber()
            if (r14 == 0) goto L_0x03db
            int r14 = r11.bucket
            int r15 = r8.bucket
            if (r14 != r15) goto L_0x03db
            int r11 = r11.rowNumber
            r8.rowNumber = r11
            r11 = 1
            goto L_0x03dc
        L_0x03db:
            r11 = 0
        L_0x03dc:
            if (r11 == 0) goto L_0x03df
            goto L_0x03e2
        L_0x03df:
            int r10 = r10 + 1
            goto L_0x03c2
        L_0x03e2:
            int r7 = r7 + 1
            goto L_0x0335
        L_0x03e6:
            int r4 = r4 + 1
            goto L_0x0328
        L_0x03ea:
            if (r2 <= 0) goto L_0x03f4
            if (r2 < r3) goto L_0x03ef
            goto L_0x03f4
        L_0x03ef:
            r3 = r2
            r2 = 0
            r4 = 1
            goto L_0x023d
        L_0x03f4:
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r2 = r5.detectionResultColumns
            int r3 = r2.length
            r4 = 0
            r6 = 0
        L_0x03f9:
            if (r4 >= r3) goto L_0x0421
            r7 = r2[r4]
            if (r7 == 0) goto L_0x041c
            com.google.zxing.pdf417.decoder.Codeword[] r7 = r7.codewords
            int r8 = r7.length
            r9 = 0
        L_0x0403:
            if (r9 >= r8) goto L_0x041c
            r10 = r7[r9]
            if (r10 == 0) goto L_0x0419
            int r11 = r10.rowNumber
            if (r11 < 0) goto L_0x0419
            int r12 = r0.length
            if (r11 >= r12) goto L_0x0419
            r11 = r0[r11]
            r11 = r11[r6]
            int r10 = r10.value
            r11.setValue(r10)
        L_0x0419:
            int r9 = r9 + 1
            goto L_0x0403
        L_0x041c:
            int r6 = r6 + 1
            int r4 = r4 + 1
            goto L_0x03f9
        L_0x0421:
            r4 = 0
            r2 = r0[r4]
            r3 = 1
            r2 = r2[r3]
            int[] r2 = r2.getValue()
            int r3 = r5.barcodeColumnCount
            com.google.zxing.pdf417.decoder.BarcodeMetadata r4 = r5.barcodeMetadata
            int r6 = r4.rowCount
            int r3 = r3 * r6
            int r4 = r4.errorCorrectionLevel
            r6 = 2
            int r4 = r6 << r4
            int r3 = r3 - r4
            int r4 = r2.length
            if (r4 != 0) goto L_0x044d
            if (r3 <= 0) goto L_0x044a
            if (r3 > r1) goto L_0x044a
            r1 = 0
            r2 = r0[r1]
            r4 = 1
            r2 = r2[r4]
            r2.setValue(r3)
            goto L_0x045a
        L_0x044a:
            com.google.zxing.NotFoundException r0 = com.google.zxing.NotFoundException.INSTANCE
            throw r0
        L_0x044d:
            r1 = 0
            r4 = 1
            r2 = r2[r1]
            if (r2 == r3) goto L_0x045a
            r2 = r0[r1]
            r1 = r2[r4]
            r1.setValue(r3)
        L_0x045a:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.google.zxing.pdf417.decoder.BarcodeMetadata r2 = r5.barcodeMetadata
            int r2 = r2.rowCount
            int r3 = r5.barcodeColumnCount
            int r2 = r2 * r3
            int[] r2 = new int[r2]
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r6 = 0
        L_0x0474:
            com.google.zxing.pdf417.decoder.BarcodeMetadata r7 = r5.barcodeMetadata
            int r7 = r7.rowCount
            if (r6 >= r7) goto L_0x04b2
            r7 = 0
        L_0x047b:
            int r8 = r5.barcodeColumnCount
            if (r7 >= r8) goto L_0x04af
            r8 = r0[r6]
            int r9 = r7 + 1
            r8 = r8[r9]
            int[] r8 = r8.getValue()
            int r10 = r5.barcodeColumnCount
            int r10 = r10 * r6
            int r10 = r10 + r7
            int r7 = r8.length
            if (r7 != 0) goto L_0x0499
            java.lang.Integer r7 = java.lang.Integer.valueOf(r10)
            r1.add(r7)
            goto L_0x04ad
        L_0x0499:
            int r7 = r8.length
            r11 = 1
            if (r7 != r11) goto L_0x04a3
            r7 = 0
            r8 = r8[r7]
            r2[r10] = r8
            goto L_0x04ad
        L_0x04a3:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r10)
            r4.add(r7)
            r3.add(r8)
        L_0x04ad:
            r7 = r9
            goto L_0x047b
        L_0x04af:
            int r6 = r6 + 1
            goto L_0x0474
        L_0x04b2:
            int r0 = r3.size()
            int[][] r6 = new int[r0][]
            r7 = 0
        L_0x04b9:
            if (r7 >= r0) goto L_0x04c6
            java.lang.Object r8 = r3.get(r7)
            int[] r8 = (int[]) r8
            r6[r7] = r8
            int r7 = r7 + 1
            goto L_0x04b9
        L_0x04c6:
            com.google.zxing.pdf417.decoder.BarcodeMetadata r0 = r5.barcodeMetadata
            int r0 = r0.errorCorrectionLevel
            int[] r1 = com.google.zxing.pdf417.PDF417Common.toIntArray(r1)
            int[] r3 = com.google.zxing.pdf417.PDF417Common.toIntArray(r4)
            int r4 = r3.length
            int[] r5 = new int[r4]
            r7 = 100
        L_0x04d7:
            int r8 = r7 + -1
            if (r7 <= 0) goto L_0x0520
            r7 = 0
        L_0x04dc:
            if (r7 >= r4) goto L_0x04eb
            r9 = r3[r7]
            r10 = r6[r7]
            r11 = r5[r7]
            r10 = r10[r11]
            r2[r9] = r10
            int r7 = r7 + 1
            goto L_0x04dc
        L_0x04eb:
            com.google.zxing.common.DecoderResult r0 = decodeCodewords(r2, r0, r1)     // Catch:{ ChecksumException -> 0x04f0 }
            return r0
        L_0x04f0:
            if (r4 == 0) goto L_0x051b
            r7 = 0
        L_0x04f3:
            if (r7 >= r4) goto L_0x0516
            r9 = r5[r7]
            r10 = r6[r7]
            int r10 = r10.length
            r11 = -1
            int r10 = r10 + r11
            if (r9 >= r10) goto L_0x0506
            r9 = r5[r7]
            r10 = 1
            int r9 = r9 + r10
            r5[r7] = r9
            r9 = 0
            goto L_0x0519
        L_0x0506:
            r9 = 0
            r10 = 1
            r5[r7] = r9
            int r12 = r4 + -1
            if (r7 == r12) goto L_0x0511
            int r7 = r7 + 1
            goto L_0x04f3
        L_0x0511:
            com.google.zxing.ChecksumException r0 = com.google.zxing.ChecksumException.getChecksumInstance()
            throw r0
        L_0x0516:
            r9 = 0
            r10 = 1
            r11 = -1
        L_0x0519:
            r7 = r8
            goto L_0x04d7
        L_0x051b:
            com.google.zxing.ChecksumException r0 = com.google.zxing.ChecksumException.getChecksumInstance()
            throw r0
        L_0x0520:
            com.google.zxing.ChecksumException r0 = com.google.zxing.ChecksumException.getChecksumInstance()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.decode(com.google.zxing.common.BitMatrix, com.google.zxing.ResultPoint, com.google.zxing.ResultPoint, com.google.zxing.ResultPoint, com.google.zxing.ResultPoint, int, int):com.google.zxing.common.DecoderResult");
    }

    public static DecoderResult decodeCodewords(int[] iArr, int i, int[] iArr2) throws FormatException, ChecksumException {
        ModulusPoly modulusPoly;
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        if (iArr3.length != 0) {
            int i2 = 1 << (i + 1);
            if ((iArr4 == null || iArr4.length <= (i2 / 2) + 3) && i2 >= 0 && i2 <= 512) {
                ErrorCorrection errorCorrection2 = errorCorrection;
                ModulusPoly modulusPoly2 = new ModulusPoly(errorCorrection2.field, iArr3);
                int[] iArr5 = new int[i2];
                boolean z = false;
                for (int i3 = i2; i3 > 0; i3--) {
                    int evaluateAt = modulusPoly2.evaluateAt(errorCorrection2.field.expTable[i3]);
                    iArr5[i2 - i3] = evaluateAt;
                    if (evaluateAt != 0) {
                        z = true;
                    }
                }
                if (z) {
                    ModulusPoly modulusPoly3 = errorCorrection2.field.one;
                    if (iArr4 != null) {
                        for (int length : iArr4) {
                            ModulusGF modulusGF = errorCorrection2.field;
                            modulusPoly3 = modulusPoly3.multiply(new ModulusPoly(modulusGF, new int[]{modulusGF.subtract(0, modulusGF.expTable[(iArr3.length - 1) - length]), 1}));
                        }
                    }
                    ModulusPoly modulusPoly4 = new ModulusPoly(errorCorrection2.field, iArr5);
                    ModulusPoly buildMonomial = errorCorrection2.field.buildMonomial(i2, 1);
                    if (buildMonomial.getDegree() >= modulusPoly4.getDegree()) {
                        ModulusPoly modulusPoly5 = buildMonomial;
                        buildMonomial = modulusPoly4;
                        modulusPoly4 = modulusPoly5;
                    }
                    ModulusGF modulusGF2 = errorCorrection2.field;
                    ModulusPoly modulusPoly6 = modulusGF2.zero;
                    ModulusPoly modulusPoly7 = modulusGF2.one;
                    while (true) {
                        ModulusPoly modulusPoly8 = r6;
                        ModulusPoly modulusPoly9 = modulusPoly4;
                        modulusPoly4 = modulusPoly8;
                        if (modulusPoly4.getDegree() < i2 / 2) {
                            int coefficient = modulusPoly7.getCoefficient(0);
                            if (coefficient != 0) {
                                int inverse = errorCorrection2.field.inverse(coefficient);
                                ModulusPoly[] modulusPolyArr = {modulusPoly7.multiply(inverse), modulusPoly4.multiply(inverse)};
                                ModulusPoly modulusPoly10 = modulusPolyArr[0];
                                ModulusPoly modulusPoly11 = modulusPolyArr[1];
                                int degree = modulusPoly10.getDegree();
                                int[] iArr6 = new int[degree];
                                int i4 = 0;
                                for (int i5 = 1; i5 < errorCorrection2.field.modulus && i4 < degree; i5++) {
                                    if (modulusPoly10.evaluateAt(i5) == 0) {
                                        iArr6[i4] = errorCorrection2.field.inverse(i5);
                                        i4++;
                                    }
                                }
                                if (i4 == degree) {
                                    int degree2 = modulusPoly10.getDegree();
                                    int[] iArr7 = new int[degree2];
                                    for (int i6 = 1; i6 <= degree2; i6++) {
                                        iArr7[degree2 - i6] = errorCorrection2.field.multiply(i6, modulusPoly10.getCoefficient(i6));
                                    }
                                    ModulusPoly modulusPoly12 = new ModulusPoly(errorCorrection2.field, iArr7);
                                    int[] iArr8 = new int[degree];
                                    for (int i7 = 0; i7 < degree; i7++) {
                                        int inverse2 = errorCorrection2.field.inverse(iArr6[i7]);
                                        iArr8[i7] = errorCorrection2.field.multiply(errorCorrection2.field.subtract(0, modulusPoly11.evaluateAt(inverse2)), errorCorrection2.field.inverse(modulusPoly12.evaluateAt(inverse2)));
                                    }
                                    int i8 = 0;
                                    while (i8 < degree) {
                                        int length2 = iArr3.length - 1;
                                        ModulusGF modulusGF3 = errorCorrection2.field;
                                        int i9 = iArr6[i8];
                                        if (modulusGF3 == null) {
                                            throw null;
                                        } else if (i9 != 0) {
                                            int i10 = length2 - modulusGF3.logTable[i9];
                                            if (i10 >= 0) {
                                                iArr3[i10] = modulusGF3.subtract(iArr3[i10], iArr8[i8]);
                                                i8++;
                                            } else {
                                                throw ChecksumException.getChecksumInstance();
                                            }
                                        } else {
                                            throw new IllegalArgumentException();
                                        }
                                    }
                                } else {
                                    throw ChecksumException.getChecksumInstance();
                                }
                            } else {
                                throw ChecksumException.getChecksumInstance();
                            }
                        } else if (!modulusPoly4.isZero()) {
                            ModulusPoly modulusPoly13 = errorCorrection2.field.zero;
                            int inverse3 = errorCorrection2.field.inverse(modulusPoly4.getCoefficient(modulusPoly4.getDegree()));
                            while (modulusPoly9.getDegree() >= modulusPoly4.getDegree() && !modulusPoly9.isZero()) {
                                int degree3 = modulusPoly9.getDegree() - modulusPoly4.getDegree();
                                int multiply = errorCorrection2.field.multiply(modulusPoly9.getCoefficient(modulusPoly9.getDegree()), inverse3);
                                modulusPoly13 = modulusPoly13.add(errorCorrection2.field.buildMonomial(degree3, multiply));
                                if (degree3 >= 0) {
                                    if (multiply == 0) {
                                        modulusPoly = modulusPoly4.field.zero;
                                    } else {
                                        int length3 = modulusPoly4.coefficients.length;
                                        int[] iArr9 = new int[(degree3 + length3)];
                                        for (int i11 = 0; i11 < length3; i11++) {
                                            iArr9[i11] = modulusPoly4.field.multiply(modulusPoly4.coefficients[i11], multiply);
                                        }
                                        modulusPoly = new ModulusPoly(modulusPoly4.field, iArr9);
                                    }
                                    modulusPoly9 = modulusPoly9.subtract(modulusPoly);
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            }
                            modulusPoly6 = modulusPoly7;
                            modulusPoly7 = modulusPoly13.multiply(modulusPoly7).subtract(modulusPoly6).negative();
                        } else {
                            throw ChecksumException.getChecksumInstance();
                        }
                    }
                }
                if (iArr3.length >= 4) {
                    int i12 = iArr3[0];
                    if (i12 <= iArr3.length) {
                        if (i12 == 0) {
                            if (i2 < iArr3.length) {
                                iArr3[0] = iArr3.length - i2;
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                        }
                        DecoderResult decode = DecodedBitStreamParser.decode(iArr3, String.valueOf(i));
                        int length4 = iArr4.length;
                        return decode;
                    }
                    throw FormatException.getFormatInstance();
                }
                throw FormatException.getFormatInstance();
            }
            throw ChecksumException.getChecksumInstance();
        }
        throw FormatException.getFormatInstance();
    }

    public static Codeword detectCodeword(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int i7;
        BitMatrix bitMatrix2 = bitMatrix;
        int i8 = i;
        int i9 = i2;
        int i10 = i4;
        int i11 = z ? -1 : 1;
        boolean z2 = z;
        int i12 = i3;
        int i13 = 0;
        loop0:
        while (true) {
            if (i13 >= 2) {
                break;
            }
            while (true) {
                if (!z2) {
                    if (i12 >= i9) {
                        continue;
                        break;
                    }
                } else if (i12 < i8) {
                    continue;
                    break;
                }
                if (z2 != bitMatrix2.get(i12, i10)) {
                    continue;
                    break;
                } else if (Math.abs(i3 - i12) > 2) {
                    i12 = i3;
                    break loop0;
                } else {
                    i12 += i11;
                }
            }
            i11 = -i11;
            z2 = !z2;
            i13++;
        }
        int[] iArr = new int[8];
        int i14 = z ? 1 : -1;
        boolean z3 = z;
        int i15 = i12;
        int i16 = 0;
        while (true) {
            if (!z) {
                if (i15 < i8) {
                    break;
                }
            } else if (i15 >= i9) {
                break;
            }
            if (i16 >= 8) {
                break;
            } else if (bitMatrix2.get(i15, i10) == z3) {
                iArr[i16] = iArr[i16] + 1;
                i15 += i14;
            } else {
                i16++;
                z3 = !z3;
            }
        }
        int i17 = 7;
        if (i16 != 8) {
            if (z) {
                i8 = i9;
            }
            if (!(i15 == i8 && i16 == 7)) {
                iArr = null;
            }
        }
        if (iArr == null) {
            return null;
        }
        int sum = TextAppearanceConfig.sum(iArr);
        if (z) {
            i7 = i12 + sum;
        } else {
            for (int i18 = 0; i18 < iArr.length / 2; i18++) {
                int i19 = iArr[i18];
                iArr[i18] = iArr[(iArr.length - 1) - i18];
                iArr[(iArr.length - 1) - i18] = i19;
            }
            int i20 = i12;
            i12 -= sum;
            i7 = i20;
        }
        if (!(i5 + -2 <= sum && sum <= i6 + 2)) {
            return null;
        }
        int decodedValue = PDF417CodewordDecoder.getDecodedValue(iArr);
        int codeword = PDF417Common.getCodeword(decodedValue);
        if (codeword == -1) {
            return null;
        }
        int[] iArr2 = new int[8];
        int i21 = 0;
        while (true) {
            int i22 = decodedValue & 1;
            if (i22 != i21) {
                i17--;
                if (i17 < 0) {
                    return new Codeword(i12, i7, ((((iArr2[0] - iArr2[2]) + iArr2[4]) - iArr2[6]) + 9) % 9, codeword);
                }
                i21 = i22;
            }
            iArr2[i17] = iArr2[i17] + 1;
            decodedValue >>= 1;
        }
    }

    public static DetectionResultRowIndicatorColumn getRowIndicatorColumn(BitMatrix bitMatrix, BoundingBox boundingBox, ResultPoint resultPoint, boolean z, int i, int i2) {
        int i3;
        BoundingBox boundingBox2 = boundingBox;
        ResultPoint resultPoint2 = resultPoint;
        boolean z2 = z;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox2, z2);
        int i4 = 0;
        while (i4 < 2) {
            int i5 = i4 == 0 ? 1 : -1;
            int i6 = (int) resultPoint2.x;
            int i7 = (int) resultPoint2.y;
            while (i7 <= boundingBox2.maxY && i7 >= boundingBox2.minY) {
                Codeword detectCodeword = detectCodeword(bitMatrix, 0, bitMatrix.width, z, i6, i7, i, i2);
                if (detectCodeword != null) {
                    detectionResultRowIndicatorColumn.codewords[i7 - detectionResultRowIndicatorColumn.boundingBox.minY] = detectCodeword;
                    if (z2) {
                        i3 = detectCodeword.startX;
                    } else {
                        i3 = detectCodeword.endX;
                    }
                    i6 = i3;
                }
                i7 += i5;
            }
            i4++;
        }
        return detectionResultRowIndicatorColumn;
    }

    public static boolean isValidBarcodeColumn(DetectionResult detectionResult, int i) {
        return i >= 0 && i <= detectionResult.barcodeColumnCount + 1;
    }
}
