package org.jboss.netty.handler.stream;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

public class ChunkedNioStream implements ChunkedInput {
    public final ByteBuffer byteBuffer;
    public final int chunkSize;

    /* renamed from: in  reason: collision with root package name */
    public final ReadableByteChannel f6172in;
    public volatile long offset;

    public ChunkedNioStream(ReadableByteChannel readableByteChannel) {
        this(readableByteChannel, 8192);
    }

    public void close() throws Exception {
        this.f6172in.close();
    }

    public long getTransferredBytes() {
        return this.offset;
    }

    public boolean hasNextChunk() throws Exception {
        if (this.byteBuffer.position() > 0) {
            return true;
        }
        if (!this.f6172in.isOpen()) {
            return false;
        }
        int read = this.f6172in.read(this.byteBuffer);
        if (read < 0) {
            return false;
        }
        this.offset += (long) read;
        return true;
    }

    public boolean isEndOfInput() throws Exception {
        return !hasNextChunk();
    }

    public Object nextChunk() throws Exception {
        if (!hasNextChunk()) {
            return null;
        }
        int position = this.byteBuffer.position();
        do {
            int read = this.f6172in.read(this.byteBuffer);
            if (read < 0) {
                break;
            }
            position += read;
            this.offset += (long) read;
        } while (position != this.chunkSize);
        this.byteBuffer.flip();
        ChannelBuffer copiedBuffer = ChannelBuffers.copiedBuffer(this.byteBuffer);
        this.byteBuffer.clear();
        return copiedBuffer;
    }

    public ChunkedNioStream(ReadableByteChannel readableByteChannel, int i) {
        if (readableByteChannel == null) {
            throw new NullPointerException("in");
        } else if (i > 0) {
            this.f6172in = readableByteChannel;
            this.offset = 0;
            this.chunkSize = i;
            this.byteBuffer = ByteBuffer.allocate(i);
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline42("chunkSize: ", i, " (expected: a positive integer)"));
        }
    }
}
