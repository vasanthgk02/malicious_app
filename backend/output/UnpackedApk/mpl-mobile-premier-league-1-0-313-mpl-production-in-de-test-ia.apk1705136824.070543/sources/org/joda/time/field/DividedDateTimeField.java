package org.joda.time.field;

import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeFieldType.StandardDateTimeFieldType;
import org.joda.time.DurationField;

public class DividedDateTimeField extends DecoratedDateTimeField {
    public final int iDivisor;
    public final DurationField iDurationField;
    public final int iMax;
    public final int iMin;
    public final DurationField iRangeDurationField;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DividedDateTimeField(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType, int i) {
        // DurationField rangeDurationField = dateTimeField.getRangeDurationField();
        super(dateTimeField, dateTimeFieldType);
        if (i >= 2) {
            DurationField durationField = dateTimeField.getDurationField();
            if (durationField == null) {
                this.iDurationField = null;
            } else {
                this.iDurationField = new ScaledDurationField(durationField, ((StandardDateTimeFieldType) dateTimeFieldType).iUnitType, i);
            }
            this.iRangeDurationField = rangeDurationField;
            this.iDivisor = i;
            int minimumValue = dateTimeField.getMinimumValue();
            int i2 = minimumValue >= 0 ? minimumValue / i : ((minimumValue + 1) / i) - 1;
            int maximumValue = dateTimeField.getMaximumValue();
            int i3 = maximumValue >= 0 ? maximumValue / i : ((maximumValue + 1) / i) - 1;
            this.iMin = i2;
            this.iMax = i3;
            return;
        }
        throw new IllegalArgumentException("The divisor must be at least 2");
    }

    public long add(long j, int i) {
        return this.iField.add(j, i * this.iDivisor);
    }

    public int get(long j) {
        int i = this.iField.get(j);
        if (i >= 0) {
            return i / this.iDivisor;
        }
        return ((i + 1) / this.iDivisor) - 1;
    }

    public DurationField getDurationField() {
        return this.iDurationField;
    }

    public int getMaximumValue() {
        return this.iMax;
    }

    public int getMinimumValue() {
        return this.iMin;
    }

    public DurationField getRangeDurationField() {
        DurationField durationField = this.iRangeDurationField;
        if (durationField != null) {
            return durationField;
        }
        return super.getRangeDurationField();
    }

    public long remainder(long j) {
        return set(j, get(this.iField.remainder(j)));
    }

    public long roundFloor(long j) {
        DateTimeField dateTimeField = this.iField;
        return dateTimeField.roundFloor(dateTimeField.set(j, get(j) * this.iDivisor));
    }

    public long set(long j, int i) {
        int i2;
        TypeUtilsKt.verifyValueBounds(this, i, this.iMin, this.iMax);
        int i3 = this.iField.get(j);
        if (i3 >= 0) {
            i2 = i3 % this.iDivisor;
        } else {
            int i4 = this.iDivisor;
            i2 = ((i3 + 1) % i4) + (i4 - 1);
        }
        return this.iField.set(j, (i * this.iDivisor) + i2);
    }
}
