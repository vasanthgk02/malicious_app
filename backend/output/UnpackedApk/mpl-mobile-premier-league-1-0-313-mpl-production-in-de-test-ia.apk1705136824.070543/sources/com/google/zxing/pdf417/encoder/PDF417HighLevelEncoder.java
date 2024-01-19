package com.google.zxing.pdf417.encoder;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.jboss.netty.handler.codec.http.HttpCodecUtil;

public final class PDF417HighLevelEncoder {
    public static final Charset DEFAULT_ENCODING = Charset.forName("ISO-8859-1");
    public static final byte[] MIXED = new byte[128];
    public static final byte[] PUNCTUATION = new byte[128];
    public static final byte[] TEXT_MIXED_RAW = {BaseParser.ASCII_ZERO, 49, 50, 51, 52, 53, 54, 55, 56, BaseParser.ASCII_NINE, 38, 13, 9, HttpCodecUtil.COMMA, HttpCodecUtil.COLON, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};
    public static final byte[] TEXT_PUNCTUATION_RAW = {HttpCodecUtil.SEMICOLON, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, HttpCodecUtil.COMMA, HttpCodecUtil.COLON, 10, 45, 46, 36, 47, HttpCodecUtil.DOUBLE_QUOTE, 124, 42, 40, 41, Utf8.REPLACEMENT_BYTE, 123, 125, 39, 0};

