package com.badlogic.gdx.graphics.glutils;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class VertexBufferObject implements VertexData {
    public VertexAttributes attributes;
    public FloatBuffer buffer;
    public int bufferHandle;
    public ByteBuffer byteBuffer;
    public boolean isBound;
    public boolean isDirty;
    public boolean ownsBuffer;
    public int usage;

    public VertexBufferObject(boolean z, int i, VertexAttribute... vertexAttributeArr) {
        this(z, i, new VertexAttributes(vertexAttributeArr));
    }

    private void bufferChanged() {
        if (this.isBound) {
            k.gl20.glBufferData(GL20.GL_ARRAY_BUFFER, this.byteBuffer.limit(), this.byteBuffer, this.usage);
            this.isDirty = false;
        }
    }

    public void bind(ShaderProgram shaderProgram) {
        bind(shaderProgram, null);
    }

    public void dispose() {
        GL20 gl20 = k.gl20;
        gl20.glBindBuffer(GL20.GL_ARRAY_BUFFER, 0);
        gl20.glDeleteBuffer(this.bufferHandle);
        this.bufferHandle = 0;
        if (this.ownsBuffer) {
            BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer);
        }
    }

    public VertexAttributes getAttributes() {
        return this.attributes;
    }

    public FloatBuffer getBuffer() {
        this.isDirty = true;
        return this.buffer;
    }

    public int getNumMaxVertices() {
        return this.byteBuffer.capacity() / this.attributes.vertexSize;
    }

    public int getNumVertices() {
        return (this.buffer.limit() * 4) / this.attributes.vertexSize;
    }

    public int getUsage() {
        return this.usage;
    }

    public void invalidate() {
        this.bufferHandle = k.gl20.glGenBuffer();
        this.isDirty = true;
    }

    public void setBuffer(Buffer buffer2, boolean z, VertexAttributes vertexAttributes) {
        if (!this.isBound) {
            if (this.ownsBuffer) {
                ByteBuffer byteBuffer2 = this.byteBuffer;
                if (byteBuffer2 != null) {
                    BufferUtils.disposeUnsafeByteBuffer(byteBuffer2);
                }
            }
            this.attributes = vertexAttributes;
            if (buffer2 instanceof ByteBuffer) {
                ByteBuffer byteBuffer3 = (ByteBuffer) buffer2;
                this.byteBuffer = byteBuffer3;
                this.ownsBuffer = z;
                int limit = byteBuffer3.limit();
                ByteBuffer byteBuffer4 = this.byteBuffer;
                byteBuffer4.limit(byteBuffer4.capacity());
                this.buffer = this.byteBuffer.asFloatBuffer();
                this.byteBuffer.limit(limit);
                this.buffer.limit(limit / 4);
                return;
            }
            throw new GdxRuntimeException((String) "Only ByteBuffer is currently supported");
        }
        throw new GdxRuntimeException((String) "Cannot change attributes while VBO is bound");
    }

    public void setUsage(int i) {
        if (!this.isBound) {
            this.usage = i;
            return;
        }
        throw new GdxRuntimeException((String) "Cannot change usage while VBO is bound");
    }

    public void setVertices(float[] fArr, int i, int i2) {
        this.isDirty = true;
        BufferUtils.copy(fArr, (Buffer) this.byteBuffer, i2, i);
        this.buffer.position(0);
        this.buffer.limit(i2);
        bufferChanged();
    }

    public void unbind(ShaderProgram shaderProgram) {
        unbind(shaderProgram, null);
    }

    public void updateVertices(int i, float[] fArr, int i2, int i3) {
        this.isDirty = true;
        int position = this.byteBuffer.position();
        this.byteBuffer.position(i * 4);
        BufferUtils.copy(fArr, i2, i3, (Buffer) this.byteBuffer);
        this.byteBuffer.position(position);
        this.buffer.position(0);
        bufferChanged();
    }

    public VertexBufferObject(boolean z, int i, VertexAttributes vertexAttributes) {
        this.isDirty = false;
        this.isBound = false;
        this.bufferHandle = k.gl20.glGenBuffer();
        ByteBuffer newUnsafeByteBuffer = BufferUtils.newUnsafeByteBuffer(vertexAttributes.vertexSize * i);
        newUnsafeByteBuffer.limit(0);
        setBuffer(newUnsafeByteBuffer, true, vertexAttributes);
        setUsage(z ? GL20.GL_STATIC_DRAW : GL20.GL_DYNAMIC_DRAW);
    }

    public void bind(ShaderProgram shaderProgram, int[] iArr) {
        GL20 gl20 = k.gl20;
        gl20.glBindBuffer(GL20.GL_ARRAY_BUFFER, this.bufferHandle);
        int i = 0;
        if (this.isDirty) {
            this.byteBuffer.limit(this.buffer.limit() * 4);
            gl20.glBufferData(GL20.GL_ARRAY_BUFFER, this.byteBuffer.limit(), this.byteBuffer, this.usage);
            this.isDirty = false;
        }
        int size = this.attributes.size();
        if (iArr == null) {
            while (i < size) {
                VertexAttribute vertexAttribute = this.attributes.get(i);
                int attributeLocation = shaderProgram.getAttributeLocation(vertexAttribute.alias);
                if (attributeLocation >= 0) {
                    shaderProgram.enableVertexAttribute(attributeLocation);
                    shaderProgram.setVertexAttribute(attributeLocation, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, vertexAttribute.offset);
                }
                i++;
            }
        } else {
            while (i < size) {
                VertexAttribute vertexAttribute2 = this.attributes.get(i);
                int i2 = iArr[i];
                if (i2 >= 0) {
                    shaderProgram.enableVertexAttribute(i2);
                    shaderProgram.setVertexAttribute(i2, vertexAttribute2.numComponents, vertexAttribute2.type, vertexAttribute2.normalized, this.attributes.vertexSize, vertexAttribute2.offset);
                }
                i++;
            }
        }
        this.isBound = true;
    }

    public void unbind(ShaderProgram shaderProgram, int[] iArr) {
        GL20 gl20 = k.gl20;
        int size = this.attributes.size();
        if (iArr == null) {
            for (int i = 0; i < size; i++) {
                shaderProgram.disableVertexAttribute(this.attributes.get(i).alias);
            }
        } else {
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = iArr[i2];
                if (i3 >= 0) {
                    shaderProgram.disableVertexAttribute(i3);
                }
            }
        }
        gl20.glBindBuffer(GL20.GL_ARRAY_BUFFER, 0);
        this.isBound = false;
    }

    public VertexBufferObject(int i, ByteBuffer byteBuffer2, boolean z, VertexAttributes vertexAttributes) {
        this.isDirty = false;
        this.isBound = false;
        this.bufferHandle = k.gl20.glGenBuffer();
        setBuffer(byteBuffer2, z, vertexAttributes);
        setUsage(i);
    }
}
