package com.badlogic.gdx.graphics.glutils;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;
import org.apache.fontbox.cmap.CMap;

public abstract class GLFrameBuffer<T extends GLTexture> implements Disposable {
    public static final int GL_DEPTH24_STENCIL8_OES = 35056;
    public static final Map<Application, Array<GLFrameBuffer>> buffers = new HashMap();
    public static int defaultFramebufferHandle;
    public static boolean defaultFramebufferHandleInitialized = false;
    public GLFrameBufferBuilder<? extends GLFrameBuffer<T>> bufferBuilder;
    public int depthStencilPackedBufferHandle;
    public int depthbufferHandle;
    public int framebufferHandle;
    public boolean hasDepthStencilPackedBuffer;
    public boolean isMRT;
    public int stencilbufferHandle;
    public Array<T> textureAttachments = new Array<>();

    public static class FloatFrameBufferBuilder extends GLFrameBufferBuilder<FloatFrameBuffer> {
        public FloatFrameBufferBuilder(int i, int i2) {
            super(i, i2);
        }

        public FloatFrameBuffer build() {
            return new FloatFrameBuffer(this);
        }
    }

    public static class FrameBufferBuilder extends GLFrameBufferBuilder<FrameBuffer> {
        public FrameBufferBuilder(int i, int i2) {
            super(i, i2);
        }

        public FrameBuffer build() {
            return new FrameBuffer(this);
        }
    }

    public static class FrameBufferCubemapBuilder extends GLFrameBufferBuilder<FrameBufferCubemap> {
        public FrameBufferCubemapBuilder(int i, int i2) {
            super(i, i2);
        }

        public FrameBufferCubemap build() {
            return new FrameBufferCubemap(this);
        }
    }

    public static class FrameBufferRenderBufferAttachmentSpec {
        public int internalFormat;

        public FrameBufferRenderBufferAttachmentSpec(int i) {
            this.internalFormat = i;
        }
    }

    public static class FrameBufferTextureAttachmentSpec {
        public int format;
        public int internalFormat;
        public boolean isDepth;
        public boolean isFloat;
        public boolean isGpuOnly;
        public boolean isStencil;
        public int type;

        public FrameBufferTextureAttachmentSpec(int i, int i2, int i3) {
            this.internalFormat = i;
            this.format = i2;
            this.type = i3;
        }

        public boolean isColorTexture() {
            return !this.isDepth && !this.isStencil;
        }
    }

    public static abstract class GLFrameBufferBuilder<U extends GLFrameBuffer<? extends GLTexture>> {
        public FrameBufferRenderBufferAttachmentSpec depthRenderBufferSpec;
        public boolean hasDepthRenderBuffer;
        public boolean hasPackedStencilDepthRenderBuffer;
        public boolean hasStencilRenderBuffer;
        public int height;
        public FrameBufferRenderBufferAttachmentSpec packedStencilDepthRenderBufferSpec;
        public FrameBufferRenderBufferAttachmentSpec stencilRenderBufferSpec;
        public Array<FrameBufferTextureAttachmentSpec> textureAttachmentSpecs = new Array<>();
        public int width;

