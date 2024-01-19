package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Provider;

public final class DefaultScheduler_Factory implements Object<DefaultScheduler> {
    public final Provider<BackendRegistry> backendRegistryProvider;
    public final Provider<EventStore> eventStoreProvider;
    public final Provider<Executor> executorProvider;
    public final Provider<SynchronizationGuard> guardProvider;
    public final Provider<WorkScheduler> workSchedulerProvider;

    public DefaultScheduler_Factory(Provider<Executor> provider, Provider<BackendRegistry> provider2, Provider<WorkScheduler> provider3, Provider<EventStore> provider4, Provider<SynchronizationGuard> provider5) {
        this.executorProvider = provider;
        this.backendRegistryProvider = provider2;
        this.workSchedulerProvider = provider3;
        this.eventStoreProvider = provider4;
        this.guardProvider = provider5;
    }

    public Object get() {
        DefaultScheduler defaultScheduler = new DefaultScheduler((Executor) this.executorProvider.get(), (BackendRegistry) this.backendRegistryProvider.get(), (WorkScheduler) this.workSchedulerProvider.get(), (EventStore) this.eventStoreProvider.get(), (SynchronizationGuard) this.guardProvider.get());
        return defaultScheduler;
    }
}
