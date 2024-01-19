package org.joda.time.chrono;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.Constant;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.chrono.AssembledChronology.Fields;
import org.joda.time.field.DividedDateTimeField;
import org.joda.time.field.MillisDurationField;
import org.joda.time.field.OffsetDateTimeField;
import org.joda.time.field.PreciseDateTimeField;
import org.joda.time.field.PreciseDurationField;
import org.joda.time.field.RemainderDateTimeField;
import org.joda.time.field.ZeroIsMaxDateTimeField;

public abstract class BasicChronology extends AssembledChronology {
    public static final DateTimeField cClockhourOfDayField = new ZeroIsMaxDateTimeField(cHourOfDayField, DateTimeFieldType.CLOCKHOUR_OF_DAY_TYPE);
    public static final DateTimeField cClockhourOfHalfdayField = new ZeroIsMaxDateTimeField(cHourOfHalfdayField, DateTimeFieldType.CLOCKHOUR_OF_HALFDAY_TYPE);
    public static final DurationField cDaysField = new PreciseDurationField(DurationFieldType.DAYS_TYPE, 86400000);
    public static final DateTimeField cHalfdayOfDayField = new HalfdayField();
    public static final DurationField cHalfdaysField = new PreciseDurationField(DurationFieldType.HALFDAYS_TYPE, 43200000);
    public static final DateTimeField cHourOfDayField = new PreciseDateTimeField(DateTimeFieldType.HOUR_OF_DAY_TYPE, cHoursField, cDaysField);
    public static final DateTimeField cHourOfHalfdayField = new PreciseDateTimeField(DateTimeFieldType.HOUR_OF_HALFDAY_TYPE, cHoursField, cHalfdaysField);
    public static final DurationField cHoursField = new PreciseDurationField(DurationFieldType.HOURS_TYPE, 3600000);
    public static final DurationField cMillisField = MillisDurationField.INSTANCE;
    public static final DateTimeField cMillisOfDayField = new PreciseDateTimeField(DateTimeFieldType.MILLIS_OF_DAY_TYPE, cMillisField, cDaysField);
    public static final DateTimeField cMillisOfSecondField = new PreciseDateTimeField(DateTimeFieldType.MILLIS_OF_SECOND_TYPE, cMillisField, cSecondsField);
    public static final DateTimeField cMinuteOfDayField = new PreciseDateTimeField(DateTimeFieldType.MINUTE_OF_DAY_TYPE, cMinutesField, cDaysField);
    public static final DateTimeField cMinuteOfHourField = new PreciseDateTimeField(DateTimeFieldType.MINUTE_OF_HOUR_TYPE, cMinutesField, cHoursField);
    public static final DurationField cMinutesField = new PreciseDurationField(DurationFieldType.MINUTES_TYPE, 60000);
    public static final DateTimeField cSecondOfDayField = new PreciseDateTimeField(DateTimeFieldType.SECOND_OF_DAY_TYPE, cSecondsField, cDaysField);
    public static final DateTimeField cSecondOfMinuteField = new PreciseDateTimeField(DateTimeFieldType.SECOND_OF_MINUTE_TYPE, cSecondsField, cMinutesField);
    public static final DurationField cSecondsField = new PreciseDurationField(DurationFieldType.SECONDS_TYPE, 1000);
    public static final DurationField cWeeksField = new PreciseDurationField(DurationFieldType.WEEKS_TYPE, 604800000);
    public static final long serialVersionUID = 8283225332206808863L;
    public final int iMinDaysInFirstWeek;
    public final transient YearInfo[] iYearInfoCache = new YearInfo[1024];

    public static class HalfdayField extends PreciseDateTimeField {
        public HalfdayField() {
            super(DateTimeFieldType.HALFDAY_OF_DAY_TYPE, BasicChronology.cHalfdaysField, BasicChronology.cDaysField);
        }

        public String getAsText(int i, Locale locale) {
            return GJLocaleSymbols.forLocale(locale).iHalfday[i];
        }

        public int getMaximumTextLength(Locale locale) {
            return GJLocaleSymbols.forLocale(locale).iMaxHalfdayLength;
        }

        public long set(long j, String str, Locale locale) {
            String[] strArr = GJLocaleSymbols.forLocale(locale).iHalfday;
            int length = strArr.length;
            do {
                length--;
                if (length < 0) {
                    throw new IllegalFieldValueException(DateTimeFieldType.HALFDAY_OF_DAY_TYPE, str);
                }
            } while (!strArr[length].equalsIgnoreCase(str));
            return set(j, length);
        }
    }

    public static class YearInfo {
        public final long iFirstDayMillis;
        public final int iYear;

        public YearInfo(int i, long j) {
            this.iYear = i;
            this.iFirstDayMillis = j;
        }
    }