        public GLFrameBufferBuilder(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public GLFrameBufferBuilder<U> addBasicColorTextureAttachment(Format format) {
            int glFormat = Format.toGlFormat(format);
            return addColorTextureAttachment(glFormat, glFormat, Format.toGlType(format));
        }

        public GLFrameBufferBuilder<U> addBasicDepthRenderBuffer() {
            return addDepthRenderBuffer(GL20.GL_DEPTH_COMPONENT16);
        }

        public GLFrameBufferBuilder<U> addBasicStencilDepthPackedRenderBuffer() {
            return addStencilDepthPackedRenderBuffer(35056);
        }

        public GLFrameBufferBuilder<U> addBasicStencilRenderBuffer() {
            return addStencilRenderBuffer(GL20.GL_STENCIL_INDEX8);
        }

        public GLFrameBufferBuilder<U> addColorTextureAttachment(int i, int i2, int i3) {
            this.textureAttachmentSpecs.add(new FrameBufferTextureAttachmentSpec(i, i2, i3));
            return this;
        }

        public GLFrameBufferBuilder<U> addDepthRenderBuffer(int i) {
            this.depthRenderBufferSpec = new FrameBufferRenderBufferAttachmentSpec(i);
            this.hasDepthRenderBuffer = true;
            return this;
        }

        public GLFrameBufferBuilder<U> addDepthTextureAttachment(int i, int i2) {
            FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec = new FrameBufferTextureAttachmentSpec(i, GL20.GL_DEPTH_COMPONENT, i2);
            frameBufferTextureAttachmentSpec.isDepth = true;
            this.textureAttachmentSpecs.add(frameBufferTextureAttachmentSpec);
            return this;
        }

        public GLFrameBufferBuilder<U> addFloatAttachment(int i, int i2, int i3, boolean z) {
            FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec = new FrameBufferTextureAttachmentSpec(i, i2, i3);
            frameBufferTextureAttachmentSpec.isFloat = true;
            frameBufferTextureAttachmentSpec.isGpuOnly = z;
            this.textureAttachmentSpecs.add(frameBufferTextureAttachmentSpec);
            return this;
        }

        public GLFrameBufferBuilder<U> addStencilDepthPackedRenderBuffer(int i) {
            this.packedStencilDepthRenderBufferSpec = new FrameBufferRenderBufferAttachmentSpec(i);
            this.hasPackedStencilDepthRenderBuffer = true;
            return this;
        }

        public GLFrameBufferBuilder<U> addStencilRenderBuffer(int i) {
            this.stencilRenderBufferSpec = new FrameBufferRenderBufferAttachmentSpec(i);
            this.hasStencilRenderBuffer = true;
            return this;
        }

        public GLFrameBufferBuilder<U> addStencilTextureAttachment(int i, int i2) {
            FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec = new FrameBufferTextureAttachmentSpec(i, GL20.GL_STENCIL_ATTACHMENT, i2);
            frameBufferTextureAttachmentSpec.isStencil = true;
            this.textureAttachmentSpecs.add(frameBufferTextureAttachmentSpec);
            return this;
        }

        public abstract U build();
    }

    public GLFrameBuffer() {
    }

    public static void addManagedFrameBuffer(Application application, GLFrameBuffer gLFrameBuffer) {
        Array array = buffers.get(application);
        if (array == null) {
            array = new Array();
        }
        array.add(gLFrameBuffer);
        buffers.put(application, array);
    }

    private void checkValidBuilder() {
        if (!(((AndroidGraphics) k.graphics).gl30 != null)) {
            GLFrameBufferBuilder<? extends GLFrameBuffer<T>> gLFrameBufferBuilder = this.bufferBuilder;
            if (!gLFrameBufferBuilder.hasPackedStencilDepthRenderBuffer) {
                Array<FrameBufferTextureAttachmentSpec> array = gLFrameBufferBuilder.textureAttachmentSpecs;
                if (array.size <= 1) {
                    ArrayIterator it = array.iterator();
                    while (it.hasNext()) {
                        FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec = (FrameBufferTextureAttachmentSpec) it.next();
                        if (frameBufferTextureAttachmentSpec.isDepth) {
                            throw new GdxRuntimeException((String) "Depth texture FrameBuffer Attachment not available on GLES 2.0");
                        } else if (frameBufferTextureAttachmentSpec.isStencil) {
                            throw new GdxRuntimeException((String) "Stencil texture FrameBuffer Attachment not available on GLES 2.0");
                        } else if (frameBufferTextureAttachmentSpec.isFloat && !((AndroidGraphics) k.graphics).supportsExtension("OES_texture_float")) {
                            throw new GdxRuntimeException((String) "Float texture FrameBuffer Attachment not available on GLES 2.0");
                        }
                    }
                    return;
                }
                throw new GdxRuntimeException((String) "Multiple render targets not available on GLES 2.0");
            }
            throw new GdxRuntimeException((String) "Packed Stencil/Render render buffers are not available on GLES 2.0");
        }
    }

    public static void clearAllFrameBuffers(Application application) {
        buffers.remove(application);
    }

    public static StringBuilder getManagedStatus(StringBuilder sb) {
        sb.append("Managed buffers/app: { ");
        for (Application application : buffers.keySet()) {
            sb.append(buffers.get(application).size);
            sb.append(CMap.SPACE);
        }
        sb.append("}");
        return sb;
    }

    public static void invalidateAllFrameBuffers(Application application) {
        if (k.gl20 != null) {
            Array array = buffers.get(application);
            if (array != null) {
                for (int i = 0; i < array.size; i++) {
                    ((GLFrameBuffer) array.get(i)).build();
                }
            }
        }
    }

