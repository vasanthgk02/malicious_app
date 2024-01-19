package com.badlogic.gdx.graphics;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.badlogic.gdx.graphics.Pixmap.Blending;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.TextureData.TextureDataType;
import com.badlogic.gdx.graphics.glutils.MipMapGenerator;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.Disposable;
import java.nio.FloatBuffer;

public abstract class GLTexture implements Disposable {
    public static float maxAnisotropicFilterLevel;
    public float anisotropicFilterLevel;
    public int glHandle;
    public final int glTarget;
    public TextureFilter magFilter;
    public TextureFilter minFilter;
    public TextureWrap uWrap;
    public TextureWrap vWrap;

    public GLTexture(int i) {
        this(i, k.gl.glGenTexture());
    }

    public static float getMaxAnisotropicFilterLevel() {
        float f2 = maxAnisotropicFilterLevel;
        if (f2 > 0.0f) {
            return f2;
        }
        if (((AndroidGraphics) k.graphics).supportsExtension("GL_EXT_texture_filter_anisotropic")) {
            FloatBuffer newFloatBuffer = BufferUtils.newFloatBuffer(16);
            newFloatBuffer.position(0);
            newFloatBuffer.limit(newFloatBuffer.capacity());
            k.gl20.glGetFloatv(GL20.GL_MAX_TEXTURE_MAX_ANISOTROPY_EXT, newFloatBuffer);
            float f3 = newFloatBuffer.get(0);
            maxAnisotropicFilterLevel = f3;
            return f3;
        }
        maxAnisotropicFilterLevel = 1.0f;
        return 1.0f;
    }

    public static void uploadImageData(int i, TextureData textureData) {
        uploadImageData(i, textureData, 0);
    }

    public void bind() {
        k.gl.glBindTexture(this.glTarget, this.glHandle);
    }

    public void delete() {
        int i = this.glHandle;
        if (i != 0) {
            k.gl.glDeleteTexture(i);
            this.glHandle = 0;
        }
    }

    public void dispose() {
        delete();
    }

    public float getAnisotropicFilter() {
        return this.anisotropicFilterLevel;
    }

    public abstract int getDepth();

    public abstract int getHeight();

    public TextureFilter getMagFilter() {
        return this.magFilter;
    }

    public TextureFilter getMinFilter() {
        return this.minFilter;
    }

    public int getTextureObjectHandle() {
        return this.glHandle;
    }

    public TextureWrap getUWrap() {
        return this.uWrap;
    }

    public TextureWrap getVWrap() {
        return this.vWrap;
    }

    public abstract int getWidth();

    public abstract boolean isManaged();

    public abstract void reload();

    public float setAnisotropicFilter(float f2) {
        float maxAnisotropicFilterLevel2 = getMaxAnisotropicFilterLevel();
        if (maxAnisotropicFilterLevel2 == 1.0f) {
            return 1.0f;
        }
        float min = Math.min(f2, maxAnisotropicFilterLevel2);
        if (MathUtils.isEqual(min, this.anisotropicFilterLevel, 0.1f)) {
            return min;
        }
        bind();
        k.gl20.glTexParameterf(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_MAX_ANISOTROPY_EXT, min);
        this.anisotropicFilterLevel = min;
        return min;
    }

    public void setFilter(TextureFilter textureFilter, TextureFilter textureFilter2) {
        this.minFilter = textureFilter;
        this.magFilter = textureFilter2;
        bind();
        k.gl.glTexParameteri(this.glTarget, GL20.GL_TEXTURE_MIN_FILTER, textureFilter.getGLEnum());
        k.gl.glTexParameteri(this.glTarget, GL20.GL_TEXTURE_MAG_FILTER, textureFilter2.getGLEnum());
    }

    public void setWrap(TextureWrap textureWrap, TextureWrap textureWrap2) {
        this.uWrap = textureWrap;
        this.vWrap = textureWrap2;
        bind();
        k.gl.glTexParameteri(this.glTarget, GL20.GL_TEXTURE_WRAP_S, textureWrap.getGLEnum());
        k.gl.glTexParameteri(this.glTarget, GL20.GL_TEXTURE_WRAP_T, textureWrap2.getGLEnum());
    }

    public float unsafeSetAnisotropicFilter(float f2) {
        return unsafeSetAnisotropicFilter(f2, false);
    }

    public void unsafeSetFilter(TextureFilter textureFilter, TextureFilter textureFilter2) {
        unsafeSetFilter(textureFilter, textureFilter2, false);
    }

