package org.joda.time.chrono;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.AssembledChronology.Fields;

public final class GregorianChronology extends BasicGJChronology {
    public static final GregorianChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC, 4);
    public static final ConcurrentHashMap<DateTimeZone, GregorianChronology[]> cCache = new ConcurrentHashMap<>();
    public static final long serialVersionUID = -861407383323710522L;

    public GregorianChronology(Chronology chronology, Object obj, int i) {
        super(chronology, null, i);
    }

    public static GregorianChronology getInstance(DateTimeZone dateTimeZone) {
        return getInstance(dateTimeZone, 4);
    }

    private Object readResolve() {
        Chronology chronology = this.iBase;
        int i = this.iMinDaysInFirstWeek;
        if (i == 0) {
            i = 4;
        }
        if (chronology == null) {
            return getInstance(DateTimeZone.UTC, i);
        }
        return getInstance(chronology.getZone(), i);
    }

    public void assemble(Fields fields) {
        if (this.iBase == null) {
            super.assemble(fields);
        }
    }

    public boolean isLeapYear(int i) {
        return (i & 3) == 0 && (i % 100 != 0 || i % 400 == 0);
    }

    public Chronology withUTC() {
        return INSTANCE_UTC;
    }

    public Chronology withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        if (dateTimeZone == getZone()) {
            return this;
        }
        return getInstance(dateTimeZone);
    }

    public static GregorianChronology getInstance(DateTimeZone dateTimeZone, int i) {
        GregorianChronology gregorianChronology;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        GregorianChronology[] gregorianChronologyArr = cCache.get(dateTimeZone);
        if (gregorianChronologyArr == null) {
            gregorianChronologyArr = new GregorianChronology[7];
            GregorianChronology[] putIfAbsent = cCache.putIfAbsent(dateTimeZone, gregorianChronologyArr);
            if (putIfAbsent != null) {
                gregorianChronologyArr = putIfAbsent;
            }
        }
        int i2 = i - 1;
        try {
            GregorianChronology gregorianChronology2 = gregorianChronologyArr[i2];
            if (gregorianChronology2 == null) {
                synchronized (gregorianChronologyArr) {
                    gregorianChronology2 = gregorianChronologyArr[i2];
                    if (gregorianChronology2 == null) {
                        if (dateTimeZone == DateTimeZone.UTC) {
                            gregorianChronology = new GregorianChronology(null, null, i);
                        } else {
                            gregorianChronology = new GregorianChronology(ZonedChronology.getInstance(getInstance(DateTimeZone.UTC, i), dateTimeZone), null, i);
                        }
                        gregorianChronologyArr[i2] = gregorianChronology;
                        gregorianChronology2 = gregorianChronology;
                    }
                }
            }
            return gregorianChronology2;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("Invalid min days in first week: ", i));
        }
    }
}
