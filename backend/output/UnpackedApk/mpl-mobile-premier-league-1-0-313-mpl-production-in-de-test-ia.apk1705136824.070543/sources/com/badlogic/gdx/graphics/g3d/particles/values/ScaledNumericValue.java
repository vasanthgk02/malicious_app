package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class ScaledNumericValue extends RangedNumericValue {
    public float highMax;
    public float highMin;
    public boolean relative = false;
    public float[] scaling = {1.0f};
    public float[] timeline = {0.0f};

    public float getHighMax() {
        return this.highMax;
    }

    public float getHighMin() {
        return this.highMin;
    }

    public float getScale(float f2) {
        int length = this.timeline.length;
        int i = 1;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (this.timeline[i] > f2) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return this.scaling[length - 1];
        }
        int i2 = i - 1;
        float[] fArr = this.scaling;
        float f3 = fArr[i2];
        float[] fArr2 = this.timeline;
        float f4 = fArr2[i2];
        return (((f2 - f4) / (fArr2[i] - f4)) * (fArr[i] - f3)) + f3;
    }

    public float[] getScaling() {
        return this.scaling;
    }

    public float[] getTimeline() {
        return this.timeline;
    }

    public boolean isRelative() {
        return this.relative;
    }

    public void load(ScaledNumericValue scaledNumericValue) {
        super.load(scaledNumericValue);
        this.highMax = scaledNumericValue.highMax;
        this.highMin = scaledNumericValue.highMin;
        float[] fArr = new float[scaledNumericValue.scaling.length];
        this.scaling = fArr;
        System.arraycopy(scaledNumericValue.scaling, 0, fArr, 0, fArr.length);
        float[] fArr2 = new float[scaledNumericValue.timeline.length];
        this.timeline = fArr2;
        System.arraycopy(scaledNumericValue.timeline, 0, fArr2, 0, fArr2.length);
        this.relative = scaledNumericValue.relative;
    }

    public float newHighValue() {
        float f2 = this.highMin;
        return (MathUtils.random() * (this.highMax - f2)) + f2;
    }

    public void read(Json json, JsonValue jsonValue) {
        Class cls = float[].class;
        super.read(json, jsonValue);
        this.highMin = ((Float) json.readValue((String) "highMin", Float.TYPE, jsonValue)).floatValue();
        this.highMax = ((Float) json.readValue((String) "highMax", Float.TYPE, jsonValue)).floatValue();
        this.relative = ((Boolean) json.readValue((String) "relative", Boolean.TYPE, jsonValue)).booleanValue();
        this.scaling = (float[]) json.readValue((String) "scaling", cls, jsonValue);
        this.timeline = (float[]) json.readValue((String) "timeline", cls, jsonValue);
    }

    public void setHigh(float f2) {
        this.highMin = f2;
        this.highMax = f2;
    }

    public void setHighMax(float f2) {
        this.highMax = f2;
    }

    public void setHighMin(float f2) {
        this.highMin = f2;
    }

    public void setRelative(boolean z) {
        this.relative = z;
    }

    public void setScaling(float[] fArr) {
        this.scaling = fArr;
    }

    public void setTimeline(float[] fArr) {
        this.timeline = fArr;
    }

    public void write(Json json) {
        super.write(json);
        json.writeValue("highMin", Float.valueOf(this.highMin));
        json.writeValue("highMax", Float.valueOf(this.highMax));
        json.writeValue("relative", Boolean.valueOf(this.relative));
        json.writeValue("scaling", this.scaling);
        json.writeValue("timeline", this.timeline);
    }

    public void setHigh(float f2, float f3) {
        this.highMin = f2;
        this.highMax = f3;
    }
}
