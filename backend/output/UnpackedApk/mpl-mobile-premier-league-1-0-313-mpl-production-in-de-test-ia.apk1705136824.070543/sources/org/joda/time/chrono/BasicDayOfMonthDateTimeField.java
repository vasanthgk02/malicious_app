package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.PreciseDurationDateTimeField;

public final class BasicDayOfMonthDateTimeField extends PreciseDurationDateTimeField {
    public final BasicChronology iChronology;

    public BasicDayOfMonthDateTimeField(BasicChronology basicChronology, DurationField durationField) {
        super(DateTimeFieldType.DAY_OF_MONTH_TYPE, durationField);
        this.iChronology = basicChronology;
    }

    public int get(long j) {
        BasicChronology basicChronology = this.iChronology;
        int year = basicChronology.getYear(j);
        return basicChronology.getDayOfMonth(j, year, basicChronology.getMonthOfYear(j, year));
    }

    public int getMaximumValue() {
        if (this.iChronology != null) {
            return 31;
        }
        throw null;
    }

    public int getMaximumValueForSet(long j, int i) {
        BasicGJChronology basicGJChronology = (BasicGJChronology) this.iChronology;
        if (basicGJChronology == null) {
            throw null;
        } else if (i <= 28 && i >= 1) {
            return 28;
        } else {
            int year = basicGJChronology.getYear(j);
            return basicGJChronology.getDaysInYearMonth(year, basicGJChronology.getMonthOfYear(j, year));
        }
    }

    public int getMinimumValue() {
        return 1;
    }

    public DurationField getRangeDurationField() {
        return this.iChronology.iMonths;
    }

    public boolean isLeap(long j) {
        return this.iChronology.isLeapDay(j);
    }

    public int getMaximumValue(long j) {
        BasicChronology basicChronology = this.iChronology;
        int year = basicChronology.getYear(j);
        return basicChronology.getDaysInYearMonth(year, basicChronology.getMonthOfYear(j, year));
    }
}
