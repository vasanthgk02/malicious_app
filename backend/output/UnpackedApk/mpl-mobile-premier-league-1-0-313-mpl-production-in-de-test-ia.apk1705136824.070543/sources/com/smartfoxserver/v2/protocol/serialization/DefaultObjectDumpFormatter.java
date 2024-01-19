package com.smartfoxserver.v2.protocol.serialization;

import java.util.Arrays;

public class DefaultObjectDumpFormatter {
    public static final char TOKEN_DIVIDER = ';';
    public static final char TOKEN_INDENT_CLOSE = '}';
    public static final char TOKEN_INDENT_OPEN = '{';

    public static String getFormatTabs(int i) {
        return strFill(9, i);
    }

    public static String prettyPrintByteArray(byte[] bArr) {
        if (bArr == null) {
            return "Null";
        }
        return String.format("Byte[%s]", new Object[]{Integer.valueOf(bArr.length)});
    }

    public static String prettyPrintDump(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '{') {
                i++;
                sb.append("\n");
                sb.append(getFormatTabs(i));
            } else if (charAt == '}') {
                i--;
                if (i >= 0) {
                    sb.append("\n");
                    sb.append(getFormatTabs(i));
                } else {
                    throw new IllegalStateException("Argh! The indentPos is negative. TOKENS ARE NOT BALANCED!");
                }
            } else if (charAt == ';') {
                sb.append("\n");
                sb.append(getFormatTabs(i));
            } else {
                sb.append(charAt);
            }
        }
        if (i == 0) {
            return sb.toString();
        }
        throw new IllegalStateException("Argh! The indentPos is not == 0. TOKENS ARE NOT BALANCED!");
    }

    public static String strFill(char c2, int i) {
        char[] cArr = new char[i];
        Arrays.fill(cArr, c2);
        return new String(cArr);
    }
}
