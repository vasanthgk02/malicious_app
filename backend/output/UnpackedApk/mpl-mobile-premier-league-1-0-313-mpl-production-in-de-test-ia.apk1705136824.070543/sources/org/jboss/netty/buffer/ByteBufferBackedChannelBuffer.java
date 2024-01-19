package org.jboss.netty.buffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import org.apache.fontbox.ttf.GlyfDescript;

public class ByteBufferBackedChannelBuffer extends AbstractChannelBuffer {
    public final ByteBuffer buffer;
    public final int capacity;
    public final ByteOrder order;

    public ByteBufferBackedChannelBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            this.order = byteBuffer.order();
            this.buffer = byteBuffer.slice().order(this.order);
            int remaining = byteBuffer.remaining();
            this.capacity = remaining;
            writerIndex(remaining);
            return;
        }
        throw new NullPointerException("buffer");
    }

    public byte[] array() {
        return this.buffer.array();
    }

    public int arrayOffset() {
        return this.buffer.arrayOffset();
    }

    public int capacity() {
        return this.capacity;
    }

    public ChannelBuffer copy(int i, int i2) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) this.buffer.duplicate().position(i).limit(i + i2);
            ByteBuffer allocateDirect = this.buffer.isDirect() ? ByteBuffer.allocateDirect(i2) : ByteBuffer.allocate(i2);
            allocateDirect.put(byteBuffer);
            allocateDirect.order(order());
            allocateDirect.clear();
            return new ByteBufferBackedChannelBuffer(allocateDirect);
        } catch (IllegalArgumentException unused) {
            throw new IndexOutOfBoundsException();
        }
    }

    public ChannelBuffer duplicate() {
        return new ByteBufferBackedChannelBuffer(this);
    }

    public ChannelBufferFactory factory() {
        if (this.buffer.isDirect()) {
            return DirectChannelBufferFactory.getInstance(order());
        }
        return HeapChannelBufferFactory.getInstance(order());
    }

    public byte getByte(int i) {
        return this.buffer.get(i);
    }

    public void getBytes(int i, ChannelBuffer channelBuffer, int i2, int i3) {
        if (channelBuffer instanceof ByteBufferBackedChannelBuffer) {
            ByteBuffer duplicate = ((ByteBufferBackedChannelBuffer) channelBuffer).buffer.duplicate();
            duplicate.limit(i3 + i2).position(i2);
            getBytes(i, duplicate);
        } else if (this.buffer.hasArray()) {
            channelBuffer.setBytes(i2, this.buffer.array(), this.buffer.arrayOffset() + i, i3);
        } else {
            channelBuffer.setBytes(i2, (ChannelBuffer) this, i, i3);
        }
    }

    public int getInt(int i) {
        return this.buffer.getInt(i);
    }

    public long getLong(int i) {
        return this.buffer.getLong(i);
    }

    public short getShort(int i) {
        return this.buffer.getShort(i);
    }

    public int getUnsignedMedium(int i) {
        return ((getByte(i + 2) & 255) << 0) | ((getByte(i) & 255) << GlyfDescript.X_DUAL) | ((getByte(i + 1) & 255) << 8);
    }

    public boolean hasArray() {
        return this.buffer.hasArray();
    }

    public boolean isDirect() {
        return this.buffer.isDirect();
    }

    public ByteOrder order() {
        return this.order;
    }

    public void setByte(int i, int i2) {
        this.buffer.put(i, (byte) i2);
    }

    public void setBytes(int i, ChannelBuffer channelBuffer, int i2, int i3) {
        if (channelBuffer instanceof ByteBufferBackedChannelBuffer) {
            ByteBuffer duplicate = ((ByteBufferBackedChannelBuffer) channelBuffer).buffer.duplicate();
            duplicate.limit(i3 + i2).position(i2);
            setBytes(i, duplicate);
        } else if (this.buffer.hasArray()) {
            channelBuffer.getBytes(i2, this.buffer.array(), this.buffer.arrayOffset() + i, i3);
        } else {
            channelBuffer.getBytes(i2, (ChannelBuffer) this, i, i3);
        }
    }

    public void setInt(int i, int i2) {
        this.buffer.putInt(i, i2);
    }

    public void setLong(int i, long j) {
        this.buffer.putLong(i, j);
    }

    public void setMedium(int i, int i2) {
        setByte(i, (byte) (i2 >>> 16));
        setByte(i + 1, (byte) (i2 >>> 8));
        setByte(i + 2, (byte) (i2 >>> 0));
    }

    public void setShort(int i, int i2) {
        this.buffer.putShort(i, (short) i2);
    }

    public ChannelBuffer slice(int i, int i2) {
        if (i == 0 && i2 == capacity()) {
            ChannelBuffer duplicate = duplicate();
            duplicate.setIndex(0, i2);
            return duplicate;
        } else if (i < 0 || i2 != 0) {
            return new ByteBufferBackedChannelBuffer(((ByteBuffer) this.buffer.duplicate().position(i).limit(i + i2)).order(order()));
        } else {
            return ChannelBuffers.EMPTY_BUFFER;
        }
    }

    public ByteBuffer toByteBuffer(int i, int i2) {
        if (i == 0 && i2 == capacity()) {
            return this.buffer.duplicate().order(order());
        }
        return ((ByteBuffer) this.buffer.duplicate().position(i).limit(i + i2)).slice().order(order());
    }

    public ByteBufferBackedChannelBuffer(ByteBufferBackedChannelBuffer byteBufferBackedChannelBuffer) {
        this.buffer = byteBufferBackedChannelBuffer.buffer;
        this.order = byteBufferBackedChannelBuffer.order;
        this.capacity = byteBufferBackedChannelBuffer.capacity;
        setIndex(byteBufferBackedChannelBuffer.readerIndex(), byteBufferBackedChannelBuffer.writerIndex());
    }

    public void getBytes(int i, byte[] bArr, int i2, int i3) {
        ByteBuffer duplicate = this.buffer.duplicate();
        try {
            duplicate.limit(i + i3).position(i);
            duplicate.get(bArr, i2, i3);
        } catch (IllegalArgumentException unused) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void setBytes(int i, byte[] bArr, int i2, int i3) {
        ByteBuffer duplicate = this.buffer.duplicate();
        duplicate.limit(i + i3).position(i);
        duplicate.put(bArr, i2, i3);
    }

    public void setBytes(int i, ByteBuffer byteBuffer) {
        ByteBuffer duplicate = this.buffer.duplicate();
        duplicate.limit(byteBuffer.remaining() + i).position(i);
        duplicate.put(byteBuffer);
    }

    public void getBytes(int i, ByteBuffer byteBuffer) {
        ByteBuffer duplicate = this.buffer.duplicate();
        try {
            duplicate.limit(Math.min(capacity() - i, byteBuffer.remaining()) + i).position(i);
            byteBuffer.put(duplicate);
        } catch (IllegalArgumentException unused) {
            throw new IndexOutOfBoundsException();
        }
    }

    public int setBytes(int i, InputStream inputStream, int i2) throws IOException {
        int i3 = 0;
        if (this.buffer.hasArray()) {
            int arrayOffset = this.buffer.arrayOffset() + i;
            while (true) {
                int read = inputStream.read(this.buffer.array(), arrayOffset, i2);
                if (read >= 0) {
                    i3 += read;
                    arrayOffset += read;
                    i2 -= read;
                    if (i2 <= 0) {
                        break;
                    }
                } else if (i3 == 0) {
                    return -1;
                }
            }
        } else {
            byte[] bArr = new byte[i2];
            int i4 = 0;
            while (true) {
                int read2 = inputStream.read(bArr, i3, i2 - i3);
                if (read2 >= 0) {
                    i4 += read2;
                    i3 += i4;
                    if (i3 >= i2) {
                        break;
                    }
                } else if (i4 == 0) {
                    return -1;
                }
            }
            i3 = i4;
            ((ByteBuffer) this.buffer.duplicate().position(i)).put(bArr);
        }
        return i3;
    }

    public void getBytes(int i, OutputStream outputStream, int i2) throws IOException {
        if (i2 != 0) {
            if (this.buffer.hasArray()) {
                outputStream.write(this.buffer.array(), this.buffer.arrayOffset() + i, i2);
            } else {
                byte[] bArr = new byte[i2];
                ((ByteBuffer) this.buffer.duplicate().position(i)).get(bArr);
                outputStream.write(bArr);
            }
        }
    }

    public int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) throws IOException {
        int i3;
        ByteBuffer byteBuffer = (ByteBuffer) this.buffer.duplicate().limit(i + i2).position(i);
        int i4 = 0;
        while (i4 < i2) {
            try {
                i3 = scatteringByteChannel.read(byteBuffer);
            } catch (ClosedChannelException unused) {
                i3 = -1;
            }
            if (i3 < 0) {
                if (i4 == 0) {
                    return -1;
                }
                return i4;
            } else if (i3 == 0) {
                break;
            } else {
                i4 += i3;
            }
        }
        return i4;
    }

    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        return gatheringByteChannel.write((ByteBuffer) this.buffer.duplicate().position(i).limit(i + i2));
    }
}
