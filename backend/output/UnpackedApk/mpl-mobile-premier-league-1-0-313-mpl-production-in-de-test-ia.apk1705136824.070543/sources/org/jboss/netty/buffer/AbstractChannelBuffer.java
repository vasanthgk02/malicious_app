package org.jboss.netty.buffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;

public abstract class AbstractChannelBuffer implements ChannelBuffer {
    public int markedReaderIndex;
    public int markedWriterIndex;
    public int readerIndex;
    public int writerIndex;

    public int bytesBefore(byte b2) {
        return bytesBefore(readerIndex(), readableBytes(), b2);
    }

    public void checkReadableBytes(int i) {
        if (readableBytes() < i) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void clear() {
        this.writerIndex = 0;
        this.readerIndex = 0;
    }

    public ChannelBuffer copy() {
        return copy(this.readerIndex, readableBytes());
    }

    public void discardReadBytes() {
        int i = this.readerIndex;
        if (i != 0) {
            setBytes(0, (ChannelBuffer) this, i, this.writerIndex - i);
            int i2 = this.writerIndex;
            int i3 = this.readerIndex;
            this.writerIndex = i2 - i3;
            this.markedReaderIndex = Math.max(this.markedReaderIndex - i3, 0);
            this.markedWriterIndex = Math.max(this.markedWriterIndex - this.readerIndex, 0);
            this.readerIndex = 0;
        }
    }

    public void ensureWritableBytes(int i) {
        if (i > writableBytes()) {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ChannelBuffer)) {
            return false;
        }
        return ChannelBuffers.equals(this, (ChannelBuffer) obj);
    }

    public void getBytes(int i, byte[] bArr) {
        getBytes(i, bArr, 0, bArr.length);
    }

    public char getChar(int i) {
        return (char) getShort(i);
    }

    public double getDouble(int i) {
        return Double.longBitsToDouble(getLong(i));
    }

    public float getFloat(int i) {
        return Float.intBitsToFloat(getInt(i));
    }

    public int getMedium(int i) {
        int unsignedMedium = getUnsignedMedium(i);
        return (8388608 & unsignedMedium) != 0 ? unsignedMedium | -16777216 : unsignedMedium;
    }

    public short getUnsignedByte(int i) {
        return (short) (getByte(i) & 255);
    }

    public long getUnsignedInt(int i) {
        return ((long) getInt(i)) & 4294967295L;
    }

    public int getUnsignedShort(int i) {
        return getShort(i) & 65535;
    }

    public int hashCode() {
        return ChannelBuffers.hashCode(this);
    }

    public int indexOf(int i, int i2, byte b2) {
        return ChannelBuffers.indexOf((ChannelBuffer) this, i, i2, b2);
    }

    public void markReaderIndex() {
        this.markedReaderIndex = this.readerIndex;
    }

    public void markWriterIndex() {
        this.markedWriterIndex = this.writerIndex;
    }

