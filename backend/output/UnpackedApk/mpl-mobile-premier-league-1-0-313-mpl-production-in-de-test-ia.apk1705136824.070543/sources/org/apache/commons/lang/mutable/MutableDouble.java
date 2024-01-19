package org.apache.commons.lang.mutable;

import org.apache.commons.lang.math.NumberUtils;

public class MutableDouble extends Number implements Comparable, Mutable {
    public static final long serialVersionUID = 1587163916;
    public double value;

    public MutableDouble() {
    }

    public void add(double d2) {
        this.value += d2;
    }

    public int compareTo(Object obj) {
        return NumberUtils.compare(this.value, ((MutableDouble) obj).value);
    }

    public void decrement() {
        this.value -= 1.0d;
    }

    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableDouble) && Double.doubleToLongBits(((MutableDouble) obj).value) == Double.doubleToLongBits(this.value);
    }

    public float floatValue() {
        return (float) this.value;
    }

    public Object getValue() {
        return new Double(this.value);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.value);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public void increment() {
        this.value += 1.0d;
    }

    public int intValue() {
        return (int) this.value;
    }

    public boolean isInfinite() {
        return Double.isInfinite(this.value);
    }

    public boolean isNaN() {
        return Double.isNaN(this.value);
    }

    public long longValue() {
        return (long) this.value;
    }

    public void setValue(double d2) {
        this.value = d2;
    }

    public void subtract(double d2) {
        this.value -= d2;
    }

    public Double toDouble() {
        return new Double(doubleValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableDouble(double d2) {
        this.value = d2;
    }

    public void add(Number number) {
        this.value = number.doubleValue() + this.value;
    }

    public void setValue(Object obj) {
        setValue(((Number) obj).doubleValue());
    }

    public void subtract(Number number) {
        this.value -= number.doubleValue();
    }

    public MutableDouble(Number number) {
        this.value = number.doubleValue();
    }
}
