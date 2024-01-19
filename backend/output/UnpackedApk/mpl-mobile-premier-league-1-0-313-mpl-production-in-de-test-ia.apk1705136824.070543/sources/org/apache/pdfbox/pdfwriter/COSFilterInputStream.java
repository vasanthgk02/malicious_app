package org.apache.pdfbox.pdfwriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class COSFilterInputStream extends FilterInputStream {
    public final int[] byteRange;
    public long position = 0;

    public COSFilterInputStream(InputStream inputStream, int[] iArr) {
        super(inputStream);
        this.byteRange = iArr;
    }

    private boolean inRange() throws IOException {
        long j = this.position;
        int i = 0;
        while (true) {
            int[] iArr = this.byteRange;
            if (i >= iArr.length / 2) {
                return false;
            }
            int i2 = i * 2;
            if (((long) iArr[i2]) <= j && ((long) (iArr[i2] + iArr[i2 + 1])) > j) {
                return true;
            }
            i++;
        }
    }

    private void nextAvailable() throws IOException {
        while (!inRange()) {
            this.position++;
            if (super.read() < 0) {
                return;
            }
        }
    }

    public int read() throws IOException {
        nextAvailable();
        int read = super.read();
        if (read > -1) {
            this.position++;
        }
        return read;
    }

    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public COSFilterInputStream(byte[] bArr, int[] iArr) {
        super(new ByteArrayInputStream(bArr));
        this.byteRange = iArr;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        int read = read();
        if (read == -1) {
            return -1;
        }
        bArr[i] = (byte) read;
        int i3 = 1;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            try {
                int read2 = read();
                if (read2 == -1) {
                    break;
                }
                bArr[i + i3] = (byte) read2;
                i3++;
            } catch (IOException unused) {
            }
        }
        return i3;
    }
}
