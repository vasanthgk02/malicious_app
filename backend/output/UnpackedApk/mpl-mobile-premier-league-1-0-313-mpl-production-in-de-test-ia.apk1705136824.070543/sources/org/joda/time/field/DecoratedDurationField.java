package org.joda.time.field;

import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public class DecoratedDurationField extends BaseDurationField {
    public static final long serialVersionUID = 8019982251647420015L;
    public final DurationField iField;

    public DecoratedDurationField(DurationField durationField, DurationFieldType durationFieldType) {
        super(durationFieldType);
        if (durationField == null) {
            throw new IllegalArgumentException("The field must not be null");
        } else if (durationField.isSupported()) {
            this.iField = durationField;
        } else {
            throw new IllegalArgumentException("The field must be supported");
        }
    }

    public long add(long j, int i) {
        return this.iField.add(j, i);
    }

    public long getUnitMillis() {
        return this.iField.getUnitMillis();
    }

    public boolean isPrecise() {
        return this.iField.isPrecise();
    }

    public long add(long j, long j2) {
        return this.iField.add(j, j2);
    }
}
