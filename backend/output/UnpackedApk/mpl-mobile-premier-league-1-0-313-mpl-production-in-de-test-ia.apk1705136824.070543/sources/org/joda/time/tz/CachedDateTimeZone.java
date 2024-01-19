package org.joda.time.tz;

import androidx.recyclerview.widget.LinearLayoutManager;
import org.joda.time.DateTimeZone;

public class CachedDateTimeZone extends DateTimeZone {
    public static final int cInfoCacheMask;
    public static final long serialVersionUID = 5472298452022250685L;
    public final transient Info[] iInfoCache = new Info[(cInfoCacheMask + 1)];
    public final DateTimeZone iZone;

    public static final class Info {
        public String iNameKey;
        public Info iNextInfo;
        public int iOffset = LinearLayoutManager.INVALID_OFFSET;
        public final long iPeriodStart;
        public int iStandardOffset = LinearLayoutManager.INVALID_OFFSET;
        public final DateTimeZone iZoneRef;

        public Info(DateTimeZone dateTimeZone, long j) {
            this.iPeriodStart = j;
            this.iZoneRef = dateTimeZone;
        }

        public String getNameKey(long j) {
            Info info = this.iNextInfo;
            if (info != null && j >= info.iPeriodStart) {
                return info.getNameKey(j);
            }
            if (this.iNameKey == null) {
                this.iNameKey = this.iZoneRef.getNameKey(this.iPeriodStart);
            }
            return this.iNameKey;
        }

        public int getOffset(long j) {
            Info info = this.iNextInfo;
            if (info != null && j >= info.iPeriodStart) {
                return info.getOffset(j);
            }
            if (this.iOffset == Integer.MIN_VALUE) {
                this.iOffset = this.iZoneRef.getOffset(this.iPeriodStart);
            }
            return this.iOffset;
        }

        public int getStandardOffset(long j) {
            Info info = this.iNextInfo;
            if (info != null && j >= info.iPeriodStart) {
                return info.getStandardOffset(j);
            }
            if (this.iStandardOffset == Integer.MIN_VALUE) {
                this.iStandardOffset = this.iZoneRef.getStandardOffset(this.iPeriodStart);
            }
            return this.iStandardOffset;
        }
    }

    static {
        Integer num;
        int i;
        try {
            num = Integer.getInteger("org.joda.time.tz.CachedDateTimeZone.size");
        } catch (SecurityException unused) {
            num = null;
        }
        if (num == null) {
            i = 512;
        } else {
            int i2 = 0;
            for (int intValue = num.intValue() - 1; intValue > 0; intValue >>= 1) {
                i2++;
            }
            i = 1 << i2;
        }
        cInfoCacheMask = i - 1;
    }

    public CachedDateTimeZone(DateTimeZone dateTimeZone) {
        super(dateTimeZone.iID);
        this.iZone = dateTimeZone;
    }

    public static CachedDateTimeZone forZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone instanceof CachedDateTimeZone) {
            return (CachedDateTimeZone) dateTimeZone;
        }
        return new CachedDateTimeZone(dateTimeZone);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CachedDateTimeZone) {
            return this.iZone.equals(((CachedDateTimeZone) obj).iZone);
        }
        return false;
    }

    public final Info getInfo(long j) {
        int i = (int) (j >> 32);
        Info[] infoArr = this.iInfoCache;
        int i2 = cInfoCacheMask & i;
        Info info = infoArr[i2];
        if (info == null || ((int) (info.iPeriodStart >> 32)) != i) {
            long j2 = j & -4294967296L;
            info = new Info(this.iZone, j2);
            long j3 = 4294967295L | j2;
            Info info2 = info;
            while (true) {
                long nextTransition = this.iZone.nextTransition(j2);
                if (nextTransition == j2 || nextTransition > j3) {
                    infoArr[i2] = info;
                } else {
                    Info info3 = new Info(this.iZone, nextTransition);
                    info2.iNextInfo = info3;
                    info2 = info3;
                    j2 = nextTransition;
                }
            }
            infoArr[i2] = info;
        }
        return info;
    }

    public String getNameKey(long j) {
        return getInfo(j).getNameKey(j);
    }

    public int getOffset(long j) {
        return getInfo(j).getOffset(j);
    }

    public int getStandardOffset(long j) {
        return getInfo(j).getStandardOffset(j);
    }

    public int hashCode() {
        return this.iZone.hashCode();
    }

    public boolean isFixed() {
        return this.iZone.isFixed();
    }

    public long nextTransition(long j) {
        return this.iZone.nextTransition(j);
    }

    public long previousTransition(long j) {
        return this.iZone.previousTransition(j);
    }
}
