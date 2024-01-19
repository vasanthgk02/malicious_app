package org.joda.time.chrono;

import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.field.PreciseDurationDateTimeField;

public final class GJDayOfWeekDateTimeField extends PreciseDurationDateTimeField {
    public final BasicChronology iChronology;

    public GJDayOfWeekDateTimeField(BasicChronology basicChronology, DurationField durationField) {
        super(DateTimeFieldType.DAY_OF_WEEK_TYPE, durationField);
        this.iChronology = basicChronology;
    }

    public int convertText(String str, Locale locale) {
        Integer num = GJLocaleSymbols.forLocale(locale).iParseDaysOfWeek.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalFieldValueException(DateTimeFieldType.DAY_OF_WEEK_TYPE, str);
    }

    public int get(long j) {
        return this.iChronology.getDayOfWeek(j);
    }

    public String getAsShortText(int i, Locale locale) {
        return GJLocaleSymbols.forLocale(locale).iShortDaysOfWeek[i];
    }

    public String getAsText(int i, Locale locale) {
        return GJLocaleSymbols.forLocale(locale).iDaysOfWeek[i];
    }

    public int getMaximumTextLength(Locale locale) {
        return GJLocaleSymbols.forLocale(locale).iMaxDayOfWeekLength;
    }

    public int getMaximumValue() {
        return 7;
    }

    public int getMinimumValue() {
        return 1;
    }

    public DurationField getRangeDurationField() {
        return this.iChronology.iWeeks;
    }
}
