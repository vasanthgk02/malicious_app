package org.apache.commons.lang.math;

import java.io.Serializable;

public final class NumberRange extends Range implements Serializable {
    public static final long serialVersionUID = 71849363892710L;
    public transient int hashCode = 0;
    public final Number max;
    public final Number min;
    public transient String toString = null;

    public NumberRange(Number number) {
        if (number == null) {
            throw new IllegalArgumentException("The number must not be null");
        } else if (!(number instanceof Comparable)) {
            throw new IllegalArgumentException("The number must implement Comparable");
        } else if ((number instanceof Double) && ((Double) number).isNaN()) {
            throw new IllegalArgumentException("The number must not be NaN");
        } else if (!(number instanceof Float) || !((Float) number).isNaN()) {
            this.min = number;
            this.max = number;
        } else {
            throw new IllegalArgumentException("The number must not be NaN");
        }
    }

    public boolean containsNumber(Number number) {
        boolean z = false;
        if (number == null) {
            return false;
        }
        if (number.getClass() == this.min.getClass()) {
            int compareTo = ((Comparable) this.min).compareTo(number);
            int compareTo2 = ((Comparable) this.max).compareTo(number);
            if (compareTo <= 0 && compareTo2 >= 0) {
                z = true;
            }
            return z;
        }
        throw new IllegalArgumentException("The number must be of the same type as the range numbers");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NumberRange)) {
            return false;
        }
        NumberRange numberRange = (NumberRange) obj;
        if (!this.min.equals(numberRange.min) || !this.max.equals(numberRange.max)) {
            z = false;
        }
        return z;
    }

    public Number getMaximumNumber() {
        return this.max;
    }

    public Number getMinimumNumber() {
        return this.min;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 17;
            int hashCode2 = NumberRange.class.hashCode() + (17 * 37);
            this.hashCode = hashCode2;
            int hashCode3 = this.min.hashCode() + (hashCode2 * 37);
            this.hashCode = hashCode3;
            this.hashCode = this.max.hashCode() + (hashCode3 * 37);
        }
        return this.hashCode;
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

    public NumberRange(Number number, Number number2) {
        if (number == null || number2 == null) {
            throw new IllegalArgumentException("The numbers must not be null");
        } else if (number.getClass() != number2.getClass()) {
            throw new IllegalArgumentException("The numbers must be of the same type");
        } else if (number instanceof Comparable) {
            if (number instanceof Double) {
                if (((Double) number).isNaN() || ((Double) number2).isNaN()) {
                    throw new IllegalArgumentException("The number must not be NaN");
                }
            } else if ((number instanceof Float) && (((Float) number).isNaN() || ((Float) number2).isNaN())) {
                throw new IllegalArgumentException("The number must not be NaN");
            }
            int compareTo = ((Comparable) number).compareTo(number2);
            if (compareTo == 0) {
                this.min = number;
                this.max = number;
            } else if (compareTo > 0) {
                this.min = number2;
                this.max = number;
            } else {
                this.min = number;
                this.max = number2;
            }
        } else {
            throw new IllegalArgumentException("The numbers must implement Comparable");
        }
    }
}
