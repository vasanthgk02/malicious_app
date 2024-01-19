package org.apache.fontbox.pfb;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class PfbParser {
    public static final int ASCII_MARKER = 1;
    public static final int BINARY_MARKER = 2;
    public static final int BUFFER_SIZE = 65535;
    public static final int PFB_HEADER_LENGTH = 18;
    public static final int[] PFB_RECORDS = {1, 2, 1};
    public static final int START_MARKER = 128;
    public int[] lengths;
    public byte[] pfbdata;

    public PfbParser(String str) throws IOException {
        this((InputStream) new BufferedInputStream(new FileInputStream(str), 65535));
    }

    private void parsePfb(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        this.pfbdata = new byte[(bArr.length - 18)];
        this.lengths = new int[PFB_RECORDS.length];
        int i = 0;
        int i2 = 0;
        while (i < PFB_RECORDS.length) {
            if (byteArrayInputStream.read() != 128) {
                throw new IOException("Start marker missing");
            } else if (byteArrayInputStream.read() == PFB_RECORDS[i]) {
                int read = byteArrayInputStream.read() + (byteArrayInputStream.read() << 8) + (byteArrayInputStream.read() << 16) + (byteArrayInputStream.read() << 24);
                this.lengths[i] = read;
                int read2 = byteArrayInputStream.read(this.pfbdata, i2, read);
                if (read2 >= 0) {
                    i2 += read2;
                    i++;
                } else {
                    throw new EOFException();
                }
            } else {
                throw new IOException("Incorrect record type");
            }
        }
    }

    private byte[] readPfbInput(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[65535];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(this.pfbdata);
    }

    public int[] getLengths() {
        return this.lengths;
    }

    public byte[] getPfbdata() {
        return this.pfbdata;
    }

    public byte[] getSegment1() {
        return Arrays.copyOfRange(this.pfbdata, 0, this.lengths[0]);
    }

    public byte[] getSegment2() {
        byte[] bArr = this.pfbdata;
        int[] iArr = this.lengths;
        return Arrays.copyOfRange(bArr, iArr[0], iArr[0] + iArr[1]);
    }

    public int size() {
        return this.pfbdata.length;
    }

    public PfbParser(InputStream inputStream) throws IOException {
        parsePfb(readPfbInput(inputStream));
    }

    public PfbParser(byte[] bArr) throws IOException {
        parsePfb(bArr);
    }
}
