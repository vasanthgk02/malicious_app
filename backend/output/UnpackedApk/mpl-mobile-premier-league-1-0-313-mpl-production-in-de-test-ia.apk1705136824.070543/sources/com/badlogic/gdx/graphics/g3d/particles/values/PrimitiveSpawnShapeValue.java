package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public abstract class PrimitiveSpawnShapeValue extends SpawnShapeValue {
    public static final Vector3 TMP_V1 = new Vector3();
    public boolean edges = false;
    public float spawnDepth;
    public float spawnDepthDiff;
    public ScaledNumericValue spawnDepthValue = new ScaledNumericValue();
    public float spawnHeight;
    public float spawnHeightDiff;
    public ScaledNumericValue spawnHeightValue = new ScaledNumericValue();
    public float spawnWidth;
    public float spawnWidthDiff;
    public ScaledNumericValue spawnWidthValue = new ScaledNumericValue();

    public enum SpawnSide {
        both,
        top,
        bottom
    }

    public PrimitiveSpawnShapeValue() {
    }

    public ScaledNumericValue getSpawnDepth() {
        return this.spawnDepthValue;
    }

    public ScaledNumericValue getSpawnHeight() {
        return this.spawnHeightValue;
    }

    public ScaledNumericValue getSpawnWidth() {
        return this.spawnWidthValue;
    }

    public boolean isEdges() {
        return this.edges;
    }

    public void load(ParticleValue particleValue) {
        super.load(particleValue);
        PrimitiveSpawnShapeValue primitiveSpawnShapeValue = (PrimitiveSpawnShapeValue) particleValue;
        this.edges = primitiveSpawnShapeValue.edges;
        this.spawnWidthValue.load(primitiveSpawnShapeValue.spawnWidthValue);
        this.spawnHeightValue.load(primitiveSpawnShapeValue.spawnHeightValue);
        this.spawnDepthValue.load(primitiveSpawnShapeValue.spawnDepthValue);
    }

    public void read(Json json, JsonValue jsonValue) {
        Class cls = ScaledNumericValue.class;
        super.read(json, jsonValue);
        this.spawnWidthValue = (ScaledNumericValue) json.readValue((String) "spawnWidthValue", cls, jsonValue);
        this.spawnHeightValue = (ScaledNumericValue) json.readValue((String) "spawnHeightValue", cls, jsonValue);
        this.spawnDepthValue = (ScaledNumericValue) json.readValue((String) "spawnDepthValue", cls, jsonValue);
        this.edges = ((Boolean) json.readValue((String) "edges", Boolean.TYPE, jsonValue)).booleanValue();
    }

    public void setActive(boolean z) {
        super.setActive(z);
        this.spawnWidthValue.setActive(true);
        this.spawnHeightValue.setActive(true);
        this.spawnDepthValue.setActive(true);
    }

    public void setDimensions(float f2, float f3, float f4) {
        this.spawnWidthValue.setHigh(f2);
        this.spawnHeightValue.setHigh(f3);
        this.spawnDepthValue.setHigh(f4);
    }

    public void setEdges(boolean z) {
        this.edges = z;
    }

    public void start() {
        this.spawnWidth = this.spawnWidthValue.newLowValue();
        this.spawnWidthDiff = this.spawnWidthValue.newHighValue();
        if (!this.spawnWidthValue.isRelative()) {
            this.spawnWidthDiff -= this.spawnWidth;
        }
        this.spawnHeight = this.spawnHeightValue.newLowValue();
        this.spawnHeightDiff = this.spawnHeightValue.newHighValue();
        if (!this.spawnHeightValue.isRelative()) {
            this.spawnHeightDiff -= this.spawnHeight;
        }
        this.spawnDepth = this.spawnDepthValue.newLowValue();
        this.spawnDepthDiff = this.spawnDepthValue.newHighValue();
        if (!this.spawnDepthValue.isRelative()) {
            this.spawnDepthDiff -= this.spawnDepth;
        }
    }

    public void write(Json json) {
        super.write(json);
        json.writeValue("spawnWidthValue", this.spawnWidthValue);
        json.writeValue("spawnHeightValue", this.spawnHeightValue);
        json.writeValue("spawnDepthValue", this.spawnDepthValue);
        json.writeValue("edges", Boolean.valueOf(this.edges));
    }

    public PrimitiveSpawnShapeValue(PrimitiveSpawnShapeValue primitiveSpawnShapeValue) {
        super(primitiveSpawnShapeValue);
    }
}
