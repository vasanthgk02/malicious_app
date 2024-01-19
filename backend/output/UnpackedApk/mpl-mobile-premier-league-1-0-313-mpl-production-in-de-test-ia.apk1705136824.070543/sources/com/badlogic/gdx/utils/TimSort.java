package com.badlogic.gdx.utils;

import java.util.Comparator;

public class TimSort<T> {

    /* renamed from: a  reason: collision with root package name */
    public T[] f3311a;

    /* renamed from: c  reason: collision with root package name */
    public Comparator<? super T> f3312c;
    public int minGallop = 7;
    public final int[] runBase = new int[40];
    public final int[] runLen = new int[40];
    public int stackSize = 0;
    public T[] tmp = new Object[256];
    public int tmpCount;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        if (r3 == 1) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
        if (r3 == 2) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        java.lang.System.arraycopy(r6, r2, r6, r2 + 1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r6[r2 + 2] = r6[r2 + 1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        r6[r2 + 1] = r6[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        r6[r2] = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        r9 = r9 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0001, code lost:
        if (r9 == r7) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        if (r9 >= r8) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r1 = r6[r9];
        r2 = r7;
        r3 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        if (r2 >= r3) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        r4 = (r2 + r3) >>> 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        if (r10.compare(r1, r6[r4]) >= 0) goto L_0x0019;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        r2 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        r3 = r9 - r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> void binarySort(T[] r6, int r7, int r8, int r9, java.util.Comparator<? super T> r10) {
        /*
            r0 = 1
            if (r9 != r7) goto L_0x0004
            goto L_0x0039
        L_0x0004:
            if (r9 >= r8) goto L_0x003b
            r1 = r6[r9]
            r2 = r7
            r3 = r9
        L_0x000a:
            if (r2 >= r3) goto L_0x001c
            int r4 = r2 + r3
            int r4 = r4 >>> r0
            r5 = r6[r4]
            int r5 = r10.compare(r1, r5)
            if (r5 >= 0) goto L_0x0019
            r3 = r4
            goto L_0x000a
        L_0x0019:
            int r2 = r4 + 1
            goto L_0x000a
        L_0x001c:
            int r3 = r9 - r2
            if (r3 == r0) goto L_0x0031
            r4 = 2
            if (r3 == r4) goto L_0x0029
            int r4 = r2 + 1
            java.lang.System.arraycopy(r6, r2, r6, r4, r3)
            goto L_0x0037
        L_0x0029:
            int r3 = r2 + 2
            int r4 = r2 + 1
            r4 = r6[r4]
            r6[r3] = r4
        L_0x0031:
            int r3 = r2 + 1
            r4 = r6[r2]
            r6[r3] = r4
        L_0x0037:
            r6[r2] = r1
        L_0x0039:
            int r9 = r9 + r0
            goto L_0x0004
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.TimSort.binarySort(java.lang.Object[], int, int, int, java.util.Comparator):void");
    }

    public static <T> int countRunAndMakeAscending(T[] tArr, int i, int i2, Comparator<? super T> comparator) {
        int i3 = i + 1;
        if (i3 == i2) {
            return 1;
        }
        int i4 = i3 + 1;
        if (comparator.compare(tArr[i3], tArr[i]) < 0) {
            while (i4 < i2 && comparator.compare(tArr[i4], tArr[i4 - 1]) < 0) {
                i4++;
            }
            int i5 = i4 - 1;
            for (int i6 = i; i6 < i5; i6++) {
                T t = tArr[i6];
                tArr[i6] = tArr[i5];
                tArr[i5] = t;
                i5--;
            }
        } else {
            while (i4 < i2 && comparator.compare(tArr[i4], tArr[i4 - 1]) >= 0) {
                i4++;
            }
        }
        return i4 - i;
    }

    public static <T> int gallopLeft(T t, T[] tArr, int i, int i2, int i3, Comparator<? super T> comparator) {
        int i4;
        int i5;
        int i6 = i + i3;
        if (comparator.compare(t, tArr[i6]) > 0) {
            int i7 = i2 - i3;
            int i8 = 0;
            int i9 = 1;
            while (i9 < i7 && comparator.compare(t, tArr[i6 + i9]) > 0) {
                int i10 = (i9 << 1) + 1;
                if (i10 <= 0) {
                    i8 = i9;
                    i9 = i7;
                } else {
                    int i11 = i9;
                    i9 = i10;
                    i8 = i11;
                }
            }
            if (i9 <= i7) {
                i7 = i9;
            }
            i5 = i8 + i3;
            i4 = i7 + i3;
        } else {
            int i12 = i3 + 1;
            int i13 = 0;
            int i14 = 1;
            while (i14 < i12 && comparator.compare(t, tArr[i6 - i14]) <= 0) {
                int i15 = (i14 << 1) + 1;
                if (i15 <= 0) {
                    i13 = i14;
                    i14 = i12;
                } else {
                    int i16 = i14;
                    i14 = i15;
                    i13 = i16;
                }
            }
            if (i14 <= i12) {
                i12 = i14;
            }
            int i17 = i3 - i12;
            int i18 = i3 - i13;
            i5 = i17;
            i4 = i18;
        }
        int i19 = i5 + 1;
        while (i19 < i4) {
            int i20 = ((i4 - i19) >>> 1) + i19;
            if (comparator.compare(t, tArr[i + i20]) > 0) {
                i19 = i20 + 1;
            } else {
                i4 = i20;
            }
        }
        return i4;
    }

    public static <T> int gallopRight(T t, T[] tArr, int i, int i2, int i3, Comparator<? super T> comparator) {
        int i4;
        int i5;
        int i6 = i + i3;
        if (comparator.compare(t, tArr[i6]) < 0) {
            int i7 = i3 + 1;
            int i8 = 0;
            int i9 = 1;
            while (i9 < i7 && comparator.compare(t, tArr[i6 - i9]) < 0) {
                int i10 = (i9 << 1) + 1;
                if (i10 <= 0) {
                    i8 = i9;
                    i9 = i7;
                } else {
                    int i11 = i9;
                    i9 = i10;
                    i8 = i11;
                }
            }
            if (i9 <= i7) {
                i7 = i9;
            }
            i5 = i3 - i7;
            i4 = i3 - i8;
        } else {
            int i12 = i2 - i3;
            int i13 = 0;
            int i14 = 1;
            while (i14 < i12 && comparator.compare(t, tArr[i6 + i14]) >= 0) {
                int i15 = (i14 << 1) + 1;
                if (i15 <= 0) {
                    i13 = i14;
                    i14 = i12;
                } else {
                    int i16 = i14;
                    i14 = i15;
                    i13 = i16;
                }
            }
            if (i14 <= i12) {
                i12 = i14;
            }
            int i17 = i13 + i3;
            i4 = i3 + i12;
            i5 = i17;
        }
        int i18 = i5 + 1;
        while (i18 < i4) {
            int i19 = ((i4 - i18) >>> 1) + i18;
            if (comparator.compare(t, tArr[i + i19]) < 0) {
                i4 = i19;
            } else {
                i18 = i19 + 1;
            }
        }
        return i4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0063, code lost:
        if (r7[r6 - 1] > (r7[r6] + r7[r6 + 1])) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0074, code lost:
        if (r7[r6 - 2] <= (r7[r6] + r7[r6 - 1])) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0076, code lost:
        r7 = r11.runLen;
        r8 = r6 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0080, code lost:
        if (r7[r8] >= r7[r6 + 1]) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0082, code lost:
        r6 = r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doSort(T[] r12, java.util.Comparator<T> r13, int r14, int r15) {
        /*
            r11 = this;
            r0 = 0
            r11.stackSize = r0
            int r1 = r12.length
            if (r14 > r15) goto L_0x00cd
            if (r14 < 0) goto L_0x00c7
            if (r15 > r1) goto L_0x00c1
            int r1 = r15 - r14
            r2 = 2
            if (r1 >= r2) goto L_0x0010
            return
        L_0x0010:
            r3 = 32
            if (r1 >= r3) goto L_0x001d
            int r0 = countRunAndMakeAscending(r12, r14, r15, r13)
            int r0 = r0 + r14
            binarySort(r12, r14, r15, r0, r13)
            return
        L_0x001d:
            r11.f3311a = r12
            r11.f3312c = r13
            r11.tmpCount = r0
            r4 = 0
            r5 = r1
        L_0x0025:
            if (r5 < r3) goto L_0x002d
            r6 = r5 & 1
            r4 = r4 | r6
            int r5 = r5 >> 1
            goto L_0x0025
        L_0x002d:
            int r5 = r5 + r4
        L_0x002e:
            int r3 = countRunAndMakeAscending(r12, r14, r15, r13)
            if (r3 >= r5) goto L_0x0040
            if (r1 > r5) goto L_0x0038
            r4 = r1
            goto L_0x0039
        L_0x0038:
            r4 = r5
        L_0x0039:
            int r6 = r14 + r4
            int r3 = r3 + r14
            binarySort(r12, r14, r6, r3, r13)
            r3 = r4
        L_0x0040:
            int[] r4 = r11.runBase
            int r6 = r11.stackSize
            r4[r6] = r14
            int[] r4 = r11.runLen
            r4[r6] = r3
            r4 = 1
            int r6 = r6 + r4
            r11.stackSize = r6
        L_0x004e:
            int r6 = r11.stackSize
            if (r6 <= r4) goto L_0x0093
            int r6 = r6 + -2
            if (r6 < r4) goto L_0x0065
            int[] r7 = r11.runLen
            int r8 = r6 + -1
            r8 = r7[r8]
            r9 = r7[r6]
            int r10 = r6 + 1
            r7 = r7[r10]
            int r9 = r9 + r7
            if (r8 <= r9) goto L_0x0076
        L_0x0065:
            if (r6 < r2) goto L_0x0084
            int[] r7 = r11.runLen
            int r8 = r6 + -2
            r8 = r7[r8]
            r9 = r7[r6]
            int r10 = r6 + -1
            r7 = r7[r10]
            int r9 = r9 + r7
            if (r8 > r9) goto L_0x0084
        L_0x0076:
            int[] r7 = r11.runLen
            int r8 = r6 + -1
            r9 = r7[r8]
            int r10 = r6 + 1
            r7 = r7[r10]
            if (r9 >= r7) goto L_0x008f
            r6 = r8
            goto L_0x008f
        L_0x0084:
            int[] r7 = r11.runLen
            r8 = r7[r6]
            int r9 = r6 + 1
            r7 = r7[r9]
            if (r8 <= r7) goto L_0x008f
            goto L_0x0093
        L_0x008f:
            r11.mergeAt(r6)
            goto L_0x004e
        L_0x0093:
            int r14 = r14 + r3
            int r1 = r1 - r3
            if (r1 != 0) goto L_0x002e
        L_0x0097:
            int r12 = r11.stackSize
            if (r12 <= r4) goto L_0x00b0
            int r12 = r12 + -2
            if (r12 <= 0) goto L_0x00ac
            int[] r13 = r11.runLen
            int r14 = r12 + -1
            r15 = r13[r14]
            int r1 = r12 + 1
            r13 = r13[r1]
            if (r15 >= r13) goto L_0x00ac
            r12 = r14
        L_0x00ac:
            r11.mergeAt(r12)
            goto L_0x0097
        L_0x00b0:
            r12 = 0
            r11.f3311a = r12
            r11.f3312c = r12
            T[] r13 = r11.tmp
            int r14 = r11.tmpCount
        L_0x00b9:
            if (r0 >= r14) goto L_0x00c0
            r13[r0] = r12
            int r0 = r0 + 1
            goto L_0x00b9
        L_0x00c0:
            return
        L_0x00c1:
            java.lang.ArrayIndexOutOfBoundsException r12 = new java.lang.ArrayIndexOutOfBoundsException
            r12.<init>(r15)
            throw r12
        L_0x00c7:
            java.lang.ArrayIndexOutOfBoundsException r12 = new java.lang.ArrayIndexOutOfBoundsException
            r12.<init>(r14)
            throw r12
        L_0x00cd:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "fromIndex("
            java.lang.String r0 = ") > toIndex("
            java.lang.String r1 = ")"
            java.lang.String r13 = com.android.tools.r8.GeneratedOutlineSupport.outline44(r13, r14, r0, r15, r1)
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.TimSort.doSort(java.lang.Object[], java.util.Comparator, int, int):void");
    }

    public final T[] ensureCapacity(int i) {
        this.tmpCount = Math.max(this.tmpCount, i);
        if (this.tmp.length < i) {
            int i2 = (i >> 1) | i;
            int i3 = i2 | (i2 >> 2);
            int i4 = i3 | (i3 >> 4);
            int i5 = i4 | (i4 >> 8);
            int i6 = (i5 | (i5 >> 16)) + 1;
            if (i6 >= 0) {
                i = Math.min(i6, this.f3311a.length >>> 1);
            }
            this.tmp = new Object[i];
        }
        return this.tmp;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01f4, code lost:
        r21 = r13;
        r13 = r4;
        r4 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01fa, code lost:
        r5 = r14;
        r4 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01fd, code lost:
        r6 = r13 - 1;
        r7 = r10 - 1;
        r11[r13] = r15[r10];
        r2 = r2 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0208, code lost:
        if (r2 != 1) goto L_0x0210;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x020a, code lost:
        r3 = r2;
        r13 = r4;
        r14 = r5;
        r2 = r6;
        r4 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0210, code lost:
        r10 = r15;
        r8 = r2 - gallopLeft(r11[r5], r15, 0, r2, r2 - 1, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0222, code lost:
        if (r8 == 0) goto L_0x0237;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0224, code lost:
        r6 = r6 - r8;
        r7 = r7 - r8;
        r2 = r2 - r8;
        java.lang.System.arraycopy(r10, r7 + 1, r11, r6 + 1, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x022f, code lost:
        if (r2 > 1) goto L_0x0237;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0231, code lost:
        r3 = r2;
        r13 = r4;
        r14 = r5;
        r2 = r6;
        r4 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0237, code lost:
        r13 = r6 - 1;
        r14 = r5 - 1;
        r11[r6] = r11[r5];
        r16 = r4 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0241, code lost:
        if (r16 != 0) goto L_0x026f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0243, code lost:
        r3 = r2;
        r4 = r7;
        r2 = r13;
        r13 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x026f, code lost:
        r20 = r20 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0274, code lost:
        if (r3 < 7) goto L_0x0278;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0276, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0278, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0279, code lost:
        if (r8 < 7) goto L_0x027d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x027b, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x027d, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x027f, code lost:
        if ((r3 | r6) != false) goto L_0x0292;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0281, code lost:
        if (r20 >= 0) goto L_0x0285;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0283, code lost:
        r20 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0292, code lost:
        r15 = r10;
        r10 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00bd, code lost:
        r9 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00be, code lost:
        r11 = gallopRight(r4[r9], r6, r5, r10, 0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00cd, code lost:
        if (r11 == 0) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00cf, code lost:
        java.lang.System.arraycopy(r6, r5, r4, r1, r11);
        r1 = r1 + r11;
        r5 = r5 + r11;
        r10 = r10 - r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d5, code lost:
        if (r10 > 1) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d8, code lost:
        r13 = r1 + 1;
        r15 = r9 + 1;
        r4[r1] = r4[r9];
        r3 = r3 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e2, code lost:
        if (r3 != 0) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e4, code lost:
        r1 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e6, code lost:
        r9 = r15;
        r1 = gallopLeft(r6[r5], r4, r9, r3, 0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f6, code lost:
        if (r1 == 0) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f8, code lost:
        java.lang.System.arraycopy(r4, r9, r4, r13, r1);
        r13 = r13 + r1;
        r15 = r9 + r1;
        r3 = r3 - r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ff, code lost:
        if (r3 != 0) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0101, code lost:
        r9 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0105, code lost:
        r9 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        r14 = r13 + 1;
        r15 = r5 + 1;
        r4[r13] = r6[r5];
        r10 = r10 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0110, code lost:
        if (r10 != 1) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0112, code lost:
        r1 = r14;
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0132, code lost:
        r8 = r8 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0135, code lost:
        if (r11 < 7) goto L_0x0139;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0137, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0139, code lost:
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x013a, code lost:
        if (r1 < 7) goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x013c, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x013e, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0140, code lost:
        if ((r1 | r11) != false) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0142, code lost:
        if (r8 >= 0) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0144, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x014d, code lost:
        r1 = r14;
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01c4, code lost:
        r2 = r3;
        r20 = r5;
        r14 = r10;
        r16 = r13;
        r10 = r4;
        r13 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01cc, code lost:
        r3 = r16 - gallopRight(r15[r10], r11, r9, r16, r16 - 1, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01db, code lost:
        if (r3 == 0) goto L_0x01fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01dd, code lost:
        r4 = r13 - r3;
        r5 = r14 - r3;
        r13 = r16 - r3;
        java.lang.System.arraycopy(r11, r5 + 1, r11, r4 + 1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01ea, code lost:
        if (r13 != 0) goto L_0x01f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01ec, code lost:
        r3 = r2;
        r2 = r4;
        r14 = r5;
        r4 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01f0, code lost:
        r10 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01f1, code lost:
        r5 = r20;
     */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0296 A[LOOP:4: B:78:0x018b->B:137:0x0296, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x01c4 A[EDGE_INSN: B:156:0x01c4->B:92:0x01c4 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mergeAt(int r23) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            int[] r2 = r0.runBase
            r9 = r2[r1]
            int[] r3 = r0.runLen
            r10 = r3[r1]
            int r4 = r1 + 1
            r15 = r2[r4]
            r14 = r3[r4]
            int r5 = r10 + r14
            r3[r1] = r5
            int r5 = r0.stackSize
            int r5 = r5 + -3
            if (r1 != r5) goto L_0x0026
            int r1 = r1 + 2
            r5 = r2[r1]
            r2[r4] = r5
            r1 = r3[r1]
            r3[r4] = r1
        L_0x0026:
            int r1 = r0.stackSize
            r2 = 1
            int r1 = r1 - r2
            r0.stackSize = r1
            T[] r4 = r0.f3311a
            r3 = r4[r15]
            r7 = 0
            java.util.Comparator<? super T> r8 = r0.f3312c
            r5 = r9
            r6 = r10
            int r1 = gallopRight(r3, r4, r5, r6, r7, r8)
            int r9 = r9 + r1
            int r10 = r10 - r1
            if (r10 != 0) goto L_0x003e
            return
        L_0x003e:
            T[] r12 = r0.f3311a
            int r1 = r9 + r10
            int r1 = r1 - r2
            r11 = r12[r1]
            int r3 = r14 + -1
            java.util.Comparator<? super T> r4 = r0.f3312c
            r13 = r15
            r5 = r15
            r15 = r3
            r16 = r4
            int r3 = gallopLeft(r11, r12, r13, r14, r15, r16)
            if (r3 != 0) goto L_0x0055
            return
        L_0x0055:
            java.lang.String r12 = "Comparison method violates its general contract!"
            r13 = 0
            if (r10 > r3) goto L_0x0151
            T[] r4 = r0.f3311a
            java.lang.Object[] r6 = r0.ensureCapacity(r10)
            java.lang.System.arraycopy(r4, r9, r6, r13, r10)
            int r1 = r9 + 1
            int r15 = r5 + 1
            r5 = r4[r5]
            r4[r9] = r5
            int r3 = r3 + -1
            if (r3 != 0) goto L_0x0074
            java.lang.System.arraycopy(r6, r13, r4, r1, r10)
            goto L_0x0268
        L_0x0074:
            if (r10 != r2) goto L_0x0080
            java.lang.System.arraycopy(r4, r15, r4, r1, r3)
            int r1 = r1 + r3
            r2 = r6[r13]
            r4[r1] = r2
            goto L_0x0268
        L_0x0080:
            java.util.Comparator<? super T> r7 = r0.f3312c
            int r5 = r0.minGallop
            r8 = r5
            r5 = 0
        L_0x0086:
            r9 = 0
            r14 = 0
        L_0x0088:
            r13 = r4[r15]
            r11 = r6[r5]
            int r11 = r7.compare(r13, r11)
            if (r11 >= 0) goto L_0x00a6
            int r9 = r1 + 1
            int r11 = r15 + 1
            r13 = r4[r15]
            r4[r1] = r13
            int r14 = r14 + r2
            int r3 = r3 + -1
            if (r3 != 0) goto L_0x00a2
            r15 = r11
            goto L_0x0102
        L_0x00a2:
            r1 = r9
            r15 = r11
            r9 = 0
            goto L_0x00b9
        L_0x00a6:
            int r11 = r1 + 1
            int r13 = r5 + 1
            r5 = r6[r5]
            r4[r1] = r5
            int r9 = r9 + r2
            int r10 = r10 + -1
            if (r10 != r2) goto L_0x00b6
            r9 = r11
            r5 = r13
            goto L_0x0102
        L_0x00b6:
            r1 = r11
            r5 = r13
            r14 = 0
        L_0x00b9:
            r11 = r9 | r14
            if (r11 < r8) goto L_0x0088
            r9 = r15
        L_0x00be:
            r14 = r4[r9]
            r18 = 0
            r15 = r6
            r16 = r5
            r17 = r10
            r19 = r7
            int r11 = gallopRight(r14, r15, r16, r17, r18, r19)
            if (r11 == 0) goto L_0x00d8
            java.lang.System.arraycopy(r6, r5, r4, r1, r11)
            int r1 = r1 + r11
            int r5 = r5 + r11
            int r10 = r10 - r11
            if (r10 > r2) goto L_0x00d8
            goto L_0x0114
        L_0x00d8:
            int r13 = r1 + 1
            int r15 = r9 + 1
            r9 = r4[r9]
            r4[r1] = r9
            int r3 = r3 + -1
            if (r3 != 0) goto L_0x00e6
            r1 = r13
            goto L_0x0103
        L_0x00e6:
            r14 = r6[r5]
            r18 = 0
            r9 = r15
            r15 = r4
            r16 = r9
            r17 = r3
            r19 = r7
            int r1 = gallopLeft(r14, r15, r16, r17, r18, r19)
            if (r1 == 0) goto L_0x0106
            java.lang.System.arraycopy(r4, r9, r4, r13, r1)
            int r13 = r13 + r1
            int r15 = r9 + r1
            int r3 = r3 - r1
            if (r3 != 0) goto L_0x0105
            r9 = r13
        L_0x0102:
            r1 = r9
        L_0x0103:
            r9 = r15
            goto L_0x0114
        L_0x0105:
            r9 = r15
        L_0x0106:
            int r14 = r13 + 1
            int r15 = r5 + 1
            r5 = r6[r5]
            r4[r13] = r5
            int r10 = r10 + -1
            if (r10 != r2) goto L_0x0132
            r1 = r14
            r5 = r15
        L_0x0114:
            if (r8 >= r2) goto L_0x0117
            r8 = 1
        L_0x0117:
            r0.minGallop = r8
            if (r10 != r2) goto L_0x0125
            java.lang.System.arraycopy(r4, r9, r4, r1, r3)
            int r1 = r1 + r3
            r2 = r6[r5]
            r4[r1] = r2
            goto L_0x0268
        L_0x0125:
            if (r10 == 0) goto L_0x012c
            java.lang.System.arraycopy(r6, r5, r4, r1, r10)
            goto L_0x0268
        L_0x012c:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r12)
            throw r1
        L_0x0132:
            int r8 = r8 + -1
            r5 = 7
            if (r11 < r5) goto L_0x0139
            r11 = 1
            goto L_0x013a
        L_0x0139:
            r11 = 0
        L_0x013a:
            if (r1 < r5) goto L_0x013e
            r1 = 1
            goto L_0x013f
        L_0x013e:
            r1 = 0
        L_0x013f:
            r1 = r1 | r11
            if (r1 != 0) goto L_0x014d
            if (r8 >= 0) goto L_0x0145
            r8 = 0
        L_0x0145:
            int r8 = r8 + 2
            r1 = r14
            r5 = r15
            r13 = 0
            r15 = r9
            goto L_0x0086
        L_0x014d:
            r1 = r14
            r5 = r15
            goto L_0x00be
        L_0x0151:
            T[] r11 = r0.f3311a
            java.lang.Object[] r15 = r0.ensureCapacity(r3)
            r4 = 0
            java.lang.System.arraycopy(r11, r5, r15, r4, r3)
            int r4 = r3 + -1
            int r5 = r5 + r3
            int r5 = r5 - r2
            int r6 = r5 + -1
            int r7 = r1 + -1
            r1 = r11[r1]
            r11[r5] = r1
            int r10 = r10 + -1
            if (r10 != 0) goto L_0x0172
            int r6 = r6 - r4
            r1 = 0
            java.lang.System.arraycopy(r15, r1, r11, r6, r3)
            goto L_0x0268
        L_0x0172:
            if (r3 != r2) goto L_0x0182
            int r6 = r6 - r10
            int r7 = r7 - r10
            int r7 = r7 + r2
            int r1 = r6 + 1
            java.lang.System.arraycopy(r11, r7, r11, r1, r10)
            r1 = r15[r4]
            r11[r6] = r1
            goto L_0x0268
        L_0x0182:
            java.util.Comparator<? super T> r1 = r0.f3312c
            int r5 = r0.minGallop
        L_0x0186:
            r8 = r6
            r13 = r10
            r6 = 0
            r10 = r7
            r7 = 0
        L_0x018b:
            r14 = r15[r4]
            r2 = r11[r10]
            int r2 = r1.compare(r14, r2)
            if (r2 >= 0) goto L_0x01a9
            int r2 = r8 + -1
            int r6 = r10 + -1
            r10 = r11[r10]
            r11[r8] = r10
            r8 = 1
            int r7 = r7 + r8
            int r13 = r13 + -1
            if (r13 != 0) goto L_0x01a5
            r14 = r6
            goto L_0x01b9
        L_0x01a5:
            r8 = r2
            r10 = r6
            r6 = 0
            goto L_0x01c0
        L_0x01a9:
            int r2 = r8 + -1
            int r7 = r4 + -1
            r4 = r15[r4]
            r11[r8] = r4
            r4 = 1
            int r6 = r6 + r4
            int r3 = r3 + -1
            if (r3 != r4) goto L_0x01bd
            r4 = r7
            r14 = r10
        L_0x01b9:
            r10 = r15
        L_0x01ba:
            r15 = 1
            goto L_0x0249
        L_0x01bd:
            r8 = r2
            r4 = r7
            r7 = 0
        L_0x01c0:
            r2 = r7 | r6
            if (r2 < r5) goto L_0x0296
            r2 = r3
            r20 = r5
            r14 = r10
            r16 = r13
            r10 = r4
            r13 = r8
        L_0x01cc:
            r3 = r15[r10]
            int r7 = r16 + -1
            r4 = r11
            r5 = r9
            r6 = r16
            r8 = r1
            int r3 = gallopRight(r3, r4, r5, r6, r7, r8)
            int r3 = r16 - r3
            if (r3 == 0) goto L_0x01fa
            int r4 = r13 - r3
            int r5 = r14 - r3
            int r13 = r16 - r3
            int r6 = r5 + 1
            int r7 = r4 + 1
            java.lang.System.arraycopy(r11, r6, r11, r7, r3)
            if (r13 != 0) goto L_0x01f4
            r3 = r2
            r2 = r4
            r14 = r5
            r4 = r10
        L_0x01f0:
            r10 = r15
        L_0x01f1:
            r5 = r20
            goto L_0x01ba
        L_0x01f4:
            r21 = r13
            r13 = r4
            r4 = r21
            goto L_0x01fd
        L_0x01fa:
            r5 = r14
            r4 = r16
        L_0x01fd:
            int r6 = r13 + -1
            int r7 = r10 + -1
            r8 = r15[r10]
            r11[r13] = r8
            int r2 = r2 + -1
            r8 = 1
            if (r2 != r8) goto L_0x0210
            r3 = r2
            r13 = r4
            r14 = r5
            r2 = r6
            r4 = r7
            goto L_0x01f0
        L_0x0210:
            r13 = r11[r5]
            r8 = 0
            int r17 = r2 + -1
            r14 = r15
            r10 = r15
            r15 = r8
            r16 = r2
            r18 = r1
            int r8 = gallopLeft(r13, r14, r15, r16, r17, r18)
            int r8 = r2 - r8
            if (r8 == 0) goto L_0x0237
            int r6 = r6 - r8
            int r7 = r7 - r8
            int r2 = r2 - r8
            int r13 = r7 + 1
            int r14 = r6 + 1
            java.lang.System.arraycopy(r10, r13, r11, r14, r8)
            r13 = 1
            if (r2 > r13) goto L_0x0237
            r3 = r2
            r13 = r4
            r14 = r5
            r2 = r6
            r4 = r7
            goto L_0x01f1
        L_0x0237:
            int r13 = r6 + -1
            int r14 = r5 + -1
            r5 = r11[r5]
            r11[r6] = r5
            int r16 = r4 + -1
            if (r16 != 0) goto L_0x026f
            r3 = r2
            r4 = r7
            r2 = r13
            r13 = r16
            goto L_0x01f1
        L_0x0249:
            if (r5 >= r15) goto L_0x024d
            r8 = 1
            goto L_0x024e
        L_0x024d:
            r8 = r5
        L_0x024e:
            r0.minGallop = r8
            if (r3 != r15) goto L_0x025f
            int r2 = r2 - r13
            int r14 = r14 - r13
            int r14 = r14 + r15
            int r1 = r2 + 1
            java.lang.System.arraycopy(r11, r14, r11, r1, r13)
            r1 = r10[r4]
            r11[r2] = r1
            goto L_0x0268
        L_0x025f:
            if (r3 == 0) goto L_0x0269
            int r1 = r3 + -1
            int r2 = r2 - r1
            r4 = 0
            java.lang.System.arraycopy(r10, r4, r11, r2, r3)
        L_0x0268:
            return
        L_0x0269:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r12)
            throw r1
        L_0x026f:
            r4 = 0
            r15 = 1
            int r20 = r20 + -1
            r5 = 7
            if (r3 < r5) goto L_0x0278
            r3 = 1
            goto L_0x0279
        L_0x0278:
            r3 = 0
        L_0x0279:
            if (r8 < r5) goto L_0x027d
            r6 = 1
            goto L_0x027e
        L_0x027d:
            r6 = 0
        L_0x027e:
            r3 = r3 | r6
            if (r3 != 0) goto L_0x0292
            if (r20 >= 0) goto L_0x0285
            r20 = 0
        L_0x0285:
            int r3 = r20 + 2
            r5 = r3
            r4 = r7
            r15 = r10
            r6 = r13
            r7 = r14
            r10 = r16
            r3 = r2
            r2 = 1
            goto L_0x0186
        L_0x0292:
            r15 = r10
            r10 = r7
            goto L_0x01cc
        L_0x0296:
            r2 = 1
            goto L_0x018b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.TimSort.mergeAt(int):void");
    }
}
