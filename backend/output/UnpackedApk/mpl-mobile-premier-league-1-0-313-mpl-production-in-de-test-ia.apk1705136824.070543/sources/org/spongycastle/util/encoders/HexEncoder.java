package org.spongycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.pdfbox.pdfparser.BaseParser;

public class HexEncoder implements Encoder {
    public final byte[] decodingTable = new byte[128];
    public final byte[] encodingTable = {BaseParser.ASCII_ZERO, 49, 50, 51, 52, 53, 54, 55, 56, BaseParser.ASCII_NINE, 97, 98, 99, 100, 101, 102};

    public HexEncoder() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.decodingTable;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        while (true) {
            byte[] bArr2 = this.encodingTable;
            if (i < bArr2.length) {
                this.decodingTable[bArr2[i]] = (byte) i;
                i++;
            } else {
                byte[] bArr3 = this.decodingTable;
                bArr3[65] = bArr3[97];
                bArr3[66] = bArr3[98];
                bArr3[67] = bArr3[99];
                bArr3[68] = bArr3[100];
                bArr3[69] = bArr3[101];
                bArr3[70] = bArr3[102];
                return;
            }
        }
    }

    public static boolean ignore(char c2) {
        return c2 == 10 || c2 == 13 || c2 == 9 || c2 == ' ';
    }

    public int decode(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        int i3 = i2 + i;
        while (i3 > i) {
            int i4 = i3 - 1;
            if (!ignore((char) bArr[i4])) {
                break;
            }
            i3 = i4;
        }
        int i5 = 0;
        while (i < i3) {
            while (i < i3 && ignore((char) bArr[i])) {
                i++;
            }
            int i6 = i + 1;
            byte b2 = this.decodingTable[bArr[i]];
            while (i6 < i3 && ignore((char) bArr[i6])) {
                i6++;
            }
            int i7 = i6 + 1;
            byte b3 = this.decodingTable[bArr[i6]];
            if ((b2 | b3) >= 0) {
                outputStream.write((b2 << 4) | b3);
                i5++;
                i = i7;
            } else {
                throw new IOException("invalid characters encountered in Hex data");
            }
        }
        return i5;
    }

    public int encode(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        for (int i3 = i; i3 < i + i2; i3++) {
            byte b2 = bArr[i3] & 255;
            outputStream.write(this.encodingTable[b2 >>> 4]);
            outputStream.write(this.encodingTable[b2 & 15]);
        }
        return i2 * 2;
    }

    public int decode(String str, OutputStream outputStream) throws IOException {
        int length = str.length();
        while (length > 0) {
            int i = length - 1;
            if (!ignore(str.charAt(i))) {
                break;
            }
            length = i;
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            while (i2 < length && ignore(str.charAt(i2))) {
                i2++;
            }
            int i4 = i2 + 1;
            byte b2 = this.decodingTable[str.charAt(i2)];
            while (i4 < length && ignore(str.charAt(i4))) {
                i4++;
            }
            int i5 = i4 + 1;
            byte b3 = this.decodingTable[str.charAt(i4)];
            if ((b2 | b3) >= 0) {
                outputStream.write((b2 << 4) | b3);
                i3++;
                i2 = i5;
            } else {
                throw new IOException("invalid characters encountered in Hex string");
            }
        }
        return i3;
    }
}
