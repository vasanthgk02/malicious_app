package org.joda.time.field;

import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public class ScaledDurationField extends DecoratedDurationField {
    public static final long serialVersionUID = -3205227092378684157L;
    public final int iScalar;

    public ScaledDurationField(DurationField durationField, DurationFieldType durationFieldType, int i) {
        super(durationField, durationFieldType);
        if (i == 0 || i == 1) {
            throw new IllegalArgumentException("The scalar must not be 0 or 1");
        }
        this.iScalar = i;
    }

    public long add(long j, int i) {
        return this.iField.add(j, ((long) i) * ((long) this.iScalar));
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScaledDurationField)) {
            return false;
        }
        ScaledDurationField scaledDurationField = (ScaledDurationField) obj;
        if (!(this.iField.equals(scaledDurationField.iField) && this.iType == scaledDurationField.iType && this.iScalar == scaledDurationField.iScalar)) {
            z = false;
        }
        return z;
    }

    public long getUnitMillis() {
        return this.iField.getUnitMillis() * ((long) this.iScalar);
    }

    public int hashCode() {
        long j = (long) this.iScalar;
        return this.iField.hashCode() + this.iType.hashCode() + ((int) (j ^ (j >>> 32)));
    }

    public long add(long j, long j2) {
        int i = this.iScalar;
        if (i != -1) {
            if (i == 0) {
                j2 = 0;
            } else if (i != 1) {
                long j3 = (long) i;
                long j4 = j2 * j3;
                if (j4 / j3 == j2) {
                    j2 = j4;
                } else {
                    throw new ArithmeticException("Multiplication overflows a long: " + j2 + " * " + i);
                }
            }
        } else if (j2 != Long.MIN_VALUE) {
            j2 = -j2;
        } else {
            throw new ArithmeticException("Multiplication overflows a long: " + j2 + " * " + i);
        }
        return this.iField.add(j, j2);
    }
}