    public byte readByte() {
        int i = this.readerIndex;
        if (i != this.writerIndex) {
            this.readerIndex = i + 1;
            return getByte(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public ChannelBuffer readBytes(int i) {
        checkReadableBytes(i);
        if (i == 0) {
            return ChannelBuffers.EMPTY_BUFFER;
        }
        ChannelBuffer buffer = factory().getBuffer(order(), i);
        buffer.writeBytes((ChannelBuffer) this, this.readerIndex, i);
        this.readerIndex += i;
        return buffer;
    }

    public char readChar() {
        return (char) readShort();
    }

    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    public int readInt() {
        checkReadableBytes(4);
        int i = getInt(this.readerIndex);
        this.readerIndex += 4;
        return i;
    }

    public long readLong() {
        checkReadableBytes(8);
        long j = getLong(this.readerIndex);
        this.readerIndex += 8;
        return j;
    }

    public int readMedium() {
        int readUnsignedMedium = readUnsignedMedium();
        return (8388608 & readUnsignedMedium) != 0 ? readUnsignedMedium | -16777216 : readUnsignedMedium;
    }

    public short readShort() {
        checkReadableBytes(2);
        short s = getShort(this.readerIndex);
        this.readerIndex += 2;
        return s;
    }

    public ChannelBuffer readSlice(int i) {
        ChannelBuffer slice = slice(this.readerIndex, i);
        this.readerIndex += i;
        return slice;
    }

    public short readUnsignedByte() {
        return (short) (readByte() & 255);
    }

    public long readUnsignedInt() {
        return ((long) readInt()) & 4294967295L;
    }

    public int readUnsignedMedium() {
        checkReadableBytes(3);
        int unsignedMedium = getUnsignedMedium(this.readerIndex);
        this.readerIndex += 3;
        return unsignedMedium;
    }

    public int readUnsignedShort() {
        return readShort() & 65535;
    }

    public boolean readable() {
        return readableBytes() > 0;
    }

    public int readableBytes() {
        return this.writerIndex - this.readerIndex;
    }

    public int readerIndex() {
        return this.readerIndex;
    }

    public void resetReaderIndex() {
        readerIndex(this.markedReaderIndex);
    }

    public void resetWriterIndex() {
        this.writerIndex = this.markedWriterIndex;
    }

    public void setBytes(int i, byte[] bArr) {
        setBytes(i, bArr, 0, bArr.length);
    }

    public void setChar(int i, int i2) {
        setShort(i, i2);
    }

    public void setDouble(int i, double d2) {
        setLong(i, Double.doubleToRawLongBits(d2));
    }

    public void setFloat(int i, float f2) {
        setInt(i, Float.floatToRawIntBits(f2));
    }

    public void setIndex(int i, int i2) {
        if (i < 0 || i > i2 || i2 > capacity()) {
            throw new IndexOutOfBoundsException();
        }
        this.readerIndex = i;
        this.writerIndex = i2;
    }

    public void setZero(int i, int i2) {
        if (i2 != 0) {
            if (i2 >= 0) {
                int i3 = i2 & 7;
                for (int i4 = i2 >>> 3; i4 > 0; i4--) {
                    setLong(i, 0);
                    i += 8;
                }
                if (i3 == 4) {
                    setInt(i, 0);
                } else if (i3 < 4) {
                    while (i3 > 0) {
                        setByte(i, 0);
                        i++;
                        i3--;
                    }
                } else {
                    setInt(i, 0);
                    int i5 = i + 4;
                    for (int i6 = i3 - 4; i6 > 0; i6--) {
                        setByte(i5, 0);
                        i5++;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("length must be 0 or greater than 0.");
        }
    }

    public void skipBytes(int i) {
        int i2 = this.readerIndex + i;
        if (i2 <= this.writerIndex) {
            this.readerIndex = i2;
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public ChannelBuffer slice() {
        return slice(this.readerIndex, readableBytes());
    }

    public ByteBuffer toByteBuffer() {
        return toByteBuffer(this.readerIndex, readableBytes());
    }

    public ByteBuffer[] toByteBuffers() {
        return toByteBuffers(this.readerIndex, readableBytes());
    }

    public String toString(Charset charset) {
        return toString(this.readerIndex, readableBytes(), charset);
    }

    public boolean writable() {
        return writableBytes() > 0;
    }

    public int writableBytes() {
        return capacity() - this.writerIndex;
    }

    public void writeByte(int i) {
        int i2 = this.writerIndex;
        this.writerIndex = i2 + 1;
        setByte(i2, i);
    }

    public void writeBytes(byte[] bArr, int i, int i2) {
        setBytes(this.writerIndex, bArr, i, i2);
        this.writerIndex += i2;
    }

    public void writeChar(int i) {
        writeShort(i);
    }

    public void writeDouble(double d2) {
        writeLong(Double.doubleToRawLongBits(d2));
    }

    public void writeFloat(float f2) {
        writeInt(Float.floatToRawIntBits(f2));
    }

    public void writeInt(int i) {
        setInt(this.writerIndex, i);
        this.writerIndex += 4;
    }

    public void writeLong(long j) {
        setLong(this.writerIndex, j);
        this.writerIndex += 8;
    }

    public void writeMedium(int i) {
        setMedium(this.writerIndex, i);
        this.writerIndex += 3;
    }

    public void writeShort(int i) {
        setShort(this.writerIndex, i);
        this.writerIndex += 2;
    }

    public void writeZero(int i) {
        if (i != 0) {
            if (i >= 0) {
                int i2 = i & 7;
                for (int i3 = i >>> 3; i3 > 0; i3--) {
                    writeLong(0);
                }
                if (i2 == 4) {
                    writeInt(0);
                } else if (i2 < 4) {
                    while (i2 > 0) {
                        writeByte(0);
                        i2--;
                    }
                } else {
                    writeInt(0);
                    for (int i4 = i2 - 4; i4 > 0; i4--) {
                        writeByte(0);
                    }
                }
                return;
            }
            throw new IllegalArgumentException("length must be 0 or greater than 0.");
        }
    }

    public int writerIndex() {
        return this.writerIndex;
    }

    public int bytesBefore(ChannelBufferIndexFinder channelBufferIndexFinder) {
        return bytesBefore(readerIndex(), readableBytes(), channelBufferIndexFinder);
    }

    public int compareTo(ChannelBuffer channelBuffer) {
        return ChannelBuffers.compare(this, channelBuffer);
    }

    public void getBytes(int i, ChannelBuffer channelBuffer) {
        getBytes(i, channelBuffer, channelBuffer.writableBytes());
    }

    public int indexOf(int i, int i2, ChannelBufferIndexFinder channelBufferIndexFinder) {
        return ChannelBuffers.indexOf((ChannelBuffer) this, i, i2, channelBufferIndexFinder);
    }

    public void readerIndex(int i) {
        if (i < 0 || i > this.writerIndex) {
            throw new IndexOutOfBoundsException();
        }
        this.readerIndex = i;
    }

    public void setBytes(int i, ChannelBuffer channelBuffer) {
        setBytes(i, channelBuffer, channelBuffer.readableBytes());
    }

    public ByteBuffer[] toByteBuffers(int i, int i2) {
        return new ByteBuffer[]{toByteBuffer(i, i2)};
    }

    public String toString(int i, int i2, Charset charset) {
        return i2 == 0 ? "" : ChannelBuffers.decodeString(toByteBuffer(i, i2), charset);
    }

    public void writerIndex(int i) {
        if (i < this.readerIndex || i > capacity()) {
            throw new IndexOutOfBoundsException();
        }
        this.writerIndex = i;
    }

    public int bytesBefore(int i, byte b2) {
        checkReadableBytes(i);
        return bytesBefore(readerIndex(), i, b2);
    }

    public void getBytes(int i, ChannelBuffer channelBuffer, int i2) {
        if (i2 <= channelBuffer.writableBytes()) {
            getBytes(i, channelBuffer, channelBuffer.writerIndex(), i2);
            channelBuffer.writerIndex(channelBuffer.writerIndex() + i2);
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    @Deprecated
    public ChannelBuffer readSlice(ChannelBufferIndexFinder channelBufferIndexFinder) {
        int indexOf = indexOf(this.readerIndex, this.writerIndex, channelBufferIndexFinder);
        if (indexOf >= 0) {
            return readSlice(indexOf - this.readerIndex);
        }
        throw new NoSuchElementException();
    }

    public void setBytes(int i, ChannelBuffer channelBuffer, int i2) {
        if (i2 <= channelBuffer.readableBytes()) {
            setBytes(i, channelBuffer, channelBuffer.readerIndex(), i2);
            channelBuffer.readerIndex(channelBuffer.readerIndex() + i2);
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    @Deprecated
    public String toString(int i, int i2, String str, ChannelBufferIndexFinder channelBufferIndexFinder) {
        if (channelBufferIndexFinder == null) {
            return toString(i, i2, str);
        }
        int indexOf = indexOf(i, i + i2, channelBufferIndexFinder);
        if (indexOf < 0) {
            return toString(i, i2, str);
        }
        return toString(i, indexOf - i, str);
    }

    public void writeBytes(byte[] bArr) {
        writeBytes(bArr, 0, bArr.length);
    }

    public void writeBytes(ChannelBuffer channelBuffer) {
        writeBytes(channelBuffer, channelBuffer.readableBytes());
    }

    public int bytesBefore(int i, ChannelBufferIndexFinder channelBufferIndexFinder) {
        checkReadableBytes(i);
        return bytesBefore(readerIndex(), i, channelBufferIndexFinder);
    }

    @Deprecated
    public int skipBytes(ChannelBufferIndexFinder channelBufferIndexFinder) {
        int i = this.readerIndex;
        int indexOf = indexOf(i, this.writerIndex, channelBufferIndexFinder);
        if (indexOf >= 0) {
            readerIndex(indexOf);
            return indexOf - i;
        }
        throw new NoSuchElementException();
    }

    public void writeBytes(ChannelBuffer channelBuffer, int i) {
        if (i <= channelBuffer.readableBytes()) {
            writeBytes(channelBuffer, channelBuffer.readerIndex(), i);
            channelBuffer.readerIndex(channelBuffer.readerIndex() + i);
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    @Deprecated
    public ChannelBuffer readBytes(ChannelBufferIndexFinder channelBufferIndexFinder) {
        int indexOf = indexOf(this.readerIndex, this.writerIndex, channelBufferIndexFinder);
        if (indexOf >= 0) {
            return readBytes(indexOf - this.readerIndex);
        }
        throw new NoSuchElementException();
    }

    public int bytesBefore(int i, int i2, byte b2) {
        int indexOf = indexOf(i, i2 + i, b2);
        if (indexOf < 0) {
            return -1;
        }
        return indexOf - i;
    }

    @Deprecated
    public String toString(int i, int i2, String str) {
        return toString(i, i2, Charset.forName(str));
    }

    public int bytesBefore(int i, int i2, ChannelBufferIndexFinder channelBufferIndexFinder) {
        int indexOf = indexOf(i, i2 + i, channelBufferIndexFinder);
        if (indexOf < 0) {
            return -1;
        }
        return indexOf - i;
    }

    @Deprecated
    public String toString(String str, ChannelBufferIndexFinder channelBufferIndexFinder) {
        return toString(this.readerIndex, readableBytes(), str, channelBufferIndexFinder);
    }

    public void readBytes(byte[] bArr, int i, int i2) {
        checkReadableBytes(i2);
        getBytes(this.readerIndex, bArr, i, i2);
        this.readerIndex += i2;
    }

    @Deprecated
    public String toString(String str) {
        return toString(Charset.forName(str));
    }

    public void writeBytes(ChannelBuffer channelBuffer, int i, int i2) {
        setBytes(this.writerIndex, channelBuffer, i, i2);
        this.writerIndex += i2;
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + "ridx=" + this.readerIndex + ", " + "widx=" + this.writerIndex + ", " + "cap=" + capacity() + ')';
    }

    public void writeBytes(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        setBytes(this.writerIndex, byteBuffer);
        this.writerIndex += remaining;
    }

    public void readBytes(byte[] bArr) {
        readBytes(bArr, 0, bArr.length);
    }

    public void readBytes(ChannelBuffer channelBuffer) {
        readBytes(channelBuffer, channelBuffer.writableBytes());
    }

    public void readBytes(ChannelBuffer channelBuffer, int i) {
        if (i <= channelBuffer.writableBytes()) {
            readBytes(channelBuffer, channelBuffer.writerIndex(), i);
            channelBuffer.writerIndex(channelBuffer.writerIndex() + i);
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public int writeBytes(InputStream inputStream, int i) throws IOException {
        int bytes = setBytes(this.writerIndex, inputStream, i);
        if (bytes > 0) {
            this.writerIndex += bytes;
        }
        return bytes;
    }

    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i) throws IOException {
        int bytes = setBytes(this.writerIndex, scatteringByteChannel, i);
        if (bytes > 0) {
            this.writerIndex += bytes;
        }
        return bytes;
    }

    public void readBytes(ChannelBuffer channelBuffer, int i, int i2) {
        checkReadableBytes(i2);
        getBytes(this.readerIndex, channelBuffer, i, i2);
        this.readerIndex += i2;
    }

    public void readBytes(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkReadableBytes(remaining);
        getBytes(this.readerIndex, byteBuffer);
        this.readerIndex += remaining;
    }

    public int readBytes(GatheringByteChannel gatheringByteChannel, int i) throws IOException {
        checkReadableBytes(i);
        int bytes = getBytes(this.readerIndex, gatheringByteChannel, i);
        this.readerIndex += bytes;
        return bytes;
    }

    public void readBytes(OutputStream outputStream, int i) throws IOException {
        checkReadableBytes(i);
        getBytes(this.readerIndex, outputStream, i);
        this.readerIndex += i;
    }
}
