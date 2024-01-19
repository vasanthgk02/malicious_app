package org.apache.pdfbox.filter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.util.Hex;

public final class ASCIIHexFilter extends Filter {
    public static final int[] REVERSE_HEX = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15};

    public static boolean isEOD(int i) {
        return i == 62;
    }

    public static boolean isWhitespace(int i) {
        return i == 0 || i == 9 || i == 10 || i == 12 || i == 13 || i == 32;
    }

    public DecodeResult decode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary, int i) throws IOException {
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                break;
            }
            while (isWhitespace(read)) {
                read = inputStream.read();
            }
            if (read == -1 || isEOD(read)) {
                break;
            }
            int i2 = REVERSE_HEX[read];
            int i3 = REVERSE_HEX[read] * 16;
            int read2 = inputStream.read();
            if (read2 == -1 || isEOD(read2)) {
                outputStream.write(i3);
            } else {
                if (read2 >= 0) {
                    int i4 = REVERSE_HEX[read2];
                    i3 += REVERSE_HEX[read2];
                }
                outputStream.write(i3);
            }
        }
        outputStream.flush();
        return new DecodeResult(cOSDictionary);
    }

    public void encode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary) throws IOException {
        while (true) {
            int read = inputStream.read();
            if (read != -1) {
                outputStream.write(Hex.getBytes((byte) read));
            } else {
                outputStream.flush();
                return;
            }
        }
    }
}
