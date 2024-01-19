package org.apache.commons.lang.mutable;

import org.apache.commons.lang.math.NumberUtils;

public class MutableFloat extends Number implements Comparable, Mutable {
    public static final long serialVersionUID = 5787169186L;
    public float value;

    public MutableFloat() {
    }

    public void add(float f2) {
        this.value += f2;
    }

    public int compareTo(Object obj) {
        return NumberUtils.compare(this.value, ((MutableFloat) obj).value);
    }

    public void decrement() {
        this.value -= 1.0f;
    }

    public double doubleValue() {
        return (double) this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableFloat) && Float.floatToIntBits(((MutableFloat) obj).value) == Float.floatToIntBits(this.value);
    }

    public float floatValue() {
        return this.value;
    }

    public Object getValue() {
        return new Float(this.value);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.value);
    }

    public void increment() {
        this.value += 1.0f;
    }

    public int intValue() {
        return (int) this.value;
    }

    public boolean isInfinite() {
        return Float.isInfinite(this.value);
    }

    public boolean isNaN() {
        return Float.isNaN(this.value);
    }

    public long longValue() {
        return (long) this.value;
    }

    public void setValue(float f2) {
        this.value = f2;
    }

    public void subtract(float f2) {
        this.value -= f2;
    }

    public Float toFloat() {
        return new Float(floatValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableFloat(float f2) {
        this.value = f2;
    }

    public void add(Number number) {
        this.value = number.floatValue() + this.value;
    }

    public void setValue(Object obj) {
        setValue(((Number) obj).floatValue());
    }

    public void subtract(Number number) {
        this.value -= number.floatValue();
    }

    public MutableFloat(Number number) {
        this.value = number.floatValue();
    }
}
