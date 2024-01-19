package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Map;

public final class AutoValue_SchedulerConfig extends SchedulerConfig {
    public final Clock clock;
    public final Map<Priority, ConfigValue> values;

    public AutoValue_SchedulerConfig(Clock clock2, Map<Priority, ConfigValue> map) {
        if (clock2 != null) {
            this.clock = clock2;
            if (map != null) {
                this.values = map;
                return;
            }
            throw new NullPointerException("Null values");
        }
        throw new NullPointerException("Null clock");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig)) {
            return false;
        }
        AutoValue_SchedulerConfig autoValue_SchedulerConfig = (AutoValue_SchedulerConfig) ((SchedulerConfig) obj);
        if (!this.clock.equals(autoValue_SchedulerConfig.clock) || !this.values.equals(autoValue_SchedulerConfig.values)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((this.clock.hashCode() ^ 1000003) * 1000003) ^ this.values.hashCode();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("SchedulerConfig{clock=");
        outline73.append(this.clock);
        outline73.append(", values=");
        outline73.append(this.values);
        outline73.append("}");
        return outline73.toString();
    }
}
