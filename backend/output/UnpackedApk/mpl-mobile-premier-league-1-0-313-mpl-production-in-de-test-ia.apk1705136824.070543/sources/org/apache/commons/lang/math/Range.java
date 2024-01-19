package org.apache.commons.lang.math;

public abstract class Range {
    public boolean containsDouble(Number number) {
        if (number == null) {
            return false;
        }
        return containsDouble(number.doubleValue());
    }

    public boolean containsFloat(Number number) {
        if (number == null) {
            return false;
        }
        return containsFloat(number.floatValue());
    }

    public boolean containsInteger(Number number) {
        if (number == null) {
            return false;
        }
        return containsInteger(number.intValue());
    }

    public boolean containsLong(Number number) {
        if (number == null) {
            return false;
        }
        return containsLong(number.longValue());
    }

    public abstract boolean containsNumber(Number number);

    public boolean containsRange(Range range) {
        boolean z = false;
        if (range == null) {
            return false;
        }
        if (containsNumber(range.getMinimumNumber()) && containsNumber(range.getMaximumNumber())) {
            z = true;
        }
        return z;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Range range = (Range) obj;
        if (!getMinimumNumber().equals(range.getMinimumNumber()) || !getMaximumNumber().equals(range.getMaximumNumber())) {
            z = false;
        }
        return z;
    }

    public double getMaximumDouble() {
        return getMaximumNumber().doubleValue();
    }

    public float getMaximumFloat() {
        return getMaximumNumber().floatValue();
    }

    public int getMaximumInteger() {
        return getMaximumNumber().intValue();
    }

    public long getMaximumLong() {
        return getMaximumNumber().longValue();
    }

    public abstract Number getMaximumNumber();

    public double getMinimumDouble() {
        return getMinimumNumber().doubleValue();
    }

    public float getMinimumFloat() {
        return getMinimumNumber().floatValue();
    }

    public int getMinimumInteger() {
        return getMinimumNumber().intValue();
    }

    public long getMinimumLong() {
        return getMinimumNumber().longValue();
    }

    public abstract Number getMinimumNumber();

    public int hashCode() {
        int hashCode = getMinimumNumber().hashCode();
        return getMaximumNumber().hashCode() + ((hashCode + ((getClass().hashCode() + 629) * 37)) * 37);
    }

    public boolean overlapsRange(Range range) {
        boolean z = false;
        if (range == null) {
            return false;
        }
        if (range.containsNumber(getMinimumNumber()) || range.containsNumber(getMaximumNumber()) || containsNumber(range.getMinimumNumber())) {
            z = true;
        }
        return z;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(32);
        stringBuffer.append("Range[");
        stringBuffer.append(getMinimumNumber());
        stringBuffer.append(',');
        stringBuffer.append(getMaximumNumber());
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    public boolean containsDouble(double d2) {
        return NumberUtils.compare(getMinimumDouble(), d2) <= 0 && NumberUtils.compare(getMaximumDouble(), d2) >= 0;
    }

    public boolean containsFloat(float f2) {
        return NumberUtils.compare(getMinimumFloat(), f2) <= 0 && NumberUtils.compare(getMaximumFloat(), f2) >= 0;
    }

    public boolean containsInteger(int i) {
        return i >= getMinimumInteger() && i <= getMaximumInteger();
    }

    public boolean containsLong(long j) {
        return j >= getMinimumLong() && j <= getMaximumLong();
    }
}
