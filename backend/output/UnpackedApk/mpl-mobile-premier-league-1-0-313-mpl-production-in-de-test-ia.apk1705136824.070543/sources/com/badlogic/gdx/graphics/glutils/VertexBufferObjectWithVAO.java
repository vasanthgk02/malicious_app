package com.badlogic.gdx.graphics.glutils;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.IntArray;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class VertexBufferObjectWithVAO implements VertexData {
    public static final IntBuffer tmpHandle = BufferUtils.newIntBuffer(1);
    public final VertexAttributes attributes;
    public final FloatBuffer buffer;
    public int bufferHandle;
    public final ByteBuffer byteBuffer;
    public IntArray cachedLocations;
    public boolean isBound;
    public boolean isDirty;
    public final boolean isStatic;
    public final boolean ownsBuffer;
    public final int usage;
    public int vaoHandle;

    public VertexBufferObjectWithVAO(boolean z, int i, VertexAttribute... vertexAttributeArr) {
        this(z, i, new VertexAttributes(vertexAttributeArr));
    }

    private void bindAttributes(ShaderProgram shaderProgram, int[] iArr) {
        boolean z = this.cachedLocations.size != 0;
        int size = this.attributes.size();
        if (z) {
            if (iArr == null) {
                int i = 0;
                while (z && i < size) {
                    z = shaderProgram.getAttributeLocation(this.attributes.get(i).alias) == this.cachedLocations.get(i);
                    i++;
                }
            } else {
                boolean z2 = iArr.length == this.cachedLocations.size;
                int i2 = 0;
                while (z && i2 < size) {
                    z2 = iArr[i2] == this.cachedLocations.get(i2);
                    i2++;
                }
            }
        }
        if (!z) {
            k.gl.glBindBuffer(GL20.GL_ARRAY_BUFFER, this.bufferHandle);
            unbindAttributes(shaderProgram);
            this.cachedLocations.size = 0;
            for (int i3 = 0; i3 < size; i3++) {
                VertexAttribute vertexAttribute = this.attributes.get(i3);
                if (iArr == null) {
                    this.cachedLocations.add(shaderProgram.getAttributeLocation(vertexAttribute.alias));
                } else {
                    this.cachedLocations.add(iArr[i3]);
                }
                int i4 = this.cachedLocations.get(i3);
                if (i4 >= 0) {
                    shaderProgram.enableVertexAttribute(i4);
                    shaderProgram.setVertexAttribute(i4, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, vertexAttribute.offset);
                }
            }
        }
    }

    private void bindData(GL20 gl20) {
        if (this.isDirty) {
            gl20.glBindBuffer(GL20.GL_ARRAY_BUFFER, this.bufferHandle);
            this.byteBuffer.limit(this.buffer.limit() * 4);
            gl20.glBufferData(GL20.GL_ARRAY_BUFFER, this.byteBuffer.limit(), this.byteBuffer, this.usage);
            this.isDirty = false;
        }
    }

    private void bufferChanged() {
        if (this.isBound) {
            k.gl20.glBindBuffer(GL20.GL_ARRAY_BUFFER, this.bufferHandle);
            k.gl20.glBufferData(GL20.GL_ARRAY_BUFFER, this.byteBuffer.limit(), this.byteBuffer, this.usage);
            this.isDirty = false;
        }
    }

    private void createVAO() {
        tmpHandle.clear();
        k.gl30.glGenVertexArrays(1, tmpHandle);
        this.vaoHandle = tmpHandle.get();
    }

    private void deleteVAO() {
        if (this.vaoHandle != -1) {
            tmpHandle.clear();
            tmpHandle.put(this.vaoHandle);
            tmpHandle.flip();
            k.gl30.glDeleteVertexArrays(1, tmpHandle);
            this.vaoHandle = -1;
        }
    }

    private void unbindAttributes(ShaderProgram shaderProgram) {
        if (this.cachedLocations.size != 0) {
            int size = this.attributes.size();
            for (int i = 0; i < size; i++) {
                int i2 = this.cachedLocations.get(i);
                if (i2 >= 0) {
                    shaderProgram.disableVertexAttribute(i2);
                }
            }
        }
    }

    public void bind(ShaderProgram shaderProgram) {
        bind(shaderProgram, null);
    }

    public void dispose() {
        GL30 gl30 = k.gl30;
        gl30.glBindBuffer(GL20.GL_ARRAY_BUFFER, 0);
        gl30.glDeleteBuffer(this.bufferHandle);
        this.bufferHandle = 0;
        if (this.ownsBuffer) {
            BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer);
        }
        deleteVAO();
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

    public void invalidate() {
        this.bufferHandle = k.gl30.glGenBuffer();
        createVAO();
        this.isDirty = true;
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

    public VertexBufferObjectWithVAO(boolean z, int i, VertexAttributes vertexAttributes) {
        this.isDirty = false;
        this.isBound = false;
        this.vaoHandle = -1;
        this.cachedLocations = new IntArray();
        this.isStatic = z;
        this.attributes = vertexAttributes;
        ByteBuffer newUnsafeByteBuffer = BufferUtils.newUnsafeByteBuffer(vertexAttributes.vertexSize * i);
        this.byteBuffer = newUnsafeByteBuffer;
        FloatBuffer asFloatBuffer = newUnsafeByteBuffer.asFloatBuffer();
        this.buffer = asFloatBuffer;
        this.ownsBuffer = true;
        asFloatBuffer.flip();
        this.byteBuffer.flip();
        this.bufferHandle = k.gl20.glGenBuffer();
        this.usage = z ? GL20.GL_STATIC_DRAW : GL20.GL_DYNAMIC_DRAW;
        createVAO();
    }

    public void bind(ShaderProgram shaderProgram, int[] iArr) {
        GL30 gl30 = k.gl30;
        gl30.glBindVertexArray(this.vaoHandle);
        bindAttributes(shaderProgram, iArr);
        bindData(gl30);
        this.isBound = true;
    }

    public void unbind(ShaderProgram shaderProgram, int[] iArr) {
        k.gl30.glBindVertexArray(0);
        this.isBound = false;
    }

    public VertexBufferObjectWithVAO(boolean z, ByteBuffer byteBuffer2, VertexAttributes vertexAttributes) {
        this.isDirty = false;
        this.isBound = false;
        this.vaoHandle = -1;
        this.cachedLocations = new IntArray();
        this.isStatic = z;
        this.attributes = vertexAttributes;
        this.byteBuffer = byteBuffer2;
        this.ownsBuffer = false;
        FloatBuffer asFloatBuffer = byteBuffer2.asFloatBuffer();
        this.buffer = asFloatBuffer;
        asFloatBuffer.flip();
        this.byteBuffer.flip();
        this.bufferHandle = k.gl20.glGenBuffer();
        this.usage = z ? GL20.GL_STATIC_DRAW : GL20.GL_DYNAMIC_DRAW;
        createVAO();
    }
}
