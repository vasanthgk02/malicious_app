package org.apache.commons.lang.mutable;

public class MutableLong extends Number implements Comparable, Mutable {
    public static final long serialVersionUID = 62986528375L;
    public long value;

    public MutableLong() {
    }

    public void add(long j) {
        this.value += j;
    }

    public int compareTo(Object obj) {
        long j = ((MutableLong) obj).value;
        long j2 = this.value;
        if (j2 < j) {
            return -1;
        }
        return j2 == j ? 0 : 1;
    }

    public void decrement() {
        this.value--;
    }

    public double doubleValue() {
        return (double) this.value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableLong) || this.value != ((MutableLong) obj).longValue()) {
            return false;
        }
        return true;
    }

    public float floatValue() {
        return (float) this.value;
    }

    public Object getValue() {
        return new Long(this.value);
    }

    public int hashCode() {
        long j = this.value;
        return (int) (j ^ (j >>> 32));
    }

    public void increment() {
        this.value++;
    }

    public int intValue() {
        return (int) this.value;
    }

    public long longValue() {
        return this.value;
    }

    public void setValue(long j) {
        this.value = j;
    }

    public void subtract(long j) {
        this.value -= j;
    }

    public Long toLong() {
        return new Long(longValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableLong(long j) {
        this.value = j;
    }

    public void add(Number number) {
        this.value = number.longValue() + this.value;
    }

    public void setValue(Object obj) {
        setValue(((Number) obj).longValue());
    }

    public void subtract(Number number) {
        this.value -= number.longValue();
    }

    public MutableLong(Number number) {
        this.value = number.longValue();
    }
}
