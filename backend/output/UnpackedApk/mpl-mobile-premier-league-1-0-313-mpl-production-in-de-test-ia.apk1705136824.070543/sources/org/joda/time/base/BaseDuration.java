package org.joda.time.base;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.joda.time.DateTimeUtils;
import org.joda.time.ReadableDuration;
import org.joda.time.ReadableInstant;

public abstract class BaseDuration extends AbstractDuration implements ReadableDuration, Serializable {
    public static final long serialVersionUID = 2581698638990L;
    public volatile long iMillis;

    public BaseDuration(ReadableInstant readableInstant, ReadableInstant readableInstant2) {
        if (readableInstant == readableInstant2) {
            this.iMillis = 0;
            return;
        }
        long instantMillis = DateTimeUtils.getInstantMillis(readableInstant);
        long instantMillis2 = DateTimeUtils.getInstantMillis(readableInstant2);
        long j = instantMillis2 - instantMillis;
        if ((instantMillis2 ^ j) >= 0 || (instantMillis2 ^ instantMillis) >= 0) {
            this.iMillis = j;
            return;
        }
        StringBuilder outline76 = GeneratedOutlineSupport.outline76("The calculation caused an overflow: ", instantMillis2, " - ");
        outline76.append(instantMillis);
        throw new ArithmeticException(outline76.toString());
    }

    public long getMillis() {
        return this.iMillis;
    }
}
