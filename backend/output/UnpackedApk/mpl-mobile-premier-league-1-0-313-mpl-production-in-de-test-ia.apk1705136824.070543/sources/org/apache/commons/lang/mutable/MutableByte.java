package org.apache.commons.lang.mutable;

public class MutableByte extends Number implements Comparable, Mutable {
    public static final long serialVersionUID = -1585823265;
    public byte value;

    public MutableByte() {
    }

    public void add(byte b2) {
        this.value = (byte) (this.value + b2);
    }

    public byte byteValue() {
        return this.value;
    }

    public int compareTo(Object obj) {
        byte b2 = ((MutableByte) obj).value;
        byte b3 = this.value;
        if (b3 < b2) {
            return -1;
        }
        return b3 == b2 ? 0 : 1;
    }

    public void decrement() {
        this.value = (byte) (this.value - 1);
    }

    public double doubleValue() {
        return (double) this.value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableByte) || this.value != ((MutableByte) obj).byteValue()) {
            return false;
        }
        return true;
    }

    public float floatValue() {
        return (float) this.value;
    }

    public Object getValue() {
        return new Byte(this.value);
    }

    public int hashCode() {
        return this.value;
    }

    public void increment() {
        this.value = (byte) (this.value + 1);
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return (long) this.value;
    }

    public void setValue(byte b2) {
        this.value = b2;
    }

    public void subtract(byte b2) {
        this.value = (byte) (this.value - b2);
    }

    public Byte toByte() {
        return new Byte(byteValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableByte(byte b2) {
        this.value = b2;
    }

    public void add(Number number) {
        this.value = (byte) (number.byteValue() + this.value);
    }

    public void setValue(Object obj) {
        setValue(((Number) obj).byteValue());
    }

    public void subtract(Number number) {
        this.value = (byte) (this.value - number.byteValue());
    }

    public MutableByte(Number number) {
        this.value = number.byteValue();
    }
}
