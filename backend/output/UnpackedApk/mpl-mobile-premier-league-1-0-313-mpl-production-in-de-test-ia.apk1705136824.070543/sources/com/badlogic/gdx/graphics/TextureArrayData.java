package com.badlogic.gdx.graphics;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.glutils.FileTextureArrayData;

public interface TextureArrayData {

    public static class Factory {
        public static TextureArrayData loadFromFiles(Format format, boolean z, FileHandle... fileHandleArr) {
            return new FileTextureArrayData(format, z, fileHandleArr);
        }
    }

    void consumeTextureArrayData();

    int getDepth();

    int getGLType();

    int getHeight();

    int getInternalFormat();

    int getWidth();

    boolean isManaged();

    boolean isPrepared();

    void prepare();
}
