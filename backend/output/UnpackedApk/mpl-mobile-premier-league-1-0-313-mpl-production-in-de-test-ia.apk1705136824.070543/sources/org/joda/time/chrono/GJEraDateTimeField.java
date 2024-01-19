package org.joda.time.chrono;

import java.util.Locale;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.field.BaseDateTimeField;
import org.joda.time.field.UnsupportedDurationField;

public final class GJEraDateTimeField extends BaseDateTimeField {
    public final BasicChronology iChronology;

    public GJEraDateTimeField(BasicChronology basicChronology) {
        super(DateTimeFieldType.ERA_TYPE);
        this.iChronology = basicChronology;
    }

    public int get(long j) {
        return this.iChronology.getYear(j) <= 0 ? 0 : 1;
    }

    public String getAsText(int i, Locale locale) {
        return GJLocaleSymbols.forLocale(locale).iEras[i];
    }

    public DurationField getDurationField() {
        return UnsupportedDurationField.getInstance(DurationFieldType.ERAS_TYPE);
    }

    public int getMaximumTextLength(Locale locale) {
        return GJLocaleSymbols.forLocale(locale).iMaxEraLength;
    }

    public int getMaximumValue() {
        return 1;
    }

    public int getMinimumValue() {
        return 0;
    }

    public DurationField getRangeDurationField() {
        return null;
    }

    public boolean isLenient() {
        return false;
    }

    public long roundCeiling(long j) {
        if (get(j) == 0) {
            return this.iChronology.setYear(0, 1);
        }
        return Long.MAX_VALUE;
    }

    public long roundFloor(long j) {
        if (get(j) == 1) {
            return this.iChronology.setYear(0, 1);
        }
        return Long.MIN_VALUE;
    }

    public long roundHalfCeiling(long j) {
        return roundFloor(j);
    }

    public long roundHalfEven(long j) {
        return roundFloor(j);
    }

    public long roundHalfFloor(long j) {
        return roundFloor(j);
    }

    public long set(long j, int i) {
        TypeUtilsKt.verifyValueBounds(this, i, 0, 1);
        if (get(j) == i) {
            return j;
        }
        return this.iChronology.setYear(j, -this.iChronology.getYear(j));
    }

    public long set(long j, String str, Locale locale) {
        Integer num = GJLocaleSymbols.forLocale(locale).iParseEras.get(str);
        if (num != null) {
            return set(j, num.intValue());
        }
        throw new IllegalFieldValueException(DateTimeFieldType.ERA_TYPE, str);
    }
}
