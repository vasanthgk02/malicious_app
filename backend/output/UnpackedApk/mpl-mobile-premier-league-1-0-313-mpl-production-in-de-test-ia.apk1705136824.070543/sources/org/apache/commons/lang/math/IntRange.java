package org.apache.commons.lang.math;

import java.io.Serializable;

public final class IntRange extends Range implements Serializable {
    public static final long serialVersionUID = 71849363892730L;
    public transient int hashCode = 0;
    public final int max;
    public transient Integer maxObject = null;
    public final int min;
    public transient Integer minObject = null;
    public transient String toString = null;

    public IntRange(int i) {
        this.min = i;
        this.max = i;
    }

    public boolean containsInteger(int i) {
        return i >= this.min && i <= this.max;
    }

    public boolean containsNumber(Number number) {
        if (number == null) {
            return false;
        }
        return containsInteger(number.intValue());
    }

    public boolean containsRange(Range range) {
        boolean z = false;
        if (range == null) {
            return false;
        }
        if (containsInteger(range.getMinimumInteger()) && containsInteger(range.getMaximumInteger())) {
            z = true;
        }
        return z;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IntRange)) {
            return false;
        }
        IntRange intRange = (IntRange) obj;
        if (!(this.min == intRange.min && this.max == intRange.max)) {
            z = false;
        }
        return z;
    }

    public double getMaximumDouble() {
        return (double) this.max;
    }

    public float getMaximumFloat() {
        return (float) this.max;
    }

    public int getMaximumInteger() {
        return this.max;
    }

    public long getMaximumLong() {
        return (long) this.max;
    }

    public Number getMaximumNumber() {
        if (this.maxObject == null) {
            this.maxObject = new Integer(this.max);
        }
        return this.maxObject;
    }

    public double getMinimumDouble() {
        return (double) this.min;
    }

    public float getMinimumFloat() {
        return (float) this.min;
    }

    public int getMinimumInteger() {
        return this.min;
    }

    public long getMinimumLong() {
        return (long) this.min;
    }

    public Number getMinimumNumber() {
        if (this.minObject == null) {
            this.minObject = new Integer(this.min);
        }
        return this.minObject;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 17;
            int hashCode2 = IntRange.class.hashCode() + (17 * 37);
            this.hashCode = hashCode2;
            int i = (hashCode2 * 37) + this.min;
            this.hashCode = i;
            this.hashCode = (i * 37) + this.max;
        }
        return this.hashCode;
    }

    public boolean overlapsRange(Range range) {
        boolean z = false;
        if (range == null) {
            return false;
        }
        if (range.containsInteger(this.min) || range.containsInteger(this.max) || containsInteger(range.getMinimumInteger())) {
            z = true;
        }
        return z;
    }

    public int[] toArray() {
        int i = (this.max - this.min) + 1;
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = this.min + i2;
        }
        return iArr;
    }

    public String toString() {
        if (this.toString == null) {
            StringBuffer stringBuffer = new StringBuffer(32);
            stringBuffer.append("Range[");
            stringBuffer.append(this.min);
            stringBuffer.append(',');
            stringBuffer.append(this.max);
            stringBuffer.append(']');
            this.toString = stringBuffer.toString();
        }
        return this.toString;
    }

    public IntRange(Number number) {
        if (number != null) {
            this.min = number.intValue();
            this.max = number.intValue();
            if (number instanceof Integer) {
                Integer num = (Integer) number;
                this.minObject = num;
                this.maxObject = num;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The number must not be null");
    }

    public IntRange(int i, int i2) {
        if (i2 < i) {
            this.min = i2;
            this.max = i;
            return;
        }
        this.min = i;
        this.max = i2;
    }

    public IntRange(Number number, Number number2) {
        if (number == null || number2 == null) {
            throw new IllegalArgumentException("The numbers must not be null");
        }
        int intValue = number.intValue();
        int intValue2 = number2.intValue();
        if (intValue2 < intValue) {
            this.min = intValue2;
            this.max = intValue;
            if (number2 instanceof Integer) {
                this.minObject = (Integer) number2;
            }
            if (number instanceof Integer) {
                this.maxObject = (Integer) number;
                return;
            }
            return;
        }
        this.min = intValue;
        this.max = intValue2;
        if (number instanceof Integer) {
            this.minObject = (Integer) number;
        }
        if (number2 instanceof Integer) {
            this.maxObject = (Integer) number2;
        }
    }
}
