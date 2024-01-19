package org.spongycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;
import okio.Utf8;
import org.apache.pdfbox.pdfparser.BaseParser;

public class Base64Encoder implements Encoder {
    public final byte[] decodingTable = new byte[128];
    public final byte[] encodingTable = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, BaseParser.ASCII_ZERO, 49, 50, 51, 52, 53, 54, 55, 56, BaseParser.ASCII_NINE, 43, 47};
    public byte padding = 61;

    public Base64Encoder() {
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
                return;
            }
        }
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
        int i5 = i3 - 4;
        int nextI = nextI(bArr, i, i5);
        int i6 = 0;
        while (nextI < i5) {
            int i7 = nextI + 1;
            byte b2 = this.decodingTable[bArr[nextI]];
            int nextI2 = nextI(bArr, i7, i5);
            int i8 = nextI2 + 1;
            byte b3 = this.decodingTable[bArr[nextI2]];
            int nextI3 = nextI(bArr, i8, i5);
            int i9 = nextI3 + 1;
            byte b4 = this.decodingTable[bArr[nextI3]];
            int nextI4 = nextI(bArr, i9, i5);
            int i10 = nextI4 + 1;
            byte b5 = this.decodingTable[bArr[nextI4]];
            if ((b2 | b3 | b4 | b5) >= 0) {
                outputStream.write((b2 << 2) | (b3 >> 4));
                outputStream.write((b3 << 4) | (b4 >> 2));
                outputStream.write((b4 << 6) | b5);
                i6 += 3;
                nextI = nextI(bArr, i10, i5);
            } else {
                throw new IOException("invalid characters encountered in base64 data");
            }
        }
        return i6 + decodeLastBlock(outputStream, (char) bArr[i5], (char) bArr[i3 - 3], (char) bArr[i3 - 2], (char) bArr[i3 - 1]);
    }

    public final int decodeLastBlock(OutputStream outputStream, char c2, char c3, char c4, char c5) throws IOException {
        byte b2 = this.padding;
        if (c4 == b2) {
            byte[] bArr = this.decodingTable;
            byte b3 = bArr[c2];
            byte b4 = bArr[c3];
            if ((b3 | b4) >= 0) {
                outputStream.write((b3 << 2) | (b4 >> 4));
                return 1;
            }
            throw new IOException("invalid characters encountered at end of base64 data");
        } else if (c5 == b2) {
            byte[] bArr2 = this.decodingTable;
            byte b5 = bArr2[c2];
            byte b6 = bArr2[c3];
            byte b7 = bArr2[c4];
            if ((b5 | b6 | b7) >= 0) {
                outputStream.write((b5 << 2) | (b6 >> 4));
                outputStream.write((b6 << 4) | (b7 >> 2));
                return 2;
            }
            throw new IOException("invalid characters encountered at end of base64 data");
        } else {
            byte[] bArr3 = this.decodingTable;
            byte b8 = bArr3[c2];
            byte b9 = bArr3[c3];
            byte b10 = bArr3[c4];
            byte b11 = bArr3[c5];
            if ((b8 | b9 | b10 | b11) >= 0) {
                outputStream.write((b8 << 2) | (b9 >> 4));
                outputStream.write((b9 << 4) | (b10 >> 2));
                outputStream.write((b10 << 6) | b11);
                return 3;
            }
            throw new IOException("invalid characters encountered at end of base64 data");
        }
    }

    public int encode(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        int i3;
        int i4;
        int i5 = i2 % 3;
        int i6 = i2 - i5;
        int i7 = i;
        while (true) {
            i3 = i + i6;
            i4 = 4;
            if (i7 >= i3) {
                break;
            }
            byte b2 = bArr[i7] & 255;
            byte b3 = bArr[i7 + 1] & 255;
            byte b4 = bArr[i7 + 2] & 255;
            outputStream.write(this.encodingTable[(b2 >>> 2) & 63]);
            outputStream.write(this.encodingTable[((b2 << 4) | (b3 >>> 4)) & 63]);
            outputStream.write(this.encodingTable[((b3 << 2) | (b4 >>> 6)) & 63]);
            outputStream.write(this.encodingTable[b4 & Utf8.REPLACEMENT_BYTE]);
            i7 += 3;
        }
        if (i5 == 1) {
            byte b5 = bArr[i3] & 255;
            outputStream.write(this.encodingTable[(b5 >>> 2) & 63]);
            outputStream.write(this.encodingTable[(b5 << 4) & 63]);
            outputStream.write(this.padding);
            outputStream.write(this.padding);
        } else if (i5 == 2) {
            byte b6 = bArr[i3] & 255;
            byte b7 = bArr[i3 + 1] & 255;
            outputStream.write(this.encodingTable[(b6 >>> 2) & 63]);
            outputStream.write(this.encodingTable[((b6 << 4) | (b7 >>> 4)) & 63]);
            outputStream.write(this.encodingTable[(b7 << 2) & 63]);
            outputStream.write(this.padding);
        }
        int i8 = (i6 / 3) * 4;
        if (i5 == 0) {
            i4 = 0;
        }
        return i8 + i4;
    }

    public final boolean ignore(char c2) {
        return c2 == 10 || c2 == 13 || c2 == 9 || c2 == ' ';
    }

    public final int nextI(byte[] bArr, int i, int i2) {
        while (i < i2 && ignore((char) bArr[i])) {
            i++;
        }
        return i;
    }

    public final int nextI(String str, int i, int i2) {
        while (i < i2 && ignore(str.charAt(i))) {
            i++;
        }
        return i;
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
        int i2 = length - 4;
        int i3 = 0;
        int nextI = nextI(str, 0, i2);
        while (nextI < i2) {
            int i4 = nextI + 1;
            byte b2 = this.decodingTable[str.charAt(nextI)];
            int nextI2 = nextI(str, i4, i2);
            int i5 = nextI2 + 1;
            byte b3 = this.decodingTable[str.charAt(nextI2)];
            int nextI3 = nextI(str, i5, i2);
            int i6 = nextI3 + 1;
            byte b4 = this.decodingTable[str.charAt(nextI3)];
            int nextI4 = nextI(str, i6, i2);
            int i7 = nextI4 + 1;
            byte b5 = this.decodingTable[str.charAt(nextI4)];
            if ((b2 | b3 | b4 | b5) >= 0) {
                outputStream.write((b2 << 2) | (b3 >> 4));
                outputStream.write((b3 << 4) | (b4 >> 2));
                outputStream.write((b4 << 6) | b5);
                i3 += 3;
                nextI = nextI(str, i7, i2);
            } else {
                throw new IOException("invalid characters encountered in base64 data");
            }
        }
        return i3 + decodeLastBlock(outputStream, str.charAt(i2), str.charAt(length - 3), str.charAt(length - 2), str.charAt(length - 1));
    }
}
