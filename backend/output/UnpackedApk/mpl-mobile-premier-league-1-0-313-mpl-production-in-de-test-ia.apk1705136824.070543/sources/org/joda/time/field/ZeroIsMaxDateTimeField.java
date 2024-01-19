package org.joda.time.field;

import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public final class ZeroIsMaxDateTimeField extends DecoratedDateTimeField {
    public ZeroIsMaxDateTimeField(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType) {
        super(dateTimeField, dateTimeFieldType);
        if (dateTimeField.getMinimumValue() != 0) {
            throw new IllegalArgumentException("Wrapped field's minumum value must be zero");
        }
    }

    public long add(long j, int i) {
        return this.iField.add(j, i);
    }

    public int get(long j) {
        int i = this.iField.get(j);
        return i == 0 ? getMaximumValue() : i;
    }

    public DurationField getLeapDurationField() {
        return this.iField.getLeapDurationField();
    }

    public int getMaximumValue() {
        return this.iField.getMaximumValue() + 1;
    }

    public int getMinimumValue() {
        return 1;
    }

    public boolean isLeap(long j) {
        return this.iField.isLeap(j);
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
        int maximumValue = getMaximumValue();
        TypeUtilsKt.verifyValueBounds(this, i, 1, maximumValue);
        if (i == maximumValue) {
            i = 0;
        }
        return this.iField.set(j, i);
    }

    public int getMaximumValue(long j) {
        return this.iField.getMaximumValue(j) + 1;
    }
}
