package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData.Configurable;
import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.Disposable;

public class ParticleEffect implements Disposable, Configurable {
    public BoundingBox bounds;
    public Array<ParticleController> controllers;

    public ParticleEffect() {
        this.controllers = new Array<>(true, 3, ParticleController.class);
    }

    public ParticleEffect copy() {
        return new ParticleEffect(this);
    }

    public void dispose() {
        int i = this.controllers.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleController) this.controllers.get(i2)).dispose();
        }
    }

    public void draw() {
        int i = this.controllers.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleController) this.controllers.get(i2)).draw();
        }
    }

    public void end() {
        int i = this.controllers.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleController) this.controllers.get(i2)).end();
        }
    }

    public ParticleController findController(String str) {
        int i = this.controllers.size;
        for (int i2 = 0; i2 < i; i2++) {
            ParticleController particleController = (ParticleController) this.controllers.get(i2);
            if (particleController.name.equals(str)) {
                return particleController;
            }
        }
        return null;
    }

    public BoundingBox getBoundingBox() {
        if (this.bounds == null) {
            this.bounds = new BoundingBox();
        }
        BoundingBox boundingBox = this.bounds;
        boundingBox.inf();
        ArrayIterator it = this.controllers.iterator();
        while (it.hasNext()) {
            boundingBox.ext(((ParticleController) it.next()).getBoundingBox());
        }
        return boundingBox;
    }

    public Array<ParticleController> getControllers() {
        return this.controllers;
    }

    public void init() {
        int i = this.controllers.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleController) this.controllers.get(i2)).init();
        }
    }

    public boolean isComplete() {
        int i = this.controllers.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (!((ParticleController) this.controllers.get(i2)).isComplete()) {
                return false;
            }
        }
        return true;
    }

    public void load(AssetManager assetManager, ResourceData resourceData) {
        ArrayIterator it = this.controllers.iterator();
        while (it.hasNext()) {
            ((ParticleController) it.next()).load(assetManager, resourceData);
        }
    }

    public void reset() {
        int i = this.controllers.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleController) this.controllers.get(i2)).reset();
        }
    }

    public void rotate(Quaternion quaternion) {
        int i = this.controllers.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleController) this.controllers.get(i2)).rotate(quaternion);
        }
    }

    public void save(AssetManager assetManager, ResourceData resourceData) {
        ArrayIterator it = this.controllers.iterator();
        while (it.hasNext()) {
            ((ParticleController) it.next()).save(assetManager, resourceData);
        }
    }

    public void scale(float f2, float f3, float f4) {
        int i = this.controllers.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleController) this.controllers.get(i2)).scale(f2, f3, f4);
        }
    }

    public void setBatch(Array<ParticleBatch<?>> array) {
        ArrayIterator it = this.controllers.iterator();
        while (it.hasNext()) {
            ParticleController particleController = (ParticleController) it.next();
            ArrayIterator it2 = array.iterator();
            while (it2.hasNext()) {
                if (particleController.renderer.setBatch((ParticleBatch) it2.next())) {
                    break;
                }
            }
        }
    }

    public void setTransform(Matrix4 matrix4) {
        int i = this.controllers.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleController) this.controllers.get(i2)).setTransform(matrix4);
        }
    }

    public void start() {
        int i = this.controllers.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleController) this.controllers.get(i2)).start();
        }
    }

    public void translate(Vector3 vector3) {
        int i = this.controllers.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleController) this.controllers.get(i2)).translate(vector3);
        }
    }

    public void update() {
        int i = this.controllers.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleController) this.controllers.get(i2)).update();
        }
    }

    public ParticleEffect(ParticleEffect particleEffect) {
        this.controllers = new Array<>(true, particleEffect.controllers.size);
        int i = particleEffect.controllers.size;
        for (int i2 = 0; i2 < i; i2++) {
            this.controllers.add(((ParticleController) particleEffect.controllers.get(i2)).copy());
        }
    }

    public void rotate(Vector3 vector3, float f2) {
        int i = this.controllers.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleController) this.controllers.get(i2)).rotate(vector3, f2);
        }
    }

    public void scale(Vector3 vector3) {
        int i = this.controllers.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleController) this.controllers.get(i2)).scale(vector3.x, vector3.y, vector3.z);
        }
    }

    public void update(float f2) {
        int i = this.controllers.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleController) this.controllers.get(i2)).update(f2);
        }
    }

    public ParticleEffect(ParticleController... particleControllerArr) {
        this.controllers = new Array<>((T[]) particleControllerArr);
    }
}
