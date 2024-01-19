package org.joda.time.field;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public final class UnsupportedDateTimeField extends DateTimeField implements Serializable {
    public static HashMap<DateTimeFieldType, UnsupportedDateTimeField> cCache = null;
    public static final long serialVersionUID = -1934618396111902255L;
    public final DurationField iDurationField;
    public final DateTimeFieldType iType;

    public UnsupportedDateTimeField(DateTimeFieldType dateTimeFieldType, DurationField durationField) {
        if (dateTimeFieldType == null || durationField == null) {
            throw new IllegalArgumentException();
        }
        this.iType = dateTimeFieldType;
        this.iDurationField = durationField;
    }

    public static synchronized UnsupportedDateTimeField getInstance(DateTimeFieldType dateTimeFieldType, DurationField durationField) {
        UnsupportedDateTimeField unsupportedDateTimeField;
        synchronized (UnsupportedDateTimeField.class) {
            try {
                unsupportedDateTimeField = null;
                if (cCache == null) {
                    cCache = new HashMap<>(7);
                } else {
                    UnsupportedDateTimeField unsupportedDateTimeField2 = cCache.get(dateTimeFieldType);
                    if (unsupportedDateTimeField2 == null || unsupportedDateTimeField2.iDurationField == durationField) {
                        unsupportedDateTimeField = unsupportedDateTimeField2;
                    }
                }
                if (unsupportedDateTimeField == null) {
                    unsupportedDateTimeField = new UnsupportedDateTimeField(dateTimeFieldType, durationField);
                    cCache.put(dateTimeFieldType, unsupportedDateTimeField);
                }
            }
        }
        return unsupportedDateTimeField;
    }

    private Object readResolve() {
        return getInstance(this.iType, this.iDurationField);
    }

    public long add(long j, int i) {
        return this.iDurationField.add(j, i);
    }

    public int get(long j) {
        throw unsupported();
    }

    public String getAsShortText(long j, Locale locale) {
        throw unsupported();
    }

    public String getAsText(long j, Locale locale) {
        throw unsupported();
    }

    public DurationField getDurationField() {
        return this.iDurationField;
    }

    public DurationField getLeapDurationField() {
        return null;
    }

    public int getMaximumTextLength(Locale locale) {
        throw unsupported();
    }

    public int getMaximumValue() {
        throw unsupported();
    }

    public int getMinimumValue() {
        throw unsupported();
    }

    public String getName() {
        return this.iType.iName;
    }

    public DurationField getRangeDurationField() {
        return null;
    }

    public DateTimeFieldType getType() {
        return this.iType;
    }

    public boolean isLeap(long j) {
        throw unsupported();
    }

    public boolean isLenient() {
        return false;
    }

    public boolean isSupported() {
        return false;
    }

    public long remainder(long j) {
        throw unsupported();
    }

    public long roundCeiling(long j) {
        throw unsupported();
    }

    public long roundFloor(long j) {
        throw unsupported();
    }

    public long roundHalfCeiling(long j) {
        throw unsupported();
    }

    public long roundHalfEven(long j) {
        throw unsupported();
    }

    public long roundHalfFloor(long j) {
        throw unsupported();
    }

    public long set(long j, int i) {
        throw unsupported();
    }

    public String toString() {
        return "UnsupportedDateTimeField";
    }

    public final UnsupportedOperationException unsupported() {
        return new UnsupportedOperationException(this.iType + " field is unsupported");
    }

    public String getAsShortText(int i, Locale locale) {
        throw unsupported();
    }

    public String getAsText(int i, Locale locale) {
        throw unsupported();
    }

    public int getMaximumValue(long j) {
        throw unsupported();
    }

    public long set(long j, String str, Locale locale) {
        throw unsupported();
    }
}
