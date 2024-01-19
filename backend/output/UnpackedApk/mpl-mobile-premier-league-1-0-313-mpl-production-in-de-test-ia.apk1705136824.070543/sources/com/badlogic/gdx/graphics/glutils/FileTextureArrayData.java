package com.badlogic.gdx.graphics.glutils;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Blending;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.TextureArrayData;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.TextureData.Factory;
import com.badlogic.gdx.graphics.TextureData.TextureDataType;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.Buffer;

public class FileTextureArrayData implements TextureArrayData {
    public int depth;
    public Format format;
    public boolean prepared;
    public TextureData[] textureDatas;
    public boolean useMipMaps;

    public FileTextureArrayData(Format format2, boolean z, FileHandle[] fileHandleArr) {
        this.format = format2;
        this.useMipMaps = z;
        this.depth = fileHandleArr.length;
        this.textureDatas = new TextureData[fileHandleArr.length];
        for (int i = 0; i < fileHandleArr.length; i++) {
            this.textureDatas[i] = Factory.loadFromFile(fileHandleArr[i], format2, z);
        }
    }

    public void consumeTextureArrayData() {
        Pixmap pixmap;
        boolean z;
        int i = 0;
        while (true) {
            TextureData[] textureDataArr = this.textureDatas;
            if (i < textureDataArr.length) {
                if (textureDataArr[i].getType() == TextureDataType.Custom) {
                    this.textureDatas[i].consumeCustomData(GL30.GL_TEXTURE_2D_ARRAY);
                } else {
                    TextureData textureData = this.textureDatas[i];
                    Pixmap consumePixmap = textureData.consumePixmap();
                    boolean disposePixmap = textureData.disposePixmap();
                    if (textureData.getFormat() != consumePixmap.getFormat()) {
                        Pixmap pixmap2 = new Pixmap(consumePixmap.getWidth(), consumePixmap.getHeight(), textureData.getFormat());
                        pixmap2.setBlending(Blending.None);
                        pixmap2.drawPixmap(consumePixmap, 0, 0, 0, 0, consumePixmap.getWidth(), consumePixmap.getHeight());
                        if (textureData.disposePixmap()) {
                            consumePixmap.dispose();
                        }
                        pixmap = pixmap2;
                        z = true;
                    } else {
                        z = disposePixmap;
                        pixmap = consumePixmap;
                    }
                    k.gl30.glTexSubImage3D((int) GL30.GL_TEXTURE_2D_ARRAY, 0, 0, 0, i, pixmap.getWidth(), pixmap.getHeight(), 1, pixmap.getGLInternalFormat(), pixmap.getGLType(), (Buffer) pixmap.getPixels());
                    if (this.useMipMaps) {
                        k.gl20.glGenerateMipmap(GL30.GL_TEXTURE_2D_ARRAY);
                    }
                    if (z) {
                        pixmap.dispose();
                    }
                }
                i++;
            } else {
                return;
            }
        }
    }

    public int getDepth() {
        return this.depth;
    }

    public int getGLType() {
        return Format.toGlType(this.format);
    }

    public int getHeight() {
        return this.textureDatas[0].getHeight();
    }

    public int getInternalFormat() {
        return Format.toGlFormat(this.format);
    }

    public int getWidth() {
        return this.textureDatas[0].getWidth();
    }

    public boolean isManaged() {
        for (TextureData isManaged : this.textureDatas) {
            if (!isManaged.isManaged()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrepared() {
        return this.prepared;
    }

    public void prepare() {
        int i = -1;
        int i2 = -1;
        for (TextureData textureData : this.textureDatas) {
            textureData.prepare();
            if (i == -1) {
                i = textureData.getWidth();
                i2 = textureData.getHeight();
            } else if (i != textureData.getWidth() || i2 != textureData.getHeight()) {
                throw new GdxRuntimeException((String) "Error whilst preparing TextureArray: TextureArray Textures must have equal dimensions.");
            }
        }
        this.prepared = true;
    }
}
