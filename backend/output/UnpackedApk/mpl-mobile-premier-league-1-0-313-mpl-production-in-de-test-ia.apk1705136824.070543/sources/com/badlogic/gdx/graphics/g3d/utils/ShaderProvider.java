package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.utils.Disposable;

public interface ShaderProvider extends Disposable {
    /* synthetic */ void dispose();

    Shader getShader(Renderable renderable);
}
