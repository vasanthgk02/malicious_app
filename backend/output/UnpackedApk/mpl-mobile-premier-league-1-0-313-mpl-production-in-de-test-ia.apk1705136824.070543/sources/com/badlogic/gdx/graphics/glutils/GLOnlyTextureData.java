package com.badlogic.gdx.graphics.glutils;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.TextureData.TextureDataType;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class GLOnlyTextureData implements TextureData {
    public int format;
    public int height = 0;
    public int internalFormat;
    public boolean isPrepared = false;
    public int mipLevel = 0;
    public int type;
    public int width = 0;

    public GLOnlyTextureData(int i, int i2, int i3, int i4, int i5, int i6) {
        this.width = i;
        this.height = i2;
        this.mipLevel = i3;
        this.internalFormat = i4;
        this.format = i5;
        this.type = i6;
    }

    public void consumeCustomData(int i) {
        k.gl.glTexImage2D(i, this.mipLevel, this.internalFormat, this.width, this.height, 0, this.format, this.type, null);
    }

    public Pixmap consumePixmap() {
        throw new GdxRuntimeException((String) "This TextureData implementation does not return a Pixmap");
    }

    public boolean disposePixmap() {
        throw new GdxRuntimeException((String) "This TextureData implementation does not return a Pixmap");
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
        return false;
    }

    public boolean isPrepared() {
        return this.isPrepared;
    }

    public void prepare() {
        if (!this.isPrepared) {
            this.isPrepared = true;
            return;
        }
        throw new GdxRuntimeException((String) "Already prepared");
    }

    public boolean useMipMaps() {
        return false;
    }
}
