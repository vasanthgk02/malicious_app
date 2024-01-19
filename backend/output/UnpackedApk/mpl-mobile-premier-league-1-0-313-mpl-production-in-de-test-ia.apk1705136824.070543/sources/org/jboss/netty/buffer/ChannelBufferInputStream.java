package org.jboss.netty.buffer;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class ChannelBufferInputStream extends InputStream implements DataInput {
    public final ChannelBuffer buffer;
    public final int endIndex;
    public final StringBuilder lineBuf;
    public final int startIndex;

    public ChannelBufferInputStream(ChannelBuffer channelBuffer) {
        this(channelBuffer, channelBuffer.readableBytes());
    }

    private void checkAvailable(int i) throws IOException {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i > available()) {
            throw new EOFException();
        }
    }

    public int available() throws IOException {
        return this.endIndex - this.buffer.readerIndex();
    }

    public void mark(int i) {
        this.buffer.markReaderIndex();
    }

    public boolean markSupported() {
        return true;
    }

    public int read() throws IOException {
        if (!this.buffer.readable()) {
            return -1;
        }
        return this.buffer.readByte() & 255;
    }

    public boolean readBoolean() throws IOException {
        checkAvailable(1);
        if (read() != 0) {
            return true;
        }
        return false;
    }

    public byte readByte() throws IOException {
        if (this.buffer.readable()) {
            return this.buffer.readByte();
        }
        throw new EOFException();
    }

    public int readBytes() {
        return this.buffer.readerIndex() - this.startIndex;
    }

    public char readChar() throws IOException {
        return (char) readShort();
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    public void readFully(byte[] bArr) throws IOException {
        readFully(bArr, 0, bArr.length);
    }

    public int readInt() throws IOException {
        checkAvailable(4);
        return this.buffer.readInt();
    }

    public String readLine() throws IOException {
        this.lineBuf.setLength(0);
        while (true) {
            int read = read();
            if (read >= 0 && read != 10) {
                this.lineBuf.append((char) read);
            }
        }
        while (true) {
            StringBuilder sb = this.lineBuf;
            if (sb.charAt(sb.length() - 1) != 13) {
                return this.lineBuf.toString();
            }
            StringBuilder sb2 = this.lineBuf;
            sb2.setLength(sb2.length() - 1);
        }
    }

    public long readLong() throws IOException {
        checkAvailable(8);
        return this.buffer.readLong();
    }

    public short readShort() throws IOException {
        checkAvailable(2);
        return this.buffer.readShort();
    }

    public String readUTF() throws IOException {
        return DataInputStream.readUTF(this);
    }

    public int readUnsignedByte() throws IOException {
        return readByte() & 255;
    }

    public int readUnsignedShort() throws IOException {
        return readShort() & 65535;
    }

    public void reset() throws IOException {
        this.buffer.resetReaderIndex();
    }

    public long skip(long j) throws IOException {
        int skipBytes;
        if (j > 2147483647L) {
            skipBytes = skipBytes(Integer.MAX_VALUE);
        } else {
            skipBytes = skipBytes((int) j);
        }
        return (long) skipBytes;
    }

    public int skipBytes(int i) throws IOException {
        int min = Math.min(available(), i);
        this.buffer.skipBytes(min);
        return min;
    }

    public ChannelBufferInputStream(ChannelBuffer channelBuffer, int i) {
        this.lineBuf = new StringBuilder();
        if (channelBuffer == null) {
            throw new NullPointerException("buffer");
        } else if (i < 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("length: ", i));
        } else if (i <= channelBuffer.readableBytes()) {
            this.buffer = channelBuffer;
            int readerIndex = channelBuffer.readerIndex();
            this.startIndex = readerIndex;
            this.endIndex = readerIndex + i;
            channelBuffer.markReaderIndex();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        checkAvailable(i2);
        this.buffer.readBytes(bArr, i, i2);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int available = available();
        if (available == 0) {
            return -1;
        }
        int min = Math.min(available, i2);
        this.buffer.readBytes(bArr, i, min);
        return min;
    }
}
