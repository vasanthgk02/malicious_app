package com.badlogic.gdx.graphics.glutils;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.glutils.GLFrameBuffer.FrameBufferBuilder;
import com.badlogic.gdx.graphics.glutils.GLFrameBuffer.FrameBufferTextureAttachmentSpec;
import com.badlogic.gdx.graphics.glutils.GLFrameBuffer.GLFrameBufferBuilder;

public class FrameBuffer extends GLFrameBuffer<Texture> {
    public FrameBuffer() {
    }

    public static void unbind() {
        GLFrameBuffer.unbind();
    }

    public FrameBuffer(GLFrameBufferBuilder<? extends GLFrameBuffer<Texture>> gLFrameBufferBuilder) {
        super(gLFrameBufferBuilder);
    }

    public void attachFrameBufferColorTexture(Texture texture) {
        k.gl20.glFramebufferTexture2D(GL20.GL_FRAMEBUFFER, GL20.GL_COLOR_ATTACHMENT0, GL20.GL_TEXTURE_2D, texture.getTextureObjectHandle(), 0);
    }

    public Texture createTexture(FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec) {
        GLFrameBufferBuilder<? extends GLFrameBuffer<T>> gLFrameBufferBuilder = this.bufferBuilder;
        GLOnlyTextureData gLOnlyTextureData = new GLOnlyTextureData(gLFrameBufferBuilder.width, gLFrameBufferBuilder.height, 0, frameBufferTextureAttachmentSpec.internalFormat, frameBufferTextureAttachmentSpec.format, frameBufferTextureAttachmentSpec.type);
        Texture texture = new Texture((TextureData) gLOnlyTextureData);
        TextureFilter textureFilter = TextureFilter.Linear;
        texture.setFilter(textureFilter, textureFilter);
        TextureWrap textureWrap = TextureWrap.ClampToEdge;
        texture.setWrap(textureWrap, textureWrap);
        return texture;
    }

    public void disposeColorTexture(Texture texture) {
        texture.dispose();
    }

    public FrameBuffer(Format format, int i, int i2, boolean z) {
        this(format, i, i2, z, false);
    }

    public FrameBuffer(Format format, int i, int i2, boolean z, boolean z2) {
        FrameBufferBuilder frameBufferBuilder = new FrameBufferBuilder(i, i2);
        frameBufferBuilder.addBasicColorTextureAttachment(format);
        if (z) {
            frameBufferBuilder.addBasicDepthRenderBuffer();
        }
        if (z2) {
            frameBufferBuilder.addBasicStencilRenderBuffer();
        }
        this.bufferBuilder = frameBufferBuilder;
        build();
    }
}
