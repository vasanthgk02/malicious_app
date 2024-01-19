package org.jboss.netty.handler.stream;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.jboss.netty.buffer.ChannelBuffers;

public class ChunkedFile implements ChunkedInput {
    public final int chunkSize;
    public final long endOffset;
    public final RandomAccessFile file;
    public volatile long offset;
    public final long startOffset;

    public ChunkedFile(File file2) throws IOException {
        this(file2, 8192);
    }

    public void close() throws Exception {
        this.file.close();
    }

    public long getCurrentOffset() {
        return this.offset;
    }

    public long getEndOffset() {
        return this.endOffset;
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    public boolean hasNextChunk() throws Exception {
        return this.offset < this.endOffset && this.file.getChannel().isOpen();
    }

    public boolean isEndOfInput() throws Exception {
        return !hasNextChunk();
    }

    public Object nextChunk() throws Exception {
        long j = this.offset;
        long j2 = this.endOffset;
        if (j >= j2) {
            return null;
        }
        int min = (int) Math.min((long) this.chunkSize, j2 - j);
        byte[] bArr = new byte[min];
        this.file.readFully(bArr);
        this.offset = j + ((long) min);
        return ChannelBuffers.wrappedBuffer(bArr);
    }

    public ChunkedFile(File file2, int i) throws IOException {
        this(new RandomAccessFile(file2, "r"), i);
    }

    public ChunkedFile(RandomAccessFile randomAccessFile) throws IOException {
        this(randomAccessFile, 8192);
    }

    public ChunkedFile(RandomAccessFile randomAccessFile, int i) throws IOException {
        this(randomAccessFile, 0, randomAccessFile.length(), i);
    }

    public ChunkedFile(RandomAccessFile randomAccessFile, long j, long j2, int i) throws IOException {
        if (randomAccessFile == null) {
            throw new NullPointerException("file");
        } else if (j < 0) {
            throw new IllegalArgumentException("offset: " + j + " (expected: 0 or greater)");
        } else if (j2 < 0) {
            throw new IllegalArgumentException("length: " + j2 + " (expected: 0 or greater)");
        } else if (i > 0) {
            this.file = randomAccessFile;
            this.startOffset = j;
            this.offset = j;
            this.endOffset = j2 + j;
            this.chunkSize = i;
            randomAccessFile.seek(j);
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline42("chunkSize: ", i, " (expected: a positive integer)"));
        }
    }
}
