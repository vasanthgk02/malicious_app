package org.jboss.netty.buffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

public class ReadOnlyChannelBuffer extends AbstractChannelBuffer implements WrappedChannelBuffer {
    public final ChannelBuffer buffer;

    public ReadOnlyChannelBuffer(ChannelBuffer channelBuffer) {
        if (channelBuffer != null) {
            this.buffer = channelBuffer;
            setIndex(channelBuffer.readerIndex(), channelBuffer.writerIndex());
            return;
        }
        throw new NullPointerException("buffer");
    }

    public byte[] array() {
        throw new ReadOnlyBufferException();
    }

    public int arrayOffset() {
        throw new ReadOnlyBufferException();
    }

    public int capacity() {
        return this.buffer.capacity();
    }

    public ChannelBuffer copy(int i, int i2) {
        return this.buffer.copy(i, i2);
    }

    public void discardReadBytes() {
        throw new ReadOnlyBufferException();
    }

    public ChannelBuffer duplicate() {
        return new ReadOnlyChannelBuffer(this);
    }

    public ChannelBufferFactory factory() {
        return this.buffer.factory();
    }

    public byte getByte(int i) {
        return this.buffer.getByte(i);
    }

    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) throws IOException {
        return this.buffer.getBytes(i, gatheringByteChannel, i2);
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
        return this.buffer.getUnsignedMedium(i);
    }

    public boolean hasArray() {
        return false;
    }

    public boolean isDirect() {
        return this.buffer.isDirect();
    }

    public ByteOrder order() {
        return this.buffer.order();
    }

    public void setByte(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    public void setBytes(int i, ChannelBuffer channelBuffer, int i2, int i3) {
        throw new ReadOnlyBufferException();
    }

    public void setInt(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    public void setLong(int i, long j) {
        throw new ReadOnlyBufferException();
    }

    public void setMedium(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    public void setShort(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    public ChannelBuffer slice(int i, int i2) {
        return new ReadOnlyChannelBuffer(this.buffer.slice(i, i2));
    }

    public ByteBuffer toByteBuffer(int i, int i2) {
        return this.buffer.toByteBuffer(i, i2).asReadOnlyBuffer();
    }

    public ByteBuffer[] toByteBuffers(int i, int i2) {
        ByteBuffer[] byteBuffers = this.buffer.toByteBuffers(i, i2);
        for (int i3 = 0; i3 < byteBuffers.length; i3++) {
            byteBuffers[i3] = byteBuffers[i3].asReadOnlyBuffer();
        }
        return byteBuffers;
    }

    public ChannelBuffer unwrap() {
        return this.buffer;
    }

    public void getBytes(int i, OutputStream outputStream, int i2) throws IOException {
        this.buffer.getBytes(i, outputStream, i2);
    }

    public void setBytes(int i, byte[] bArr, int i2, int i3) {
        throw new ReadOnlyBufferException();
    }

    public void getBytes(int i, byte[] bArr, int i2, int i3) {
        this.buffer.getBytes(i, bArr, i2, i3);
    }

    public void setBytes(int i, ByteBuffer byteBuffer) {
        throw new ReadOnlyBufferException();
    }

    public void getBytes(int i, ChannelBuffer channelBuffer, int i2, int i3) {
        this.buffer.getBytes(i, channelBuffer, i2, i3);
    }

    public int setBytes(int i, InputStream inputStream, int i2) throws IOException {
        throw new ReadOnlyBufferException();
    }

    public ReadOnlyChannelBuffer(ReadOnlyChannelBuffer readOnlyChannelBuffer) {
        this.buffer = readOnlyChannelBuffer.buffer;
        setIndex(readOnlyChannelBuffer.readerIndex(), readOnlyChannelBuffer.writerIndex());
    }

    public void getBytes(int i, ByteBuffer byteBuffer) {
        this.buffer.getBytes(i, byteBuffer);
    }

    public int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) throws IOException {
        throw new ReadOnlyBufferException();
    }
}
