package org.joda.time;

import java.io.Serializable;
import org.joda.time.base.BaseDuration;

public final class Duration extends BaseDuration implements ReadableDuration, Serializable {
    public static final long serialVersionUID = 2471658376918L;

    public Duration(ReadableInstant readableInstant, ReadableInstant readableInstant2) {
        super(readableInstant, readableInstant2);
    }
}
