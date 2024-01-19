package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.shaders.DepthShader;
import com.badlogic.gdx.graphics.g3d.shaders.DepthShader.Config;

public class DepthShaderProvider extends BaseShaderProvider {
    public final Config config;

    public DepthShaderProvider(Config config2) {
        this.config = config2 == null ? new Config() : config2;
    }

    public Shader createShader(Renderable renderable) {
        return new DepthShader(renderable, this.config);
    }

    public DepthShaderProvider(String str, String str2) {
        this(new Config(str, str2));
    }

    public DepthShaderProvider(FileHandle fileHandle, FileHandle fileHandle2) {
        this(fileHandle.readString(), fileHandle2.readString());
    }

    public DepthShaderProvider() {
        this(null);
    }
}
