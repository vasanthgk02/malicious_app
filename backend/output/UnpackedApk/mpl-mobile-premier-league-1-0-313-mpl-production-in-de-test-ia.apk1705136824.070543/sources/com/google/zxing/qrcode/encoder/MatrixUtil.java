package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import org.apache.commons.net.ftp.FTPReply;

public final class MatrixUtil {
    public static final int[][] POSITION_ADJUSTMENT_PATTERN = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    public static final int[][] POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, FTPReply.FILE_STATUS_OK}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
    public static final int[][] POSITION_DETECTION_PATTERN = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    public static final int[][] TYPE_INFO_COORDINATES = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0213, code lost:
        r13 = r13 & 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0215, code lost:
        if (r13 != 0) goto L_0x0219;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0217, code lost:
        r13 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0219, code lost:
        r13 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x021a, code lost:
        if (r13 == false) goto L_0x021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x021c, code lost:
        r12 = !r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01f8, code lost:
        r13 = r13 + r14;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void buildMatrix(com.google.zxing.common.BitArray r16, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r17, com.google.zxing.qrcode.decoder.Version r18, int r19, com.google.zxing.qrcode.encoder.ByteMatrix r20) throws com.google.zxing.WriterException {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = 0
            r5 = 0
        L_0x000a:
            int r6 = r3.height
            r7 = -1
            if (r5 >= r6) goto L_0x0020
            r6 = 0
        L_0x0010:
            int r8 = r3.width
            if (r6 >= r8) goto L_0x001d
            byte[][] r8 = r3.bytes
            r8 = r8[r5]
            r8[r6] = r7
            int r6 = r6 + 1
            goto L_0x0010
        L_0x001d:
            int r5 = r5 + 1
            goto L_0x000a
        L_0x0020:
            int[][] r5 = POSITION_DETECTION_PATTERN
            r5 = r5[r4]
            int r5 = r5.length
            embedPositionDetectionPattern(r4, r4, r3)
            int r6 = r3.width
            int r6 = r6 - r5
            embedPositionDetectionPattern(r6, r4, r3)
            int r6 = r3.width
            int r6 = r6 - r5
            embedPositionDetectionPattern(r4, r6, r3)
            r5 = 7
            embedHorizontalSeparationPattern(r4, r5, r3)
            int r6 = r3.width
            int r6 = r6 + -8
            embedHorizontalSeparationPattern(r6, r5, r3)
            int r6 = r3.width
            int r6 = r6 + -8
            embedHorizontalSeparationPattern(r4, r6, r3)
            embedVerticalSeparationPattern(r5, r4, r3)
            int r6 = r3.height
            int r6 = r6 - r5
            int r6 = r6 + r7
            embedVerticalSeparationPattern(r6, r4, r3)
            int r4 = r3.height
            int r4 = r4 - r5
            embedVerticalSeparationPattern(r5, r4, r3)
            int r4 = r3.height
            r5 = 8
            int r4 = r4 - r5
            byte r4 = r3.get(r5, r4)
            if (r4 == 0) goto L_0x0286
            int r4 = r3.height
            int r4 = r4 - r5
            r6 = 1
            r3.set(r5, r4, r6)
            int r4 = r1.versionNumber
            r6 = 5
            r8 = 2
            if (r4 >= r8) goto L_0x006f
            goto L_0x00b8
        L_0x006f:
            int r4 = r4 + r7
            int[][] r8 = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE
            r9 = r8[r4]
            r4 = r8[r4]
            int r4 = r4.length
            r8 = 0
        L_0x0078:
            if (r8 >= r4) goto L_0x00b8
            r10 = 0
        L_0x007b:
            if (r10 >= r4) goto L_0x00b3
            r11 = r9[r8]
            r12 = r9[r10]
            if (r12 == r7) goto L_0x00ae
            if (r11 == r7) goto L_0x00ae
            byte r7 = r3.get(r12, r11)
            boolean r7 = isEmpty(r7)
            if (r7 == 0) goto L_0x00ae
            int r12 = r12 + -2
            int r11 = r11 + -2
            r7 = 0
        L_0x0094:
            if (r7 >= r6) goto L_0x00ae
            r13 = 0
        L_0x0097:
            if (r13 >= r6) goto L_0x00aa
            int r6 = r12 + r13
            int r14 = r11 + r7
            int[][] r15 = POSITION_ADJUSTMENT_PATTERN
            r15 = r15[r7]
            r15 = r15[r13]
            r3.set(r6, r14, r15)
            int r13 = r13 + 1
            r6 = 5
            goto L_0x0097
        L_0x00aa:
            int r7 = r7 + 1
            r6 = 5
            goto L_0x0094
        L_0x00ae:
            int r10 = r10 + 1
            r7 = -1
            r6 = 5
            goto L_0x007b
        L_0x00b3:
            int r8 = r8 + 1
            r7 = -1
            r6 = 5
            goto L_0x0078
        L_0x00b8:
            r4 = 8
        L_0x00ba:
            int r6 = r3.width
            int r6 = r6 - r5
            r7 = 6
            if (r4 >= r6) goto L_0x00e0
            int r6 = r4 + 1
            int r8 = r6 % 2
            byte r9 = r3.get(r4, r7)
            boolean r9 = isEmpty(r9)
            if (r9 == 0) goto L_0x00d1
            r3.set(r4, r7, r8)
        L_0x00d1:
            byte r9 = r3.get(r7, r4)
            boolean r9 = isEmpty(r9)
            if (r9 == 0) goto L_0x00de
            r3.set(r7, r4, r8)
        L_0x00de:
            r4 = r6
            goto L_0x00ba
        L_0x00e0:
            com.google.zxing.common.BitArray r4 = new com.google.zxing.common.BitArray
            r4.<init>()
            if (r2 < 0) goto L_0x00eb
            if (r2 >= r5) goto L_0x00eb
            r6 = 1
            goto L_0x00ec
        L_0x00eb:
            r6 = 0
        L_0x00ec:
            if (r6 == 0) goto L_0x027e
            int r6 = r17.getBits()
            r8 = 3
            int r6 = r6 << r8
            r6 = r6 | r2
            r9 = 5
            r4.appendBits(r6, r9)
            r9 = 1335(0x537, float:1.871E-42)
            int r6 = calculateBCHCode(r6, r9)
            r9 = 10
            r4.appendBits(r6, r9)
            com.google.zxing.common.BitArray r6 = new com.google.zxing.common.BitArray
            r6.<init>()
            r9 = 21522(0x5412, float:3.0159E-41)
            r10 = 15
            r6.appendBits(r9, r10)
            int r9 = r4.size
            int r11 = r6.size
            if (r9 != r11) goto L_0x0276
            r9 = 0
        L_0x0117:
            int[] r11 = r4.bits
            int r12 = r11.length
            if (r9 >= r12) goto L_0x0128
            r12 = r11[r9]
            int[] r13 = r6.bits
            r13 = r13[r9]
            r12 = r12 ^ r13
            r11[r9] = r12
            int r9 = r9 + 1
            goto L_0x0117
        L_0x0128:
            int r6 = r4.size
            java.lang.String r9 = "should not happen but we got: "
            if (r6 != r10) goto L_0x0262
            r6 = 0
        L_0x012f:
            int r10 = r4.size
            if (r6 >= r10) goto L_0x0160
            int r10 = r10 + -1
            int r10 = r10 - r6
            boolean r10 = r4.get(r10)
            int[][] r11 = TYPE_INFO_COORDINATES
            r12 = r11[r6]
            r13 = 0
            r12 = r12[r13]
            r11 = r11[r6]
            r13 = 1
            r11 = r11[r13]
            r3.set(r12, r11, r10)
            if (r6 >= r5) goto L_0x0153
            int r11 = r3.width
            int r11 = r11 - r6
            int r11 = r11 - r13
            r3.set(r11, r5, r10)
            goto L_0x015d
        L_0x0153:
            int r11 = r3.height
            int r11 = r11 + -7
            int r12 = r6 + -8
            int r12 = r12 + r11
            r3.set(r5, r12, r10)
        L_0x015d:
            int r6 = r6 + 1
            goto L_0x012f
        L_0x0160:
            int r4 = r1.versionNumber
            r5 = 7
            if (r4 >= r5) goto L_0x0166
            goto L_0x01a7
        L_0x0166:
            com.google.zxing.common.BitArray r4 = new com.google.zxing.common.BitArray
            r4.<init>()
            int r5 = r1.versionNumber
            r4.appendBits(r5, r7)
            int r1 = r1.versionNumber
            r5 = 7973(0x1f25, float:1.1173E-41)
            int r1 = calculateBCHCode(r1, r5)
            r5 = 12
            r4.appendBits(r1, r5)
            int r1 = r4.size
            r5 = 18
            if (r1 != r5) goto L_0x024e
            r1 = 17
            r5 = 0
        L_0x0186:
            if (r5 >= r7) goto L_0x01a7
            r6 = 0
        L_0x0189:
            if (r6 >= r8) goto L_0x01a4
            boolean r9 = r4.get(r1)
            int r1 = r1 + -1
            int r10 = r3.height
            int r10 = r10 + -11
            int r10 = r10 + r6
            r3.set(r5, r10, r9)
            int r10 = r3.height
            int r10 = r10 + -11
            int r10 = r10 + r6
            r3.set(r10, r5, r9)
            int r6 = r6 + 1
            goto L_0x0189
        L_0x01a4:
            int r5 = r5 + 1
            goto L_0x0186
        L_0x01a7:
            int r1 = r3.width
            int r1 = r1 + -1
            int r4 = r3.height
            int r4 = r4 + -1
            r5 = 0
            r6 = -1
        L_0x01b1:
            if (r1 <= 0) goto L_0x022b
            if (r1 != r7) goto L_0x01b7
            int r1 = r1 + -1
        L_0x01b7:
            if (r4 < 0) goto L_0x0226
            int r9 = r3.height
            if (r4 >= r9) goto L_0x0226
            r9 = 0
            r10 = 2
        L_0x01bf:
            if (r9 >= r10) goto L_0x0224
            int r11 = r1 - r9
            byte r12 = r3.get(r11, r4)
            boolean r12 = isEmpty(r12)
            if (r12 == 0) goto L_0x0221
            int r12 = r0.size
            if (r5 >= r12) goto L_0x01d8
            boolean r12 = r0.get(r5)
            int r5 = r5 + 1
            goto L_0x01d9
        L_0x01d8:
            r12 = 0
        L_0x01d9:
            r13 = -1
            if (r2 == r13) goto L_0x021e
            switch(r2) {
                case 0: goto L_0x0211;
                case 1: goto L_0x020f;
                case 2: goto L_0x020c;
                case 3: goto L_0x0207;
                case 4: goto L_0x0201;
                case 5: goto L_0x01fa;
                case 6: goto L_0x01f3;
                case 7: goto L_0x01eb;
                default: goto L_0x01df;
            }
        L_0x01df:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Invalid mask pattern: "
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline40(r1, r2)
            r0.<init>(r1)
            throw r0
        L_0x01eb:
            int r13 = r4 * r11
            int r13 = r13 % r8
            int r14 = r4 + r11
            r14 = r14 & 1
            goto L_0x01f8
        L_0x01f3:
            int r13 = r4 * r11
            r14 = r13 & 1
            int r13 = r13 % r8
        L_0x01f8:
            int r13 = r13 + r14
            goto L_0x0213
        L_0x01fa:
            int r13 = r4 * r11
            r14 = r13 & 1
            int r13 = r13 % r8
            int r13 = r13 + r14
            goto L_0x0215
        L_0x0201:
            int r13 = r4 / 2
            int r14 = r11 / 3
            int r13 = r13 + r14
            goto L_0x0213
        L_0x0207:
            int r13 = r4 + r11
            int r13 = r13 % 3
            goto L_0x0215
        L_0x020c:
            int r13 = r11 % 3
            goto L_0x0215
        L_0x020f:
            r13 = r4
            goto L_0x0213
        L_0x0211:
            int r13 = r4 + r11
        L_0x0213:
            r13 = r13 & 1
        L_0x0215:
            if (r13 != 0) goto L_0x0219
            r13 = 1
            goto L_0x021a
        L_0x0219:
            r13 = 0
        L_0x021a:
            if (r13 == 0) goto L_0x021e
            r12 = r12 ^ 1
        L_0x021e:
            r3.set(r11, r4, r12)
        L_0x0221:
            int r9 = r9 + 1
            goto L_0x01bf
        L_0x0224:
            int r4 = r4 + r6
            goto L_0x01b7
        L_0x0226:
            int r6 = -r6
            int r4 = r4 + r6
            int r1 = r1 + -2
            goto L_0x01b1
        L_0x022b:
            int r1 = r0.size
            if (r5 != r1) goto L_0x0230
            return
        L_0x0230:
            com.google.zxing.WriterException r1 = new com.google.zxing.WriterException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Not all bits consumed: "
            r2.<init>(r3)
            r2.append(r5)
            r3 = 47
            r2.append(r3)
            int r0 = r0.size
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x024e:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r9)
            int r2 = r4.size
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0262:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r9)
            int r2 = r4.size
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0276:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Sizes don't match"
            r0.<init>(r1)
            throw r0
        L_0x027e:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Invalid mask pattern"
            r0.<init>(r1)
            throw r0
        L_0x0286:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.MatrixUtil.buildMatrix(com.google.zxing.common.BitArray, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, com.google.zxing.qrcode.decoder.Version, int, com.google.zxing.qrcode.encoder.ByteMatrix):void");
    }

    public static int calculateBCHCode(int i, int i2) {
        if (i2 != 0) {
            int findMSBSet = findMSBSet(i2);
            int i3 = i << (findMSBSet - 1);
            while (findMSBSet(i3) >= findMSBSet) {
                i3 ^= i2 << (findMSBSet(i3) - findMSBSet);
            }
            return i3;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    public static void embedHorizontalSeparationPattern(int i, int i2, ByteMatrix byteMatrix) throws WriterException {
        int i3 = 0;
        while (i3 < 8) {
            int i4 = i + i3;
            if (isEmpty(byteMatrix.get(i4, i2))) {
                byteMatrix.set(i4, i2, 0);
                i3++;
            } else {
                throw new WriterException();
            }
        }
    }

    public static void embedPositionDetectionPattern(int i, int i2, ByteMatrix byteMatrix) {
        for (int i3 = 0; i3 < 7; i3++) {
            for (int i4 = 0; i4 < 7; i4++) {
                byteMatrix.set(i + i4, i2 + i3, POSITION_DETECTION_PATTERN[i3][i4]);
            }
        }
    }

    public static void embedVerticalSeparationPattern(int i, int i2, ByteMatrix byteMatrix) throws WriterException {
        int i3 = 0;
        while (i3 < 7) {
            int i4 = i2 + i3;
            if (isEmpty(byteMatrix.bytes[i4][i])) {
                byteMatrix.bytes[i4][i] = (byte) 0;
                i3++;
            } else {
                throw new WriterException();
            }
        }
    }

    public static int findMSBSet(int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }

    public static boolean isEmpty(int i) {
        return i == -1;
    }
}
