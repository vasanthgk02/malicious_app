package org.apache.pdfbox.cos;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.net.ftp.FTPReply;

public final class PDFDocEncoding {
    public static final int[] CODE_TO_UNI = new int[256];
    public static final char REPLACEMENT_CHARACTER = '�';
    public static final Map<Character, Integer> UNI_TO_CODE = new HashMap(256);

    static {
        for (int i = 0; i < 256; i++) {
            set(i, (char) i);
        }
        set(24, 728);
        set(25, 711);
        set(26, 710);
        set(27, 729);
        set(28, 733);
        set(29, 731);
        set(30, 730);
        set(31, 732);
        set(127, 65533);
        set(128, 8226);
        set(129, 8224);
        set(130, 8225);
        set(131, 8230);
        set(132, 8212);
        set(133, 8211);
        set(134, 402);
        set(135, 8260);
        set(136, 8249);
        set(137, 8250);
        set(138, 8722);
        set(139, 8240);
        set(140, 8222);
        set(141, 8220);
        set(142, 8221);
        set(143, 8216);
        set(144, 8217);
        set(145, 8218);
        set(146, 8482);
        set(147, 64257);
        set(148, 64258);
        set(149, 321);
        set(FTPReply.FILE_STATUS_OK, 338);
        set(151, 352);
        set(152, 376);
        set(153, 381);
        set(154, 305);
        set(155, 322);
        set(156, 339);
        set(157, 353);
        set(158, 382);
        set(159, 65533);
        set(160, 8364);
    }

    public static boolean containsChar(char c2) {
        return UNI_TO_CODE.containsKey(Character.valueOf(c2));
    }

    public static byte[] getBytes(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (char c2 : str.toCharArray()) {
            if (UNI_TO_CODE.get(Character.valueOf(c2)) == null) {
                byteArrayOutputStream.write(0);
            } else {
                byteArrayOutputStream.write(c2);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void set(int i, char c2) {
        CODE_TO_UNI[i] = c2;
        UNI_TO_CODE.put(Character.valueOf(c2), Integer.valueOf(i));
    }

    public static String toString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            byte b3 = b2 & 255;
            int[] iArr = CODE_TO_UNI;
            if (b3 >= iArr.length) {
                sb.append('?');
            } else {
                sb.append((char) iArr[b3]);
            }
        }
        return sb.toString();
    }
}
