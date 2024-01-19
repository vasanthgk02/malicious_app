package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.TextureData.TextureDataType;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class MipMapTextureData implements TextureData {
    public TextureData[] mips;

    public MipMapTextureData(TextureData... textureDataArr) {
        TextureData[] textureDataArr2 = new TextureData[textureDataArr.length];
        this.mips = textureDataArr2;
        System.arraycopy(textureDataArr, 0, textureDataArr2, 0, textureDataArr.length);
    }

    public void consumeCustomData(int i) {
        int i2 = 0;
        while (true) {
            TextureData[] textureDataArr = this.mips;
            if (i2 < textureDataArr.length) {
                GLTexture.uploadImageData(i, textureDataArr[i2], i2);
                i2++;
            } else {
                return;
            }
        }
    }

    public Pixmap consumePixmap() {
        throw new GdxRuntimeException((String) "It's compressed, use the compressed method");
    }

    public boolean disposePixmap() {
        return false;
    }

    public Format getFormat() {
        return this.mips[0].getFormat();
    }

    public int getHeight() {
        return this.mips[0].getHeight();
    }

    public TextureDataType getType() {
        return TextureDataType.Custom;
    }

    public int getWidth() {
        return this.mips[0].getWidth();
    }

    public boolean isManaged() {
        return true;
    }

    public boolean isPrepared() {
        return true;
    }

    public void prepare() {
    }

    public boolean useMipMaps() {
        return false;
    }
}
