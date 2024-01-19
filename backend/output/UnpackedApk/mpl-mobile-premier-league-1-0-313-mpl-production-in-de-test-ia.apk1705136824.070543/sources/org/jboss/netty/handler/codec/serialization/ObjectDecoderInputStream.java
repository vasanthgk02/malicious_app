package org.jboss.netty.handler.codec.serialization;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.StreamCorruptedException;

public class ObjectDecoderInputStream extends InputStream implements ObjectInput {
    public final ClassLoader classLoader;

    /* renamed from: in  reason: collision with root package name */
    public final DataInputStream f6168in;
    public final int maxObjectSize;

    public ObjectDecoderInputStream(InputStream inputStream) {
        this(inputStream, (ClassLoader) null);
    }

    public int available() throws IOException {
        return this.f6168in.available();
    }

    public void close() throws IOException {
        this.f6168in.close();
    }

    public void mark(int i) {
        this.f6168in.mark(i);
    }

    public boolean markSupported() {
        return this.f6168in.markSupported();
    }

    public int read() throws IOException {
        return this.f6168in.read();
    }

    public final boolean readBoolean() throws IOException {
        return this.f6168in.readBoolean();
    }

    public final byte readByte() throws IOException {
        return this.f6168in.readByte();
    }

    public final char readChar() throws IOException {
        return this.f6168in.readChar();
    }

    public final double readDouble() throws IOException {
        return this.f6168in.readDouble();
    }

    public final float readFloat() throws IOException {
        return this.f6168in.readFloat();
    }

    public final void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.f6168in.readFully(bArr, i, i2);
    }

    public final int readInt() throws IOException {
        return this.f6168in.readInt();
    }

    @Deprecated
    public final String readLine() throws IOException {
        return this.f6168in.readLine();
    }

    public final long readLong() throws IOException {
        return this.f6168in.readLong();
    }

    public Object readObject() throws ClassNotFoundException, IOException {
        int readInt = readInt();
        if (readInt <= 0) {
            throw new StreamCorruptedException(GeneratedOutlineSupport.outline41("invalid data length: ", readInt));
        } else if (readInt <= this.maxObjectSize) {
            return new CompactObjectInputStream(this.f6168in, this.classLoader).readObject();
        } else {
            throw new StreamCorruptedException(GeneratedOutlineSupport.outline56(GeneratedOutlineSupport.outline74("data length too big: ", readInt, " (max: "), this.maxObjectSize, ')'));
        }
    }

    public final short readShort() throws IOException {
        return this.f6168in.readShort();
    }

    public final String readUTF() throws IOException {
        return this.f6168in.readUTF();
    }

    public final int readUnsignedByte() throws IOException {
        return this.f6168in.readUnsignedByte();
    }

    public final int readUnsignedShort() throws IOException {
        return this.f6168in.readUnsignedShort();
    }

    public void reset() throws IOException {
        this.f6168in.reset();
    }

    public long skip(long j) throws IOException {
        return this.f6168in.skip(j);
    }

    public final int skipBytes(int i) throws IOException {
        return this.f6168in.skipBytes(i);
    }

    public ObjectDecoderInputStream(InputStream inputStream, ClassLoader classLoader2) {
        this(inputStream, classLoader2, 1048576);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        return this.f6168in.read(bArr, i, i2);
    }

    public final void readFully(byte[] bArr) throws IOException {
        this.f6168in.readFully(bArr);
    }

    public ObjectDecoderInputStream(InputStream inputStream, int i) {
        this(inputStream, null, i);
    }

    public final int read(byte[] bArr) throws IOException {
        return this.f6168in.read(bArr);
    }

    public ObjectDecoderInputStream(InputStream inputStream, ClassLoader classLoader2, int i) {
        if (inputStream == null) {
            throw new NullPointerException("in");
        } else if (i > 0) {
            if (inputStream instanceof DataInputStream) {
                this.f6168in = (DataInputStream) inputStream;
            } else {
                this.f6168in = new DataInputStream(inputStream);
            }
            this.classLoader = classLoader2;
            this.maxObjectSize = i;
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("maxObjectSize: ", i));
        }
    }
}
