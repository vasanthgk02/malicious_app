package org.apache.commons.lang;

public final class NumberRange {
    public final Number max;
    public final Number min;

    public NumberRange(Number number) {
        if (number != null) {
            this.min = number;
            this.max = number;
            return;
        }
        throw new NullPointerException("The number must not be null");
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

    public Number getMaximum() {
        return this.max;
    }

    public Number getMinimum() {
        return this.min;
    }

    public int hashCode() {
        return this.max.hashCode() + ((this.min.hashCode() + 629) * 37);
    }

    public boolean includesNumber(Number number) {
        boolean z = false;
        if (number == null) {
            return false;
        }
        if (this.min.doubleValue() <= number.doubleValue() && this.max.doubleValue() >= number.doubleValue()) {
            z = true;
        }
        return z;
    }

    public boolean includesRange(NumberRange numberRange) {
        boolean z = false;
        if (numberRange == null) {
            return false;
        }
        if (includesNumber(numberRange.min) && includesNumber(numberRange.max)) {
            z = true;
        }
        return z;
    }

    public boolean overlaps(NumberRange numberRange) {
        boolean z = false;
        if (numberRange == null) {
            return false;
        }
        if (numberRange.includesNumber(this.min) || numberRange.includesNumber(this.max) || includesRange(numberRange)) {
            z = true;
        }
        return z;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.min.doubleValue() < 0.0d) {
            stringBuffer.append('(');
            stringBuffer.append(this.min);
            stringBuffer.append(')');
        } else {
            stringBuffer.append(this.min);
        }
        stringBuffer.append('-');
        if (this.max.doubleValue() < 0.0d) {
            stringBuffer.append('(');
            stringBuffer.append(this.max);
            stringBuffer.append(')');
        } else {
            stringBuffer.append(this.max);
        }
        return stringBuffer.toString();
    }

    public NumberRange(Number number, Number number2) {
        if (number == null) {
            throw new NullPointerException("The minimum value must not be null");
        } else if (number2 == null) {
            throw new NullPointerException("The maximum value must not be null");
        } else if (number2.doubleValue() < number.doubleValue()) {
            this.max = number;
            this.min = number;
        } else {
            this.min = number;
            this.max = number2;
        }
    }
}
