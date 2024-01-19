package com.facebook.imageformat;

import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.imageformat.ImageFormat.FormatChecker;

public class DefaultImageFormatChecker implements FormatChecker {
    public static final byte[] BMP_HEADER;
    public static final int BMP_HEADER_LENGTH;
    public static final byte[] DNG_HEADER_II;
    public static final int DNG_HEADER_LENGTH;
    public static final byte[] DNG_HEADER_MM = {77, 77, 0, 42};
    public static final byte[] GIF_HEADER_87A = ImageOriginUtils.asciiBytes("GIF87a");
    public static final byte[] GIF_HEADER_89A = ImageOriginUtils.asciiBytes("GIF89a");
    public static final byte[] HEIF_HEADER_PREFIX = ImageOriginUtils.asciiBytes("ftyp");
    public static final byte[][] HEIF_HEADER_SUFFIXES = {ImageOriginUtils.asciiBytes("heic"), ImageOriginUtils.asciiBytes("heix"), ImageOriginUtils.asciiBytes("hevc"), ImageOriginUtils.asciiBytes("hevx"), ImageOriginUtils.asciiBytes("mif1"), ImageOriginUtils.asciiBytes("msf1")};
    public static final byte[] ICO_HEADER;
    public static final int ICO_HEADER_LENGTH;
    public static final byte[] JPEG_HEADER;
    public static final int JPEG_HEADER_LENGTH;
    public static final byte[] PNG_HEADER;
    public static final int PNG_HEADER_LENGTH;
    public final int MAX_HEADER_LENGTH;

    static {
        byte[] bArr = {-1, -40, -1};
        JPEG_HEADER = bArr;
        JPEG_HEADER_LENGTH = bArr.length;
        byte[] bArr2 = {-119, 80, 78, 71, 13, 10, 26, 10};
        PNG_HEADER = bArr2;
        PNG_HEADER_LENGTH = bArr2.length;
        byte[] asciiBytes = ImageOriginUtils.asciiBytes("BM");
        BMP_HEADER = asciiBytes;
        BMP_HEADER_LENGTH = asciiBytes.length;
        byte[] bArr3 = {0, 0, 1, 0};
        ICO_HEADER = bArr3;
        ICO_HEADER_LENGTH = bArr3.length;
        byte[] bArr4 = {73, 73, 42, 0};
        DNG_HEADER_II = bArr4;
        DNG_HEADER_LENGTH = bArr4.length;
    }

