package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.GdxRuntimeException;

public abstract class BaseShaderProvider implements ShaderProvider {
    public Array<Shader> shaders = new Array<>();

    public abstract Shader createShader(Renderable renderable);

    public void dispose() {
        ArrayIterator it = this.shaders.iterator();
        while (it.hasNext()) {
            ((Shader) it.next()).dispose();
        }
        this.shaders.clear();
    }

    public Shader getShader(Renderable renderable) {
        Shader shader = renderable.shader;
        if (shader != null && shader.canRender(renderable)) {
            return shader;
        }
        ArrayIterator it = this.shaders.iterator();
        while (it.hasNext()) {
            Shader shader2 = (Shader) it.next();
            if (shader2.canRender(renderable)) {
                return shader2;
            }
        }
        Shader createShader = createShader(renderable);
        if (createShader.canRender(renderable)) {
            createShader.init();
            this.shaders.add(createShader);
            return createShader;
        }
        throw new GdxRuntimeException((String) "unable to provide a shader for this renderable");
    }
}
