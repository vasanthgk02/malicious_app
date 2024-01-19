package com.google.zxing.aztec;

import com.google.zxing.Writer;
import java.nio.charset.Charset;

public final class AztecWriter implements Writer {
    public static final Charset DEFAULT_CHARSET = Charset.forName("ISO-8859-1");

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0461  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.common.BitMatrix encode(java.lang.String r19, com.google.zxing.BarcodeFormat r20, int r21, int r22, java.util.Map<com.google.zxing.EncodeHintType, ?> r23) {
        /*
            r18 = this;
            r0 = r20
            r1 = r23
            java.nio.charset.Charset r2 = DEFAULT_CHARSET
            r3 = 0
            r4 = 33
            if (r1 == 0) goto L_0x004e
            com.google.zxing.EncodeHintType r5 = com.google.zxing.EncodeHintType.CHARACTER_SET
            boolean r5 = r1.containsKey(r5)
            if (r5 == 0) goto L_0x0021
            com.google.zxing.EncodeHintType r2 = com.google.zxing.EncodeHintType.CHARACTER_SET
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = r2.toString()
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r2)
        L_0x0021:
            com.google.zxing.EncodeHintType r5 = com.google.zxing.EncodeHintType.ERROR_CORRECTION
            boolean r5 = r1.containsKey(r5)
            if (r5 == 0) goto L_0x0037
            com.google.zxing.EncodeHintType r4 = com.google.zxing.EncodeHintType.ERROR_CORRECTION
            java.lang.Object r4 = r1.get(r4)
            java.lang.String r4 = r4.toString()
            int r4 = java.lang.Integer.parseInt(r4)
        L_0x0037:
            com.google.zxing.EncodeHintType r5 = com.google.zxing.EncodeHintType.AZTEC_LAYERS
            boolean r5 = r1.containsKey(r5)
            if (r5 == 0) goto L_0x004e
            com.google.zxing.EncodeHintType r5 = com.google.zxing.EncodeHintType.AZTEC_LAYERS
            java.lang.Object r1 = r1.get(r5)
            java.lang.String r1 = r1.toString()
            int r1 = java.lang.Integer.parseInt(r1)
            goto L_0x004f
        L_0x004e:
            r1 = 0
        L_0x004f:
            com.google.zxing.BarcodeFormat r5 = com.google.zxing.BarcodeFormat.AZTEC
            if (r0 != r5) goto L_0x0461
            r5 = r19
            byte[] r0 = r5.getBytes(r2)
            com.google.zxing.aztec.encoder.HighLevelEncoder r2 = new com.google.zxing.aztec.encoder.HighLevelEncoder
            r2.<init>(r0)
            com.google.zxing.aztec.encoder.State r0 = com.google.zxing.aztec.encoder.State.INITIAL_STATE
            java.util.List r0 = java.util.Collections.singletonList(r0)
            r5 = 0
        L_0x0065:
            byte[] r6 = r2.text
            int r7 = r6.length
            r8 = 32
            r9 = 3
            r10 = 10
            r11 = 4
            r12 = 2
            r13 = 1
            if (r5 >= r7) goto L_0x0177
            int r7 = r5 + 1
            int r14 = r6.length
            if (r7 >= r14) goto L_0x007a
            byte r6 = r6[r7]
            goto L_0x007b
        L_0x007a:
            r6 = 0
        L_0x007b:
            byte[] r14 = r2.text
            byte r14 = r14[r5]
            r15 = 13
            if (r14 == r15) goto L_0x009c
            r10 = 44
            if (r14 == r10) goto L_0x0098
            r10 = 46
            if (r14 == r10) goto L_0x0094
            r10 = 58
            if (r14 == r10) goto L_0x0090
            goto L_0x00a0
        L_0x0090:
            if (r6 != r8) goto L_0x00a0
            r6 = 5
            goto L_0x00a1
        L_0x0094:
            if (r6 != r8) goto L_0x00a0
            r6 = 3
            goto L_0x00a1
        L_0x0098:
            if (r6 != r8) goto L_0x00a0
            r6 = 4
            goto L_0x00a1
        L_0x009c:
            if (r6 != r10) goto L_0x00a0
            r6 = 2
            goto L_0x00a1
        L_0x00a0:
            r6 = 0
        L_0x00a1:
            if (r6 <= 0) goto L_0x00f6
            java.util.LinkedList r8 = new java.util.LinkedList
            r8.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x00ac:
            boolean r10 = r0.hasNext()
            if (r10 == 0) goto L_0x00ef
            java.lang.Object r10 = r0.next()
            com.google.zxing.aztec.encoder.State r10 = (com.google.zxing.aztec.encoder.State) r10
            com.google.zxing.aztec.encoder.State r14 = r10.endBinaryShift(r5)
            com.google.zxing.aztec.encoder.State r15 = r14.latchAndAppend(r11, r6)
            r8.add(r15)
            int r15 = r10.mode
            if (r15 == r11) goto L_0x00ce
            com.google.zxing.aztec.encoder.State r15 = r14.shiftAndAppend(r11, r6)
            r8.add(r15)
        L_0x00ce:
            if (r6 == r9) goto L_0x00d2
            if (r6 != r11) goto L_0x00df
        L_0x00d2:
            int r15 = 16 - r6
            com.google.zxing.aztec.encoder.State r14 = r14.latchAndAppend(r12, r15)
            com.google.zxing.aztec.encoder.State r14 = r14.latchAndAppend(r12, r13)
            r8.add(r14)
        L_0x00df:
            int r14 = r10.binaryShiftByteCount
            if (r14 <= 0) goto L_0x00ac
            com.google.zxing.aztec.encoder.State r10 = r10.addBinaryShiftChar(r5)
            com.google.zxing.aztec.encoder.State r10 = r10.addBinaryShiftChar(r7)
            r8.add(r10)
            goto L_0x00ac
        L_0x00ef:
            java.util.Collection r0 = com.google.zxing.aztec.encoder.HighLevelEncoder.simplifyStates(r8)
            r5 = r7
            goto L_0x0174
        L_0x00f6:
            java.util.LinkedList r6 = new java.util.LinkedList
            r6.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x00ff:
            boolean r7 = r0.hasNext()
            if (r7 == 0) goto L_0x0170
            java.lang.Object r7 = r0.next()
            com.google.zxing.aztec.encoder.State r7 = (com.google.zxing.aztec.encoder.State) r7
            byte[] r8 = r2.text
            byte r8 = r8[r5]
            r8 = r8 & 255(0xff, float:3.57E-43)
            char r8 = (char) r8
            int[][] r9 = com.google.zxing.aztec.encoder.HighLevelEncoder.CHAR_MAP
            int r10 = r7.mode
            r9 = r9[r10]
            r9 = r9[r8]
            if (r9 <= 0) goto L_0x011e
            r9 = 1
            goto L_0x011f
        L_0x011e:
            r9 = 0
        L_0x011f:
            r10 = 0
            r14 = 0
        L_0x0121:
            if (r10 > r11) goto L_0x0158
            int[][] r11 = com.google.zxing.aztec.encoder.HighLevelEncoder.CHAR_MAP
            r11 = r11[r10]
            r11 = r11[r8]
            if (r11 <= 0) goto L_0x0153
            if (r14 != 0) goto L_0x0131
            com.google.zxing.aztec.encoder.State r14 = r7.endBinaryShift(r5)
        L_0x0131:
            if (r9 == 0) goto L_0x0139
            int r15 = r7.mode
            if (r10 == r15) goto L_0x0139
            if (r10 != r12) goto L_0x0140
        L_0x0139:
            com.google.zxing.aztec.encoder.State r12 = r14.latchAndAppend(r10, r11)
            r6.add(r12)
        L_0x0140:
            if (r9 != 0) goto L_0x0153
            int[][] r12 = com.google.zxing.aztec.encoder.HighLevelEncoder.SHIFT_TABLE
            int r15 = r7.mode
            r12 = r12[r15]
            r12 = r12[r10]
            if (r12 < 0) goto L_0x0153
            com.google.zxing.aztec.encoder.State r11 = r14.shiftAndAppend(r10, r11)
            r6.add(r11)
        L_0x0153:
            int r10 = r10 + 1
            r11 = 4
            r12 = 2
            goto L_0x0121
        L_0x0158:
            int r9 = r7.binaryShiftByteCount
            if (r9 > 0) goto L_0x0166
            int[][] r9 = com.google.zxing.aztec.encoder.HighLevelEncoder.CHAR_MAP
            int r10 = r7.mode
            r9 = r9[r10]
            r8 = r9[r8]
            if (r8 != 0) goto L_0x016d
        L_0x0166:
            com.google.zxing.aztec.encoder.State r7 = r7.addBinaryShiftChar(r5)
            r6.add(r7)
        L_0x016d:
            r11 = 4
            r12 = 2
            goto L_0x00ff
        L_0x0170:
            java.util.Collection r0 = com.google.zxing.aztec.encoder.HighLevelEncoder.simplifyStates(r6)
        L_0x0174:
            int r5 = r5 + r13
            goto L_0x0065
        L_0x0177:
            com.google.zxing.aztec.encoder.HighLevelEncoder$1 r5 = new com.google.zxing.aztec.encoder.HighLevelEncoder$1
            r5.<init>(r2)
            java.lang.Object r0 = java.util.Collections.min(r0, r5)
            com.google.zxing.aztec.encoder.State r0 = (com.google.zxing.aztec.encoder.State) r0
            byte[] r2 = r2.text
            if (r0 == 0) goto L_0x045f
            java.util.LinkedList r5 = new java.util.LinkedList
            r5.<init>()
            int r6 = r2.length
            com.google.zxing.aztec.encoder.State r0 = r0.endBinaryShift(r6)
            com.google.zxing.aztec.encoder.Token r0 = r0.token
        L_0x0192:
            if (r0 == 0) goto L_0x019a
            r5.addFirst(r0)
            com.google.zxing.aztec.encoder.Token r0 = r0.previous
            goto L_0x0192
        L_0x019a:
            com.google.zxing.common.BitArray r0 = new com.google.zxing.common.BitArray
            r0.<init>()
            java.util.Iterator r5 = r5.iterator()
        L_0x01a3:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x01b3
            java.lang.Object r6 = r5.next()
            com.google.zxing.aztec.encoder.Token r6 = (com.google.zxing.aztec.encoder.Token) r6
            r6.appendTo(r0, r2)
            goto L_0x01a3
        L_0x01b3:
            int r2 = r0.size
            r5 = 100
            r6 = 11
            int r4 = com.android.tools.r8.GeneratedOutlineSupport.outline8(r4, r2, r5, r6)
            int r2 = r2 + r4
            if (r1 == 0) goto L_0x0215
            if (r1 >= 0) goto L_0x01c4
            r2 = 1
            goto L_0x01c5
        L_0x01c4:
            r2 = 0
        L_0x01c5:
            int r5 = java.lang.Math.abs(r1)
            if (r2 == 0) goto L_0x01cc
            r8 = 4
        L_0x01cc:
            if (r5 > r8) goto L_0x0201
            if (r2 == 0) goto L_0x01d3
            r1 = 88
            goto L_0x01d5
        L_0x01d3:
            r1 = 112(0x70, float:1.57E-43)
        L_0x01d5:
            int r3 = r5 << 4
            int r1 = r1 + r3
            int r1 = r1 * r5
            int[] r3 = com.google.zxing.aztec.encoder.Encoder.WORD_SIZE
            r3 = r3[r5]
            int r7 = r1 % r3
            int r7 = r1 - r7
            com.google.zxing.common.BitArray r0 = com.google.zxing.aztec.encoder.Encoder.stuffBits(r0, r3)
            int r8 = r0.size
            int r4 = r4 + r8
            java.lang.String r9 = "Data to large for user specified layer"
            if (r4 > r7) goto L_0x01fb
            if (r2 == 0) goto L_0x025c
            int r4 = r3 << 6
            if (r8 > r4) goto L_0x01f5
            goto L_0x025c
        L_0x01f5:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r9)
            throw r0
        L_0x01fb:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r9)
            throw r0
        L_0x0201:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.Object[] r2 = new java.lang.Object[r13]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2[r3] = r1
            java.lang.String r1 = "Illegal value %s for layers"
            java.lang.String r1 = java.lang.String.format(r1, r2)
            r0.<init>(r1)
            throw r0
        L_0x0215:
            r1 = 0
            r3 = 0
            r5 = 0
        L_0x0218:
            if (r1 > r8) goto L_0x0457
            if (r1 > r9) goto L_0x021e
            r7 = 1
            goto L_0x021f
        L_0x021e:
            r7 = 0
        L_0x021f:
            if (r7 == 0) goto L_0x0224
            int r8 = r1 + 1
            goto L_0x0225
        L_0x0224:
            r8 = r1
        L_0x0225:
            if (r7 == 0) goto L_0x022a
            r10 = 88
            goto L_0x022c
        L_0x022a:
            r10 = 112(0x70, float:1.57E-43)
        L_0x022c:
            int r11 = r8 << 4
            int r10 = r10 + r11
            int r10 = r10 * r8
            if (r2 > r10) goto L_0x044a
            int[] r11 = com.google.zxing.aztec.encoder.Encoder.WORD_SIZE
            r12 = r11[r8]
            if (r5 == r12) goto L_0x0244
            r3 = r11[r8]
            com.google.zxing.common.BitArray r5 = com.google.zxing.aztec.encoder.Encoder.stuffBits(r0, r3)
            r17 = r5
            r5 = r3
            r3 = r17
        L_0x0244:
            int r11 = r10 % r5
            int r11 = r10 - r11
            if (r7 == 0) goto L_0x0250
            int r12 = r3.size
            int r14 = r5 << 6
            if (r12 > r14) goto L_0x044a
        L_0x0250:
            int r12 = r3.size
            int r12 = r12 + r4
            if (r12 <= r11) goto L_0x0257
            goto L_0x044a
        L_0x0257:
            r0 = r3
            r3 = r5
            r2 = r7
            r5 = r8
            r1 = r10
        L_0x025c:
            com.google.zxing.common.BitArray r1 = com.google.zxing.aztec.encoder.Encoder.generateCheckWords(r0, r1, r3)
            int r0 = r0.size
            int r0 = r0 / r3
            com.google.zxing.common.BitArray r3 = new com.google.zxing.common.BitArray
            r3.<init>()
            if (r2 == 0) goto L_0x027e
            int r4 = r5 + -1
            r7 = 2
            r3.appendBits(r4, r7)
            int r0 = r0 + -1
            r4 = 6
            r3.appendBits(r0, r4)
            r0 = 28
            r4 = 4
            com.google.zxing.common.BitArray r0 = com.google.zxing.aztec.encoder.Encoder.generateCheckWords(r3, r0, r4)
            goto L_0x0290
        L_0x027e:
            r4 = 4
            int r7 = r5 + -1
            r8 = 5
            r3.appendBits(r7, r8)
            int r0 = r0 + -1
            r3.appendBits(r0, r6)
            r0 = 40
            com.google.zxing.common.BitArray r0 = com.google.zxing.aztec.encoder.Encoder.generateCheckWords(r3, r0, r4)
        L_0x0290:
            if (r2 == 0) goto L_0x0293
            goto L_0x0295
        L_0x0293:
            r6 = 14
        L_0x0295:
            int r3 = r5 << 2
            int r6 = r6 + r3
            int[] r3 = new int[r6]
            if (r2 == 0) goto L_0x02a6
            r4 = 0
        L_0x029d:
            if (r4 >= r6) goto L_0x02a4
            r3[r4] = r4
            int r4 = r4 + 1
            goto L_0x029d
        L_0x02a4:
            r8 = r6
            goto L_0x02cb
        L_0x02a6:
            int r4 = r6 + 1
            int r7 = r6 / 2
            int r8 = r7 + -1
            int r8 = r8 / 15
            int r8 = r8 * 2
            int r8 = r8 + r4
            int r4 = r8 / 2
            r9 = 0
        L_0x02b4:
            if (r9 >= r7) goto L_0x02cb
            int r10 = r9 / 15
            int r10 = r10 + r9
            int r11 = r7 - r9
            int r11 = r11 - r13
            int r12 = r4 - r10
            int r12 = r12 + -1
            r3[r11] = r12
            int r11 = r7 + r9
            int r10 = r10 + r4
            int r10 = r10 + r13
            r3[r11] = r10
            int r9 = r9 + 1
            goto L_0x02b4
        L_0x02cb:
            com.google.zxing.common.BitMatrix r4 = new com.google.zxing.common.BitMatrix
            r4.<init>(r8, r8)
            r7 = 0
            r9 = 0
        L_0x02d2:
            if (r7 >= r5) goto L_0x035a
            int r10 = r5 - r7
            int r10 = r10 << 2
            if (r2 == 0) goto L_0x02dd
            r11 = 9
            goto L_0x02df
        L_0x02dd:
            r11 = 12
        L_0x02df:
            int r10 = r10 + r11
            r11 = 0
        L_0x02e1:
            if (r11 >= r10) goto L_0x0353
            int r12 = r11 << 1
            r13 = 0
        L_0x02e6:
            r14 = 2
            if (r13 >= r14) goto L_0x0350
            int r14 = r9 + r12
            int r14 = r14 + r13
            boolean r14 = r1.get(r14)
            if (r14 == 0) goto L_0x02fe
            int r14 = r7 << 1
            int r15 = r14 + r13
            r15 = r3[r15]
            int r14 = r14 + r11
            r14 = r3[r14]
            r4.set(r15, r14)
        L_0x02fe:
            int r14 = r10 << 1
            int r14 = r14 + r9
            int r14 = r14 + r12
            int r14 = r14 + r13
            boolean r14 = r1.get(r14)
            if (r14 == 0) goto L_0x031a
            int r14 = r7 << 1
            int r15 = r14 + r11
            r15 = r3[r15]
            int r16 = r6 + -1
            int r16 = r16 - r14
            int r16 = r16 - r13
            r14 = r3[r16]
            r4.set(r15, r14)
        L_0x031a:
            int r14 = r10 << 2
            int r14 = r14 + r9
            int r14 = r14 + r12
            int r14 = r14 + r13
            boolean r14 = r1.get(r14)
            if (r14 == 0) goto L_0x0334
            int r14 = r6 + -1
            int r15 = r7 << 1
            int r14 = r14 - r15
            int r15 = r14 - r13
            r15 = r3[r15]
            int r14 = r14 - r11
            r14 = r3[r14]
            r4.set(r15, r14)
        L_0x0334:
            int r14 = r10 * 6
            int r14 = r14 + r9
            int r14 = r14 + r12
            int r14 = r14 + r13
            boolean r14 = r1.get(r14)
            if (r14 == 0) goto L_0x034d
            int r14 = r6 + -1
            int r15 = r7 << 1
            int r14 = r14 - r15
            int r14 = r14 - r11
            r14 = r3[r14]
            int r15 = r15 + r13
            r15 = r3[r15]
            r4.set(r14, r15)
        L_0x034d:
            int r13 = r13 + 1
            goto L_0x02e6
        L_0x0350:
            int r11 = r11 + 1
            goto L_0x02e1
        L_0x0353:
            int r10 = r10 << 3
            int r9 = r9 + r10
            int r7 = r7 + 1
            goto L_0x02d2
        L_0x035a:
            int r1 = r8 / 2
            r3 = 7
            if (r2 == 0) goto L_0x039a
            r5 = 0
        L_0x0360:
            if (r5 >= r3) goto L_0x03da
            int r7 = r1 + -3
            int r7 = r7 + r5
            boolean r9 = r0.get(r5)
            if (r9 == 0) goto L_0x0370
            int r9 = r1 + -5
            r4.set(r7, r9)
        L_0x0370:
            int r9 = r5 + 7
            boolean r9 = r0.get(r9)
            if (r9 == 0) goto L_0x037d
            int r9 = r1 + 5
            r4.set(r9, r7)
        L_0x037d:
            int r9 = 20 - r5
            boolean r9 = r0.get(r9)
            if (r9 == 0) goto L_0x038a
            int r9 = r1 + 5
            r4.set(r7, r9)
        L_0x038a:
            int r9 = 27 - r5
            boolean r9 = r0.get(r9)
            if (r9 == 0) goto L_0x0397
            int r9 = r1 + -5
            r4.set(r9, r7)
        L_0x0397:
            int r5 = r5 + 1
            goto L_0x0360
        L_0x039a:
            r5 = 0
            r7 = 10
        L_0x039d:
            if (r5 >= r7) goto L_0x03da
            int r9 = r1 + -5
            int r9 = r9 + r5
            int r10 = r5 / 5
            int r10 = r10 + r9
            boolean r9 = r0.get(r5)
            if (r9 == 0) goto L_0x03b0
            int r9 = r1 + -7
            r4.set(r10, r9)
        L_0x03b0:
            int r9 = r5 + 10
            boolean r9 = r0.get(r9)
            if (r9 == 0) goto L_0x03bd
            int r9 = r1 + 7
            r4.set(r9, r10)
        L_0x03bd:
            int r9 = 29 - r5
            boolean r9 = r0.get(r9)
            if (r9 == 0) goto L_0x03ca
            int r9 = r1 + 7
            r4.set(r10, r9)
        L_0x03ca:
            int r9 = 39 - r5
            boolean r9 = r0.get(r9)
            if (r9 == 0) goto L_0x03d7
            int r9 = r1 + -7
            r4.set(r9, r10)
        L_0x03d7:
            int r5 = r5 + 1
            goto L_0x039d
        L_0x03da:
            if (r2 == 0) goto L_0x03e1
            r0 = 5
            com.google.zxing.aztec.encoder.Encoder.drawBullsEye(r4, r1, r0)
            goto L_0x0408
        L_0x03e1:
            com.google.zxing.aztec.encoder.Encoder.drawBullsEye(r4, r1, r3)
            r0 = 0
            r2 = 0
        L_0x03e6:
            int r3 = r6 / 2
            int r3 = r3 + -1
            if (r0 >= r3) goto L_0x0408
            r3 = r1 & 1
        L_0x03ee:
            if (r3 >= r8) goto L_0x0403
            int r5 = r1 - r2
            r4.set(r5, r3)
            int r7 = r1 + r2
            r4.set(r7, r3)
            r4.set(r3, r5)
            r4.set(r3, r7)
            int r3 = r3 + 2
            goto L_0x03ee
        L_0x0403:
            int r0 = r0 + 15
            int r2 = r2 + 16
            goto L_0x03e6
        L_0x0408:
            int r0 = r4.width
            int r1 = r4.height
            r7 = r21
            int r2 = java.lang.Math.max(r7, r0)
            r8 = r22
            int r3 = java.lang.Math.max(r8, r1)
            int r5 = r2 / r0
            int r6 = r3 / r1
            int r5 = java.lang.Math.min(r5, r6)
            int r6 = r0 * r5
            int r6 = r2 - r6
            int r6 = r6 / 2
            int r7 = r1 * r5
            int r7 = r3 - r7
            int r7 = r7 / 2
            com.google.zxing.common.BitMatrix r8 = new com.google.zxing.common.BitMatrix
            r8.<init>(r2, r3)
            r2 = 0
        L_0x0432:
            if (r2 >= r1) goto L_0x0449
            r3 = 0
            r9 = r6
        L_0x0436:
            if (r3 >= r0) goto L_0x0445
            boolean r10 = r4.get(r3, r2)
            if (r10 == 0) goto L_0x0441
            r8.setRegion(r9, r7, r5, r5)
        L_0x0441:
            int r3 = r3 + 1
            int r9 = r9 + r5
            goto L_0x0436
        L_0x0445:
            int r2 = r2 + 1
            int r7 = r7 + r5
            goto L_0x0432
        L_0x0449:
            return r8
        L_0x044a:
            r7 = r21
            r8 = r22
            int r1 = r1 + 1
            r10 = 32
            r13 = 1
            r8 = 32
            goto L_0x0218
        L_0x0457:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Data too large for an Aztec code"
            r0.<init>(r1)
            throw r0
        L_0x045f:
            r0 = 0
            throw r0
        L_0x0461:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Can only encode AZTEC, but got "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.AztecWriter.encode(java.lang.String, com.google.zxing.BarcodeFormat, int, int, java.util.Map):com.google.zxing.common.BitMatrix");
    }
}
