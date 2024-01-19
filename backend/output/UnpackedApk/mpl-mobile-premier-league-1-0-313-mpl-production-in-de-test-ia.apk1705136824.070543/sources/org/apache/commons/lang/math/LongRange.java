package org.apache.commons.lang.math;

import java.io.Serializable;

public final class LongRange extends Range implements Serializable {
    public static final long serialVersionUID = 71849363892720L;
    public transient int hashCode = 0;
    public final long max;
    public transient Long maxObject = null;
    public final long min;
    public transient Long minObject = null;
    public transient String toString = null;

    public LongRange(long j) {
        this.min = j;
        this.max = j;
    }

    public boolean containsLong(long j) {
        return j >= this.min && j <= this.max;
    }

    public boolean containsNumber(Number number) {
        if (number == null) {
            return false;
        }
        return containsLong(number.longValue());
    }

    public boolean containsRange(Range range) {
        boolean z = false;
        if (range == null) {
            return false;
        }
        if (containsLong(range.getMinimumLong()) && containsLong(range.getMaximumLong())) {
            z = true;
        }
        return z;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LongRange)) {
            return false;
        }
        LongRange longRange = (LongRange) obj;
        if (!(this.min == longRange.min && this.max == longRange.max)) {
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
        return (int) this.max;
    }

    public long getMaximumLong() {
        return this.max;
    }

    public Number getMaximumNumber() {
        if (this.maxObject == null) {
            this.maxObject = new Long(this.max);
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
        return (int) this.min;
    }

    public long getMinimumLong() {
        return this.min;
    }

    public Number getMinimumNumber() {
        if (this.minObject == null) {
            this.minObject = new Long(this.min);
        }
        return this.minObject;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 17;
            int hashCode2 = LongRange.class.hashCode() + (17 * 37);
            this.hashCode = hashCode2;
            long j = this.min;
            int i = (hashCode2 * 37) + ((int) (j ^ (j >> 32)));
            this.hashCode = i;
            long j2 = this.max;
            this.hashCode = (i * 37) + ((int) (j2 ^ (j2 >> 32)));
        }
        return this.hashCode;
    }

    public boolean overlapsRange(Range range) {
        boolean z = false;
        if (range == null) {
            return false;
        }
        if (range.containsLong(this.min) || range.containsLong(this.max) || containsLong(range.getMinimumLong())) {
            z = true;
        }
        return z;
    }

    public long[] toArray() {
        int i = (int) ((this.max - this.min) + 1);
        long[] jArr = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            jArr[i2] = this.min + ((long) i2);
        }
        return jArr;
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

    public LongRange(Number number) {
        if (number != null) {
            this.min = number.longValue();
            this.max = number.longValue();
            if (number instanceof Long) {
                Long l = (Long) number;
                this.minObject = l;
                this.maxObject = l;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The number must not be null");
    }

    public LongRange(long j, long j2) {
        if (j2 < j) {
            this.min = j2;
            this.max = j;
            return;
        }
        this.min = j;
        this.max = j2;
    }

    public LongRange(Number number, Number number2) {
        if (number == null || number2 == null) {
            throw new IllegalArgumentException("The numbers must not be null");
        }
        long longValue = number.longValue();
        long longValue2 = number2.longValue();
        if (longValue2 < longValue) {
            this.min = longValue2;
            this.max = longValue;
            if (number2 instanceof Long) {
                this.minObject = (Long) number2;
            }
            if (number instanceof Long) {
                this.maxObject = (Long) number;
                return;
            }
            return;
        }
        this.min = longValue;
        this.max = longValue2;
        if (number instanceof Long) {
            this.minObject = (Long) number;
        }
        if (number2 instanceof Long) {
            this.maxObject = (Long) number2;
        }
    }
}
