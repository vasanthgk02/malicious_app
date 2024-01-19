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

public class InstanceBufferObjectSubData implements InstanceData {
    public final VertexAttributes attributes;
    public final FloatBuffer buffer;
    public int bufferHandle;
    public final ByteBuffer byteBuffer;
    public boolean isBound;
    public final boolean isDirect;
    public boolean isDirty;
    public final boolean isStatic;
    public final int usage;

    public InstanceBufferObjectSubData(boolean z, int i, VertexAttribute... vertexAttributeArr) {
        this(z, i, new VertexAttributes(vertexAttributeArr));
    }

    private void bufferChanged() {
        if (this.isBound) {
            k.gl20.glBufferData(GL20.GL_ARRAY_BUFFER, this.byteBuffer.limit(), null, this.usage);
            k.gl20.glBufferSubData(GL20.GL_ARRAY_BUFFER, 0, this.byteBuffer.limit(), this.byteBuffer);
            this.isDirty = false;
        }
    }

    private int createBufferObject() {
        int glGenBuffer = k.gl20.glGenBuffer();
        k.gl20.glBindBuffer(GL20.GL_ARRAY_BUFFER, glGenBuffer);
        k.gl20.glBufferData(GL20.GL_ARRAY_BUFFER, this.byteBuffer.capacity(), null, this.usage);
        k.gl20.glBindBuffer(GL20.GL_ARRAY_BUFFER, 0);
        return glGenBuffer;
    }

    public void bind(ShaderProgram shaderProgram) {
        bind(shaderProgram, null);
    }

    public void dispose() {
        GL20 gl20 = k.gl20;
        gl20.glBindBuffer(GL20.GL_ARRAY_BUFFER, 0);
        gl20.glDeleteBuffer(this.bufferHandle);
        this.bufferHandle = 0;
    }

    public VertexAttributes getAttributes() {
        return this.attributes;
    }

    public FloatBuffer getBuffer() {
        this.isDirty = true;
        return this.buffer;
    }

    public int getBufferHandle() {
        return this.bufferHandle;
    }

    public int getNumInstances() {
        return (this.buffer.limit() * 4) / this.attributes.vertexSize;
    }

    public int getNumMaxInstances() {
        return this.byteBuffer.capacity() / this.attributes.vertexSize;
    }

    public void invalidate() {
        this.bufferHandle = createBufferObject();
        this.isDirty = true;
    }

    public void setInstanceData(float[] fArr, int i, int i2) {
        this.isDirty = true;
        if (this.isDirect) {
            BufferUtils.copy(fArr, (Buffer) this.byteBuffer, i2, i);
            this.buffer.position(0);
            this.buffer.limit(i2);
        } else {
            this.buffer.clear();
            this.buffer.put(fArr, i, i2);
            this.buffer.flip();
            this.byteBuffer.position(0);
            this.byteBuffer.limit(this.buffer.limit() << 2);
        }
        bufferChanged();
    }

    public void unbind(ShaderProgram shaderProgram) {
        unbind(shaderProgram, null);
    }

    public void updateInstanceData(int i, float[] fArr, int i2, int i3) {
        this.isDirty = true;
        if (this.isDirect) {
            int position = this.byteBuffer.position();
            this.byteBuffer.position(i * 4);
            BufferUtils.copy(fArr, i2, i3, (Buffer) this.byteBuffer);
            this.byteBuffer.position(position);
            bufferChanged();
            return;
        }
        throw new GdxRuntimeException((String) "Buffer must be allocated direct.");
    }

    public InstanceBufferObjectSubData(boolean z, int i, VertexAttributes vertexAttributes) {
        this.isDirty = false;
        this.isBound = false;
        this.isStatic = z;
        this.attributes = vertexAttributes;
        this.byteBuffer = BufferUtils.newByteBuffer(vertexAttributes.vertexSize * i);
        this.isDirect = true;
        this.usage = z ? GL20.GL_STATIC_DRAW : GL20.GL_DYNAMIC_DRAW;
        this.buffer = this.byteBuffer.asFloatBuffer();
        this.bufferHandle = createBufferObject();
        this.buffer.flip();
        this.byteBuffer.flip();
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
                    int i2 = attributeLocation + vertexAttribute.unit;
                    shaderProgram.enableVertexAttribute(i2);
                    shaderProgram.setVertexAttribute(i2, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, vertexAttribute.offset);
                    k.gl30.glVertexAttribDivisor(i2, 1);
                }
                i++;
            }
        } else {
            while (i < size) {
                VertexAttribute vertexAttribute2 = this.attributes.get(i);
                int i3 = iArr[i];
                if (i3 >= 0) {
                    int i4 = i3 + vertexAttribute2.unit;
                    shaderProgram.enableVertexAttribute(i4);
                    shaderProgram.setVertexAttribute(i4, vertexAttribute2.numComponents, vertexAttribute2.type, vertexAttribute2.normalized, this.attributes.vertexSize, vertexAttribute2.offset);
                    k.gl30.glVertexAttribDivisor(i4, 1);
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
                VertexAttribute vertexAttribute = this.attributes.get(i);
                int attributeLocation = shaderProgram.getAttributeLocation(vertexAttribute.alias);
                if (attributeLocation >= 0) {
                    shaderProgram.disableVertexAttribute(attributeLocation + vertexAttribute.unit);
                }
            }
        } else {
            for (int i2 = 0; i2 < size; i2++) {
                VertexAttribute vertexAttribute2 = this.attributes.get(i2);
                int i3 = iArr[i2];
                if (i3 >= 0) {
                    shaderProgram.enableVertexAttribute(i3 + vertexAttribute2.unit);
                }
            }
        }
        gl20.glBindBuffer(GL20.GL_ARRAY_BUFFER, 0);
        this.isBound = false;
    }

    public void updateInstanceData(int i, FloatBuffer floatBuffer, int i2, int i3) {
        this.isDirty = true;
        if (this.isDirect) {
            int position = this.byteBuffer.position();
            this.byteBuffer.position(i * 4);
            floatBuffer.position(i2 * 4);
            BufferUtils.copy(floatBuffer, this.byteBuffer, i3);
            this.byteBuffer.position(position);
            bufferChanged();
            return;
        }
        throw new GdxRuntimeException((String) "Buffer must be allocated direct.");
    }

    public void setInstanceData(FloatBuffer floatBuffer, int i) {
        this.isDirty = true;
        if (this.isDirect) {
            BufferUtils.copy(floatBuffer, this.byteBuffer, i);
            this.buffer.position(0);
            this.buffer.limit(i);
        } else {
            this.buffer.clear();
            this.buffer.put(floatBuffer);
            this.buffer.flip();
            this.byteBuffer.position(0);
            this.byteBuffer.limit(this.buffer.limit() << 2);
        }
        bufferChanged();
    }
}
