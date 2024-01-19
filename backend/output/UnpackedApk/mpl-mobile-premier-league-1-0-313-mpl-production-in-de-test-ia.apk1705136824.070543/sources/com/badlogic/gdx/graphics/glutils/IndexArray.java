package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.utils.BufferUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class IndexArray implements IndexData {
    public final ShortBuffer buffer;
    public final ByteBuffer byteBuffer;
    public final boolean empty;

    public IndexArray(int i) {
        boolean z = i == 0;
        this.empty = z;
        ByteBuffer newUnsafeByteBuffer = BufferUtils.newUnsafeByteBuffer((z ? 1 : i) * 2);
        this.byteBuffer = newUnsafeByteBuffer;
        ShortBuffer asShortBuffer = newUnsafeByteBuffer.asShortBuffer();
        this.buffer = asShortBuffer;
        asShortBuffer.flip();
        this.byteBuffer.flip();
    }

    public void bind() {
    }

    public void dispose() {
        BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer);
    }

    public ShortBuffer getBuffer() {
        return this.buffer;
    }

    public int getNumIndices() {
        if (this.empty) {
            return 0;
        }
        return this.buffer.limit();
    }

    public int getNumMaxIndices() {
        if (this.empty) {
            return 0;
        }
        return this.buffer.capacity();
    }

    public void invalidate() {
    }

    public void setIndices(short[] sArr, int i, int i2) {
        this.buffer.clear();
        this.buffer.put(sArr, i, i2);
        this.buffer.flip();
        this.byteBuffer.position(0);
        this.byteBuffer.limit(i2 << 1);
    }

    public void unbind() {
    }

    public void updateIndices(int i, short[] sArr, int i2, int i3) {
        int position = this.byteBuffer.position();
        this.byteBuffer.position(i * 2);
        BufferUtils.copy(sArr, i2, (Buffer) this.byteBuffer, i3);
        this.byteBuffer.position(position);
    }

    public void setIndices(ShortBuffer shortBuffer) {
        int position = shortBuffer.position();
        this.buffer.clear();
        this.buffer.limit(shortBuffer.remaining());
        this.buffer.put(shortBuffer);
        this.buffer.flip();
        shortBuffer.position(position);
        this.byteBuffer.position(0);
        this.byteBuffer.limit(this.buffer.limit() << 1);
    }
}
