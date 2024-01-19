package org.jboss.netty.channel.socket.nio;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.WritableByteChannel;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.FileRegion;

public final class SocketSendBufferPool {
    public static final int ALIGN_MASK = 15;
    public static final int ALIGN_SHIFT = 4;
    public static final int DEFAULT_PREALLOCATION_SIZE = 65536;
    public static final SendBuffer EMPTY_BUFFER = new EmptySendBuffer();
    public Preallocation current = new Preallocation(65536);
    public PreallocationRef poolHead = null;

    public static final class EmptySendBuffer implements SendBuffer {
        public final boolean finished() {
            return true;
        }

        public void release() {
        }

        public final long totalBytes() {
            return 0;
        }

        public final long transferTo(DatagramChannel datagramChannel, SocketAddress socketAddress) throws IOException {
            return 0;
        }

        public final long transferTo(WritableByteChannel writableByteChannel) throws IOException {
            return 0;
        }

        public final long writtenBytes() {
            return 0;
        }
    }

    public final class FileSendBuffer implements SendBuffer {
        public final FileRegion file;
        public long writtenBytes;

        public FileSendBuffer(FileRegion fileRegion) {
            this.file = fileRegion;
        }

        public boolean finished() {
            return this.writtenBytes >= this.file.getCount();
        }

        public void release() {
        }

        public long totalBytes() {
            return this.file.getCount();
        }

        public long transferTo(WritableByteChannel writableByteChannel) throws IOException {
            long transferTo = this.file.transferTo(writableByteChannel, this.writtenBytes);
            this.writtenBytes += transferTo;
            return transferTo;
        }

        public long writtenBytes() {
            return this.writtenBytes;
        }

        public long transferTo(DatagramChannel datagramChannel, SocketAddress socketAddress) throws IOException {
            throw new UnsupportedOperationException();
        }
    }

    public final class PooledSendBuffer implements SendBuffer {
        public final ByteBuffer buffer;
        public final int initialPos;
        public final Preallocation parent;

        public PooledSendBuffer(Preallocation preallocation, ByteBuffer byteBuffer) {
            this.parent = preallocation;
            this.buffer = byteBuffer;
            this.initialPos = byteBuffer.position();
        }

        public boolean finished() {
            return !this.buffer.hasRemaining();
        }

        public void release() {
            Preallocation preallocation = this.parent;
            int i = preallocation.refCnt - 1;
            preallocation.refCnt = i;
            if (i == 0) {
                preallocation.buffer.clear();
                SocketSendBufferPool socketSendBufferPool = SocketSendBufferPool.this;
                if (preallocation != socketSendBufferPool.current) {
                    SocketSendBufferPool socketSendBufferPool2 = SocketSendBufferPool.this;
                    socketSendBufferPool.poolHead = new PreallocationRef(preallocation, socketSendBufferPool2.poolHead);
                }
            }
        }

        public long totalBytes() {
            return (long) (this.buffer.limit() - this.initialPos);
        }

        public long transferTo(WritableByteChannel writableByteChannel) throws IOException {
            return (long) writableByteChannel.write(this.buffer);
        }

        public long writtenBytes() {
            return (long) (this.buffer.position() - this.initialPos);
        }

        public long transferTo(DatagramChannel datagramChannel, SocketAddress socketAddress) throws IOException {
            return (long) datagramChannel.send(this.buffer, socketAddress);
        }
    }

    public final class Preallocation {
        public final ByteBuffer buffer;
        public int refCnt;

        public Preallocation(int i) {
            this.buffer = ByteBuffer.allocateDirect(i);
        }
    }

    public final class PreallocationRef extends SoftReference<Preallocation> {
        public final PreallocationRef next;

        public PreallocationRef(Preallocation preallocation, PreallocationRef preallocationRef) {
            super(preallocation);
            this.next = preallocationRef;
        }
    }

    public interface SendBuffer {
        boolean finished();

        void release();

        long totalBytes();

        long transferTo(DatagramChannel datagramChannel, SocketAddress socketAddress) throws IOException;

        long transferTo(WritableByteChannel writableByteChannel) throws IOException;

        long writtenBytes();
    }

    public class UnpooledSendBuffer implements SendBuffer {
        public final ByteBuffer buffer;
        public final int initialPos;

