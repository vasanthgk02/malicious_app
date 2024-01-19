package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import java.util.Collections;
import java.util.Set;

public abstract class SchedulerConfig {

    public static abstract class ConfigValue {

        public static abstract class Builder {
            public abstract ConfigValue build();

            public abstract Builder setDelta(long j);

            public abstract Builder setMaxAllowedDelay(long j);
        }

        public static Builder builder() {
            com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue.Builder builder = new com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue.Builder();
            Set<Flag> emptySet = Collections.emptySet();
            if (emptySet != null) {
                builder.flags = emptySet;
                return builder;
            }
            throw new NullPointerException("Null flags");
        }
    }

    public enum Flag {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    public long getScheduleDelay(Priority priority, long j, int i) {
        AutoValue_SchedulerConfig autoValue_SchedulerConfig = (AutoValue_SchedulerConfig) this;
        long time = j - autoValue_SchedulerConfig.clock.getTime();
        AutoValue_SchedulerConfig_ConfigValue autoValue_SchedulerConfig_ConfigValue = (AutoValue_SchedulerConfig_ConfigValue) autoValue_SchedulerConfig.values.get(priority);
        long j2 = autoValue_SchedulerConfig_ConfigValue.delta;
        int i2 = i - 1;
        return Math.min(Math.max((long) (Math.pow(3.0d, (double) i2) * ((double) j2) * Math.max(1.0d, Math.log(10000.0d) / Math.log((double) ((j2 > 1 ? j2 : 2) * ((long) i2))))), time), autoValue_SchedulerConfig_ConfigValue.maxAllowedDelay);
    }
}
