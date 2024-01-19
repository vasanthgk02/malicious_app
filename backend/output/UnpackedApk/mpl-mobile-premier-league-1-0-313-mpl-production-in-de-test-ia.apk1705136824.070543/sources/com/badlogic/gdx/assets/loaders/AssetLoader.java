package com.badlogic.gdx.assets.loaders;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

public abstract class AssetLoader<T, P extends AssetLoaderParameters<T>> {
    public FileHandleResolver resolver;

    public AssetLoader(FileHandleResolver fileHandleResolver) {
        this.resolver = fileHandleResolver;
    }

    public abstract Array<AssetDescriptor> getDependencies(String str, FileHandle fileHandle, P p);

    public FileHandle resolve(String str) {
        if (((InternalFileHandleResolver) this.resolver) != null) {
            return k.files.internal(str);
        }
        throw null;
    }
}
