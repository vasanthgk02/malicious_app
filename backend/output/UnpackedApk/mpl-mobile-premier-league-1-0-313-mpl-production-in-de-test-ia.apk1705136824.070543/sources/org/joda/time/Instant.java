package org.joda.time;

import java.io.Serializable;
import org.joda.time.base.AbstractInstant;
import org.joda.time.chrono.ISOChronology;

public final class Instant extends AbstractInstant implements ReadableInstant, Serializable {
    public static final long serialVersionUID = 3299096530934209741L;
    public final long iMillis;

    public Instant() {
        this.iMillis = DateTimeUtils.currentTimeMillis();
    }

    public Chronology getChronology() {
        return ISOChronology.INSTANCE_UTC;
    }

    public long getMillis() {
        return this.iMillis;
    }

    public Instant(long j) {
        this.iMillis = j;
    }
}
