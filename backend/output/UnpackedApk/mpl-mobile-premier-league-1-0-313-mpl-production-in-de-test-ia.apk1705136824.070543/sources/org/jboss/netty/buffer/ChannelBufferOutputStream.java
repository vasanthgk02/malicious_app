package org.jboss.netty.buffer;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ChannelBufferOutputStream extends OutputStream implements DataOutput {
    public final ChannelBuffer buffer;
    public final int startIndex;
    public final DataOutputStream utf8out = new DataOutputStream(this);

    public ChannelBufferOutputStream(ChannelBuffer channelBuffer) {
        if (channelBuffer != null) {
            this.buffer = channelBuffer;
            this.startIndex = channelBuffer.writerIndex();
            return;
        }
        throw new NullPointerException("buffer");
    }

    public ChannelBuffer buffer() {
        return this.buffer;
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i2 != 0) {
            this.buffer.writeBytes(bArr, i, i2);
        }
    }

    public void writeBoolean(boolean z) throws IOException {
        write(z ? 1 : 0);
    }

    public void writeByte(int i) throws IOException {
        write(i);
    }

    public void writeBytes(String str) throws IOException {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            write((int) (byte) str.charAt(i));
        }
    }

    public void writeChar(int i) throws IOException {
        writeShort((short) i);
    }

    public void writeChars(String str) throws IOException {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            writeChar(str.charAt(i));
        }
    }

    public void writeDouble(double d2) throws IOException {
        writeLong(Double.doubleToLongBits(d2));
    }

    public void writeFloat(float f2) throws IOException {
        writeInt(Float.floatToIntBits(f2));
    }

    public void writeInt(int i) throws IOException {
        this.buffer.writeInt(i);
    }

    public void writeLong(long j) throws IOException {
        this.buffer.writeLong(j);
    }

    public void writeShort(int i) throws IOException {
        this.buffer.writeShort((short) i);
    }

    public void writeUTF(String str) throws IOException {
        this.utf8out.writeUTF(str);
    }

    public int writtenBytes() {
        return this.buffer.writerIndex() - this.startIndex;
    }

    public void write(byte[] bArr) throws IOException {
        this.buffer.writeBytes(bArr);
    }

    public void write(int i) throws IOException {
        this.buffer.writeByte((byte) i);
    }
}
