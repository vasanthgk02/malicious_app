package org.joda.time.chrono;

import java.io.IOException;
import java.io.ObjectInputStream;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;

public abstract class AssembledChronology extends BaseChronology {
    public static final long serialVersionUID = -6728465968995518215L;
    public final Chronology iBase;
    public transient DurationField iCenturies;
    public transient DateTimeField iCenturyOfEra;
    public transient DateTimeField iClockhourOfDay;
    public transient DateTimeField iClockhourOfHalfday;
    public transient DateTimeField iDayOfMonth;
    public transient DateTimeField iDayOfWeek;
    public transient DateTimeField iDayOfYear;
    public transient DurationField iDays;
    public transient DateTimeField iEra;
    public transient DurationField iEras;
    public transient DateTimeField iHalfdayOfDay;
    public transient DurationField iHalfdays;
    public transient DateTimeField iHourOfDay;
    public transient DateTimeField iHourOfHalfday;
    public transient DurationField iHours;
    public transient DurationField iMillis;
    public transient DateTimeField iMillisOfDay;
    public transient DateTimeField iMillisOfSecond;
    public transient DateTimeField iMinuteOfDay;
    public transient DateTimeField iMinuteOfHour;
    public transient DurationField iMinutes;
    public transient DateTimeField iMonthOfYear;
    public transient DurationField iMonths;
    public final Object iParam;
    public transient DateTimeField iSecondOfDay;
    public transient DateTimeField iSecondOfMinute;
    public transient DurationField iSeconds;
    public transient DateTimeField iWeekOfWeekyear;
    public transient DurationField iWeeks;
    public transient DateTimeField iWeekyear;
    public transient DateTimeField iWeekyearOfCentury;
    public transient DurationField iWeekyears;
    public transient DateTimeField iYear;
    public transient DateTimeField iYearOfCentury;
    public transient DateTimeField iYearOfEra;
    public transient DurationField iYears;

    public static final class Fields {
        public DurationField centuries;
        public DateTimeField centuryOfEra;
        public DateTimeField clockhourOfDay;
        public DateTimeField clockhourOfHalfday;
        public DateTimeField dayOfMonth;
        public DateTimeField dayOfWeek;
        public DateTimeField dayOfYear;
        public DurationField days;
        public DateTimeField era;
        public DurationField eras;
        public DateTimeField halfdayOfDay;
        public DurationField halfdays;
        public DateTimeField hourOfDay;
        public DateTimeField hourOfHalfday;
        public DurationField hours;
        public DurationField millis;
        public DateTimeField millisOfDay;
        public DateTimeField millisOfSecond;
        public DateTimeField minuteOfDay;
        public DateTimeField minuteOfHour;
        public DurationField minutes;
        public DateTimeField monthOfYear;
        public DurationField months;
        public DateTimeField secondOfDay;
        public DateTimeField secondOfMinute;
        public DurationField seconds;
        public DateTimeField weekOfWeekyear;
        public DurationField weeks;
        public DateTimeField weekyear;
        public DateTimeField weekyearOfCentury;
        public DurationField weekyears;
        public DateTimeField year;
        public DateTimeField yearOfCentury;
        public DateTimeField yearOfEra;
        public DurationField years;

        public static boolean isSupported(DurationField durationField) {
            if (durationField == null) {
                return false;
            }
            return durationField.isSupported();
        }

        public static boolean isSupported(DateTimeField dateTimeField) {
            if (dateTimeField == null) {
                return false;
            }
            return dateTimeField.isSupported();
        }
    }

    public AssembledChronology(Chronology chronology, Object obj) {
        this.iBase = chronology;
        this.iParam = obj;
        setFields();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        setFields();
    }

    public abstract void assemble(Fields fields);

    public final DurationField centuries() {
        return this.iCenturies;
    }

    public final DateTimeField centuryOfEra() {
        return this.iCenturyOfEra;
    }

    public final DateTimeField clockhourOfDay() {
        return this.iClockhourOfDay;
    }

    public final DateTimeField clockhourOfHalfday() {
        return this.iClockhourOfHalfday;
    }

