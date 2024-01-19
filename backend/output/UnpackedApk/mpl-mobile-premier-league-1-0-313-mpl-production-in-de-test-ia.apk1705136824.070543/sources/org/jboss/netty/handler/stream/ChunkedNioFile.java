package org.jboss.netty.handler.stream;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.jboss.netty.buffer.ChannelBuffers;

public class ChunkedNioFile implements ChunkedInput {
    public final int chunkSize;
    public final long endOffset;

    /* renamed from: in  reason: collision with root package name */
    public final FileChannel f6171in;
    public volatile long offset;
    public long startOffset;

    public ChunkedNioFile(File file) throws IOException {
        this(new FileInputStream(file).getChannel());
    }

    public void close() throws Exception {
        this.f6171in.close();
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
        return this.offset < this.endOffset && this.f6171in.isOpen();
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
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        int i = 0;
        do {
            int read = this.f6171in.read(wrap);
            if (read < 0) {
                break;
            }
            i += read;
        } while (i != min);
        this.offset += (long) i;
        return ChannelBuffers.wrappedBuffer(bArr);
    }

    public ChunkedNioFile(File file, int i) throws IOException {
        this(new FileInputStream(file).getChannel(), i);
    }

    public ChunkedNioFile(FileChannel fileChannel) throws IOException {
        this(fileChannel, 8192);
    }

    public ChunkedNioFile(FileChannel fileChannel, int i) throws IOException {
        this(fileChannel, 0, fileChannel.size(), i);
    }

    public ChunkedNioFile(FileChannel fileChannel, long j, long j2, int i) throws IOException {
        if (fileChannel != null) {
            int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("offset: " + j + " (expected: 0 or greater)");
            } else if (j2 < 0) {
                throw new IllegalArgumentException("length: " + j2 + " (expected: 0 or greater)");
            } else if (i > 0) {
                if (i2 != 0) {
                    fileChannel.position(j);
                }
                this.f6171in = fileChannel;
                this.chunkSize = i;
                this.startOffset = j;
                this.offset = j;
                this.endOffset = j + j2;
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline42("chunkSize: ", i, " (expected: a positive integer)"));
            }
        } else {
            throw new NullPointerException("in");
        }
    }
}
