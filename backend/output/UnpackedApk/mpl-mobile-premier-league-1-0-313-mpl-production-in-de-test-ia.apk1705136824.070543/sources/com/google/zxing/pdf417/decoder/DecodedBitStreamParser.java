package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import java.math.BigInteger;
import java.nio.charset.Charset;

public final class DecodedBitStreamParser {
    public static final Charset DEFAULT_ENCODING = Charset.forName("ISO-8859-1");
    public static final BigInteger[] EXP900;
    public static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    public static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();

    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        EXP900[1] = valueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i < bigIntegerArr2.length) {
                bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(valueOf);
                i++;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01a2, code lost:
        r13 = 0;
        r3 = false;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01a8, code lost:
        if (r7 >= r0[r8]) goto L_0x0207;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01aa, code lost:
        if (r3 != false) goto L_0x0207;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01ac, code lost:
        r15 = r7 + 1;
        r7 = r0[r7];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01b0, code lost:
        if (r7 >= 900) goto L_0x01be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01b2, code lost:
        r4 = r4 + 1;
        r13 = (r13 * 900) + ((long) r7);
        r7 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01be, code lost:
        if (r7 == 900) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01c0, code lost:
        if (r7 == 901) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01c2, code lost:
        if (r7 == 902) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01c6, code lost:
        if (r7 == 924) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01ca, code lost:
        if (r7 == 928) goto L_0x01d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01ce, code lost:
        if (r7 == 923) goto L_0x01d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01d2, code lost:
        if (r7 != 922) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01d5, code lost:
        r7 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01de, code lost:
        r7 = r15 - 1;
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01e4, code lost:
        if ((r4 % 5) != 0) goto L_0x0202;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01e6, code lost:
        if (r4 <= 0) goto L_0x0202;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01e8, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01ea, code lost:
        if (r4 >= 6) goto L_0x01fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01ec, code lost:
        r6.write((byte) ((int) (r13 >> ((5 - r4) * 8))));
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x01fe, code lost:
        r13 = 0;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0203, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0207, code lost:
        r1.append(new java.lang.String(r6.toByteArray(), r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0213, code lost:
        r3 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0110, code lost:
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0113, code lost:
        r6 = new java.io.ByteArrayOutputStream();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x011d, code lost:
        if (r4 != 901) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x011f, code lost:
        r4 = new int[6];
        r20 = r7 + 1;
        r7 = r0[r7];
        r21 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0127, code lost:
        r3 = r7;
        r23 = 0;
        r7 = r20;
        r22 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0130, code lost:
        if (r7 >= r0[0]) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0132, code lost:
        if (r21 != false) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0134, code lost:
        r13 = r22 + 1;
        r4[r22] = r3;
        r23 = (r23 * 900) + ((long) r3);
        r3 = r7 + 1;
        r7 = r0[r7];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0141, code lost:
        if (r7 == 900) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0143, code lost:
        if (r7 == 901) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0145, code lost:
        if (r7 == 902) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0147, code lost:
        if (r7 == 924) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x014b, code lost:
        if (r7 == 928) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x014f, code lost:
        if (r7 == 923) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0153, code lost:
        if (r7 != 922) goto L_0x0156;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0158, code lost:
        if ((r13 % 5) != 0) goto L_0x017c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x015a, code lost:
        if (r13 <= 0) goto L_0x017c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x015c, code lost:
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x015e, code lost:
        if (r13 >= 6) goto L_0x016e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0160, code lost:
        r6.write((byte) ((int) (r23 >> ((5 - r13) * 8))));
        r13 = r13 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x016e, code lost:
        r20 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0178, code lost:
        r3 = r3 - 1;
        r21 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x017c, code lost:
        r22 = r13;
        r25 = r7;
        r7 = r3;
        r3 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x018a, code lost:
        if (r7 != r0[0]) goto L_0x0193;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x018c, code lost:
        if (r3 >= 900) goto L_0x0193;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x018e, code lost:
        r9 = r22 + 1;
        r4[r22] = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0193, code lost:
        r9 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0195, code lost:
        if (r8 >= r9) goto L_0x0207;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0197, code lost:
        r6.write((byte) r4[r8]);
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01a0, code lost:
        if (r4 != 924) goto L_0x0207;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.zxing.common.DecoderResult decode(int[] r26, java.lang.String r27) throws com.google.zxing.FormatException {
        /*
            r0 = r26
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r2 = r0.length
            r3 = 1
            int r2 = r2 << r3
            r1.<init>(r2)
            java.nio.charset.Charset r2 = DEFAULT_ENCODING
            r4 = r0[r3]
            com.google.zxing.pdf417.PDF417ResultMetadata r5 = new com.google.zxing.pdf417.PDF417ResultMetadata
            r5.<init>()
            r7 = 2
        L_0x0014:
            r8 = 0
            r9 = r0[r8]
            if (r7 >= r9) goto L_0x0231
            r9 = 913(0x391, float:1.28E-42)
            if (r4 == r9) goto L_0x021a
            r9 = 924(0x39c, float:1.295E-42)
            r10 = 900(0x384, float:1.261E-42)
            r11 = 902(0x386, float:1.264E-42)
            r12 = 901(0x385, float:1.263E-42)
            r13 = 922(0x39a, float:1.292E-42)
            r14 = 923(0x39b, float:1.293E-42)
            r15 = 928(0x3a0, float:1.3E-42)
            switch(r4) {
                case 900: goto L_0x0089;
                case 901: goto L_0x0086;
                case 902: goto L_0x0039;
                default: goto L_0x002e;
            }
        L_0x002e:
            switch(r4) {
                case 922: goto L_0x0215;
                case 923: goto L_0x0215;
                case 924: goto L_0x0086;
                case 925: goto L_0x010d;
                case 926: goto L_0x0109;
                case 927: goto L_0x00f4;
                case 928: goto L_0x008f;
                default: goto L_0x0031;
            }
        L_0x0031:
            int r7 = r7 + -1
            int r3 = textCompaction(r0, r7, r1)
            goto L_0x0222
        L_0x0039:
            r4 = 15
            int[] r4 = new int[r4]
            r16 = 0
            r17 = 0
        L_0x0041:
            r3 = r0[r8]
            if (r7 >= r3) goto L_0x0213
            if (r16 != 0) goto L_0x0213
            int r3 = r7 + 1
            r7 = r0[r7]
            r6 = r0[r8]
            if (r3 != r6) goto L_0x0051
            r16 = 1
        L_0x0051:
            if (r7 >= r10) goto L_0x0058
            r4[r17] = r7
            int r17 = r17 + 1
            goto L_0x0065
        L_0x0058:
            if (r7 == r10) goto L_0x0068
            if (r7 == r12) goto L_0x0068
            if (r7 == r9) goto L_0x0068
            if (r7 == r15) goto L_0x0068
            if (r7 == r14) goto L_0x0068
            if (r7 != r13) goto L_0x0065
            goto L_0x0068
        L_0x0065:
            r6 = r17
            goto L_0x006e
        L_0x0068:
            int r3 = r3 + -1
            r6 = r17
            r16 = 1
        L_0x006e:
            int r17 = r6 % 15
            if (r17 == 0) goto L_0x0076
            if (r7 == r11) goto L_0x0076
            if (r16 == 0) goto L_0x0082
        L_0x0076:
            if (r6 <= 0) goto L_0x0082
            java.lang.String r6 = decodeBase900toBase10(r4, r6)
            r1.append(r6)
            r17 = 0
            goto L_0x0084
        L_0x0082:
            r17 = r6
        L_0x0084:
            r7 = r3
            goto L_0x0041
        L_0x0086:
            r3 = 2
            goto L_0x0113
        L_0x0089:
            int r3 = textCompaction(r0, r7, r1)
            goto L_0x0222
        L_0x008f:
            int r3 = r7 + 2
            r4 = r0[r8]
            if (r3 > r4) goto L_0x00ef
            r3 = 2
            int[] r4 = new int[r3]
            r6 = 0
        L_0x0099:
            if (r6 >= r3) goto L_0x00a4
            r9 = r0[r7]
            r4[r6] = r9
            int r6 = r6 + 1
            int r7 = r7 + 1
            goto L_0x0099
        L_0x00a4:
            java.lang.String r4 = decodeBase900toBase10(r4, r3)
            java.lang.Integer.parseInt(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            int r7 = textCompaction(r0, r7, r4)
            r4.toString()
            r4 = r0[r7]
            if (r4 != r14) goto L_0x00e7
            int r7 = r7 + 1
            r4 = r0[r8]
            int r4 = r4 - r7
            int[] r4 = new int[r4]
            r6 = 0
            r9 = 0
        L_0x00c4:
            r11 = r0[r8]
            if (r7 >= r11) goto L_0x00e2
            if (r6 != 0) goto L_0x00e2
            int r11 = r7 + 1
            r7 = r0[r7]
            if (r7 >= r10) goto L_0x00d7
            int r12 = r9 + 1
            r4[r9] = r7
            r7 = r11
            r9 = r12
            goto L_0x00c4
        L_0x00d7:
            if (r7 != r13) goto L_0x00dd
            int r7 = r11 + 1
            r6 = 1
            goto L_0x00c4
        L_0x00dd:
            com.google.zxing.FormatException r0 = com.google.zxing.FormatException.getFormatInstance()
            throw r0
        L_0x00e2:
            java.util.Arrays.copyOf(r4, r9)
            goto L_0x0213
        L_0x00e7:
            r4 = r0[r7]
            if (r4 != r13) goto L_0x0213
            int r7 = r7 + 1
            goto L_0x0213
        L_0x00ef:
            com.google.zxing.FormatException r0 = com.google.zxing.FormatException.getFormatInstance()
            throw r0
        L_0x00f4:
            r3 = 2
            int r2 = r7 + 1
            r4 = r0[r7]
            com.google.zxing.common.CharacterSetECI r4 = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByValue(r4)
            java.lang.String r4 = r4.name()
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r4)
            r3 = r2
            r2 = r4
            goto L_0x0222
        L_0x0109:
            r3 = 2
            int r4 = r7 + 2
            goto L_0x0110
        L_0x010d:
            r3 = 2
            int r4 = r7 + 1
        L_0x0110:
            r3 = r4
            goto L_0x0222
        L_0x0113:
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream
            r6.<init>()
            r16 = 900(0x384, double:4.447E-321)
            r18 = 0
            r3 = 6
            if (r4 != r12) goto L_0x01a0
            int[] r4 = new int[r3]
            int r20 = r7 + 1
            r7 = r0[r7]
            r21 = 0
        L_0x0127:
            r3 = r7
            r23 = r18
            r7 = r20
            r22 = 0
        L_0x012e:
            r13 = r0[r8]
            if (r7 >= r13) goto L_0x0188
            if (r21 != 0) goto L_0x0188
            int r13 = r22 + 1
            r4[r22] = r3
            long r23 = r23 * r16
            long r14 = (long) r3
            long r23 = r23 + r14
            int r3 = r7 + 1
            r7 = r0[r7]
            if (r7 == r10) goto L_0x0178
            if (r7 == r12) goto L_0x0178
            if (r7 == r11) goto L_0x0178
            if (r7 == r9) goto L_0x0178
            r14 = 928(0x3a0, float:1.3E-42)
            if (r7 == r14) goto L_0x0178
            r14 = 923(0x39b, float:1.293E-42)
            if (r7 == r14) goto L_0x0178
            r14 = 922(0x39a, float:1.292E-42)
            if (r7 != r14) goto L_0x0156
            goto L_0x0178
        L_0x0156:
            int r14 = r13 % 5
            if (r14 != 0) goto L_0x017c
            if (r13 <= 0) goto L_0x017c
            r13 = 0
        L_0x015d:
            r14 = 6
            if (r13 >= r14) goto L_0x016e
            int r14 = 5 - r13
            int r14 = r14 * 8
            long r14 = r23 >> r14
            int r15 = (int) r14
            byte r14 = (byte) r15
            r6.write(r14)
            int r13 = r13 + 1
            goto L_0x015d
        L_0x016e:
            r20 = r3
            r3 = 6
            r13 = 922(0x39a, float:1.292E-42)
            r14 = 923(0x39b, float:1.293E-42)
            r15 = 928(0x3a0, float:1.3E-42)
            goto L_0x0127
        L_0x0178:
            int r3 = r3 + -1
            r21 = 1
        L_0x017c:
            r22 = r13
            r14 = 923(0x39b, float:1.293E-42)
            r15 = 928(0x3a0, float:1.3E-42)
            r25 = r7
            r7 = r3
            r3 = r25
            goto L_0x012e
        L_0x0188:
            r9 = r0[r8]
            if (r7 != r9) goto L_0x0193
            if (r3 >= r10) goto L_0x0193
            int r9 = r22 + 1
            r4[r22] = r3
            goto L_0x0195
        L_0x0193:
            r9 = r22
        L_0x0195:
            if (r8 >= r9) goto L_0x0207
            r3 = r4[r8]
            byte r3 = (byte) r3
            r6.write(r3)
            int r8 = r8 + 1
            goto L_0x0195
        L_0x01a0:
            if (r4 != r9) goto L_0x0207
            r13 = r18
            r3 = 0
            r4 = 0
        L_0x01a6:
            r15 = r0[r8]
            if (r7 >= r15) goto L_0x0207
            if (r3 != 0) goto L_0x0207
            int r15 = r7 + 1
            r7 = r0[r7]
            if (r7 >= r10) goto L_0x01be
            int r4 = r4 + 1
            long r13 = r13 * r16
            long r8 = (long) r7
            long r13 = r13 + r8
            r7 = r15
            r8 = 922(0x39a, float:1.292E-42)
            r9 = 928(0x3a0, float:1.3E-42)
            goto L_0x01e2
        L_0x01be:
            if (r7 == r10) goto L_0x01da
            if (r7 == r12) goto L_0x01da
            if (r7 == r11) goto L_0x01da
            r8 = 924(0x39c, float:1.295E-42)
            if (r7 == r8) goto L_0x01da
            r9 = 928(0x3a0, float:1.3E-42)
            if (r7 == r9) goto L_0x01d7
            r8 = 923(0x39b, float:1.293E-42)
            if (r7 == r8) goto L_0x01d7
            r8 = 922(0x39a, float:1.292E-42)
            if (r7 != r8) goto L_0x01d5
            goto L_0x01de
        L_0x01d5:
            r7 = r15
            goto L_0x01e2
        L_0x01d7:
            r8 = 922(0x39a, float:1.292E-42)
            goto L_0x01de
        L_0x01da:
            r8 = 922(0x39a, float:1.292E-42)
            r9 = 928(0x3a0, float:1.3E-42)
        L_0x01de:
            int r15 = r15 + -1
            r7 = r15
            r3 = 1
        L_0x01e2:
            int r15 = r4 % 5
            if (r15 != 0) goto L_0x0202
            if (r4 <= 0) goto L_0x0202
            r4 = 0
            r15 = 6
        L_0x01ea:
            if (r4 >= r15) goto L_0x01fe
            int r20 = 5 - r4
            int r20 = r20 * 8
            long r8 = r13 >> r20
            int r9 = (int) r8
            byte r8 = (byte) r9
            r6.write(r8)
            int r4 = r4 + 1
            r8 = 922(0x39a, float:1.292E-42)
            r9 = 928(0x3a0, float:1.3E-42)
            goto L_0x01ea
        L_0x01fe:
            r13 = r18
            r4 = 0
            goto L_0x0203
        L_0x0202:
            r15 = 6
        L_0x0203:
            r8 = 0
            r9 = 924(0x39c, float:1.295E-42)
            goto L_0x01a6
        L_0x0207:
            java.lang.String r3 = new java.lang.String
            byte[] r4 = r6.toByteArray()
            r3.<init>(r4, r2)
            r1.append(r3)
        L_0x0213:
            r3 = r7
            goto L_0x0222
        L_0x0215:
            com.google.zxing.FormatException r0 = com.google.zxing.FormatException.getFormatInstance()
            throw r0
        L_0x021a:
            int r3 = r7 + 1
            r4 = r0[r7]
            char r4 = (char) r4
            r1.append(r4)
        L_0x0222:
            int r4 = r0.length
            if (r3 >= r4) goto L_0x022c
            int r7 = r3 + 1
            r4 = r0[r3]
            r3 = 1
            goto L_0x0014
        L_0x022c:
            com.google.zxing.FormatException r0 = com.google.zxing.FormatException.getFormatInstance()
            throw r0
        L_0x0231:
            int r0 = r1.length()
            if (r0 == 0) goto L_0x0246
            com.google.zxing.common.DecoderResult r0 = new com.google.zxing.common.DecoderResult
            java.lang.String r1 = r1.toString()
            r2 = 0
            r3 = r27
            r0.<init>(r2, r1, r2, r3)
            r0.other = r5
            return r0
        L_0x0246:
            com.google.zxing.FormatException r0 = com.google.zxing.FormatException.getFormatInstance()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decode(int[], java.lang.String):com.google.zxing.common.DecoderResult");
    }

    public static String decodeBase900toBase10(int[] iArr, int i) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(EXP900[(i - i2) - 1].multiply(BigInteger.valueOf((long) iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x015c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int textCompaction(int[] r17, int r18, java.lang.StringBuilder r19) {
        /*
            r0 = r19
            r1 = 0
            r2 = r17[r1]
            int r2 = r2 - r18
            r3 = 1
            int r2 = r2 << r3
            int[] r2 = new int[r2]
            r4 = r17[r1]
            int r4 = r4 - r18
            int r4 = r4 << r3
            int[] r4 = new int[r4]
            r5 = r18
            r6 = 0
            r7 = 0
        L_0x0016:
            r8 = r17[r1]
            r9 = 900(0x384, float:1.261E-42)
            r10 = 913(0x391, float:1.28E-42)
            if (r5 >= r8) goto L_0x0056
            if (r6 != 0) goto L_0x0056
            int r8 = r5 + 1
            r5 = r17[r5]
            if (r5 >= r9) goto L_0x0033
            int r9 = r5 / 30
            r2[r7] = r9
            int r9 = r7 + 1
            int r5 = r5 % 30
            r2[r9] = r5
            int r7 = r7 + 2
            goto L_0x0045
        L_0x0033:
            if (r5 == r10) goto L_0x004b
            r10 = 928(0x3a0, float:1.3E-42)
            if (r5 == r10) goto L_0x0047
            switch(r5) {
                case 900: goto L_0x0040;
                case 901: goto L_0x0047;
                case 902: goto L_0x0047;
                default: goto L_0x003c;
            }
        L_0x003c:
            switch(r5) {
                case 922: goto L_0x0047;
                case 923: goto L_0x0047;
                case 924: goto L_0x0047;
                default: goto L_0x003f;
            }
        L_0x003f:
            goto L_0x0045
        L_0x0040:
            int r5 = r7 + 1
            r2[r7] = r9
            r7 = r5
        L_0x0045:
            r5 = r8
            goto L_0x0016
        L_0x0047:
            int r5 = r8 + -1
            r6 = 1
            goto L_0x0016
        L_0x004b:
            r2[r7] = r10
            int r5 = r8 + 1
            r8 = r17[r8]
            r4[r7] = r8
            int r7 = r7 + 1
            goto L_0x0016
        L_0x0056:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r6 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            r8 = r6
            r11 = 0
        L_0x005a:
            if (r11 >= r7) goto L_0x0162
            r12 = r2[r11]
            int r13 = r6.ordinal()
            r15 = 29
            r1 = 26
            r16 = 32
            r14 = 28
            if (r13 == 0) goto L_0x012b
            if (r13 == r3) goto L_0x0104
            r3 = 2
            if (r13 == r3) goto L_0x00ca
            r3 = 3
            if (r13 == r3) goto L_0x00ad
            r3 = 4
            if (r13 == r3) goto L_0x0098
            r1 = 5
            if (r13 == r1) goto L_0x007c
            goto L_0x0156
        L_0x007c:
            if (r12 >= r15) goto L_0x0083
            char[] r1 = PUNCT_CHARS
            char r1 = r1[r12]
            goto L_0x009d
        L_0x0083:
            if (r12 != r15) goto L_0x0089
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r6 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0156
        L_0x0089:
            if (r12 != r10) goto L_0x0092
            r1 = r4[r11]
            char r1 = (char) r1
            r0.append(r1)
            goto L_0x00aa
        L_0x0092:
            if (r12 != r9) goto L_0x00aa
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r6 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0156
        L_0x0098:
            if (r12 >= r1) goto L_0x00a0
            int r12 = r12 + 65
            char r1 = (char) r12
        L_0x009d:
            r16 = r1
            goto L_0x00a2
        L_0x00a0:
            if (r12 != r1) goto L_0x00a4
        L_0x00a2:
            r6 = r8
            goto L_0x00d4
        L_0x00a4:
            if (r12 != r9) goto L_0x00aa
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r6 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0156
        L_0x00aa:
            r6 = r8
            goto L_0x0156
        L_0x00ad:
            if (r12 >= r15) goto L_0x00b4
            char[] r1 = PUNCT_CHARS
            char r1 = r1[r12]
            goto L_0x00d2
        L_0x00b4:
            if (r12 != r15) goto L_0x00ba
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r6 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0156
        L_0x00ba:
            if (r12 != r10) goto L_0x00c4
            r1 = r4[r11]
            char r1 = (char) r1
            r0.append(r1)
            goto L_0x0156
        L_0x00c4:
            if (r12 != r9) goto L_0x0156
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r6 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0156
        L_0x00ca:
            r3 = 25
            if (r12 >= r3) goto L_0x00d8
            char[] r1 = MIXED_CHARS
            char r1 = r1[r12]
        L_0x00d2:
            r16 = r1
        L_0x00d4:
            r1 = r16
            goto L_0x0157
        L_0x00d8:
            if (r12 != r3) goto L_0x00de
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r6 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT
            goto L_0x0156
        L_0x00de:
            if (r12 != r1) goto L_0x00e1
            goto L_0x0133
        L_0x00e1:
            r1 = 27
            if (r12 != r1) goto L_0x00e9
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r6 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER
            goto L_0x0156
        L_0x00e9:
            if (r12 != r14) goto L_0x00ef
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r6 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0156
        L_0x00ef:
            if (r12 != r15) goto L_0x00f4
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x0146
        L_0x00f4:
            if (r12 != r10) goto L_0x00fe
            r1 = r4[r11]
            char r1 = (char) r1
            r0.append(r1)
            goto L_0x0156
        L_0x00fe:
            if (r12 != r9) goto L_0x0156
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r6 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0156
        L_0x0104:
            if (r12 >= r1) goto L_0x0109
            int r12 = r12 + 97
            goto L_0x012f
        L_0x0109:
            if (r12 != r1) goto L_0x010c
            goto L_0x0133
        L_0x010c:
            r1 = 27
            if (r12 != r1) goto L_0x0113
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA_SHIFT
            goto L_0x0146
        L_0x0113:
            if (r12 != r14) goto L_0x0118
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r6 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED
            goto L_0x0156
        L_0x0118:
            if (r12 != r15) goto L_0x011d
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x0146
        L_0x011d:
            if (r12 != r10) goto L_0x0126
            r1 = r4[r11]
            char r1 = (char) r1
            r0.append(r1)
            goto L_0x0156
        L_0x0126:
            if (r12 != r9) goto L_0x0156
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r6 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0156
        L_0x012b:
            if (r12 >= r1) goto L_0x0131
            int r12 = r12 + 65
        L_0x012f:
            char r1 = (char) r12
            goto L_0x0157
        L_0x0131:
            if (r12 != r1) goto L_0x0136
        L_0x0133:
            r1 = 32
            goto L_0x0157
        L_0x0136:
            r1 = 27
            if (r12 != r1) goto L_0x013d
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r6 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER
            goto L_0x0156
        L_0x013d:
            if (r12 != r14) goto L_0x0142
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r6 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED
            goto L_0x0156
        L_0x0142:
            if (r12 != r15) goto L_0x0149
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
        L_0x0146:
            r8 = r6
            r6 = r1
            goto L_0x0156
        L_0x0149:
            if (r12 != r10) goto L_0x0152
            r1 = r4[r11]
            char r1 = (char) r1
            r0.append(r1)
            goto L_0x0156
        L_0x0152:
            if (r12 != r9) goto L_0x0156
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r6 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
        L_0x0156:
            r1 = 0
        L_0x0157:
            if (r1 == 0) goto L_0x015c
            r0.append(r1)
        L_0x015c:
            int r11 = r11 + 1
            r1 = 0
            r3 = 1
            goto L_0x005a
        L_0x0162:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.textCompaction(int[], int, java.lang.StringBuilder):int");
    }
}
