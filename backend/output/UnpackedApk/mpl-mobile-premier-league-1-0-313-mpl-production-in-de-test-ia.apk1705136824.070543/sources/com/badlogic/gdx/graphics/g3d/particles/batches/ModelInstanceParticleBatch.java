package com.badlogic.gdx.graphics.g3d.particles.batches;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.renderers.ModelInstanceControllerRenderData;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.Pool;

public class ModelInstanceParticleBatch implements ParticleBatch<ModelInstanceControllerRenderData> {
    public int bufferedParticlesCount;
    public Array<ModelInstanceControllerRenderData> controllersRenderData = new Array<>(false, 5);

    public void begin() {
        this.controllersRenderData.clear();
        this.bufferedParticlesCount = 0;
    }

    public void end() {
    }

    public int getBufferedCount() {
        return this.bufferedParticlesCount;
    }

    public void getRenderables(Array<Renderable> array, Pool<Renderable> pool) {
        ArrayIterator it = this.controllersRenderData.iterator();
        while (it.hasNext()) {
            ModelInstanceControllerRenderData modelInstanceControllerRenderData = (ModelInstanceControllerRenderData) it.next();
            int i = modelInstanceControllerRenderData.controller.particles.size;
            for (int i2 = 0; i2 < i; i2++) {
                ((ModelInstance[]) modelInstanceControllerRenderData.modelInstanceChannel.data)[i2].getRenderables(array, pool);
            }
        }
    }

    public void load(AssetManager assetManager, ResourceData resourceData) {
    }

    public void save(AssetManager assetManager, ResourceData resourceData) {
    }

    public void draw(ModelInstanceControllerRenderData modelInstanceControllerRenderData) {
        this.controllersRenderData.add(modelInstanceControllerRenderData);
        this.bufferedParticlesCount += modelInstanceControllerRenderData.controller.particles.size;
    }
}
