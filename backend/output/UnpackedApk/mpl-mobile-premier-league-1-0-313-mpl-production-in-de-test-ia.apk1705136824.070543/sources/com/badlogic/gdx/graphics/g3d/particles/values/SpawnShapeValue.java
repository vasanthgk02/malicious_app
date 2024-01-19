package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData.Configurable;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public abstract class SpawnShapeValue extends ParticleValue implements Configurable, Serializable {
    public RangedNumericValue xOffsetValue;
    public RangedNumericValue yOffsetValue;
    public RangedNumericValue zOffsetValue;

    public SpawnShapeValue() {
        this.xOffsetValue = new RangedNumericValue();
        this.yOffsetValue = new RangedNumericValue();
        this.zOffsetValue = new RangedNumericValue();
    }

    public abstract SpawnShapeValue copy();

    public void init() {
    }

    public void load(AssetManager assetManager, ResourceData resourceData) {
    }

    public void load(ParticleValue particleValue) {
        super.load(particleValue);
        SpawnShapeValue spawnShapeValue = (SpawnShapeValue) particleValue;
        this.xOffsetValue.load(spawnShapeValue.xOffsetValue);
        this.yOffsetValue.load(spawnShapeValue.yOffsetValue);
        this.zOffsetValue.load(spawnShapeValue.zOffsetValue);
    }

    public void read(Json json, JsonValue jsonValue) {
        Class cls = RangedNumericValue.class;
        super.read(json, jsonValue);
        this.xOffsetValue = (RangedNumericValue) json.readValue((String) "xOffsetValue", cls, jsonValue);
        this.yOffsetValue = (RangedNumericValue) json.readValue((String) "yOffsetValue", cls, jsonValue);
        this.zOffsetValue = (RangedNumericValue) json.readValue((String) "zOffsetValue", cls, jsonValue);
    }

    public void save(AssetManager assetManager, ResourceData resourceData) {
    }

    public final Vector3 spawn(Vector3 vector3, float f2) {
        spawnAux(vector3, f2);
        RangedNumericValue rangedNumericValue = this.xOffsetValue;
        if (rangedNumericValue.active) {
            vector3.x = rangedNumericValue.newLowValue() + vector3.x;
        }
        RangedNumericValue rangedNumericValue2 = this.yOffsetValue;
        if (rangedNumericValue2.active) {
            vector3.y = rangedNumericValue2.newLowValue() + vector3.y;
        }
        RangedNumericValue rangedNumericValue3 = this.zOffsetValue;
        if (rangedNumericValue3.active) {
            vector3.z = rangedNumericValue3.newLowValue() + vector3.z;
        }
        return vector3;
    }

    public abstract void spawnAux(Vector3 vector3, float f2);

    public void start() {
    }

    public void write(Json json) {
        super.write(json);
        json.writeValue("xOffsetValue", this.xOffsetValue);
        json.writeValue("yOffsetValue", this.yOffsetValue);
        json.writeValue("zOffsetValue", this.zOffsetValue);
    }

    public SpawnShapeValue(SpawnShapeValue spawnShapeValue) {
        this();
    }
}
