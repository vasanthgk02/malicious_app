package com.badlogic.gdx.graphics.glutils;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.TextureData.TextureDataType;
import com.badlogic.gdx.graphics.glutils.ETC1.ETC1Data;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class ETC1TextureData implements TextureData {
    public ETC1Data data;
    public FileHandle file;
    public int height;
    public boolean isPrepared;
    public boolean useMipMaps;
    public int width;

    public ETC1TextureData(FileHandle fileHandle) {
        this(fileHandle, false);
    }

    public void consumeCustomData(int i) {
        if (this.isPrepared) {
            if (!((AndroidGraphics) k.graphics).supportsExtension("GL_OES_compressed_ETC1_RGB8_texture")) {
                Pixmap decodeImage = ETC1.decodeImage(this.data, Format.RGB565);
                k.gl.glTexImage2D(i, 0, decodeImage.getGLInternalFormat(), decodeImage.getWidth(), decodeImage.getHeight(), 0, decodeImage.getGLFormat(), decodeImage.getGLType(), decodeImage.getPixels());
                if (this.useMipMaps) {
                    MipMapGenerator.generateMipMap(i, decodeImage, decodeImage.getWidth(), decodeImage.getHeight());
                }
                decodeImage.dispose();
                this.useMipMaps = false;
            } else {
                GL20 gl20 = k.gl;
                int i2 = ETC1.ETC1_RGB8_OES;
                int i3 = this.width;
                int i4 = this.height;
                int capacity = this.data.compressedData.capacity();
                ETC1Data eTC1Data = this.data;
                gl20.glCompressedTexImage2D(i, 0, i2, i3, i4, 0, capacity - eTC1Data.dataOffset, eTC1Data.compressedData);
                if (useMipMaps()) {
                    k.gl20.glGenerateMipmap(GL20.GL_TEXTURE_2D);
                }
            }
            this.data.dispose();
            this.data = null;
            this.isPrepared = false;
            return;
        }
        throw new GdxRuntimeException((String) "Call prepare() before calling consumeCompressedData()");
    }

    public Pixmap consumePixmap() {
        throw new GdxRuntimeException((String) "This TextureData implementation does not return a Pixmap");
    }

    public boolean disposePixmap() {
        throw new GdxRuntimeException((String) "This TextureData implementation does not return a Pixmap");
    }

    public Format getFormat() {
        return Format.RGB565;
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
        if (this.isPrepared) {
            throw new GdxRuntimeException((String) "Already prepared");
        } else if (this.file == null && this.data == null) {
            throw new GdxRuntimeException((String) "Can only load once from ETC1Data");
        } else {
            FileHandle fileHandle = this.file;
            if (fileHandle != null) {
                this.data = new ETC1Data(fileHandle);
            }
            ETC1Data eTC1Data = this.data;
            this.width = eTC1Data.width;
            this.height = eTC1Data.height;
            this.isPrepared = true;
        }
    }

    public boolean useMipMaps() {
        return this.useMipMaps;
    }

    public ETC1TextureData(FileHandle fileHandle, boolean z) {
        this.width = 0;
        this.height = 0;
        this.isPrepared = false;
        this.file = fileHandle;
        this.useMipMaps = z;
    }

    public ETC1TextureData(ETC1Data eTC1Data, boolean z) {
        this.width = 0;
        this.height = 0;
        this.isPrepared = false;
        this.data = eTC1Data;
        this.useMipMaps = z;
    }
}
