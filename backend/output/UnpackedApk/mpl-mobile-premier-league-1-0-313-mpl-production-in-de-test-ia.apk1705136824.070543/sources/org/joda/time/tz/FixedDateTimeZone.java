package org.joda.time.tz;

import org.joda.time.DateTimeZone;

public final class FixedDateTimeZone extends DateTimeZone {
    public static final long serialVersionUID = -3513011772763289092L;
    public final String iNameKey;
    public final int iStandardOffset;
    public final int iWallOffset;

    public FixedDateTimeZone(String str, String str2, int i, int i2) {
        super(str);
        this.iNameKey = str2;
        this.iWallOffset = i;
        this.iStandardOffset = i2;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FixedDateTimeZone)) {
            return false;
        }
        FixedDateTimeZone fixedDateTimeZone = (FixedDateTimeZone) obj;
        if (!(this.iID.equals(fixedDateTimeZone.iID) && this.iStandardOffset == fixedDateTimeZone.iStandardOffset && this.iWallOffset == fixedDateTimeZone.iWallOffset)) {
            z = false;
        }
        return z;
    }

    public String getNameKey(long j) {
        return this.iNameKey;
    }

    public int getOffset(long j) {
        return this.iWallOffset;
    }

    public int getOffsetFromLocal(long j) {
        return this.iWallOffset;
    }

    public int getStandardOffset(long j) {
        return this.iStandardOffset;
    }

    public int hashCode() {
        return (this.iWallOffset * 31) + (this.iStandardOffset * 37) + this.iID.hashCode();
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
