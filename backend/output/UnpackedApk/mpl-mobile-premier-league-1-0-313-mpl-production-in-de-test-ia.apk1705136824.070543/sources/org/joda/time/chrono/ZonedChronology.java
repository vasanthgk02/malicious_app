package org.joda.time.chrono;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.HashMap;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.IllegalInstantException;
import org.joda.time.chrono.AssembledChronology.Fields;
import org.joda.time.field.BaseDateTimeField;
import org.joda.time.field.BaseDurationField;

public final class ZonedChronology extends AssembledChronology {
    public static final long serialVersionUID = -1079258847191166848L;

    public static final class ZonedDateTimeField extends BaseDateTimeField {
        public final DurationField iDurationField;
        public final DateTimeField iField;
        public final DurationField iLeapDurationField;
        public final DurationField iRangeDurationField;
        public final boolean iTimeField;
        public final DateTimeZone iZone;

        public ZonedDateTimeField(DateTimeField dateTimeField, DateTimeZone dateTimeZone, DurationField durationField, DurationField durationField2, DurationField durationField3) {
            super(dateTimeField.getType());
            if (dateTimeField.isSupported()) {
                this.iField = dateTimeField;
                this.iZone = dateTimeZone;
                this.iDurationField = durationField;
                this.iTimeField = durationField != null && durationField.getUnitMillis() < 43200000;
                this.iRangeDurationField = durationField2;
                this.iLeapDurationField = durationField3;
                return;
            }
            throw new IllegalArgumentException();
        }

