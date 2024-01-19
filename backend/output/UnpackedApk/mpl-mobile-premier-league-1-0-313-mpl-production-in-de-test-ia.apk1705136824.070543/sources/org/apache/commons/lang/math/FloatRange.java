package org.apache.commons.lang.math;

import java.io.Serializable;

public final class FloatRange extends Range implements Serializable {
    public static final long serialVersionUID = 71849363892750L;
    public transient int hashCode = 0;
    public final float max;
    public transient Float maxObject = null;
    public final float min;
    public transient Float minObject = null;
    public transient String toString = null;

    public FloatRange(float f2) {
        if (!Float.isNaN(f2)) {
            this.min = f2;
            this.max = f2;
            return;
        }
        throw new IllegalArgumentException("The number must not be NaN");
    }

    public boolean containsFloat(float f2) {
        return f2 >= this.min && f2 <= this.max;
    }

    public boolean containsNumber(Number number) {
        if (number == null) {
            return false;
        }
        return containsFloat(number.floatValue());
    }

    public boolean containsRange(Range range) {
        boolean z = false;
        if (range == null) {
            return false;
        }
        if (containsFloat(range.getMinimumFloat()) && containsFloat(range.getMaximumFloat())) {
            z = true;
        }
        return z;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FloatRange)) {
            return false;
        }
        FloatRange floatRange = (FloatRange) obj;
        if (!(Float.floatToIntBits(this.min) == Float.floatToIntBits(floatRange.min) && Float.floatToIntBits(this.max) == Float.floatToIntBits(floatRange.max))) {
            z = false;
        }
        return z;
    }

    public double getMaximumDouble() {
        return (double) this.max;
    }

    public float getMaximumFloat() {
        return this.max;
    }

    public int getMaximumInteger() {
        return (int) this.max;
    }

    public long getMaximumLong() {
        return (long) this.max;
    }

    public Number getMaximumNumber() {
        if (this.maxObject == null) {
            this.maxObject = new Float(this.max);
        }
        return this.maxObject;
    }

    public double getMinimumDouble() {
        return (double) this.min;
    }

    public float getMinimumFloat() {
        return this.min;
    }

    public int getMinimumInteger() {
        return (int) this.min;
    }

    public long getMinimumLong() {
        return (long) this.min;
    }

    public Number getMinimumNumber() {
        if (this.minObject == null) {
            this.minObject = new Float(this.min);
        }
        return this.minObject;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 17;
            int hashCode2 = FloatRange.class.hashCode() + (17 * 37);
            this.hashCode = hashCode2;
            int floatToIntBits = Float.floatToIntBits(this.min) + (hashCode2 * 37);
            this.hashCode = floatToIntBits;
            this.hashCode = Float.floatToIntBits(this.max) + (floatToIntBits * 37);
        }
        return this.hashCode;
    }

    public boolean overlapsRange(Range range) {
        boolean z = false;
        if (range == null) {
            return false;
        }
        if (range.containsFloat(this.min) || range.containsFloat(this.max) || containsFloat(range.getMinimumFloat())) {
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

    public FloatRange(Number number) {
        if (number != null) {
            this.min = number.floatValue();
            this.max = number.floatValue();
            if (Float.isNaN(this.min) || Float.isNaN(this.max)) {
                throw new IllegalArgumentException("The number must not be NaN");
            } else if (number instanceof Float) {
                Float f2 = (Float) number;
                this.minObject = f2;
                this.maxObject = f2;
            }
        } else {
            throw new IllegalArgumentException("The number must not be null");
        }
    }

    public FloatRange(float f2, float f3) {
        if (Float.isNaN(f2) || Float.isNaN(f3)) {
            throw new IllegalArgumentException("The numbers must not be NaN");
        } else if (f3 < f2) {
            this.min = f3;
            this.max = f2;
        } else {
            this.min = f2;
            this.max = f3;
        }
    }

    public FloatRange(Number number, Number number2) {
        if (number == null || number2 == null) {
            throw new IllegalArgumentException("The numbers must not be null");
        }
        float floatValue = number.floatValue();
        float floatValue2 = number2.floatValue();
        if (Float.isNaN(floatValue) || Float.isNaN(floatValue2)) {
            throw new IllegalArgumentException("The numbers must not be NaN");
        } else if (floatValue2 < floatValue) {
            this.min = floatValue2;
            this.max = floatValue;
            if (number2 instanceof Float) {
                this.minObject = (Float) number2;
            }
            if (number instanceof Float) {
                this.maxObject = (Float) number;
            }
        } else {
            this.min = floatValue;
            this.max = floatValue2;
            if (number instanceof Float) {
                this.minObject = (Float) number;
            }
            if (number2 instanceof Float) {
                this.maxObject = (Float) number2;
            }
        }
    }
}
