package com.badlogic.gdx.graphics.g3d.particles.renderers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.ObjectChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class ParticleControllerControllerRenderer extends ParticleControllerRenderer {
    public ObjectChannel<ParticleController> controllerChannel;

    public ParticleControllerComponent copy() {
        return new ParticleControllerControllerRenderer();
    }

    public void init() {
        ObjectChannel<ParticleController> objectChannel = (ObjectChannel) this.controller.particles.getChannel(ParticleChannels.ParticleController);
        this.controllerChannel = objectChannel;
        if (objectChannel == null) {
            throw new GdxRuntimeException((String) "ParticleController channel not found, specify an influencer which will allocate it please.");
        }
    }

    public boolean isCompatible(ParticleBatch particleBatch) {
        return false;
    }

    public void update() {
        int i = this.controller.particles.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleController[]) this.controllerChannel.data)[i2].draw();
        }
    }
}
