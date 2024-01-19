package com.google.android.datatransport.runtime.time;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;

public final class TimeModule_UptimeClockFactory implements Object<Clock> {

    public static final class InstanceHolder {
        public static final TimeModule_UptimeClockFactory INSTANCE = new TimeModule_UptimeClockFactory();
    }

    public Object get() {
        UptimeClock uptimeClock = new UptimeClock();
        ImageOriginUtils.checkNotNull(uptimeClock, "Cannot return null from a non-@Nullable @Provides method");
        return uptimeClock;
    }
}
