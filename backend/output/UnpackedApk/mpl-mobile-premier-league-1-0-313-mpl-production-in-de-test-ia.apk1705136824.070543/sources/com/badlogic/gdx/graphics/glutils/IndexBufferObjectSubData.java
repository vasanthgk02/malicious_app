package com.badlogic.gdx.graphics.glutils;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class IndexBufferObjectSubData implements IndexData {
    public final ShortBuffer buffer;
    public int bufferHandle;
    public final ByteBuffer byteBuffer;
    public boolean isBound = false;
    public final boolean isDirect;
    public boolean isDirty = true;
    public final int usage;

    public IndexBufferObjectSubData(boolean z, int i) {
        this.byteBuffer = BufferUtils.newByteBuffer(i * 2);
        this.isDirect = true;
        this.usage = z ? GL20.GL_STATIC_DRAW : GL20.GL_DYNAMIC_DRAW;
        ShortBuffer asShortBuffer = this.byteBuffer.asShortBuffer();
        this.buffer = asShortBuffer;
        asShortBuffer.flip();
        this.byteBuffer.flip();
        this.bufferHandle = createBufferObject();
    }

    private int createBufferObject() {
        int glGenBuffer = k.gl20.glGenBuffer();
        k.gl20.glBindBuffer(GL20.GL_ELEMENT_ARRAY_BUFFER, glGenBuffer);
        k.gl20.glBufferData(GL20.GL_ELEMENT_ARRAY_BUFFER, this.byteBuffer.capacity(), null, this.usage);
        k.gl20.glBindBuffer(GL20.GL_ELEMENT_ARRAY_BUFFER, 0);
        return glGenBuffer;
    }

    public void bind() {
        int i = this.bufferHandle;
        if (i != 0) {
            k.gl20.glBindBuffer(GL20.GL_ELEMENT_ARRAY_BUFFER, i);
            if (this.isDirty) {
                this.byteBuffer.limit(this.buffer.limit() * 2);
                k.gl20.glBufferSubData(GL20.GL_ELEMENT_ARRAY_BUFFER, 0, this.byteBuffer.limit(), this.byteBuffer);
                this.isDirty = false;
            }
            this.isBound = true;
            return;
        }
        throw new GdxRuntimeException((String) "IndexBufferObject cannot be used after it has been disposed.");
    }

    public void dispose() {
        GL20 gl20 = k.gl20;
        gl20.glBindBuffer(GL20.GL_ELEMENT_ARRAY_BUFFER, 0);
        gl20.glDeleteBuffer(this.bufferHandle);
        this.bufferHandle = 0;
    }

    public ShortBuffer getBuffer() {
        this.isDirty = true;
        return this.buffer;
    }

    public int getNumIndices() {
        return this.buffer.limit();
    }

    public int getNumMaxIndices() {
        return this.buffer.capacity();
    }

    public void invalidate() {
        this.bufferHandle = createBufferObject();
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
            k.gl20.glBufferSubData(GL20.GL_ELEMENT_ARRAY_BUFFER, 0, this.byteBuffer.limit(), this.byteBuffer);
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
            k.gl20.glBufferSubData(GL20.GL_ELEMENT_ARRAY_BUFFER, 0, this.byteBuffer.limit(), this.byteBuffer);
            this.isDirty = false;
        }
    }

    public void setIndices(ShortBuffer shortBuffer) {
        int position = shortBuffer.position();
        this.isDirty = true;
        this.buffer.clear();
        this.buffer.put(shortBuffer);
        this.buffer.flip();
        shortBuffer.position(position);
        this.byteBuffer.position(0);
        this.byteBuffer.limit(this.buffer.limit() << 1);
        if (this.isBound) {
            k.gl20.glBufferSubData(GL20.GL_ELEMENT_ARRAY_BUFFER, 0, this.byteBuffer.limit(), this.byteBuffer);
            this.isDirty = false;
        }
    }

    public IndexBufferObjectSubData(int i) {
        ByteBuffer newByteBuffer = BufferUtils.newByteBuffer(i * 2);
        this.byteBuffer = newByteBuffer;
        this.isDirect = true;
        this.usage = GL20.GL_STATIC_DRAW;
        ShortBuffer asShortBuffer = newByteBuffer.asShortBuffer();
        this.buffer = asShortBuffer;
        asShortBuffer.flip();
        this.byteBuffer.flip();
        this.bufferHandle = createBufferObject();
    }
}
