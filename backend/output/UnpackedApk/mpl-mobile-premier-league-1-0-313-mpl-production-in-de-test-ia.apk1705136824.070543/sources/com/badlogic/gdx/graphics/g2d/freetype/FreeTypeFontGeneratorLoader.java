package com.badlogic.gdx.graphics.g2d.freetype;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

public class FreeTypeFontGeneratorLoader extends SynchronousAssetLoader<FreeTypeFontGenerator, FreeTypeFontGeneratorParameters> {

    public static class FreeTypeFontGeneratorParameters extends AssetLoaderParameters<FreeTypeFontGenerator> {
    }

    public FreeTypeFontGeneratorLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    public Array<AssetDescriptor> getDependencies(String str, FileHandle fileHandle, FreeTypeFontGeneratorParameters freeTypeFontGeneratorParameters) {
        return null;
    }

    public FreeTypeFontGenerator load(AssetManager assetManager, String str, FileHandle fileHandle, FreeTypeFontGeneratorParameters freeTypeFontGeneratorParameters) {
        if (fileHandle.extension().equals("gen")) {
            return new FreeTypeFontGenerator(fileHandle.sibling(fileHandle.nameWithoutExtension()));
        }
        return new FreeTypeFontGenerator(fileHandle);
    }
}
