package com.badlogic.gdx.graphics.g3d.particles.renderers;

import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
import com.badlogic.gdx.graphics.g3d.particles.renderers.ParticleControllerRenderData;

public abstract class ParticleControllerRenderer<D extends ParticleControllerRenderData, T extends ParticleBatch<D>> extends ParticleControllerComponent {
    public T batch;
    public D renderData;

    public ParticleControllerRenderer() {
    }

    public abstract boolean isCompatible(ParticleBatch<?> particleBatch);

    public void set(ParticleController particleController) {
        super.set(particleController);
        D d2 = this.renderData;
        if (d2 != null) {
            d2.controller = this.controller;
        }
    }

    public boolean setBatch(ParticleBatch<?> particleBatch) {
        if (!isCompatible(particleBatch)) {
            return false;
        }
        this.batch = particleBatch;
        return true;
    }

    public void update() {
        this.batch.draw(this.renderData);
    }

    public ParticleControllerRenderer(D d2) {
        this.renderData = d2;
    }
}
