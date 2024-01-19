package com.google.zxing.qrcode;

import com.google.zxing.Writer;

public final class QRCodeWriter implements Writer {
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006c A[SYNTHETIC, Splitter:B:23:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x063e  */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x00bd A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x0150 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0140 A[LOOP:2: B:77:0x0111->B:92:0x0140, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.common.BitMatrix encode(java.lang.String r27, com.google.zxing.BarcodeFormat r28, int r29, int r30, java.util.Map<com.google.zxing.EncodeHintType, ?> r31) throws com.google.zxing.WriterException {
        /*
            r26 = this;
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            boolean r5 = r27.isEmpty()
            if (r5 != 0) goto L_0x068c
            com.google.zxing.BarcodeFormat r5 = com.google.zxing.BarcodeFormat.QR_CODE
            if (r1 != r5) goto L_0x0678
            if (r2 < 0) goto L_0x065a
            if (r3 < 0) goto L_0x065a
            com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r1 = com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.L
            r5 = 4
            if (r4 == 0) goto L_0x004a
            com.google.zxing.EncodeHintType r6 = com.google.zxing.EncodeHintType.ERROR_CORRECTION
            boolean r6 = r4.containsKey(r6)
            if (r6 == 0) goto L_0x0033
            com.google.zxing.EncodeHintType r1 = com.google.zxing.EncodeHintType.ERROR_CORRECTION
            java.lang.Object r1 = r4.get(r1)
            java.lang.String r1 = r1.toString()
            com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r1 = com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.valueOf(r1)
        L_0x0033:
            com.google.zxing.EncodeHintType r6 = com.google.zxing.EncodeHintType.MARGIN
            boolean r6 = r4.containsKey(r6)
            if (r6 == 0) goto L_0x004a
            com.google.zxing.EncodeHintType r6 = com.google.zxing.EncodeHintType.MARGIN
            java.lang.Object r6 = r4.get(r6)
            java.lang.String r6 = r6.toString()
            int r6 = java.lang.Integer.parseInt(r6)
            goto L_0x004b
        L_0x004a:
            r6 = 4
        L_0x004b:
            java.lang.String r7 = "ISO-8859-1"
            if (r4 == 0) goto L_0x0062
            com.google.zxing.EncodeHintType r8 = com.google.zxing.EncodeHintType.CHARACTER_SET
            boolean r8 = r4.containsKey(r8)
            if (r8 == 0) goto L_0x0062
            com.google.zxing.EncodeHintType r8 = com.google.zxing.EncodeHintType.CHARACTER_SET
            java.lang.Object r8 = r4.get(r8)
            java.lang.String r8 = r8.toString()
            goto L_0x0063
        L_0x0062:
            r8 = r7
        L_0x0063:
            java.lang.String r9 = "Shift_JIS"
            boolean r10 = r9.equals(r8)
            r11 = -1
            if (r10 == 0) goto L_0x0099
            byte[] r10 = r0.getBytes(r9)     // Catch:{ UnsupportedEncodingException -> 0x0093 }
            int r14 = r10.length
            int r15 = r14 % 2
            if (r15 == 0) goto L_0x0076
            goto L_0x0093
        L_0x0076:
            r15 = 0
        L_0x0077:
            if (r15 >= r14) goto L_0x0091
            byte r12 = r10[r15]
            r12 = r12 & 255(0xff, float:3.57E-43)
            r13 = 129(0x81, float:1.81E-43)
            if (r12 < r13) goto L_0x0085
            r13 = 159(0x9f, float:2.23E-43)
            if (r12 <= r13) goto L_0x008e
        L_0x0085:
            r13 = 224(0xe0, float:3.14E-43)
            if (r12 < r13) goto L_0x0093
            r13 = 235(0xeb, float:3.3E-43)
            if (r12 <= r13) goto L_0x008e
            goto L_0x0093
        L_0x008e:
            int r15 = r15 + 2
            goto L_0x0077
        L_0x0091:
            r10 = 1
            goto L_0x0094
        L_0x0093:
            r10 = 0
        L_0x0094:
            if (r10 == 0) goto L_0x0099
            com.google.zxing.qrcode.decoder.Mode r10 = com.google.zxing.qrcode.decoder.Mode.KANJI
            goto L_0x00c9
        L_0x0099:
            r10 = 0
            r12 = 0
            r13 = 0
        L_0x009c:
            int r14 = r27.length()
            if (r10 >= r14) goto L_0x00bd
            char r14 = r0.charAt(r10)
            r15 = 48
            if (r14 < r15) goto L_0x00b0
            r15 = 57
            if (r14 > r15) goto L_0x00b0
            r13 = 1
            goto L_0x00b7
        L_0x00b0:
            int r12 = com.google.zxing.qrcode.encoder.Encoder.getAlphanumericCode(r14)
            if (r12 == r11) goto L_0x00ba
            r12 = 1
        L_0x00b7:
            int r10 = r10 + 1
            goto L_0x009c
        L_0x00ba:
            com.google.zxing.qrcode.decoder.Mode r10 = com.google.zxing.qrcode.decoder.Mode.BYTE
            goto L_0x00c9
        L_0x00bd:
            if (r12 == 0) goto L_0x00c2
            com.google.zxing.qrcode.decoder.Mode r10 = com.google.zxing.qrcode.decoder.Mode.ALPHANUMERIC
            goto L_0x00c9
        L_0x00c2:
            if (r13 == 0) goto L_0x00c7
            com.google.zxing.qrcode.decoder.Mode r10 = com.google.zxing.qrcode.decoder.Mode.NUMERIC
            goto L_0x00c9
        L_0x00c7:
            com.google.zxing.qrcode.decoder.Mode r10 = com.google.zxing.qrcode.decoder.Mode.BYTE
        L_0x00c9:
            com.google.zxing.common.BitArray r12 = new com.google.zxing.common.BitArray
            r12.<init>()
            com.google.zxing.qrcode.decoder.Mode r13 = com.google.zxing.qrcode.decoder.Mode.BYTE
            r14 = 8
            if (r10 != r13) goto L_0x00f0
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x00f0
            com.google.zxing.common.CharacterSetECI r7 = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByName(r8)
            if (r7 == 0) goto L_0x00f0
            com.google.zxing.qrcode.decoder.Mode r13 = com.google.zxing.qrcode.decoder.Mode.ECI
            int r13 = r13.getBits()
            r12.appendBits(r13, r5)
            int r7 = r7.getValue()
            r12.appendBits(r7, r14)
        L_0x00f0:
            int r7 = r10.getBits()
            r12.appendBits(r7, r5)
            com.google.zxing.common.BitArray r7 = new com.google.zxing.common.BitArray
            r7.<init>()
            int r13 = r10.ordinal()
            r15 = 2
            r11 = 1
            if (r13 == r11) goto L_0x01ca
            r11 = 6
            if (r13 == r15) goto L_0x018c
            if (r13 == r5) goto L_0x0174
            if (r13 != r11) goto L_0x0160
            byte[] r8 = r0.getBytes(r9)     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            int r9 = r8.length
            r11 = 0
        L_0x0111:
            if (r11 >= r9) goto L_0x020e
            byte r13 = r8[r11]
            r13 = r13 & 255(0xff, float:3.57E-43)
            int r19 = r11 + 1
            byte r15 = r8[r19]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r13 = r13 << r14
            r13 = r13 | r15
            r15 = 33088(0x8140, float:4.6366E-41)
            if (r13 < r15) goto L_0x012d
            r15 = 40956(0x9ffc, float:5.7392E-41)
            if (r13 > r15) goto L_0x012d
            r15 = 33088(0x8140, float:4.6366E-41)
            goto L_0x013a
        L_0x012d:
            r15 = 57408(0xe040, float:8.0446E-41)
            if (r13 < r15) goto L_0x013c
            r15 = 60351(0xebbf, float:8.457E-41)
            if (r13 > r15) goto L_0x013c
            r15 = 49472(0xc140, float:6.9325E-41)
        L_0x013a:
            int r13 = r13 - r15
            goto L_0x013d
        L_0x013c:
            r13 = -1
        L_0x013d:
            r15 = -1
            if (r13 == r15) goto L_0x0150
            int r15 = r13 >> 8
            int r15 = r15 * 192
            r13 = r13 & 255(0xff, float:3.57E-43)
            int r15 = r15 + r13
            r13 = 13
            r7.appendBits(r15, r13)
            int r11 = r11 + 2
            r15 = 2
            goto L_0x0111
        L_0x0150:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Invalid byte sequence"
            r0.<init>(r1)
            throw r0
        L_0x0158:
            r0 = move-exception
            r1 = r0
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            r0.<init>(r1)
            throw r0
        L_0x0160:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Invalid mode: "
            r1.<init>(r2)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0174:
            byte[] r8 = r0.getBytes(r8)     // Catch:{ UnsupportedEncodingException -> 0x0184 }
            int r9 = r8.length
            r11 = 0
        L_0x017a:
            if (r11 >= r9) goto L_0x020e
            byte r13 = r8[r11]
            r7.appendBits(r13, r14)
            int r11 = r11 + 1
            goto L_0x017a
        L_0x0184:
            r0 = move-exception
            r1 = r0
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            r0.<init>(r1)
            throw r0
        L_0x018c:
            int r8 = r27.length()
            r9 = 0
        L_0x0191:
            if (r9 >= r8) goto L_0x020e
            char r13 = r0.charAt(r9)
            int r13 = com.google.zxing.qrcode.encoder.Encoder.getAlphanumericCode(r13)
            r15 = -1
            if (r13 == r15) goto L_0x01c4
            int r14 = r9 + 1
            if (r14 >= r8) goto L_0x01bd
            char r14 = r0.charAt(r14)
            int r14 = com.google.zxing.qrcode.encoder.Encoder.getAlphanumericCode(r14)
            if (r14 == r15) goto L_0x01b7
            int r13 = r13 * 45
            int r13 = r13 + r14
            r14 = 11
            r7.appendBits(r13, r14)
            int r9 = r9 + 2
            goto L_0x01c1
        L_0x01b7:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            r0.<init>()
            throw r0
        L_0x01bd:
            r7.appendBits(r13, r11)
            r9 = r14
        L_0x01c1:
            r14 = 8
            goto L_0x0191
        L_0x01c4:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            r0.<init>()
            throw r0
        L_0x01ca:
            int r8 = r27.length()
            r9 = 0
        L_0x01cf:
            if (r9 >= r8) goto L_0x020e
            char r11 = r0.charAt(r9)
            int r11 = r11 + -48
            int r13 = r9 + 2
            if (r13 >= r8) goto L_0x01f7
            int r14 = r9 + 1
            char r14 = r0.charAt(r14)
            int r14 = r14 + -48
            char r13 = r0.charAt(r13)
            int r13 = r13 + -48
            int r11 = r11 * 100
            r15 = 10
            int r14 = r14 * 10
            int r14 = r14 + r11
            int r14 = r14 + r13
            r7.appendBits(r14, r15)
            int r9 = r9 + 3
            goto L_0x01cf
        L_0x01f7:
            int r9 = r9 + 1
            if (r9 >= r8) goto L_0x020a
            char r9 = r0.charAt(r9)
            int r9 = r9 + -48
            int r11 = r11 * 10
            int r11 = r11 + r9
            r9 = 7
            r7.appendBits(r11, r9)
            r9 = r13
            goto L_0x01cf
        L_0x020a:
            r7.appendBits(r11, r5)
            goto L_0x01cf
        L_0x020e:
            if (r4 == 0) goto L_0x0243
            com.google.zxing.EncodeHintType r8 = com.google.zxing.EncodeHintType.QR_VERSION
            boolean r8 = r4.containsKey(r8)
            if (r8 == 0) goto L_0x0243
            com.google.zxing.EncodeHintType r8 = com.google.zxing.EncodeHintType.QR_VERSION
            java.lang.Object r4 = r4.get(r8)
            java.lang.String r4 = r4.toString()
            int r4 = java.lang.Integer.parseInt(r4)
            com.google.zxing.qrcode.decoder.Version r4 = com.google.zxing.qrcode.decoder.Version.getVersionForNumber(r4)
            int r8 = r12.size
            int r9 = r10.getCharacterCountBits(r4)
            int r9 = r9 + r8
            int r8 = r7.size
            int r9 = r9 + r8
            boolean r8 = com.google.zxing.qrcode.encoder.Encoder.willFit(r9, r4, r1)
            if (r8 == 0) goto L_0x023b
            goto L_0x0264
        L_0x023b:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Data too big for requested version"
            r0.<init>(r1)
            throw r0
        L_0x0243:
            r4 = 1
            com.google.zxing.qrcode.decoder.Version r8 = com.google.zxing.qrcode.decoder.Version.getVersionForNumber(r4)
            int r4 = r12.size
            int r8 = r10.getCharacterCountBits(r8)
            int r8 = r8 + r4
            int r4 = r7.size
            int r8 = r8 + r4
            com.google.zxing.qrcode.decoder.Version r4 = com.google.zxing.qrcode.encoder.Encoder.chooseVersion(r8, r1)
            int r8 = r12.size
            int r4 = r10.getCharacterCountBits(r4)
            int r4 = r4 + r8
            int r8 = r7.size
            int r4 = r4 + r8
            com.google.zxing.qrcode.decoder.Version r4 = com.google.zxing.qrcode.encoder.Encoder.chooseVersion(r4, r1)
        L_0x0264:
            com.google.zxing.common.BitArray r8 = new com.google.zxing.common.BitArray
            r8.<init>()
            r8.appendBitArray(r12)
            com.google.zxing.qrcode.decoder.Mode r9 = com.google.zxing.qrcode.decoder.Mode.BYTE
            if (r10 != r9) goto L_0x0275
            int r0 = r7.getSizeInBytes()
            goto L_0x0279
        L_0x0275:
            int r0 = r27.length()
        L_0x0279:
            int r9 = r10.getCharacterCountBits(r4)
            r10 = 1
            int r11 = r10 << r9
            if (r0 >= r11) goto L_0x063e
            r8.appendBits(r0, r9)
            r8.appendBitArray(r7)
            com.google.zxing.qrcode.decoder.Version$ECBlocks[] r0 = r4.ecBlocks
            int r7 = r1.ordinal()
            r0 = r0[r7]
            int r7 = r4.totalCodewords
            int r9 = r0.ecCodewordsPerBlock
            int r10 = r0.getNumBlocks()
            int r10 = r10 * r9
            int r7 = r7 - r10
            int r9 = r7 << 3
            int r10 = r8.size
            if (r10 > r9) goto L_0x0620
            r10 = 0
        L_0x02a2:
            if (r10 >= r5) goto L_0x02af
            int r11 = r8.size
            if (r11 >= r9) goto L_0x02af
            r11 = 0
            r8.appendBit(r11)
            int r10 = r10 + 1
            goto L_0x02a2
        L_0x02af:
            r11 = 0
            int r10 = r8.size
            r12 = 7
            r10 = r10 & r12
            if (r10 <= 0) goto L_0x02c1
        L_0x02b6:
            r12 = 8
            if (r10 >= r12) goto L_0x02c1
            r8.appendBit(r11)
            int r10 = r10 + 1
            r11 = 0
            goto L_0x02b6
        L_0x02c1:
            int r10 = r8.getSizeInBytes()
            int r10 = r7 - r10
            r11 = 0
        L_0x02c8:
            if (r11 >= r10) goto L_0x02db
            r13 = r11 & 1
            if (r13 != 0) goto L_0x02d1
            r12 = 236(0xec, float:3.31E-43)
            goto L_0x02d3
        L_0x02d1:
            r12 = 17
        L_0x02d3:
            r13 = 8
            r8.appendBits(r12, r13)
            int r11 = r11 + 1
            goto L_0x02c8
        L_0x02db:
            int r10 = r8.size
            if (r10 != r9) goto L_0x0618
            int r9 = r4.totalCodewords
            int r0 = r0.getNumBlocks()
            int r10 = r8.getSizeInBytes()
            if (r10 != r7) goto L_0x0610
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>(r0)
            r11 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x02f4:
            if (r11 >= r0) goto L_0x03e0
            r12 = 1
            int[] r5 = new int[r12]
            int[] r3 = new int[r12]
            if (r11 >= r0) goto L_0x03d8
            int r12 = r9 % r0
            int r2 = r0 - r12
            int r20 = r9 / r0
            int r21 = r20 + 1
            int r22 = r7 / r0
            int r23 = r22 + 1
            r24 = r6
            int r6 = r20 - r22
            r20 = r1
            int r1 = r21 - r23
            if (r6 != r1) goto L_0x03d0
            r21 = r4
            int r4 = r2 + r12
            if (r0 != r4) goto L_0x03c8
            int r4 = r22 + r6
            int r4 = r4 * r2
            int r25 = r23 + r1
            int r25 = r25 * r12
            int r4 = r25 + r4
            if (r9 != r4) goto L_0x03c0
            if (r11 >= r2) goto L_0x032d
            r2 = 0
            r5[r2] = r22
            r3[r2] = r6
            goto L_0x0332
        L_0x032d:
            r2 = 0
            r5[r2] = r23
            r3[r2] = r1
        L_0x0332:
            r1 = r5[r2]
            byte[] r2 = new byte[r1]
            int r4 = r13 << 3
            r6 = r4
            r4 = 0
        L_0x033a:
            if (r4 >= r1) goto L_0x0369
            r31 = r0
            r0 = r6
            r22 = r9
            r6 = 0
            r9 = 8
            r12 = 0
        L_0x0345:
            if (r6 >= r9) goto L_0x035c
            boolean r9 = r8.get(r0)
            if (r9 == 0) goto L_0x0355
            int r9 = 7 - r6
            r16 = 1
            int r9 = r16 << r9
            r9 = r9 | r12
            r12 = r9
        L_0x0355:
            int r0 = r0 + 1
            int r6 = r6 + 1
            r9 = 8
            goto L_0x0345
        L_0x035c:
            int r6 = r4 + 0
            byte r9 = (byte) r12
            r2[r6] = r9
            int r4 = r4 + 1
            r6 = r0
            r9 = r22
            r0 = r31
            goto L_0x033a
        L_0x0369:
            r31 = r0
            r22 = r9
            r0 = 0
            r3 = r3[r0]
            int r0 = r1 + r3
            int[] r0 = new int[r0]
            r4 = 0
        L_0x0375:
            if (r4 >= r1) goto L_0x0380
            byte r6 = r2[r4]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r0[r4] = r6
            int r4 = r4 + 1
            goto L_0x0375
        L_0x0380:
            com.google.zxing.common.reedsolomon.ReedSolomonEncoder r4 = new com.google.zxing.common.reedsolomon.ReedSolomonEncoder
            com.google.zxing.common.reedsolomon.GenericGF r6 = com.google.zxing.common.reedsolomon.GenericGF.QR_CODE_FIELD_256
            r4.<init>(r6)
            r4.encode(r0, r3)
            byte[] r4 = new byte[r3]
            r6 = 0
        L_0x038d:
            if (r6 >= r3) goto L_0x0399
            int r9 = r1 + r6
            r9 = r0[r9]
            byte r9 = (byte) r9
            r4[r6] = r9
            int r6 = r6 + 1
            goto L_0x038d
        L_0x0399:
            com.google.zxing.qrcode.encoder.BlockPair r0 = new com.google.zxing.qrcode.encoder.BlockPair
            r0.<init>(r2, r4)
            r10.add(r0)
            int r14 = java.lang.Math.max(r14, r1)
            int r15 = java.lang.Math.max(r15, r3)
            r0 = 0
            r1 = r5[r0]
            int r13 = r13 + r1
            int r11 = r11 + 1
            r2 = r29
            r3 = r30
            r0 = r31
            r1 = r20
            r4 = r21
            r9 = r22
            r6 = r24
            r5 = 4
            goto L_0x02f4
        L_0x03c0:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Total bytes mismatch"
            r0.<init>(r1)
            throw r0
        L_0x03c8:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "RS blocks mismatch"
            r0.<init>(r1)
            throw r0
        L_0x03d0:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "EC bytes mismatch"
            r0.<init>(r1)
            throw r0
        L_0x03d8:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Block ID too large"
            r0.<init>(r1)
            throw r0
        L_0x03e0:
            r20 = r1
            r21 = r4
            r24 = r6
            r22 = r9
            if (r7 != r13) goto L_0x0608
            com.google.zxing.common.BitArray r0 = new com.google.zxing.common.BitArray
            r0.<init>()
            r11 = 0
        L_0x03f0:
            if (r11 >= r14) goto L_0x0412
            java.util.Iterator r1 = r10.iterator()
        L_0x03f6:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x040f
            java.lang.Object r2 = r1.next()
            com.google.zxing.qrcode.encoder.BlockPair r2 = (com.google.zxing.qrcode.encoder.BlockPair) r2
            byte[] r2 = r2.dataBytes
            int r3 = r2.length
            if (r11 >= r3) goto L_0x03f6
            byte r2 = r2[r11]
            r3 = 8
            r0.appendBits(r2, r3)
            goto L_0x03f6
        L_0x040f:
            int r11 = r11 + 1
            goto L_0x03f0
        L_0x0412:
            r11 = 0
        L_0x0413:
            if (r11 >= r15) goto L_0x0435
            java.util.Iterator r1 = r10.iterator()
        L_0x0419:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0432
            java.lang.Object r2 = r1.next()
            com.google.zxing.qrcode.encoder.BlockPair r2 = (com.google.zxing.qrcode.encoder.BlockPair) r2
            byte[] r2 = r2.errorCorrectionBytes
            int r3 = r2.length
            if (r11 >= r3) goto L_0x0419
            byte r2 = r2[r11]
            r3 = 8
            r0.appendBits(r2, r3)
            goto L_0x0419
        L_0x0432:
            int r11 = r11 + 1
            goto L_0x0413
        L_0x0435:
            int r1 = r0.getSizeInBytes()
            r2 = r22
            if (r2 != r1) goto L_0x05e3
            r4 = r21
            int r1 = r4.versionNumber
            r2 = 4
            int r1 = r1 * 4
            r2 = 17
            int r1 = r1 + r2
            com.google.zxing.qrcode.encoder.ByteMatrix r2 = new com.google.zxing.qrcode.encoder.ByteMatrix
            r2.<init>(r1, r1)
            r1 = 2147483647(0x7fffffff, float:NaN)
            r3 = 8
            r11 = 0
            r15 = -1
        L_0x0453:
            if (r11 >= r3) goto L_0x0596
            r5 = r20
            com.google.zxing.qrcode.encoder.MatrixUtil.buildMatrix(r0, r5, r4, r11, r2)
            r6 = 1
            int r7 = com.google.android.material.resources.TextAppearanceConfig.applyMaskPenaltyRule1Internal(r2, r6)
            r6 = 0
            int r8 = com.google.android.material.resources.TextAppearanceConfig.applyMaskPenaltyRule1Internal(r2, r6)
            int r8 = r8 + r7
            byte[][] r7 = r2.bytes
            int r9 = r2.width
            int r10 = r2.height
            r12 = 0
            r13 = 0
        L_0x046d:
            r14 = -1
            int r3 = r10 + -1
            if (r12 >= r3) goto L_0x049b
            r3 = 0
        L_0x0473:
            int r6 = r9 + -1
            if (r3 >= r6) goto L_0x0497
            r6 = r7[r12]
            byte r6 = r6[r3]
            r17 = r7[r12]
            int r18 = r3 + 1
            byte r14 = r17[r18]
            if (r6 != r14) goto L_0x0493
            int r14 = r12 + 1
            r17 = r7[r14]
            byte r3 = r17[r3]
            if (r6 != r3) goto L_0x0493
            r3 = r7[r14]
            byte r3 = r3[r18]
            if (r6 != r3) goto L_0x0493
            int r13 = r13 + 1
        L_0x0493:
            r3 = r18
            r14 = -1
            goto L_0x0473
        L_0x0497:
            int r12 = r12 + 1
            r6 = 0
            goto L_0x046d
        L_0x049b:
            int r13 = r13 * 3
            int r13 = r13 + r8
            byte[][] r3 = r2.bytes
            int r6 = r2.width
            int r7 = r2.height
            r8 = 0
            r9 = 0
        L_0x04a6:
            if (r8 >= r7) goto L_0x0552
            r10 = 0
        L_0x04a9:
            if (r10 >= r6) goto L_0x054a
            r12 = r3[r8]
            int r14 = r10 + 6
            if (r14 >= r6) goto L_0x04f1
            r17 = r6
            byte r6 = r12[r10]
            r31 = r0
            r0 = 1
            if (r6 != r0) goto L_0x04f5
            int r6 = r10 + 1
            byte r6 = r12[r6]
            if (r6 != 0) goto L_0x04f5
            int r6 = r10 + 2
            byte r6 = r12[r6]
            if (r6 != r0) goto L_0x04f5
            int r6 = r10 + 3
            byte r6 = r12[r6]
            if (r6 != r0) goto L_0x04f5
            int r6 = r10 + 4
            byte r6 = r12[r6]
            if (r6 != r0) goto L_0x04f5
            int r6 = r10 + 5
            byte r6 = r12[r6]
            if (r6 != 0) goto L_0x04f5
            byte r6 = r12[r14]
            if (r6 != r0) goto L_0x04f5
            int r0 = r10 + -4
            boolean r0 = com.google.android.material.resources.TextAppearanceConfig.isWhiteHorizontal(r12, r0, r10)
            if (r0 != 0) goto L_0x04ee
            int r0 = r10 + 7
            int r6 = r10 + 11
            boolean r0 = com.google.android.material.resources.TextAppearanceConfig.isWhiteHorizontal(r12, r0, r6)
            if (r0 == 0) goto L_0x04f5
        L_0x04ee:
            int r9 = r9 + 1
            goto L_0x04f5
        L_0x04f1:
            r31 = r0
            r17 = r6
        L_0x04f5:
            int r0 = r8 + 6
            if (r0 >= r7) goto L_0x0542
            r6 = r3[r8]
            byte r6 = r6[r10]
            r12 = 1
            if (r6 != r12) goto L_0x0542
            int r6 = r8 + 1
            r6 = r3[r6]
            byte r6 = r6[r10]
            if (r6 != 0) goto L_0x0542
            int r6 = r8 + 2
            r6 = r3[r6]
            byte r6 = r6[r10]
            if (r6 != r12) goto L_0x0542
            int r6 = r8 + 3
            r6 = r3[r6]
            byte r6 = r6[r10]
            if (r6 != r12) goto L_0x0542
            int r6 = r8 + 4
            r6 = r3[r6]
            byte r6 = r6[r10]
            if (r6 != r12) goto L_0x0542
            int r6 = r8 + 5
            r6 = r3[r6]
            byte r6 = r6[r10]
            if (r6 != 0) goto L_0x0542
            r0 = r3[r0]
            byte r0 = r0[r10]
            if (r0 != r12) goto L_0x0542
            int r0 = r8 + -4
            boolean r0 = com.google.android.material.resources.TextAppearanceConfig.isWhiteVertical(r3, r10, r0, r8)
            if (r0 != 0) goto L_0x0540
            int r0 = r8 + 7
            int r6 = r8 + 11
            boolean r0 = com.google.android.material.resources.TextAppearanceConfig.isWhiteVertical(r3, r10, r0, r6)
            if (r0 == 0) goto L_0x0542
        L_0x0540:
            int r9 = r9 + 1
        L_0x0542:
            int r10 = r10 + 1
            r0 = r31
            r6 = r17
            goto L_0x04a9
        L_0x054a:
            r31 = r0
            r17 = r6
            int r8 = r8 + 1
            goto L_0x04a6
        L_0x0552:
            r31 = r0
            int r9 = r9 * 40
            int r9 = r9 + r13
            byte[][] r0 = r2.bytes
            int r3 = r2.width
            int r6 = r2.height
            r7 = 0
            r8 = 0
        L_0x055f:
            if (r7 >= r6) goto L_0x0573
            r10 = r0[r7]
            r12 = 0
        L_0x0564:
            if (r12 >= r3) goto L_0x0570
            byte r13 = r10[r12]
            r14 = 1
            if (r13 != r14) goto L_0x056d
            int r8 = r8 + 1
        L_0x056d:
            int r12 = r12 + 1
            goto L_0x0564
        L_0x0570:
            int r7 = r7 + 1
            goto L_0x055f
        L_0x0573:
            int r0 = r2.height
            int r3 = r2.width
            int r0 = r0 * r3
            int r3 = r8 << 1
            int r3 = r3 - r0
            int r3 = java.lang.Math.abs(r3)
            r6 = 10
            int r3 = r3 * 10
            int r3 = r3 / r0
            int r3 = r3 * 10
            int r3 = r3 + r9
            if (r3 >= r1) goto L_0x058c
            r1 = r3
            r15 = r11
        L_0x058c:
            int r11 = r11 + 1
            r0 = r31
            r20 = r5
            r3 = 8
            goto L_0x0453
        L_0x0596:
            r5 = r20
            com.google.zxing.qrcode.encoder.MatrixUtil.buildMatrix(r0, r5, r4, r15, r2)
            int r0 = r2.width
            int r1 = r2.height
            r3 = 1
            int r4 = r24 << 1
            int r3 = r0 + r4
            int r4 = r4 + r1
            r5 = r29
            int r5 = java.lang.Math.max(r5, r3)
            r6 = r30
            int r6 = java.lang.Math.max(r6, r4)
            int r3 = r5 / r3
            int r4 = r6 / r4
            int r3 = java.lang.Math.min(r3, r4)
            int r4 = r0 * r3
            int r4 = r5 - r4
            r7 = 2
            int r4 = r4 / r7
            int r8 = r1 * r3
            int r8 = r6 - r8
            int r8 = r8 / r7
            com.google.zxing.common.BitMatrix r7 = new com.google.zxing.common.BitMatrix
            r7.<init>(r5, r6)
            r11 = 0
        L_0x05ca:
            if (r11 >= r1) goto L_0x05e2
            r6 = r4
            r5 = 0
        L_0x05ce:
            if (r5 >= r0) goto L_0x05de
            byte r9 = r2.get(r5, r11)
            r10 = 1
            if (r9 != r10) goto L_0x05da
            r7.setRegion(r6, r8, r3, r3)
        L_0x05da:
            int r5 = r5 + 1
            int r6 = r6 + r3
            goto L_0x05ce
        L_0x05de:
            int r11 = r11 + 1
            int r8 = r8 + r3
            goto L_0x05ca
        L_0x05e2:
            return r7
        L_0x05e3:
            com.google.zxing.WriterException r1 = new com.google.zxing.WriterException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Interleaving error: "
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r2 = " and "
            r3.append(r2)
            int r0 = r0.getSizeInBytes()
            r3.append(r0)
            java.lang.String r0 = " differ."
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.<init>(r0)
            throw r1
        L_0x0608:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Data bytes does not match offset"
            r0.<init>(r1)
            throw r0
        L_0x0610:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Number of bits and data bytes does not match"
            r0.<init>(r1)
            throw r0
        L_0x0618:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Bits size does not equal capacity"
            r0.<init>(r1)
            throw r0
        L_0x0620:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "data bits cannot fit in the QR Code"
            r1.<init>(r2)
            int r2 = r8.size
            r1.append(r2)
            java.lang.String r2 = " > "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x063e:
            com.google.zxing.WriterException r1 = new com.google.zxing.WriterException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = " is bigger than "
            r2.append(r0)
            r0 = 1
            int r11 = r11 - r0
            r2.append(r11)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x065a:
            r5 = r2
            r6 = r3
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Requested dimensions are too small: "
            r1.<init>(r2)
            r1.append(r5)
            r2 = 120(0x78, float:1.68E-43)
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0678:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Can only encode QR_CODE, but got "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x068c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Found empty contents"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.QRCodeWriter.encode(java.lang.String, com.google.zxing.BarcodeFormat, int, int, java.util.Map):com.google.zxing.common.BitMatrix");
    }
}
