package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData.Configurable;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public abstract class ParticleControllerComponent implements Disposable, Serializable, Configurable {
    public static final Matrix3 TMP_M3 = new Matrix3();
    public static final Matrix4 TMP_M4 = new Matrix4();
    public static final Quaternion TMP_Q = new Quaternion();
    public static final Quaternion TMP_Q2 = new Quaternion();
    public static final Vector3 TMP_V1 = new Vector3();
    public static final Vector3 TMP_V2 = new Vector3();
    public static final Vector3 TMP_V3 = new Vector3();
    public static final Vector3 TMP_V4 = new Vector3();
    public static final Vector3 TMP_V5 = new Vector3();
    public static final Vector3 TMP_V6 = new Vector3();
    public ParticleController controller;

    public void activateParticles(int i, int i2) {
    }

    public void allocateChannels() {
    }

    public abstract ParticleControllerComponent copy();

    public void dispose() {
    }

    public void end() {
    }

    public void init() {
    }

    public void killParticles(int i, int i2) {
    }

    public void load(AssetManager assetManager, ResourceData resourceData) {
    }

    public void read(Json json, JsonValue jsonValue) {
    }

    public void save(AssetManager assetManager, ResourceData resourceData) {
    }

    public void set(ParticleController particleController) {
        this.controller = particleController;
    }

    public void start() {
    }

    public void update() {
    }

    public void write(Json json) {
    }
}
