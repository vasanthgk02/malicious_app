package org.joda.time;

import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.chrono.ISOChronology;

public class DateTimeUtils {
    public static final MillisProvider SYSTEM_MILLIS_PROVIDER;
    public static volatile MillisProvider cMillisProvider;
    public static final AtomicReference<Map<String, DateTimeZone>> cZoneNames = new AtomicReference<>();

    public interface MillisProvider {
    }

    public static class SystemMillisProvider implements MillisProvider {
    }

    static {
        SystemMillisProvider systemMillisProvider = new SystemMillisProvider();
        SYSTEM_MILLIS_PROVIDER = systemMillisProvider;
        cMillisProvider = systemMillisProvider;
    }

    public static final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static final Chronology getChronology(Chronology chronology) {
        return chronology == null ? ISOChronology.getInstance() : chronology;
    }

    public static final DateFormatSymbols getDateFormatSymbols(Locale locale) {
        try {
            return (DateFormatSymbols) DateFormatSymbols.class.getMethod("getInstance", new Class[]{Locale.class}).invoke(null, new Object[]{locale});
        } catch (Exception unused) {
            return new DateFormatSymbols(locale);
        }
    }

    public static final long getInstantMillis(ReadableInstant readableInstant) {
        if (readableInstant == null) {
            return System.currentTimeMillis();
        }
        return readableInstant.getMillis();
    }

    public static void put(Map<String, DateTimeZone> map, String str, String str2) {
        try {
            map.put(str, DateTimeZone.forID(str2));
        } catch (RuntimeException unused) {
        }
    }
}
