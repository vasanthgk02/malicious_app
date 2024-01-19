package com.facebook.common.webp;

import java.io.UnsupportedEncodingException;

public class WebpSupportStatus {
    public static final byte[] WEBP_NAME_BYTES = asciiBytes("WEBP");
    public static final byte[] WEBP_RIFF_BYTES = asciiBytes("RIFF");
    public static final byte[] WEBP_VP8L_BYTES = asciiBytes("VP8L");
    public static final byte[] WEBP_VP8X_BYTES = asciiBytes("VP8X");
    public static final byte[] WEBP_VP8_BYTES = asciiBytes("VP8 ");
    public static final boolean sIsExtendedWebpSupported = true;
    public static final boolean sIsWebpSupportRequired = false;
    public static WebpBitmapFactory sWebpBitmapFactory;
    public static boolean sWebpLibraryChecked;

    public static byte[] asciiBytes(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("ASCII not found!", e2);
        }
    }

    public static boolean isWebpHeader(byte[] bArr, int i, int i2) {
        return i2 >= 20 && matchBytePattern(bArr, i, WEBP_RIFF_BYTES) && matchBytePattern(bArr, i + 8, WEBP_NAME_BYTES);
    }

    public static WebpBitmapFactory loadWebpBitmapFactoryIfExists() {
        if (sWebpLibraryChecked) {
            return sWebpBitmapFactory;
        }
        WebpBitmapFactory webpBitmapFactory = null;
        try {
            webpBitmapFactory = (WebpBitmapFactory) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable unused) {
        }
        sWebpLibraryChecked = true;
        return webpBitmapFactory;
    }

    public static boolean matchBytePattern(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
