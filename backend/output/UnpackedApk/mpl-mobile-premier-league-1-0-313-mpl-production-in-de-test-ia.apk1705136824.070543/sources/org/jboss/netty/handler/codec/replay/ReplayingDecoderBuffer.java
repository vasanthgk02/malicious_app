package org.jboss.netty.handler.codec.replay;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferFactory;
import org.jboss.netty.buffer.ChannelBufferIndexFinder;

public class ReplayingDecoderBuffer implements ChannelBuffer {
    public static final Error REPLAY = new ReplayError();
    public final ChannelBuffer buffer;
    public boolean terminated;

    public ReplayingDecoderBuffer(ChannelBuffer channelBuffer) {
        this.buffer = channelBuffer;
    }

    private void checkIndex(int i) {
        if (i > this.buffer.writerIndex()) {
            throw REPLAY;
        }
    }

    private void checkReadableBytes(int i) {
        if (this.buffer.readableBytes() < i) {
            throw REPLAY;
        }
    }

    public byte[] array() {
        throw new UnsupportedOperationException();
    }

    public int arrayOffset() {
        throw new UnsupportedOperationException();
    }

    public int bytesBefore(byte b2) {
        int bytesBefore = this.buffer.bytesBefore(b2);
        if (bytesBefore >= 0) {
            return bytesBefore;
        }
        throw REPLAY;
    }

    public int capacity() {
        if (this.terminated) {
            return this.buffer.capacity();
        }
        return Integer.MAX_VALUE;
    }

    public void clear() {
        throw new UnreplayableOperationException();
    }

    public ChannelBuffer copy() {
        throw new UnreplayableOperationException();
    }

    public void discardReadBytes() {
        throw new UnreplayableOperationException();
    }

    public ChannelBuffer duplicate() {
        throw new UnreplayableOperationException();
    }

