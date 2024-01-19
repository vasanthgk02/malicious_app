package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;

public class TextureLoader$TextureParameter extends AssetLoaderParameters<Texture> {
    public TextureLoader$TextureParameter() {
        TextureFilter textureFilter = TextureFilter.Nearest;
        TextureWrap textureWrap = TextureWrap.ClampToEdge;
    }
}
