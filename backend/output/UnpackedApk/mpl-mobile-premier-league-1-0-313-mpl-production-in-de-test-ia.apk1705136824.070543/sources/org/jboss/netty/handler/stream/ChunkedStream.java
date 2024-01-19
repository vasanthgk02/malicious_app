package org.jboss.netty.handler.stream;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.InputStream;
import java.io.PushbackInputStream;
import org.jboss.netty.buffer.ChannelBuffers;

public class ChunkedStream implements ChunkedInput {
    public static final int DEFAULT_CHUNK_SIZE = 8192;
    public final int chunkSize;

    /* renamed from: in  reason: collision with root package name */
    public final PushbackInputStream f6173in;
    public volatile long offset;

    public ChunkedStream(InputStream inputStream) {
        this(inputStream, 8192);
    }

    public void close() throws Exception {
        this.f6173in.close();
    }

    public long getTransferredBytes() {
        return this.offset;
    }

    public boolean hasNextChunk() throws Exception {
        int read = this.f6173in.read();
        if (read < 0) {
            return false;
        }
        this.f6173in.unread(read);
        return true;
    }

    public boolean isEndOfInput() throws Exception {
        return !hasNextChunk();
    }

    public Object nextChunk() throws Exception {
        int i;
        if (!hasNextChunk()) {
            return null;
        }
        if (this.f6173in.available() <= 0) {
            i = this.chunkSize;
        } else {
            i = Math.min(this.chunkSize, this.f6173in.available());
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        do {
            int read = this.f6173in.read(bArr, i2, i - i2);
            if (read < 0) {
                break;
            }
            i2 += read;
            this.offset += (long) read;
        } while (i2 != i);
        return ChannelBuffers.wrappedBuffer(bArr, 0, i2);
    }

    public ChunkedStream(InputStream inputStream, int i) {
        if (inputStream == null) {
            throw new NullPointerException("in");
        } else if (i > 0) {
            if (inputStream instanceof PushbackInputStream) {
                this.f6173in = (PushbackInputStream) inputStream;
            } else {
                this.f6173in = new PushbackInputStream(inputStream);
            }
            this.chunkSize = i;
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline42("chunkSize: ", i, " (expected: a positive integer)"));
        }
    }
}
