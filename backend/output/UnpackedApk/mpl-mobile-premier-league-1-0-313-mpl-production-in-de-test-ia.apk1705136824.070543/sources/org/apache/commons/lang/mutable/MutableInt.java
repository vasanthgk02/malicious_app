package org.apache.commons.lang.mutable;

public class MutableInt extends Number implements Comparable, Mutable {
    public static final long serialVersionUID = 512176391864L;
    public int value;

    public MutableInt() {
    }

    public void add(int i) {
        this.value += i;
    }

    public int compareTo(Object obj) {
        int i = ((MutableInt) obj).value;
        int i2 = this.value;
        if (i2 < i) {
            return -1;
        }
        return i2 == i ? 0 : 1;
    }

    public void decrement() {
        this.value--;
    }

    public double doubleValue() {
        return (double) this.value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableInt) || this.value != ((MutableInt) obj).intValue()) {
            return false;
        }
        return true;
    }

    public float floatValue() {
        return (float) this.value;
    }

    public Object getValue() {
        return new Integer(this.value);
    }

    public int hashCode() {
        return this.value;
    }

    public void increment() {
        this.value++;
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return (long) this.value;
    }

    public void setValue(int i) {
        this.value = i;
    }

    public void subtract(int i) {
        this.value -= i;
    }

    public Integer toInteger() {
        return new Integer(intValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableInt(int i) {
        this.value = i;
    }

    public void add(Number number) {
        this.value = number.intValue() + this.value;
    }

    public void setValue(Object obj) {
        setValue(((Number) obj).intValue());
    }

    public void subtract(Number number) {
        this.value -= number.intValue();
    }

    public MutableInt(Number number) {
        this.value = number.intValue();
    }
}
