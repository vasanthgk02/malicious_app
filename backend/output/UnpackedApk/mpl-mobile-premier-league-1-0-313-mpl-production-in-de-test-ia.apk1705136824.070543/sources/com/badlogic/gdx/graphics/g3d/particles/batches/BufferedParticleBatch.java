package com.badlogic.gdx.graphics.g3d.particles.batches;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.particles.ParticleSorter;
import com.badlogic.gdx.graphics.g3d.particles.ParticleSorter.Distance;
import com.badlogic.gdx.graphics.g3d.particles.renderers.ParticleControllerRenderData;
import com.badlogic.gdx.utils.Array;

public abstract class BufferedParticleBatch<T extends ParticleControllerRenderData> implements ParticleBatch<T> {
    public int bufferedParticlesCount;
    public Camera camera;
    public int currentCapacity = 0;
    public Array<T> renderData;
    public ParticleSorter sorter = new Distance();

    public BufferedParticleBatch(Class<T> cls) {
        this.renderData = new Array<>(false, 10, cls);
    }

    public abstract void allocParticlesData(int i);

    public void begin() {
        this.renderData.clear();
        this.bufferedParticlesCount = 0;
    }

    public void draw(T t) {
        if (t.controller.particles.size > 0) {
            this.renderData.add(t);
            this.bufferedParticlesCount += t.controller.particles.size;
        }
    }

    public void end() {
        int i = this.bufferedParticlesCount;
        if (i > 0) {
            ensureCapacity(i);
            flush(this.sorter.sort(this.renderData));
        }
    }

    public void ensureCapacity(int i) {
        if (this.currentCapacity < i) {
            this.sorter.ensureCapacity(i);
            allocParticlesData(i);
            this.currentCapacity = i;
        }
    }

    public abstract void flush(int[] iArr);

    public int getBufferedCount() {
        return this.bufferedParticlesCount;
    }

    public ParticleSorter getSorter() {
        return this.sorter;
    }

    public void resetCapacity() {
        this.bufferedParticlesCount = 0;
        this.currentCapacity = 0;
    }

    public void setCamera(Camera camera2) {
        this.camera = camera2;
        this.sorter.setCamera(camera2);
    }

    public void setSorter(ParticleSorter particleSorter) {
        this.sorter = particleSorter;
        particleSorter.setCamera(this.camera);
        particleSorter.ensureCapacity(this.currentCapacity);
    }
}
