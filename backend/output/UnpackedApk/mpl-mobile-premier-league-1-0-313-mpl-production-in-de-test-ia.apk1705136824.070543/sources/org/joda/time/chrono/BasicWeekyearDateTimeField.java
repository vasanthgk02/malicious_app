package org.joda.time.chrono;

import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.ImpreciseDateTimeField;

public final class BasicWeekyearDateTimeField extends ImpreciseDateTimeField {
    public final BasicChronology iChronology;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public BasicWeekyearDateTimeField(BasicChronology basicChronology) {
        // GregorianChronology gregorianChronology = (GregorianChronology) basicChronology;
        super(DateTimeFieldType.WEEKYEAR_TYPE, 31556952000L);
        this.iChronology = basicChronology;
    }

    public long add(long j, int i) {
        if (i == 0) {
            return j;
        }
        return set(j, this.iChronology.getWeekyear(j) + i);
    }

    public int get(long j) {
        return this.iChronology.getWeekyear(j);
    }

    public DurationField getLeapDurationField() {
        return this.iChronology.iWeeks;
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
        return basicChronology.getWeeksInYear(basicChronology.getWeekyear(j)) > 52;
    }

    public boolean isLenient() {
        return false;
    }

    public long remainder(long j) {
        return j - roundFloor(j);
    }

    public long roundFloor(long j) {
        long roundFloor = this.iChronology.iWeekOfWeekyear.roundFloor(j);
        int weekOfWeekyear = this.iChronology.getWeekOfWeekyear(roundFloor);
        return weekOfWeekyear > 1 ? roundFloor - (((long) (weekOfWeekyear - 1)) * 604800000) : roundFloor;
    }

    public long set(long j, int i) {
        int abs = Math.abs(i);
        BasicChronology basicChronology = this.iChronology;
        if (((GregorianChronology) basicChronology) == null) {
            throw null;
        } else if (((GregorianChronology) basicChronology) != null) {
            TypeUtilsKt.verifyValueBounds(this, abs, -292275054, 292278993);
            int weekyear = this.iChronology.getWeekyear(j);
            if (weekyear == i) {
                return j;
            }
            int dayOfWeek = this.iChronology.getDayOfWeek(j);
            int weeksInYear = this.iChronology.getWeeksInYear(weekyear);
            int weeksInYear2 = this.iChronology.getWeeksInYear(i);
            if (weeksInYear2 < weeksInYear) {
                weeksInYear = weeksInYear2;
            }
            BasicChronology basicChronology2 = this.iChronology;
            int weekOfWeekyear = basicChronology2.getWeekOfWeekyear(j, basicChronology2.getYear(j));
            if (weekOfWeekyear <= weeksInYear) {
                weeksInYear = weekOfWeekyear;
            }
            long year = this.iChronology.setYear(j, i);
            int i2 = get(year);
            if (i2 < i) {
                year += 604800000;
            } else if (i2 > i) {
                year -= 604800000;
            }
            return this.iChronology.iDayOfWeek.set((((long) (weeksInYear - this.iChronology.getWeekOfWeekyear(year))) * 604800000) + year, dayOfWeek);
        } else {
            throw null;
        }
    }

    public long add(long j, long j2) {
        return add(j, TypeUtilsKt.safeToInt(j2));
    }
}
