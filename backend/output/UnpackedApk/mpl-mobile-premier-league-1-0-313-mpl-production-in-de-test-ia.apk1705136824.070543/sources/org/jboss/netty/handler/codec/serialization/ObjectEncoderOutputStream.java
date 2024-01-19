package org.jboss.netty.handler.codec.serialization;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.OutputStream;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferOutputStream;
import org.jboss.netty.buffer.ChannelBuffers;

public class ObjectEncoderOutputStream extends OutputStream implements ObjectOutput {
    public final int estimatedLength;
    public final DataOutputStream out;

    public ObjectEncoderOutputStream(OutputStream outputStream) {
        this(outputStream, 512);
    }

    public void close() throws IOException {
        this.out.close();
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public final int size() {
        return this.out.size();
    }

    public void write(int i) throws IOException {
        this.out.write(i);
    }

    public final void writeBoolean(boolean z) throws IOException {
        this.out.writeBoolean(z);
    }

    public final void writeByte(int i) throws IOException {
        this.out.writeByte(i);
    }

    public final void writeBytes(String str) throws IOException {
        this.out.writeBytes(str);
    }

    public final void writeChar(int i) throws IOException {
        this.out.writeChar(i);
    }

    public final void writeChars(String str) throws IOException {
        this.out.writeChars(str);
    }

    public final void writeDouble(double d2) throws IOException {
        this.out.writeDouble(d2);
    }

    public final void writeFloat(float f2) throws IOException {
        this.out.writeFloat(f2);
    }

    public final void writeInt(int i) throws IOException {
        this.out.writeInt(i);
    }

    public final void writeLong(long j) throws IOException {
        this.out.writeLong(j);
    }

    public void writeObject(Object obj) throws IOException {
        ChannelBufferOutputStream channelBufferOutputStream = new ChannelBufferOutputStream(ChannelBuffers.dynamicBuffer(this.estimatedLength));
        CompactObjectOutputStream compactObjectOutputStream = new CompactObjectOutputStream(channelBufferOutputStream);
        compactObjectOutputStream.writeObject(obj);
        compactObjectOutputStream.flush();
        compactObjectOutputStream.close();
        ChannelBuffer buffer = channelBufferOutputStream.buffer();
        int readableBytes = buffer.readableBytes();
        writeInt(readableBytes);
        buffer.getBytes(0, (OutputStream) this, readableBytes);
    }

    public final void writeShort(int i) throws IOException {
        this.out.writeShort(i);
    }

    public final void writeUTF(String str) throws IOException {
        this.out.writeUTF(str);
    }

    public ObjectEncoderOutputStream(OutputStream outputStream, int i) {
        if (outputStream == null) {
            throw new NullPointerException("out");
        } else if (i >= 0) {
            if (outputStream instanceof DataOutputStream) {
                this.out = (DataOutputStream) outputStream;
            } else {
                this.out = new DataOutputStream(outputStream);
            }
            this.estimatedLength = i;
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("estimatedLength: ", i));
        }
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
    }

    public void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
    }
}