    public void unsafeSetWrap(TextureWrap textureWrap, TextureWrap textureWrap2) {
        unsafeSetWrap(textureWrap, textureWrap2, false);
    }

    public GLTexture(int i, int i2) {
        TextureFilter textureFilter = TextureFilter.Nearest;
        this.minFilter = textureFilter;
        this.magFilter = textureFilter;
        TextureWrap textureWrap = TextureWrap.ClampToEdge;
        this.uWrap = textureWrap;
        this.vWrap = textureWrap;
        this.anisotropicFilterLevel = 1.0f;
        this.glTarget = i;
        this.glHandle = i2;
    }

    public static void uploadImageData(int i, TextureData textureData, int i2) {
        if (textureData != null) {
            if (!textureData.isPrepared()) {
                textureData.prepare();
            }
            if (textureData.getType() == TextureDataType.Custom) {
                textureData.consumeCustomData(i);
                return;
            }
            Pixmap consumePixmap = textureData.consumePixmap();
            boolean disposePixmap = textureData.disposePixmap();
            if (textureData.getFormat() != consumePixmap.getFormat()) {
                Pixmap pixmap = new Pixmap(consumePixmap.getWidth(), consumePixmap.getHeight(), textureData.getFormat());
                pixmap.setBlending(Blending.None);
                pixmap.drawPixmap(consumePixmap, 0, 0, 0, 0, consumePixmap.getWidth(), consumePixmap.getHeight());
                if (textureData.disposePixmap()) {
                    consumePixmap.dispose();
                }
                consumePixmap = pixmap;
                disposePixmap = true;
            }
            k.gl.glPixelStorei(GL20.GL_UNPACK_ALIGNMENT, 1);
            if (textureData.useMipMaps()) {
                MipMapGenerator.generateMipMap(i, consumePixmap, consumePixmap.getWidth(), consumePixmap.getHeight());
            } else {
                k.gl.glTexImage2D(i, i2, consumePixmap.getGLInternalFormat(), consumePixmap.getWidth(), consumePixmap.getHeight(), 0, consumePixmap.getGLFormat(), consumePixmap.getGLType(), consumePixmap.getPixels());
            }
            if (disposePixmap) {
                consumePixmap.dispose();
            }
        }
    }

    public void bind(int i) {
        k.gl.glActiveTexture(i + GL20.GL_TEXTURE0);
        k.gl.glBindTexture(this.glTarget, this.glHandle);
    }

    public float unsafeSetAnisotropicFilter(float f2, boolean z) {
        float maxAnisotropicFilterLevel2 = getMaxAnisotropicFilterLevel();
        if (maxAnisotropicFilterLevel2 == 1.0f) {
            return 1.0f;
        }
        float min = Math.min(f2, maxAnisotropicFilterLevel2);
        if (!z && MathUtils.isEqual(min, this.anisotropicFilterLevel, 0.1f)) {
            return this.anisotropicFilterLevel;
        }
        k.gl20.glTexParameterf(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_MAX_ANISOTROPY_EXT, min);
        this.anisotropicFilterLevel = min;
        return min;
    }

    public void unsafeSetFilter(TextureFilter textureFilter, TextureFilter textureFilter2, boolean z) {
        if (textureFilter != null && (z || this.minFilter != textureFilter)) {
            k.gl.glTexParameteri(this.glTarget, GL20.GL_TEXTURE_MIN_FILTER, textureFilter.getGLEnum());
            this.minFilter = textureFilter;
        }
        if (textureFilter2 == null) {
            return;
        }
        if (z || this.magFilter != textureFilter2) {
            k.gl.glTexParameteri(this.glTarget, GL20.GL_TEXTURE_MAG_FILTER, textureFilter2.getGLEnum());
            this.magFilter = textureFilter2;
        }
    }

    public void unsafeSetWrap(TextureWrap textureWrap, TextureWrap textureWrap2, boolean z) {
        if (textureWrap != null && (z || this.uWrap != textureWrap)) {
            k.gl.glTexParameteri(this.glTarget, GL20.GL_TEXTURE_WRAP_S, textureWrap.getGLEnum());
            this.uWrap = textureWrap;
        }
        if (textureWrap2 == null) {
            return;
        }
        if (z || this.vWrap != textureWrap2) {
            k.gl.glTexParameteri(this.glTarget, GL20.GL_TEXTURE_WRAP_T, textureWrap2.getGLEnum());
            this.vWrap = textureWrap2;
        }
    }
}
