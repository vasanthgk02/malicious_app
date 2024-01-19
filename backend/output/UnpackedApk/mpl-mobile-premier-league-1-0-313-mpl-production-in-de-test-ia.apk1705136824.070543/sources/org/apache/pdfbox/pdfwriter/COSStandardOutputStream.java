package org.apache.pdfbox.pdfwriter;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class COSStandardOutputStream extends FilterOutputStream {
    public static final byte[] CRLF = {13, 10};
    public static final byte[] EOL = {10};
    public static final byte[] LF = {10};
    public boolean onNewLine = false;
    public long position = 0;

    public COSStandardOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public long getPos() {
        return this.position;
    }

    public boolean isOnNewLine() {
        return this.onNewLine;
    }

    public void setOnNewLine(boolean z) {
        this.onNewLine = z;
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        setOnNewLine(false);
        this.out.write(bArr, i, i2);
        this.position += (long) i2;
    }

    public void writeCRLF() throws IOException {
        write(CRLF);
    }

    public void writeEOL() throws IOException {
        if (!isOnNewLine()) {
            write(EOL);
            setOnNewLine(true);
        }
    }

    public void writeLF() throws IOException {
        write(LF);
    }

    public COSStandardOutputStream(OutputStream outputStream, int i) {
        super(outputStream);
        this.position = (long) i;
    }

    public void write(int i) throws IOException {
        setOnNewLine(false);
        this.out.write(i);
        this.position++;
    }
}
