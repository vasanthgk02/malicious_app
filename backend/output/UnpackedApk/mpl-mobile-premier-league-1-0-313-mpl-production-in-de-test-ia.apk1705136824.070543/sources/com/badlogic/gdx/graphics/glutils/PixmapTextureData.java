package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.TextureData.TextureDataType;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class PixmapTextureData implements TextureData {
    public final boolean disposePixmap;
    public final Format format;
    public final boolean managed;
    public final Pixmap pixmap;
    public final boolean useMipMaps;

    public PixmapTextureData(Pixmap pixmap2, Format format2, boolean z, boolean z2) {
        this(pixmap2, format2, z, z2, false);
    }

    public void consumeCustomData(int i) {
        throw new GdxRuntimeException((String) "This TextureData implementation does not upload data itself");
    }

    public Pixmap consumePixmap() {
        return this.pixmap;
    }

    public boolean disposePixmap() {
        return this.disposePixmap;
    }

    public Format getFormat() {
        return this.format;
    }

    public int getHeight() {
        return this.pixmap.getHeight();
    }

    public TextureDataType getType() {
        return TextureDataType.Pixmap;
    }

    public int getWidth() {
        return this.pixmap.getWidth();
    }

    public boolean isManaged() {
        return this.managed;
    }

    public boolean isPrepared() {
        return true;
    }

    public void prepare() {
        throw new GdxRuntimeException((String) "prepare() must not be called on a PixmapTextureData instance as it is already prepared.");
    }

    public boolean useMipMaps() {
        return this.useMipMaps;
    }

    public PixmapTextureData(Pixmap pixmap2, Format format2, boolean z, boolean z2, boolean z3) {
        this.pixmap = pixmap2;
        this.format = format2 == null ? pixmap2.getFormat() : format2;
        this.useMipMaps = z;
        this.disposePixmap = z2;
        this.managed = z3;
    }
}
