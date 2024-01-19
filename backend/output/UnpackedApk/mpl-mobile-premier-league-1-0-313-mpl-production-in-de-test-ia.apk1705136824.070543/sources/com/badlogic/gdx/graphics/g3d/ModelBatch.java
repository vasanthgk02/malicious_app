package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.utils.DefaultRenderableSorter;
import com.badlogic.gdx.graphics.g3d.utils.DefaultShaderProvider;
import com.badlogic.gdx.graphics.g3d.utils.DefaultTextureBinder;
import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
import com.badlogic.gdx.graphics.g3d.utils.RenderableSorter;
import com.badlogic.gdx.graphics.g3d.utils.ShaderProvider;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.FlushablePool;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class ModelBatch implements Disposable {
    public Camera camera;
    public final RenderContext context;
    public final boolean ownContext;
    public final Array<Renderable> renderables;
    public final RenderablePool renderablesPool;
    public final ShaderProvider shaderProvider;
    public final RenderableSorter sorter;

    public static class RenderablePool extends FlushablePool<Renderable> {
        public Renderable newObject() {
            return new Renderable();
        }

        public Renderable obtain() {
            Renderable renderable = (Renderable) super.obtain();
            renderable.environment = null;
            renderable.material = null;
            renderable.meshPart.set("", null, 0, 0, 0);
            renderable.shader = null;
            renderable.userData = null;
            return renderable;
        }
    }

    public ModelBatch(RenderContext renderContext, ShaderProvider shaderProvider2, RenderableSorter renderableSorter) {
        this.renderablesPool = new RenderablePool();
        this.renderables = new Array<>();
        this.sorter = renderableSorter == null ? new DefaultRenderableSorter() : renderableSorter;
        this.ownContext = renderContext == null;
        this.context = renderContext == null ? new RenderContext(new DefaultTextureBinder(1, 1)) : renderContext;
        this.shaderProvider = shaderProvider2 == null ? new DefaultShaderProvider() : shaderProvider2;
    }

    public void begin(Camera camera2) {
        if (this.camera == null) {
            this.camera = camera2;
            if (this.ownContext) {
                this.context.begin();
                return;
            }
            return;
        }
        throw new GdxRuntimeException((String) "Call end() first.");
    }

    public void dispose() {
        this.shaderProvider.dispose();
    }

    public void end() {
        flush();
        if (this.ownContext) {
            this.context.end();
        }
        this.camera = null;
    }

    public void flush() {
        this.sorter.sort(this.camera, this.renderables);
        Shader shader = null;
        int i = 0;
        while (true) {
            Array<Renderable> array = this.renderables;
            if (i >= array.size) {
                break;
            }
            Renderable renderable = (Renderable) array.get(i);
            if (shader != renderable.shader) {
                if (shader != null) {
                    shader.end();
                }
                shader = renderable.shader;
                shader.begin(this.camera, this.context);
            }
            shader.render(renderable);
            i++;
        }
        if (shader != null) {
            shader.end();
        }
        this.renderablesPool.flush();
        this.renderables.clear();
    }

    public Camera getCamera() {
        return this.camera;
    }

    public RenderContext getRenderContext() {
        return this.context;
    }

    public RenderableSorter getRenderableSorter() {
        return this.sorter;
    }

    public ShaderProvider getShaderProvider() {
        return this.shaderProvider;
    }

    public boolean ownsRenderContext() {
        return this.ownContext;
    }

    public void render(Renderable renderable) {
        renderable.shader = this.shaderProvider.getShader(renderable);
        this.renderables.add(renderable);
    }

    public void setCamera(Camera camera2) {
        if (this.camera != null) {
            if (this.renderables.size > 0) {
                flush();
            }
            this.camera = camera2;
            return;
        }
        throw new GdxRuntimeException((String) "Call begin() first.");
    }

    public void render(RenderableProvider renderableProvider) {
        Array<Renderable> array = this.renderables;
        int i = array.size;
        renderableProvider.getRenderables(array, this.renderablesPool);
        while (true) {
            Array<Renderable> array2 = this.renderables;
            if (i < array2.size) {
                Renderable renderable = (Renderable) array2.get(i);
                renderable.shader = this.shaderProvider.getShader(renderable);
                i++;
            } else {
                return;
            }
        }
    }

    public ModelBatch(RenderContext renderContext, ShaderProvider shaderProvider2) {
        this(renderContext, shaderProvider2, null);
    }

    public <T extends RenderableProvider> void render(Iterable<T> iterable) {
        for (T render : iterable) {
            render((RenderableProvider) render);
        }
    }

    public ModelBatch(RenderContext renderContext, RenderableSorter renderableSorter) {
        this(renderContext, null, renderableSorter);
    }

    public ModelBatch(RenderContext renderContext) {
        this(renderContext, null, null);
    }

    public void render(RenderableProvider renderableProvider, Environment environment) {
        Array<Renderable> array = this.renderables;
        int i = array.size;
        renderableProvider.getRenderables(array, this.renderablesPool);
        while (true) {
            Array<Renderable> array2 = this.renderables;
            if (i < array2.size) {
                Renderable renderable = (Renderable) array2.get(i);
                renderable.environment = environment;
                renderable.shader = this.shaderProvider.getShader(renderable);
                i++;
            } else {
                return;
            }
        }
    }

    public ModelBatch(ShaderProvider shaderProvider2, RenderableSorter renderableSorter) {
        this(null, shaderProvider2, renderableSorter);
    }

    public ModelBatch(RenderableSorter renderableSorter) {
        this(null, null, renderableSorter);
    }

    public ModelBatch(ShaderProvider shaderProvider2) {
        this(null, shaderProvider2, null);
    }

    public ModelBatch(FileHandle fileHandle, FileHandle fileHandle2) {
        this(null, new DefaultShaderProvider(fileHandle, fileHandle2), null);
    }

    public ModelBatch(String str, String str2) {
        this(null, new DefaultShaderProvider(str, str2), null);
    }

    public ModelBatch() {
        this(null, null, null);
    }

    public <T extends RenderableProvider> void render(Iterable<T> iterable, Environment environment) {
        for (T render : iterable) {
            render((RenderableProvider) render, environment);
        }
    }

    public void render(RenderableProvider renderableProvider, Shader shader) {
        Array<Renderable> array = this.renderables;
        int i = array.size;
        renderableProvider.getRenderables(array, this.renderablesPool);
        while (true) {
            Array<Renderable> array2 = this.renderables;
            if (i < array2.size) {
                Renderable renderable = (Renderable) array2.get(i);
                renderable.shader = shader;
                renderable.shader = this.shaderProvider.getShader(renderable);
                i++;
            } else {
                return;
            }
        }
    }

    public <T extends RenderableProvider> void render(Iterable<T> iterable, Shader shader) {
        for (T render : iterable) {
            render((RenderableProvider) render, shader);
        }
    }

    public void render(RenderableProvider renderableProvider, Environment environment, Shader shader) {
        Array<Renderable> array = this.renderables;
        int i = array.size;
        renderableProvider.getRenderables(array, this.renderablesPool);
        while (true) {
            Array<Renderable> array2 = this.renderables;
            if (i < array2.size) {
                Renderable renderable = (Renderable) array2.get(i);
                renderable.environment = environment;
                renderable.shader = shader;
                renderable.shader = this.shaderProvider.getShader(renderable);
                i++;
            } else {
                return;
            }
        }
    }

    public <T extends RenderableProvider> void render(Iterable<T> iterable, Environment environment, Shader shader) {
        for (T render : iterable) {
            render((RenderableProvider) render, environment, shader);
        }
    }
}
