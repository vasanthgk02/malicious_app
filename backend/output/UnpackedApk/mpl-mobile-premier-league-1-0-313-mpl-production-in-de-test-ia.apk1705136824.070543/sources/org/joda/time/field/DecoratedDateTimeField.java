package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public abstract class DecoratedDateTimeField extends BaseDateTimeField {
    public final DateTimeField iField;

    public DecoratedDateTimeField(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType) {
        super(dateTimeFieldType);
        if (dateTimeField == null) {
            throw new IllegalArgumentException("The field must not be null");
        } else if (dateTimeField.isSupported()) {
            this.iField = dateTimeField;
        } else {
            throw new IllegalArgumentException("The field must be supported");
        }
    }

    public int get(long j) {
        return this.iField.get(j);
    }

    public DurationField getDurationField() {
        return this.iField.getDurationField();
    }

    public DurationField getRangeDurationField() {
        return this.iField.getRangeDurationField();
    }

    public boolean isLenient() {
        return this.iField.isLenient();
    }

    public long set(long j, int i) {
        return this.iField.set(j, i);
    }
}
