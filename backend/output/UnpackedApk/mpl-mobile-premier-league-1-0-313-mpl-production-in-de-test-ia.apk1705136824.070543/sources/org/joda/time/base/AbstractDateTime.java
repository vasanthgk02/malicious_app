package org.joda.time.base;

import org.joda.convert.ToString;
import org.joda.time.ReadableInstant;

public abstract class AbstractDateTime extends AbstractInstant implements ReadableInstant {
    public int getYear() {
        return getChronology().year().get(getMillis());
    }

    @ToString
    public String toString() {
        return super.toString();
    }
}
