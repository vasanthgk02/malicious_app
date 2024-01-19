package org.joda.time.tz;

import java.io.DataInput;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.joda.time.chrono.ISOChronology;

public final class DateTimeZoneBuilder$Recurrence {
    public final String iNameKey;
    public final DateTimeZoneBuilder$OfYear iOfYear;
    public final int iSaveMillis;

    public DateTimeZoneBuilder$Recurrence(DateTimeZoneBuilder$OfYear dateTimeZoneBuilder$OfYear, String str, int i) {
        this.iOfYear = dateTimeZoneBuilder$OfYear;
        this.iNameKey = str;
        this.iSaveMillis = i;
    }

    public static DateTimeZoneBuilder$Recurrence readFrom(DataInput dataInput) throws IOException {
        DateTimeZoneBuilder$OfYear dateTimeZoneBuilder$OfYear = new DateTimeZoneBuilder$OfYear((char) dataInput.readUnsignedByte(), dataInput.readUnsignedByte(), dataInput.readByte(), dataInput.readUnsignedByte(), dataInput.readBoolean(), (int) TypeUtilsKt.readMillis(dataInput));
        return new DateTimeZoneBuilder$Recurrence(dateTimeZoneBuilder$OfYear, dataInput.readUTF(), (int) TypeUtilsKt.readMillis(dataInput));
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DateTimeZoneBuilder$Recurrence)) {
            return false;
        }
        DateTimeZoneBuilder$Recurrence dateTimeZoneBuilder$Recurrence = (DateTimeZoneBuilder$Recurrence) obj;
        if (this.iSaveMillis != dateTimeZoneBuilder$Recurrence.iSaveMillis || !this.iNameKey.equals(dateTimeZoneBuilder$Recurrence.iNameKey) || !this.iOfYear.equals(dateTimeZoneBuilder$Recurrence.iOfYear)) {
            z = false;
        }
        return z;
    }

    public long next(long j, int i, int i2) {
        DateTimeZoneBuilder$OfYear dateTimeZoneBuilder$OfYear = this.iOfYear;
        char c2 = dateTimeZoneBuilder$OfYear.iMode;
        if (c2 == 'w') {
            i += i2;
        } else if (c2 != 's') {
            i = 0;
        }
        long j2 = (long) i;
        long j3 = j + j2;
        ISOChronology iSOChronology = ISOChronology.INSTANCE_UTC;
        long dayOfMonthNext = dateTimeZoneBuilder$OfYear.setDayOfMonthNext(iSOChronology, iSOChronology.iMillisOfDay.add(iSOChronology.iMillisOfDay.set(iSOChronology.iMonthOfYear.set(j3, dateTimeZoneBuilder$OfYear.iMonthOfYear), 0), Math.min(dateTimeZoneBuilder$OfYear.iMillisOfDay, 86399999)));
        if (dateTimeZoneBuilder$OfYear.iDayOfWeek != 0) {
            dayOfMonthNext = dateTimeZoneBuilder$OfYear.setDayOfWeek(iSOChronology, dayOfMonthNext);
            if (dayOfMonthNext <= j3) {
                dayOfMonthNext = dateTimeZoneBuilder$OfYear.setDayOfWeek(iSOChronology, dateTimeZoneBuilder$OfYear.setDayOfMonthNext(iSOChronology, iSOChronology.iMonthOfYear.set(iSOChronology.iYear.add(dayOfMonthNext, 1), dateTimeZoneBuilder$OfYear.iMonthOfYear)));
            }
        } else if (dayOfMonthNext <= j3) {
            dayOfMonthNext = dateTimeZoneBuilder$OfYear.setDayOfMonthNext(iSOChronology, iSOChronology.iYear.add(dayOfMonthNext, 1));
        }
        return iSOChronology.iMillisOfDay.add(iSOChronology.iMillisOfDay.set(dayOfMonthNext, 0), dateTimeZoneBuilder$OfYear.iMillisOfDay) - j2;
    }

    public long previous(long j, int i, int i2) {
        DateTimeZoneBuilder$OfYear dateTimeZoneBuilder$OfYear = this.iOfYear;
        char c2 = dateTimeZoneBuilder$OfYear.iMode;
        if (c2 == 'w') {
            i += i2;
        } else if (c2 != 's') {
            i = 0;
        }
        long j2 = (long) i;
        long j3 = j + j2;
        ISOChronology iSOChronology = ISOChronology.INSTANCE_UTC;
        long dayOfMonthPrevious = dateTimeZoneBuilder$OfYear.setDayOfMonthPrevious(iSOChronology, iSOChronology.iMillisOfDay.add(iSOChronology.iMillisOfDay.set(iSOChronology.iMonthOfYear.set(j3, dateTimeZoneBuilder$OfYear.iMonthOfYear), 0), dateTimeZoneBuilder$OfYear.iMillisOfDay));
        if (dateTimeZoneBuilder$OfYear.iDayOfWeek != 0) {
            dayOfMonthPrevious = dateTimeZoneBuilder$OfYear.setDayOfWeek(iSOChronology, dayOfMonthPrevious);
            if (dayOfMonthPrevious >= j3) {
                dayOfMonthPrevious = dateTimeZoneBuilder$OfYear.setDayOfWeek(iSOChronology, dateTimeZoneBuilder$OfYear.setDayOfMonthPrevious(iSOChronology, iSOChronology.iMonthOfYear.set(iSOChronology.iYear.add(dayOfMonthPrevious, -1), dateTimeZoneBuilder$OfYear.iMonthOfYear)));
            }
        } else if (dayOfMonthPrevious >= j3) {
            dayOfMonthPrevious = dateTimeZoneBuilder$OfYear.setDayOfMonthPrevious(iSOChronology, iSOChronology.iYear.add(dayOfMonthPrevious, -1));
        }
        return iSOChronology.iMillisOfDay.add(iSOChronology.iMillisOfDay.set(dayOfMonthPrevious, 0), dateTimeZoneBuilder$OfYear.iMillisOfDay) - j2;
    }

    public String toString() {
        return this.iOfYear + " named " + this.iNameKey + " at " + this.iSaveMillis;
    }
}
