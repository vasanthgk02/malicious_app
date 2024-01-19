package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.Array;

public class CumulativeDistribution<T> {
    public Array<CumulativeValue> values = new Array<>(false, 10, CumulativeValue.class);

    public class CumulativeValue {
        public float frequency;
        public float interval;
        public T value;

        public CumulativeValue(CumulativeDistribution cumulativeDistribution, T t, float f2, float f3) {
            this.value = t;
            this.frequency = f2;
            this.interval = f3;
        }
    }
}
