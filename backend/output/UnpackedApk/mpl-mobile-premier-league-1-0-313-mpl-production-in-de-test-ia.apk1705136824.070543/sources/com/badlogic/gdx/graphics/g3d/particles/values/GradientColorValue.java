package com.badlogic.gdx.graphics.g3d.particles.values;

import com.BV.LinearGradient.LinearGradientManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class GradientColorValue extends ParticleValue {
    public static float[] temp = new float[3];
    public float[] colors = {1.0f, 1.0f, 1.0f};
    public float[] timeline = {0.0f};

    public float[] getColor(float f2) {
        getColor(f2, temp, 0);
        return temp;
    }

    public float[] getColors() {
        return this.colors;
    }

    public float[] getTimeline() {
        return this.timeline;
    }

    public void load(GradientColorValue gradientColorValue) {
        super.load(gradientColorValue);
        float[] fArr = new float[gradientColorValue.colors.length];
        this.colors = fArr;
        System.arraycopy(gradientColorValue.colors, 0, fArr, 0, fArr.length);
        float[] fArr2 = new float[gradientColorValue.timeline.length];
        this.timeline = fArr2;
        System.arraycopy(gradientColorValue.timeline, 0, fArr2, 0, fArr2.length);
    }

    public void read(Json json, JsonValue jsonValue) {
        Class cls = float[].class;
        super.read(json, jsonValue);
        this.colors = (float[]) json.readValue((String) LinearGradientManager.PROP_COLORS, cls, jsonValue);
        this.timeline = (float[]) json.readValue((String) "timeline", cls, jsonValue);
    }

    public void setColors(float[] fArr) {
        this.colors = fArr;
    }

    public void setTimeline(float[] fArr) {
        this.timeline = fArr;
    }

    public void write(Json json) {
        super.write(json);
        json.writeValue(LinearGradientManager.PROP_COLORS, this.colors);
        json.writeValue("timeline", this.timeline);
    }

    public void getColor(float f2, float[] fArr, int i) {
        float[] fArr2 = this.timeline;
        int length = fArr2.length;
        int i2 = 1;
        int i3 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (fArr2[i2] > f2) {
                break;
            } else {
                i3 = i2;
                i2++;
            }
        }
        float f3 = fArr2[i3];
        int i4 = i3 * 3;
        float[] fArr3 = this.colors;
        float f4 = fArr3[i4];
        float f5 = fArr3[i4 + 1];
        float f6 = fArr3[i4 + 2];
        if (i2 == -1) {
            fArr[i] = f4;
            fArr[i + 1] = f5;
            fArr[i + 2] = f6;
            return;
        }
        float f7 = (f2 - f3) / (fArr2[i2] - f3);
        int i5 = i2 * 3;
        fArr[i] = GeneratedOutlineSupport.outline3(fArr3[i5], f4, f7, f4);
        fArr[i + 1] = GeneratedOutlineSupport.outline3(fArr3[i5 + 1], f5, f7, f5);
        fArr[i + 2] = GeneratedOutlineSupport.outline3(fArr3[i5 + 2], f6, f7, f6);
    }
}
