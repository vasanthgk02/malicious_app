package com.badlogic.gdx.math;

public class FloatCounter {
    public int count;
    public float latest;
    public float max;
    public final WindowedMean mean;
    public float min;
    public float total;
    public float value;

    public FloatCounter(int i) {
        this.mean = i > 1 ? new WindowedMean(i) : null;
        reset();
    }

    public void put(float f2) {
        float[] fArr;
        this.latest = f2;
        this.total += f2;
        boolean z = true;
        this.count++;
        WindowedMean windowedMean = this.mean;
        if (windowedMean != null) {
            int i = windowedMean.added_values;
            if (i < windowedMean.values.length) {
                windowedMean.added_values = i + 1;
            }
            float[] fArr2 = windowedMean.values;
            int i2 = windowedMean.last_value;
            int i3 = i2 + 1;
            windowedMean.last_value = i3;
            fArr2[i2] = f2;
            if (i3 > fArr2.length - 1) {
                windowedMean.last_value = 0;
            }
            windowedMean.dirty = true;
            WindowedMean windowedMean2 = this.mean;
            float f3 = 0.0f;
            if (windowedMean2.added_values >= windowedMean2.values.length) {
                if (windowedMean2.dirty) {
                    int i4 = 0;
                    while (true) {
                        fArr = windowedMean2.values;
                        if (i4 >= fArr.length) {
                            break;
                        }
                        f3 += fArr[i4];
                        i4++;
                    }
                    windowedMean2.mean = f3 / ((float) fArr.length);
                    windowedMean2.dirty = false;
                }
                f3 = windowedMean2.mean;
            }
            this.value = f3;
        } else {
            this.value = f2;
        }
        WindowedMean windowedMean3 = this.mean;
        if (windowedMean3 != null) {
            if (windowedMean3.added_values < windowedMean3.values.length) {
                z = false;
            }
            if (!z) {
                return;
            }
        }
        float f4 = this.value;
        if (f4 < this.min) {
            this.min = f4;
        }
        float f5 = this.value;
        if (f5 > this.max) {
            this.max = f5;
        }
    }

    public void reset() {
        int i = 0;
        this.count = 0;
        this.total = 0.0f;
        this.min = Float.MAX_VALUE;
        this.max = -3.4028235E38f;
        this.latest = 0.0f;
        this.value = 0.0f;
        WindowedMean windowedMean = this.mean;
        if (windowedMean != null) {
            windowedMean.added_values = 0;
            windowedMean.last_value = 0;
            while (true) {
                float[] fArr = windowedMean.values;
                if (i < fArr.length) {
                    fArr[i] = 0.0f;
                    i++;
                } else {
                    windowedMean.dirty = true;
                    return;
                }
            }
        }
    }
}
