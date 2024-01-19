package org.joda.time.field;

import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public class PreciseDateTimeField extends PreciseDurationDateTimeField {
    public final int iRange;
    public final DurationField iRangeField;

    public PreciseDateTimeField(DateTimeFieldType dateTimeFieldType, DurationField durationField, DurationField durationField2) {
        super(dateTimeFieldType, durationField);
        if (durationField2.isPrecise()) {
            int unitMillis = (int) (durationField2.getUnitMillis() / this.iUnitMillis);
            this.iRange = unitMillis;
            if (unitMillis >= 2) {
                this.iRangeField = durationField2;
                return;
            }
            throw new IllegalArgumentException("The effective range must be at least 2");
        }
        throw new IllegalArgumentException("Range duration field must be precise");
    }

    public int get(long j) {
        if (j >= 0) {
            return (int) ((j / this.iUnitMillis) % ((long) this.iRange));
        }
        int i = this.iRange;
        return (i - 1) + ((int) (((j + 1) / this.iUnitMillis) % ((long) i)));
    }

    public int getMaximumValue() {
        return this.iRange - 1;
    }

    public DurationField getRangeDurationField() {
        return this.iRangeField;
    }

    public long set(long j, int i) {
        TypeUtilsKt.verifyValueBounds(this, i, 0, this.iRange - 1);
        return (((long) (i - get(j))) * this.iUnitMillis) + j;
    }
}
