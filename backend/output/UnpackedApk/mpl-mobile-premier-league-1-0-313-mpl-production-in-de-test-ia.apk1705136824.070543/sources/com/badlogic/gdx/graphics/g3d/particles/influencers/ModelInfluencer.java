package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.ObjectChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.Pool;

public abstract class ModelInfluencer extends Influencer {
    public ObjectChannel<ModelInstance> modelChannel;
    public Array<Model> models;

    public static class Random extends ModelInfluencer {
        public ModelInstancePool pool = new ModelInstancePool();

        public class ModelInstancePool extends Pool<ModelInstance> {
            public ModelInstancePool() {
            }

            public ModelInstance newObject() {
                return new ModelInstance((Model) Random.this.models.random());
            }
        }

        public Random() {
        }

        public void activateParticles(int i, int i2) {
            int i3 = i2 + i;
            while (i < i3) {
                ((ModelInstance[]) this.modelChannel.data)[i] = (ModelInstance) this.pool.obtain();
                i++;
            }
        }

        public void init() {
            this.pool.clear();
        }

        public void killParticles(int i, int i2) {
            int i3 = i2 + i;
            while (i < i3) {
                this.pool.free(((ModelInstance[]) this.modelChannel.data)[i]);
                ((ModelInstance[]) this.modelChannel.data)[i] = null;
                i++;
            }
        }

        public Random copy() {
            return new Random(this);
        }

        public Random(Random random) {
            super((ModelInfluencer) random);
        }

        public Random(Model... modelArr) {
            super(modelArr);
        }
    }

    public static class Single extends ModelInfluencer {
        public Single() {
        }

        public void init() {
            Model model = (Model) this.models.first();
            int i = this.controller.emitter.maxParticleCount;
            for (int i2 = 0; i2 < i; i2++) {
                ((ModelInstance[]) this.modelChannel.data)[i2] = new ModelInstance(model);
            }
        }

        public Single(Single single) {
            super((ModelInfluencer) single);
        }

        public Single copy() {
            return new Single(this);
        }

        public Single(Model... modelArr) {
            super(modelArr);
        }
    }

    public ModelInfluencer() {
        this.models = new Array<>(true, 1, Model.class);
    }

    public void allocateChannels() {
        this.modelChannel = (ObjectChannel) this.controller.particles.addChannel(ParticleChannels.ModelInstance);
    }

    public void load(AssetManager assetManager, ResourceData resourceData) {
        if (resourceData.getSaveData().loadAsset() != null) {
            throw null;
        }
    }

    public void save(AssetManager assetManager, ResourceData resourceData) {
        resourceData.createSaveData();
        ArrayIterator it = this.models.iterator();
        if (it.hasNext()) {
            Model model = (Model) it.next();
            throw null;
        }
    }

    public ModelInfluencer(Model... modelArr) {
        this.models = new Array<>((T[]) modelArr);
    }

    public ModelInfluencer(ModelInfluencer modelInfluencer) {
        this((Model[]) modelInfluencer.models.toArray(Model.class));
    }
}
