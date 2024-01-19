package org.joda.time.chrono;

import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.DecoratedDateTimeField;

public class ISOYearOfEraDateTimeField extends DecoratedDateTimeField {
    public static final DateTimeField INSTANCE = new ISOYearOfEraDateTimeField();

    public ISOYearOfEraDateTimeField() {
        super(GregorianChronology.INSTANCE_UTC.iYear, DateTimeFieldType.YEAR_OF_ERA_TYPE);
    }

    public long add(long j, int i) {
        return this.iField.add(j, i);
    }

    public int get(long j) {
        int i = this.iField.get(j);
        return i < 0 ? -i : i;
    }

    public int getMaximumValue() {
        return this.iField.getMaximumValue();
    }

    public int getMinimumValue() {
        return 0;
    }

    public DurationField getRangeDurationField() {
        return GregorianChronology.INSTANCE_UTC.iEras;
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
        TypeUtilsKt.verifyValueBounds(this, i, 0, getMaximumValue());
        if (this.iField.get(j) < 0) {
            i = -i;
        }
        return super.set(j, i);
    }
}
