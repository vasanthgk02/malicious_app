package com.google.android.datatransport.runtime.scheduling;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public class DefaultScheduler implements Scheduler {
    public static final Logger LOGGER = Logger.getLogger(TransportRuntime.class.getName());
    public final BackendRegistry backendRegistry;
    public final EventStore eventStore;
    public final Executor executor;
    public final SynchronizationGuard guard;
    public final WorkScheduler workScheduler;

    public DefaultScheduler(Executor executor2, BackendRegistry backendRegistry2, WorkScheduler workScheduler2, EventStore eventStore2, SynchronizationGuard synchronizationGuard) {
        this.executor = executor2;
        this.backendRegistry = backendRegistry2;
        this.workScheduler = workScheduler2;
        this.eventStore = eventStore2;
        this.guard = synchronizationGuard;
    }

    public /* synthetic */ Object lambda$schedule$0$DefaultScheduler(TransportContext transportContext, EventInternal eventInternal) {
        this.eventStore.persist(transportContext, eventInternal);
        this.workScheduler.schedule(transportContext, 1);
        return null;
    }

    public /* synthetic */ void lambda$schedule$1$DefaultScheduler(TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        try {
            TransportBackend transportBackend = this.backendRegistry.get(transportContext.getBackendName());
            if (transportBackend == null) {
                String format = String.format("Transport backend '%s' is not registered", new Object[]{transportContext.getBackendName()});
                LOGGER.warning(format);
                transportScheduleCallback.onSchedule(new IllegalArgumentException(format));
                return;
            }
            this.guard.runCriticalSection(new CriticalSection(transportContext, transportBackend.decorate(eventInternal)) {
                public final /* synthetic */ TransportContext f$1;
                public final /* synthetic */ EventInternal f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final Object execute() {
                    DefaultScheduler.this.lambda$schedule$0$DefaultScheduler(this.f$1, this.f$2);
                    return null;
                }
            });
            transportScheduleCallback.onSchedule(null);
        } catch (Exception e2) {
            Logger logger = LOGGER;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error scheduling event ");
            outline73.append(e2.getMessage());
            logger.warning(outline73.toString());
            transportScheduleCallback.onSchedule(e2);
        }
    }

    public void schedule(TransportContext transportContext, EventInternal eventInternal, TransportScheduleCallback transportScheduleCallback) {
        this.executor.execute(new Runnable(transportContext, transportScheduleCallback, eventInternal) {
            public final /* synthetic */ TransportContext f$1;
            public final /* synthetic */ TransportScheduleCallback f$2;
            public final /* synthetic */ EventInternal f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                DefaultScheduler.this.lambda$schedule$1$DefaultScheduler(this.f$1, this.f$2, this.f$3);
            }
        });
    }
}
