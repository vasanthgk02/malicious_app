package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.PreciseDurationDateTimeField;

public final class BasicDayOfYearDateTimeField extends PreciseDurationDateTimeField {
    public final BasicChronology iChronology;

    public BasicDayOfYearDateTimeField(BasicChronology basicChronology, DurationField durationField) {
        super(DateTimeFieldType.DAY_OF_YEAR_TYPE, durationField);
        this.iChronology = basicChronology;
    }

    public int get(long j) {
        BasicChronology basicChronology = this.iChronology;
        return ((int) ((j - basicChronology.getYearMillis(basicChronology.getYear(j))) / 86400000)) + 1;
    }

    public int getMaximumValue() {
        if (this.iChronology != null) {
            return 366;
        }
        throw null;
    }

    public int getMaximumValueForSet(long j, int i) {
        if (this.iChronology == null) {
            throw null;
        } else if (i > 365 || i < 1) {
            return getMaximumValue(j);
        } else {
            return 365;
        }
    }

    public int getMinimumValue() {
        return 1;
    }

    public DurationField getRangeDurationField() {
        return this.iChronology.iYears;
    }

    public boolean isLeap(long j) {
        return this.iChronology.isLeapDay(j);
    }

    public int getMaximumValue(long j) {
        return this.iChronology.isLeapYear(this.iChronology.getYear(j)) ? 366 : 365;
    }
}
