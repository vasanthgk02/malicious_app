package org.joda.time;

public final class UTCDateTimeZone extends DateTimeZone {
    public static final DateTimeZone INSTANCE = new UTCDateTimeZone();
    public static final long serialVersionUID = -3513011772763289092L;

    public UTCDateTimeZone() {
        super("UTC");
    }

    public boolean equals(Object obj) {
        return obj instanceof UTCDateTimeZone;
    }

    public String getNameKey(long j) {
        return "UTC";
    }

    public int getOffset(long j) {
        return 0;
    }

    public int getOffsetFromLocal(long j) {
        return 0;
    }

    public int getStandardOffset(long j) {
        return 0;
    }

    public int hashCode() {
        return this.iID.hashCode();
    }

    public boolean isFixed() {
        return true;
    }

    public long nextTransition(long j) {
        return j;
    }

    public long previousTransition(long j) {
        return j;
    }
}