    public BasicChronology(Chronology chronology, Object obj, int i) {
        super(chronology, obj);
        if (i < 1 || i > 7) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("Invalid min days in first week: ", i));
        }
        this.iMinDaysInFirstWeek = i;
    }

    public void assemble(Fields fields) {
        fields.millis = cMillisField;
        fields.seconds = cSecondsField;
        fields.minutes = cMinutesField;
        fields.hours = cHoursField;
        fields.halfdays = cHalfdaysField;
        fields.days = cDaysField;
        fields.weeks = cWeeksField;
        fields.millisOfSecond = cMillisOfSecondField;
        fields.millisOfDay = cMillisOfDayField;
        fields.secondOfMinute = cSecondOfMinuteField;
        fields.secondOfDay = cSecondOfDayField;
        fields.minuteOfHour = cMinuteOfHourField;
        fields.minuteOfDay = cMinuteOfDayField;
        fields.hourOfDay = cHourOfDayField;
        fields.hourOfHalfday = cHourOfHalfdayField;
        fields.clockhourOfDay = cClockhourOfDayField;
        fields.clockhourOfHalfday = cClockhourOfHalfdayField;
        fields.halfdayOfDay = cHalfdayOfDayField;
        BasicYearDateTimeField basicYearDateTimeField = new BasicYearDateTimeField(this);
        fields.year = basicYearDateTimeField;
        GJYearOfEraDateTimeField gJYearOfEraDateTimeField = new GJYearOfEraDateTimeField(basicYearDateTimeField, this);
        fields.yearOfEra = gJYearOfEraDateTimeField;
        OffsetDateTimeField offsetDateTimeField = new OffsetDateTimeField(gJYearOfEraDateTimeField, gJYearOfEraDateTimeField.iType, 99, LinearLayoutManager.INVALID_OFFSET, Integer.MAX_VALUE);
        DividedDateTimeField dividedDateTimeField = new DividedDateTimeField(offsetDateTimeField, DateTimeFieldType.CENTURY_OF_ERA_TYPE, 100);
        fields.centuryOfEra = dividedDateTimeField;
        fields.centuries = dividedDateTimeField.iDurationField;
        DividedDateTimeField dividedDateTimeField2 = dividedDateTimeField;
        OffsetDateTimeField offsetDateTimeField2 = new OffsetDateTimeField(new RemainderDateTimeField(dividedDateTimeField2, dividedDateTimeField2.iType), DateTimeFieldType.YEAR_OF_CENTURY_TYPE, 1, LinearLayoutManager.INVALID_OFFSET, Integer.MAX_VALUE);
        fields.yearOfCentury = offsetDateTimeField2;
        fields.era = new GJEraDateTimeField(this);
        fields.dayOfWeek = new GJDayOfWeekDateTimeField(this, fields.days);
        fields.dayOfMonth = new BasicDayOfMonthDateTimeField(this, fields.days);
        fields.dayOfYear = new BasicDayOfYearDateTimeField(this, fields.days);
        fields.monthOfYear = new GJMonthOfYearDateTimeField(this);
        fields.weekyear = new BasicWeekyearDateTimeField(this);
        fields.weekOfWeekyear = new BasicWeekOfWeekyearDateTimeField(this, fields.weeks);
        OffsetDateTimeField offsetDateTimeField3 = new OffsetDateTimeField(new RemainderDateTimeField(fields.weekyear, fields.centuries, DateTimeFieldType.WEEKYEAR_OF_CENTURY_TYPE, 100), DateTimeFieldType.WEEKYEAR_OF_CENTURY_TYPE, 1, LinearLayoutManager.INVALID_OFFSET, Integer.MAX_VALUE);
        fields.weekyearOfCentury = offsetDateTimeField3;
        fields.years = fields.year.getDurationField();
        fields.months = fields.monthOfYear.getDurationField();
        fields.weekyears = fields.weekyear.getDurationField();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BasicChronology basicChronology = (BasicChronology) obj;
        if (this.iMinDaysInFirstWeek != basicChronology.iMinDaysInFirstWeek || !getZone().equals(basicChronology.getZone())) {
            z = false;
        }
        return z;
    }

    public int getDayOfMonth(long j, int i, int i2) {
        return ((int) ((j - (getTotalMillisByYearMonth(i, i2) + getYearMillis(i))) / 86400000)) + 1;
    }

    public int getDayOfWeek(long j) {
        long j2;
        if (j >= 0) {
            j2 = j / 86400000;
        } else {
            j2 = (j - 86399999) / 86400000;
            if (j2 < -3) {
                return ((int) ((j2 + 4) % 7)) + 7;
            }
        }
        return ((int) ((j2 + 3) % 7)) + 1;
    }

    public abstract int getDaysInYearMonth(int i, int i2);

    public long getFirstWeekOfYearMillis(int i) {
        long yearMillis = getYearMillis(i);
        int dayOfWeek = getDayOfWeek(yearMillis);
        return dayOfWeek > 8 - this.iMinDaysInFirstWeek ? (((long) (8 - dayOfWeek)) * 86400000) + yearMillis : yearMillis - (((long) (dayOfWeek - 1)) * 86400000);
    }

    public int getMillisOfDay(long j) {
        if (j >= 0) {
            return (int) (j % 86400000);
        }
        return ((int) ((j + 1) % 86400000)) + 86399999;
    }

    public abstract int getMonthOfYear(long j, int i);

    public abstract long getTotalMillisByYearMonth(int i, int i2);

    public int getWeekOfWeekyear(long j) {
        return getWeekOfWeekyear(j, getYear(j));
    }

    public int getWeeksInYear(int i) {
        return (int) ((getFirstWeekOfYearMillis(i + 1) - getFirstWeekOfYearMillis(i)) / 604800000);
    }

    public int getWeekyear(long j) {
        int year = getYear(j);
        int weekOfWeekyear = getWeekOfWeekyear(j, year);
        if (weekOfWeekyear == 1) {
            return getYear(j + 604800000);
        }
        return weekOfWeekyear > 51 ? getYear(j - 1209600000) : year;
    }

    public int getYear(long j) {
        long j2 = (j >> 1) + 31083597720000L;
        if (j2 < 0) {
            j2 = (j2 - 15778476000L) + 1;
        }
        int i = (int) (j2 / 15778476000L);
        long yearMillis = getYearMillis(i);
        long j3 = j - yearMillis;
        if (j3 < 0) {
            return i - 1;
        }
        long j4 = 31536000000L;
        if (j3 < 31536000000L) {
            return i;
        }
        if (isLeapYear(i)) {
            j4 = 31622400000L;
        }
        return yearMillis + j4 <= j ? i + 1 : i;
    }

    public long getYearMillis(int i) {
        int i2;
        YearInfo[] yearInfoArr = this.iYearInfoCache;
        int i3 = i & Constant.PERMISSIONS_REQUEST_AUDIO;
        YearInfo yearInfo = yearInfoArr[i3];
        if (yearInfo == null || yearInfo.iYear != i) {
            GregorianChronology gregorianChronology = (GregorianChronology) this;
            int i4 = i / 100;
            if (i < 0) {
                i2 = ((((i + 3) >> 2) - i4) + ((i4 + 3) >> 2)) - 1;
            } else {
                i2 = gregorianChronology.isLeapYear(i) ? ((i4 >> 2) + ((i >> 2) - i4)) - 1 : (i4 >> 2) + ((i >> 2) - i4);
            }
            yearInfo = new YearInfo(i, ((((long) i) * 365) + ((long) (i2 - 719527))) * 86400000);
            this.iYearInfoCache[i3] = yearInfo;
        }
        return yearInfo.iFirstDayMillis;
    }

    public long getYearMonthDayMillis(int i, int i2, int i3) {
        return (((long) (i3 - 1)) * 86400000) + getTotalMillisByYearMonth(i, i2) + getYearMillis(i);
    }

    public DateTimeZone getZone() {
        Chronology chronology = this.iBase;
        if (chronology != null) {
            return chronology.getZone();
        }
        return DateTimeZone.UTC;
    }

    public int hashCode() {
        return getZone().hashCode() + (getClass().getName().hashCode() * 11) + this.iMinDaysInFirstWeek;
    }

    public boolean isLeapDay(long j) {
        return false;
    }

    public abstract boolean isLeapYear(int i);

    public abstract long setYear(long j, int i);

    public String toString() {
        StringBuilder sb = new StringBuilder(60);
        String name = getClass().getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            name = name.substring(lastIndexOf + 1);
        }
        sb.append(name);
        sb.append('[');
        DateTimeZone zone = getZone();
        if (zone != null) {
            sb.append(zone.iID);
        }
        if (this.iMinDaysInFirstWeek != 4) {
            sb.append(",mdfw=");
            sb.append(this.iMinDaysInFirstWeek);
        }
        sb.append(']');
        return sb.toString();
    }

    public int getWeekOfWeekyear(long j, int i) {
        long firstWeekOfYearMillis = getFirstWeekOfYearMillis(i);
        if (j < firstWeekOfYearMillis) {
            return getWeeksInYear(i - 1);
        }
        if (j >= getFirstWeekOfYearMillis(i + 1)) {
            return 1;
        }
        return ((int) ((j - firstWeekOfYearMillis) / 604800000)) + 1;
    }
}