        public UnpooledSendBuffer(ByteBuffer byteBuffer) {
            this.buffer = byteBuffer;
            this.initialPos = byteBuffer.position();
        }

        public final boolean finished() {
            return !this.buffer.hasRemaining();
        }

        public void release() {
        }

        public final long totalBytes() {
            return (long) (this.buffer.limit() - this.initialPos);
        }

        public final long transferTo(WritableByteChannel writableByteChannel) throws IOException {
            return (long) writableByteChannel.write(this.buffer);
        }

        public final long writtenBytes() {
            return (long) (this.buffer.position() - this.initialPos);
        }

        public final long transferTo(DatagramChannel datagramChannel, SocketAddress socketAddress) throws IOException {
            return (long) datagramChannel.send(this.buffer, socketAddress);
        }
    }

    public static final int align(int i) {
        int i2 = i >>> 4;
        if ((i & 15) != 0) {
            i2++;
        }
        return i2 << 4;
    }

    private final Preallocation getPreallocation() {
        Preallocation preallocation = this.current;
        if (preallocation.refCnt != 0) {
            return getPreallocation0();
        }
        preallocation.buffer.clear();
        return preallocation;
    }

    private final Preallocation getPreallocation0() {
        PreallocationRef preallocationRef = this.poolHead;
        if (preallocationRef != null) {
            do {
                Preallocation preallocation = (Preallocation) preallocationRef.get();
                preallocationRef = preallocationRef.next;
                if (preallocation != null) {
                    this.poolHead = preallocationRef;
                    return preallocation;
                }
            } while (preallocationRef != null);
            this.poolHead = preallocationRef;
        }
        return new Preallocation(65536);
    }

    public final SendBuffer acquire(Object obj) {
        if (obj instanceof ChannelBuffer) {
            return acquire((ChannelBuffer) obj);
        }
        if (obj instanceof FileRegion) {
            return acquire((FileRegion) obj);
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("unsupported message type: ");
        outline73.append(obj.getClass());
        throw new IllegalArgumentException(outline73.toString());
    }

    private final SendBuffer acquire(FileRegion fileRegion) {
        if (fileRegion.getCount() == 0) {
            return EMPTY_BUFFER;
        }
        return new FileSendBuffer(fileRegion);
    }

    private final SendBuffer acquire(ChannelBuffer channelBuffer) {
        PooledSendBuffer pooledSendBuffer;
        int readableBytes = channelBuffer.readableBytes();
        if (readableBytes == 0) {
            return EMPTY_BUFFER;
        }
        if (channelBuffer.isDirect()) {
            return new UnpooledSendBuffer(channelBuffer.toByteBuffer());
        }
        if (channelBuffer.readableBytes() > 65536) {
            return new UnpooledSendBuffer(channelBuffer.toByteBuffer());
        }
        Preallocation preallocation = this.current;
        ByteBuffer byteBuffer = preallocation.buffer;
        int remaining = byteBuffer.remaining();
        if (readableBytes < remaining) {
            int position = byteBuffer.position() + readableBytes;
            ByteBuffer duplicate = byteBuffer.duplicate();
            byteBuffer.position(align(position));
            duplicate.limit(position);
            preallocation.refCnt++;
            pooledSendBuffer = new PooledSendBuffer(preallocation, duplicate);
        } else if (readableBytes > remaining) {
            Preallocation preallocation2 = getPreallocation();
            this.current = preallocation2;
            ByteBuffer byteBuffer2 = preallocation2.buffer;
            ByteBuffer duplicate2 = byteBuffer2.duplicate();
            byteBuffer2.position(align(readableBytes));
            duplicate2.limit(readableBytes);
            preallocation2.refCnt++;
            pooledSendBuffer = new PooledSendBuffer(preallocation2, duplicate2);
        } else {
            preallocation.refCnt++;
            this.current = getPreallocation0();
            pooledSendBuffer = new PooledSendBuffer(preallocation, preallocation.buffer);
        }
        ByteBuffer byteBuffer3 = pooledSendBuffer.buffer;
        byteBuffer3.mark();
        channelBuffer.getBytes(channelBuffer.readerIndex(), byteBuffer3);
        byteBuffer3.reset();
        return pooledSendBuffer;
    }
}
