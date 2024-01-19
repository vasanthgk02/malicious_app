package com.smartfoxserver.bitswarm.util;

import java.nio.ByteBuffer;
import org.apache.fontbox.cmap.CMap;

public class ByteUtils {
    public static final char DOT = '.';
    public static final int HEX_BYTES_PER_LINE = 16;
    public static final String NEW_LINE = System.getProperty("line.separator");
    public static final char TAB = '\t';

    public static String fullHexDump(ByteBuffer byteBuffer, int i) {
        return fullHexDump(byteBuffer.array(), i);
    }

    public static byte[] resizeByteArray(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static String fullHexDump(ByteBuffer byteBuffer) {
        return fullHexDump(byteBuffer.array(), 16);
    }

    public static String fullHexDump(byte[] bArr) {
        return fullHexDump(bArr, 16);
    }

    public static String fullHexDump(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder("Binary size: ");
        sb.append(bArr.length);
        sb.append("\n");
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        int i2 = 0;
        int i3 = 0;
        do {
            byte b2 = bArr[i2];
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb2.append("0");
            }
            sb2.append(hexString.toUpperCase());
            sb2.append(CMap.SPACE);
            sb3.append((b2 < 33 || b2 > 126) ? '.' : (char) b2);
            i3++;
            if (i3 == i) {
                sb.append(sb2);
                sb.append(9);
                sb.append(sb3);
                sb.append(NEW_LINE);
                sb2.delete(0, sb2.length());
                sb3.delete(0, sb3.length());
                i3 = 0;
            }
            i2++;
        } while (i2 < bArr.length);
        if (i3 != 0) {
            for (int i4 = i - i3; i4 > 0; i4--) {
                sb2.append("   ");
                sb3.append(CMap.SPACE);
            }
            sb.append(sb2);
            sb.append(9);
            sb.append(sb3);
            sb.append(NEW_LINE);
        }
        return sb.toString();
    }
}
