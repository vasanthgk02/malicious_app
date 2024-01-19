package org.joda.time.base;

import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.joda.convert.ToString;
import org.joda.time.DateTimeUtils;
import org.joda.time.ReadableInstant;
import org.joda.time.format.ISODateTimeFormat$Constants;

public abstract class AbstractInstant implements ReadableInstant {
    public int compareTo(Object obj) {
        ReadableInstant readableInstant = (ReadableInstant) obj;
        if (this == readableInstant) {
            return 0;
        }
        int i = (getMillis() > readableInstant.getMillis() ? 1 : (getMillis() == readableInstant.getMillis() ? 0 : -1));
        if (i == 0) {
            return 0;
        }
        return i < 0 ? -1 : 1;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReadableInstant)) {
            return false;
        }
        ReadableInstant readableInstant = (ReadableInstant) obj;
        if (getMillis() != readableInstant.getMillis() || !TypeUtilsKt.equals(getChronology(), readableInstant.getChronology())) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return getChronology().hashCode() + ((int) (getMillis() ^ (getMillis() >>> 32)));
    }

    public boolean isBeforeNow() {
        return getMillis() < DateTimeUtils.currentTimeMillis();
    }

    @ToString
    public String toString() {
        return ISODateTimeFormat$Constants.dt.print(this);
    }
}