    public DefaultImageFormatChecker() {
        int[] iArr = {21, 20, JPEG_HEADER_LENGTH, PNG_HEADER_LENGTH, 6, BMP_HEADER_LENGTH, ICO_HEADER_LENGTH, 12};
        k.checkArgument(true);
        int i = iArr[0];
        for (int i2 = 1; i2 < 8; i2++) {
            if (iArr[i2] > i) {
                i = iArr[i2];
            }
        }
        this.MAX_HEADER_LENGTH = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:93:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0106  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.facebook.imageformat.ImageFormat determineFormat(byte[] r8, int r9) {
        /*
            r7 = this;
            r0 = 0
            boolean r1 = com.facebook.common.webp.WebpSupportStatus.isWebpHeader(r8, r0, r9)
            r2 = 12
            r3 = 1
            if (r1 == 0) goto L_0x0075
            boolean r1 = com.facebook.common.webp.WebpSupportStatus.isWebpHeader(r8, r0, r9)
            co.hyperverge.hypersnapsdk.c.k.checkArgument(r1)
            byte[] r1 = com.facebook.common.webp.WebpSupportStatus.WEBP_VP8_BYTES
            boolean r1 = com.facebook.common.webp.WebpSupportStatus.matchBytePattern(r8, r2, r1)
            if (r1 == 0) goto L_0x001c
            com.facebook.imageformat.ImageFormat r8 = com.facebook.imageformat.DefaultImageFormats.WEBP_SIMPLE
            goto L_0x0074
        L_0x001c:
            byte[] r1 = com.facebook.common.webp.WebpSupportStatus.WEBP_VP8L_BYTES
            boolean r1 = com.facebook.common.webp.WebpSupportStatus.matchBytePattern(r8, r2, r1)
            if (r1 == 0) goto L_0x0027
            com.facebook.imageformat.ImageFormat r8 = com.facebook.imageformat.DefaultImageFormats.WEBP_LOSSLESS
            goto L_0x0074
        L_0x0027:
            r1 = 21
            if (r9 < r1) goto L_0x0035
            byte[] r9 = com.facebook.common.webp.WebpSupportStatus.WEBP_VP8X_BYTES
            boolean r9 = com.facebook.common.webp.WebpSupportStatus.matchBytePattern(r8, r2, r9)
            if (r9 == 0) goto L_0x0035
            r9 = 1
            goto L_0x0036
        L_0x0035:
            r9 = 0
        L_0x0036:
            if (r9 == 0) goto L_0x0072
            byte[] r9 = com.facebook.common.webp.WebpSupportStatus.WEBP_VP8X_BYTES
            boolean r9 = com.facebook.common.webp.WebpSupportStatus.matchBytePattern(r8, r2, r9)
            r1 = 20
            byte r4 = r8[r1]
            r5 = 2
            r4 = r4 & r5
            if (r4 != r5) goto L_0x0048
            r4 = 1
            goto L_0x0049
        L_0x0048:
            r4 = 0
        L_0x0049:
            if (r9 == 0) goto L_0x004f
            if (r4 == 0) goto L_0x004f
            r9 = 1
            goto L_0x0050
        L_0x004f:
            r9 = 0
        L_0x0050:
            if (r9 == 0) goto L_0x0055
            com.facebook.imageformat.ImageFormat r8 = com.facebook.imageformat.DefaultImageFormats.WEBP_ANIMATED
            goto L_0x0074
        L_0x0055:
            byte[] r9 = com.facebook.common.webp.WebpSupportStatus.WEBP_VP8X_BYTES
            boolean r9 = com.facebook.common.webp.WebpSupportStatus.matchBytePattern(r8, r2, r9)
            byte r8 = r8[r1]
            r1 = 16
            r8 = r8 & r1
            if (r8 != r1) goto L_0x0064
            r8 = 1
            goto L_0x0065
        L_0x0064:
            r8 = 0
        L_0x0065:
            if (r9 == 0) goto L_0x006a
            if (r8 == 0) goto L_0x006a
            r0 = 1
        L_0x006a:
            if (r0 == 0) goto L_0x006f
            com.facebook.imageformat.ImageFormat r8 = com.facebook.imageformat.DefaultImageFormats.WEBP_EXTENDED_WITH_ALPHA
            goto L_0x0074
        L_0x006f:
            com.facebook.imageformat.ImageFormat r8 = com.facebook.imageformat.DefaultImageFormats.WEBP_EXTENDED
            goto L_0x0074
        L_0x0072:
            com.facebook.imageformat.ImageFormat r8 = com.facebook.imageformat.ImageFormat.UNKNOWN
        L_0x0074:
            return r8
        L_0x0075:
            byte[] r1 = JPEG_HEADER
            int r4 = r1.length
            if (r9 < r4) goto L_0x0082
            boolean r1 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.startsWithPattern(r8, r1)
            if (r1 == 0) goto L_0x0082
            r1 = 1
            goto L_0x0083
        L_0x0082:
            r1 = 0
        L_0x0083:
            if (r1 == 0) goto L_0x0088
            com.facebook.imageformat.ImageFormat r8 = com.facebook.imageformat.DefaultImageFormats.JPEG
            return r8
        L_0x0088:
            byte[] r1 = PNG_HEADER
            int r4 = r1.length
            if (r9 < r4) goto L_0x0095
            boolean r1 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.startsWithPattern(r8, r1)
            if (r1 == 0) goto L_0x0095
            r1 = 1
            goto L_0x0096
        L_0x0095:
            r1 = 0
        L_0x0096:
            if (r1 == 0) goto L_0x009b
            com.facebook.imageformat.ImageFormat r8 = com.facebook.imageformat.DefaultImageFormats.PNG
            return r8
        L_0x009b:
            r1 = 6
            if (r9 >= r1) goto L_0x009f
            goto L_0x00b0
        L_0x009f:
            byte[] r1 = GIF_HEADER_87A
            boolean r1 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.startsWithPattern(r8, r1)
            if (r1 != 0) goto L_0x00b2
            byte[] r1 = GIF_HEADER_89A
            boolean r1 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.startsWithPattern(r8, r1)
            if (r1 == 0) goto L_0x00b0
            goto L_0x00b2
        L_0x00b0:
            r1 = 0
            goto L_0x00b3
        L_0x00b2:
            r1 = 1
        L_0x00b3:
            if (r1 == 0) goto L_0x00b8
            com.facebook.imageformat.ImageFormat r8 = com.facebook.imageformat.DefaultImageFormats.GIF
            return r8
        L_0x00b8:
            byte[] r1 = BMP_HEADER
            int r4 = r1.length
            if (r9 >= r4) goto L_0x00bf
            r1 = 0
            goto L_0x00c3
        L_0x00bf:
            boolean r1 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.startsWithPattern(r8, r1)
        L_0x00c3:
            if (r1 == 0) goto L_0x00c8
            com.facebook.imageformat.ImageFormat r8 = com.facebook.imageformat.DefaultImageFormats.BMP
            return r8
        L_0x00c8:
            byte[] r1 = ICO_HEADER
            int r4 = r1.length
            if (r9 >= r4) goto L_0x00cf
            r1 = 0
            goto L_0x00d3
        L_0x00cf:
            boolean r1 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.startsWithPattern(r8, r1)
        L_0x00d3:
            if (r1 == 0) goto L_0x00d8
            com.facebook.imageformat.ImageFormat r8 = com.facebook.imageformat.DefaultImageFormats.ICO
            return r8
        L_0x00d8:
            if (r9 >= r2) goto L_0x00db
            goto L_0x0100
        L_0x00db:
            r1 = 3
            byte r1 = r8[r1]
            r2 = 8
            if (r1 >= r2) goto L_0x00e3
            goto L_0x0100
        L_0x00e3:
            byte[] r1 = HEIF_HEADER_PREFIX
            r4 = 4
            boolean r1 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.hasPatternAt(r8, r1, r4)
            if (r1 != 0) goto L_0x00ed
            goto L_0x0100
        L_0x00ed:
            byte[][] r1 = HEIF_HEADER_SUFFIXES
            int r4 = r1.length
            r5 = 0
        L_0x00f1:
            if (r5 >= r4) goto L_0x0100
            r6 = r1[r5]
            boolean r6 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.hasPatternAt(r8, r6, r2)
            if (r6 == 0) goto L_0x00fd
            r1 = 1
            goto L_0x0101
        L_0x00fd:
            int r5 = r5 + 1
            goto L_0x00f1
        L_0x0100:
            r1 = 0
        L_0x0101:
            if (r1 == 0) goto L_0x0106
            com.facebook.imageformat.ImageFormat r8 = com.facebook.imageformat.DefaultImageFormats.HEIF
            return r8
        L_0x0106:
            int r1 = DNG_HEADER_LENGTH
            if (r9 < r1) goto L_0x011b
            byte[] r9 = DNG_HEADER_II
            boolean r9 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.startsWithPattern(r8, r9)
            if (r9 != 0) goto L_0x011a
            byte[] r9 = DNG_HEADER_MM
            boolean r8 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.startsWithPattern(r8, r9)
            if (r8 == 0) goto L_0x011b
        L_0x011a:
            r0 = 1
        L_0x011b:
            if (r0 == 0) goto L_0x0120
            com.facebook.imageformat.ImageFormat r8 = com.facebook.imageformat.DefaultImageFormats.DNG
            return r8
        L_0x0120:
            com.facebook.imageformat.ImageFormat r8 = com.facebook.imageformat.ImageFormat.UNKNOWN
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imageformat.DefaultImageFormatChecker.determineFormat(byte[], int):com.facebook.imageformat.ImageFormat");
    }

    public int getHeaderSize() {
        return this.MAX_HEADER_LENGTH;
    }
}
