package org.joda.time;

public interface ReadableInstant extends Comparable<ReadableInstant> {
    Chronology getChronology();

    long getMillis();
}
