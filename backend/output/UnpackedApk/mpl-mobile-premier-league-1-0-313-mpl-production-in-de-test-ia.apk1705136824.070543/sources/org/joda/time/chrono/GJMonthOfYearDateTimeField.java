package org.joda.time.chrono;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Locale;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.field.ImpreciseDateTimeField;

public final class GJMonthOfYearDateTimeField extends ImpreciseDateTimeField {
    public final BasicChronology iChronology;
    public final int iLeapMonth = 2;
    public final int iMax = 12;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public GJMonthOfYearDateTimeField(BasicChronology basicChronology) {
        // GregorianChronology gregorianChronology = (GregorianChronology) basicChronology;
        super(DateTimeFieldType.MONTH_OF_YEAR_TYPE, 2629746000L);
        this.iChronology = basicChronology;
    }

    public long add(long j, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (i == 0) {
            return j;
        }
        long millisOfDay = (long) this.iChronology.getMillisOfDay(j);
        int year = this.iChronology.getYear(j);
        int monthOfYear = this.iChronology.getMonthOfYear(j, year);
        int i7 = monthOfYear - 1;
        int i8 = i7 + i;
        if (monthOfYear <= 0 || i8 >= 0) {
            i2 = year;
        } else {
            if (Math.signum((float) (this.iMax + i)) == Math.signum((float) i)) {
                i6 = year - 1;
                i5 = i + this.iMax;
            } else {
                i6 = year + 1;
                i5 = i - this.iMax;
            }
            int i9 = i6;
            i8 = i5 + i7;
            i2 = i9;
        }
        if (i8 >= 0) {
            int i10 = this.iMax;
            i3 = (i8 / i10) + i2;
            i4 = (i8 % i10) + 1;
        } else {
            i3 = ((i8 / this.iMax) + i2) - 1;
            int abs = Math.abs(i8);
            int i11 = this.iMax;
            int i12 = abs % i11;
            if (i12 != 0) {
                i11 = i12;
            }
            i4 = (this.iMax - i11) + 1;
            if (i4 == 1) {
                i3++;
            }
        }
        int dayOfMonth = this.iChronology.getDayOfMonth(j, year, monthOfYear);
        int daysInYearMonth = this.iChronology.getDaysInYearMonth(i3, i4);
        if (dayOfMonth > daysInYearMonth) {
            dayOfMonth = daysInYearMonth;
        }
        return this.iChronology.getYearMonthDayMillis(i3, i4, dayOfMonth) + millisOfDay;
    }

    public int convertText(String str, Locale locale) {
        Integer num = GJLocaleSymbols.forLocale(locale).iParseMonths.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalFieldValueException(DateTimeFieldType.MONTH_OF_YEAR_TYPE, str);
    }

    public int get(long j) {
        BasicChronology basicChronology = this.iChronology;
        return basicChronology.getMonthOfYear(j, basicChronology.getYear(j));
    }

    public String getAsShortText(int i, Locale locale) {
        return GJLocaleSymbols.forLocale(locale).iShortMonths[i];
    }

    public String getAsText(int i, Locale locale) {
        return GJLocaleSymbols.forLocale(locale).iMonths[i];
    }

    public DurationField getLeapDurationField() {
        return this.iChronology.iDays;
    }

    public int getMaximumTextLength(Locale locale) {
        return GJLocaleSymbols.forLocale(locale).iMaxMonthLength;
    }

    public int getMaximumValue() {
        return this.iMax;
    }

    public int getMinimumValue() {
        return 1;
    }

    public DurationField getRangeDurationField() {
        return this.iChronology.iYears;
    }

    public boolean isLeap(long j) {
        int year = this.iChronology.getYear(j);
        if (!this.iChronology.isLeapYear(year) || this.iChronology.getMonthOfYear(j, year) != this.iLeapMonth) {
            return false;
        }
        return true;
    }

    public boolean isLenient() {
        return false;
    }

    public long remainder(long j) {
        return j - roundFloor(j);
    }

    public long roundFloor(long j) {
        int year = this.iChronology.getYear(j);
        int monthOfYear = this.iChronology.getMonthOfYear(j, year);
        BasicChronology basicChronology = this.iChronology;
        return basicChronology.getTotalMillisByYearMonth(year, monthOfYear) + basicChronology.getYearMillis(year);
    }

    public long set(long j, int i) {
        TypeUtilsKt.verifyValueBounds(this, i, 1, this.iMax);
        int year = this.iChronology.getYear(j);
        BasicChronology basicChronology = this.iChronology;
        int dayOfMonth = basicChronology.getDayOfMonth(j, year, basicChronology.getMonthOfYear(j, year));
        int daysInYearMonth = this.iChronology.getDaysInYearMonth(year, i);
        if (dayOfMonth > daysInYearMonth) {
            dayOfMonth = daysInYearMonth;
        }
        return this.iChronology.getYearMonthDayMillis(year, i, dayOfMonth) + ((long) this.iChronology.getMillisOfDay(j));
    }

    public long add(long j, long j2) {
        long j3;
        long j4;
        long j5 = j;
        long j6 = j2;
        int i = (int) j6;
        if (((long) i) == j6) {
            return add(j5, i);
        }
        long millisOfDay = (long) this.iChronology.getMillisOfDay(j5);
        int year = this.iChronology.getYear(j5);
        int monthOfYear = this.iChronology.getMonthOfYear(j5, year);
        long j7 = ((long) (monthOfYear - 1)) + j6;
        if (j7 >= 0) {
            long j8 = (long) this.iMax;
            j3 = (j7 / j8) + ((long) year);
            j4 = (j7 % j8) + 1;
        } else {
            j3 = ((j7 / ((long) this.iMax)) + ((long) year)) - 1;
            long abs = Math.abs(j7);
            int i2 = this.iMax;
            int i3 = (int) (abs % ((long) i2));
            if (i3 != 0) {
                i2 = i3;
            }
            j4 = (long) ((this.iMax - i2) + 1);
            if (j4 == 1) {
                j3++;
            }
        }
        long j9 = j3;
        BasicChronology basicChronology = this.iChronology;
        GregorianChronology gregorianChronology = (GregorianChronology) basicChronology;
        if (gregorianChronology != null) {
            if (j9 >= ((long) -292275054)) {
                if (gregorianChronology == null) {
                    throw null;
                } else if (j9 <= ((long) 292278993)) {
                    int i4 = (int) j9;
                    int i5 = (int) j4;
                    int dayOfMonth = basicChronology.getDayOfMonth(j5, year, monthOfYear);
                    int daysInYearMonth = this.iChronology.getDaysInYearMonth(i4, i5);
                    if (dayOfMonth > daysInYearMonth) {
                        dayOfMonth = daysInYearMonth;
                    }
                    return this.iChronology.getYearMonthDayMillis(i4, i5, dayOfMonth) + millisOfDay;
                }
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline45("Magnitude of add amount is too large: ", j2));
        }
        throw null;
    }
}
