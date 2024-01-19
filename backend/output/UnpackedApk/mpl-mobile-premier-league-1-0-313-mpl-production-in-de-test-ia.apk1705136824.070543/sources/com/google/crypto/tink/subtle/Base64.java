package com.google.crypto.tink.subtle;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.apache.pdfbox.pdfparser.BaseParser;

public final class Base64 {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static abstract class Coder {
        public int op;
        public byte[] output;
    }

    public static class Decoder extends Coder {
        public static final int[] DECODE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        public static final int[] DECODE_WEBSAFE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    }

    public static class Encoder extends Coder {
        public static final byte[] ENCODE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, BaseParser.ASCII_ZERO, 49, 50, 51, 52, 53, 54, 55, 56, BaseParser.ASCII_NINE, 43, 47};
        public static final byte[] ENCODE_WEBSAFE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, BaseParser.ASCII_ZERO, 49, 50, 51, 52, 53, 54, 55, 56, BaseParser.ASCII_NINE, 45, 95};
        public final byte[] alphabet;
        public int count;
        public final boolean doCr;
        public final boolean doNewline;
        public final boolean doPadding;
        public final byte[] tail;
        public int tailLen;

        public Encoder(int i, byte[] bArr) {
            this.output = null;
            boolean z = true;
            this.doPadding = (i & 1) == 0;
            this.doNewline = (i & 2) == 0;
            this.doCr = (i & 4) == 0 ? false : z;
            this.alphabet = (i & 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
            this.tail = new byte[2];
            this.tailLen = 0;
            this.count = this.doNewline ? 19 : -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f0, code lost:
        if (r8 != 4) goto L_0x010d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] decode(java.lang.String r16, int r17) {
        /*
            java.nio.charset.Charset r0 = UTF_8
            r1 = r16
            byte[] r0 = r1.getBytes(r0)
            int r1 = r0.length
            int r2 = r1 * 3
            r3 = 4
            int r2 = r2 / r3
            byte[] r4 = new byte[r2]
            r5 = r17 & 8
            if (r5 != 0) goto L_0x0016
            int[] r5 = com.google.crypto.tink.subtle.Base64.Decoder.DECODE
            goto L_0x0018
        L_0x0016:
            int[] r5 = com.google.crypto.tink.subtle.Base64.Decoder.DECODE_WEBSAFE
        L_0x0018:
            r6 = 0
            int r1 = r1 + r6
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x001e:
            r11 = 3
            r12 = 2
            r13 = 1
            if (r7 >= r1) goto L_0x00ea
            if (r8 != 0) goto L_0x006b
        L_0x0025:
            int r14 = r7 + 4
            if (r14 > r1) goto L_0x0067
            byte r9 = r0[r7]
            r9 = r9 & 255(0xff, float:3.57E-43)
            r9 = r5[r9]
            int r9 = r9 << 18
            int r15 = r7 + 1
            byte r15 = r0[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r5[r15]
            int r15 = r15 << 12
            r9 = r9 | r15
            int r15 = r7 + 2
            byte r15 = r0[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r5[r15]
            int r15 = r15 << 6
            r9 = r9 | r15
            int r15 = r7 + 3
            byte r15 = r0[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r5[r15]
            r9 = r9 | r15
            if (r9 < 0) goto L_0x0067
            int r7 = r10 + 2
            byte r15 = (byte) r9
            r4[r7] = r15
            int r7 = r10 + 1
            int r15 = r9 >> 8
            byte r15 = (byte) r15
            r4[r7] = r15
            int r7 = r9 >> 16
            byte r7 = (byte) r7
            r4[r10] = r7
            int r10 = r10 + 3
            r7 = r14
            goto L_0x0025
        L_0x0067:
            if (r7 < r1) goto L_0x006b
            goto L_0x00ea
        L_0x006b:
            int r14 = r7 + 1
            byte r7 = r0[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            r7 = r5[r7]
            r15 = -1
            r6 = 5
            if (r8 == 0) goto L_0x00dd
            if (r8 == r13) goto L_0x00d4
            r13 = -2
            if (r8 == r12) goto L_0x00c2
            if (r8 == r11) goto L_0x0092
            if (r8 == r3) goto L_0x0088
            if (r8 == r6) goto L_0x0084
            goto L_0x00e6
        L_0x0084:
            if (r7 == r15) goto L_0x00e6
            goto L_0x010b
        L_0x0088:
            if (r7 != r13) goto L_0x008e
            int r8 = r8 + 1
            goto L_0x00e6
        L_0x008e:
            if (r7 == r15) goto L_0x00e6
            goto L_0x010b
        L_0x0092:
            if (r7 < 0) goto L_0x00ad
            int r6 = r9 << 6
            r6 = r6 | r7
            int r7 = r10 + 2
            byte r8 = (byte) r6
            r4[r7] = r8
            int r7 = r10 + 1
            int r8 = r6 >> 8
            byte r8 = (byte) r8
            r4[r7] = r8
            int r7 = r6 >> 16
            byte r7 = (byte) r7
            r4[r10] = r7
            int r10 = r10 + 3
            r9 = r6
            r8 = 0
            goto L_0x00e6
        L_0x00ad:
            if (r7 != r13) goto L_0x00bf
            int r7 = r10 + 1
            int r8 = r9 >> 2
            byte r8 = (byte) r8
            r4[r7] = r8
            int r7 = r9 >> 10
            byte r7 = (byte) r7
            r4[r10] = r7
            int r10 = r10 + 2
            r8 = 5
            goto L_0x00e6
        L_0x00bf:
            if (r7 == r15) goto L_0x00e6
            goto L_0x010b
        L_0x00c2:
            if (r7 < 0) goto L_0x00c5
            goto L_0x00d6
        L_0x00c5:
            if (r7 != r13) goto L_0x00d1
            int r6 = r10 + 1
            int r7 = r9 >> 4
            byte r7 = (byte) r7
            r4[r10] = r7
            r10 = r6
            r8 = 4
            goto L_0x00e6
        L_0x00d1:
            if (r7 == r15) goto L_0x00e6
            goto L_0x010b
        L_0x00d4:
            if (r7 < 0) goto L_0x00da
        L_0x00d6:
            int r6 = r9 << 6
            r7 = r7 | r6
            goto L_0x00df
        L_0x00da:
            if (r7 == r15) goto L_0x00e6
            goto L_0x010b
        L_0x00dd:
            if (r7 < 0) goto L_0x00e3
        L_0x00df:
            int r8 = r8 + 1
            r9 = r7
            goto L_0x00e6
        L_0x00e3:
            if (r7 == r15) goto L_0x00e6
            goto L_0x010b
        L_0x00e6:
            r7 = r14
            r6 = 0
            goto L_0x001e
        L_0x00ea:
            if (r8 == r13) goto L_0x010b
            if (r8 == r12) goto L_0x0102
            if (r8 == r11) goto L_0x00f3
            if (r8 == r3) goto L_0x010b
            goto L_0x010d
        L_0x00f3:
            int r0 = r10 + 1
            int r1 = r9 >> 10
            byte r1 = (byte) r1
            r4[r10] = r1
            int r10 = r0 + 1
            int r1 = r9 >> 2
            byte r1 = (byte) r1
            r4[r0] = r1
            goto L_0x010d
        L_0x0102:
            int r0 = r10 + 1
            int r1 = r9 >> 4
            byte r1 = (byte) r1
            r4[r10] = r1
            r10 = r0
            goto L_0x010d
        L_0x010b:
            r10 = 0
            r13 = 0
        L_0x010d:
            if (r13 == 0) goto L_0x011a
            if (r10 != r2) goto L_0x0112
            goto L_0x0119
        L_0x0112:
            byte[] r0 = new byte[r10]
            r1 = 0
            java.lang.System.arraycopy(r4, r1, r0, r1, r10)
            r4 = r0
        L_0x0119:
            return r4
        L_0x011a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "bad base-64"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.Base64.decode(java.lang.String, int):byte[]");
    }

    public static String encode(byte[] bArr) {
        try {
            return new String(encode(bArr, 2), "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:690)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:690)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:690)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:690)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0125 A[SYNTHETIC] */
    public static byte[] encode(byte[] r17, int r18) {
        /*
            r0 = r17
            int r1 = r0.length
            com.google.crypto.tink.subtle.Base64$Encoder r2 = new com.google.crypto.tink.subtle.Base64$Encoder
            r3 = 0
            r4 = r18
            r2.<init>(r4, r3)
            int r3 = r1 / 3
            r4 = 4
            int r3 = r3 * 4
            boolean r5 = r2.doPadding
            r6 = 2
            r7 = 1
            if (r5 == 0) goto L_0x001d
            int r5 = r1 % 3
            if (r5 <= 0) goto L_0x0029
            int r3 = r3 + 4
            goto L_0x0029
        L_0x001d:
            int r5 = r1 % 3
            if (r5 == r7) goto L_0x0027
            if (r5 == r6) goto L_0x0024
            goto L_0x0029
        L_0x0024:
            int r3 = r3 + 3
            goto L_0x0029
        L_0x0027:
            int r3 = r3 + 2
        L_0x0029:
            boolean r5 = r2.doNewline
            if (r5 == 0) goto L_0x003e
            if (r1 <= 0) goto L_0x003e
            int r5 = r1 + -1
            int r5 = r5 / 57
            int r5 = r5 + r7
            boolean r8 = r2.doCr
            if (r8 == 0) goto L_0x003a
            r8 = 2
            goto L_0x003b
        L_0x003a:
            r8 = 1
        L_0x003b:
            int r5 = r5 * r8
            int r3 = r3 + r5
        L_0x003e:
            byte[] r3 = new byte[r3]
            r2.output = r3
            byte[] r5 = r2.alphabet
            int r8 = r2.count
            r9 = 0
            int r1 = r1 + r9
            int r10 = r2.tailLen
            r11 = -1
            if (r10 == r7) goto L_0x006a
            if (r10 == r6) goto L_0x0050
            goto L_0x0084
        L_0x0050:
            if (r7 > r1) goto L_0x0084
            byte[] r10 = r2.tail
            byte r12 = r10[r9]
            r12 = r12 & 255(0xff, float:3.57E-43)
            int r12 = r12 << 16
            byte r10 = r10[r7]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r10 = r10 << 8
            r10 = r10 | r12
            byte r12 = r0[r9]
            r12 = r12 & 255(0xff, float:3.57E-43)
            r10 = r10 | r12
            r2.tailLen = r9
            r12 = 1
            goto L_0x0086
        L_0x006a:
            if (r6 > r1) goto L_0x0084
            byte[] r10 = r2.tail
            byte r10 = r10[r9]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r10 = r10 << 16
            byte r12 = r0[r9]
            r12 = r12 & 255(0xff, float:3.57E-43)
            int r12 = r12 << 8
            r10 = r10 | r12
            byte r12 = r0[r7]
            r12 = r12 & 255(0xff, float:3.57E-43)
            r10 = r10 | r12
            r2.tailLen = r9
            r12 = 2
            goto L_0x0086
        L_0x0084:
            r10 = -1
            r12 = 0
        L_0x0086:
            r14 = 13
            r15 = 10
            if (r10 == r11) goto L_0x00c3
            int r11 = r10 >> 18
            r11 = r11 & 63
            byte r11 = r5[r11]
            r3[r9] = r11
            int r11 = r10 >> 12
            r11 = r11 & 63
            byte r11 = r5[r11]
            r3[r7] = r11
            int r11 = r10 >> 6
            r11 = r11 & 63
            byte r11 = r5[r11]
            r3[r6] = r11
            r10 = r10 & 63
            byte r10 = r5[r10]
            r11 = 3
            r3[r11] = r10
            int r8 = r8 + -1
            if (r8 != 0) goto L_0x00c1
            boolean r8 = r2.doCr
            if (r8 == 0) goto L_0x00b7
            r8 = 5
            r3[r4] = r14
            goto L_0x00b8
        L_0x00b7:
            r8 = 4
        L_0x00b8:
            int r10 = r8 + 1
            r3[r8] = r15
            r8 = r5
            r11 = r10
            r5 = r3
            r3 = r2
            goto L_0x011c
        L_0x00c1:
            r10 = 4
            goto L_0x00c4
        L_0x00c3:
            r10 = 0
        L_0x00c4:
            r11 = r10
            r10 = r8
            r8 = r5
            r5 = r3
            r3 = r2
        L_0x00c9:
            int r13 = r12 + 3
            if (r13 > r1) goto L_0x0125
            byte r7 = r0[r12]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 << 16
            int r16 = r12 + 1
            byte r6 = r0[r16]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << 8
            r6 = r6 | r7
            int r12 = r12 + 2
            byte r7 = r0[r12]
            r7 = r7 & 255(0xff, float:3.57E-43)
            r6 = r6 | r7
            int r7 = r6 >> 18
            r7 = r7 & 63
            byte r7 = r8[r7]
            r5[r11] = r7
            int r7 = r11 + 1
            int r12 = r6 >> 12
            r12 = r12 & 63
            byte r12 = r8[r12]
            r5[r7] = r12
            int r7 = r11 + 2
            int r12 = r6 >> 6
            r12 = r12 & 63
            byte r12 = r8[r12]
            r5[r7] = r12
            int r7 = r11 + 3
            r6 = r6 & 63
            byte r6 = r8[r6]
            r5[r7] = r6
            int r11 = r11 + 4
            int r10 = r10 + -1
            if (r10 != 0) goto L_0x0121
            boolean r6 = r2.doCr
            if (r6 == 0) goto L_0x0116
            int r6 = r11 + 1
            r5[r11] = r14
            r11 = r6
        L_0x0116:
            int r10 = r11 + 1
            r5[r11] = r15
            r11 = r10
            r12 = r13
        L_0x011c:
            r6 = 2
            r7 = 1
            r10 = 19
            goto L_0x00c9
        L_0x0121:
            r12 = r13
            r6 = 2
            r7 = 1
            goto L_0x00c9
        L_0x0125:
            int r6 = r2.tailLen
            int r7 = r12 - r6
            int r13 = r1 + -1
            r16 = 61
            if (r7 != r13) goto L_0x0176
            if (r6 <= 0) goto L_0x0137
            byte[] r0 = r2.tail
            byte r0 = r0[r9]
            r7 = 1
            goto L_0x013a
        L_0x0137:
            byte r0 = r0[r12]
            r7 = 0
        L_0x013a:
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r0 = r0 << r4
            int r1 = r2.tailLen
            int r1 = r1 - r7
            r2.tailLen = r1
            int r1 = r11 + 1
            int r4 = r0 >> 6
            r4 = r4 & 63
            byte r4 = r8[r4]
            r5[r11] = r4
            int r4 = r1 + 1
            r0 = r0 & 63
            byte r0 = r8[r0]
            r5[r1] = r0
            boolean r0 = r2.doPadding
            if (r0 == 0) goto L_0x0162
            int r0 = r4 + 1
            r5[r4] = r16
            int r1 = r0 + 1
            r5[r0] = r16
            r11 = r1
            goto L_0x0163
        L_0x0162:
            r11 = r4
        L_0x0163:
            boolean r0 = r2.doNewline
            if (r0 == 0) goto L_0x01f5
            boolean r0 = r2.doCr
            if (r0 == 0) goto L_0x0170
            int r0 = r11 + 1
            r5[r11] = r14
            r11 = r0
        L_0x0170:
            int r0 = r11 + 1
            r5[r11] = r15
            goto L_0x01f4
        L_0x0176:
            r4 = 2
            int r1 = r1 - r4
            if (r7 != r1) goto L_0x01dd
            r1 = 1
            if (r6 <= r1) goto L_0x0183
            byte[] r4 = r2.tail
            byte r4 = r4[r9]
            r7 = 1
            goto L_0x0189
        L_0x0183:
            int r1 = r12 + 1
            byte r4 = r0[r12]
            r12 = r1
            r7 = 0
        L_0x0189:
            r1 = r4 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r15
            int r4 = r2.tailLen
            if (r4 <= 0) goto L_0x0198
            byte[] r0 = r2.tail
            int r4 = r7 + 1
            byte r0 = r0[r7]
            r7 = r4
            goto L_0x019a
        L_0x0198:
            byte r0 = r0[r12]
        L_0x019a:
            r0 = r0 & 255(0xff, float:3.57E-43)
            r4 = 2
            int r0 = r0 << r4
            r0 = r0 | r1
            int r1 = r2.tailLen
            int r1 = r1 - r7
            r2.tailLen = r1
            int r1 = r11 + 1
            int r4 = r0 >> 12
            r4 = r4 & 63
            byte r4 = r8[r4]
            r5[r11] = r4
            int r4 = r1 + 1
            int r6 = r0 >> 6
            r6 = r6 & 63
            byte r6 = r8[r6]
            r5[r1] = r6
            int r1 = r4 + 1
            r0 = r0 & 63
            byte r0 = r8[r0]
            r5[r4] = r0
            boolean r0 = r2.doPadding
            if (r0 == 0) goto L_0x01ca
            int r0 = r1 + 1
            r5[r1] = r16
            r11 = r0
            goto L_0x01cb
        L_0x01ca:
            r11 = r1
        L_0x01cb:
            boolean r0 = r2.doNewline
            if (r0 == 0) goto L_0x01f5
            boolean r0 = r2.doCr
            if (r0 == 0) goto L_0x01d8
            int r0 = r11 + 1
            r5[r11] = r14
            r11 = r0
        L_0x01d8:
            int r0 = r11 + 1
            r5[r11] = r15
            goto L_0x01f4
        L_0x01dd:
            boolean r0 = r2.doNewline
            if (r0 == 0) goto L_0x01f5
            if (r11 <= 0) goto L_0x01f5
            r0 = 19
            if (r10 == r0) goto L_0x01f5
            boolean r0 = r2.doCr
            if (r0 == 0) goto L_0x01f0
            int r0 = r11 + 1
            r5[r11] = r14
            r11 = r0
        L_0x01f0:
            int r0 = r11 + 1
            r5[r11] = r15
        L_0x01f4:
            r11 = r0
        L_0x01f5:
            r2.op = r11
            r2.count = r10
            byte[] r0 = r3.output
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.Base64.encode(byte[], int):byte[]");
    }
}
