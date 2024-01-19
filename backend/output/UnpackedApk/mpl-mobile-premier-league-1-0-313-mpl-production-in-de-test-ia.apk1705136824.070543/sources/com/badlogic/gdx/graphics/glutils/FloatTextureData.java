package com.badlogic.gdx.graphics.glutils;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.TextureData.TextureDataType;
import com.badlogic.gdx.graphics.glutils.GLVersion.Type;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.FloatBuffer;

public class FloatTextureData implements TextureData {
    public FloatBuffer buffer;
    public int format;
    public int height = 0;
    public int internalFormat;
    public boolean isGpuOnly;
    public boolean isPrepared = false;
    public int type;
    public int width = 0;

    public FloatTextureData(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.width = i;
        this.height = i2;
        this.internalFormat = i3;
        this.format = i4;
        this.type = i5;
        this.isGpuOnly = z;
    }

    public void consumeCustomData(int i) {
        if (k.app.getType() != ApplicationType.Android && k.app.getType() != ApplicationType.iOS && k.app.getType() != ApplicationType.WebGL) {
            if ((((AndroidGraphics) k.graphics).gl30 != null) || ((AndroidGraphics) k.graphics).supportsExtension("GL_ARB_texture_float")) {
                k.gl.glTexImage2D(i, 0, this.internalFormat, this.width, this.height, 0, this.format, GL20.GL_FLOAT, this.buffer);
                return;
            }
            throw new GdxRuntimeException((String) "Extension GL_ARB_texture_float not supported!");
        } else if (((AndroidGraphics) k.graphics).supportsExtension("OES_texture_float")) {
            k.gl.glTexImage2D(i, 0, GL20.GL_RGBA, this.width, this.height, 0, GL20.GL_RGBA, GL20.GL_FLOAT, this.buffer);
        } else {
            throw new GdxRuntimeException((String) "Extension OES_texture_float not supported!");
        }
    }

    public Pixmap consumePixmap() {
        throw new GdxRuntimeException((String) "This TextureData implementation does not return a Pixmap");
    }

    public boolean disposePixmap() {
        throw new GdxRuntimeException((String) "This TextureData implementation does not return a Pixmap");
    }

    public FloatBuffer getBuffer() {
        return this.buffer;
    }

    public Format getFormat() {
        return Format.RGBA8888;
    }

    public int getHeight() {
        return this.height;
    }

    public TextureDataType getType() {
        return TextureDataType.Custom;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isManaged() {
        return true;
    }

    public boolean isPrepared() {
        return this.isPrepared;
    }

    public void prepare() {
        if (!this.isPrepared) {
            if (!this.isGpuOnly) {
                int i = 4;
                if (((AndroidGraphics) k.graphics).glVersion.getType().equals(Type.OpenGL)) {
                    if (this.internalFormat != 34842) {
                    }
                    int i2 = this.internalFormat;
                    if (i2 == 34843 || i2 == 34837) {
                        i = 3;
                    }
                    int i3 = this.internalFormat;
                    if (i3 == 33327 || i3 == 33328) {
                        i = 2;
                    }
                    int i4 = this.internalFormat;
                    if (i4 == 33325 || i4 == 33326) {
                        i = 1;
                    }
                }
                this.buffer = BufferUtils.newFloatBuffer(this.width * this.height * i);
            }
            this.isPrepared = true;
            return;
        }
        throw new GdxRuntimeException((String) "Already prepared");
    }

    public boolean useMipMaps() {
        return false;
    }
}
