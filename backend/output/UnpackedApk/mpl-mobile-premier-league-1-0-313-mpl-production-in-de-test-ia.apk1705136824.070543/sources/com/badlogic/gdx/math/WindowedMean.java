package com.badlogic.gdx.math;

public final class WindowedMean {
    public int added_values = 0;
    public boolean dirty = true;
    public int last_value;
    public float mean = 0.0f;
    public float[] values;

    public WindowedMean(int i) {
        this.values = new float[i];
    }
}
