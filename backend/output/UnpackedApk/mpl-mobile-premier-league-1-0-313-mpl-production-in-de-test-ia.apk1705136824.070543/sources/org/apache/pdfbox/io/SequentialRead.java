package org.apache.pdfbox.io;

import java.io.IOException;

public interface SequentialRead {
    void close() throws IOException;

    int read() throws IOException;

    int read(byte[] bArr, int i, int i2) throws IOException;
}
