package org.joda.time.chrono;

import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.DecoratedDateTimeField;

public final class GJYearOfEraDateTimeField extends DecoratedDateTimeField {
    public final BasicChronology iChronology;

    public GJYearOfEraDateTimeField(DateTimeField dateTimeField, BasicChronology basicChronology) {
        super(dateTimeField, DateTimeFieldType.YEAR_OF_ERA_TYPE);
        this.iChronology = basicChronology;
    }

    public long add(long j, int i) {
        return this.iField.add(j, i);
    }

    public int get(long j) {
        int i = this.iField.get(j);
        return i <= 0 ? 1 - i : i;
    }

    public int getMaximumValue() {
        return this.iField.getMaximumValue();
    }

    public int getMinimumValue() {
        return 1;
    }

    public DurationField getRangeDurationField() {
        return this.iChronology.iEras;
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

    public long set(long j, int i) {
        TypeUtilsKt.verifyValueBounds(this, i, 1, getMaximumValue());
        if (this.iChronology.getYear(j) <= 0) {
            i = 1 - i;
        }
        return this.iField.set(j, i);
    }
}
