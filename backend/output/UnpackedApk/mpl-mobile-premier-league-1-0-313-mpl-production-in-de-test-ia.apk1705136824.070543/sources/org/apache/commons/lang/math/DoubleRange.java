package org.apache.commons.lang.math;

import java.io.Serializable;

public final class DoubleRange extends Range implements Serializable {
    public static final long serialVersionUID = 71849363892740L;
    public transient int hashCode = 0;
    public final double max;
    public transient Double maxObject = null;
    public final double min;
    public transient Double minObject = null;
    public transient String toString = null;

    public DoubleRange(double d2) {
        if (!Double.isNaN(d2)) {
            this.min = d2;
            this.max = d2;
            return;
        }
        throw new IllegalArgumentException("The number must not be NaN");
    }

    public boolean containsDouble(double d2) {
        return d2 >= this.min && d2 <= this.max;
    }

    public boolean containsNumber(Number number) {
        if (number == null) {
            return false;
        }
        return containsDouble(number.doubleValue());
    }

    public boolean containsRange(Range range) {
        boolean z = false;
        if (range == null) {
            return false;
        }
        if (containsDouble(range.getMinimumDouble()) && containsDouble(range.getMaximumDouble())) {
            z = true;
        }
        return z;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DoubleRange)) {
            return false;
        }
        DoubleRange doubleRange = (DoubleRange) obj;
        if (!(Double.doubleToLongBits(this.min) == Double.doubleToLongBits(doubleRange.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(doubleRange.max))) {
            z = false;
        }
        return z;
    }

    public double getMaximumDouble() {
        return this.max;
    }

    public float getMaximumFloat() {
        return (float) this.max;
    }

    public int getMaximumInteger() {
        return (int) this.max;
    }

    public long getMaximumLong() {
        return (long) this.max;
    }

    public Number getMaximumNumber() {
        if (this.maxObject == null) {
            this.maxObject = new Double(this.max);
        }
        return this.maxObject;
    }

    public double getMinimumDouble() {
        return this.min;
    }

    public float getMinimumFloat() {
        return (float) this.min;
    }

    public int getMinimumInteger() {
        return (int) this.min;
    }

    public long getMinimumLong() {
        return (long) this.min;
    }

    public Number getMinimumNumber() {
        if (this.minObject == null) {
            this.minObject = new Double(this.min);
        }
        return this.minObject;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 17;
            this.hashCode = DoubleRange.class.hashCode() + (17 * 37);
            long doubleToLongBits = Double.doubleToLongBits(this.min);
            this.hashCode = (this.hashCode * 37) + ((int) (doubleToLongBits ^ (doubleToLongBits >> 32)));
            long doubleToLongBits2 = Double.doubleToLongBits(this.max);
            this.hashCode = (this.hashCode * 37) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >> 32)));
        }
        return this.hashCode;
    }

    public boolean overlapsRange(Range range) {
        boolean z = false;
        if (range == null) {
            return false;
        }
        if (range.containsDouble(this.min) || range.containsDouble(this.max) || containsDouble(range.getMinimumDouble())) {
            z = true;
        }
        return z;
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

    public DoubleRange(Number number) {
        if (number != null) {
            this.min = number.doubleValue();
            this.max = number.doubleValue();
            if (Double.isNaN(this.min) || Double.isNaN(this.max)) {
                throw new IllegalArgumentException("The number must not be NaN");
            } else if (number instanceof Double) {
                Double d2 = (Double) number;
                this.minObject = d2;
                this.maxObject = d2;
            }
        } else {
            throw new IllegalArgumentException("The number must not be null");
        }
    }

    public DoubleRange(double d2, double d3) {
        if (Double.isNaN(d2) || Double.isNaN(d3)) {
            throw new IllegalArgumentException("The numbers must not be NaN");
        } else if (d3 < d2) {
            this.min = d3;
            this.max = d2;
        } else {
            this.min = d2;
            this.max = d3;
        }
    }

    public DoubleRange(Number number, Number number2) {
        if (number == null || number2 == null) {
            throw new IllegalArgumentException("The numbers must not be null");
        }
        double doubleValue = number.doubleValue();
        double doubleValue2 = number2.doubleValue();
        if (Double.isNaN(doubleValue) || Double.isNaN(doubleValue2)) {
            throw new IllegalArgumentException("The numbers must not be NaN");
        } else if (doubleValue2 < doubleValue) {
            this.min = doubleValue2;
            this.max = doubleValue;
            if (number2 instanceof Double) {
                this.minObject = (Double) number2;
            }
            if (number instanceof Double) {
                this.maxObject = (Double) number;
            }
        } else {
            this.min = doubleValue;
            this.max = doubleValue2;
            if (number instanceof Double) {
                this.minObject = (Double) number;
            }
            if (number2 instanceof Double) {
                this.maxObject = (Double) number2;
            }
        }
    }
}
