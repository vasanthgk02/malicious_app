package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.RenderableProvider;
import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.Pool;

public final class ParticleSystem implements RenderableProvider {
    public static ParticleSystem instance;
    public Array<ParticleBatch<?>> batches = new Array<>();
    public Array<ParticleEffect> effects = new Array<>();

    @Deprecated
    public static ParticleSystem get() {
        if (instance == null) {
            instance = new ParticleSystem();
        }
        return instance;
    }

    public void add(ParticleBatch<?> particleBatch) {
        this.batches.add(particleBatch);
    }

    public void begin() {
        ArrayIterator it = this.batches.iterator();
        while (it.hasNext()) {
            ((ParticleBatch) it.next()).begin();
        }
    }

    public void draw() {
        ArrayIterator it = this.effects.iterator();
        while (it.hasNext()) {
            ((ParticleEffect) it.next()).draw();
        }
    }

    public void end() {
        ArrayIterator it = this.batches.iterator();
        while (it.hasNext()) {
            ((ParticleBatch) it.next()).end();
        }
    }

    public Array<ParticleBatch<?>> getBatches() {
        return this.batches;
    }

    public void getRenderables(Array<Renderable> array, Pool<Renderable> pool) {
        ArrayIterator it = this.batches.iterator();
        while (it.hasNext()) {
            ((ParticleBatch) it.next()).getRenderables(array, pool);
        }
    }

    public void remove(ParticleEffect particleEffect) {
        this.effects.removeValue(particleEffect, true);
    }

    public void removeAll() {
        this.effects.clear();
    }

    public void update() {
        ArrayIterator it = this.effects.iterator();
        while (it.hasNext()) {
            ((ParticleEffect) it.next()).update();
        }
    }

    public void updateAndDraw() {
        ArrayIterator it = this.effects.iterator();
        while (it.hasNext()) {
            ParticleEffect particleEffect = (ParticleEffect) it.next();
            particleEffect.update();
            particleEffect.draw();
        }
    }

    public void add(ParticleEffect particleEffect) {
        this.effects.add(particleEffect);
    }

    public void update(float f2) {
        ArrayIterator it = this.effects.iterator();
        while (it.hasNext()) {
            ((ParticleEffect) it.next()).update(f2);
        }
    }

    public void updateAndDraw(float f2) {
        ArrayIterator it = this.effects.iterator();
        while (it.hasNext()) {
            ParticleEffect particleEffect = (ParticleEffect) it.next();
            particleEffect.update(f2);
            particleEffect.draw();
        }
    }
}
