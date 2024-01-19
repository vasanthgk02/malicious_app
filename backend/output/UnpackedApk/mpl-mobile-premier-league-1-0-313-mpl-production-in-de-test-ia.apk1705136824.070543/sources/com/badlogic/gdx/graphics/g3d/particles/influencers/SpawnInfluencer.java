package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.values.PointSpawnShapeValue;
import com.badlogic.gdx.graphics.g3d.particles.values.SpawnShapeValue;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class SpawnInfluencer extends Influencer {
    public FloatChannel positionChannel;
    public FloatChannel rotationChannel;
    public SpawnShapeValue spawnShapeValue;

    public SpawnInfluencer() {
        this.spawnShapeValue = new PointSpawnShapeValue();
    }

    public void activateParticles(int i, int i2) {
        int i3 = this.positionChannel.strideSize;
        int i4 = i * i3;
        int i5 = (i3 * i2) + i4;
        while (i4 < i5) {
            this.spawnShapeValue.spawn(ParticleControllerComponent.TMP_V1, this.controller.emitter.percent);
            ParticleControllerComponent.TMP_V1.mul(this.controller.transform);
            FloatChannel floatChannel = this.positionChannel;
            float[] fArr = floatChannel.data;
            Vector3 vector3 = ParticleControllerComponent.TMP_V1;
            fArr[i4 + 0] = vector3.x;
            fArr[i4 + 1] = vector3.y;
            fArr[i4 + 2] = vector3.z;
            i4 += floatChannel.strideSize;
        }
        int i6 = this.rotationChannel.strideSize;
        int i7 = i * i6;
        int i8 = (i2 * i6) + i7;
        while (i7 < i8) {
            this.controller.transform.getRotation(ParticleControllerComponent.TMP_Q, true);
            FloatChannel floatChannel2 = this.rotationChannel;
            float[] fArr2 = floatChannel2.data;
            Quaternion quaternion = ParticleControllerComponent.TMP_Q;
            fArr2[i7 + 0] = quaternion.x;
            fArr2[i7 + 1] = quaternion.y;
            fArr2[i7 + 2] = quaternion.z;
            fArr2[i7 + 3] = quaternion.w;
            i7 += floatChannel2.strideSize;
        }
    }

    public void allocateChannels() {
        this.positionChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Position);
        this.rotationChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Rotation3D);
    }

    public void init() {
        this.spawnShapeValue.init();
    }

    public void load(AssetManager assetManager, ResourceData resourceData) {
        this.spawnShapeValue.load(assetManager, resourceData);
    }

    public void read(Json json, JsonValue jsonValue) {
        this.spawnShapeValue = (SpawnShapeValue) json.readValue((String) "spawnShape", SpawnShapeValue.class, jsonValue);
    }

    public void save(AssetManager assetManager, ResourceData resourceData) {
        this.spawnShapeValue.save(assetManager, resourceData);
    }

    public void start() {
        this.spawnShapeValue.start();
    }

    public void write(Json json) {
        json.writeValue((String) "spawnShape", (Object) this.spawnShapeValue, SpawnShapeValue.class);
    }

    public SpawnInfluencer copy() {
        return new SpawnInfluencer(this);
    }

    public SpawnInfluencer(SpawnShapeValue spawnShapeValue2) {
        this.spawnShapeValue = spawnShapeValue2;
    }

    public SpawnInfluencer(SpawnInfluencer spawnInfluencer) {
        this.spawnShapeValue = spawnInfluencer.spawnShapeValue.copy();
    }
}
