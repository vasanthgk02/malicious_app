package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.ObjectChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData.SaveData;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public abstract class ParticleControllerInfluencer extends Influencer {
    public ObjectChannel<ParticleController> particleControllerChannel;
    public Array<ParticleController> templates;

    public static class Random extends ParticleControllerInfluencer {
        public ParticleControllerPool pool = new ParticleControllerPool();

        public class ParticleControllerPool extends Pool<ParticleController> {
            public ParticleControllerPool() {
            }

            public void clear() {
                int free = Random.this.pool.getFree();
                for (int i = 0; i < free; i++) {
                    ((ParticleController) Random.this.pool.obtain()).dispose();
                }
                super.clear();
            }

            public ParticleController newObject() {
                ParticleController copy = ((ParticleController) Random.this.templates.random()).copy();
                copy.init();
                return copy;
            }
        }

        public Random() {
        }

        public void activateParticles(int i, int i2) {
            int i3 = i2 + i;
            while (i < i3) {
                ParticleController particleController = (ParticleController) this.pool.obtain();
                particleController.start();
                ((ParticleController[]) this.particleControllerChannel.data)[i] = particleController;
                i++;
            }
        }

        public void dispose() {
            this.pool.clear();
            ParticleControllerInfluencer.super.dispose();
        }

        public void init() {
            this.pool.clear();
            for (int i = 0; i < this.controller.emitter.maxParticleCount; i++) {
                ParticleControllerPool particleControllerPool = this.pool;
                particleControllerPool.free(particleControllerPool.newObject());
            }
        }

        public void killParticles(int i, int i2) {
            int i3 = i2 + i;
            while (i < i3) {
                ParticleController particleController = ((ParticleController[]) this.particleControllerChannel.data)[i];
                particleController.end();
                this.pool.free(particleController);
                ((ParticleController[]) this.particleControllerChannel.data)[i] = null;
                i++;
            }
        }

        public Random copy() {
            return new Random(this);
        }

        public Random(ParticleController... particleControllerArr) {
            super(particleControllerArr);
        }

        public Random(Random random) {
            super((ParticleControllerInfluencer) random);
        }
    }

    public static class Single extends ParticleControllerInfluencer {
        public Single(ParticleController... particleControllerArr) {
            super(particleControllerArr);
        }

        public void activateParticles(int i, int i2) {
            int i3 = i2 + i;
            while (i < i3) {
                ((ParticleController[]) this.particleControllerChannel.data)[i].start();
                i++;
            }
        }

        public void init() {
            ParticleController particleController = (ParticleController) this.templates.first();
            int i = this.controller.particles.capacity;
            for (int i2 = 0; i2 < i; i2++) {
                ParticleController copy = particleController.copy();
                copy.init();
                ((ParticleController[]) this.particleControllerChannel.data)[i2] = copy;
            }
        }

        public void killParticles(int i, int i2) {
            int i3 = i2 + i;
            while (i < i3) {
                ((ParticleController[]) this.particleControllerChannel.data)[i].end();
                i++;
            }
        }

        public Single() {
        }

        public Single copy() {
            return new Single(this);
        }

        public Single(Single single) {
            super((ParticleControllerInfluencer) single);
        }
    }

    public ParticleControllerInfluencer() {
        this.templates = new Array<>(true, 1, ParticleController.class);
    }

    public void allocateChannels() {
        this.particleControllerChannel = (ObjectChannel) this.controller.particles.addChannel(ParticleChannels.ParticleController);
    }

    public void dispose() {
        if (this.controller != null) {
            for (int i = 0; i < this.controller.particles.size; i++) {
                ParticleController particleController = ((ParticleController[]) this.particleControllerChannel.data)[i];
                if (particleController != null) {
                    particleController.dispose();
                    ((ParticleController[]) this.particleControllerChannel.data)[i] = null;
                }
            }
        }
    }

    public void end() {
        for (int i = 0; i < this.controller.particles.size; i++) {
            ((ParticleController[]) this.particleControllerChannel.data)[i].end();
        }
    }

    public void load(AssetManager assetManager, ResourceData resourceData) {
        SaveData saveData = resourceData.getSaveData();
        ((Array) saveData.load("indices")).iterator();
        if (saveData.loadAsset() != null) {
            throw null;
        }
    }

    public void save(AssetManager assetManager, ResourceData resourceData) {
        resourceData.createSaveData();
        throw null;
    }

    public ParticleControllerInfluencer(ParticleController... particleControllerArr) {
        this.templates = new Array<>((T[]) particleControllerArr);
    }

    public ParticleControllerInfluencer(ParticleControllerInfluencer particleControllerInfluencer) {
        this((ParticleController[]) particleControllerInfluencer.templates.items);
    }
}
