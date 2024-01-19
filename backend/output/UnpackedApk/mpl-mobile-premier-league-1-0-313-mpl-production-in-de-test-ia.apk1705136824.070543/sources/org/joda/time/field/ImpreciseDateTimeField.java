package org.joda.time.field;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeFieldType.StandardDateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public abstract class ImpreciseDateTimeField extends BaseDateTimeField {
    public final DurationField iDurationField;
    public final long iUnitMillis;

    public final class LinkedDurationField extends BaseDurationField {
        public static final long serialVersionUID = -203813474600094134L;

        public LinkedDurationField(DurationFieldType durationFieldType) {
            super(durationFieldType);
        }

        public long add(long j, int i) {
            return ImpreciseDateTimeField.this.add(j, i);
        }

        public long getUnitMillis() {
            return ImpreciseDateTimeField.this.iUnitMillis;
        }

        public boolean isPrecise() {
            return false;
        }

        public long add(long j, long j2) {
            return ImpreciseDateTimeField.this.add(j, j2);
        }
    }

    public ImpreciseDateTimeField(DateTimeFieldType dateTimeFieldType, long j) {
        super(dateTimeFieldType);
        this.iUnitMillis = j;
        this.iDurationField = new LinkedDurationField(((StandardDateTimeFieldType) dateTimeFieldType).iUnitType);
    }

    public abstract long add(long j, long j2);

    public final DurationField getDurationField() {
        return this.iDurationField;
    }
}