    public void ensureWritableBytes(int i) {
        throw new UnreplayableOperationException();
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public ChannelBufferFactory factory() {
        return this.buffer.factory();
    }

    public byte getByte(int i) {
        checkIndex(i);
        return this.buffer.getByte(i);
    }

    public void getBytes(int i, byte[] bArr, int i2, int i3) {
        checkIndex(i, i3);
        this.buffer.getBytes(i, bArr, i2, i3);
    }

    public char getChar(int i) {
        checkIndex(i, 2);
        return this.buffer.getChar(i);
    }

    public double getDouble(int i) {
        checkIndex(i, 8);
        return this.buffer.getDouble(i);
    }

    public float getFloat(int i) {
        checkIndex(i, 4);
        return this.buffer.getFloat(i);
    }

    public int getInt(int i) {
        checkIndex(i, 4);
        return this.buffer.getInt(i);
    }

    public long getLong(int i) {
        checkIndex(i, 8);
        return this.buffer.getLong(i);
    }

    public int getMedium(int i) {
        checkIndex(i, 3);
        return this.buffer.getMedium(i);
    }

    public short getShort(int i) {
        checkIndex(i, 2);
        return this.buffer.getShort(i);
    }

    public short getUnsignedByte(int i) {
        checkIndex(i);
        return this.buffer.getUnsignedByte(i);
    }

    public long getUnsignedInt(int i) {
        checkIndex(i, 4);
        return this.buffer.getUnsignedInt(i);
    }

    public int getUnsignedMedium(int i) {
        checkIndex(i, 3);
        return this.buffer.getUnsignedMedium(i);
    }

    public int getUnsignedShort(int i) {
        checkIndex(i, 2);
        return this.buffer.getUnsignedShort(i);
    }

    public boolean hasArray() {
        return false;
    }

    public int hashCode() {
        throw new UnreplayableOperationException();
    }

    public int indexOf(int i, int i2, byte b2) {
        int indexOf = this.buffer.indexOf(i, i2, b2);
        if (indexOf >= 0) {
            return indexOf;
        }
        throw REPLAY;
    }

    public boolean isDirect() {
        return this.buffer.isDirect();
    }

    public void markReaderIndex() {
        this.buffer.markReaderIndex();
    }

    public void markWriterIndex() {
        throw new UnreplayableOperationException();
    }

    public ByteOrder order() {
        return this.buffer.order();
    }

    public byte readByte() {
        checkReadableBytes(1);
        return this.buffer.readByte();
    }

    public void readBytes(byte[] bArr, int i, int i2) {
        checkReadableBytes(i2);
        this.buffer.readBytes(bArr, i, i2);
    }

    public char readChar() {
        checkReadableBytes(2);
        return this.buffer.readChar();
    }

    public double readDouble() {
        checkReadableBytes(8);
        return this.buffer.readDouble();
    }

    public float readFloat() {
        checkReadableBytes(4);
        return this.buffer.readFloat();
    }

    public int readInt() {
        checkReadableBytes(4);
        return this.buffer.readInt();
    }

    public long readLong() {
        checkReadableBytes(8);
        return this.buffer.readLong();
    }

    public int readMedium() {
        checkReadableBytes(3);
        return this.buffer.readMedium();
    }

    public short readShort() {
        checkReadableBytes(2);
        return this.buffer.readShort();
    }

    @Deprecated
    public ChannelBuffer readSlice(ChannelBufferIndexFinder channelBufferIndexFinder) {
        ChannelBuffer channelBuffer = this.buffer;
        int indexOf = channelBuffer.indexOf(channelBuffer.readerIndex(), this.buffer.writerIndex(), channelBufferIndexFinder);
        if (indexOf >= 0) {
            ChannelBuffer channelBuffer2 = this.buffer;
            return channelBuffer2.readSlice(indexOf - channelBuffer2.readerIndex());
        }
        throw REPLAY;
    }

    public short readUnsignedByte() {
        checkReadableBytes(1);
        return this.buffer.readUnsignedByte();
    }

    public long readUnsignedInt() {
        checkReadableBytes(4);
        return this.buffer.readUnsignedInt();
    }

    public int readUnsignedMedium() {
        checkReadableBytes(3);
        return this.buffer.readUnsignedMedium();
    }

    public int readUnsignedShort() {
        checkReadableBytes(2);
        return this.buffer.readUnsignedShort();
    }

    public boolean readable() {
        if (this.terminated) {
            return this.buffer.readable();
        }
        return true;
    }

    public int readableBytes() {
        if (this.terminated) {
            return this.buffer.readableBytes();
        }
        return Integer.MAX_VALUE - this.buffer.readerIndex();
    }

    public int readerIndex() {
        return this.buffer.readerIndex();
    }

    public void resetReaderIndex() {
        this.buffer.resetReaderIndex();
    }

    public void resetWriterIndex() {
        throw new UnreplayableOperationException();
    }

    public void setByte(int i, int i2) {
        throw new UnreplayableOperationException();
    }

    public void setBytes(int i, byte[] bArr, int i2, int i3) {
        throw new UnreplayableOperationException();
    }

    public void setChar(int i, int i2) {
        throw new UnreplayableOperationException();
    }

    public void setDouble(int i, double d2) {
        throw new UnreplayableOperationException();
    }

    public void setFloat(int i, float f2) {
        throw new UnreplayableOperationException();
    }

    public void setIndex(int i, int i2) {
        throw new UnreplayableOperationException();
    }

    public void setInt(int i, int i2) {
        throw new UnreplayableOperationException();
    }

    public void setLong(int i, long j) {
        throw new UnreplayableOperationException();
    }

    public void setMedium(int i, int i2) {
        throw new UnreplayableOperationException();
    }

    public void setShort(int i, int i2) {
        throw new UnreplayableOperationException();
    }

    public void setZero(int i, int i2) {
        throw new UnreplayableOperationException();
    }

    @Deprecated
    public int skipBytes(ChannelBufferIndexFinder channelBufferIndexFinder) {
        int readerIndex = this.buffer.readerIndex();
        ChannelBuffer channelBuffer = this.buffer;
        int indexOf = channelBuffer.indexOf(readerIndex, channelBuffer.writerIndex(), channelBufferIndexFinder);
        if (indexOf >= 0) {
            this.buffer.readerIndex(indexOf);
            return indexOf - readerIndex;
        }
        throw REPLAY;
    }

    public ChannelBuffer slice() {
        throw new UnreplayableOperationException();
    }

    public void terminate() {
        this.terminated = true;
    }

    public ByteBuffer toByteBuffer() {
        throw new UnreplayableOperationException();
    }

    public ByteBuffer[] toByteBuffers() {
        throw new UnreplayableOperationException();
    }

    public String toString(int i, int i2, Charset charset) {
        checkIndex(i, i2);
        return this.buffer.toString(i, i2, charset);
    }

    public boolean writable() {
        return false;
    }

    public int writableBytes() {
        return 0;
    }

    public void writeByte(int i) {
        throw new UnreplayableOperationException();
    }

    public void writeBytes(byte[] bArr, int i, int i2) {
        throw new UnreplayableOperationException();
    }

    public void writeChar(int i) {
        throw new UnreplayableOperationException();
    }

    public void writeDouble(double d2) {
        throw new UnreplayableOperationException();
    }

    public void writeFloat(float f2) {
        throw new UnreplayableOperationException();
    }

    public void writeInt(int i) {
        throw new UnreplayableOperationException();
    }

    public void writeLong(long j) {
        throw new UnreplayableOperationException();
    }

    public void writeMedium(int i) {
        throw new UnreplayableOperationException();
    }

    public void writeShort(int i) {
        throw new UnreplayableOperationException();
    }

    public void writeZero(int i) {
        throw new UnreplayableOperationException();
    }

    public int writerIndex() {
        return this.buffer.writerIndex();
    }

    public int compareTo(ChannelBuffer channelBuffer) {
        throw new UnreplayableOperationException();
    }

    public ChannelBuffer copy(int i, int i2) {
        checkIndex(i, i2);
        return this.buffer.copy(i, i2);
    }

    public void readerIndex(int i) {
        this.buffer.readerIndex(i);
    }

    public void setBytes(int i, byte[] bArr) {
        throw new UnreplayableOperationException();
    }

    public ChannelBuffer slice(int i, int i2) {
        checkIndex(i, i2);
        return this.buffer.slice(i, i2);
    }

    public ByteBuffer toByteBuffer(int i, int i2) {
        checkIndex(i, i2);
        return this.buffer.toByteBuffer(i, i2);
    }

    public ByteBuffer[] toByteBuffers(int i, int i2) {
        checkIndex(i, i2);
        return this.buffer.toByteBuffers(i, i2);
    }

    public void writeBytes(byte[] bArr) {
        throw new UnreplayableOperationException();
    }

    public void writerIndex(int i) {
        throw new UnreplayableOperationException();
    }

    private void checkIndex(int i, int i2) {
        if (i + i2 > this.buffer.writerIndex()) {
            throw REPLAY;
        }
    }

    public int bytesBefore(ChannelBufferIndexFinder channelBufferIndexFinder) {
        int bytesBefore = this.buffer.bytesBefore(channelBufferIndexFinder);
        if (bytesBefore >= 0) {
            return bytesBefore;
        }
        throw REPLAY;
    }

    public void getBytes(int i, byte[] bArr) {
        checkIndex(i, bArr.length);
        this.buffer.getBytes(i, bArr);
    }

    public int indexOf(int i, int i2, ChannelBufferIndexFinder channelBufferIndexFinder) {
        int indexOf = this.buffer.indexOf(i, i2, channelBufferIndexFinder);
        if (indexOf >= 0) {
            return indexOf;
        }
        throw REPLAY;
    }

    public void readBytes(byte[] bArr) {
        checkReadableBytes(bArr.length);
        this.buffer.readBytes(bArr);
    }

    public void setBytes(int i, ByteBuffer byteBuffer) {
        throw new UnreplayableOperationException();
    }

    public String toString(Charset charset) {
        throw new UnreplayableOperationException();
    }

    public void writeBytes(ByteBuffer byteBuffer) {
        throw new UnreplayableOperationException();
    }

    public ChannelBuffer readSlice(int i) {
        checkReadableBytes(i);
        return this.buffer.readSlice(i);
    }

    public void setBytes(int i, ChannelBuffer channelBuffer, int i2, int i3) {
        throw new UnreplayableOperationException();
    }

    @Deprecated
    public String toString(int i, int i2, String str) {
        checkIndex(i, i2);
        return this.buffer.toString(i, i2, str);
    }

    public void writeBytes(ChannelBuffer channelBuffer, int i, int i2) {
        throw new UnreplayableOperationException();
    }

    public int bytesBefore(int i, byte b2) {
        checkReadableBytes(i);
        int bytesBefore = this.buffer.bytesBefore(i, b2);
        if (bytesBefore >= 0) {
            return bytesBefore;
        }
        throw REPLAY;
    }

    public void getBytes(int i, ByteBuffer byteBuffer) {
        throw new UnreplayableOperationException();
    }

    public void readBytes(ByteBuffer byteBuffer) {
        throw new UnreplayableOperationException();
    }

    public void setBytes(int i, ChannelBuffer channelBuffer, int i2) {
        throw new UnreplayableOperationException();
    }

    public void skipBytes(int i) {
        checkReadableBytes(i);
        this.buffer.skipBytes(i);
    }

    public void writeBytes(ChannelBuffer channelBuffer, int i) {
        throw new UnreplayableOperationException();
    }

    public void getBytes(int i, ChannelBuffer channelBuffer, int i2, int i3) {
        checkIndex(i, i3);
        this.buffer.getBytes(i, channelBuffer, i2, i3);
    }

    public void readBytes(ChannelBuffer channelBuffer, int i, int i2) {
        checkReadableBytes(i2);
        this.buffer.readBytes(channelBuffer, i, i2);
    }

    public void setBytes(int i, ChannelBuffer channelBuffer) {
        throw new UnreplayableOperationException();
    }

    @Deprecated
    public String toString(int i, int i2, String str, ChannelBufferIndexFinder channelBufferIndexFinder) {
        checkIndex(i, i2);
        return this.buffer.toString(i, i2, str, channelBufferIndexFinder);
    }

    public void writeBytes(ChannelBuffer channelBuffer) {
        throw new UnreplayableOperationException();
    }

    public int setBytes(int i, InputStream inputStream, int i2) throws IOException {
        throw new UnreplayableOperationException();
    }

    public int writeBytes(InputStream inputStream, int i) throws IOException {
        throw new UnreplayableOperationException();
    }

    public int bytesBefore(int i, ChannelBufferIndexFinder channelBufferIndexFinder) {
        checkReadableBytes(i);
        int bytesBefore = this.buffer.bytesBefore(i, channelBufferIndexFinder);
        if (bytesBefore >= 0) {
            return bytesBefore;
        }
        throw REPLAY;
    }

    public void getBytes(int i, ChannelBuffer channelBuffer, int i2) {
        throw new UnreplayableOperationException();
    }

    public void readBytes(ChannelBuffer channelBuffer, int i) {
        throw new UnreplayableOperationException();
    }

    public int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) throws IOException {
        throw new UnreplayableOperationException();
    }

