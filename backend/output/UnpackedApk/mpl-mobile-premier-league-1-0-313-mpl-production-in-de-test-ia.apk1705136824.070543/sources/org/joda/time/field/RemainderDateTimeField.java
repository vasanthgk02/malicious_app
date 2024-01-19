package org.joda.time.field;

import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public class RemainderDateTimeField extends DecoratedDateTimeField {
    public final int iDivisor;
    public final DurationField iDurationField;
    public final DurationField iRangeField;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public RemainderDateTimeField(DividedDateTimeField dividedDateTimeField, DateTimeFieldType dateTimeFieldType) {
        // DurationField durationField = dividedDateTimeField.iField.getDurationField();
        super(dividedDateTimeField.iField, dateTimeFieldType);
        this.iDivisor = dividedDateTimeField.iDivisor;
        this.iDurationField = durationField;
        this.iRangeField = dividedDateTimeField.iDurationField;
    }

    public int get(long j) {
        int i = this.iField.get(j);
        if (i >= 0) {
            return i % this.iDivisor;
        }
        int i2 = this.iDivisor;
        return ((i + 1) % i2) + (i2 - 1);
    }

    public DurationField getDurationField() {
        return this.iDurationField;
    }

    public int getMaximumValue() {
        return this.iDivisor - 1;
    }

    public int getMinimumValue() {
        return 0;
    }

    public DurationField getRangeDurationField() {
        return this.iRangeField;
    }

    public long remainder(long j) {
        return this.iField.remainder(j);
    }

    public long roundCeiling(long j) {
        return this.iField.roundCeiling(j);
    }

    public long roundFloor(long j) {
        return this.iField.roundFloor(j);
    }

    public long roundHalfCeiling(long j) {
        return this.iField.roundHalfCeiling(j);
    }

    public long roundHalfEven(long j) {
        return this.iField.roundHalfEven(j);
    }

    public long roundHalfFloor(long j) {
        return this.iField.roundHalfFloor(j);
    }

    public long set(long j, int i) {
        int i2;
        TypeUtilsKt.verifyValueBounds(this, i, 0, this.iDivisor - 1);
        int i3 = this.iField.get(j);
        if (i3 >= 0) {
            i2 = i3 / this.iDivisor;
        } else {
            i2 = ((i3 + 1) / this.iDivisor) - 1;
        }
        return this.iField.set(j, (i2 * this.iDivisor) + i);
    }

    public RemainderDateTimeField(DividedDateTimeField dividedDateTimeField, DurationField durationField, DateTimeFieldType dateTimeFieldType) {
        super(dividedDateTimeField.iField, dateTimeFieldType);
        this.iDivisor = dividedDateTimeField.iDivisor;
        this.iDurationField = durationField;
        this.iRangeField = dividedDateTimeField.iDurationField;
    }

    public RemainderDateTimeField(DateTimeField dateTimeField, DurationField durationField, DateTimeFieldType dateTimeFieldType, int i) {
        super(dateTimeField, dateTimeFieldType);
        if (i >= 2) {
            this.iRangeField = durationField;
            this.iDurationField = dateTimeField.getDurationField();
            this.iDivisor = i;
            return;
        }
        throw new IllegalArgumentException("The divisor must be at least 2");
    }
}