        public long add(long j, int i) {
            if (this.iTimeField) {
                long offsetToAdd = (long) getOffsetToAdd(j);
                return this.iField.add(j + offsetToAdd, i) - offsetToAdd;
            }
            return this.iZone.convertLocalToUTC(this.iField.add(this.iZone.convertUTCToLocal(j), i), false, j);
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ZonedDateTimeField)) {
                return false;
            }
            ZonedDateTimeField zonedDateTimeField = (ZonedDateTimeField) obj;
            if (!this.iField.equals(zonedDateTimeField.iField) || !this.iZone.equals(zonedDateTimeField.iZone) || !this.iDurationField.equals(zonedDateTimeField.iDurationField) || !this.iRangeDurationField.equals(zonedDateTimeField.iRangeDurationField)) {
                z = false;
            }
            return z;
        }

        public int get(long j) {
            return this.iField.get(this.iZone.convertUTCToLocal(j));
        }

        public String getAsShortText(long j, Locale locale) {
            return this.iField.getAsShortText(this.iZone.convertUTCToLocal(j), locale);
        }

        public String getAsText(long j, Locale locale) {
            return this.iField.getAsText(this.iZone.convertUTCToLocal(j), locale);
        }

        public final DurationField getDurationField() {
            return this.iDurationField;
        }

        public final DurationField getLeapDurationField() {
            return this.iLeapDurationField;
        }

        public int getMaximumTextLength(Locale locale) {
            return this.iField.getMaximumTextLength(locale);
        }

        public int getMaximumValue() {
            return this.iField.getMaximumValue();
        }

        public int getMinimumValue() {
            return this.iField.getMinimumValue();
        }

        public final int getOffsetToAdd(long j) {
            int offset = this.iZone.getOffset(j);
            long j2 = (long) offset;
            if (((j + j2) ^ j) >= 0 || (j ^ j2) < 0) {
                return offset;
            }
            throw new ArithmeticException("Adding time zone offset caused overflow");
        }

        public final DurationField getRangeDurationField() {
            return this.iRangeDurationField;
        }

        public int hashCode() {
            return this.iField.hashCode() ^ this.iZone.hashCode();
        }

        public boolean isLeap(long j) {
            return this.iField.isLeap(this.iZone.convertUTCToLocal(j));
        }

        public boolean isLenient() {
            return this.iField.isLenient();
        }

        public long remainder(long j) {
            return this.iField.remainder(this.iZone.convertUTCToLocal(j));
        }

        public long roundCeiling(long j) {
            if (this.iTimeField) {
                long offsetToAdd = (long) getOffsetToAdd(j);
                return this.iField.roundCeiling(j + offsetToAdd) - offsetToAdd;
            }
            return this.iZone.convertLocalToUTC(this.iField.roundCeiling(this.iZone.convertUTCToLocal(j)), false, j);
        }

        public long roundFloor(long j) {
            if (this.iTimeField) {
                long offsetToAdd = (long) getOffsetToAdd(j);
                return this.iField.roundFloor(j + offsetToAdd) - offsetToAdd;
            }
            return this.iZone.convertLocalToUTC(this.iField.roundFloor(this.iZone.convertUTCToLocal(j)), false, j);
        }

        public long set(long j, int i) {
            long j2 = this.iField.set(this.iZone.convertUTCToLocal(j), i);
            long convertLocalToUTC = this.iZone.convertLocalToUTC(j2, false, j);
            if (get(convertLocalToUTC) == i) {
                return convertLocalToUTC;
            }
            IllegalInstantException illegalInstantException = new IllegalInstantException(j2, this.iZone.iID);
            IllegalFieldValueException illegalFieldValueException = new IllegalFieldValueException(this.iField.getType(), Integer.valueOf(i), illegalInstantException.getMessage());
            illegalFieldValueException.initCause(illegalInstantException);
            throw illegalFieldValueException;
        }

        public int getMaximumValue(long j) {
            return this.iField.getMaximumValue(this.iZone.convertUTCToLocal(j));
        }

        public String getAsShortText(int i, Locale locale) {
            return this.iField.getAsShortText(i, locale);
        }

        public String getAsText(int i, Locale locale) {
            return this.iField.getAsText(i, locale);
        }

        public long set(long j, String str, Locale locale) {
            return this.iZone.convertLocalToUTC(this.iField.set(this.iZone.convertUTCToLocal(j), str, locale), false, j);
        }
    }

    public static class ZonedDurationField extends BaseDurationField {
        public static final long serialVersionUID = -485345310999208286L;
        public final DurationField iField;
        public final boolean iTimeField;
        public final DateTimeZone iZone;

        public ZonedDurationField(DurationField durationField, DateTimeZone dateTimeZone) {
            super(durationField.getType());
            if (durationField.isSupported()) {
                this.iField = durationField;
                this.iTimeField = durationField.getUnitMillis() < 43200000;
                this.iZone = dateTimeZone;
                return;
            }
            throw new IllegalArgumentException();
        }

        public long add(long j, int i) {
            int offsetToAdd = getOffsetToAdd(j);
            long add = this.iField.add(j + ((long) offsetToAdd), i);
            if (!this.iTimeField) {
                offsetToAdd = getOffsetFromLocalToSubtract(add);
            }
            return add - ((long) offsetToAdd);
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ZonedDurationField)) {
                return false;
            }
            ZonedDurationField zonedDurationField = (ZonedDurationField) obj;
            if (!this.iField.equals(zonedDurationField.iField) || !this.iZone.equals(zonedDurationField.iZone)) {
                z = false;
            }
            return z;
        }

        public final int getOffsetFromLocalToSubtract(long j) {
            int offsetFromLocal = this.iZone.getOffsetFromLocal(j);
            long j2 = (long) offsetFromLocal;
            if (((j - j2) ^ j) >= 0 || (j ^ j2) >= 0) {
                return offsetFromLocal;
            }
            throw new ArithmeticException("Subtracting time zone offset caused overflow");
        }

        public final int getOffsetToAdd(long j) {
            int offset = this.iZone.getOffset(j);
            long j2 = (long) offset;
            if (((j + j2) ^ j) >= 0 || (j ^ j2) < 0) {
                return offset;
            }
            throw new ArithmeticException("Adding time zone offset caused overflow");
        }

        public long getUnitMillis() {
            return this.iField.getUnitMillis();
        }

        public int hashCode() {
            return this.iField.hashCode() ^ this.iZone.hashCode();
        }

        public boolean isPrecise() {
            if (this.iTimeField) {
                return this.iField.isPrecise();
            }
            return this.iField.isPrecise() && this.iZone.isFixed();
        }

        public long add(long j, long j2) {
            int offsetToAdd = getOffsetToAdd(j);
            long add = this.iField.add(j + ((long) offsetToAdd), j2);
            if (!this.iTimeField) {
                offsetToAdd = getOffsetFromLocalToSubtract(add);
            }
            return add - ((long) offsetToAdd);
        }
    }

    public ZonedChronology(Chronology chronology, DateTimeZone dateTimeZone) {
        super(chronology, dateTimeZone);
    }

    public static ZonedChronology getInstance(Chronology chronology, DateTimeZone dateTimeZone) {
        if (chronology != null) {
            Chronology withUTC = chronology.withUTC();
            if (withUTC == null) {
                throw new IllegalArgumentException("UTC chronology must not be null");
            } else if (dateTimeZone != null) {
                return new ZonedChronology(withUTC, dateTimeZone);
            } else {
                throw new IllegalArgumentException("DateTimeZone must not be null");
            }
        } else {
            throw new IllegalArgumentException("Must supply a chronology");
        }
    }

    public void assemble(Fields fields) {
        HashMap hashMap = new HashMap();
        fields.eras = convertField(fields.eras, hashMap);
        fields.centuries = convertField(fields.centuries, hashMap);
        fields.years = convertField(fields.years, hashMap);
        fields.months = convertField(fields.months, hashMap);
        fields.weekyears = convertField(fields.weekyears, hashMap);
        fields.weeks = convertField(fields.weeks, hashMap);
        fields.days = convertField(fields.days, hashMap);
        fields.halfdays = convertField(fields.halfdays, hashMap);
        fields.hours = convertField(fields.hours, hashMap);
        fields.minutes = convertField(fields.minutes, hashMap);
        fields.seconds = convertField(fields.seconds, hashMap);
        fields.millis = convertField(fields.millis, hashMap);
        fields.year = convertField(fields.year, hashMap);
        fields.yearOfEra = convertField(fields.yearOfEra, hashMap);
        fields.yearOfCentury = convertField(fields.yearOfCentury, hashMap);
        fields.centuryOfEra = convertField(fields.centuryOfEra, hashMap);
        fields.era = convertField(fields.era, hashMap);
        fields.dayOfWeek = convertField(fields.dayOfWeek, hashMap);
        fields.dayOfMonth = convertField(fields.dayOfMonth, hashMap);
        fields.dayOfYear = convertField(fields.dayOfYear, hashMap);
        fields.monthOfYear = convertField(fields.monthOfYear, hashMap);
        fields.weekOfWeekyear = convertField(fields.weekOfWeekyear, hashMap);
        fields.weekyear = convertField(fields.weekyear, hashMap);
        fields.weekyearOfCentury = convertField(fields.weekyearOfCentury, hashMap);
        fields.millisOfSecond = convertField(fields.millisOfSecond, hashMap);
        fields.millisOfDay = convertField(fields.millisOfDay, hashMap);
        fields.secondOfMinute = convertField(fields.secondOfMinute, hashMap);
        fields.secondOfDay = convertField(fields.secondOfDay, hashMap);
        fields.minuteOfHour = convertField(fields.minuteOfHour, hashMap);
        fields.minuteOfDay = convertField(fields.minuteOfDay, hashMap);
        fields.hourOfDay = convertField(fields.hourOfDay, hashMap);
        fields.hourOfHalfday = convertField(fields.hourOfHalfday, hashMap);
        fields.clockhourOfDay = convertField(fields.clockhourOfDay, hashMap);
        fields.clockhourOfHalfday = convertField(fields.clockhourOfHalfday, hashMap);
        fields.halfdayOfDay = convertField(fields.halfdayOfDay, hashMap);
    }

    public final DurationField convertField(DurationField durationField, HashMap<Object, Object> hashMap) {
        if (durationField == null || !durationField.isSupported()) {
            return durationField;
        }
        if (hashMap.containsKey(durationField)) {
            return (DurationField) hashMap.get(durationField);
        }
        ZonedDurationField zonedDurationField = new ZonedDurationField(durationField, (DateTimeZone) this.iParam);
        hashMap.put(durationField, zonedDurationField);
        return zonedDurationField;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZonedChronology)) {
            return false;
        }
        ZonedChronology zonedChronology = (ZonedChronology) obj;
        if (!this.iBase.equals(zonedChronology.iBase) || !((DateTimeZone) this.iParam).equals((DateTimeZone) zonedChronology.iParam)) {
            z = false;
        }
        return z;
    }

    public DateTimeZone getZone() {
        return (DateTimeZone) this.iParam;
    }

    public int hashCode() {
        return (this.iBase.hashCode() * 7) + (((DateTimeZone) this.iParam).hashCode() * 11) + 326565;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ZonedChronology[");
        outline73.append(this.iBase);
        outline73.append(", ");
        return GeneratedOutlineSupport.outline59(outline73, ((DateTimeZone) this.iParam).iID, ']');
    }

    public Chronology withUTC() {
        return this.iBase;
    }

    public Chronology withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        if (dateTimeZone == this.iParam) {
            return this;
        }
        if (dateTimeZone == DateTimeZone.UTC) {
            return this.iBase;
        }
        return new ZonedChronology(this.iBase, dateTimeZone);
    }

    public final DateTimeField convertField(DateTimeField dateTimeField, HashMap<Object, Object> hashMap) {
        if (dateTimeField == null || !dateTimeField.isSupported()) {
            return dateTimeField;
        }
        if (hashMap.containsKey(dateTimeField)) {
            return (DateTimeField) hashMap.get(dateTimeField);
        }
        ZonedDateTimeField zonedDateTimeField = new ZonedDateTimeField(dateTimeField, (DateTimeZone) this.iParam, convertField(dateTimeField.getDurationField(), hashMap), convertField(dateTimeField.getRangeDurationField(), hashMap), convertField(dateTimeField.getLeapDurationField(), hashMap));
        hashMap.put(dateTimeField, zonedDateTimeField);
        return zonedDateTimeField;
    }
}
