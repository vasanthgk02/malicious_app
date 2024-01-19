package org.joda.time.field;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Locale;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.IllegalFieldValueException;

public abstract class BaseDateTimeField extends DateTimeField {
    public final DateTimeFieldType iType;

    public BaseDateTimeField(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            this.iType = dateTimeFieldType;
            return;
        }
        throw new IllegalArgumentException("The type must not be null");
    }

    public long add(long j, int i) {
        return getDurationField().add(j, i);
    }

    public int convertText(String str, Locale locale) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new IllegalFieldValueException(this.iType, str);
        }
    }

    public String getAsShortText(long j, Locale locale) {
        return getAsShortText(get(j), locale);
    }

    public String getAsText(long j, Locale locale) {
        return getAsText(get(j), locale);
    }

    public DurationField getLeapDurationField() {
        return null;
    }

    public int getMaximumTextLength(Locale locale) {
        int maximumValue = getMaximumValue();
        if (maximumValue >= 0) {
            if (maximumValue < 10) {
                return 1;
            }
            if (maximumValue < 100) {
                return 2;
            }
            if (maximumValue < 1000) {
                return 3;
            }
        }
        return Integer.toString(maximumValue).length();
    }

    public int getMaximumValue(long j) {
        return getMaximumValue();
    }

    public final String getName() {
        return this.iType.iName;
    }

    public final DateTimeFieldType getType() {
        return this.iType;
    }

    public boolean isLeap(long j) {
        return false;
    }

    public final boolean isSupported() {
        return true;
    }

    public long remainder(long j) {
        return j - roundFloor(j);
    }

    public long roundCeiling(long j) {
        long roundFloor = roundFloor(j);
        return roundFloor != j ? add(roundFloor, 1) : j;
    }

    public long roundHalfCeiling(long j) {
        long roundFloor = roundFloor(j);
        long roundCeiling = roundCeiling(j);
        return roundCeiling - j <= j - roundFloor ? roundCeiling : roundFloor;
    }

    public long roundHalfEven(long j) {
        long roundFloor = roundFloor(j);
        long roundCeiling = roundCeiling(j);
        long j2 = j - roundFloor;
        long j3 = roundCeiling - j;
        if (j2 < j3) {
            return roundFloor;
        }
        return (j3 >= j2 && (get(roundCeiling) & 1) != 0) ? roundFloor : roundCeiling;
    }

    public long roundHalfFloor(long j) {
        long roundFloor = roundFloor(j);
        long roundCeiling = roundCeiling(j);
        return j - roundFloor <= roundCeiling - j ? roundFloor : roundCeiling;
    }

    public long set(long j, String str, Locale locale) {
        return set(j, convertText(str, locale));
    }

    public String toString() {
        return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline73("DateTimeField["), this.iType.iName, ']');
    }

    public String getAsShortText(int i, Locale locale) {
        return getAsText(i, locale);
    }

    public String getAsText(int i, Locale locale) {
        return Integer.toString(i);
    }
}
