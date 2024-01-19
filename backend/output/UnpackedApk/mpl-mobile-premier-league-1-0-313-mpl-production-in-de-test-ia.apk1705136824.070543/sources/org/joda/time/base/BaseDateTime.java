package org.joda.time.base;

import java.io.Serializable;
import org.joda.time.Chronology;
import org.joda.time.DateTimeUtils;
import org.joda.time.ReadableInstant;
import org.joda.time.chrono.ISOChronology;

public abstract class BaseDateTime extends AbstractDateTime implements ReadableInstant, Serializable {
    public static final long serialVersionUID = -6728882245981L;
    public volatile Chronology iChronology;
    public volatile long iMillis;

    public BaseDateTime() {
        this(DateTimeUtils.currentTimeMillis(), ISOChronology.getInstance());
    }

    public long checkInstant(long j) {
        return j;
    }

    public Chronology getChronology() {
        return this.iChronology;
    }

    public long getMillis() {
        return this.iMillis;
    }

    public BaseDateTime(long j, Chronology chronology) {
        this.iChronology = DateTimeUtils.getChronology(chronology);
        this.iMillis = checkInstant(j);
        if (this.iMillis == Long.MIN_VALUE || this.iMillis == Long.MAX_VALUE) {
            this.iChronology = this.iChronology.withUTC();
        }
    }
}
