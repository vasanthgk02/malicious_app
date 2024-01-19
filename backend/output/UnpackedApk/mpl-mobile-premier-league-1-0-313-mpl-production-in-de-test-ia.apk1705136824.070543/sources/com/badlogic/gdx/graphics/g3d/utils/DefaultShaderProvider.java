package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader;
import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Config;

public class DefaultShaderProvider extends BaseShaderProvider {
    public final Config config;

    public DefaultShaderProvider(Config config2) {
        this.config = config2 == null ? new Config() : config2;
    }

    public Shader createShader(Renderable renderable) {
        return new DefaultShader(renderable, this.config);
    }

    public DefaultShaderProvider(String str, String str2) {
        this(new Config(str, str2));
    }

    public DefaultShaderProvider(FileHandle fileHandle, FileHandle fileHandle2) {
        this(fileHandle.readString(), fileHandle2.readString());
    }

    public DefaultShaderProvider() {
        this(null);
    }
}
