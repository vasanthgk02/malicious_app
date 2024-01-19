package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection;
import java.util.concurrent.Executor;

public class WorkInitializer {
    public final Executor executor;
    public final SynchronizationGuard guard;
    public final WorkScheduler scheduler;
    public final EventStore store;

    public WorkInitializer(Executor executor2, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        this.executor = executor2;
        this.store = eventStore;
        this.scheduler = workScheduler;
        this.guard = synchronizationGuard;
    }

    public /* synthetic */ Object lambda$ensureContextsScheduled$0$WorkInitializer() {
        for (TransportContext schedule : this.store.loadActiveContexts()) {
            this.scheduler.schedule(schedule, 1);
        }
        return null;
    }

    public /* synthetic */ void lambda$ensureContextsScheduled$1$WorkInitializer() {
        this.guard.runCriticalSection(new CriticalSection() {
            public final Object execute() {
                WorkInitializer.this.lambda$ensureContextsScheduled$0$WorkInitializer();
                return null;
            }
        });
    }
}