    public static void unbind() {
        k.gl20.glBindFramebuffer(GL20.GL_FRAMEBUFFER, defaultFramebufferHandle);
    }

    public abstract void attachFrameBufferColorTexture(T t);

    public void begin() {
        bind();
        setFrameBufferViewport();
    }

    public void bind() {
        k.gl20.glBindFramebuffer(GL20.GL_FRAMEBUFFER, this.framebufferHandle);
    }

    public void build() {
        int i;
        GL20 gl20 = k.gl20;
        checkValidBuilder();
        if (!defaultFramebufferHandleInitialized) {
            defaultFramebufferHandleInitialized = true;
            if (k.app.getType() == ApplicationType.iOS) {
                IntBuffer asIntBuffer = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asIntBuffer();
                gl20.glGetIntegerv(36006, asIntBuffer);
                defaultFramebufferHandle = asIntBuffer.get(0);
            } else {
                defaultFramebufferHandle = 0;
            }
        }
        int glGenFramebuffer = gl20.glGenFramebuffer();
        this.framebufferHandle = glGenFramebuffer;
        gl20.glBindFramebuffer(GL20.GL_FRAMEBUFFER, glGenFramebuffer);
        GLFrameBufferBuilder<? extends GLFrameBuffer<T>> gLFrameBufferBuilder = this.bufferBuilder;
        int i2 = gLFrameBufferBuilder.width;
        int i3 = gLFrameBufferBuilder.height;
        if (gLFrameBufferBuilder.hasDepthRenderBuffer) {
            int glGenRenderbuffer = gl20.glGenRenderbuffer();
            this.depthbufferHandle = glGenRenderbuffer;
            gl20.glBindRenderbuffer(GL20.GL_RENDERBUFFER, glGenRenderbuffer);
            gl20.glRenderbufferStorage(GL20.GL_RENDERBUFFER, this.bufferBuilder.depthRenderBufferSpec.internalFormat, i2, i3);
        }
        if (this.bufferBuilder.hasStencilRenderBuffer) {
            int glGenRenderbuffer2 = gl20.glGenRenderbuffer();
            this.stencilbufferHandle = glGenRenderbuffer2;
            gl20.glBindRenderbuffer(GL20.GL_RENDERBUFFER, glGenRenderbuffer2);
            gl20.glRenderbufferStorage(GL20.GL_RENDERBUFFER, this.bufferBuilder.stencilRenderBufferSpec.internalFormat, i2, i3);
        }
        if (this.bufferBuilder.hasPackedStencilDepthRenderBuffer) {
            int glGenRenderbuffer3 = gl20.glGenRenderbuffer();
            this.depthStencilPackedBufferHandle = glGenRenderbuffer3;
            gl20.glBindRenderbuffer(GL20.GL_RENDERBUFFER, glGenRenderbuffer3);
            gl20.glRenderbufferStorage(GL20.GL_RENDERBUFFER, this.bufferBuilder.packedStencilDepthRenderBufferSpec.internalFormat, i2, i3);
        }
        boolean z = this.bufferBuilder.textureAttachmentSpecs.size > 1;
        this.isMRT = z;
        if (z) {
            ArrayIterator it = this.bufferBuilder.textureAttachmentSpecs.iterator();
            int i4 = 0;
            while (it.hasNext()) {
                FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec = (FrameBufferTextureAttachmentSpec) it.next();
                GLTexture createTexture = createTexture(frameBufferTextureAttachmentSpec);
                this.textureAttachments.add(createTexture);
                if (frameBufferTextureAttachmentSpec.isColorTexture()) {
                    gl20.glFramebufferTexture2D(GL20.GL_FRAMEBUFFER, i4 + GL20.GL_COLOR_ATTACHMENT0, GL20.GL_TEXTURE_2D, createTexture.getTextureObjectHandle(), 0);
                    i4++;
                } else if (frameBufferTextureAttachmentSpec.isDepth) {
                    gl20.glFramebufferTexture2D(GL20.GL_FRAMEBUFFER, GL20.GL_DEPTH_ATTACHMENT, GL20.GL_TEXTURE_2D, createTexture.getTextureObjectHandle(), 0);
                } else if (frameBufferTextureAttachmentSpec.isStencil) {
                    gl20.glFramebufferTexture2D(GL20.GL_FRAMEBUFFER, GL20.GL_STENCIL_ATTACHMENT, GL20.GL_TEXTURE_2D, createTexture.getTextureObjectHandle(), 0);
                }
            }
            i = i4;
        } else {
            GLTexture createTexture2 = createTexture((FrameBufferTextureAttachmentSpec) this.bufferBuilder.textureAttachmentSpecs.first());
            this.textureAttachments.add(createTexture2);
            gl20.glBindTexture(createTexture2.glTarget, createTexture2.getTextureObjectHandle());
            i = 0;
        }
        if (this.isMRT) {
            IntBuffer newIntBuffer = BufferUtils.newIntBuffer(i);
            for (int i5 = 0; i5 < i; i5++) {
                newIntBuffer.put(i5 + GL20.GL_COLOR_ATTACHMENT0);
            }
            newIntBuffer.position(0);
            k.gl30.glDrawBuffers(i, newIntBuffer);
        } else {
            attachFrameBufferColorTexture((GLTexture) this.textureAttachments.first());
        }
        if (this.bufferBuilder.hasDepthRenderBuffer) {
            gl20.glFramebufferRenderbuffer(GL20.GL_FRAMEBUFFER, GL20.GL_DEPTH_ATTACHMENT, GL20.GL_RENDERBUFFER, this.depthbufferHandle);
        }
        if (this.bufferBuilder.hasStencilRenderBuffer) {
            gl20.glFramebufferRenderbuffer(GL20.GL_FRAMEBUFFER, GL20.GL_STENCIL_ATTACHMENT, GL20.GL_RENDERBUFFER, this.stencilbufferHandle);
        }
        if (this.bufferBuilder.hasPackedStencilDepthRenderBuffer) {
            gl20.glFramebufferRenderbuffer(GL20.GL_FRAMEBUFFER, GL30.GL_DEPTH_STENCIL_ATTACHMENT, GL20.GL_RENDERBUFFER, this.depthStencilPackedBufferHandle);
        }
        gl20.glBindRenderbuffer(GL20.GL_RENDERBUFFER, 0);
        ArrayIterator it2 = this.textureAttachments.iterator();
        while (it2.hasNext()) {
            gl20.glBindTexture(((GLTexture) it2.next()).glTarget, 0);
        }
        int glCheckFramebufferStatus = gl20.glCheckFramebufferStatus(GL20.GL_FRAMEBUFFER);
        if (glCheckFramebufferStatus == 36061) {
            GLFrameBufferBuilder<? extends GLFrameBuffer<T>> gLFrameBufferBuilder2 = this.bufferBuilder;
            if (gLFrameBufferBuilder2.hasDepthRenderBuffer && gLFrameBufferBuilder2.hasStencilRenderBuffer && (((AndroidGraphics) k.graphics).supportsExtension("GL_OES_packed_depth_stencil") || ((AndroidGraphics) k.graphics).supportsExtension("GL_EXT_packed_depth_stencil"))) {
                if (this.bufferBuilder.hasDepthRenderBuffer) {
                    gl20.glDeleteRenderbuffer(this.depthbufferHandle);
                    this.depthbufferHandle = 0;
                }
                if (this.bufferBuilder.hasStencilRenderBuffer) {
                    gl20.glDeleteRenderbuffer(this.stencilbufferHandle);
                    this.stencilbufferHandle = 0;
                }
                if (this.bufferBuilder.hasPackedStencilDepthRenderBuffer) {
                    gl20.glDeleteRenderbuffer(this.depthStencilPackedBufferHandle);
                    this.depthStencilPackedBufferHandle = 0;
                }
                int glGenRenderbuffer4 = gl20.glGenRenderbuffer();
                this.depthStencilPackedBufferHandle = glGenRenderbuffer4;
                this.hasDepthStencilPackedBuffer = true;
                gl20.glBindRenderbuffer(GL20.GL_RENDERBUFFER, glGenRenderbuffer4);
                gl20.glRenderbufferStorage(GL20.GL_RENDERBUFFER, 35056, i2, i3);
                gl20.glBindRenderbuffer(GL20.GL_RENDERBUFFER, 0);
                gl20.glFramebufferRenderbuffer(GL20.GL_FRAMEBUFFER, GL20.GL_DEPTH_ATTACHMENT, GL20.GL_RENDERBUFFER, this.depthStencilPackedBufferHandle);
                gl20.glFramebufferRenderbuffer(GL20.GL_FRAMEBUFFER, GL20.GL_STENCIL_ATTACHMENT, GL20.GL_RENDERBUFFER, this.depthStencilPackedBufferHandle);
                glCheckFramebufferStatus = gl20.glCheckFramebufferStatus(GL20.GL_FRAMEBUFFER);
            }
        }
        gl20.glBindFramebuffer(GL20.GL_FRAMEBUFFER, defaultFramebufferHandle);
        if (glCheckFramebufferStatus != 36053) {
            ArrayIterator it3 = this.textureAttachments.iterator();
            while (it3.hasNext()) {
                disposeColorTexture((GLTexture) it3.next());
            }
            if (this.hasDepthStencilPackedBuffer) {
                gl20.glDeleteBuffer(this.depthStencilPackedBufferHandle);
            } else {
                if (this.bufferBuilder.hasDepthRenderBuffer) {
                    gl20.glDeleteRenderbuffer(this.depthbufferHandle);
                }
                if (this.bufferBuilder.hasStencilRenderBuffer) {
                    gl20.glDeleteRenderbuffer(this.stencilbufferHandle);
                }
            }
            gl20.glDeleteFramebuffer(this.framebufferHandle);
            if (glCheckFramebufferStatus == 36054) {
                throw new IllegalStateException("Frame buffer couldn't be constructed: incomplete attachment");
            } else if (glCheckFramebufferStatus == 36057) {
                throw new IllegalStateException("Frame buffer couldn't be constructed: incomplete dimensions");
            } else if (glCheckFramebufferStatus == 36055) {
                throw new IllegalStateException("Frame buffer couldn't be constructed: missing attachment");
            } else if (glCheckFramebufferStatus == 36061) {
                throw new IllegalStateException("Frame buffer couldn't be constructed: unsupported combination of formats");
            } else {
                throw new IllegalStateException(GeneratedOutlineSupport.outline41("Frame buffer couldn't be constructed: unknown error ", glCheckFramebufferStatus));
            }
        } else {
            addManagedFrameBuffer(k.app, this);
        }
    }

