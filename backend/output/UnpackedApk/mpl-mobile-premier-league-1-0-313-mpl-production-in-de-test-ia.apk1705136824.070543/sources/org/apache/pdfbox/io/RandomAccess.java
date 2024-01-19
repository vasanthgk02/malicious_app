package org.apache.pdfbox.io;

import java.io.IOException;

public interface RandomAccess extends RandomAccessRead {
    void write(int i) throws IOException;

    void write(byte[] bArr, int i, int i2) throws IOException;
}
