package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

public final class TransportRuntime_Factory implements Object<TransportRuntime> {
    public final Provider<Clock> eventClockProvider;
    public final Provider<WorkInitializer> initializerProvider;
    public final Provider<Scheduler> schedulerProvider;
    public final Provider<Uploader> uploaderProvider;
    public final Provider<Clock> uptimeClockProvider;

    public TransportRuntime_Factory(Provider<Clock> provider, Provider<Clock> provider2, Provider<Scheduler> provider3, Provider<Uploader> provider4, Provider<WorkInitializer> provider5) {
        this.eventClockProvider = provider;
        this.uptimeClockProvider = provider2;
        this.schedulerProvider = provider3;
        this.uploaderProvider = provider4;
        this.initializerProvider = provider5;
    }

    public Object get() {
        TransportRuntime transportRuntime = new TransportRuntime((Clock) this.eventClockProvider.get(), (Clock) this.uptimeClockProvider.get(), (Scheduler) this.schedulerProvider.get(), (Uploader) this.uploaderProvider.get(), (WorkInitializer) this.initializerProvider.get());
        return transportRuntime;
    }
}