    static {
        Arrays.fill(MIXED, -1);
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = TEXT_MIXED_RAW;
            if (i2 >= bArr.length) {
                break;
            }
            byte b2 = bArr[i2];
            if (b2 > 0) {
                MIXED[b2] = (byte) i2;
            }
            i2++;
        }
        Arrays.fill(PUNCTUATION, -1);
        while (true) {
            byte[] bArr2 = TEXT_PUNCTUATION_RAW;
            if (i < bArr2.length) {
                byte b3 = bArr2[i];
                if (b3 > 0) {
                    PUNCTUATION[b3] = (byte) i;
                }
                i++;
            } else {
                return;
            }
        }
    }

    public static void encodeBinary(byte[] bArr, int i, int i2, int i3, StringBuilder sb) {
        int i4;
        if (i2 == 1 && i3 == 0) {
            sb.append(913);
        } else if (i2 % 6 == 0) {
            sb.append(924);
        } else {
            sb.append(901);
        }
        if (i2 >= 6) {
            char[] cArr = new char[5];
            i4 = i;
            while ((i + i2) - i4 >= 6) {
                long j = 0;
                for (int i5 = 0; i5 < 6; i5++) {
                    j = (j << 8) + ((long) (bArr[i4 + i5] & 255));
                }
                for (int i6 = 0; i6 < 5; i6++) {
                    cArr[i6] = (char) ((int) (j % 900));
                    j /= 900;
                }
                for (int i7 = 4; i7 >= 0; i7--) {
                    sb.append(cArr[i7]);
                }
                i4 += 6;
            }
        } else {
            i4 = i;
        }
        while (i4 < i + i2) {
            sb.append((char) (bArr[i4] & 255));
            i4++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0113, code lost:
        r12 = r12 - r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String encodeHighLevel(java.lang.String r17, com.google.zxing.pdf417.encoder.Compaction r18, java.nio.charset.Charset r19) throws com.google.zxing.WriterException {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r4 = r17.length()
            r3.<init>(r4)
            r4 = 900(0x384, float:1.261E-42)
            if (r2 != 0) goto L_0x0016
            java.nio.charset.Charset r2 = DEFAULT_ENCODING
            goto L_0x006e
        L_0x0016:
            java.nio.charset.Charset r5 = DEFAULT_ENCODING
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto L_0x006e
            java.lang.String r5 = r19.name()
            com.google.zxing.common.CharacterSetECI r5 = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByName(r5)
            if (r5 == 0) goto L_0x006e
            int r5 = r5.getValue()
            if (r5 < 0) goto L_0x003a
            if (r5 >= r4) goto L_0x003a
            r6 = 927(0x39f, float:1.299E-42)
            r3.append(r6)
            char r5 = (char) r5
            r3.append(r5)
            goto L_0x006e
        L_0x003a:
            r6 = 810900(0xc5f94, float:1.136313E-39)
            if (r5 >= r6) goto L_0x0052
            r6 = 926(0x39e, float:1.298E-42)
            r3.append(r6)
            int r6 = r5 / 900
            int r6 = r6 + -1
            char r6 = (char) r6
            r3.append(r6)
            int r5 = r5 % r4
            char r5 = (char) r5
            r3.append(r5)
            goto L_0x006e
        L_0x0052:
            r7 = 811800(0xc6318, float:1.137574E-39)
            if (r5 >= r7) goto L_0x0062
            r7 = 925(0x39d, float:1.296E-42)
            r3.append(r7)
            int r6 = r6 - r5
            char r5 = (char) r6
            r3.append(r5)
            goto L_0x006e
        L_0x0062:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "ECI number not in valid range from 0..811799, but was "
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline40(r1, r5)
            r0.<init>(r1)
            throw r0
        L_0x006e:
            int r5 = r17.length()
            com.google.zxing.pdf417.encoder.Compaction r6 = com.google.zxing.pdf417.encoder.Compaction.TEXT
            r7 = 0
            if (r1 != r6) goto L_0x007c
            encodeText(r0, r7, r5, r3, r7)
            goto L_0x019d
        L_0x007c:
            com.google.zxing.pdf417.encoder.Compaction r6 = com.google.zxing.pdf417.encoder.Compaction.BYTE
            r8 = 1
            if (r1 != r6) goto L_0x008b
            byte[] r0 = r0.getBytes(r2)
            int r1 = r0.length
            encodeBinary(r0, r7, r1, r8, r3)
            goto L_0x019d
        L_0x008b:
            com.google.zxing.pdf417.encoder.Compaction r6 = com.google.zxing.pdf417.encoder.Compaction.NUMERIC
            r9 = 902(0x386, float:1.264E-42)
            if (r1 != r6) goto L_0x0099
            r3.append(r9)
            encodeNumeric(r0, r7, r5, r3)
            goto L_0x019d
        L_0x0099:
            r1 = 0
            r6 = 0
            r10 = 0
        L_0x009c:
            if (r1 >= r5) goto L_0x019d
            int r11 = r17.length()
            if (r1 >= r11) goto L_0x00bd
            char r12 = r0.charAt(r1)
            r13 = 0
            r14 = r1
        L_0x00aa:
            boolean r15 = isDigit(r12)
            if (r15 == 0) goto L_0x00be
            if (r14 >= r11) goto L_0x00be
            int r13 = r13 + 1
            int r14 = r14 + 1
            if (r14 >= r11) goto L_0x00aa
            char r12 = r0.charAt(r14)
            goto L_0x00aa
        L_0x00bd:
            r13 = 0
        L_0x00be:
            r11 = 13
            if (r13 < r11) goto L_0x00cc
            r3.append(r9)
            r10 = 2
            encodeNumeric(r0, r1, r13, r3)
            int r1 = r1 + r13
            r6 = 0
            goto L_0x009c
        L_0x00cc:
            int r9 = r17.length()
            r12 = r1
        L_0x00d1:
            if (r12 >= r9) goto L_0x0113
            char r14 = r0.charAt(r12)
            r15 = 0
        L_0x00d8:
            if (r15 >= r11) goto L_0x00ed
            boolean r16 = isDigit(r14)
            if (r16 == 0) goto L_0x00ed
            if (r12 >= r9) goto L_0x00ed
            int r15 = r15 + 1
            int r12 = r12 + 1
            if (r12 >= r9) goto L_0x00d8
            char r14 = r0.charAt(r12)
            goto L_0x00d8
        L_0x00ed:
            if (r15 < r11) goto L_0x00f2
            int r12 = r12 - r1
            int r12 = r12 - r15
            goto L_0x0114
        L_0x00f2:
            if (r15 > 0) goto L_0x00d1
            char r14 = r0.charAt(r12)
            r15 = 9
            if (r14 == r15) goto L_0x010d
            r15 = 10
            if (r14 == r15) goto L_0x010d
            if (r14 == r11) goto L_0x010d
            r15 = 32
            if (r14 < r15) goto L_0x010b
            r15 = 126(0x7e, float:1.77E-43)
            if (r14 > r15) goto L_0x010b
            goto L_0x010d
        L_0x010b:
            r14 = 0
            goto L_0x010e
        L_0x010d:
            r14 = 1
        L_0x010e:
            if (r14 == 0) goto L_0x0113
            int r12 = r12 + 1
            goto L_0x00d1
        L_0x0113:
            int r12 = r12 - r1
        L_0x0114:
            r9 = 5
            if (r12 >= r9) goto L_0x018d
            if (r13 != r5) goto L_0x011b
            goto L_0x018d
        L_0x011b:
            java.nio.charset.CharsetEncoder r9 = r2.newEncoder()
            int r12 = r17.length()
            r13 = r1
        L_0x0124:
            if (r13 >= r12) goto L_0x016f
            char r14 = r0.charAt(r13)
            r15 = 0
        L_0x012b:
            if (r15 >= r11) goto L_0x013e
            boolean r14 = isDigit(r14)
            if (r14 == 0) goto L_0x013e
            int r15 = r15 + 1
            int r14 = r13 + r15
            if (r14 >= r12) goto L_0x013e
            char r14 = r0.charAt(r14)
            goto L_0x012b
        L_0x013e:
            if (r15 < r11) goto L_0x0141
            goto L_0x016f
        L_0x0141:
            char r14 = r0.charAt(r13)
            boolean r15 = r9.canEncode(r14)
            if (r15 == 0) goto L_0x014e
            int r13 = r13 + 1
            goto L_0x0124
        L_0x014e:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Non-encodable character detected: "
            r1.<init>(r2)
            r1.append(r14)
            java.lang.String r2 = " (Unicode: "
            r1.append(r2)
            r1.append(r14)
            r2 = 41
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x016f:
            int r13 = r13 - r1
            if (r13 != 0) goto L_0x0173
            r13 = 1
        L_0x0173:
            int r13 = r13 + r1
            java.lang.String r1 = r0.substring(r1, r13)
            byte[] r1 = r1.getBytes(r2)
            int r9 = r1.length
            if (r9 != r8) goto L_0x0185
            if (r10 != 0) goto L_0x0185
            encodeBinary(r1, r7, r8, r7, r3)
            goto L_0x018b
        L_0x0185:
            int r6 = r1.length
            encodeBinary(r1, r7, r6, r10, r3)
            r6 = 0
            r10 = 1
        L_0x018b:
            r1 = r13
            goto L_0x0199
        L_0x018d:
            if (r10 == 0) goto L_0x0194
            r3.append(r4)
            r6 = 0
            r10 = 0
        L_0x0194:
            int r6 = encodeText(r0, r1, r12, r3, r6)
            int r1 = r1 + r12
        L_0x0199:
            r9 = 902(0x386, float:1.264E-42)
            goto L_0x009c
        L_0x019d:
            java.lang.String r0 = r3.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.encodeHighLevel(java.lang.String, com.google.zxing.pdf417.encoder.Compaction, java.nio.charset.Charset):java.lang.String");
    }

    public static void encodeNumeric(String str, int i, int i2, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i2 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900);
        BigInteger valueOf2 = BigInteger.valueOf(0);
        int i3 = 0;
        while (i3 < i2) {
            sb2.setLength(0);
            int min = Math.min(44, i2 - i3);
            StringBuilder sb3 = new StringBuilder("1");
            int i4 = i + i3;
            sb3.append(str.substring(i4, i4 + min));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            int length = sb2.length();
            while (true) {
                length--;
                if (length < 0) {
                    break;
                }
                sb.append(sb2.charAt(length));
            }
            i3 += min;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x0101 A[EDGE_INSN: B:75:0x0101->B:60:0x0101 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0011 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int encodeText(java.lang.CharSequence r16, int r17, int r18, java.lang.StringBuilder r19, int r20) {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            r4 = 2
            r5 = 0
            r6 = 1
            r7 = r20
            r8 = 0
        L_0x0011:
            int r9 = r17 + r8
            char r10 = r0.charAt(r9)
            r11 = 26
            r12 = 32
            r13 = 28
            r14 = 27
            r15 = 29
            if (r7 == 0) goto L_0x00c7
            if (r7 == r6) goto L_0x008e
            r11 = -1
            if (r7 == r4) goto L_0x0041
            byte[] r9 = PUNCTUATION
            byte r9 = r9[r10]
            if (r9 == r11) goto L_0x0030
            r9 = 1
            goto L_0x0031
        L_0x0030:
            r9 = 0
        L_0x0031:
            if (r9 == 0) goto L_0x003d
            byte[] r9 = PUNCTUATION
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x00fd
        L_0x003d:
            r3.append(r15)
            goto L_0x005a
        L_0x0041:
            boolean r12 = isMixed(r10)
            if (r12 == 0) goto L_0x0051
            byte[] r9 = MIXED
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x00fd
        L_0x0051:
            boolean r12 = isAlphaUpper(r10)
            if (r12 == 0) goto L_0x005c
            r3.append(r13)
        L_0x005a:
            r7 = 0
            goto L_0x0011
        L_0x005c:
            boolean r12 = isAlphaLower(r10)
            if (r12 == 0) goto L_0x0067
            r3.append(r14)
            goto L_0x00e3
        L_0x0067:
            int r9 = r9 + 1
            if (r9 >= r1) goto L_0x0081
            char r9 = r0.charAt(r9)
            byte[] r12 = PUNCTUATION
            byte r9 = r12[r9]
            if (r9 == r11) goto L_0x0077
            r9 = 1
            goto L_0x0078
        L_0x0077:
            r9 = 0
        L_0x0078:
            if (r9 == 0) goto L_0x0081
            r7 = 3
            r9 = 25
            r3.append(r9)
            goto L_0x0011
        L_0x0081:
            r3.append(r15)
            byte[] r9 = PUNCTUATION
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x00fd
        L_0x008e:
            boolean r9 = isAlphaLower(r10)
            if (r9 == 0) goto L_0x00a1
            if (r10 != r12) goto L_0x009a
            r3.append(r11)
            goto L_0x00fd
        L_0x009a:
            int r10 = r10 + -97
            char r9 = (char) r10
            r3.append(r9)
            goto L_0x00fd
        L_0x00a1:
            boolean r9 = isAlphaUpper(r10)
            if (r9 == 0) goto L_0x00b1
            r3.append(r14)
            int r10 = r10 + -65
            char r9 = (char) r10
            r3.append(r9)
            goto L_0x00fd
        L_0x00b1:
            boolean r9 = isMixed(r10)
            if (r9 == 0) goto L_0x00bb
            r3.append(r13)
            goto L_0x00ef
        L_0x00bb:
            r3.append(r15)
            byte[] r9 = PUNCTUATION
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x00fd
        L_0x00c7:
            boolean r9 = isAlphaUpper(r10)
            if (r9 == 0) goto L_0x00da
            if (r10 != r12) goto L_0x00d3
            r3.append(r11)
            goto L_0x00fd
        L_0x00d3:
            int r10 = r10 + -65
            char r9 = (char) r10
            r3.append(r9)
            goto L_0x00fd
        L_0x00da:
            boolean r9 = isAlphaLower(r10)
            if (r9 == 0) goto L_0x00e6
            r3.append(r14)
        L_0x00e3:
            r7 = 1
            goto L_0x0011
        L_0x00e6:
            boolean r9 = isMixed(r10)
            if (r9 == 0) goto L_0x00f2
            r3.append(r13)
        L_0x00ef:
            r7 = 2
            goto L_0x0011
        L_0x00f2:
            r3.append(r15)
            byte[] r9 = PUNCTUATION
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
        L_0x00fd:
            int r8 = r8 + 1
            if (r8 < r1) goto L_0x0011
            int r0 = r3.length()
            r1 = 0
            r8 = 0
        L_0x0107:
            if (r1 >= r0) goto L_0x0125
            int r9 = r1 % 2
            if (r9 == 0) goto L_0x010f
            r9 = 1
            goto L_0x0110
        L_0x010f:
            r9 = 0
        L_0x0110:
            if (r9 == 0) goto L_0x011e
            int r8 = r8 * 30
            char r9 = r3.charAt(r1)
            int r9 = r9 + r8
            char r8 = (char) r9
            r2.append(r8)
            goto L_0x0122
        L_0x011e:
            char r8 = r3.charAt(r1)
        L_0x0122:
            int r1 = r1 + 1
            goto L_0x0107
        L_0x0125:
            int r0 = r0 % r4
            if (r0 == 0) goto L_0x012f
            int r8 = r8 * 30
            int r8 = r8 + r15
            char r0 = (char) r8
            r2.append(r0)
        L_0x012f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.encodeText(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    public static boolean isAlphaLower(char c2) {
        return c2 == ' ' || (c2 >= 'a' && c2 <= 'z');
    }

    public static boolean isAlphaUpper(char c2) {
        return c2 == ' ' || (c2 >= 'A' && c2 <= 'Z');
    }

    public static boolean isDigit(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    public static boolean isMixed(char c2) {
        return MIXED[c2] != -1;
    }
}
