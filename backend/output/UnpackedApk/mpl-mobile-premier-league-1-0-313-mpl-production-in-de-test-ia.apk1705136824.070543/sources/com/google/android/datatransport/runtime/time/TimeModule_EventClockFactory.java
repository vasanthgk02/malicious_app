package com.google.android.datatransport.runtime.time;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;

public final class TimeModule_EventClockFactory implements Object<Clock> {

    public static final class InstanceHolder {
        public static final TimeModule_EventClockFactory INSTANCE = new TimeModule_EventClockFactory();
    }

    public Object get() {
        WallTimeClock wallTimeClock = new WallTimeClock();
        ImageOriginUtils.checkNotNull(wallTimeClock, "Cannot return null from a non-@Nullable @Provides method");
        return wallTimeClock;
    }
}
