package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.TextureData.TextureDataType;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class FileTextureData implements TextureData {
    public final FileHandle file;
    public Format format;
    public int height = 0;
    public boolean isPrepared = false;
    public Pixmap pixmap;
    public boolean useMipMaps;
    public int width = 0;

    public FileTextureData(FileHandle fileHandle, Pixmap pixmap2, Format format2, boolean z) {
        this.file = fileHandle;
        this.pixmap = pixmap2;
        this.format = format2;
        this.useMipMaps = z;
        if (pixmap2 != null) {
            this.width = pixmap2.getWidth();
            this.height = this.pixmap.getHeight();
            if (format2 == null) {
                this.format = this.pixmap.getFormat();
            }
        }
    }

    public void consumeCustomData(int i) {
        throw new GdxRuntimeException((String) "This TextureData implementation does not upload data itself");
    }

    public Pixmap consumePixmap() {
        if (this.isPrepared) {
            this.isPrepared = false;
            Pixmap pixmap2 = this.pixmap;
            this.pixmap = null;
            return pixmap2;
        }
        throw new GdxRuntimeException((String) "Call prepare() before calling getPixmap()");
    }

    public boolean disposePixmap() {
        return true;
    }

    public FileHandle getFileHandle() {
        return this.file;
    }

    public Format getFormat() {
        return this.format;
    }

    public int getHeight() {
        return this.height;
    }

    public TextureDataType getType() {
        return TextureDataType.Pixmap;
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
            if (this.pixmap == null) {
                if (this.file.extension().equals("cim")) {
                    this.pixmap = PixmapIO.readCIM(this.file);
                } else {
                    this.pixmap = new Pixmap(this.file);
                }
                this.width = this.pixmap.getWidth();
                this.height = this.pixmap.getHeight();
                if (this.format == null) {
                    this.format = this.pixmap.getFormat();
                }
            }
            this.isPrepared = true;
            return;
        }
        throw new GdxRuntimeException((String) "Already prepared");
    }

    public String toString() {
        return this.file.toString();
    }

    public boolean useMipMaps() {
        return this.useMipMaps;
    }
}
