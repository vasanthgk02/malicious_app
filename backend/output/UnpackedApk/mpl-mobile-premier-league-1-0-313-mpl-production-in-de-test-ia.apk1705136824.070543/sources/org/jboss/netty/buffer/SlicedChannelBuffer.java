package org.jboss.netty.buffer;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

public class SlicedChannelBuffer extends AbstractChannelBuffer implements WrappedChannelBuffer {
    public final int adjustment;
    public final ChannelBuffer buffer;
    public final int length;

    public SlicedChannelBuffer(ChannelBuffer channelBuffer, int i, int i2) {
        if (i < 0 || i > channelBuffer.capacity()) {
            throw new IndexOutOfBoundsException();
        } else if (i + i2 <= channelBuffer.capacity()) {
            this.buffer = channelBuffer;
            this.adjustment = i;
            this.length = i2;
            writerIndex(i2);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkIndex(int i) {
        if (i < 0 || i >= capacity()) {
            throw new IndexOutOfBoundsException();
        }
    }

    public byte[] array() {
        return this.buffer.array();
    }

    public int arrayOffset() {
        return this.buffer.arrayOffset() + this.adjustment;
    }

    public int capacity() {
        return this.length;
    }

    public ChannelBuffer copy(int i, int i2) {
        checkIndex(i, i2);
        return this.buffer.copy(i + this.adjustment, i2);
    }

    public ChannelBuffer duplicate() {
        SlicedChannelBuffer slicedChannelBuffer = new SlicedChannelBuffer(this.buffer, this.adjustment, this.length);
        slicedChannelBuffer.setIndex(readerIndex(), writerIndex());
        return slicedChannelBuffer;
    }

    public ChannelBufferFactory factory() {
        return this.buffer.factory();
    }

    public byte getByte(int i) {
        checkIndex(i);
        return this.buffer.getByte(i + this.adjustment);
    }

    public void getBytes(int i, ChannelBuffer channelBuffer, int i2, int i3) {
        checkIndex(i, i3);
        this.buffer.getBytes(i + this.adjustment, channelBuffer, i2, i3);
    }

    public int getInt(int i) {
        checkIndex(i, 4);
        return this.buffer.getInt(i + this.adjustment);
    }

    public long getLong(int i) {
        checkIndex(i, 8);
        return this.buffer.getLong(i + this.adjustment);
    }

    public short getShort(int i) {
        checkIndex(i, 2);
        return this.buffer.getShort(i + this.adjustment);
    }

    public int getUnsignedMedium(int i) {
        checkIndex(i, 3);
        return this.buffer.getUnsignedMedium(i + this.adjustment);
    }

    public boolean hasArray() {
        return this.buffer.hasArray();
    }

    public boolean isDirect() {
        return this.buffer.isDirect();
    }

    public ByteOrder order() {
        return this.buffer.order();
    }

    public void setByte(int i, int i2) {
        checkIndex(i);
        this.buffer.setByte(i + this.adjustment, i2);
    }

    public void setBytes(int i, byte[] bArr, int i2, int i3) {
        checkIndex(i, i3);
        this.buffer.setBytes(i + this.adjustment, bArr, i2, i3);
    }

    public void setInt(int i, int i2) {
        checkIndex(i, 4);
        this.buffer.setInt(i + this.adjustment, i2);
    }

    public void setLong(int i, long j) {
        checkIndex(i, 8);
        this.buffer.setLong(i + this.adjustment, j);
    }

    public void setMedium(int i, int i2) {
        checkIndex(i, 3);
        this.buffer.setMedium(i + this.adjustment, i2);
    }

    public void setShort(int i, int i2) {
        checkIndex(i, 2);
        this.buffer.setShort(i + this.adjustment, i2);
    }

    public ChannelBuffer slice(int i, int i2) {
        checkIndex(i, i2);
        if (i2 == 0) {
            return ChannelBuffers.EMPTY_BUFFER;
        }
        return new SlicedChannelBuffer(this.buffer, i + this.adjustment, i2);
    }

    public ByteBuffer toByteBuffer(int i, int i2) {
        checkIndex(i, i2);
        return this.buffer.toByteBuffer(i + this.adjustment, i2);
    }

    public ChannelBuffer unwrap() {
        return this.buffer;
    }

    private void checkIndex(int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("length is negative: ", i2));
        } else if (i < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i + i2 > capacity()) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void getBytes(int i, byte[] bArr, int i2, int i3) {
        checkIndex(i, i3);
        this.buffer.getBytes(i + this.adjustment, bArr, i2, i3);
    }

    public void setBytes(int i, ChannelBuffer channelBuffer, int i2, int i3) {
        checkIndex(i, i3);
        this.buffer.setBytes(i + this.adjustment, channelBuffer, i2, i3);
    }

    public void getBytes(int i, ByteBuffer byteBuffer) {
        checkIndex(i, byteBuffer.remaining());
        this.buffer.getBytes(i + this.adjustment, byteBuffer);
    }

    public void setBytes(int i, ByteBuffer byteBuffer) {
        checkIndex(i, byteBuffer.remaining());
        this.buffer.setBytes(i + this.adjustment, byteBuffer);
    }

    public void getBytes(int i, OutputStream outputStream, int i2) throws IOException {
        checkIndex(i, i2);
        this.buffer.getBytes(i + this.adjustment, outputStream, i2);
    }

    public int setBytes(int i, InputStream inputStream, int i2) throws IOException {
        checkIndex(i, i2);
        return this.buffer.setBytes(i + this.adjustment, inputStream, i2);
    }

    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) throws IOException {
        checkIndex(i, i2);
        return this.buffer.getBytes(i + this.adjustment, gatheringByteChannel, i2);
    }

    public int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) throws IOException {
        checkIndex(i, i2);
        return this.buffer.setBytes(i + this.adjustment, scatteringByteChannel, i2);
    }
}
