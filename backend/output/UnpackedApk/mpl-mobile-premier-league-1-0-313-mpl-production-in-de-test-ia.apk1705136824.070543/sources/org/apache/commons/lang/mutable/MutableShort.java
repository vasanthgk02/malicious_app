package org.apache.commons.lang.mutable;

public class MutableShort extends Number implements Comparable, Mutable {
    public static final long serialVersionUID = -2135791679;
    public short value;

    public MutableShort() {
    }

    public void add(short s) {
        this.value = (short) (this.value + s);
    }

    public int compareTo(Object obj) {
        short s = ((MutableShort) obj).value;
        short s2 = this.value;
        if (s2 < s) {
            return -1;
        }
        return s2 == s ? 0 : 1;
    }

    public void decrement() {
        this.value = (short) (this.value - 1);
    }

    public double doubleValue() {
        return (double) this.value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableShort) || this.value != ((MutableShort) obj).shortValue()) {
            return false;
        }
        return true;
    }

    public float floatValue() {
        return (float) this.value;
    }

    public Object getValue() {
        return new Short(this.value);
    }

    public int hashCode() {
        return this.value;
    }

    public void increment() {
        this.value = (short) (this.value + 1);
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return (long) this.value;
    }

    public void setValue(short s) {
        this.value = s;
    }

    public short shortValue() {
        return this.value;
    }

    public void subtract(short s) {
        this.value = (short) (this.value - s);
    }

    public Short toShort() {
        return new Short(shortValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableShort(short s) {
        this.value = s;
    }

    public void add(Number number) {
        this.value = (short) (number.shortValue() + this.value);
    }

    public void setValue(Object obj) {
        setValue(((Number) obj).shortValue());
    }

    public void subtract(Number number) {
        this.value = (short) (this.value - number.shortValue());
    }

    public MutableShort(Number number) {
        this.value = number.shortValue();
    }
}