    @Deprecated
    public String toString(String str) {
        throw new UnreplayableOperationException();
    }

    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i) throws IOException {
        throw new UnreplayableOperationException();
    }

    public void getBytes(int i, ChannelBuffer channelBuffer) {
        throw new UnreplayableOperationException();
    }

    public void readBytes(ChannelBuffer channelBuffer) {
        throw new UnreplayableOperationException();
    }

    @Deprecated
    public String toString(String str, ChannelBufferIndexFinder channelBufferIndexFinder) {
        throw new UnreplayableOperationException();
    }

    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) throws IOException {
        throw new UnreplayableOperationException();
    }

    @Deprecated
    public ChannelBuffer readBytes(ChannelBufferIndexFinder channelBufferIndexFinder) {
        ChannelBuffer channelBuffer = this.buffer;
        int indexOf = channelBuffer.indexOf(channelBuffer.readerIndex(), this.buffer.writerIndex(), channelBufferIndexFinder);
        if (indexOf >= 0) {
            ChannelBuffer channelBuffer2 = this.buffer;
            return channelBuffer2.readBytes(indexOf - channelBuffer2.readerIndex());
        }
        throw REPLAY;
    }

    public String toString() {
        return ReplayingDecoderBuffer.class.getSimpleName() + '(' + "ridx=" + readerIndex() + ", " + "widx=" + writerIndex() + ')';
    }

    public int bytesBefore(int i, int i2, byte b2) {
        int bytesBefore = this.buffer.bytesBefore(i, i2, b2);
        if (bytesBefore >= 0) {
            return bytesBefore;
        }
        throw REPLAY;
    }

    public void getBytes(int i, OutputStream outputStream, int i2) throws IOException {
        throw new UnreplayableOperationException();
    }

    public int bytesBefore(int i, int i2, ChannelBufferIndexFinder channelBufferIndexFinder) {
        int bytesBefore = this.buffer.bytesBefore(i, i2, channelBufferIndexFinder);
        if (bytesBefore >= 0) {
            return bytesBefore;
        }
        throw REPLAY;
    }

    public int readBytes(GatheringByteChannel gatheringByteChannel, int i) throws IOException {
        throw new UnreplayableOperationException();
    }

    public ChannelBuffer readBytes(int i) {
        checkReadableBytes(i);
        return this.buffer.readBytes(i);
    }

    public void readBytes(OutputStream outputStream, int i) throws IOException {
        throw new UnreplayableOperationException();
    }
}
