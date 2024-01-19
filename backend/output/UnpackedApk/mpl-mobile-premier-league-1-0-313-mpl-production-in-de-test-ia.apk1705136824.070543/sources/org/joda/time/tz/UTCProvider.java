package org.joda.time.tz;

import java.util.Collections;
import java.util.Set;
import org.joda.time.DateTimeZone;

public final class UTCProvider implements Provider {
    public static final Set<String> AVAILABLE_IDS = Collections.singleton("UTC");

    public Set<String> getAvailableIDs() {
        return AVAILABLE_IDS;
    }

    public DateTimeZone getZone(String str) {
        if ("UTC".equalsIgnoreCase(str)) {
            return DateTimeZone.UTC;
        }
        return null;
    }
}
