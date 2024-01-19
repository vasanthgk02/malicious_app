package org.joda.time;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.joda.time.format.DateTimeFormat;

public class IllegalInstantException extends IllegalArgumentException {
    public static final long serialVersionUID = 2858712538216L;

    public IllegalInstantException(String str) {
        super(str);
    }

    public IllegalInstantException(long j, String str) {
        super(GeneratedOutlineSupport.outline52("Illegal instant due to time zone offset transition (daylight savings time 'gap'): ", DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS").print(new Instant(j)), str != null ? GeneratedOutlineSupport.outline52(" (", str, ")") : ""));
    }
}
