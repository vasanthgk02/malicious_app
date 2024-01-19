package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.Flag;
import java.util.Set;

public final class AutoValue_SchedulerConfig_ConfigValue extends ConfigValue {
    public final long delta;
    public final Set<Flag> flags;
    public final long maxAllowedDelay;

    public static final class Builder extends com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder {
        public Long delta;
        public Set<Flag> flags;
        public Long maxAllowedDelay;

        public ConfigValue build() {
            String str = this.delta == null ? " delta" : "";
            if (this.maxAllowedDelay == null) {
                str = GeneratedOutlineSupport.outline50(str, " maxAllowedDelay");
            }
            if (this.flags == null) {
                str = GeneratedOutlineSupport.outline50(str, " flags");
            }
            if (str.isEmpty()) {
                AutoValue_SchedulerConfig_ConfigValue autoValue_SchedulerConfig_ConfigValue = new AutoValue_SchedulerConfig_ConfigValue(this.delta.longValue(), this.maxAllowedDelay.longValue(), this.flags, null);
                return autoValue_SchedulerConfig_ConfigValue;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder setDelta(long j) {
            this.delta = Long.valueOf(j);
            return this;
        }

        public com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder setMaxAllowedDelay(long j) {
            this.maxAllowedDelay = Long.valueOf(j);
            return this;
        }
    }

    public AutoValue_SchedulerConfig_ConfigValue(long j, long j2, Set set, AnonymousClass1 r6) {
        this.delta = j;
        this.maxAllowedDelay = j2;
        this.flags = set;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConfigValue)) {
            return false;
        }
        AutoValue_SchedulerConfig_ConfigValue autoValue_SchedulerConfig_ConfigValue = (AutoValue_SchedulerConfig_ConfigValue) ((ConfigValue) obj);
        if (!(this.delta == autoValue_SchedulerConfig_ConfigValue.delta && this.maxAllowedDelay == autoValue_SchedulerConfig_ConfigValue.maxAllowedDelay && this.flags.equals(autoValue_SchedulerConfig_ConfigValue.flags))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        long j = this.delta;
        long j2 = this.maxAllowedDelay;
        return this.flags.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ConfigValue{delta=");
        outline73.append(this.delta);
        outline73.append(", maxAllowedDelay=");
        outline73.append(this.maxAllowedDelay);
        outline73.append(", flags=");
        outline73.append(this.flags);
        outline73.append("}");
        return outline73.toString();
    }
}
