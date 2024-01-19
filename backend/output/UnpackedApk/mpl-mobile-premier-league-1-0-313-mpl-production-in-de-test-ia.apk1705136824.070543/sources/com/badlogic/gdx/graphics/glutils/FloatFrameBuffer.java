package com.badlogic.gdx.graphics.glutils;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.glutils.GLFrameBuffer.FloatFrameBufferBuilder;
import com.badlogic.gdx.graphics.glutils.GLFrameBuffer.FrameBufferTextureAttachmentSpec;
import com.badlogic.gdx.graphics.glutils.GLFrameBuffer.GLFrameBufferBuilder;

public class FloatFrameBuffer extends FrameBuffer {
    public FloatFrameBuffer() {
    }

    public FloatFrameBuffer(GLFrameBufferBuilder<? extends GLFrameBuffer<Texture>> gLFrameBufferBuilder) {
        super(gLFrameBufferBuilder);
    }

    public Texture createTexture(FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec) {
        GLFrameBufferBuilder<? extends GLFrameBuffer<T>> gLFrameBufferBuilder = this.bufferBuilder;
        FloatTextureData floatTextureData = new FloatTextureData(gLFrameBufferBuilder.width, gLFrameBufferBuilder.height, frameBufferTextureAttachmentSpec.internalFormat, frameBufferTextureAttachmentSpec.format, frameBufferTextureAttachmentSpec.type, frameBufferTextureAttachmentSpec.isGpuOnly);
        Texture texture = new Texture((TextureData) floatTextureData);
        if (k.app.getType() == ApplicationType.Desktop || k.app.getType() == ApplicationType.Applet) {
            TextureFilter textureFilter = TextureFilter.Linear;
            texture.setFilter(textureFilter, textureFilter);
        } else {
            TextureFilter textureFilter2 = TextureFilter.Nearest;
            texture.setFilter(textureFilter2, textureFilter2);
        }
        TextureWrap textureWrap = TextureWrap.ClampToEdge;
        texture.setWrap(textureWrap, textureWrap);
        return texture;
    }

    public FloatFrameBuffer(int i, int i2, boolean z) {
        FloatFrameBufferBuilder floatFrameBufferBuilder = new FloatFrameBufferBuilder(i, i2);
        floatFrameBufferBuilder.addFloatAttachment(GL30.GL_RGBA32F, GL20.GL_RGBA, GL20.GL_FLOAT, false);
        if (z) {
            floatFrameBufferBuilder.addBasicDepthRenderBuffer();
        }
        this.bufferBuilder = floatFrameBufferBuilder;
        build();
    }
}
