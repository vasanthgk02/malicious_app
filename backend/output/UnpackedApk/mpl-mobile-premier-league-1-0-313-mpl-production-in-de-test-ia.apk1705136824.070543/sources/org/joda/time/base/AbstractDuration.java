package org.joda.time.base;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.joda.convert.ToString;
import org.joda.time.ReadableDuration;
import org.joda.time.format.FormatUtils;

public abstract class AbstractDuration implements ReadableDuration {
    public int compareTo(Object obj) {
        int i = (getMillis() > ((ReadableDuration) obj).getMillis() ? 1 : (getMillis() == ((ReadableDuration) obj).getMillis() ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReadableDuration)) {
            return false;
        }
        if (getMillis() != ((ReadableDuration) obj).getMillis()) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        long millis = getMillis();
        return (int) (millis ^ (millis >>> 32));
    }

    @ToString
    public String toString() {
        long millis = getMillis();
        StringBuffer outline71 = GeneratedOutlineSupport.outline71("PT");
        boolean z = millis < 0;
        FormatUtils.appendUnpaddedInteger(outline71, millis);
        while (true) {
            int i = 3;
            if (outline71.length() >= (z ? 7 : 6)) {
                break;
            }
            if (!z) {
                i = 2;
            }
            outline71.insert(i, "0");
        }
        if ((millis / 1000) * 1000 == millis) {
            outline71.setLength(outline71.length() - 3);
        } else {
            outline71.insert(outline71.length() - 3, ".");
        }
        outline71.append('S');
        return outline71.toString();
    }
}
