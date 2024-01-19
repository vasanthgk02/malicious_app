package com.google.android.datatransport.runtime.scheduling;

import android.content.Context;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

public final class SchedulingModule_WorkSchedulerFactory implements Object<WorkScheduler> {
    public final Provider<Clock> clockProvider;
    public final Provider<SchedulerConfig> configProvider;
    public final Provider<Context> contextProvider;
    public final Provider<EventStore> eventStoreProvider;

    public SchedulingModule_WorkSchedulerFactory(Provider<Context> provider, Provider<EventStore> provider2, Provider<SchedulerConfig> provider3, Provider<Clock> provider4) {
        this.contextProvider = provider;
        this.eventStoreProvider = provider2;
        this.configProvider = provider3;
        this.clockProvider = provider4;
    }

    public Object get() {
        Clock clock = (Clock) this.clockProvider.get();
        JobInfoScheduler jobInfoScheduler = new JobInfoScheduler((Context) this.contextProvider.get(), (EventStore) this.eventStoreProvider.get(), (SchedulerConfig) this.configProvider.get());
        ImageOriginUtils.checkNotNull(jobInfoScheduler, "Cannot return null from a non-@Nullable @Provides method");
        return jobInfoScheduler;
    }
}
