package org.apache.pdfbox.util;

public final class Hex {
    public static byte[] getBytes(byte b2) {
        return getString(b2).getBytes(Charsets.US_ASCII);
    }

    public static String getString(byte b2) {
        return Integer.toHexString((b2 & 255) | 256).substring(1).toUpperCase();
    }
}