    public final DateTimeField dayOfMonth() {
        return this.iDayOfMonth;
    }

    public final DateTimeField dayOfWeek() {
        return this.iDayOfWeek;
    }

    public final DateTimeField dayOfYear() {
        return this.iDayOfYear;
    }

    public final DurationField days() {
        return this.iDays;
    }

    public final DateTimeField era() {
        return this.iEra;
    }

    public final DurationField eras() {
        return this.iEras;
    }

    public DateTimeZone getZone() {
        Chronology chronology = this.iBase;
        if (chronology != null) {
            return chronology.getZone();
        }
        return null;
    }

    public final DateTimeField halfdayOfDay() {
        return this.iHalfdayOfDay;
    }

    public final DurationField halfdays() {
        return this.iHalfdays;
    }

    public final DateTimeField hourOfDay() {
        return this.iHourOfDay;
    }

    public final DateTimeField hourOfHalfday() {
        return this.iHourOfHalfday;
    }

    public final DurationField hours() {
        return this.iHours;
    }

    public final DurationField millis() {
        return this.iMillis;
    }

    public final DateTimeField millisOfDay() {
        return this.iMillisOfDay;
    }

    public final DateTimeField millisOfSecond() {
        return this.iMillisOfSecond;
    }

    public final DateTimeField minuteOfDay() {
        return this.iMinuteOfDay;
    }

    public final DateTimeField minuteOfHour() {
        return this.iMinuteOfHour;
    }

    public final DurationField minutes() {
        return this.iMinutes;
    }

    public final DateTimeField monthOfYear() {
        return this.iMonthOfYear;
    }

    public final DurationField months() {
        return this.iMonths;
    }

    public final DateTimeField secondOfDay() {
        return this.iSecondOfDay;
    }

    public final DateTimeField secondOfMinute() {
        return this.iSecondOfMinute;
    }

    public final DurationField seconds() {
        return this.iSeconds;
    }

