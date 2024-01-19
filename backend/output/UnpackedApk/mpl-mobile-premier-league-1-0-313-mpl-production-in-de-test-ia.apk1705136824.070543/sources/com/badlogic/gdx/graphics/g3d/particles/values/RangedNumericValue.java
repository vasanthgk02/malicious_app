package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class RangedNumericValue extends ParticleValue {
    public float lowMax;
    public float lowMin;

    public float getLowMax() {
        return this.lowMax;
    }

    public float getLowMin() {
        return this.lowMin;
    }

    public void load(RangedNumericValue rangedNumericValue) {
        super.load(rangedNumericValue);
        this.lowMax = rangedNumericValue.lowMax;
        this.lowMin = rangedNumericValue.lowMin;
    }

    public float newLowValue() {
        float f2 = this.lowMin;
        return (MathUtils.random() * (this.lowMax - f2)) + f2;
    }

    public void read(Json json, JsonValue jsonValue) {
        super.read(json, jsonValue);
        this.lowMin = ((Float) json.readValue((String) "lowMin", Float.TYPE, jsonValue)).floatValue();
        this.lowMax = ((Float) json.readValue((String) "lowMax", Float.TYPE, jsonValue)).floatValue();
    }

    public void setLow(float f2) {
        this.lowMin = f2;
        this.lowMax = f2;
    }

    public void setLowMax(float f2) {
        this.lowMax = f2;
    }

    public void setLowMin(float f2) {
        this.lowMin = f2;
    }

    public void write(Json json) {
        super.write(json);
        json.writeValue("lowMin", Float.valueOf(this.lowMin));
        json.writeValue("lowMax", Float.valueOf(this.lowMax));
    }

    public void setLow(float f2, float f3) {
        this.lowMin = f2;
        this.lowMax = f3;
    }
}
