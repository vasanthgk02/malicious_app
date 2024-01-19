package org.apache.pdfbox.io;

import java.io.IOException;

public interface RandomAccessRead extends SequentialRead {
    long getPosition() throws IOException;

    boolean isClosed();

    long length() throws IOException;

    void seek(long j) throws IOException;
}