    public final void setFields() {
        Fields fields = new Fields();
        Chronology chronology = this.iBase;
        if (chronology != null) {
            DurationField millis = chronology.millis();
            if (Fields.isSupported(millis)) {
                fields.millis = millis;
            }
            DurationField seconds = chronology.seconds();
            if (Fields.isSupported(seconds)) {
                fields.seconds = seconds;
            }
            DurationField minutes = chronology.minutes();
            if (Fields.isSupported(minutes)) {
                fields.minutes = minutes;
            }
            DurationField hours = chronology.hours();
            if (Fields.isSupported(hours)) {
                fields.hours = hours;
            }
            DurationField halfdays = chronology.halfdays();
            if (Fields.isSupported(halfdays)) {
                fields.halfdays = halfdays;
            }
            DurationField days = chronology.days();
            if (Fields.isSupported(days)) {
                fields.days = days;
            }
            DurationField weeks = chronology.weeks();
            if (Fields.isSupported(weeks)) {
                fields.weeks = weeks;
            }
            DurationField weekyears = chronology.weekyears();
            if (Fields.isSupported(weekyears)) {
                fields.weekyears = weekyears;
            }
            DurationField months = chronology.months();
            if (Fields.isSupported(months)) {
                fields.months = months;
            }
            DurationField years = chronology.years();
            if (Fields.isSupported(years)) {
                fields.years = years;
            }
            DurationField centuries = chronology.centuries();
            if (Fields.isSupported(centuries)) {
                fields.centuries = centuries;
            }
            DurationField eras = chronology.eras();
            if (Fields.isSupported(eras)) {
                fields.eras = eras;
            }
            DateTimeField millisOfSecond = chronology.millisOfSecond();
            if (Fields.isSupported(millisOfSecond)) {
                fields.millisOfSecond = millisOfSecond;
            }
            DateTimeField millisOfDay = chronology.millisOfDay();
            if (Fields.isSupported(millisOfDay)) {
                fields.millisOfDay = millisOfDay;
            }
            DateTimeField secondOfMinute = chronology.secondOfMinute();
            if (Fields.isSupported(secondOfMinute)) {
                fields.secondOfMinute = secondOfMinute;
            }
            DateTimeField secondOfDay = chronology.secondOfDay();
            if (Fields.isSupported(secondOfDay)) {
                fields.secondOfDay = secondOfDay;
            }
            DateTimeField minuteOfHour = chronology.minuteOfHour();
            if (Fields.isSupported(minuteOfHour)) {
                fields.minuteOfHour = minuteOfHour;
            }
            DateTimeField minuteOfDay = chronology.minuteOfDay();
            if (Fields.isSupported(minuteOfDay)) {
                fields.minuteOfDay = minuteOfDay;
            }
            DateTimeField hourOfDay = chronology.hourOfDay();
            if (Fields.isSupported(hourOfDay)) {
                fields.hourOfDay = hourOfDay;
            }
            DateTimeField clockhourOfDay = chronology.clockhourOfDay();
            if (Fields.isSupported(clockhourOfDay)) {
                fields.clockhourOfDay = clockhourOfDay;
            }
            DateTimeField hourOfHalfday = chronology.hourOfHalfday();
            if (Fields.isSupported(hourOfHalfday)) {
                fields.hourOfHalfday = hourOfHalfday;
            }
            DateTimeField clockhourOfHalfday = chronology.clockhourOfHalfday();
            if (Fields.isSupported(clockhourOfHalfday)) {
                fields.clockhourOfHalfday = clockhourOfHalfday;
            }
            DateTimeField halfdayOfDay = chronology.halfdayOfDay();
            if (Fields.isSupported(halfdayOfDay)) {
                fields.halfdayOfDay = halfdayOfDay;
            }
            DateTimeField dayOfWeek = chronology.dayOfWeek();
            if (Fields.isSupported(dayOfWeek)) {
                fields.dayOfWeek = dayOfWeek;
            }
            DateTimeField dayOfMonth = chronology.dayOfMonth();
            if (Fields.isSupported(dayOfMonth)) {
                fields.dayOfMonth = dayOfMonth;
            }
            DateTimeField dayOfYear = chronology.dayOfYear();
            if (Fields.isSupported(dayOfYear)) {
                fields.dayOfYear = dayOfYear;
            }
            DateTimeField weekOfWeekyear = chronology.weekOfWeekyear();
            if (Fields.isSupported(weekOfWeekyear)) {
                fields.weekOfWeekyear = weekOfWeekyear;
            }
            DateTimeField weekyear = chronology.weekyear();
            if (Fields.isSupported(weekyear)) {
                fields.weekyear = weekyear;
            }
            DateTimeField weekyearOfCentury = chronology.weekyearOfCentury();
            if (Fields.isSupported(weekyearOfCentury)) {
                fields.weekyearOfCentury = weekyearOfCentury;
            }
            DateTimeField monthOfYear = chronology.monthOfYear();
            if (Fields.isSupported(monthOfYear)) {
                fields.monthOfYear = monthOfYear;
            }
            DateTimeField year = chronology.year();
            if (Fields.isSupported(year)) {
                fields.year = year;
            }
            DateTimeField yearOfEra = chronology.yearOfEra();
            if (Fields.isSupported(yearOfEra)) {
                fields.yearOfEra = yearOfEra;
            }
            DateTimeField yearOfCentury = chronology.yearOfCentury();
            if (Fields.isSupported(yearOfCentury)) {
                fields.yearOfCentury = yearOfCentury;
            }
            DateTimeField centuryOfEra = chronology.centuryOfEra();
            if (Fields.isSupported(centuryOfEra)) {
                fields.centuryOfEra = centuryOfEra;
            }
            DateTimeField era = chronology.era();
            if (Fields.isSupported(era)) {
                fields.era = era;
            }
        }
        assemble(fields);
        DurationField durationField = fields.millis;
        if (durationField == null) {
            durationField = super.millis();
        }
        this.iMillis = durationField;
        DurationField durationField2 = fields.seconds;
        if (durationField2 == null) {
            durationField2 = super.seconds();
        }
        this.iSeconds = durationField2;
        DurationField durationField3 = fields.minutes;
        if (durationField3 == null) {
            durationField3 = super.minutes();
        }
        this.iMinutes = durationField3;
        DurationField durationField4 = fields.hours;
        if (durationField4 == null) {
            durationField4 = super.hours();
        }
        this.iHours = durationField4;
        DurationField durationField5 = fields.halfdays;
        if (durationField5 == null) {
            durationField5 = super.halfdays();
        }
        this.iHalfdays = durationField5;
        DurationField durationField6 = fields.days;
        if (durationField6 == null) {
            durationField6 = super.days();
        }
        this.iDays = durationField6;
        DurationField durationField7 = fields.weeks;
        if (durationField7 == null) {
            durationField7 = super.weeks();
        }
        this.iWeeks = durationField7;
        DurationField durationField8 = fields.weekyears;
        if (durationField8 == null) {
            durationField8 = super.weekyears();
        }
        this.iWeekyears = durationField8;
        DurationField durationField9 = fields.months;
        if (durationField9 == null) {
            durationField9 = super.months();
        }
        this.iMonths = durationField9;
        DurationField durationField10 = fields.years;
        if (durationField10 == null) {
            durationField10 = super.years();
        }
        this.iYears = durationField10;
        DurationField durationField11 = fields.centuries;
        if (durationField11 == null) {
            durationField11 = super.centuries();
        }
        this.iCenturies = durationField11;
        DurationField durationField12 = fields.eras;
        if (durationField12 == null) {
            durationField12 = super.eras();
        }
        this.iEras = durationField12;
        DateTimeField dateTimeField = fields.millisOfSecond;
        if (dateTimeField == null) {
            dateTimeField = super.millisOfSecond();
        }
        this.iMillisOfSecond = dateTimeField;
        DateTimeField dateTimeField2 = fields.millisOfDay;
        if (dateTimeField2 == null) {
            dateTimeField2 = super.millisOfDay();
        }
        this.iMillisOfDay = dateTimeField2;
        DateTimeField dateTimeField3 = fields.secondOfMinute;
        if (dateTimeField3 == null) {
            dateTimeField3 = super.secondOfMinute();
        }
        this.iSecondOfMinute = dateTimeField3;
        DateTimeField dateTimeField4 = fields.secondOfDay;
        if (dateTimeField4 == null) {
            dateTimeField4 = super.secondOfDay();
        }
        this.iSecondOfDay = dateTimeField4;
        DateTimeField dateTimeField5 = fields.minuteOfHour;
        if (dateTimeField5 == null) {
            dateTimeField5 = super.minuteOfHour();
        }
        this.iMinuteOfHour = dateTimeField5;
        DateTimeField dateTimeField6 = fields.minuteOfDay;
        if (dateTimeField6 == null) {
            dateTimeField6 = super.minuteOfDay();
        }
        this.iMinuteOfDay = dateTimeField6;
        DateTimeField dateTimeField7 = fields.hourOfDay;
        if (dateTimeField7 == null) {
            dateTimeField7 = super.hourOfDay();
        }
        this.iHourOfDay = dateTimeField7;
        DateTimeField dateTimeField8 = fields.clockhourOfDay;
        if (dateTimeField8 == null) {
            dateTimeField8 = super.clockhourOfDay();
        }
        this.iClockhourOfDay = dateTimeField8;
        DateTimeField dateTimeField9 = fields.hourOfHalfday;
        if (dateTimeField9 == null) {
            dateTimeField9 = super.hourOfHalfday();
        }
        this.iHourOfHalfday = dateTimeField9;
        DateTimeField dateTimeField10 = fields.clockhourOfHalfday;
        if (dateTimeField10 == null) {
            dateTimeField10 = super.clockhourOfHalfday();
        }
        this.iClockhourOfHalfday = dateTimeField10;
        DateTimeField dateTimeField11 = fields.halfdayOfDay;
        if (dateTimeField11 == null) {
            dateTimeField11 = super.halfdayOfDay();
        }
        this.iHalfdayOfDay = dateTimeField11;
        DateTimeField dateTimeField12 = fields.dayOfWeek;
        if (dateTimeField12 == null) {
            dateTimeField12 = super.dayOfWeek();
        }
        this.iDayOfWeek = dateTimeField12;
        DateTimeField dateTimeField13 = fields.dayOfMonth;
        if (dateTimeField13 == null) {
            dateTimeField13 = super.dayOfMonth();
        }
        this.iDayOfMonth = dateTimeField13;
        DateTimeField dateTimeField14 = fields.dayOfYear;
        if (dateTimeField14 == null) {
            dateTimeField14 = super.dayOfYear();
        }
        this.iDayOfYear = dateTimeField14;
        DateTimeField dateTimeField15 = fields.weekOfWeekyear;
        if (dateTimeField15 == null) {
            dateTimeField15 = super.weekOfWeekyear();
        }
        this.iWeekOfWeekyear = dateTimeField15;
        DateTimeField dateTimeField16 = fields.weekyear;
        if (dateTimeField16 == null) {
            dateTimeField16 = super.weekyear();
        }
        this.iWeekyear = dateTimeField16;
        DateTimeField dateTimeField17 = fields.weekyearOfCentury;
        if (dateTimeField17 == null) {
            dateTimeField17 = super.weekyearOfCentury();
        }
        this.iWeekyearOfCentury = dateTimeField17;
        DateTimeField dateTimeField18 = fields.monthOfYear;
        if (dateTimeField18 == null) {
            dateTimeField18 = super.monthOfYear();
        }
        this.iMonthOfYear = dateTimeField18;
        DateTimeField dateTimeField19 = fields.year;
        if (dateTimeField19 == null) {
            dateTimeField19 = super.year();
        }
        this.iYear = dateTimeField19;
        DateTimeField dateTimeField20 = fields.yearOfEra;
        if (dateTimeField20 == null) {
            dateTimeField20 = super.yearOfEra();
        }
        this.iYearOfEra = dateTimeField20;
        DateTimeField dateTimeField21 = fields.yearOfCentury;
        if (dateTimeField21 == null) {
            dateTimeField21 = super.yearOfCentury();
        }
        this.iYearOfCentury = dateTimeField21;
        DateTimeField dateTimeField22 = fields.centuryOfEra;
        if (dateTimeField22 == null) {
            dateTimeField22 = super.centuryOfEra();
        }
        this.iCenturyOfEra = dateTimeField22;
        DateTimeField dateTimeField23 = fields.era;
        if (dateTimeField23 == null) {
            dateTimeField23 = super.era();
        }
        this.iEra = dateTimeField23;
        Chronology chronology2 = this.iBase;
        if (chronology2 != null) {
            if (this.iHourOfDay == chronology2.hourOfDay() && this.iMinuteOfHour == this.iBase.minuteOfHour() && this.iSecondOfMinute == this.iBase.secondOfMinute()) {
                DateTimeField dateTimeField24 = this.iMillisOfSecond;
                DateTimeField millisOfSecond2 = this.iBase.millisOfSecond();
            }
            DateTimeField dateTimeField25 = this.iMillisOfDay;
            DateTimeField millisOfDay2 = this.iBase.millisOfDay();
            if (this.iYear == this.iBase.year() && this.iMonthOfYear == this.iBase.monthOfYear()) {
                DateTimeField dateTimeField26 = this.iDayOfMonth;
                DateTimeField dayOfMonth2 = this.iBase.dayOfMonth();
            }
        }
    }

    public final DateTimeField weekOfWeekyear() {
        return this.iWeekOfWeekyear;
    }

    public final DurationField weeks() {
        return this.iWeeks;
    }

    public final DateTimeField weekyear() {
        return this.iWeekyear;
    }

    public final DateTimeField weekyearOfCentury() {
        return this.iWeekyearOfCentury;
    }

    public final DurationField weekyears() {
        return this.iWeekyears;
    }

    public final DateTimeField year() {
        return this.iYear;
    }

    public final DateTimeField yearOfCentury() {
        return this.iYearOfCentury;
    }

    public final DateTimeField yearOfEra() {
        return this.iYearOfEra;
    }

    public final DurationField years() {
        return this.iYears;
    }
}
