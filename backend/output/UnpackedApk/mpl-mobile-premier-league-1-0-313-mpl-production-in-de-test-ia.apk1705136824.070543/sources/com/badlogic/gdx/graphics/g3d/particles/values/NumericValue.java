package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import io.hansel.core.criteria.HSLCriteriaBuilder;

public class NumericValue extends ParticleValue {
    public float value;

    public float getValue() {
        return this.value;
    }

    public void load(NumericValue numericValue) {
        super.load(numericValue);
        this.value = numericValue.value;
    }

    public void read(Json json, JsonValue jsonValue) {
        super.read(json, jsonValue);
        this.value = ((Float) json.readValue((String) HSLCriteriaBuilder.VALUE, Float.TYPE, jsonValue)).floatValue();
    }

    public void setValue(float f2) {
        this.value = f2;
    }

    public void write(Json json) {
        super.write(json);
        json.writeValue(HSLCriteriaBuilder.VALUE, Float.valueOf(this.value));
    }
}
