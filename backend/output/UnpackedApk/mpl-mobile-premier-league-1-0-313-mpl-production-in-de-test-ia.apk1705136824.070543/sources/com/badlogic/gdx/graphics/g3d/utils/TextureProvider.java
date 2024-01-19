package com.badlogic.gdx.graphics.g3d.utils;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;

public interface TextureProvider {

    public static class AssetTextureProvider implements TextureProvider {
        public final AssetManager assetManager;

        public AssetTextureProvider(AssetManager assetManager2) {
            this.assetManager = assetManager2;
        }

        public Texture load(String str) {
            throw null;
        }
    }

    public static class FileTextureProvider implements TextureProvider {
        public TextureFilter magFilter;
        public TextureFilter minFilter;
        public TextureWrap uWrap;
        public boolean useMipMaps;
        public TextureWrap vWrap;

        public FileTextureProvider() {
            TextureFilter textureFilter = TextureFilter.Linear;
            this.magFilter = textureFilter;
            this.minFilter = textureFilter;
            TextureWrap textureWrap = TextureWrap.Repeat;
            this.vWrap = textureWrap;
            this.uWrap = textureWrap;
            this.useMipMaps = false;
        }

        public Texture load(String str) {
            Texture texture = new Texture(k.files.internal(str), this.useMipMaps);
            texture.setFilter(this.minFilter, this.magFilter);
            texture.setWrap(this.uWrap, this.vWrap);
            return texture;
        }

        public FileTextureProvider(TextureFilter textureFilter, TextureFilter textureFilter2, TextureWrap textureWrap, TextureWrap textureWrap2, boolean z) {
            this.minFilter = textureFilter;
            this.magFilter = textureFilter2;
            this.uWrap = textureWrap;
            this.vWrap = textureWrap2;
            this.useMipMaps = z;
        }
    }

    Texture load(String str);
}
