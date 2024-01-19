package com.badlogic.gdx.graphics.glutils;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.Cubemap.CubemapSide;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.glutils.GLFrameBuffer.FrameBufferCubemapBuilder;
import com.badlogic.gdx.graphics.glutils.GLFrameBuffer.FrameBufferTextureAttachmentSpec;
import com.badlogic.gdx.graphics.glutils.GLFrameBuffer.GLFrameBufferBuilder;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class FrameBufferCubemap extends GLFrameBuffer<Cubemap> {
    public static final CubemapSide[] cubemapSides = CubemapSide.values();
    public int currentSide;

    public FrameBufferCubemap() {
    }

    public void bind() {
        this.currentSide = -1;
        super.bind();
    }

    public void bindSide(CubemapSide cubemapSide) {
        k.gl20.glFramebufferTexture2D(GL20.GL_FRAMEBUFFER, GL20.GL_COLOR_ATTACHMENT0, cubemapSide.glEnum, ((Cubemap) getColorBufferTexture()).getTextureObjectHandle(), 0);
    }

    public CubemapSide getSide() {
        int i = this.currentSide;
        if (i < 0) {
            return null;
        }
        return cubemapSides[i];
    }

    public boolean nextSide() {
        int i = this.currentSide;
        if (i > 5) {
            throw new GdxRuntimeException((String) "No remaining sides.");
        } else if (i == 5) {
            return false;
        } else {
            this.currentSide = i + 1;
            bindSide(getSide());
            return true;
        }
    }

    public FrameBufferCubemap(GLFrameBufferBuilder<? extends GLFrameBuffer<Cubemap>> gLFrameBufferBuilder) {
        super(gLFrameBufferBuilder);
    }

    public void attachFrameBufferColorTexture(Cubemap cubemap) {
        GL20 gl20 = k.gl20;
        int textureObjectHandle = cubemap.getTextureObjectHandle();
        for (CubemapSide cubemapSide : CubemapSide.values()) {
            gl20.glFramebufferTexture2D(GL20.GL_FRAMEBUFFER, GL20.GL_COLOR_ATTACHMENT0, cubemapSide.glEnum, textureObjectHandle, 0);
        }
    }

    public Cubemap createTexture(FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec) {
        GLFrameBufferBuilder<? extends GLFrameBuffer<T>> gLFrameBufferBuilder = this.bufferBuilder;
        GLOnlyTextureData gLOnlyTextureData = new GLOnlyTextureData(gLFrameBufferBuilder.width, gLFrameBufferBuilder.height, 0, frameBufferTextureAttachmentSpec.internalFormat, frameBufferTextureAttachmentSpec.format, frameBufferTextureAttachmentSpec.type);
        Cubemap cubemap = new Cubemap((TextureData) gLOnlyTextureData, (TextureData) gLOnlyTextureData, (TextureData) gLOnlyTextureData, (TextureData) gLOnlyTextureData, (TextureData) gLOnlyTextureData, (TextureData) gLOnlyTextureData);
        TextureFilter textureFilter = TextureFilter.Linear;
        cubemap.setFilter(textureFilter, textureFilter);
        TextureWrap textureWrap = TextureWrap.ClampToEdge;
        cubemap.setWrap(textureWrap, textureWrap);
        return cubemap;
    }

    public void disposeColorTexture(Cubemap cubemap) {
        cubemap.dispose();
    }

    public FrameBufferCubemap(Format format, int i, int i2, boolean z) {
        this(format, i, i2, z, false);
    }

    public FrameBufferCubemap(Format format, int i, int i2, boolean z, boolean z2) {
        FrameBufferCubemapBuilder frameBufferCubemapBuilder = new FrameBufferCubemapBuilder(i, i2);
        frameBufferCubemapBuilder.addBasicColorTextureAttachment(format);
        if (z) {
            frameBufferCubemapBuilder.addBasicDepthRenderBuffer();
        }
        if (z2) {
            frameBufferCubemapBuilder.addBasicStencilRenderBuffer();
        }
        this.bufferBuilder = frameBufferCubemapBuilder;
        build();
    }
}
