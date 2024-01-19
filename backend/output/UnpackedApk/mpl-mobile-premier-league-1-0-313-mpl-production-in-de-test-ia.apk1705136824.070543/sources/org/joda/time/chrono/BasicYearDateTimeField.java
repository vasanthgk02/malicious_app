package org.joda.time.chrono;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.ImpreciseDateTimeField;

public class BasicYearDateTimeField extends ImpreciseDateTimeField {
    public final BasicChronology iChronology;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public BasicYearDateTimeField(BasicChronology basicChronology) {
        // GregorianChronology gregorianChronology = (GregorianChronology) basicChronology;
        super(DateTimeFieldType.YEAR_TYPE, 31556952000L);
        this.iChronology = basicChronology;
    }

    public long add(long j, int i) {
        if (i == 0) {
            return j;
        }
        int year = this.iChronology.getYear(j);
        int i2 = year + i;
        if ((year ^ i2) >= 0 || (year ^ i) < 0) {
            return set(j, i2);
        }
        throw new ArithmeticException(GeneratedOutlineSupport.outline43("The calculation caused an overflow: ", year, " + ", i));
    }

    public int get(long j) {
        return this.iChronology.getYear(j);
    }

    public DurationField getLeapDurationField() {
        return this.iChronology.iDays;
    }

    public int getMaximumValue() {
        if (((GregorianChronology) this.iChronology) != null) {
            return 292278993;
        }
        throw null;
    }

    public int getMinimumValue() {
        if (((GregorianChronology) this.iChronology) != null) {
            return -292275054;
        }
        throw null;
    }

    public DurationField getRangeDurationField() {
        return null;
    }

    public boolean isLeap(long j) {
        BasicChronology basicChronology = this.iChronology;
        return basicChronology.isLeapYear(basicChronology.getYear(j));
    }

    public boolean isLenient() {
        return false;
    }

    public long remainder(long j) {
        BasicChronology basicChronology = this.iChronology;
        return j - basicChronology.getYearMillis(basicChronology.getYear(j));
    }

    public long roundCeiling(long j) {
        int year = this.iChronology.getYear(j);
        return j != this.iChronology.getYearMillis(year) ? this.iChronology.getYearMillis(year + 1) : j;
    }

    public long roundFloor(long j) {
        BasicChronology basicChronology = this.iChronology;
        return basicChronology.getYearMillis(basicChronology.getYear(j));
    }

    public long set(long j, int i) {
        BasicChronology basicChronology = this.iChronology;
        if (((GregorianChronology) basicChronology) == null) {
            throw null;
        } else if (((GregorianChronology) basicChronology) != null) {
            TypeUtilsKt.verifyValueBounds(this, i, -292275054, 292278993);
            return this.iChronology.setYear(j, i);
        } else {
            throw null;
        }
    }

    public long setExtended(long j, int i) {
        BasicChronology basicChronology = this.iChronology;
        if (((GregorianChronology) basicChronology) == null) {
            throw null;
        } else if (((GregorianChronology) basicChronology) != null) {
            TypeUtilsKt.verifyValueBounds(this, i, -292275055, 292278994);
            return this.iChronology.setYear(j, i);
        } else {
            throw null;
        }
    }

    public long add(long j, long j2) {
        return add(j, TypeUtilsKt.safeToInt(j2));
    }
}
