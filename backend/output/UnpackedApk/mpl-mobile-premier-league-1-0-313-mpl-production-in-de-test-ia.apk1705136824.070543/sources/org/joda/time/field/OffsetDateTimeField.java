package org.joda.time.field;

import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public class OffsetDateTimeField extends DecoratedDateTimeField {
    public final int iMax;
    public final int iMin;
    public final int iOffset;

    public OffsetDateTimeField(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType, int i, int i2, int i3) {
        super(dateTimeField, dateTimeFieldType);
        if (i != 0) {
            this.iOffset = i;
            if (i2 < dateTimeField.getMinimumValue() + i) {
                this.iMin = dateTimeField.getMinimumValue() + i;
            } else {
                this.iMin = i2;
            }
            if (i3 > dateTimeField.getMaximumValue() + i) {
                this.iMax = dateTimeField.getMaximumValue() + i;
            } else {
                this.iMax = i3;
            }
        } else {
            throw new IllegalArgumentException("The offset cannot be zero");
        }
    }

    public long add(long j, int i) {
        long add = super.add(j, i);
        TypeUtilsKt.verifyValueBounds(this, get(add), this.iMin, this.iMax);
        return add;
    }

    public int get(long j) {
        return super.get(j) + this.iOffset;
    }

    public DurationField getLeapDurationField() {
        return this.iField.getLeapDurationField();
    }

    public int getMaximumValue() {
        return this.iMax;
    }

    public int getMinimumValue() {
        return this.iMin;
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
        TypeUtilsKt.verifyValueBounds(this, i, this.iMin, this.iMax);
        return super.set(j, i - this.iOffset);
    }
}
