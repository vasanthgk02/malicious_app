package com.google.zxing.pdf417.detector;

import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.Arrays;

public final class Detector {
    public static final int[] INDEXES_START_PATTERN = {0, 4, 1, 5};
    public static final int[] INDEXES_STOP_PATTERN = {6, 2, 7, 3};
    public static final int[] START_PATTERN = {8, 1, 1, 1, 1, 1, 1, 3};
    public static final int[] STOP_PATTERN = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0068, code lost:
        if (r12 == false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006a, code lost:
        r1 = r7.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0072, code lost:
        if (r1.hasNext() == false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0074, code lost:
        r2 = (com.google.zxing.ResultPoint[]) r1.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007c, code lost:
        if (r2[1] == null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007e, code lost:
        r10 = (int) java.lang.Math.max((float) r10, r2[1].y);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008a, code lost:
        if (r2[3] == null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008c, code lost:
        r10 = java.lang.Math.max(r10, (int) r2[3].y);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.google.zxing.ResultPoint[]> detect(boolean r17, com.google.zxing.common.BitMatrix r18) {
        /*
            r6 = r18
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r8 = 1
            r9 = 0
            r10 = 0
        L_0x000a:
            r11 = 0
            r12 = 0
        L_0x000c:
            int r13 = r6.height
            if (r10 >= r13) goto L_0x00bc
            int r14 = r6.width
            r0 = 8
            com.google.zxing.ResultPoint[] r15 = new com.google.zxing.ResultPoint[r0]
            int[] r5 = START_PATTERN
            r0 = r18
            r1 = r13
            r2 = r14
            r3 = r10
            r4 = r11
            com.google.zxing.ResultPoint[] r0 = findRowsWithPattern(r0, r1, r2, r3, r4, r5)
            int[] r1 = INDEXES_START_PATTERN
            r2 = 0
        L_0x0025:
            int r3 = r1.length
            if (r2 >= r3) goto L_0x0031
            r3 = r1[r2]
            r4 = r0[r2]
            r15[r3] = r4
            int r2 = r2 + 1
            goto L_0x0025
        L_0x0031:
            r16 = 4
            r0 = r15[r16]
            if (r0 == 0) goto L_0x0044
            r0 = r15[r16]
            float r0 = r0.x
            int r0 = (int) r0
            r1 = r15[r16]
            float r1 = r1.y
            int r1 = (int) r1
            r4 = r0
            r3 = r1
            goto L_0x0046
        L_0x0044:
            r3 = r10
            r4 = r11
        L_0x0046:
            int[] r5 = STOP_PATTERN
            r0 = r18
            r1 = r13
            r2 = r14
            com.google.zxing.ResultPoint[] r0 = findRowsWithPattern(r0, r1, r2, r3, r4, r5)
            int[] r1 = INDEXES_STOP_PATTERN
            r2 = 0
        L_0x0053:
            int r3 = r1.length
            if (r2 >= r3) goto L_0x005f
            r3 = r1[r2]
            r4 = r0[r2]
            r15[r3] = r4
            int r2 = r2 + 1
            goto L_0x0053
        L_0x005f:
            r0 = r15[r9]
            if (r0 != 0) goto L_0x009b
            r0 = 3
            r1 = r15[r0]
            if (r1 != 0) goto L_0x009b
            if (r12 == 0) goto L_0x00bc
            java.util.Iterator r1 = r7.iterator()
        L_0x006e:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0097
            java.lang.Object r2 = r1.next()
            com.google.zxing.ResultPoint[] r2 = (com.google.zxing.ResultPoint[]) r2
            r3 = r2[r8]
            if (r3 == 0) goto L_0x0088
            float r3 = (float) r10
            r4 = r2[r8]
            float r4 = r4.y
            float r3 = java.lang.Math.max(r3, r4)
            int r10 = (int) r3
        L_0x0088:
            r3 = r2[r0]
            if (r3 == 0) goto L_0x006e
            r2 = r2[r0]
            float r2 = r2.y
            int r2 = (int) r2
            int r2 = java.lang.Math.max(r10, r2)
            r10 = r2
            goto L_0x006e
        L_0x0097:
            int r10 = r10 + 5
            goto L_0x000a
        L_0x009b:
            r7.add(r15)
            if (r17 == 0) goto L_0x00bc
            r0 = 2
            r1 = r15[r0]
            if (r1 == 0) goto L_0x00af
            r1 = r15[r0]
            float r1 = r1.x
            int r11 = (int) r1
            r0 = r15[r0]
            float r0 = r0.y
            goto L_0x00b8
        L_0x00af:
            r0 = r15[r16]
            float r0 = r0.x
            int r11 = (int) r0
            r0 = r15[r16]
            float r0 = r0.y
        L_0x00b8:
            int r10 = (int) r0
            r12 = 1
            goto L_0x000c
        L_0x00bc:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.detector.Detector.detect(boolean, com.google.zxing.common.BitMatrix):java.util.List");
    }

    public static int[] findGuardPattern(BitMatrix bitMatrix, int i, int i2, int i3, boolean z, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (bitMatrix.get(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        int length = iArr.length;
        boolean z2 = z;
        int i6 = 0;
        int i7 = i;
        while (i < i3) {
            if (bitMatrix.get(i, i2) ^ z2) {
                iArr2[i6] = iArr2[i6] + 1;
            } else {
                int i8 = length - 1;
                if (i6 != i8) {
                    i6++;
                } else if (patternMatchVariance(iArr2, iArr, 0.8f) < 0.42f) {
                    return new int[]{i7, i};
                } else {
                    i7 += iArr2[0] + iArr2[1];
                    int i9 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i9);
                    iArr2[i9] = 0;
                    iArr2[i8] = 0;
                    i6--;
                }
                iArr2[i6] = 1;
                z2 = !z2;
            }
            i++;
        }
        if (i6 != length - 1 || patternMatchVariance(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i7, i - 1};
    }

    public static ResultPoint[] findRowsWithPattern(BitMatrix bitMatrix, int i, int i2, int i3, int i4, int[] iArr) {
        int i5;
        boolean z;
        int i6;
        int i7;
        int i8;
        int i9 = i;
        ResultPoint[] resultPointArr = new ResultPoint[4];
        int[] iArr2 = new int[iArr.length];
        int i10 = i3;
        while (true) {
            if (i10 >= i9) {
                z = false;
                break;
            }
            int[] findGuardPattern = findGuardPattern(bitMatrix, i4, i10, i2, false, iArr, iArr2);
            if (findGuardPattern != null) {
                int i11 = i10;
                int[] iArr3 = findGuardPattern;
                int i12 = i11;
                while (true) {
                    if (i12 <= 0) {
                        i8 = i12;
                        break;
                    }
                    int i13 = i12 - 1;
                    int[] findGuardPattern2 = findGuardPattern(bitMatrix, i4, i13, i2, false, iArr, iArr2);
                    if (findGuardPattern2 == null) {
                        i8 = i13 + 1;
                        break;
                    }
                    iArr3 = findGuardPattern2;
                    i12 = i13;
                }
                float f2 = (float) i8;
                resultPointArr[0] = new ResultPoint((float) iArr3[0], f2);
                resultPointArr[1] = new ResultPoint((float) iArr3[1], f2);
                i10 = i8;
                z = true;
            } else {
                i10 += 5;
            }
        }
        int i14 = i10 + 1;
        if (z) {
            int[] iArr4 = {(int) resultPointArr[0].x, (int) resultPointArr[1].x};
            int i15 = i14;
            int i16 = 0;
            while (true) {
                if (i15 >= i9) {
                    i6 = i16;
                    i7 = i15;
                    break;
                }
                i6 = i16;
                i7 = i15;
                int[] findGuardPattern3 = findGuardPattern(bitMatrix, iArr4[0], i15, i2, false, iArr, iArr2);
                if (findGuardPattern3 == null || Math.abs(iArr4[0] - findGuardPattern3[0]) >= 5 || Math.abs(iArr4[1] - findGuardPattern3[1]) >= 5) {
                    if (i6 > 25) {
                        break;
                    }
                    i16 = i6 + 1;
                } else {
                    iArr4 = findGuardPattern3;
                    i16 = 0;
                }
                i15 = i7 + 1;
            }
            i14 = i7 - (i6 + 1);
            float f3 = (float) i14;
            resultPointArr[2] = new ResultPoint((float) iArr4[0], f3);
            resultPointArr[3] = new ResultPoint((float) iArr4[1], f3);
        }
        if (i14 - i10 < 10) {
            for (i5 = 0; i5 < 4; i5++) {
                resultPointArr[i5] = null;
            }
        }
        return resultPointArr;
    }

    public static float patternMatchVariance(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = (float) i;
        float f4 = f3 / ((float) i2);
        float f5 = f2 * f4;
        float f6 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f7 = ((float) iArr2[i4]) * f4;
            float f8 = (float) i5;
            float f9 = f8 > f7 ? f8 - f7 : f7 - f8;
            if (f9 > f5) {
                return Float.POSITIVE_INFINITY;
            }
            f6 += f9;
        }
        return f6 / f3;
    }
}
