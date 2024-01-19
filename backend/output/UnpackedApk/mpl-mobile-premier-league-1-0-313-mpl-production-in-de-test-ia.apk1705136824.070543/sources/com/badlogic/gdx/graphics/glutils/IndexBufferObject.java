package com.badlogic.gdx.graphics.glutils;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class IndexBufferObject implements IndexData {
    public final ShortBuffer buffer;
    public int bufferHandle;
    public final ByteBuffer byteBuffer;
    public final boolean empty;
    public boolean isBound;
    public final boolean isDirect;
    public boolean isDirty;
    public final boolean ownsBuffer;
    public final int usage;

    public IndexBufferObject(int i) {
        this(true, i);
    }

    public void bind() {
        int i = this.bufferHandle;
        if (i != 0) {
            k.gl20.glBindBuffer(GL20.GL_ELEMENT_ARRAY_BUFFER, i);
            if (this.isDirty) {
                this.byteBuffer.limit(this.buffer.limit() * 2);
                k.gl20.glBufferData(GL20.GL_ELEMENT_ARRAY_BUFFER, this.byteBuffer.limit(), this.byteBuffer, this.usage);
                this.isDirty = false;
            }
            this.isBound = true;
            return;
        }
        throw new GdxRuntimeException((String) "No buffer allocated!");
    }

    public void dispose() {
        k.gl20.glBindBuffer(GL20.GL_ELEMENT_ARRAY_BUFFER, 0);
        k.gl20.glDeleteBuffer(this.bufferHandle);
        this.bufferHandle = 0;
        if (this.ownsBuffer) {
            BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer);
        }
    }

    public ShortBuffer getBuffer() {
        this.isDirty = true;
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
        this.bufferHandle = k.gl20.glGenBuffer();
        this.isDirty = true;
    }

    public void setIndices(short[] sArr, int i, int i2) {
        this.isDirty = true;
        this.buffer.clear();
        this.buffer.put(sArr, i, i2);
        this.buffer.flip();
        this.byteBuffer.position(0);
        this.byteBuffer.limit(i2 << 1);
        if (this.isBound) {
            k.gl20.glBufferData(GL20.GL_ELEMENT_ARRAY_BUFFER, this.byteBuffer.limit(), this.byteBuffer, this.usage);
            this.isDirty = false;
        }
    }

    public void unbind() {
        k.gl20.glBindBuffer(GL20.GL_ELEMENT_ARRAY_BUFFER, 0);
        this.isBound = false;
    }

    public void updateIndices(int i, short[] sArr, int i2, int i3) {
        this.isDirty = true;
        int position = this.byteBuffer.position();
        this.byteBuffer.position(i * 2);
        BufferUtils.copy(sArr, i2, (Buffer) this.byteBuffer, i3);
        this.byteBuffer.position(position);
        this.buffer.position(0);
        if (this.isBound) {
            k.gl20.glBufferData(GL20.GL_ELEMENT_ARRAY_BUFFER, this.byteBuffer.limit(), this.byteBuffer, this.usage);
            this.isDirty = false;
        }
    }

    public IndexBufferObject(boolean z, int i) {
        this.isDirty = true;
        boolean z2 = false;
        this.isBound = false;
        z2 = i == 0 ? true : z2;
        this.empty = z2;
        ByteBuffer newUnsafeByteBuffer = BufferUtils.newUnsafeByteBuffer((z2 ? 1 : i) * 2);
        this.byteBuffer = newUnsafeByteBuffer;
        this.isDirect = true;
        ShortBuffer asShortBuffer = newUnsafeByteBuffer.asShortBuffer();
        this.buffer = asShortBuffer;
        this.ownsBuffer = true;
        asShortBuffer.flip();
        this.byteBuffer.flip();
        this.bufferHandle = k.gl20.glGenBuffer();
        this.usage = z ? GL20.GL_STATIC_DRAW : GL20.GL_DYNAMIC_DRAW;
    }

    public void setIndices(ShortBuffer shortBuffer) {
        this.isDirty = true;
        int position = shortBuffer.position();
        this.buffer.clear();
        this.buffer.put(shortBuffer);
        this.buffer.flip();
        shortBuffer.position(position);
        this.byteBuffer.position(0);
        this.byteBuffer.limit(this.buffer.limit() << 1);
        if (this.isBound) {
            k.gl20.glBufferData(GL20.GL_ELEMENT_ARRAY_BUFFER, this.byteBuffer.limit(), this.byteBuffer, this.usage);
            this.isDirty = false;
        }
    }

    public IndexBufferObject(boolean z, ByteBuffer byteBuffer2) {
        this.isDirty = true;
        this.isBound = false;
        this.empty = byteBuffer2.limit() == 0;
        this.byteBuffer = byteBuffer2;
        this.isDirect = true;
        this.buffer = byteBuffer2.asShortBuffer();
        this.ownsBuffer = false;
        this.bufferHandle = k.gl20.glGenBuffer();
        this.usage = z ? GL20.GL_STATIC_DRAW : GL20.GL_DYNAMIC_DRAW;
    }
}