    public abstract T createTexture(FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec);

    public void dispose() {
        GL20 gl20 = k.gl20;
        ArrayIterator it = this.textureAttachments.iterator();
        while (it.hasNext()) {
            disposeColorTexture((GLTexture) it.next());
        }
        if (this.hasDepthStencilPackedBuffer) {
            gl20.glDeleteRenderbuffer(this.depthStencilPackedBufferHandle);
        } else {
            if (this.bufferBuilder.hasDepthRenderBuffer) {
                gl20.glDeleteRenderbuffer(this.depthbufferHandle);
            }
            if (this.bufferBuilder.hasStencilRenderBuffer) {
                gl20.glDeleteRenderbuffer(this.stencilbufferHandle);
            }
        }
        gl20.glDeleteFramebuffer(this.framebufferHandle);
        if (buffers.get(k.app) != null) {
            buffers.get(k.app).removeValue(this, true);
        }
    }

    public abstract void disposeColorTexture(T t);

    public void end() {
        Graphics graphics = k.graphics;
        end(0, 0, ((AndroidGraphics) graphics).width, ((AndroidGraphics) graphics).height);
    }

    public T getColorBufferTexture() {
        return (GLTexture) this.textureAttachments.first();
    }

    public int getDepthBufferHandle() {
        return this.depthbufferHandle;
    }

