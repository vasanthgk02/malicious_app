package org.joda.time.tz;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.joda.time.Chronology;
import org.joda.time.chrono.AssembledChronology;

public final class DateTimeZoneBuilder$OfYear {
    public final boolean iAdvance;
    public final int iDayOfMonth;
    public final int iDayOfWeek;
    public final int iMillisOfDay;
    public final char iMode;
    public final int iMonthOfYear;

    public DateTimeZoneBuilder$OfYear(char c2, int i, int i2, int i3, boolean z, int i4) {
        if (c2 == 'u' || c2 == 'w' || c2 == 's') {
            this.iMode = c2;
            this.iMonthOfYear = i;
            this.iDayOfMonth = i2;
            this.iDayOfWeek = i3;
            this.iAdvance = z;
            this.iMillisOfDay = i4;
            return;
        }
        throw new IllegalArgumentException("Unknown mode: " + c2);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DateTimeZoneBuilder$OfYear)) {
            return false;
        }
        DateTimeZoneBuilder$OfYear dateTimeZoneBuilder$OfYear = (DateTimeZoneBuilder$OfYear) obj;
        if (!(this.iMode == dateTimeZoneBuilder$OfYear.iMode && this.iMonthOfYear == dateTimeZoneBuilder$OfYear.iMonthOfYear && this.iDayOfMonth == dateTimeZoneBuilder$OfYear.iDayOfMonth && this.iDayOfWeek == dateTimeZoneBuilder$OfYear.iDayOfWeek && this.iAdvance == dateTimeZoneBuilder$OfYear.iAdvance && this.iMillisOfDay == dateTimeZoneBuilder$OfYear.iMillisOfDay)) {
            z = false;
        }
        return z;
    }

    public final long setDayOfMonth(Chronology chronology, long j) {
        if (this.iDayOfMonth >= 0) {
            return chronology.dayOfMonth().set(j, this.iDayOfMonth);
        }
        return chronology.dayOfMonth().add(chronology.monthOfYear().add(chronology.dayOfMonth().set(j, 1), 1), this.iDayOfMonth);
    }

    public final long setDayOfMonthNext(Chronology chronology, long j) {
        try {
            return setDayOfMonth(chronology, j);
        } catch (IllegalArgumentException e2) {
            if (this.iMonthOfYear == 2 && this.iDayOfMonth == 29) {
                while (true) {
                    AssembledChronology assembledChronology = (AssembledChronology) chronology;
                    if (assembledChronology.iYear.isLeap(j)) {
                        return setDayOfMonth(chronology, j);
                    }
                    j = assembledChronology.iYear.add(j, 1);
                }
            } else {
                throw e2;
            }
        }
    }

    public final long setDayOfMonthPrevious(Chronology chronology, long j) {
        try {
            return setDayOfMonth(chronology, j);
        } catch (IllegalArgumentException e2) {
            if (this.iMonthOfYear == 2 && this.iDayOfMonth == 29) {
                while (true) {
                    AssembledChronology assembledChronology = (AssembledChronology) chronology;
                    if (assembledChronology.iYear.isLeap(j)) {
                        return setDayOfMonth(chronology, j);
                    }
                    j = assembledChronology.iYear.add(j, -1);
                }
            } else {
                throw e2;
            }
        }
    }

    public final long setDayOfWeek(Chronology chronology, long j) {
        AssembledChronology assembledChronology = (AssembledChronology) chronology;
        int i = this.iDayOfWeek - assembledChronology.iDayOfWeek.get(j);
        if (i == 0) {
            return j;
        }
        if (this.iAdvance) {
            if (i < 0) {
                i += 7;
            }
        } else if (i > 0) {
            i -= 7;
        }
        return assembledChronology.iDayOfWeek.add(j, i);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[OfYear]\nMode: ");
        outline73.append(this.iMode);
        outline73.append(10);
        outline73.append("MonthOfYear: ");
        outline73.append(this.iMonthOfYear);
        outline73.append(10);
        outline73.append("DayOfMonth: ");
        outline73.append(this.iDayOfMonth);
        outline73.append(10);
        outline73.append("DayOfWeek: ");
        outline73.append(this.iDayOfWeek);
        outline73.append(10);
        outline73.append("AdvanceDayOfWeek: ");
        outline73.append(this.iAdvance);
        outline73.append(10);
        outline73.append("MillisOfDay: ");
        return GeneratedOutlineSupport.outline56(outline73, this.iMillisOfDay, 10);
    }
}
