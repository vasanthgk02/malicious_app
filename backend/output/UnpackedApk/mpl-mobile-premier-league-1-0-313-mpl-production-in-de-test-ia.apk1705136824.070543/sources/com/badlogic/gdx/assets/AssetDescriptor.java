package com.badlogic.gdx.assets;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.files.FileHandle;

public class AssetDescriptor<T> {
    public final String fileName;
    public final Class<T> type;

    public AssetDescriptor(String str, Class<T> cls) {
        this.fileName = str.replace('\\', '/');
        this.type = cls;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.fileName);
        sb.append(", ");
        return GeneratedOutlineSupport.outline35(this.type, sb);
    }

    public AssetDescriptor(String str, Class<T> cls, AssetLoaderParameters<T> assetLoaderParameters) {
        this.fileName = str.replace('\\', '/');
        this.type = cls;
    }

    public AssetDescriptor(FileHandle fileHandle, Class<T> cls) {
        this.fileName = fileHandle.path().replace('\\', '/');
        this.type = cls;
    }
}
