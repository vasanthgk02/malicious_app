package org.joda.time.field;

import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public abstract class PreciseDurationDateTimeField extends BaseDateTimeField {
    public final DurationField iUnitField;
    public final long iUnitMillis;

    public PreciseDurationDateTimeField(DateTimeFieldType dateTimeFieldType, DurationField durationField) {
        super(dateTimeFieldType);
        if (durationField.isPrecise()) {
            long unitMillis = durationField.getUnitMillis();
            this.iUnitMillis = unitMillis;
            if (unitMillis >= 1) {
                this.iUnitField = durationField;
                return;
            }
            throw new IllegalArgumentException("The unit milliseconds must be at least 1");
        }
        throw new IllegalArgumentException("Unit duration field must be precise");
    }

    public DurationField getDurationField() {
        return this.iUnitField;
    }

    public int getMaximumValueForSet(long j, int i) {
        return getMaximumValue(j);
    }

    public int getMinimumValue() {
        return 0;
    }

    public boolean isLenient() {
        return false;
    }

    public long remainder(long j) {
        if (j >= 0) {
            return j % this.iUnitMillis;
        }
        long j2 = this.iUnitMillis;
        return (((j + 1) % j2) + j2) - 1;
    }

    public long roundCeiling(long j) {
        if (j <= 0) {
            return j - (j % this.iUnitMillis);
        }
        long j2 = j - 1;
        long j3 = this.iUnitMillis;
        return (j2 - (j2 % j3)) + j3;
    }

    public long roundFloor(long j) {
        long j2;
        if (j >= 0) {
            j2 = j % this.iUnitMillis;
        } else {
            long j3 = j + 1;
            j2 = this.iUnitMillis;
            j = j3 - (j3 % j2);
        }
        return j - j2;
    }

    public long set(long j, int i) {
        TypeUtilsKt.verifyValueBounds(this, i, getMinimumValue(), getMaximumValueForSet(j, i));
        return (((long) (i - get(j))) * this.iUnitMillis) + j;
    }
}