    public int getDepthStencilPackedBuffer() {
        return this.depthStencilPackedBufferHandle;
    }

    public int getFramebufferHandle() {
        return this.framebufferHandle;
    }

    public int getHeight() {
        return this.bufferBuilder.height;
    }

    public int getStencilBufferHandle() {
        return this.stencilbufferHandle;
    }

    public Array<T> getTextureAttachments() {
        return this.textureAttachments;
    }

    public int getWidth() {
        return this.bufferBuilder.width;
    }

    public void setFrameBufferViewport() {
        GL20 gl20 = k.gl20;
        GLFrameBufferBuilder<? extends GLFrameBuffer<T>> gLFrameBufferBuilder = this.bufferBuilder;
        gl20.glViewport(0, 0, gLFrameBufferBuilder.width, gLFrameBufferBuilder.height);
    }

    public GLFrameBuffer(GLFrameBufferBuilder<? extends GLFrameBuffer<T>> gLFrameBufferBuilder) {
        this.bufferBuilder = gLFrameBufferBuilder;
        build();
    }

    public static String getManagedStatus() {
        return getManagedStatus(new StringBuilder()).toString();
    }

    public void end(int i, int i2, int i3, int i4) {
        unbind();
        k.gl20.glViewport(i, i2, i3, i4);
    }
}
