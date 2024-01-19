package org.apache.pdfbox.filter;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.fontbox.ttf.GlyfDescript;

public final class ASCII85OutputStream extends FilterOutputStream {
    public static final char NEWLINE = '\n';
    public static final char OFFSET = '!';
    public static final char Z = 'z';
    public int count = 0;
    public boolean flushed = true;
    public byte[] indata = new byte[4];
    public int lineBreak = 72;
    public int maxline = 72;
    public byte[] outdata = new byte[5];
    public char terminator = ASCII85InputStream.TERMINATOR;

    public ASCII85OutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    private void transformASCII85() {
        byte[] bArr = this.indata;
        long j = ((long) ((bArr[3] & 255) | (((bArr[0] << 8) | (bArr[1] & 255)) << GlyfDescript.X_DUAL) | ((bArr[2] & 255) << 8))) & 4294967295L;
        if (j == 0) {
            byte[] bArr2 = this.outdata;
            bArr2[0] = 122;
            bArr2[1] = 0;
            return;
        }
        long j2 = j / 52200625;
        byte[] bArr3 = this.outdata;
        bArr3[0] = (byte) ((int) (j2 + 33));
        long j3 = j - ((((j2 * 85) * 85) * 85) * 85);
        long j4 = j3 / 614125;
        bArr3[1] = (byte) ((int) (j4 + 33));
        long j5 = j3 - (((j4 * 85) * 85) * 85);
        long j6 = j5 / 7225;
        bArr3[2] = (byte) ((int) (j6 + 33));
        long j7 = j5 - ((j6 * 85) * 85);
        bArr3[3] = (byte) ((int) ((j7 / 85) + 33));
        bArr3[4] = (byte) ((int) ((j7 % 85) + 33));
    }

    public void close() throws IOException {
        try {
            flush();
            super.close();
        } finally {
            this.outdata = null;
            this.indata = null;
        }
    }

    public void flush() throws IOException {
        if (!this.flushed) {
            int i = this.count;
            if (i > 0) {
                while (i < 4) {
                    this.indata[i] = 0;
                    i++;
                }
                transformASCII85();
                if (this.outdata[0] == 122) {
                    for (int i2 = 0; i2 < 5; i2++) {
                        this.outdata[i2] = 33;
                    }
                }
                for (int i3 = 0; i3 < this.count + 1; i3++) {
                    this.out.write(this.outdata[i3]);
                    int i4 = this.lineBreak - 1;
                    this.lineBreak = i4;
                    if (i4 == 0) {
                        this.out.write(10);
                        this.lineBreak = this.maxline;
                    }
                }
            }
            int i5 = this.lineBreak - 1;
            this.lineBreak = i5;
            if (i5 == 0) {
                this.out.write(10);
            }
            this.out.write(this.terminator);
            this.out.write(10);
            this.count = 0;
            this.lineBreak = this.maxline;
            this.flushed = true;
            super.flush();
        }
    }

    public int getLineLength() {
        return this.maxline;
    }

    public char getTerminator() {
        return this.terminator;
    }

    public void setLineLength(int i) {
        if (this.lineBreak > i) {
            this.lineBreak = i;
        }
        this.maxline = i;
    }

    public void setTerminator(char c2) {
        if (c2 < 'v' || c2 > '~' || c2 == 'z') {
            throw new IllegalArgumentException("Terminator must be 118-126 excluding z");
        }
        this.terminator = c2;
    }

    public void write(int i) throws IOException {
        this.flushed = false;
        byte[] bArr = this.indata;
        int i2 = this.count;
        int i3 = i2 + 1;
        this.count = i3;
        bArr[i2] = (byte) i;
        if (i3 >= 4) {
            transformASCII85();
            for (int i4 = 0; i4 < 5; i4++) {
                byte[] bArr2 = this.outdata;
                if (bArr2[i4] == 0) {
                    break;
                }
                this.out.write(bArr2[i4]);
                int i5 = this.lineBreak - 1;
                this.lineBreak = i5;
                if (i5 == 0) {
                    this.out.write(10);
                    this.lineBreak = this.maxline;
                }
            }
            this.count = 0;
        }
    }
}
